package b.f.j.p;

import android.util.Pair;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.DefaultCacheKeyFactory;
import b.f.j.j.EncodedImage2;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.Closeable;

/* JADX INFO: renamed from: b.f.j.p.u, reason: use source file name */
/* JADX INFO: compiled from: EncodedCacheKeyMultiplexProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class EncodedCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, ImageRequest.c>, EncodedImage2> {
    public final CacheKeyFactory f;

    public EncodedCacheKeyMultiplexProducer(CacheKeyFactory cacheKeyFactory, boolean z2, Producer2 producer2) {
        super(producer2, "EncodedCacheKeyMultiplexProducer", "multiplex_enc_cnt", z2);
        this.f = cacheKeyFactory;
    }

    @Override // b.f.j.p.MultiplexProducer
    public Closeable c(Closeable closeable) {
        return EncodedImage2.a((EncodedImage2) closeable);
    }

    @Override // b.f.j.p.MultiplexProducer
    public Pair<CacheKey, ImageRequest.c> d(ProducerContext producerContext) {
        return Pair.create(((DefaultCacheKeyFactory) this.f).b(producerContext.e(), producerContext.b()), producerContext.q());
    }
}
