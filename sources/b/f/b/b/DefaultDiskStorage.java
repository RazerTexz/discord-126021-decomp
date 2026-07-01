package b.f.b.b;

import android.os.Environment;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.f.a.FileBinaryResource;
import b.f.b.a.CacheErrorLogger;
import b.f.b.a.NoOpCacheErrorLogger;
import b.f.b.a.WriterCallback;
import b.f.b.b.DiskStorage;
import b.f.d.c.FileTreeVisitor;
import b.f.d.d.CountingOutputStream;
import b.f.d.k.Clock2;
import b.f.d.k.SystemClock;
import b.f.j.c.BufferedDiskCache4;
import com.facebook.common.file.FileUtils$CreateDirectoryException;
import com.facebook.common.file.FileUtils$ParentDirNotFoundException;
import com.facebook.common.file.FileUtils$RenameException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: b.f.b.b.a, reason: use source file name */
/* JADX INFO: compiled from: DefaultDiskStorage.java */
/* JADX INFO: loaded from: classes.dex */
public class DefaultDiskStorage implements DiskStorage {
    public static final long a = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f457b = 0;
    public final File c;
    public final boolean d;
    public final File e;
    public final CacheErrorLogger f;
    public final Clock2 g;

    /* JADX INFO: renamed from: b.f.b.b.a$b */
    /* JADX INFO: compiled from: DefaultDiskStorage.java */
    public class b implements FileTreeVisitor {
        public final List<DiskStorage.a> a = new ArrayList();

        public b(a aVar) {
        }

        @Override // b.f.d.c.FileTreeVisitor
        public void a(File file) {
            d dVarH = DefaultDiskStorage.h(DefaultDiskStorage.this, file);
            if (dVarH == null || dVarH.a != ".cnt") {
                return;
            }
            this.a.add(new c(dVarH.f460b, file, null));
        }

        @Override // b.f.d.c.FileTreeVisitor
        public void b(File file) {
        }

        @Override // b.f.d.c.FileTreeVisitor
        public void c(File file) {
        }
    }

    /* JADX INFO: renamed from: b.f.b.b.a$c */
    /* JADX INFO: compiled from: DefaultDiskStorage.java */
    @VisibleForTesting
    public static class c implements DiskStorage.a {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FileBinaryResource f459b;
        public long c;
        public long d;

        public c(String str, File file, a aVar) {
            Objects.requireNonNull(str);
            this.a = str;
            this.f459b = new FileBinaryResource(file);
            this.c = -1L;
            this.d = -1L;
        }

        @Override // b.f.b.b.DiskStorage.a
        public long a() {
            if (this.d < 0) {
                this.d = this.f459b.a.lastModified();
            }
            return this.d;
        }

        @Override // b.f.b.b.DiskStorage.a
        public String getId() {
            return this.a;
        }

        @Override // b.f.b.b.DiskStorage.a
        public long getSize() {
            if (this.c < 0) {
                this.c = this.f459b.a();
            }
            return this.c;
        }
    }

    /* JADX INFO: renamed from: b.f.b.b.a$d */
    /* JADX INFO: compiled from: DefaultDiskStorage.java */
    public static class d {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f460b;

        public d(String str, String str2) {
            this.a = str;
            this.f460b = str2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("(");
            return outline.J(sb, this.f460b, ")");
        }
    }

    /* JADX INFO: renamed from: b.f.b.b.a$e */
    /* JADX INFO: compiled from: DefaultDiskStorage.java */
    public static class e extends IOException {
        public e(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
        }
    }

    /* JADX INFO: renamed from: b.f.b.b.a$f */
    /* JADX INFO: compiled from: DefaultDiskStorage.java */
    @VisibleForTesting
    public class f implements DiskStorage.b {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @VisibleForTesting
        public final File f461b;

        public f(String str, File file) {
            this.a = str;
            this.f461b = file;
        }

        public boolean a() {
            return !this.f461b.exists() || this.f461b.delete();
        }

