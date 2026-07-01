package b.f.j.e;

import android.content.Context;
import b.f.c.CallerContextVerifier;
import b.f.d.b.SerialExecutorService;
import b.f.d.g.MemoryTrimmableRegistry;
import b.f.j.c.BitmapMemoryCacheFactory;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.CountingMemoryCache;
import b.f.j.c.ImageCacheStatsTracker;
import b.f.j.c.MemoryCache;
import b.f.j.g.NoOpCloseableReferenceLeakTracker;
import b.f.j.h.ImageDecoder2;
import b.f.j.h.ImageDecoderConfig;
import b.f.j.h.ProgressiveJpegConfig;
import b.f.j.k.RequestListener;
import b.f.j.k.RequestListener2;
import b.f.j.l.PoolFactory;
import b.f.j.p.NetworkFetcher2;
import b.f.j.s.ImageTranscoderFactory;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.Set;

/* JADX INFO: renamed from: b.f.j.e.k, reason: use source file name */
/* JADX INFO: compiled from: ImagePipelineConfigInterface.java */
/* JADX INFO: loaded from: classes.dex */
public interface ImagePipelineConfigInterface {
    Supplier<MemoryCacheParams> A();

    ImageDecoder2 B();

    Supplier<MemoryCacheParams> C();

    ExecutorSupplier D();

    PoolFactory a();

    Set<RequestListener2> b();

    int c();

    Supplier<Boolean> d();

    FileCacheFactory e();

    NoOpCloseableReferenceLeakTracker f();

    BitmapMemoryCacheFactory g();

    Context getContext();

    ImagePipelineExperiments getExperiments();

    NetworkFetcher2 h();

    MemoryCache<CacheKey, PooledByteBuffer> i();

    DiskCacheConfig j();

    Set<RequestListener> k();

    CacheKeyFactory l();

    boolean m();

    MemoryCache.a n();

    ProgressiveJpegConfig o();

    DiskCacheConfig p();

    ImageCacheStatsTracker q();

    CountingMemoryCache.b<CacheKey> r();

    boolean s();

    SerialExecutorService t();

    Integer u();

    ImageTranscoderFactory v();

    MemoryTrimmableRegistry w();

    ImageDecoderConfig x();

    boolean y();

    CallerContextVerifier z();
}
