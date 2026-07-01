package b.f.g.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.os.EnvironmentCompat;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.ImmutableList;
import b.f.d.d.Objects2;
import b.f.d.e.FLog;
import b.f.f.a.DrawableWithCaches;
import b.f.g.a.a.g.DebugOverlayImageOriginColor;
import b.f.g.a.a.g.DebugOverlayImageOriginListener;
import b.f.g.a.a.h.ForwardingImageOriginListener;
import b.f.g.a.a.h.ImageOriginListener;
import b.f.g.a.a.h.ImagePerfDataListener;
import b.f.g.a.a.h.ImagePerfMonitor;
import b.f.g.a.a.h.ImagePerfState;
import b.f.g.b.DeferredReleaser;
import b.f.g.d.DebugControllerOverlayDrawable;
import b.f.g.d.b.ImageLoadingTimeControllerListener;
import b.f.g.e.ScaleTypeDrawable;
import b.f.g.h.SettableDraweeHierarchy;
import b.f.j.c.MemoryCache;
import b.f.j.i.DrawableFactory;
import b.f.j.j.CloseableImage;
import b.f.j.j.ImmutableQualityInfo;
import b.f.j.k.RequestListener;
import b.f.j.r.FrescoSystrace;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.f.g.a.a.c, reason: use source file name */
/* JADX INFO: compiled from: PipelineDraweeController.java */
/* JADX INFO: loaded from: classes.dex */
public class PipelineDraweeController extends AbstractDraweeController<CloseableReference<CloseableImage>, ImageInfo> {
    public CacheKey A;
    public Supplier<DataSource<CloseableReference<CloseableImage>>> B;
    public boolean C;
    public ImmutableList<DrawableFactory> D;
    public ImagePerfMonitor E;
    public Set<RequestListener> F;
    public ImageOriginListener G;
    public DebugOverlayImageOriginListener H;
    public ImageRequest I;
    public ImageRequest[] J;
    public ImageRequest K;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final DrawableFactory f478x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ImmutableList<DrawableFactory> f479y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final MemoryCache<CacheKey, CloseableImage> f480z;

