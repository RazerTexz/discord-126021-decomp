package p007b.p109f.p161j.p168c;

import com.facebook.cache.common.CacheKey;
import java.util.concurrent.Callable;
import p007b.p109f.p111b.p113b.C1661d;

/* JADX INFO: renamed from: b.f.j.c.g */
/* JADX INFO: compiled from: BufferedDiskCache.java */
/* JADX INFO: loaded from: classes.dex */
public class CallableC1860g implements Callable<Void> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ CacheKey f3671j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C1859f f3672k;

    public CallableC1860g(C1859f c1859f, Object obj, CacheKey cacheKey) {
        this.f3672k = c1859f;
        this.f3671j = cacheKey;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.f3672k.f3666f.m1210c(this.f3671j);
            ((C1661d) this.f3672k.f3661a).m954f(this.f3671j);
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
