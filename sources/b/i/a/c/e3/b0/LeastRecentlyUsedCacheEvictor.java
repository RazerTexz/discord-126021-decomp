package b.i.a.c.e3.b0;

import com.google.android.exoplayer2.upstream.cache.Cache;
import java.util.Comparator;
import java.util.TreeSet;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.o, reason: use source file name */
/* JADX INFO: compiled from: LeastRecentlyUsedCacheEvictor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class LeastRecentlyUsedCacheEvictor implements CacheEvictor {
    public final TreeSet<CacheSpan> a = new TreeSet<>(new Comparator() { // from class: b.i.a.c.e3.b0.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            CacheSpan cacheSpan = (CacheSpan) obj;
            CacheSpan cacheSpan2 = (CacheSpan) obj2;
            long j2 = cacheSpan.o;
            long j3 = cacheSpan2.o;
            if (j2 - j3 == 0) {
                return cacheSpan.compareTo(cacheSpan2);
            }
            return j2 < j3 ? -1 : 1;
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f937b;

    public LeastRecentlyUsedCacheEvictor(long j) {
    }

    @Override // b.i.a.c.e3.b0.CacheEvictor
    public void a(Cache cache, String str, long j, long j2) {
        if (j2 != -1) {
            f(cache, j2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void b(Cache cache, CacheSpan cacheSpan) {
        this.a.remove(cacheSpan);
        this.f937b -= cacheSpan.l;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void c(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        this.a.remove(cacheSpan);
        this.f937b -= cacheSpan.l;
        d(cache, cacheSpan2);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void d(Cache cache, CacheSpan cacheSpan) {
        this.a.add(cacheSpan);
        this.f937b += cacheSpan.l;
        f(cache, 0L);
    }

    @Override // b.i.a.c.e3.b0.CacheEvictor
    public void e() {
    }

    public final void f(Cache cache, long j) {
        while (this.f937b + j > 104857600 && !this.a.isEmpty()) {
            cache.d(this.a.first());
        }
    }
}