    public PipelineDraweeController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, MemoryCache<CacheKey, CloseableImage> memoryCache, ImmutableList<DrawableFactory> immutableList) {
        super(deferredReleaser, executor, null, null);
        this.f478x = new DefaultDrawableFactory(resources, drawableFactory);
        this.f479y = immutableList;
        this.f480z = memoryCache;
    }

    public synchronized void F(ImageOriginListener imageOriginListener) {
        ImageOriginListener imageOriginListener2 = this.G;
        if (imageOriginListener2 instanceof ForwardingImageOriginListener) {
            ForwardingImageOriginListener forwardingImageOriginListener = (ForwardingImageOriginListener) imageOriginListener2;
            synchronized (forwardingImageOriginListener) {
                forwardingImageOriginListener.a.add(imageOriginListener);
            }
        } else if (imageOriginListener2 != null) {
            this.G = new ForwardingImageOriginListener(imageOriginListener2, imageOriginListener);
        } else {
            this.G = imageOriginListener;
        }
    }

    public synchronized void G(RequestListener requestListener) {
        if (this.F == null) {
            this.F = new HashSet();
        }
        this.F.add(requestListener);
    }

    public void H(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, CacheKey cacheKey, Object obj, ImmutableList<DrawableFactory> immutableList, ImageOriginListener imageOriginListener) {
        FrescoSystrace.b();
        n(str, obj);
        this.v = false;
        this.B = supplier;
        K(null);
        this.A = cacheKey;
        this.D = null;
        synchronized (this) {
            this.G = null;
        }
        K(null);
        F(null);
        FrescoSystrace.b();
    }

    public synchronized void I(ImagePerfDataListener imagePerfDataListener, AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> abstractDraweeControllerBuilder, Supplier<Boolean> supplier) {
        ImagePerfMonitor imagePerfMonitor = this.E;
        if (imagePerfMonitor != null) {
            List<ImagePerfDataListener> list = imagePerfMonitor.j;
            if (list != null) {
                list.clear();
            }
            imagePerfMonitor.c(false);
            imagePerfMonitor.c.a();
        }
        if (imagePerfDataListener != null) {
            if (this.E == null) {
                this.E = new ImagePerfMonitor(AwakeTimeSinceBootClock.get(), this, supplier);
            }
            ImagePerfMonitor imagePerfMonitor2 = this.E;
            Objects.requireNonNull(imagePerfMonitor2);
            if (imagePerfMonitor2.j == null) {
                imagePerfMonitor2.j = new CopyOnWriteArrayList();
            }
            imagePerfMonitor2.j.add(imagePerfDataListener);
            this.E.c(true);
            ImagePerfState imagePerfState = this.E.c;
            ImageRequest imageRequest = abstractDraweeControllerBuilder.h;
            ImageRequest[] imageRequestArr = abstractDraweeControllerBuilder.i;
            imagePerfState.f = imageRequest;
            imagePerfState.g = null;
            imagePerfState.h = imageRequestArr;
        }
        this.I = abstractDraweeControllerBuilder.h;
        this.J = abstractDraweeControllerBuilder.i;
        this.K = null;
    }

    public final Drawable J(ImmutableList<DrawableFactory> immutableList, CloseableImage closeableImage) {
        Drawable drawableB;
        if (immutableList == null) {
            return null;
        }
        for (DrawableFactory drawableFactory : immutableList) {
            if (drawableFactory.a(closeableImage) && (drawableB = drawableFactory.b(closeableImage)) != null) {
                return drawableB;
            }
        }
        return null;
    }

    public final void K(CloseableImage closeableImage) {
        String str;
        ScaleTypeDrawable scaleTypeDrawableP0;
        if (this.C) {
            if (this.l == null) {
                DebugControllerOverlayDrawable debugControllerOverlayDrawable = new DebugControllerOverlayDrawable();
                ImageLoadingTimeControllerListener imageLoadingTimeControllerListener = new ImageLoadingTimeControllerListener(debugControllerOverlayDrawable);
                this.H = new DebugOverlayImageOriginListener();
                f(imageLoadingTimeControllerListener);
                this.l = debugControllerOverlayDrawable;
                SettableDraweeHierarchy settableDraweeHierarchy = this.k;
                if (settableDraweeHierarchy != null) {
                    settableDraweeHierarchy.a(debugControllerOverlayDrawable);
                }
            }
            if (this.G == null) {
                F(this.H);
            }
            Drawable drawable = this.l;
            if (drawable instanceof DebugControllerOverlayDrawable) {
                DebugControllerOverlayDrawable debugControllerOverlayDrawable2 = (DebugControllerOverlayDrawable) drawable;
                String str2 = this.m;
                if (str2 == null) {
                    str2 = "none";
                }
                debugControllerOverlayDrawable2.j = str2;
                debugControllerOverlayDrawable2.invalidateSelf();
                SettableDraweeHierarchy settableDraweeHierarchy2 = this.k;
                ScalingUtils$ScaleType scalingUtils$ScaleType = null;
                if (settableDraweeHierarchy2 != null && (scaleTypeDrawableP0 = AnimatableValueParser.p0(settableDraweeHierarchy2.e())) != null) {
                    scalingUtils$ScaleType = scaleTypeDrawableP0.n;
                }
                debugControllerOverlayDrawable2.n = scalingUtils$ScaleType;
                int i = this.H.a;
                switch (i) {
                    case 2:
                        str = "network";
                        break;
                    case 3:
                        str = "disk";
                        break;
                    case 4:
                        str = "memory_encoded";
                        break;
                    case 5:
                        str = "memory_bitmap";
                        break;
                    case 6:
                        str = "memory_bitmap_shortcut";
                        break;
                    case 7:
                        str = "local";
                        break;
                    default:
                        str = EnvironmentCompat.MEDIA_UNKNOWN;
                        break;
                }
                int i2 = DebugOverlayImageOriginColor.a.get(i, -1);
                debugControllerOverlayDrawable2.C = str;
                debugControllerOverlayDrawable2.D = i2;
                debugControllerOverlayDrawable2.invalidateSelf();
                if (closeableImage == null) {
                    debugControllerOverlayDrawable2.c();
                    return;
                }
                int width = closeableImage.getWidth();
                int height = closeableImage.getHeight();
                debugControllerOverlayDrawable2.k = width;
                debugControllerOverlayDrawable2.l = height;
                debugControllerOverlayDrawable2.invalidateSelf();
                debugControllerOverlayDrawable2.m = closeableImage.c();
            }
        }
    }

    public synchronized void L(RequestListener requestListener) {
        Set<RequestListener> set = this.F;
        if (set == null) {
            return;
        }
        set.remove(requestListener);
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController, com.facebook.drawee.interfaces.DraweeController
    public void e(DraweeHierarchy draweeHierarchy) {
        super.e(draweeHierarchy);
        K(null);
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public Drawable g(CloseableReference<CloseableImage> closeableReference) {
        CloseableReference<CloseableImage> closeableReference2 = closeableReference;
        try {
            FrescoSystrace.b();
            AnimatableValueParser.B(CloseableReference.y(closeableReference2));
            CloseableImage closeableImageU = closeableReference2.u();
            K(closeableImageU);
            Drawable drawableJ = J(this.D, closeableImageU);
            if (drawableJ == null && (drawableJ = J(this.f479y, closeableImageU)) == null && (drawableJ = this.f478x.b(closeableImageU)) == null) {
                throw new UnsupportedOperationException("Unrecognized image class: " + closeableImageU);
            }
            FrescoSystrace.b();
            return drawableJ;
        } catch (Throwable th) {
            FrescoSystrace.b();
            throw th;
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public CloseableReference<CloseableImage> h() {
        CacheKey cacheKey;
        FrescoSystrace.b();
        try {
            MemoryCache<CacheKey, CloseableImage> memoryCache = this.f480z;
            if (memoryCache != null && (cacheKey = this.A) != null) {
                CloseableReference<CloseableImage> closeableReference = memoryCache.get(cacheKey);
                if (closeableReference == null || ((ImmutableQualityInfo) closeableReference.u().b()).d) {
                    return closeableReference;
                }
                closeableReference.close();
            }
            return null;
        } finally {
            FrescoSystrace.b();
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public DataSource<CloseableReference<CloseableImage>> j() {
        FrescoSystrace.b();
        if (FLog.h(2)) {
            System.identityHashCode(this);
        }
        DataSource<CloseableReference<CloseableImage>> dataSource = this.B.get();
        FrescoSystrace.b();
        return dataSource;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public int k(CloseableReference<CloseableImage> closeableReference) {
        CloseableReference<CloseableImage> closeableReference2 = closeableReference;
        if (closeableReference2 == null || !closeableReference2.x()) {
            return 0;
        }
        return System.identityHashCode(closeableReference2.o.c());
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public ImageInfo l(CloseableReference<CloseableImage> closeableReference) {
        CloseableReference<CloseableImage> closeableReference2 = closeableReference;
        AnimatableValueParser.B(CloseableReference.y(closeableReference2));
        return closeableReference2.u();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0021, code lost:
    
        if (r0 != null) goto L6;
     */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Uri m() {
        Uri uri;
        ImageRequest imageRequest = this.I;
        ImageRequest imageRequest2 = this.K;
        ImageRequest[] imageRequestArr = this.J;
        if (imageRequest == null || (uri = imageRequest.c) == null) {
            if (imageRequestArr != null && imageRequestArr.length > 0 && imageRequestArr[0] != null) {
                ImageRequest imageRequest3 = imageRequestArr[0];
                uri = imageRequest3 != null ? imageRequest3.c : null;
            }
            if (imageRequest2 != null) {
                return imageRequest2.c;
            }
            return null;
        }
        return uri;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public Map t(ImageInfo imageInfo) {
        ImageInfo imageInfo2 = imageInfo;
        if (imageInfo2 == null) {
            return null;
        }
        return imageInfo2.a();
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public String toString() {
        Objects2 objects2H2 = AnimatableValueParser.h2(this);
        objects2H2.c("super", super.toString());
        objects2H2.c("dataSourceSupplier", this.B);
        return objects2H2.toString();
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public void v(String str, CloseableReference<CloseableImage> closeableReference) {
        synchronized (this) {
            ImageOriginListener imageOriginListener = this.G;
            if (imageOriginListener != null) {
                imageOriginListener.a(str, 6, true, "PipelineDraweeController");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public void x(Drawable drawable) {
        if (drawable instanceof DrawableWithCaches) {
            ((DrawableWithCaches) drawable).a();
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public void z(CloseableReference<CloseableImage> closeableReference) {
        CloseableReference<CloseableImage> closeableReference2 = closeableReference;
        Class<CloseableReference> cls = CloseableReference.j;
        if (closeableReference2 != null) {
            closeableReference2.close();
        }
    }
}
