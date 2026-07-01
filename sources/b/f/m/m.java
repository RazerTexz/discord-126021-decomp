package b.f.m;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode$ThreadPolicy;
import android.util.Log;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.facebook.soloader.SysUtil$LollipopSysdeps;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: UnpackingSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m extends c {
    public final Context c;
    public String d;
    public final Map<String, Object> e;

    public m(Context context, String str) {
        super(new File(b.d.b.a.a.K(new StringBuilder(), context.getApplicationInfo().dataDir, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, str)), 1);
        this.e = new HashMap();
        this.c = context;
    }

    public static void l(File file, byte b2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            randomAccessFile.seek(0L);
            randomAccessFile.write(b2);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @Override // b.f.m.c, b.f.m.l
    public int a(String str, int i, StrictMode$ThreadPolicy strictMode$ThreadPolicy) throws IOException {
        int iC;
        synchronized (h(str)) {
            iC = c(str, i, this.a, strictMode$ThreadPolicy);
        }
        return iC;
    }

    @Override // b.f.m.l
    public void b(int i) throws IOException {
        File file = this.a;
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("cannot mkdir: " + file);
        }
        g gVar = new g(new File(this.a, "dso_lock"));
        try {
            Log.v("fb-UnpackingSoSource", "locked dso store " + this.a);
            if (j(gVar, i, g())) {
                gVar = null;
            } else {
                Log.i("fb-UnpackingSoSource", "dso store is up-to-date: " + this.a);
            }
            if (gVar != null) {
                StringBuilder sbU = b.d.b.a.a.U("releasing dso store lock for ");
                sbU.append(this.a);
                Log.v("fb-UnpackingSoSource", sbU.toString());
                gVar.close();
                return;
            }
            StringBuilder sbU2 = b.d.b.a.a.U("not releasing dso store lock for ");
            sbU2.append(this.a);
            sbU2.append(" (syncer thread started)");
            Log.v("fb-UnpackingSoSource", sbU2.toString());
        } catch (Throwable th) {
            StringBuilder sbU3 = b.d.b.a.a.U("releasing dso store lock for ");
            sbU3.append(this.a);
            Log.v("fb-UnpackingSoSource", sbU3.toString());
            gVar.close();
            throw th;
        }
    }

    public final void d(m$b[] m_bArr) throws IOException {
        String[] list = this.a.list();
        if (list == null) {
            StringBuilder sbU = b.d.b.a.a.U("unable to list directory ");
            sbU.append(this.a);
            throw new IOException(sbU.toString());
        }
        for (String str : list) {
            if (!str.equals("dso_state") && !str.equals("dso_lock") && !str.equals("dso_deps") && !str.equals("dso_manifest")) {
                boolean z2 = false;
                for (int i = 0; !z2 && i < m_bArr.length; i++) {
                    if (m_bArr[i].j.equals(str)) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    File file = new File(this.a, str);
                    Log.v("fb-UnpackingSoSource", "deleting unaccounted-for file " + file);
                    b.c.a.a0.d.b0(file);
                }
            }
        }
    }

    public final void e(m$d m_d, byte[] bArr) throws IOException {
        StringBuilder sbU = b.d.b.a.a.U("extracting DSO ");
        sbU.append(m_d.j.j);
        Log.i("fb-UnpackingSoSource", sbU.toString());
        try {
            if (!this.a.setWritable(true)) {
                throw new IOException("cannot make directory writable for us: " + this.a);
            }
            f(m_d, bArr);
            if (this.a.setWritable(false)) {
                return;
            }
            StringBuilder sbU2 = b.d.b.a.a.U("error removing ");
            sbU2.append(this.a.getCanonicalPath());
            sbU2.append(" write permission");
            Log.w("fb-UnpackingSoSource", sbU2.toString());
        } catch (Throwable th) {
            if (!this.a.setWritable(false)) {
                StringBuilder sbU3 = b.d.b.a.a.U("error removing ");
                sbU3.append(this.a.getCanonicalPath());
                sbU3.append(" write permission");
                Log.w("fb-UnpackingSoSource", sbU3.toString());
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00db  */
    /* JADX WARN: Code duplicated, block: B:38:0x00f2  */
    /* JADX WARN: Instruction removed from duplicated block: B:36:0x00db, please report this as an issue */
    public final void f(m$d m_d, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        File file = new File(this.a, m_d.j.j);
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                if (file.exists() && !file.setWritable(true)) {
                    Log.w("fb-UnpackingSoSource", "error adding write permission to: " + file);
                }
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (IOException e) {
                    Log.w("fb-UnpackingSoSource", "error overwriting " + file + " trying to delete and start over", e);
                    b.c.a.a0.d.b0(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                }
                randomAccessFile2 = randomAccessFile;
                int iAvailable = m_d.k.available();
                if (iAvailable > 1) {
                    SysUtil$LollipopSysdeps.fallocateIfSupported(randomAccessFile2.getFD(), iAvailable);
                }
                InputStream inputStream = m_d.k;
                int i = 0;
                while (i < Integer.MAX_VALUE) {
                    int i2 = inputStream.read(bArr, 0, Math.min(bArr.length, Integer.MAX_VALUE - i));
                    if (i2 == -1) {
                        break;
                    }
                    randomAccessFile2.write(bArr, 0, i2);
                    i += i2;
                }
                randomAccessFile2.setLength(randomAccessFile2.getFilePointer());
                if (!file.setExecutable(true, false)) {
                    throw new IOException("cannot make file executable: " + file);
                }
                if (!file.setWritable(false)) {
                    Log.w("fb-UnpackingSoSource", "error removing " + file + " write permission");
                }
                randomAccessFile2.close();
                return;
            } catch (IOException e2) {
                b.c.a.a0.d.b0(file);
                throw e2;
            }
        } catch (Throwable th) {
            if (!file.setWritable(false)) {
                Log.w("fb-UnpackingSoSource", "error removing " + file + " write permission");
            }
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
        if (!file.setWritable(false)) {
            Log.w("fb-UnpackingSoSource", "error removing " + file + " write permission");
        }
        if (randomAccessFile2 != null) {
            randomAccessFile2.close();
        }
        throw th;
    }

    public byte[] g() throws IOException {
        Parcel parcelObtain = Parcel.obtain();
        m$f m_fI = i();
        try {
            m$b[] m_bArr = m_fI.a().a;
            parcelObtain.writeByte((byte) 1);
            parcelObtain.writeInt(m_bArr.length);
            for (int i = 0; i < m_bArr.length; i++) {
                parcelObtain.writeString(m_bArr[i].j);
                parcelObtain.writeString(m_bArr[i].k);
            }
            m_fI.close();
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            return bArrMarshall;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (m_fI != null) {
                    try {
                        m_fI.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public final Object h(String str) {
        Object obj;
        synchronized (this.e) {
            obj = this.e.get(str);
            if (obj == null) {
                obj = new Object();
                this.e.put(str, obj);
            }
        }
        return obj;
    }

    public abstract m$f i() throws IOException;

    public final boolean j(g gVar, int i, byte[] bArr) throws IOException {
        byte b2;
        File file = new File(this.a, "dso_state");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            b2 = randomAccessFile.readByte();
            if (b2 != 1) {
                Log.v("fb-UnpackingSoSource", "dso store " + this.a + " regeneration interrupted: wiping clean");
                b2 = 0;
            }
        } catch (EOFException unused) {
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
        randomAccessFile.close();
        File file2 = new File(this.a, "dso_deps");
        m$c m_cA = null;
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
        try {
            int length = (int) randomAccessFile2.length();
            byte[] bArr2 = new byte[length];
            if (randomAccessFile2.read(bArr2) != length) {
                Log.v("fb-UnpackingSoSource", "short read of so store deps file: marking unclean");
                b2 = 0;
            }
            if (!Arrays.equals(bArr2, bArr)) {
                Log.v("fb-UnpackingSoSource", "deps mismatch on deps store: regenerating");
                b2 = 0;
            }
            if (b2 == 0 || (i & 2) != 0) {
                Log.v("fb-UnpackingSoSource", "so store dirty: regenerating");
                l(file, (byte) 0);
                m$f m_fI = i();
                try {
                    m_cA = m_fI.a();
                    try {
                        k(b2, m_cA, m_fI.b());
                        m_fI.close();
                    } catch (Throwable th4) {
                        throw th4;
                    }
                } catch (Throwable th5) {
                    try {
                        throw th5;
                    } catch (Throwable th6) {
                        if (m_fI != null) {
                            try {
                                m_fI.close();
                            } catch (Throwable th7) {
                                th5.addSuppressed(th7);
                            }
                        }
                        throw th6;
                    }
                }
            }
            m$c m_c = m_cA;
            randomAccessFile2.close();
            if (m_c == null) {
                return false;
            }
            m$a m_a = new m$a(this, file2, bArr, m_c, file, gVar);
            if ((i & 1) != 0) {
                StringBuilder sbU = b.d.b.a.a.U("SoSync:");
                sbU.append(this.a.getName());
                new Thread(m_a, sbU.toString()).start();
            } else {
                m_a.run();
            }
            return true;
        } catch (Throwable th8) {
            try {
                throw th8;
            } catch (Throwable th9) {
                try {
                    randomAccessFile2.close();
                } catch (Throwable th10) {
                    th8.addSuppressed(th10);
                }
                throw th9;
            }
        }
    }

    public final void k(byte b2, m$c m_c, m$e m_e) throws IOException {
        m$c m_cA;
        StringBuilder sbU = b.d.b.a.a.U("regenerating DSO store ");
        sbU.append(getClass().getName());
        Log.v("fb-UnpackingSoSource", sbU.toString());
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.a, "dso_manifest"), "rw");
        try {
            if (b2 == 1) {
                try {
                    m_cA = m$c.a(randomAccessFile);
                } catch (Exception e) {
                    Log.i("fb-UnpackingSoSource", "error reading existing DSO manifest", e);
                    m_cA = null;
                }
            } else {
                m_cA = null;
            }
            if (m_cA == null) {
                m_cA = new m$c(new m$b[0]);
            }
            d(m_c.a);
            byte[] bArr = new byte[32768];
            while (m_e.a()) {
                m$d m_dB = m_e.b();
                boolean z2 = true;
                int i = 0;
                while (z2) {
                    try {
                        m$b[] m_bArr = m_cA.a;
                        if (i >= m_bArr.length) {
                            break;
                        }
                        if (m_bArr[i].j.equals(m_dB.j.j) && m_cA.a[i].k.equals(m_dB.j.k)) {
                            z2 = false;
                        }
                        i++;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (m_dB != null) {
                                try {
                                    m_dB.k.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                }
                if (z2) {
                    e(m_dB, bArr);
                }
                if (m_dB != null) {
                    m_dB.k.close();
                }
            }
            randomAccessFile.close();
            Log.v("fb-UnpackingSoSource", "Finished regenerating DSO store " + getClass().getName());
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th6) {
                    th4.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }
}
