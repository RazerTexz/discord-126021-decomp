package b.f.j.e;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.appcompat.widget.ActivityChooserModel;
import b.f.c.CallerContextVerifier;
import b.f.d.b.SerialExecutorService;
import b.f.d.g.MemoryTrimmableRegistry;
import b.f.d.g.NoOpMemoryTrimmableRegistry;
import b.f.j.c.BitmapMemoryCacheFactory;
import b.f.j.c.BitmapMemoryCacheTrimStrategy;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.CountingLruBitmapMemoryCacheFactory2;
import b.f.j.c.CountingMemoryCache;
import b.f.j.c.DefaultCacheKeyFactory;
import b.f.j.c.DefaultEncodedMemoryCacheParamsSupplier;
import b.f.j.c.ImageCacheStatsTracker;
import b.f.j.c.MemoryCache;
import b.f.j.c.NoOpImageCacheStatsTracker;
import b.f.j.e.ImagePipelineExperiments;
import b.f.j.g.NoOpCloseableReferenceLeakTracker;
import b.f.j.h.ImageDecoder2;
import b.f.j.h.ImageDecoderConfig;
import b.f.j.h.ProgressiveJpegConfig;
import b.f.j.h.SimpleProgressiveJpegConfig;
import b.f.j.k.RequestListener;
import b.f.j.k.RequestListener2;
import b.f.j.l.PoolConfig;
import b.f.j.l.PoolFactory;
import b.f.j.p.HttpUrlConnectionNetworkFetcher;
import b.f.j.p.NetworkFetcher2;
import b.f.j.r.FrescoSystrace;
import b.f.j.s.ImageTranscoderFactory;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: b.f.j.e.j, reason: use source file name */
/* JADX INFO: compiled from: ImagePipelineConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class ImagePipelineConfig2 implements ImagePipelineConfigInterface {
    public static b a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Supplier<MemoryCacheParams> f570b;
    public final MemoryCache.a c;
    public final CacheKeyFactory d;
    public final Context e;
    public final boolean f;
    public final FileCacheFactory g;
    public final Supplier<MemoryCacheParams> h;
    public final ExecutorSupplier i;
    public final ImageCacheStatsTracker j;
    public final Supplier<Boolean> k;
    public final DiskCacheConfig l;
    public final MemoryTrimmableRegistry m;
    public final NetworkFetcher2 n;
    public final int o;
    public final PoolFactory p;
    public final ProgressiveJpegConfig q;
    public final Set<RequestListener> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Set<RequestListener2> f571s;
    public final boolean t;
    public final DiskCacheConfig u;
    public final ImagePipelineExperiments v;
    public final boolean w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final NoOpCloseableReferenceLeakTracker f572x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final BitmapMemoryCacheFactory f573y;

    /* JADX INFO: renamed from: b.f.j.e.j$a */
    /* JADX INFO: compiled from: ImagePipelineConfig.java */
    public static class a {
        public Supplier<MemoryCacheParams> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f574b;
        public DiskCacheConfig d;
        public DiskCacheConfig e;
        public boolean c = false;
        public final ImagePipelineExperiments.b f = new ImagePipelineExperiments.b(this);
        public boolean g = true;
        public NoOpCloseableReferenceLeakTracker h = new NoOpCloseableReferenceLeakTracker();

        public a(Context context, ImagePipelineConfig imagePipelineConfig) {
            Objects.requireNonNull(context);
            this.f574b = context;
        }
    }

    /* JADX INFO: renamed from: b.f.j.e.j$b */
    /* JADX INFO: compiled from: ImagePipelineConfig.java */
    public static class b {
        public b(ImagePipelineConfig imagePipelineConfig) {
        }
    }

    public ImagePipelineConfig2(a aVar, ImagePipelineConfig imagePipelineConfig) {
        DefaultCacheKeyFactory defaultCacheKeyFactory;
        NoOpImageCacheStatsTracker noOpImageCacheStatsTracker;
        FrescoSystrace.b();
        this.v = new ImagePipelineExperiments(aVar.f, null);
        Supplier<MemoryCacheParams> defaultBitmapMemoryCacheParamsSupplier = aVar.a;
        if (defaultBitmapMemoryCacheParamsSupplier == null) {
            Object systemService = aVar.f574b.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Objects.requireNonNull(systemService);
            defaultBitmapMemoryCacheParamsSupplier = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) systemService);
        }
        this.f570b = defaultBitmapMemoryCacheParamsSupplier;
        this.c = new BitmapMemoryCacheTrimStrategy();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        synchronized (DefaultCacheKeyFactory.class) {
            if (DefaultCacheKeyFactory.a == null) {
                DefaultCacheKeyFactory.a = new DefaultCacheKeyFactory();
            }
            defaultCacheKeyFactory = DefaultCacheKeyFactory.a;
        }
        this.d = defaultCacheKeyFactory;
        Context context = aVar.f574b;
        Objects.requireNonNull(context);
        this.e = context;
        this.g = new DiskStorageCacheFactory(new DynamicDefaultDiskStorageFactory());
        this.f = aVar.c;
        this.h = new DefaultEncodedMemoryCacheParamsSupplier();
        synchronized (NoOpImageCacheStatsTracker.class) {
            if (NoOpImageCacheStatsTracker.a == null) {
                NoOpImageCacheStatsTracker.a = new NoOpImageCacheStatsTracker();
            }
            noOpImageCacheStatsTracker = NoOpImageCacheStatsTracker.a;
        }
        this.j = noOpImageCacheStatsTracker;
        this.k = new ImagePipelineConfig(this);
        DiskCacheConfig diskCacheConfig = aVar.d;
        if (diskCacheConfig == null) {
            Context context2 = aVar.f574b;
            try {
                FrescoSystrace.b();
                diskCacheConfig = new DiskCacheConfig(new DiskCacheConfig.b(context2, null));
                FrescoSystrace.b();
            } finally {
                FrescoSystrace.b();
            }
        }
        this.l = diskCacheConfig;
        this.m = NoOpMemoryTrimmableRegistry.b();
        this.o = 30000;
        FrescoSystrace.b();
        this.n = new HttpUrlConnectionNetworkFetcher(30000);
        FrescoSystrace.b();
        PoolFactory poolFactory = new PoolFactory(new PoolConfig(new PoolConfig.b(null), null));
        this.p = poolFactory;
        this.q = new SimpleProgressiveJpegConfig();
        this.r = new HashSet();
        this.f571s = new HashSet();
        this.t = true;
        DiskCacheConfig diskCacheConfig2 = aVar.e;
        this.u = diskCacheConfig2 != null ? diskCacheConfig2 : diskCacheConfig;
        this.i = new DefaultExecutorSupplier(poolFactory.b());
        this.w = aVar.g;
        this.f572x = aVar.h;
        this.f573y = new CountingLruBitmapMemoryCacheFactory2();
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public Supplier<MemoryCacheParams> A() {
        return this.f570b;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public ImageDecoder2 B() {
        return null;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public Supplier<MemoryCacheParams> C() {
        return this.h;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public ExecutorSupplier D() {
        return this.i;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public PoolFactory a() {
        return this.p;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public Set<RequestListener2> b() {
        return Collections.unmodifiableSet(this.f571s);
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public int c() {
        return 0;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public Supplier<Boolean> d() {
        return this.k;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public FileCacheFactory e() {
        return this.g;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public NoOpCloseableReferenceLeakTracker f() {
        return this.f572x;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public BitmapMemoryCacheFactory g() {
        return this.f573y;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public Context getContext() {
        return this.e;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public ImagePipelineExperiments getExperiments() {
        return this.v;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public NetworkFetcher2 h() {
        return this.n;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public MemoryCache<CacheKey, PooledByteBuffer> i() {
        return null;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public DiskCacheConfig j() {
        return this.l;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public Set<RequestListener> k() {
        return Collections.unmodifiableSet(this.r);
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public CacheKeyFactory l() {
        return this.d;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public boolean m() {
        return this.t;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public MemoryCache.a n() {
        return this.c;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public ProgressiveJpegConfig o() {
        return this.q;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public DiskCacheConfig p() {
        return this.u;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public ImageCacheStatsTracker q() {
        return this.j;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public CountingMemoryCache.b<CacheKey> r() {
        return null;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public boolean s() {
        return this.f;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public SerialExecutorService t() {
        return null;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public Integer u() {
        return null;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public ImageTranscoderFactory v() {
        return null;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public MemoryTrimmableRegistry w() {
        return this.m;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public ImageDecoderConfig x() {
        return null;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public boolean y() {
        return this.w;
    }

    @Override // b.f.j.e.ImagePipelineConfigInterface
    public CallerContextVerifier z() {
        return null;
    }
}