        public FileBinaryResource b(Object obj) throws IOException {
            Objects.requireNonNull((SystemClock) DefaultDiskStorage.this.g);
            long jCurrentTimeMillis = System.currentTimeMillis();
            File fileJ = DefaultDiskStorage.this.j(this.a);
            try {
                AnimatableValueParser.Q1(this.f461b, fileJ);
                if (fileJ.exists()) {
                    fileJ.setLastModified(jCurrentTimeMillis);
                }
                return new FileBinaryResource(fileJ);
            } catch (FileUtils$RenameException e) {
                Throwable cause = e.getCause();
                if (cause != null && !(cause instanceof FileUtils$ParentDirNotFoundException)) {
                    boolean z2 = cause instanceof FileNotFoundException;
                }
                CacheErrorLogger cacheErrorLogger = DefaultDiskStorage.this.f;
                int i = DefaultDiskStorage.f457b;
                Objects.requireNonNull((NoOpCacheErrorLogger) cacheErrorLogger);
                throw e;
            }
        }

        public void c(WriterCallback writerCallback, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.f461b);
                try {
                    CountingOutputStream countingOutputStream = new CountingOutputStream(fileOutputStream);
                    BufferedDiskCache4 bufferedDiskCache4 = (BufferedDiskCache4) writerCallback;
                    InputStream inputStreamE = bufferedDiskCache4.a.e();
                    Objects.requireNonNull(inputStreamE);
                    bufferedDiskCache4.f556b.c.a(inputStreamE, countingOutputStream);
                    countingOutputStream.flush();
                    long j = countingOutputStream.j;
                    fileOutputStream.close();
                    if (this.f461b.length() != j) {
                        throw new e(j, this.f461b.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                CacheErrorLogger cacheErrorLogger = DefaultDiskStorage.this.f;
                int i = DefaultDiskStorage.f457b;
                Objects.requireNonNull((NoOpCacheErrorLogger) cacheErrorLogger);
                throw e;
            }
        }
    }

    /* JADX INFO: renamed from: b.f.b.b.a$g */
    /* JADX INFO: compiled from: DefaultDiskStorage.java */
    public class g implements FileTreeVisitor {
        public boolean a;

        public g(a aVar) {
        }

        @Override // b.f.d.c.FileTreeVisitor
        public void a(File file) {
            if (this.a) {
                d dVarH = DefaultDiskStorage.h(DefaultDiskStorage.this, file);
                boolean z2 = false;
                if (dVarH != null) {
                    String str = dVarH.a;
                    if (str == ".tmp") {
                        long jLastModified = file.lastModified();
                        Objects.requireNonNull((SystemClock) DefaultDiskStorage.this.g);
                        if (jLastModified > System.currentTimeMillis() - DefaultDiskStorage.a) {
                        }
                    } else {
                        AnimatableValueParser.B(str == ".cnt");
                    }
                    z2 = true;
                }
                if (z2) {
                    return;
                }
            }
            file.delete();
        }

        @Override // b.f.d.c.FileTreeVisitor
        public void b(File file) {
            if (this.a || !file.equals(DefaultDiskStorage.this.e)) {
                return;
            }
            this.a = true;
        }

