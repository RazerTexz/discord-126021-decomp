package b.f.b.b;

import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import b.f.a.FileBinaryResource;
import b.f.b.a.CacheErrorLogger;
import b.f.b.a.NoOpCacheErrorLogger;
import b.f.b.b.DiskStorage;
import b.f.d.e.FLog;
import com.facebook.common.file.FileUtils$CreateDirectoryException;
import com.facebook.common.internal.Supplier;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.b.b.e, reason: use source file name */
/* JADX INFO: compiled from: DynamicDefaultDiskStorage.java */
/* JADX INFO: loaded from: classes.dex */
public class DynamicDefaultDiskStorage implements DiskStorage {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Supplier<File> f466b;
    public final String c;
    public final CacheErrorLogger d;

    @VisibleForTesting
    public volatile a e = new a(null, null);

    /* JADX INFO: renamed from: b.f.b.b.e$a */
    /* JADX INFO: compiled from: DynamicDefaultDiskStorage.java */
    @VisibleForTesting
    public static class a {
        public final DiskStorage a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final File f467b;

        @VisibleForTesting
        public a(File file, DiskStorage diskStorage) {
            this.a = diskStorage;
            this.f467b = file;
        }
    }

    public DynamicDefaultDiskStorage(int i, Supplier<File> supplier, String str, CacheErrorLogger cacheErrorLogger) {
        this.a = i;
        this.d = cacheErrorLogger;
        this.f466b = supplier;
        this.c = str;
    }

    @Override // b.f.b.b.DiskStorage
    public void a() {
        try {
            i().a();
        } catch (IOException e) {
            FLog.b(DynamicDefaultDiskStorage.class, "purgeUnexpectedResources", e);
        }
    }

    @Override // b.f.b.b.DiskStorage
    public DiskStorage.b b(String str, Object obj) throws IOException {
        return i().b(str, obj);
    }

    @Override // b.f.b.b.DiskStorage
    public boolean c(String str, Object obj) throws IOException {
        return i().c(str, obj);
    }

    @Override // b.f.b.b.DiskStorage
    public FileBinaryResource d(String str, Object obj) throws IOException {
        return i().d(str, obj);
    }

    @Override // b.f.b.b.DiskStorage
    public Collection<DiskStorage.a> e() throws IOException {
        return i().e();
    }

    @Override // b.f.b.b.DiskStorage
    public long f(String str) throws IOException {
        return i().f(str);
    }

    @Override // b.f.b.b.DiskStorage
    public long g(DiskStorage.a aVar) throws IOException {
        return i().g(aVar);
    }

    public final void h() throws IOException {
        File file = new File(this.f466b.get(), this.c);
        try {
            AnimatableValueParser.l1(file);
            file.getAbsolutePath();
            int i = FLog.a;
            this.e = new a(file, new DefaultDiskStorage(file, this.a, this.d));
        } catch (FileUtils$CreateDirectoryException e) {
            Objects.requireNonNull((NoOpCacheErrorLogger) this.d);
            throw e;
        }
    }

    @VisibleForTesting
    public synchronized DiskStorage i() throws IOException {
        DiskStorage diskStorage;
        File file;
        a aVar = this.e;
        if (aVar.a == null || (file = aVar.f467b) == null || !file.exists()) {
            if (this.e.a != null && this.e.f467b != null) {
                AnimatableValueParser.Z(this.e.f467b);
            }
            h();
        }
        diskStorage = this.e.a;
        Objects.requireNonNull(diskStorage);
        return diskStorage;
    }

    @Override // b.f.b.b.DiskStorage
    public boolean isExternal() {
        try {
            return i().isExternal();
        } catch (IOException unused) {
            return false;
        }
    }
}
