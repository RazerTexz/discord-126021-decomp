package b.f.j.p;

import androidx.annotation.VisibleForTesting;
import b.f.d.d.ImmutableMap;
import b.f.j.c.BufferedDiskCache2;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.DefaultCacheKeyFactory;
import b.f.j.j.EncodedImage2;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: b.f.j.p.s, reason: use source file name */
/* JADX INFO: compiled from: DiskCacheReadProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class DiskCacheReadProducer3 implements Producer2<EncodedImage2> {
    public final BufferedDiskCache2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BufferedDiskCache2 f636b;
    public final CacheKeyFactory c;
    public final Producer2<EncodedImage2> d;

    public DiskCacheReadProducer3(BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache3, CacheKeyFactory cacheKeyFactory, Producer2<EncodedImage2> producer2) {
        this.a = bufferedDiskCache2;
        this.f636b = bufferedDiskCache3;
        this.c = cacheKeyFactory;
        this.d = producer2;
    }

    @VisibleForTesting
    public static Map<String, String> c(ProducerListener2 producerListener2, ProducerContext producerContext, boolean z2, int i) {
        if (producerListener2.g(producerContext, "DiskCacheProducer")) {
            return z2 ? ImmutableMap.of("cached_value_found", String.valueOf(z2), "encodedImageSize", String.valueOf(i)) : ImmutableMap.of("cached_value_found", String.valueOf(z2));
        }
        return null;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        ImageRequest imageRequestE = producerContext.e();
        if (!producerContext.e().b(16)) {
            if (producerContext.q().g() < ImageRequest.c.DISK_CACHE.g()) {
                this.d.b(consumer2, producerContext);
                return;
            } else {
                producerContext.i("disk", "nil-result_read");
                consumer2.b(null, 1);
                return;
            }
        }
        producerContext.o().e(producerContext, "DiskCacheProducer");
        CacheKey cacheKeyB = ((DefaultCacheKeyFactory) this.c).b(imageRequestE, producerContext.b());
        BufferedDiskCache2 bufferedDiskCache2 = imageRequestE.f2902b == ImageRequest.b.SMALL ? this.f636b : this.a;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        bufferedDiskCache2.e(cacheKeyB, atomicBoolean).b(new DiskCacheReadProducer(this, producerContext.o(), producerContext, consumer2));
        producerContext.f(new DiskCacheReadProducer2(this, atomicBoolean));
    }
}
