package b.f.g.a.a;

import android.content.Context;
import android.content.res.Resources;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.b.UiThreadImmediateExecutorService;
import b.f.g.b.DeferredReleaser;
import b.f.g.b.DeferredReleaserConcurrentImpl;
import b.f.j.a.b.AnimatedFactory;
import b.f.j.c.MemoryCache;
import b.f.j.e.ImagePipeline2;
import b.f.j.e.ImagePipelineFactory;
import b.f.j.i.DrawableFactory;
import b.f.j.j.CloseableImage;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;

/* JADX INFO: renamed from: b.f.g.a.a.e, reason: use source file name */
/* JADX INFO: compiled from: PipelineDraweeControllerBuilderSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class PipelineDraweeControllerBuilderSupplier implements Supplier<PipelineDraweeControllerBuilder> {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImagePipeline2 f481b;
    public final PipelineDraweeControllerFactory c;

    public PipelineDraweeControllerBuilderSupplier(Context context) {
        DeferredReleaser deferredReleaser;
        ImagePipelineFactory imagePipelineFactory = ImagePipelineFactory.a;
        AnimatableValueParser.y(imagePipelineFactory, "ImagePipelineFactory was not initialized!");
        this.a = context;
        if (imagePipelineFactory.l == null) {
            imagePipelineFactory.l = imagePipelineFactory.a();
        }
        ImagePipeline2 imagePipeline2 = imagePipelineFactory.l;
        this.f481b = imagePipeline2;
        PipelineDraweeControllerFactory pipelineDraweeControllerFactory = new PipelineDraweeControllerFactory();
        this.c = pipelineDraweeControllerFactory;
        Resources resources = context.getResources();
        synchronized (DeferredReleaser.class) {
            if (DeferredReleaser.a == null) {
                DeferredReleaser.a = new DeferredReleaserConcurrentImpl();
            }
            deferredReleaser = DeferredReleaser.a;
        }
        AnimatedFactory animatedFactoryB = imagePipelineFactory.b();
        DrawableFactory drawableFactoryA = animatedFactoryB == null ? null : animatedFactoryB.a(context);
        if (UiThreadImmediateExecutorService.k == null) {
            UiThreadImmediateExecutorService.k = new UiThreadImmediateExecutorService();
        }
        UiThreadImmediateExecutorService uiThreadImmediateExecutorService = UiThreadImmediateExecutorService.k;
        MemoryCache<CacheKey, CloseableImage> memoryCache = imagePipeline2.e;
        pipelineDraweeControllerFactory.a = resources;
        pipelineDraweeControllerFactory.f482b = deferredReleaser;
        pipelineDraweeControllerFactory.c = drawableFactoryA;
        pipelineDraweeControllerFactory.d = uiThreadImmediateExecutorService;
        pipelineDraweeControllerFactory.e = memoryCache;
        pipelineDraweeControllerFactory.f = null;
        pipelineDraweeControllerFactory.g = null;
    }

    @Override // com.facebook.common.internal.Supplier
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public PipelineDraweeControllerBuilder get() {
        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilder = new PipelineDraweeControllerBuilder(this.a, this.c, this.f481b, null, null);
        pipelineDraweeControllerBuilder.q = null;
        return pipelineDraweeControllerBuilder;
    }
}
