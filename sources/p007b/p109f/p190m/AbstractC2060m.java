package p007b.p109f.p190m;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import android.util.Log;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.facebook.soloader.SysUtil$LollipopSysdeps;
import java.io.Closeable;
import java.io.DataInput;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.f.m.m */
/* JADX INFO: compiled from: UnpackingSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2060m extends C2050c {

    /* JADX INFO: renamed from: c */
    public final Context f4344c;

    /* JADX INFO: renamed from: d */
    public String f4345d;

    /* JADX INFO: renamed from: e */
    public final Map<String, Object> f4346e;

    /* JADX INFO: renamed from: b.f.m.m$a */
    /* JADX INFO: compiled from: UnpackingSoSource.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ File f4347j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ byte[] f4348k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ c f4349l;

        /* JADX INFO: renamed from: m */
        public final /* synthetic */ File f4350m;

        /* JADX INFO: renamed from: n */
        public final /* synthetic */ C2054g f4351n;

        public a(File file, byte[] bArr, c cVar, File file2, C2054g c2054g) {
            this.f4347j = file;
            this.f4348k = bArr;
            this.f4349l = cVar;
            this.f4350m = file2;
            this.f4351n = c2054g;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    Log.v("fb-UnpackingSoSource", "starting syncer worker");
                    RandomAccessFile randomAccessFile = new RandomAccessFile(this.f4347j, "rw");
                    try {
                        randomAccessFile.write(this.f4348k);
                        randomAccessFile.setLength(randomAccessFile.getFilePointer());
                        randomAccessFile.close();
                        RandomAccessFile randomAccessFile2 = new RandomAccessFile(new File(AbstractC2060m.this.f4319a, "dso_manifest"), "rw");
                        try {
                            c cVar = this.f4349l;
                            Objects.requireNonNull(cVar);
                            randomAccessFile2.writeByte(1);
                            randomAccessFile2.writeInt(cVar.f4355a.length);
                            int i = 0;
                            while (true) {
                                b[] bVarArr = cVar.f4355a;
                                if (i >= bVarArr.length) {
                                    randomAccessFile2.close();
                                    C1460d.m544m0(AbstractC2060m.this.f4319a);
                                    AbstractC2060m.m1579l(this.f4350m, (byte) 1);
                                    Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + AbstractC2060m.this.f4319a + " (from syncer thread)");
                                    this.f4351n.close();
                                    return;
                                }
                                randomAccessFile2.writeUTF(bVarArr[i].f4353j);
                                randomAccessFile2.writeUTF(cVar.f4355a[i].f4354k);
                                i++;
                                throw new RuntimeException(e);
                            }
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                try {
                                    randomAccessFile2.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                                throw th2;
                            }
                        }
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
                } catch (Throwable th7) {
                    Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + AbstractC2060m.this.f4319a + " (from syncer thread)");
                    this.f4351n.close();
                    throw th7;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: renamed from: b.f.m.m$b */
    /* JADX INFO: compiled from: UnpackingSoSource.java */
    public static class b {

        /* JADX INFO: renamed from: j */
        public final String f4353j;

        /* JADX INFO: renamed from: k */
        public final String f4354k;

        public b(String str, String str2) {
            this.f4353j = str;
            this.f4354k = str2;
        }
    }

    /* JADX INFO: renamed from: b.f.m.m$c */
    /* JADX INFO: compiled from: UnpackingSoSource.java */
    public static final class c {

        /* JADX INFO: renamed from: a */
        public final b[] f4355a;

        public c(b[] bVarArr) {
            this.f4355a = bVarArr;
        }

        /* JADX INFO: renamed from: a */
        public static final c m1586a(DataInput dataInput) throws IOException {
            if (dataInput.readByte() != 1) {
                throw new RuntimeException("wrong dso manifest version");
            }
            int i = dataInput.readInt();
            if (i < 0) {
                throw new RuntimeException("illegal number of shared libraries");
            }
            b[] bVarArr = new b[i];
            for (int i2 = 0; i2 < i; i2++) {
                bVarArr[i2] = new b(dataInput.readUTF(), dataInput.readUTF());
            }
            return new c(bVarArr);
        }
    }

    /* JADX INFO: renamed from: b.f.m.m$d */
    /* JADX INFO: compiled from: UnpackingSoSource.java */
    public static final class d implements Closeable {

        /* JADX INFO: renamed from: j */
        public final b f4356j;

        /* JADX INFO: renamed from: k */
        public final InputStream f4357k;

        public d(b bVar, InputStream inputStream) {
            this.f4356j = bVar;
            this.f4357k = inputStream;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f4357k.close();
        }
    }

    /* JADX INFO: renamed from: b.f.m.m$e */
    /* JADX INFO: compiled from: UnpackingSoSource.java */
    public static abstract class e implements Closeable {
        /* JADX INFO: renamed from: a */
        public abstract boolean mo1575a();

        /* JADX INFO: renamed from: b */
        public abstract d mo1576b() throws IOException;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    /* JADX INFO: renamed from: b.f.m.m$f */
    /* JADX INFO: compiled from: UnpackingSoSource.java */
    public static abstract class f implements Closeable {
        /* JADX INFO: renamed from: a */
        public abstract c mo1573a() throws IOException;

        /* JADX INFO: renamed from: b */
        public abstract e mo1574b() throws IOException;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    public AbstractC2060m(Context context, String str) {
        super(new File(C1643a.m823K(new StringBuilder(), context.getApplicationInfo().dataDir, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, str)), 1);
        this.f4346e = new HashMap();
        this.f4344c = context;
    }

    /* JADX INFO: renamed from: l */
    public static void m1579l(File file, byte b2) throws IOException {
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

    @Override // p007b.p109f.p190m.C2050c, p007b.p109f.p190m.AbstractC2059l
    /* JADX INFO: renamed from: a */
    public int mo1568a(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        int iM1572c;
        synchronized (m1583h(str)) {
            iM1572c = m1572c(str, i, this.f4319a, threadPolicy);
        }
        return iM1572c;
    }

    @Override // p007b.p109f.p190m.AbstractC2059l
    /* JADX INFO: renamed from: b */
    public void mo1569b(int i) throws IOException {
        File file = this.f4319a;
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("cannot mkdir: " + file);
        }
        C2054g c2054g = new C2054g(new File(this.f4319a, "dso_lock"));
        try {
            Log.v("fb-UnpackingSoSource", "locked dso store " + this.f4319a);
            if (m1584j(c2054g, i, mo1565g())) {
                c2054g = null;
            } else {
                Log.i("fb-UnpackingSoSource", "dso store is up-to-date: " + this.f4319a);
            }
            if (c2054g != null) {
                StringBuilder sbM833U = C1643a.m833U("releasing dso store lock for ");
                sbM833U.append(this.f4319a);
                Log.v("fb-UnpackingSoSource", sbM833U.toString());
                c2054g.close();
                return;
            }
            StringBuilder sbM833U2 = C1643a.m833U("not releasing dso store lock for ");
            sbM833U2.append(this.f4319a);
            sbM833U2.append(" (syncer thread started)");
            Log.v("fb-UnpackingSoSource", sbM833U2.toString());
        } catch (Throwable th) {
            StringBuilder sbM833U3 = C1643a.m833U("releasing dso store lock for ");
            sbM833U3.append(this.f4319a);
            Log.v("fb-UnpackingSoSource", sbM833U3.toString());
            c2054g.close();
            throw th;
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m1580d(b[] bVarArr) throws IOException {
        String[] list = this.f4319a.list();
        if (list == null) {
            StringBuilder sbM833U = C1643a.m833U("unable to list directory ");
            sbM833U.append(this.f4319a);
            throw new IOException(sbM833U.toString());
        }
        for (String str : list) {
            if (!str.equals("dso_state") && !str.equals("dso_lock") && !str.equals("dso_deps") && !str.equals("dso_manifest")) {
                boolean z2 = false;
                for (int i = 0; !z2 && i < bVarArr.length; i++) {
                    if (bVarArr[i].f4353j.equals(str)) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    File file = new File(this.f4319a, str);
                    Log.v("fb-UnpackingSoSource", "deleting unaccounted-for file " + file);
                    C1460d.m500b0(file);
                }
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m1581e(d dVar, byte[] bArr) throws IOException {
        StringBuilder sbM833U = C1643a.m833U("extracting DSO ");
        sbM833U.append(dVar.f4356j.f4353j);
        Log.i("fb-UnpackingSoSource", sbM833U.toString());
        try {
            if (!this.f4319a.setWritable(true)) {
                throw new IOException("cannot make directory writable for us: " + this.f4319a);
            }
            m1582f(dVar, bArr);
            if (this.f4319a.setWritable(false)) {
                return;
            }
            StringBuilder sbM833U2 = C1643a.m833U("error removing ");
            sbM833U2.append(this.f4319a.getCanonicalPath());
            sbM833U2.append(" write permission");
            Log.w("fb-UnpackingSoSource", sbM833U2.toString());
        } catch (Throwable th) {
            if (!this.f4319a.setWritable(false)) {
                StringBuilder sbM833U3 = C1643a.m833U("error removing ");
                sbM833U3.append(this.f4319a.getCanonicalPath());
                sbM833U3.append(" write permission");
                Log.w("fb-UnpackingSoSource", sbM833U3.toString());
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00db  */
    /* JADX WARN: Code duplicated, block: B:38:0x00f2  */
    /* JADX WARN: Instruction removed from duplicated block: B:36:0x00db, please report this as an issue */
    /* JADX INFO: renamed from: f */
    public final void m1582f(d dVar, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        File file = new File(this.f4319a, dVar.f4356j.f4353j);
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                if (file.exists() && !file.setWritable(true)) {
                    Log.w("fb-UnpackingSoSource", "error adding write permission to: " + file);
                }
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (IOException e2) {
                    Log.w("fb-UnpackingSoSource", "error overwriting " + file + " trying to delete and start over", e2);
                    C1460d.m500b0(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                }
                randomAccessFile2 = randomAccessFile;
                int iAvailable = dVar.f4357k.available();
                if (iAvailable > 1) {
                    SysUtil$LollipopSysdeps.fallocateIfSupported(randomAccessFile2.getFD(), iAvailable);
                }
                InputStream inputStream = dVar.f4357k;
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
            } catch (IOException e3) {
                C1460d.m500b0(file);
                throw e3;
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

    /* JADX INFO: renamed from: g */
    public byte[] mo1565g() throws IOException {
        Parcel parcelObtain = Parcel.obtain();
        f fVarMo1566i = mo1566i();
        try {
            b[] bVarArr = fVarMo1566i.mo1573a().f4355a;
            parcelObtain.writeByte((byte) 1);
            parcelObtain.writeInt(bVarArr.length);
            for (int i = 0; i < bVarArr.length; i++) {
                parcelObtain.writeString(bVarArr[i].f4353j);
                parcelObtain.writeString(bVarArr[i].f4354k);
            }
            fVarMo1566i.close();
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            return bArrMarshall;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (fVarMo1566i != null) {
                    try {
                        fVarMo1566i.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public final Object m1583h(String str) {
        Object obj;
        synchronized (this.f4346e) {
            obj = this.f4346e.get(str);
            if (obj == null) {
                obj = new Object();
                this.f4346e.put(str, obj);
            }
        }
        return obj;
    }

    /* JADX INFO: renamed from: i */
    public abstract f mo1566i() throws IOException;

    /* JADX INFO: renamed from: j */
    public final boolean m1584j(C2054g c2054g, int i, byte[] bArr) throws IOException {
        byte b2;
        File file = new File(this.f4319a, "dso_state");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            b2 = randomAccessFile.readByte();
            if (b2 != 1) {
                Log.v("fb-UnpackingSoSource", "dso store " + this.f4319a + " regeneration interrupted: wiping clean");
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
        File file2 = new File(this.f4319a, "dso_deps");
        c cVarMo1573a = null;
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
                m1579l(file, (byte) 0);
                f fVarMo1566i = mo1566i();
                try {
                    cVarMo1573a = fVarMo1566i.mo1573a();
                    try {
                        m1585k(b2, cVarMo1573a, fVarMo1566i.mo1574b());
                        fVarMo1566i.close();
                    } catch (Throwable th4) {
                        throw th4;
                    }
                } catch (Throwable th5) {
                    try {
                        throw th5;
                    } catch (Throwable th6) {
                        if (fVarMo1566i != null) {
                            try {
                                fVarMo1566i.close();
                            } catch (Throwable th7) {
                                th5.addSuppressed(th7);
                            }
                        }
                        throw th6;
                    }
                }
            }
            c cVar = cVarMo1573a;
            randomAccessFile2.close();
            if (cVar == null) {
                return false;
            }
            a aVar = new a(file2, bArr, cVar, file, c2054g);
            if ((i & 1) != 0) {
                StringBuilder sbM833U = C1643a.m833U("SoSync:");
                sbM833U.append(this.f4319a.getName());
                new Thread(aVar, sbM833U.toString()).start();
            } else {
                aVar.run();
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

    /* JADX INFO: renamed from: k */
    public final void m1585k(byte b2, c cVar, e eVar) throws IOException {
        c cVarM1586a;
        StringBuilder sbM833U = C1643a.m833U("regenerating DSO store ");
        sbM833U.append(getClass().getName());
        Log.v("fb-UnpackingSoSource", sbM833U.toString());
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f4319a, "dso_manifest"), "rw");
        try {
            if (b2 == 1) {
                try {
                    cVarM1586a = c.m1586a(randomAccessFile);
                } catch (Exception e2) {
                    Log.i("fb-UnpackingSoSource", "error reading existing DSO manifest", e2);
                    cVarM1586a = null;
                }
            } else {
                cVarM1586a = null;
            }
            if (cVarM1586a == null) {
                cVarM1586a = new c(new b[0]);
            }
            m1580d(cVar.f4355a);
            byte[] bArr = new byte[32768];
            while (eVar.mo1575a()) {
                d dVarMo1576b = eVar.mo1576b();
                boolean z2 = true;
                int i = 0;
                while (z2) {
                    try {
                        b[] bVarArr = cVarM1586a.f4355a;
                        if (i >= bVarArr.length) {
                            break;
                        }
                        if (bVarArr[i].f4353j.equals(dVarMo1576b.f4356j.f4353j) && cVarM1586a.f4355a[i].f4354k.equals(dVarMo1576b.f4356j.f4354k)) {
                            z2 = false;
                        }
                        i++;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (dVarMo1576b != null) {
                                try {
                                    dVarMo1576b.f4357k.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                }
                if (z2) {
                    m1581e(dVarMo1576b, bArr);
                }
                if (dVarMo1576b != null) {
                    dVarMo1576b.f4357k.close();
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
