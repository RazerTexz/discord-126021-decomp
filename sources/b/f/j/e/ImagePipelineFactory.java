package b.f.j.e;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import androidx.core.util.Pools;
import b.f.b.b.FileCache;
import b.f.d.b.SerialExecutorService;
import b.f.d.e.FLog;
import b.f.d.g.ByteArrayPool;
import b.f.d.g.MemoryTrimmableRegistry;
import b.f.d.g.PooledByteBufferFactory;
import b.f.j.a.b.AnimatedFactory;
import b.f.j.a.b.AnimatedFactoryProvider;
import b.f.j.b.ArtBitmapFactory;
import b.f.j.c.BitmapMemoryCacheFactory;
import b.f.j.c.BufferedDiskCache2;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.CountingLruBitmapMemoryCacheFactory;
import b.f.j.c.CountingLruBitmapMemoryCacheFactory2;
import b.f.j.c.CountingMemoryCache;
import b.f.j.c.EncodedCountingMemoryCacheFactory;
import b.f.j.c.EncodedMemoryCacheFactory;
import b.f.j.c.ImageCacheStatsTracker;
import b.f.j.c.InstrumentedMemoryCache;
import b.f.j.c.InstrumentedMemoryCacheBitmapMemoryCacheFactory;
import b.f.j.c.LruCountingMemoryCache2;
import b.f.j.c.MemoryCache;
import b.f.j.c.NativeMemoryCacheTrimStrategy;
import b.f.j.c.NoOpImageCacheStatsTracker;
import b.f.j.e.ImagePipelineExperiments;
import b.f.j.h.DefaultImageDecoder;
import b.f.j.h.ImageDecoder2;
import b.f.j.h.ProgressiveJpegConfig;
import b.f.j.j.CloseableImage;
import b.f.j.k.RequestListener;
import b.f.j.k.RequestListener2;
import b.f.j.l.PoolFactory;
import b.f.j.n.ArtDecoder;
import b.f.j.n.OreoDecoder;
import b.f.j.n.PlatformDecoder;
import b.f.j.p.NetworkFetcher2;
import b.f.j.p.ThreadHandoffProducerQueue;
import b.f.j.p.ThreadHandoffProducerQueueImpl;
import b.f.j.r.FrescoSystrace;
import b.f.j.s.ImageTranscoderFactory;
import b.f.j.s.MultiImageTranscoderFactory;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: b.f.j.e.m, reason: use source file name */
/* JADX INFO: compiled from: ImagePipelineFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class ImagePipelineFactory {
    public static ImagePipelineFactory a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadHandoffProducerQueue f577b;
    public final ImagePipelineConfigInterface c;
    public final CloseableReferenceFactory d;
    public CountingMemoryCache<CacheKey, CloseableImage> e;
    public InstrumentedMemoryCache<CacheKey, CloseableImage> f;
    public CountingMemoryCache<CacheKey, PooledByteBuffer> g;
    public InstrumentedMemoryCache<CacheKey, PooledByteBuffer> h;
    public BufferedDiskCache2 i;
    public FileCache j;
    public ImageDecoder2 k;
    public ImagePipeline2 l;
    public ImageTranscoderFactory m;
    public ProducerFactory n;
    public ProducerSequenceFactory o;
    public BufferedDiskCache2 p;
    public FileCache q;
    public PlatformBitmapFactory r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public PlatformDecoder f578s;
    public AnimatedFactory t;

    public ImagePipelineFactory(ImagePipelineConfigInterface imagePipelineConfigInterface) {
        FrescoSystrace.b();
        Objects.requireNonNull(imagePipelineConfigInterface);
        this.c = imagePipelineConfigInterface;
        Objects.requireNonNull(imagePipelineConfigInterface.getExperiments());
        this.f577b = new ThreadHandoffProducerQueueImpl(imagePipelineConfigInterface.D().b());
        Objects.requireNonNull(imagePipelineConfigInterface.getExperiments());
        CloseableReference.k = 0;
        this.d = new CloseableReferenceFactory(imagePipelineConfigInterface.f());
        FrescoSystrace.b();
    }

    public static synchronized void j(ImagePipelineConfigInterface imagePipelineConfigInterface) {
        if (a != null) {
            FLog.k(ImagePipelineFactory.class, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
        }
        a = new ImagePipelineFactory(imagePipelineConfigInterface);
    }

    public final ImagePipeline2 a() {
        ImageDecoder2 imageDecoder2C;
        ImageDecoder2 imageDecoder2B;
        if (Build.VERSION.SDK_INT >= 24) {
            Objects.requireNonNull(this.c.getExperiments());
        }
        if (this.o == null) {
            ContentResolver contentResolver = this.c.getContext().getApplicationContext().getContentResolver();
            if (this.n == null) {
                ImagePipelineExperiments.d dVar = this.c.getExperiments().f575b;
                Context context = this.c.getContext();
                ByteArrayPool byteArrayPoolE = this.c.a().e();
                if (this.k == null) {
                    if (this.c.B() != null) {
                        this.k = this.c.B();
                    } else {
                        AnimatedFactory animatedFactoryB = b();
                        if (animatedFactoryB != null) {
                            imageDecoder2B = animatedFactoryB.b();
                            imageDecoder2C = animatedFactoryB.c();
                        } else {
                            imageDecoder2C = null;
                            imageDecoder2B = null;
                        }
                        if (this.c.x() != null) {
                            h();
                            Objects.requireNonNull(this.c.x());
                            throw null;
                        }
                        this.k = new DefaultImageDecoder(imageDecoder2B, imageDecoder2C, h());
                    }
                }
                ImageDecoder2 imageDecoder2 = this.k;
                ProgressiveJpegConfig progressiveJpegConfigO = this.c.o();
                boolean zS = this.c.s();
                boolean zM = this.c.m();
                Objects.requireNonNull(this.c.getExperiments());
                ExecutorSupplier executorSupplierD = this.c.D();
                PooledByteBufferFactory pooledByteBufferFactoryC = this.c.a().c(this.c.c());
                this.c.a().d();
                InstrumentedMemoryCache<CacheKey, CloseableImage> instrumentedMemoryCacheD = d();
                InstrumentedMemoryCache<CacheKey, PooledByteBuffer> instrumentedMemoryCacheE = e();
                BufferedDiskCache2 bufferedDiskCache2F = f();
                BufferedDiskCache2 bufferedDiskCache2I = i();
                CacheKeyFactory cacheKeyFactoryL = this.c.l();
                PlatformBitmapFactory platformBitmapFactoryG = g();
                Objects.requireNonNull(this.c.getExperiments());
                Objects.requireNonNull(this.c.getExperiments());
                Objects.requireNonNull(this.c.getExperiments());
                int i = this.c.getExperiments().a;
                CloseableReferenceFactory closeableReferenceFactory = this.d;
                Objects.requireNonNull(this.c.getExperiments());
                int i2 = this.c.getExperiments().g;
                Objects.requireNonNull((ImagePipelineExperiments.c) dVar);
                this.n = new ProducerFactory(context, byteArrayPoolE, imageDecoder2, progressiveJpegConfigO, zS, zM, false, executorSupplierD, pooledByteBufferFactoryC, instrumentedMemoryCacheD, instrumentedMemoryCacheE, bufferedDiskCache2F, bufferedDiskCache2I, cacheKeyFactoryL, platformBitmapFactoryG, 0, 0, false, i, closeableReferenceFactory, false, i2);
            }
            ProducerFactory producerFactory = this.n;
            NetworkFetcher2 networkFetcher2H = this.c.h();
            boolean zM2 = this.c.m();
            Objects.requireNonNull(this.c.getExperiments());
            ThreadHandoffProducerQueue threadHandoffProducerQueue = this.f577b;
            boolean zS2 = this.c.s();
            Objects.requireNonNull(this.c.getExperiments());
            boolean zY = this.c.y();
            if (this.m == null) {
                if (this.c.v() == null && this.c.u() == null) {
                    Objects.requireNonNull(this.c.getExperiments());
                }
                int i3 = this.c.getExperiments().a;
                Objects.requireNonNull(this.c.getExperiments());
                this.m = new MultiImageTranscoderFactory(i3, false, this.c.v(), this.c.u(), this.c.getExperiments().f);
            }
            ImageTranscoderFactory imageTranscoderFactory = this.m;
            Objects.requireNonNull(this.c.getExperiments());
            Objects.requireNonNull(this.c.getExperiments());
            Objects.requireNonNull(this.c.getExperiments());
            this.o = new ProducerSequenceFactory(contentResolver, producerFactory, networkFetcher2H, zM2, false, threadHandoffProducerQueue, zS2, false, false, zY, imageTranscoderFactory, false, false, false);
        }
        ProducerSequenceFactory producerSequenceFactory = this.o;
        Set<RequestListener> setK = this.c.k();
        Set<RequestListener2> setB = this.c.b();
        Supplier<Boolean> supplierD = this.c.d();
        InstrumentedMemoryCache<CacheKey, CloseableImage> instrumentedMemoryCacheD2 = d();
        InstrumentedMemoryCache<CacheKey, PooledByteBuffer> instrumentedMemoryCacheE2 = e();
        BufferedDiskCache2 bufferedDiskCache2F2 = f();
        BufferedDiskCache2 bufferedDiskCache2I2 = i();
        CacheKeyFactory cacheKeyFactoryL2 = this.c.l();
        ThreadHandoffProducerQueue threadHandoffProducerQueue2 = this.f577b;
        Supplier<Boolean> supplier = this.c.getExperiments().d;
        Objects.requireNonNull(this.c.getExperiments());
        return new ImagePipeline2(producerSequenceFactory, setK, setB, supplierD, instrumentedMemoryCacheD2, instrumentedMemoryCacheE2, bufferedDiskCache2F2, bufferedDiskCache2I2, cacheKeyFactoryL2, threadHandoffProducerQueue2, supplier, null, this.c.z(), this.c);
    }

    public final AnimatedFactory b() {
        if (this.t == null) {
            PlatformBitmapFactory platformBitmapFactoryG = g();
            ExecutorSupplier executorSupplierD = this.c.D();
            CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCacheC = c();
            boolean z2 = this.c.getExperiments().c;
            SerialExecutorService serialExecutorServiceT = this.c.t();
            if (!AnimatedFactoryProvider.a) {
                try {
                    AnimatedFactoryProvider.f546b = (AnimatedFactory) Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(PlatformBitmapFactory.class, ExecutorSupplier.class, CountingMemoryCache.class, Boolean.TYPE, SerialExecutorService.class).newInstance(platformBitmapFactoryG, executorSupplierD, countingMemoryCacheC, Boolean.valueOf(z2), serialExecutorServiceT);
                } catch (Throwable unused) {
                }
                if (AnimatedFactoryProvider.f546b != null) {
                    AnimatedFactoryProvider.a = true;
                }
            }
            this.t = AnimatedFactoryProvider.f546b;
        }
        return this.t;
    }

    public CountingMemoryCache<CacheKey, CloseableImage> c() {
        if (this.e == null) {
            BitmapMemoryCacheFactory bitmapMemoryCacheFactoryG = this.c.g();
            Supplier<MemoryCacheParams> supplierA = this.c.A();
            MemoryTrimmableRegistry memoryTrimmableRegistryW = this.c.w();
            MemoryCache.a aVarN = this.c.n();
            Objects.requireNonNull(this.c.getExperiments());
            Objects.requireNonNull(this.c.getExperiments());
            CountingMemoryCache.b<CacheKey> bVarR = this.c.r();
            CountingLruBitmapMemoryCacheFactory2 countingLruBitmapMemoryCacheFactory2 = (CountingLruBitmapMemoryCacheFactory2) bitmapMemoryCacheFactoryG;
            Objects.requireNonNull(countingLruBitmapMemoryCacheFactory2);
            LruCountingMemoryCache2 lruCountingMemoryCache2 = new LruCountingMemoryCache2(new CountingLruBitmapMemoryCacheFactory(countingLruBitmapMemoryCacheFactory2), aVarN, supplierA, bVarR, false, false);
            memoryTrimmableRegistryW.a(lruCountingMemoryCache2);
            this.e = lruCountingMemoryCache2;
        }
        return this.e;
    }

    public InstrumentedMemoryCache<CacheKey, CloseableImage> d() {
        if (this.f == null) {
            CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCacheC = c();
            ImageCacheStatsTracker imageCacheStatsTrackerQ = this.c.q();
            Objects.requireNonNull((NoOpImageCacheStatsTracker) imageCacheStatsTrackerQ);
            this.f = new InstrumentedMemoryCache<>(countingMemoryCacheC, new InstrumentedMemoryCacheBitmapMemoryCacheFactory(imageCacheStatsTrackerQ));
        }
        return this.f;
    }

    public InstrumentedMemoryCache<CacheKey, PooledByteBuffer> e() {
        MemoryCache<CacheKey, PooledByteBuffer> memoryCacheI;
        if (this.h == null) {
            if (this.c.i() != null) {
                memoryCacheI = this.c.i();
            } else {
                if (this.g == null) {
                    Supplier<MemoryCacheParams> supplierC = this.c.C();
                    MemoryTrimmableRegistry memoryTrimmableRegistryW = this.c.w();
                    LruCountingMemoryCache2 lruCountingMemoryCache2 = new LruCountingMemoryCache2(new EncodedCountingMemoryCacheFactory(), new NativeMemoryCacheTrimStrategy(), supplierC, null, false, false);
                    memoryTrimmableRegistryW.a(lruCountingMemoryCache2);
                    this.g = lruCountingMemoryCache2;
                }
                memoryCacheI = this.g;
            }
            ImageCacheStatsTracker imageCacheStatsTrackerQ = this.c.q();
            Objects.requireNonNull((NoOpImageCacheStatsTracker) imageCacheStatsTrackerQ);
            this.h = new InstrumentedMemoryCache<>(memoryCacheI, new EncodedMemoryCacheFactory(imageCacheStatsTrackerQ));
        }
        return this.h;
    }

    public BufferedDiskCache2 f() {
        if (this.i == null) {
            if (this.j == null) {
                this.j = ((DiskStorageCacheFactory) this.c.e()).a(this.c.j());
            }
            this.i = new BufferedDiskCache2(this.j, this.c.a().c(this.c.c()), this.c.a().d(), this.c.D().e(), this.c.D().d(), this.c.q());
        }
        return this.i;
    }

    public PlatformBitmapFactory g() {
        if (this.r == null) {
            PoolFactory poolFactoryA = this.c.a();
            h();
            this.r = new ArtBitmapFactory(poolFactoryA.a(), this.d);
        }
        return this.r;
    }

    public PlatformDecoder h() {
        PlatformDecoder artDecoder;
        if (this.f578s == null) {
            PoolFactory poolFactoryA = this.c.a();
            Objects.requireNonNull(this.c.getExperiments());
            if (Build.VERSION.SDK_INT >= 26) {
                int iB = poolFactoryA.b();
                artDecoder = new OreoDecoder(poolFactoryA.a(), iB, new Pools.SynchronizedPool(iB));
            } else {
                int iB2 = poolFactoryA.b();
                artDecoder = new ArtDecoder(poolFactoryA.a(), iB2, new Pools.SynchronizedPool(iB2));
            }
            this.f578s = artDecoder;
        }
        return this.f578s;
    }

    public final BufferedDiskCache2 i() {
        if (this.p == null) {
            if (this.q == null) {
                this.q = ((DiskStorageCacheFactory) this.c.e()).a(this.c.p());
            }
            this.p = new BufferedDiskCache2(this.q, this.c.a().c(this.c.c()), this.c.a().d(), this.c.D().e(), this.c.D().d(), this.c.q());
        }
        return this.p;
    }
}
