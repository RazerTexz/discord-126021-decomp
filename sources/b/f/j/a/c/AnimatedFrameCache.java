package b.f.j.a.c;

import androidx.annotation.VisibleForTesting;
import androidx.core.view.PointerIconCompat;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.Objects2;
import b.f.j.c.CountingMemoryCache;
import b.f.j.j.CloseableImage;
import com.facebook.cache.common.CacheKey;
import java.util.LinkedHashSet;

/* JADX INFO: renamed from: b.f.j.a.c.c, reason: use source file name */
/* JADX INFO: compiled from: AnimatedFrameCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class AnimatedFrameCache {
    public final CacheKey a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CountingMemoryCache<CacheKey, CloseableImage> f549b;
    public final LinkedHashSet<CacheKey> d = new LinkedHashSet<>();
    public final CountingMemoryCache.b<CacheKey> c = new a();

    /* JADX INFO: renamed from: b.f.j.a.c.c$a */
    /* JADX INFO: compiled from: AnimatedFrameCache.java */
    public class a implements CountingMemoryCache.b<CacheKey> {
        public a() {
        }

        public void a(Object obj, boolean z2) {
            CacheKey cacheKey = (CacheKey) obj;
            AnimatedFrameCache animatedFrameCache = AnimatedFrameCache.this;
            synchronized (animatedFrameCache) {
                try {
                    if (z2) {
                        animatedFrameCache.d.add(cacheKey);
                    } else {
                        animatedFrameCache.d.remove(cacheKey);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.f.j.a.c.c$b */
    /* JADX INFO: compiled from: AnimatedFrameCache.java */
    @VisibleForTesting
    public static class b implements CacheKey {
        public final CacheKey a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f550b;

        public b(CacheKey cacheKey, int i) {
            this.a = cacheKey;
            this.f550b = i;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean a() {
            return false;
        }

        @Override // com.facebook.cache.common.CacheKey
        public String b() {
            return null;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f550b == bVar.f550b && this.a.equals(bVar.a);
        }

        @Override // com.facebook.cache.common.CacheKey
        public int hashCode() {
            return (this.a.hashCode() * PointerIconCompat.TYPE_ALL_SCROLL) + this.f550b;
        }

        public String toString() {
            Objects2 objects2H2 = AnimatableValueParser.h2(this);
            objects2H2.c("imageCacheKey", this.a);
            objects2H2.a("frameIndex", this.f550b);
            return objects2H2.toString();
        }
    }

    public AnimatedFrameCache(CacheKey cacheKey, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache) {
        this.a = cacheKey;
        this.f549b = countingMemoryCache;
    }
}
