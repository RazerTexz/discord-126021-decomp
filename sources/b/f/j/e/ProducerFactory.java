package b.f.j.e;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import b.f.d.g.ByteArrayPool;
import b.f.d.g.PooledByteBufferFactory;
import b.f.j.c.BoundedLinkedHashSet;
import b.f.j.c.BufferedDiskCache2;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.MemoryCache;
import b.f.j.h.ImageDecoder2;
import b.f.j.h.ProgressiveJpegConfig;
import b.f.j.j.CloseableImage;
import b.f.j.j.EncodedImage2;
import b.f.j.p.Producer2;
import b.f.j.p.ResizeAndRotateProducer;
import b.f.j.s.ImageTranscoderFactory;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;

/* JADX INFO: renamed from: b.f.j.e.p, reason: use source file name */
/* JADX INFO: compiled from: ProducerFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class ProducerFactory {
    public ContentResolver a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources f579b;
    public AssetManager c;
    public final ByteArrayPool d;
    public final ImageDecoder2 e;
    public final ProgressiveJpegConfig f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final ExecutorSupplier j;
    public final PooledByteBufferFactory k;
    public final BufferedDiskCache2 l;
    public final BufferedDiskCache2 m;
    public final MemoryCache<CacheKey, PooledByteBuffer> n;
    public final MemoryCache<CacheKey, CloseableImage> o;
    public final CacheKeyFactory p;
    public final BoundedLinkedHashSet<CacheKey> q;
    public final BoundedLinkedHashSet<CacheKey> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final PlatformBitmapFactory f580s;
    public final int t;
    public final int u;
    public boolean v;
    public final CloseableReferenceFactory w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f581x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f582y;

    public ProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder2 imageDecoder2, ProgressiveJpegConfig progressiveJpegConfig, boolean z2, boolean z3, boolean z4, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache3, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z5, int i3, CloseableReferenceFactory closeableReferenceFactory, boolean z6, int i4) {
        this.a = context.getApplicationContext().getContentResolver();
        this.f579b = context.getApplicationContext().getResources();
        this.c = context.getApplicationContext().getAssets();
        this.d = byteArrayPool;
        this.e = imageDecoder2;
        this.f = progressiveJpegConfig;
        this.g = z2;
        this.h = z3;
        this.i = z4;
        this.j = executorSupplier;
        this.k = pooledByteBufferFactory;
        this.o = memoryCache;
        this.n = memoryCache2;
        this.l = bufferedDiskCache2;
        this.m = bufferedDiskCache3;
        this.p = cacheKeyFactory;
        this.f580s = platformBitmapFactory;
        this.q = new BoundedLinkedHashSet<>(i4);
        this.r = new BoundedLinkedHashSet<>(i4);
        this.t = i;
        this.u = i2;
        this.v = z5;
        this.f581x = i3;
        this.w = closeableReferenceFactory;
        this.f582y = z6;
    }

    public ResizeAndRotateProducer a(Producer2<EncodedImage2> producer2, boolean z2, ImageTranscoderFactory imageTranscoderFactory) {
        return new ResizeAndRotateProducer(this.j.c(), this.k, producer2, z2, imageTranscoderFactory);
    }
}
