package b.f.j.e;

import b.c.a.a0.AnimatableValueParser;
import b.f.c.CallerContextVerifier;
import b.f.d.l.UriUtil;
import b.f.j.c.BufferedDiskCache2;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.MemoryCache;
import b.f.j.f.CloseableProducerToDataSourceAdapter;
import b.f.j.j.CloseableImage;
import b.f.j.k.ForwardingRequestListener;
import b.f.j.k.ForwardingRequestListener2;
import b.f.j.k.RequestListener;
import b.f.j.k.RequestListener2;
import b.f.j.p.InternalRequestListener;
import b.f.j.p.Producer2;
import b.f.j.p.SettableProducerContext;
import b.f.j.p.ThreadHandoffProducerQueue;
import b.f.j.r.FrescoSystrace;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: b.f.j.e.h, reason: use source file name */
/* JADX INFO: compiled from: ImagePipeline.java */
/* JADX INFO: loaded from: classes.dex */
public class ImagePipeline2 {
    public final ProducerSequenceFactory a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RequestListener f569b;
    public final RequestListener2 c;
    public final Supplier<Boolean> d;
    public final MemoryCache<CacheKey, CloseableImage> e;
    public final MemoryCache<CacheKey, PooledByteBuffer> f;
    public final CacheKeyFactory g;
    public final Supplier<Boolean> h;
    public AtomicLong i = new AtomicLong();
    public final Supplier<Boolean> j = null;
    public final CallerContextVerifier k;
    public final ImagePipelineConfigInterface l;

    static {
        new CancellationException("Prefetching is not enabled");
    }

    public ImagePipeline2(ProducerSequenceFactory producerSequenceFactory, Set<RequestListener> set, Set<RequestListener2> set2, Supplier<Boolean> supplier, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache3, CacheKeyFactory cacheKeyFactory, ThreadHandoffProducerQueue threadHandoffProducerQueue, Supplier<Boolean> supplier2, Supplier<Boolean> supplier3, CallerContextVerifier callerContextVerifier, ImagePipelineConfigInterface imagePipelineConfigInterface) {
        this.a = producerSequenceFactory;
        this.f569b = new ForwardingRequestListener(set);
        this.c = new ForwardingRequestListener2(set2);
        this.d = supplier;
        this.e = memoryCache;
        this.f = memoryCache2;
        this.g = cacheKeyFactory;
        this.h = supplier2;
        this.k = callerContextVerifier;
        this.l = imagePipelineConfigInterface;
    }

    public DataSource<CloseableReference<CloseableImage>> a(ImageRequest imageRequest, Object obj, ImageRequest.c cVar, RequestListener requestListener, String str) {
        try {
            return b(this.a.c(imageRequest), imageRequest, cVar, obj, requestListener, str);
        } catch (Exception e) {
            return AnimatableValueParser.N0(e);
        }
    }

    public final <T> DataSource<CloseableReference<T>> b(Producer2<CloseableReference<T>> producer2, ImageRequest imageRequest, ImageRequest.c cVar, Object obj, RequestListener requestListener, String str) {
        ForwardingRequestListener forwardingRequestListener;
        RequestListener forwardingRequestListener2;
        FrescoSystrace.b();
        if (requestListener == null) {
            RequestListener requestListener2 = imageRequest.t;
            if (requestListener2 == null) {
                forwardingRequestListener2 = this.f569b;
            } else {
                forwardingRequestListener = new ForwardingRequestListener(this.f569b, requestListener2);
                forwardingRequestListener2 = forwardingRequestListener;
            }
        } else {
            RequestListener requestListener3 = imageRequest.t;
            if (requestListener3 == null) {
                forwardingRequestListener2 = new ForwardingRequestListener(this.f569b, requestListener);
            } else {
                forwardingRequestListener = new ForwardingRequestListener(this.f569b, requestListener, requestListener3);
                forwardingRequestListener2 = forwardingRequestListener;
            }
        }
        InternalRequestListener internalRequestListener = new InternalRequestListener(forwardingRequestListener2, this.c);
        CallerContextVerifier callerContextVerifier = this.k;
        if (callerContextVerifier != null) {
            callerContextVerifier.a(obj, false);
        }
        try {
            SettableProducerContext settableProducerContext = new SettableProducerContext(imageRequest, String.valueOf(this.i.getAndIncrement()), str, internalRequestListener, obj, ImageRequest.c.f(imageRequest.n, cVar), false, imageRequest.f || !UriUtil.e(imageRequest.c), imageRequest.m, this.l);
            FrescoSystrace.b();
            CloseableProducerToDataSourceAdapter closeableProducerToDataSourceAdapter = new CloseableProducerToDataSourceAdapter(producer2, settableProducerContext, internalRequestListener);
            FrescoSystrace.b();
            return closeableProducerToDataSourceAdapter;
        } catch (Exception e) {
            return AnimatableValueParser.N0(e);
        } finally {
            FrescoSystrace.b();
        }
    }
}
