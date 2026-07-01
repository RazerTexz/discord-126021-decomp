package b.f.g.a.a;

import android.content.Context;
import android.net.Uri;
import b.f.d.d.Suppliers2;
import b.f.g.a.a.h.ImageOriginListener;
import b.f.g.a.a.h.ImageOriginRequestListener;
import b.f.g.a.a.h.ImagePerfDataListener;
import b.f.h.b.a.ControllerListener2;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.DefaultCacheKeyFactory;
import b.f.j.d.RotationOptions;
import b.f.j.e.ImagePipeline2;
import b.f.j.j.CloseableImage;
import b.f.j.k.ForwardingRequestListener;
import b.f.j.k.RequestListener;
import b.f.j.r.FrescoSystrace;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Set;

/* JADX INFO: renamed from: b.f.g.a.a.d, reason: use source file name */
/* JADX INFO: compiled from: PipelineDraweeControllerBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class PipelineDraweeControllerBuilder extends AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> {
    public final ImagePipeline2 o;
    public final PipelineDraweeControllerFactory p;
    public ImagePerfDataListener q;

    public PipelineDraweeControllerBuilder(Context context, PipelineDraweeControllerFactory pipelineDraweeControllerFactory, ImagePipeline2 imagePipeline2, Set<ControllerListener> set, Set<ControllerListener2> set2) {
        super(context, set, set2);
        this.o = imagePipeline2;
        this.p = pipelineDraweeControllerFactory;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public DataSource<CloseableReference<CloseableImage>> b(DraweeController draweeController, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.b bVar) {
        ImageRequest.c cVar;
        RequestListener requestListener;
        ImageRequest imageRequest2 = imageRequest;
        ImagePipeline2 imagePipeline2 = this.o;
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 0) {
            cVar = ImageRequest.c.FULL_FETCH;
        } else if (iOrdinal == 1) {
            cVar = ImageRequest.c.DISK_CACHE;
        } else {
            if (iOrdinal != 2) {
                throw new RuntimeException("Cache level" + bVar + "is not supported. ");
            }
            cVar = ImageRequest.c.BITMAP_MEMORY_CACHE;
        }
        ImageRequest.c cVar2 = cVar;
        ImageOriginRequestListener imageOriginRequestListener = null;
        if (draweeController instanceof PipelineDraweeController) {
            PipelineDraweeController pipelineDraweeController = (PipelineDraweeController) draweeController;
            synchronized (pipelineDraweeController) {
                ImageOriginListener imageOriginListener = pipelineDraweeController.G;
                imageOriginRequestListener = imageOriginListener != null ? new ImageOriginRequestListener(pipelineDraweeController.m, imageOriginListener) : null;
                Set<RequestListener> set = pipelineDraweeController.F;
                if (set != null) {
                    ForwardingRequestListener forwardingRequestListener = new ForwardingRequestListener(set);
                    if (imageOriginRequestListener != null) {
                        forwardingRequestListener.a.add(imageOriginRequestListener);
                    }
                    requestListener = forwardingRequestListener;
                } else {
                    requestListener = imageOriginRequestListener;
                }
            }
        } else {
            requestListener = imageOriginRequestListener;
        }
        return imagePipeline2.a(imageRequest2, obj, cVar2, requestListener, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public AbstractDraweeController d() {
        PipelineDraweeController pipelineDraweeController;
        CacheKey cacheKey;
        CacheKey cacheKeyA;
        FrescoSystrace.b();
        try {
            DraweeController draweeController = this.n;
            String strValueOf = String.valueOf(AbstractDraweeControllerBuilder.c.getAndIncrement());
            if (draweeController instanceof PipelineDraweeController) {
                pipelineDraweeController = (PipelineDraweeController) draweeController;
            } else {
                PipelineDraweeControllerFactory pipelineDraweeControllerFactory = this.p;
                PipelineDraweeController pipelineDraweeController2 = new PipelineDraweeController(pipelineDraweeControllerFactory.a, pipelineDraweeControllerFactory.f482b, pipelineDraweeControllerFactory.c, pipelineDraweeControllerFactory.d, pipelineDraweeControllerFactory.e, pipelineDraweeControllerFactory.f);
                Supplier<Boolean> supplier = pipelineDraweeControllerFactory.g;
                if (supplier != null) {
                    pipelineDraweeController2.C = supplier.get().booleanValue();
                }
                pipelineDraweeController = pipelineDraweeController2;
            }
            Supplier<DataSource<CloseableReference<CloseableImage>>> supplierE = e(pipelineDraweeController, strValueOf);
            ImageRequest imageRequest = (ImageRequest) this.h;
            CacheKeyFactory cacheKeyFactory = this.o.g;
            if (cacheKeyFactory == null || imageRequest == null) {
                cacheKey = null;
            } else {
                if (imageRequest.f2903s != null) {
                    cacheKeyA = ((DefaultCacheKeyFactory) cacheKeyFactory).c(imageRequest, this.g);
                } else {
                    cacheKeyA = ((DefaultCacheKeyFactory) cacheKeyFactory).a(imageRequest, this.g);
                }
                cacheKey = cacheKeyA;
            }
            pipelineDraweeController.H(supplierE, strValueOf, cacheKey, this.g, null, null);
            pipelineDraweeController.I(this.q, this, Suppliers2.a);
            return pipelineDraweeController;
        } finally {
            FrescoSystrace.b();
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    public PipelineDraweeControllerBuilder f(Uri uri) {
        if (uri == null) {
            this.h = null;
            return this;
        }
        ImageRequestBuilder imageRequestBuilderB = ImageRequestBuilder.b(uri);
        imageRequestBuilderB.e = RotationOptions.f567b;
        this.h = imageRequestBuilderB.a();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PipelineDraweeControllerBuilder g(String str) {
        Uri uri;
        if (str != null && !str.isEmpty()) {
            return f(Uri.parse(str));
        }
        REQUEST requestA = 0;
        requestA = 0;
        requestA = 0;
        if (str != null && str.length() != 0 && (uri = Uri.parse(str)) != null) {
            requestA = ImageRequestBuilder.b(uri).a();
        }
        this.h = requestA;
        return this;
    }
}
