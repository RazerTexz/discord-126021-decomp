package com.facebook.fresco.animation.factory;

import android.content.Context;
import android.graphics.Bitmap;
import b.f.d.b.DefaultSerialExecutorService;
import b.f.d.b.SerialExecutorService;
import b.f.d.b.UiThreadImmediateExecutorService;
import b.f.d.d.DoNotStrip;
import b.f.d.d.Suppliers2;
import b.f.h.a.d.AnimatedFactoryV2Impl2;
import b.f.h.a.d.AnimatedFactoryV2Impl3;
import b.f.h.a.d.AnimatedFactoryV2Impl4;
import b.f.h.a.d.AnimatedFactoryV2Impl5;
import b.f.h.a.d.ExperimentalBitmapAnimationDrawableFactory;
import b.f.j.a.b.AnimatedFactory;
import b.f.j.a.b.AnimatedImageFactory;
import b.f.j.a.b.AnimatedImageFactoryImpl;
import b.f.j.a.c.AnimatedDrawableBackendProvider;
import b.f.j.a.d.AnimatedDrawableUtil;
import b.f.j.c.CountingMemoryCache;
import b.f.j.d.ImageDecodeOptions;
import b.f.j.e.ExecutorSupplier;
import b.f.j.h.ImageDecoder2;
import b.f.j.i.DrawableFactory;
import b.f.j.j.CloseableImage;
import b.f.j.j.EncodedImage2;
import b.f.j.j.QualityInfo;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
@DoNotStrip
public class AnimatedFactoryV2Impl implements AnimatedFactory {
    public final PlatformBitmapFactory a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorSupplier f2894b;
    public final CountingMemoryCache<CacheKey, CloseableImage> c;
    public final boolean d;
    public AnimatedImageFactory e;
    public AnimatedDrawableBackendProvider f;
    public AnimatedDrawableUtil g;
    public DrawableFactory h;
    public SerialExecutorService i;

    public class a implements ImageDecoder2 {
        public a() {
        }

        @Override // b.f.j.h.ImageDecoder2
        public CloseableImage a(EncodedImage2 encodedImage2, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
            AnimatedFactoryV2Impl animatedFactoryV2Impl = AnimatedFactoryV2Impl.this;
            if (animatedFactoryV2Impl.e == null) {
                animatedFactoryV2Impl.e = new AnimatedImageFactoryImpl(new AnimatedFactoryV2Impl5(animatedFactoryV2Impl), animatedFactoryV2Impl.a);
            }
            AnimatedImageFactory animatedImageFactory = animatedFactoryV2Impl.e;
            Bitmap.Config config = imageDecodeOptions.e;
            AnimatedImageFactoryImpl animatedImageFactoryImpl = (AnimatedImageFactoryImpl) animatedImageFactory;
            Objects.requireNonNull(animatedImageFactoryImpl);
            if (AnimatedImageFactoryImpl.a == null) {
                throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
            }
            CloseableReference<PooledByteBuffer> closeableReferenceC = encodedImage2.c();
            Objects.requireNonNull(closeableReferenceC);
            try {
                PooledByteBuffer pooledByteBufferU = closeableReferenceC.u();
                return animatedImageFactoryImpl.a(imageDecodeOptions, pooledByteBufferU.getByteBuffer() != null ? AnimatedImageFactoryImpl.a.c(pooledByteBufferU.getByteBuffer(), imageDecodeOptions) : AnimatedImageFactoryImpl.a.h(pooledByteBufferU.k(), pooledByteBufferU.size(), imageDecodeOptions), config);
            } finally {
                closeableReferenceC.close();
            }
        }
    }

    public class b implements ImageDecoder2 {
        public b() {
        }

        @Override // b.f.j.h.ImageDecoder2
        public CloseableImage a(EncodedImage2 encodedImage2, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
            AnimatedFactoryV2Impl animatedFactoryV2Impl = AnimatedFactoryV2Impl.this;
            if (animatedFactoryV2Impl.e == null) {
                animatedFactoryV2Impl.e = new AnimatedImageFactoryImpl(new AnimatedFactoryV2Impl5(animatedFactoryV2Impl), animatedFactoryV2Impl.a);
            }
            AnimatedImageFactory animatedImageFactory = animatedFactoryV2Impl.e;
            Bitmap.Config config = imageDecodeOptions.e;
            AnimatedImageFactoryImpl animatedImageFactoryImpl = (AnimatedImageFactoryImpl) animatedImageFactory;
            Objects.requireNonNull(animatedImageFactoryImpl);
            if (AnimatedImageFactoryImpl.f547b == null) {
                throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
            }
            CloseableReference<PooledByteBuffer> closeableReferenceC = encodedImage2.c();
            Objects.requireNonNull(closeableReferenceC);
            try {
                PooledByteBuffer pooledByteBufferU = closeableReferenceC.u();
                return animatedImageFactoryImpl.a(imageDecodeOptions, pooledByteBufferU.getByteBuffer() != null ? AnimatedImageFactoryImpl.f547b.c(pooledByteBufferU.getByteBuffer(), imageDecodeOptions) : AnimatedImageFactoryImpl.f547b.h(pooledByteBufferU.k(), pooledByteBufferU.size(), imageDecodeOptions), config);
            } finally {
                closeableReferenceC.close();
            }
        }
    }

    @DoNotStrip
    public AnimatedFactoryV2Impl(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, boolean z2, SerialExecutorService serialExecutorService) {
        this.a = platformBitmapFactory;
        this.f2894b = executorSupplier;
        this.c = countingMemoryCache;
        this.d = z2;
        this.i = serialExecutorService;
    }

    @Override // b.f.j.a.b.AnimatedFactory
    public DrawableFactory a(Context context) {
        if (this.h == null) {
            AnimatedFactoryV2Impl2 animatedFactoryV2Impl2 = new AnimatedFactoryV2Impl2(this);
            ExecutorService defaultSerialExecutorService = this.i;
            if (defaultSerialExecutorService == null) {
                defaultSerialExecutorService = new DefaultSerialExecutorService(this.f2894b.a());
            }
            ExecutorService executorService = defaultSerialExecutorService;
            AnimatedFactoryV2Impl3 animatedFactoryV2Impl3 = new AnimatedFactoryV2Impl3(this);
            Supplier<Boolean> supplier = Suppliers2.a;
            if (this.f == null) {
                this.f = new AnimatedFactoryV2Impl4(this);
            }
            AnimatedDrawableBackendProvider animatedDrawableBackendProvider = this.f;
            if (UiThreadImmediateExecutorService.k == null) {
                UiThreadImmediateExecutorService.k = new UiThreadImmediateExecutorService();
            }
            this.h = new ExperimentalBitmapAnimationDrawableFactory(animatedDrawableBackendProvider, UiThreadImmediateExecutorService.k, executorService, RealtimeSinceBootClock.get(), this.a, this.c, animatedFactoryV2Impl2, animatedFactoryV2Impl3, supplier);
        }
        return this.h;
    }

    @Override // b.f.j.a.b.AnimatedFactory
    public ImageDecoder2 b() {
        return new a();
    }

    @Override // b.f.j.a.b.AnimatedFactory
    public ImageDecoder2 c() {
        return new b();
    }
}