        @Override // b.f.d.c.FileTreeVisitor
        public void c(File file) {
            if (!DefaultDiskStorage.this.c.equals(file) && !this.a) {
                file.delete();
            }
            if (this.a && file.equals(DefaultDiskStorage.this.e)) {
                this.a = false;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005c  */
    /* JADX WARN: Code duplicated, block: B:17:0x0062  */
    /* JADX WARN: Code duplicated, block: B:18:0x0067  */
    /* JADX WARN: Code duplicated, block: B:29:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
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
                    Objects.requireNonNull((NoOpCacheErrorLogger) cacheErrorLogger);
                    zContains = false;
                    this.d = zContains;
                    file2 = new File(this.c, String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i)));
                    this.e = file2;
                    this.f = cacheErrorLogger;
                    if (this.c.exists()) {
                        z2 = true;
                    } else if (!file2.exists()) {
                        AnimatableValueParser.Z(this.c);
                        z2 = true;
                    }
                    if (z2) {
                        try {
                            AnimatableValueParser.l1(file2);
                        } catch (FileUtils$CreateDirectoryException unused2) {
                            CacheErrorLogger cacheErrorLogger2 = this.f;
                            StringBuilder sbU = outline.U("version directory could not be created: ");
                            sbU.append(this.e);
                            sbU.toString();
                            Objects.requireNonNull((NoOpCacheErrorLogger) cacheErrorLogger2);
                        }
                    }
                    this.g = SystemClock.a;
                }
            } else {
                zContains = false;
            }
        } catch (Exception unused3) {
            Objects.requireNonNull((NoOpCacheErrorLogger) cacheErrorLogger);
            zContains = false;
        }
        this.d = zContains;
        file2 = new File(this.c, String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i)));
        this.e = file2;
        this.f = cacheErrorLogger;
        if (this.c.exists()) {
            z2 = true;
        } else if (!file2.exists()) {
            AnimatableValueParser.Z(this.c);
            z2 = true;
        }
        if (z2) {
            AnimatableValueParser.l1(file2);
        }
        this.g = SystemClock.a;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003d  */
    public static d h(DefaultDiskStorage defaultDiskStorage, File file) {
        d dVar;
        Objects.requireNonNull(defaultDiskStorage);
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf <= 0) {
            dVar = null;
        } else {
            String strSubstring = name.substring(iLastIndexOf);
            String str = ".cnt";
            if (!".cnt".equals(strSubstring)) {
                str = ".tmp".equals(strSubstring) ? ".tmp" : null;
            }
            if (str == null) {
                dVar = null;
            } else {
                String strSubstring2 = name.substring(0, iLastIndexOf);
                if (str.equals(".tmp")) {
                    int iLastIndexOf2 = strSubstring2.lastIndexOf(46);
                    if (iLastIndexOf2 <= 0) {
                        dVar = null;
                    } else {
                        strSubstring2 = strSubstring2.substring(0, iLastIndexOf2);
                    }
                }
                dVar = new d(str, strSubstring2);
            }
        }
        if (dVar != null && new File(defaultDiskStorage.k(dVar.f460b)).equals(file.getParentFile())) {
            return dVar;
        }
        return null;
    }

    @Override // b.f.b.b.DiskStorage
    public void a() {
        AnimatableValueParser.o2(this.c, new g(null));
    }

    @Override // b.f.b.b.DiskStorage
    public DiskStorage.b b(String str, Object obj) throws IOException {
        File file = new File(k(str));
        if (!file.exists()) {
            try {
                AnimatableValueParser.l1(file);
            } catch (FileUtils$CreateDirectoryException e2) {
                Objects.requireNonNull((NoOpCacheErrorLogger) this.f);
                throw e2;
            }
        }
        try {
            return new f(str, File.createTempFile(str + ".", ".tmp", file));
        } catch (IOException e3) {
            Objects.requireNonNull((NoOpCacheErrorLogger) this.f);
            throw e3;
        }
    }

    @Override // b.f.b.b.DiskStorage
    public boolean c(String str, Object obj) {
        File fileJ = j(str);
        boolean zExists = fileJ.exists();
        if (zExists) {
            Objects.requireNonNull((SystemClock) this.g);
            fileJ.setLastModified(System.currentTimeMillis());
        }
        return zExists;
    }

    @Override // b.f.b.b.DiskStorage
    public FileBinaryResource d(String str, Object obj) {
        File fileJ = j(str);
        if (!fileJ.exists()) {
            return null;
        }
        Objects.requireNonNull((SystemClock) this.g);
        fileJ.setLastModified(System.currentTimeMillis());
        return new FileBinaryResource(fileJ);
    }

    @Override // b.f.b.b.DiskStorage
    public Collection e() throws IOException {
        b bVar = new b(null);
        AnimatableValueParser.o2(this.e, bVar);
        return Collections.unmodifiableList(bVar.a);
    }

    @Override // b.f.b.b.DiskStorage
    public long f(String str) {
        return i(j(str));
    }

    @Override // b.f.b.b.DiskStorage
    public long g(DiskStorage.a aVar) {
        return i(((c) aVar).f459b.a);
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

    @Override // b.f.b.b.DiskStorage
    public boolean isExternal() {
        return this.d;
    }

    @VisibleForTesting
    public File j(String str) {
        return new File(outline.K(outline.U(k(str)), File.separator, str, ".cnt"));
    }

    public final String k(String str) {
        String strValueOf = String.valueOf(Math.abs(str.hashCode() % 100));
        StringBuilder sb = new StringBuilder();
        sb.append(this.e);
        return outline.J(sb, File.separator, strValueOf);
    }
}
