package b.f.j.p;

import android.util.Pair;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.DefaultCacheKeyFactory;
import b.f.j.j.CloseableImage;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.Closeable;

/* JADX INFO: renamed from: b.f.j.p.g, reason: use source file name */
/* JADX INFO: compiled from: BitmapMemoryCacheKeyMultiplexProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class BitmapMemoryCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, ImageRequest.c>, CloseableReference<CloseableImage>> {
    public final CacheKeyFactory f;

    public BitmapMemoryCacheKeyMultiplexProducer(CacheKeyFactory cacheKeyFactory, Producer2 producer2) {
        super(producer2, "BitmapMemoryCacheKeyMultiplexProducer", "multiplex_bmp_cnt");
        this.f = cacheKeyFactory;
    }

    @Override // b.f.j.p.MultiplexProducer
    public Closeable c(Closeable closeable) {
        return CloseableReference.n((CloseableReference) closeable);
    }

    @Override // b.f.j.p.MultiplexProducer
    public Pair<CacheKey, ImageRequest.c> d(ProducerContext producerContext) {
        return Pair.create(((DefaultCacheKeyFactory) this.f).a(producerContext.e(), producerContext.b()), producerContext.q());
    }
}
