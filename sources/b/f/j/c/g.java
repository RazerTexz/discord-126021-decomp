package b.f.j.c;

import com.facebook.cache.common.CacheKey;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: BufferedDiskCache.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements Callable<Void> {
    public final /* synthetic */ CacheKey j;
    public final /* synthetic */ f k;

    public g(f fVar, Object obj, CacheKey cacheKey) {
        this.k = fVar;
        this.j = cacheKey;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.k.f.c(this.j);
            ((b.f.b.b.d) this.k.a).f(this.j);
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
