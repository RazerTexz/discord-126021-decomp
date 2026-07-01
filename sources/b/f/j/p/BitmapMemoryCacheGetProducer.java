package b.f.j.p;

import b.f.j.c.CacheKeyFactory;
import b.f.j.c.MemoryCache;
import b.f.j.j.CloseableImage;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: renamed from: b.f.j.p.f, reason: use source file name */
/* JADX INFO: compiled from: BitmapMemoryCacheGetProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class BitmapMemoryCacheGetProducer extends BitmapMemoryCacheProducer {
    public BitmapMemoryCacheGetProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer2<CloseableReference<CloseableImage>> producer2) {
        super(memoryCache, cacheKeyFactory, producer2);
    }

    @Override // b.f.j.p.BitmapMemoryCacheProducer
    public String c() {
        return "pipe_ui";
    }

    @Override // b.f.j.p.BitmapMemoryCacheProducer
    public String d() {
        return "BitmapMemoryCacheGetProducer";
    }

    @Override // b.f.j.p.BitmapMemoryCacheProducer
    public Consumer2<CloseableReference<CloseableImage>> e(Consumer2<CloseableReference<CloseableImage>> consumer2, CacheKey cacheKey, boolean z2) {
        return consumer2;
    }
}
