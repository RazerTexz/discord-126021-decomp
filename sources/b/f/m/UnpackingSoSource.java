package b.f.m;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import android.util.Log;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
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

/* JADX INFO: renamed from: b.f.m.m, reason: use source file name */
/* JADX INFO: compiled from: UnpackingSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class UnpackingSoSource extends DirectorySoSource {
    public final Context c;
    public String d;
    public final Map<String, Object> e;

    /* JADX INFO: renamed from: b.f.m.m$a */
    /* JADX INFO: compiled from: UnpackingSoSource.java */
    public class a implements Runnable {
        public final /* synthetic */ File j;
        public final /* synthetic */ byte[] k;
        public final /* synthetic */ c l;
        public final /* synthetic */ File m;
        public final /* synthetic */ FileLocker n;

        public a(File file, byte[] bArr, c cVar, File file2, FileLocker fileLocker) {
            this.j = file;
            this.k = bArr;
            this.l = cVar;
            this.m = file2;
            this.n = fileLocker;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    Log.v("fb-UnpackingSoSource", "starting syncer worker");
                    RandomAccessFile randomAccessFile = new RandomAccessFile(this.j, "rw");
                    try {
                        randomAccessFile.write(this.k);
                        randomAccessFile.setLength(randomAccessFile.getFilePointer());
                        randomAccessFile.close();
                        RandomAccessFile randomAccessFile2 = new RandomAccessFile(new File(UnpackingSoSource.this.a, "dso_manifest"), "rw");
                        try {
                            c cVar = this.l;
                            Objects.requireNonNull(cVar);
                            randomAccessFile2.writeByte(1);
                            randomAccessFile2.writeInt(cVar.a.length);
                            int i = 0;
                            while (true) {
                                b[] bVarArr = cVar.a;
                                if (i >= bVarArr.length) {
                                    randomAccessFile2.close();
                                    AnimatableValueParser.m0(UnpackingSoSource.this.a);
                                    UnpackingSoSource.l(this.m, (byte) 1);
                                    Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + UnpackingSoSource.this.a + " (from syncer thread)");
                                    this.n.close();
                                    return;
                                }
                                randomAccessFile2.writeUTF(bVarArr[i].j);
                                randomAccessFile2.writeUTF(cVar.a[i].k);
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
                    Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + UnpackingSoSource.this.a + " (from syncer thread)");
                    this.n.close();
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
        public final String j;
        public final String k;

        public b(String str, String str2) {
            this.j = str;
            this.k = str2;
        }
    }

    /* JADX INFO: renamed from: b.f.m.m$c */
    /* JADX INFO: compiled from: UnpackingSoSource.java */
    public static final class c {
        public final b[] a;

        public c(b[] bVarArr) {
            this.a = bVarArr;
        }

        public static final c a(DataInput dataInput) throws IOException {
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
        public final b j;
        public final InputStream k;

        public d(b bVar, InputStream inputStream) {
            this.j = bVar;
            this.k = inputStream;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.k.close();
        }
    }

    /* JADX INFO: renamed from: b.f.m.m$e */
    /* JADX INFO: compiled from: UnpackingSoSource.java */
    public static abstract class e implements Closeable {
        public abstract boolean a();

        public abstract d b() throws IOException;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    /* JADX INFO: renamed from: b.f.m.m$f */
    /* JADX INFO: compiled from: UnpackingSoSource.java */
    public static abstract class f implements Closeable {
        public abstract c a() throws IOException;

        public abstract e b() throws IOException;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    public UnpackingSoSource(Context context, String str) {
        super(new File(outline.K(new StringBuilder(), context.getApplicationInfo().dataDir, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, str)), 1);
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

    @Override // b.f.m.DirectorySoSource, b.f.m.SoSource
    public int a(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        int iC;
        synchronized (h(str)) {
            iC = c(str, i, this.a, threadPolicy);
        }
        return iC;
    }

    @Override // b.f.m.SoSource
    public void b(int i) throws IOException {
        File file = this.a;
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("cannot mkdir: " + file);
        }
        FileLocker fileLocker = new FileLocker(new File(this.a, "dso_lock"));
        try {
            Log.v("fb-UnpackingSoSource", "locked dso store " + this.a);
            if (j(fileLocker, i, g())) {
                fileLocker = null;
            } else {
                Log.i("fb-UnpackingSoSource", "dso store is up-to-date: " + this.a);
            }
            if (fileLocker != null) {
                StringBuilder sbU = outline.U("releasing dso store lock for ");
                sbU.append(this.a);
                Log.v("fb-UnpackingSoSource", sbU.toString());
                fileLocker.close();
                return;
            }
            StringBuilder sbU2 = outline.U("not releasing dso store lock for ");
            sbU2.append(this.a);
            sbU2.append(" (syncer thread started)");
            Log.v("fb-UnpackingSoSource", sbU2.toString());
        } catch (Throwable th) {
            StringBuilder sbU3 = outline.U("releasing dso store lock for ");
            sbU3.append(this.a);
            Log.v("fb-UnpackingSoSource", sbU3.toString());
            fileLocker.close();
            throw th;
        }
    }

    public final void d(b[] bVarArr) throws IOException {
        String[] list = this.a.list();
        if (list == null) {
            StringBuilder sbU = outline.U("unable to list directory ");
            sbU.append(this.a);
            throw new IOException(sbU.toString());
        }
        for (String str : list) {
            if (!str.equals("dso_state") && !str.equals("dso_lock") && !str.equals("dso_deps") && !str.equals("dso_manifest")) {
                boolean z2 = false;
                for (int i = 0; !z2 && i < bVarArr.length; i++) {
                    if (bVarArr[i].j.equals(str)) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    File file = new File(this.a, str);
                    Log.v("fb-UnpackingSoSource", "deleting unaccounted-for file " + file);
                    AnimatableValueParser.b0(file);
                }
            }
        }
    }

    public final void e(d dVar, byte[] bArr) throws IOException {
        StringBuilder sbU = outline.U("extracting DSO ");
        sbU.append(dVar.j.j);
        Log.i("fb-UnpackingSoSource", sbU.toString());
        try {
            if (!this.a.setWritable(true)) {
                throw new IOException("cannot make directory writable for us: " + this.a);
            }
            f(dVar, bArr);
            if (this.a.setWritable(false)) {
                return;
            }
            StringBuilder sbU2 = outline.U("error removing ");
            sbU2.append(this.a.getCanonicalPath());
            sbU2.append(" write permission");
            Log.w("fb-UnpackingSoSource", sbU2.toString());
        } catch (Throwable th) {
            if (!this.a.setWritable(false)) {
                StringBuilder sbU3 = outline.U("error removing ");
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
    public final void f(d dVar, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        File file = new File(this.a, dVar.j.j);
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
                    AnimatableValueParser.b0(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                }
                randomAccessFile2 = randomAccessFile;
                int iAvailable = dVar.k.available();
                if (iAvailable > 1) {
                    SysUtil$LollipopSysdeps.fallocateIfSupported(randomAccessFile2.getFD(), iAvailable);
                }
                InputStream inputStream = dVar.k;
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
                AnimatableValueParser.b0(file);
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

    public byte[] g() throws IOException {
        Parcel parcelObtain = Parcel.obtain();
        f fVarI = i();
        try {
            b[] bVarArr = fVarI.a().a;
            parcelObtain.writeByte((byte) 1);
            parcelObtain.writeInt(bVarArr.length);
            for (int i = 0; i < bVarArr.length; i++) {
                parcelObtain.writeString(bVarArr[i].j);
                parcelObtain.writeString(bVarArr[i].k);
            }
            fVarI.close();
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            return bArrMarshall;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (fVarI != null) {
                    try {
                        fVarI.close();
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

    public abstract f i() throws IOException;

    public final boolean j(FileLocker fileLocker, int i, byte[] bArr) throws IOException {
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
        c cVarA = null;
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
                f fVarI = i();
                try {
                    cVarA = fVarI.a();
                    try {
                        k(b2, cVarA, fVarI.b());
                        fVarI.close();
                    } catch (Throwable th4) {
                        throw th4;
                    }
                } catch (Throwable th5) {
                    try {
                        throw th5;
                    } catch (Throwable th6) {
                        if (fVarI != null) {
                            try {
                                fVarI.close();
                            } catch (Throwable th7) {
                                th5.addSuppressed(th7);
                            }
                        }
                        throw th6;
                    }
                }
            }
            c cVar = cVarA;
            randomAccessFile2.close();
            if (cVar == null) {
                return false;
            }
            a aVar = new a(file2, bArr, cVar, file, fileLocker);
            if ((i & 1) != 0) {
                StringBuilder sbU = outline.U("SoSync:");
                sbU.append(this.a.getName());
                new Thread(aVar, sbU.toString()).start();
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

    public final void k(byte b2, c cVar, e eVar) throws IOException {
        c cVarA;
        StringBuilder sbU = outline.U("regenerating DSO store ");
        sbU.append(getClass().getName());
        Log.v("fb-UnpackingSoSource", sbU.toString());
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.a, "dso_manifest"), "rw");
        try {
            if (b2 == 1) {
                try {
                    cVarA = c.a(randomAccessFile);
                } catch (Exception e2) {
                    Log.i("fb-UnpackingSoSource", "error reading existing DSO manifest", e2);
                    cVarA = null;
                }
            } else {
                cVarA = null;
            }
            if (cVarA == null) {
                cVarA = new c(new b[0]);
            }
            d(cVar.a);
            byte[] bArr = new byte[32768];
            while (eVar.a()) {
                d dVarB = eVar.b();
                boolean z2 = true;
                int i = 0;
                while (z2) {
                    try {
                        b[] bVarArr = cVarA.a;
                        if (i >= bVarArr.length) {
                            break;
                        }
                        if (bVarArr[i].j.equals(dVarB.j.j) && cVarA.a[i].k.equals(dVarB.j.k)) {
                            z2 = false;
                        }
                        i++;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (dVarB != null) {
                                try {
                                    dVarB.k.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                }
                if (z2) {
                    e(dVarB, bArr);
                }
                if (dVarB != null) {
                    dVarB.k.close();
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
