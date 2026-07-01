package b.f.j.e;

import b.f.b.b.d$c;
import com.facebook.cache.disk.DiskCacheConfig;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: DiskStorageCacheFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements f {
    public d a;

    public c(d dVar) {
        this.a = dVar;
    }

    public b.f.b.b.h a(DiskCacheConfig diskCacheConfig) {
        Objects.requireNonNull(this.a);
        b.f.b.b.e eVar = new b.f.b.b.e(diskCacheConfig.a, diskCacheConfig.c, diskCacheConfig.f2882b, diskCacheConfig.h);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        return new b.f.b.b.d(eVar, diskCacheConfig.g, new d$c(diskCacheConfig.f, diskCacheConfig.e, diskCacheConfig.d), diskCacheConfig.i, diskCacheConfig.h, diskCacheConfig.j, executorServiceNewSingleThreadExecutor, false);
    }
}
