package b.f.h.a.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import b.f.d.k.MonotonicClock;
import b.f.h.a.a.AnimationBackendDelegateWithInactivityCheck;
import b.f.h.a.b.BitmapAnimationBackend;
import b.f.h.a.b.BitmapFrameCache;
import b.f.h.a.b.d.AnimationFrameCacheKey;
import b.f.h.a.b.d.FrescoFrameCache;
import b.f.h.a.b.d.KeepLastFrameCache;
import b.f.h.a.b.d.NoOpCache;
import b.f.h.a.b.e.DefaultBitmapFramePreparer;
import b.f.h.a.b.e.FixedNumberBitmapFramePreparationStrategy;
import b.f.h.a.b.f.AnimatedDrawableBackendAnimationInformation;
import b.f.h.a.b.f.AnimatedDrawableBackendFrameRenderer;
import b.f.h.a.c.AnimatedDrawable2;
import b.f.j.a.a.AnimatedDrawableBackend;
import b.f.j.a.a.AnimatedImage;
import b.f.j.a.a.AnimatedImageResult;
import b.f.j.a.c.AnimatedDrawableBackendProvider;
import b.f.j.a.c.AnimatedFrameCache;
import b.f.j.c.CountingMemoryCache;
import b.f.j.i.DrawableFactory;
import b.f.j.j.CloseableAnimatedImage;
import b.f.j.j.CloseableImage;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: renamed from: b.f.h.a.d.e, reason: use source file name */
/* JADX INFO: compiled from: ExperimentalBitmapAnimationDrawableFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class ExperimentalBitmapAnimationDrawableFactory implements DrawableFactory {
    public final AnimatedDrawableBackendProvider a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f536b;
    public final ExecutorService c;
    public final MonotonicClock d;
    public final PlatformBitmapFactory e;
    public final CountingMemoryCache<CacheKey, CloseableImage> f;
    public final Supplier<Integer> g;
    public final Supplier<Integer> h;
    public final Supplier<Boolean> i;

    public ExperimentalBitmapAnimationDrawableFactory(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, MonotonicClock monotonicClock, PlatformBitmapFactory platformBitmapFactory, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, Supplier<Integer> supplier, Supplier<Integer> supplier2, Supplier<Boolean> supplier3) {
        this.a = animatedDrawableBackendProvider;
        this.f536b = scheduledExecutorService;
        this.c = executorService;
        this.d = monotonicClock;
        this.e = platformBitmapFactory;
        this.f = countingMemoryCache;
        this.g = supplier;
        this.h = supplier2;
        this.i = supplier3;
    }

    @Override // b.f.j.i.DrawableFactory
    public boolean a(CloseableImage closeableImage) {
        return closeableImage instanceof CloseableAnimatedImage;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0089  */
    /* JADX WARN: Code duplicated, block: B:35:0x0093  */
    @Override // b.f.j.i.DrawableFactory
    public Drawable b(CloseableImage closeableImage) {
        AnimatedImage animatedImage;
        AnimatedImageResult animatedImageResult;
        FrescoFrameCache frescoFrameCache;
        BitmapFrameCache noOpCache;
        AnimatedDrawableBackendFrameRenderer animatedDrawableBackendFrameRenderer;
        int iIntValue;
        FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy;
        DefaultBitmapFramePreparer defaultBitmapFramePreparer;
        CloseableAnimatedImage closeableAnimatedImage = (CloseableAnimatedImage) closeableImage;
        synchronized (closeableAnimatedImage) {
            AnimatedImageResult animatedImageResult2 = closeableAnimatedImage.l;
            animatedImage = animatedImageResult2 == null ? null : animatedImageResult2.a;
        }
        synchronized (closeableAnimatedImage) {
            animatedImageResult = closeableAnimatedImage.l;
        }
        Objects.requireNonNull(animatedImageResult);
        Bitmap.Config configD = animatedImage != null ? animatedImage.d() : null;
        AnimatedImage animatedImage2 = animatedImageResult.a;
        AnimatedDrawableBackend animatedDrawableBackendA = this.a.a(animatedImageResult, new Rect(0, 0, animatedImage2.getWidth(), animatedImage2.getHeight()));
        int iIntValue2 = this.g.get().intValue();
        if (iIntValue2 != 1) {
            if (iIntValue2 != 2) {
                noOpCache = iIntValue2 != 3 ? new NoOpCache() : new KeepLastFrameCache();
            } else {
                frescoFrameCache = new FrescoFrameCache(c(animatedImageResult), false);
            }
            BitmapFrameCache bitmapFrameCache = noOpCache;
            animatedDrawableBackendFrameRenderer = new AnimatedDrawableBackendFrameRenderer(bitmapFrameCache, animatedDrawableBackendA);
            iIntValue = this.h.get().intValue();
            if (iIntValue > 0) {
                FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy2 = new FixedNumberBitmapFramePreparationStrategy(iIntValue);
                PlatformBitmapFactory platformBitmapFactory = this.e;
                if (configD == null) {
                    configD = Bitmap.Config.ARGB_8888;
                }
                fixedNumberBitmapFramePreparationStrategy = fixedNumberBitmapFramePreparationStrategy2;
                defaultBitmapFramePreparer = new DefaultBitmapFramePreparer(platformBitmapFactory, animatedDrawableBackendFrameRenderer, configD, this.c);
            } else {
                fixedNumberBitmapFramePreparationStrategy = null;
                defaultBitmapFramePreparer = null;
            }
            BitmapAnimationBackend bitmapAnimationBackend = new BitmapAnimationBackend(this.e, bitmapFrameCache, new AnimatedDrawableBackendAnimationInformation(animatedDrawableBackendA), animatedDrawableBackendFrameRenderer, fixedNumberBitmapFramePreparationStrategy, defaultBitmapFramePreparer);
            return new AnimatedDrawable2(new AnimationBackendDelegateWithInactivityCheck(bitmapAnimationBackend, bitmapAnimationBackend, this.d, this.f536b));
        }
        frescoFrameCache = new FrescoFrameCache(c(animatedImageResult), true);
        noOpCache = frescoFrameCache;
        BitmapFrameCache bitmapFrameCache2 = noOpCache;
        animatedDrawableBackendFrameRenderer = new AnimatedDrawableBackendFrameRenderer(bitmapFrameCache2, animatedDrawableBackendA);
        iIntValue = this.h.get().intValue();
        if (iIntValue > 0) {
            FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy3 = new FixedNumberBitmapFramePreparationStrategy(iIntValue);
            PlatformBitmapFactory platformBitmapFactory2 = this.e;
            if (configD == null) {
                configD = Bitmap.Config.ARGB_8888;
            }
            fixedNumberBitmapFramePreparationStrategy = fixedNumberBitmapFramePreparationStrategy3;
            defaultBitmapFramePreparer = new DefaultBitmapFramePreparer(platformBitmapFactory2, animatedDrawableBackendFrameRenderer, configD, this.c);
        } else {
            fixedNumberBitmapFramePreparationStrategy = null;
            defaultBitmapFramePreparer = null;
        }
        BitmapAnimationBackend bitmapAnimationBackend2 = new BitmapAnimationBackend(this.e, bitmapFrameCache2, new AnimatedDrawableBackendAnimationInformation(animatedDrawableBackendA), animatedDrawableBackendFrameRenderer, fixedNumberBitmapFramePreparationStrategy, defaultBitmapFramePreparer);
        return new AnimatedDrawable2(new AnimationBackendDelegateWithInactivityCheck(bitmapAnimationBackend2, bitmapAnimationBackend2, this.d, this.f536b));
    }

    public final AnimatedFrameCache c(AnimatedImageResult animatedImageResult) {
        return new AnimatedFrameCache(new AnimationFrameCacheKey(animatedImageResult.hashCode(), Boolean.FALSE.booleanValue()), this.f);
    }
}
