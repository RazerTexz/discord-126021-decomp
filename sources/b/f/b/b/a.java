package b.f.b.b;

import android.os.Environment;
import androidx.annotation.VisibleForTesting;
import com.facebook.common.file.FileUtils$CreateDirectoryException;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DefaultDiskStorage.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements c {
    public static final long a = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f457b = 0;
    public final File c;
    public final boolean d;
    public final File e;
    public final b.f.b.a.a f;
    public final b.f.d.k.a g;

    /* JADX WARN: Code duplicated, block: B:15:0x005c  */
    /* JADX WARN: Code duplicated, block: B:17:0x0062  */
    /* JADX WARN: Code duplicated, block: B:18:0x0067  */
    /* JADX WARN: Code duplicated, block: B:29:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public a(File file, int i, b.f.b.a.a aVar) {
        boolean zContains;
        File file2;
        this.c = file;
        boolean z2 = false;
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                try {
                    zContains = file.getCanonicalPath().contains(externalStorageDirectory.toString());
                } catch (IOException unused) {
                    Objects.requireNonNull((b.f.b.a.d) aVar);
                    zContains = false;
                    this.d = zContains;
                    file2 = new File(this.c, String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i)));
                    this.e = file2;
                    this.f = aVar;
                    if (this.c.exists()) {
                        z2 = true;
                    } else if (!file2.exists()) {
                        b.c.a.a0.d.Z(this.c);
                        z2 = true;
                    }
                    if (z2) {
                        try {
                            b.c.a.a0.d.l1(file2);
                        } catch (FileUtils$CreateDirectoryException unused2) {
                            b.f.b.a.a aVar2 = this.f;
                            StringBuilder sbU = b.d.b.a.a.U("version directory could not be created: ");
                            sbU.append(this.e);
                            sbU.toString();
                            Objects.requireNonNull((b.f.b.a.d) aVar2);
                        }
                    }
                    this.g = b.f.d.k.c.a;
                }
            } else {
                zContains = false;
            }
        } catch (Exception unused3) {
            Objects.requireNonNull((b.f.b.a.d) aVar);
            zContains = false;
        }
        this.d = zContains;
        file2 = new File(this.c, String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i)));
        this.e = file2;
        this.f = aVar;
        if (this.c.exists()) {
            z2 = true;
        } else if (!file2.exists()) {
            b.c.a.a0.d.Z(this.c);
            z2 = true;
        }
        if (z2) {
            b.c.a.a0.d.l1(file2);
        }
        this.g = b.f.d.k.c.a;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003d  */
    public static a$d h(a aVar, File file) {
        a$d a_d;
        Objects.requireNonNull(aVar);
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf <= 0) {
            a_d = null;
        } else {
            String strSubstring = name.substring(iLastIndexOf);
            String str = ".cnt";
            if (!".cnt".equals(strSubstring)) {
                str = ".tmp".equals(strSubstring) ? ".tmp" : null;
            }
            if (str == null) {
                a_d = null;
            } else {
                String strSubstring2 = name.substring(0, iLastIndexOf);
                if (str.equals(".tmp")) {
                    int iLastIndexOf2 = strSubstring2.lastIndexOf(46);
                    if (iLastIndexOf2 <= 0) {
                        a_d = null;
                    } else {
                        strSubstring2 = strSubstring2.substring(0, iLastIndexOf2);
                    }
                }
                a_d = new a$d(str, strSubstring2);
            }
        }
        if (a_d != null && new File(aVar.k(a_d.f460b)).equals(file.getParentFile())) {
            return a_d;
        }
        return null;
    }

    @Override // b.f.b.b.c
    public void a() {
        b.c.a.a0.d.o2(this.c, new a$g(this, null));
    }

    @Override // b.f.b.b.c
    public c$b b(String str, Object obj) throws IOException {
        File file = new File(k(str));
        if (!file.exists()) {
            try {
                b.c.a.a0.d.l1(file);
            } catch (FileUtils$CreateDirectoryException e) {
                Objects.requireNonNull((b.f.b.a.d) this.f);
                throw e;
            }
        }
        try {
            return new a$f(this, str, File.createTempFile(str + ".", ".tmp", file));
        } catch (IOException e2) {
            Objects.requireNonNull((b.f.b.a.d) this.f);
            throw e2;
        }
    }

    @Override // b.f.b.b.c
    public boolean c(String str, Object obj) {
        File fileJ = j(str);
        boolean zExists = fileJ.exists();
        if (zExists) {
            Objects.requireNonNull((b.f.d.k.c) this.g);
            fileJ.setLastModified(System.currentTimeMillis());
        }
        return zExists;
    }

    @Override // b.f.b.b.c
    public b.f.a.a d(String str, Object obj) {
        File fileJ = j(str);
        if (!fileJ.exists()) {
            return null;
        }
        Objects.requireNonNull((b.f.d.k.c) this.g);
        fileJ.setLastModified(System.currentTimeMillis());
        return new b.f.a.a(fileJ);
    }

    @Override // b.f.b.b.c
    public Collection e() throws IOException {
        a$b a_b = new a$b(this, null);
        b.c.a.a0.d.o2(this.e, a_b);
        return Collections.unmodifiableList(a_b.a);
    }

    @Override // b.f.b.b.c
    public long f(String str) {
        return i(j(str));
    }

    @Override // b.f.b.b.c
    public long g(c$a c_a) {
        return i(((a$c) c_a).f459b.a);
    }

    public final long i(File file) {
        if (!file.exists()) {
            return 0L;
        }
        long length = file.length();
        if (file.delete()) {
            return length;
        }
        return -1L;
    }

    @Override // b.f.b.b.c
    public boolean isExternal() {
        return this.d;
    }

    @VisibleForTesting
    public File j(String str) {
        return new File(b.d.b.a.a.K(b.d.b.a.a.U(k(str)), File.separator, str, ".cnt"));
    }

    public final String k(String str) {
        String strValueOf = String.valueOf(Math.abs(str.hashCode() % 100));
        StringBuilder sb = new StringBuilder();
        sb.append(this.e);
        return b.d.b.a.a.J(sb, File.separator, strValueOf);
    }
}
