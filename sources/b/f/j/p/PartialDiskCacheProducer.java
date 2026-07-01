package b.f.j.p;

import b.c.a.a0.AnimatableValueParser;
import b.f.j.d.BytesRange;
import b.f.j.j.EncodedImage2;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.concurrent.CancellationException;
import z.Continuation3;
import z.Task6;

/* JADX INFO: renamed from: b.f.j.p.p0, reason: use source file name */
/* JADX INFO: compiled from: PartialDiskCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class PartialDiskCacheProducer implements Continuation3<EncodedImage2, Void> {
    public final /* synthetic */ ProducerListener2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ProducerContext f633b;
    public final /* synthetic */ Consumer2 c;
    public final /* synthetic */ CacheKey d;
    public final /* synthetic */ PartialDiskCacheProducer3 e;

    public PartialDiskCacheProducer(PartialDiskCacheProducer3 partialDiskCacheProducer3, ProducerListener2 producerListener2, ProducerContext producerContext, Consumer2 consumer2, CacheKey cacheKey) {
        this.e = partialDiskCacheProducer3;
        this.a = producerListener2;
        this.f633b = producerContext;
        this.c = consumer2;
        this.d = cacheKey;
    }

    @Override // z.Continuation3
    public Void a(Task6<EncodedImage2> task6) throws Exception {
        boolean z2;
        EncodedImage2 encodedImage2;
        synchronized (task6.g) {
            z2 = task6.i;
        }
        if (z2 || (task6.e() && (task6.d() instanceof CancellationException))) {
            this.a.d(this.f633b, "PartialDiskCacheProducer", null);
            this.c.d();
        } else if (task6.e()) {
            this.a.k(this.f633b, "PartialDiskCacheProducer", task6.d(), null);
            this.e.d(this.c, this.f633b, this.d, null);
        } else {
            synchronized (task6.g) {
                encodedImage2 = task6.j;
            }
            EncodedImage2 encodedImage3 = encodedImage2;
            if (encodedImage3 != null) {
                ProducerListener2 producerListener2 = this.a;
                ProducerContext producerContext = this.f633b;
                producerListener2.j(producerContext, "PartialDiskCacheProducer", PartialDiskCacheProducer3.c(producerListener2, producerContext, true, encodedImage3.n()));
                int iN = encodedImage3.n() - 1;
                AnimatableValueParser.i(Boolean.valueOf(iN > 0));
                encodedImage3.f590s = new BytesRange(0, iN);
                int iN2 = encodedImage3.n();
                ImageRequest imageRequestE = this.f633b.e();
                BytesRange bytesRange = imageRequestE.l;
                if (bytesRange != null && bytesRange.a >= 0 && iN >= bytesRange.f563b) {
                    this.f633b.i("disk", "partial");
                    this.a.c(this.f633b, "PartialDiskCacheProducer", true);
                    this.c.b(encodedImage3, 9);
                } else {
                    this.c.b(encodedImage3, 8);
                    ImageRequestBuilder imageRequestBuilderB = ImageRequestBuilder.b(imageRequestE.c);
                    imageRequestBuilderB.f = imageRequestE.i;
                    imageRequestBuilderB.o = imageRequestE.l;
                    imageRequestBuilderB.g = imageRequestE.f2902b;
                    imageRequestBuilderB.i = imageRequestE.g;
                    imageRequestBuilderB.j = imageRequestE.h;
                    imageRequestBuilderB.f2904b = imageRequestE.n;
                    imageRequestBuilderB.c = imageRequestE.o;
                    imageRequestBuilderB.l = imageRequestE.f2903s;
                    imageRequestBuilderB.h = imageRequestE.f;
                    imageRequestBuilderB.k = imageRequestE.m;
                    imageRequestBuilderB.d = imageRequestE.j;
                    imageRequestBuilderB.n = imageRequestE.t;
                    imageRequestBuilderB.e = imageRequestE.k;
                    imageRequestBuilderB.m = imageRequestE.r;
                    imageRequestBuilderB.p = imageRequestE.u;
                    int i = iN2 - 1;
                    AnimatableValueParser.i(Boolean.valueOf(i >= 0));
                    imageRequestBuilderB.o = new BytesRange(i, Integer.MAX_VALUE);
                    this.e.d(this.c, new SettableProducerContext(imageRequestBuilderB.a(), this.f633b), this.d, encodedImage3);
                }
            } else {
                ProducerListener2 producerListener3 = this.a;
                ProducerContext producerContext2 = this.f633b;
                producerListener3.j(producerContext2, "PartialDiskCacheProducer", PartialDiskCacheProducer3.c(producerListener3, producerContext2, false, 0));
                this.e.d(this.c, this.f633b, this.d, encodedImage3);
            }
        }
        return null;
    }
}
