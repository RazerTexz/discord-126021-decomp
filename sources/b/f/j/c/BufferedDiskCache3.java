package b.f.j.c;

import b.f.b.b.DiskStorageCache;
import com.facebook.cache.common.CacheKey;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.f.j.c.g, reason: use source file name */
/* JADX INFO: compiled from: BufferedDiskCache.java */
/* JADX INFO: loaded from: classes.dex */
public class BufferedDiskCache3 implements Callable<Void> {
    public final /* synthetic */ CacheKey j;
    public final /* synthetic */ BufferedDiskCache2 k;

    public BufferedDiskCache3(BufferedDiskCache2 bufferedDiskCache2, Object obj, CacheKey cacheKey) {
        this.k = bufferedDiskCache2;
        this.j = cacheKey;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.k.f.c(this.j);
            ((DiskStorageCache) this.k.a).f(this.j);
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
