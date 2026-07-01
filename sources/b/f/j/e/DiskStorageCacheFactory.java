package b.f.j.e;

import b.f.b.b.DiskStorageCache;
import b.f.b.b.DynamicDefaultDiskStorage;
import b.f.b.b.FileCache;
import com.facebook.cache.disk.DiskCacheConfig;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: b.f.j.e.c, reason: use source file name */
/* JADX INFO: compiled from: DiskStorageCacheFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class DiskStorageCacheFactory implements FileCacheFactory {
    public DynamicDefaultDiskStorageFactory a;

    public DiskStorageCacheFactory(DynamicDefaultDiskStorageFactory dynamicDefaultDiskStorageFactory) {
        this.a = dynamicDefaultDiskStorageFactory;
    }

    public FileCache a(DiskCacheConfig diskCacheConfig) {
        Objects.requireNonNull(this.a);
        DynamicDefaultDiskStorage dynamicDefaultDiskStorage = new DynamicDefaultDiskStorage(diskCacheConfig.a, diskCacheConfig.c, diskCacheConfig.f2882b, diskCacheConfig.h);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        return new DiskStorageCache(dynamicDefaultDiskStorage, diskCacheConfig.g, new DiskStorageCache.c(diskCacheConfig.f, diskCacheConfig.e, diskCacheConfig.d), diskCacheConfig.i, diskCacheConfig.h, diskCacheConfig.j, executorServiceNewSingleThreadExecutor, false);
    }
}
