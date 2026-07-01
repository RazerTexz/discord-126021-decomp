package b.f.j.e;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.Suppliers2;
import b.f.d.f.MediaUtils;
import b.f.d.m.WebpBitmapFactory;
import b.f.d.m.WebpSupportStatus;
import b.f.j.c.BufferedDiskCache2;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.MemoryCache;
import b.f.j.j.CloseableImage;
import b.f.j.j.EncodedImage2;
import b.f.j.p.AddImageTransformMetaDataProducer;
import b.f.j.p.BitmapMemoryCacheGetProducer;
import b.f.j.p.BitmapMemoryCacheKeyMultiplexProducer;
import b.f.j.p.BitmapMemoryCacheProducer;
import b.f.j.p.BitmapPrepareProducer;
import b.f.j.p.BitmapProbeProducer;
import b.f.j.p.BranchOnSeparateImagesProducer;
import b.f.j.p.DataFetchProducer;
import b.f.j.p.DecodeProducer;
import b.f.j.p.DelayProducer;
import b.f.j.p.DiskCacheReadProducer3;
import b.f.j.p.DiskCacheWriteProducer;
import b.f.j.p.EncodedCacheKeyMultiplexProducer;
import b.f.j.p.EncodedMemoryCacheProducer;
import b.f.j.p.EncodedProbeProducer;
import b.f.j.p.LocalAssetFetchProducer;
import b.f.j.p.LocalContentUriFetchProducer;
import b.f.j.p.LocalContentUriThumbnailFetchProducer;
import b.f.j.p.LocalFileFetchProducer;
import b.f.j.p.LocalResourceFetchProducer;
import b.f.j.p.LocalThumbnailBitmapProducer;
import b.f.j.p.LocalVideoThumbnailProducer;
import b.f.j.p.NetworkFetchProducer;
import b.f.j.p.NetworkFetcher2;
import b.f.j.p.PartialDiskCacheProducer3;
import b.f.j.p.PostprocessedBitmapMemoryCacheProducer;
import b.f.j.p.PostprocessorProducer;
import b.f.j.p.Producer2;
import b.f.j.p.QualifiedResourceFetchProducer;
import b.f.j.p.ThreadHandoffProducer;
import b.f.j.p.ThreadHandoffProducerQueue;
import b.f.j.p.ThrottlingProducer;
import b.f.j.p.ThumbnailBranchProducer;
import b.f.j.p.ThumbnailProducer;
import b.f.j.r.FrescoSystrace;
import b.f.j.s.ImageTranscoderFactory;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.producers.LocalExifThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.e.q, reason: use source file name */
/* JADX INFO: compiled from: ProducerSequenceFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class ProducerSequenceFactory {
    public final ContentResolver a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProducerFactory f583b;
    public final NetworkFetcher2 c;
    public final boolean d;
    public final boolean e;
    public final ThreadHandoffProducerQueue f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final ImageTranscoderFactory j;
    public final boolean k;
    public final boolean l;
    public final boolean m;

    @Nullable
    @VisibleForTesting
    public Producer2<CloseableReference<CloseableImage>> n;

    @Nullable
    public Producer2<EncodedImage2> o;

    @Nullable
    @VisibleForTesting
    public Producer2<CloseableReference<CloseableImage>> p;

    @Nullable
    @VisibleForTesting
    public Producer2<CloseableReference<CloseableImage>> q;

    @Nullable
    @VisibleForTesting
    public Producer2<CloseableReference<CloseableImage>> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    @VisibleForTesting
    public Producer2<CloseableReference<CloseableImage>> f584s;

    @Nullable
    @VisibleForTesting
    public Producer2<CloseableReference<CloseableImage>> t;

    @Nullable
    @VisibleForTesting
    public Producer2<CloseableReference<CloseableImage>> u;

    @Nullable
    @VisibleForTesting
    public Producer2<CloseableReference<CloseableImage>> v;

    @Nullable
    @VisibleForTesting
    public Producer2<CloseableReference<CloseableImage>> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @VisibleForTesting
    public Map<Producer2<CloseableReference<CloseableImage>>, Producer2<CloseableReference<CloseableImage>>> f585x = new HashMap();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @VisibleForTesting
    public Map<Producer2<CloseableReference<CloseableImage>>, Producer2<CloseableReference<CloseableImage>>> f586y;

    public ProducerSequenceFactory(ContentResolver contentResolver, ProducerFactory producerFactory, NetworkFetcher2 networkFetcher2, boolean z2, boolean z3, ThreadHandoffProducerQueue threadHandoffProducerQueue, boolean z4, boolean z5, boolean z6, boolean z7, ImageTranscoderFactory imageTranscoderFactory, boolean z8, boolean z9, boolean z10) {
        this.a = contentResolver;
        this.f583b = producerFactory;
        this.c = networkFetcher2;
        this.d = z2;
        new HashMap();
        this.f586y = new HashMap();
        this.f = threadHandoffProducerQueue;
        this.g = z4;
        this.h = z5;
        this.e = z6;
        this.i = z7;
        this.j = imageTranscoderFactory;
        this.k = z8;
        this.l = z9;
        this.m = z10;
    }

    public final synchronized Producer2<EncodedImage2> a() {
        FrescoSystrace.b();
        if (this.o == null) {
            FrescoSystrace.b();
            ProducerFactory producerFactory = this.f583b;
            AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(m(new NetworkFetchProducer(producerFactory.k, producerFactory.d, this.c)));
            this.o = addImageTransformMetaDataProducer;
            this.o = this.f583b.a(addImageTransformMetaDataProducer, this.d && !this.g, this.j);
            FrescoSystrace.b();
        }
        FrescoSystrace.b();
        return this.o;
    }

    public final synchronized Producer2<CloseableReference<CloseableImage>> b() {
        if (this.u == null) {
            DataFetchProducer dataFetchProducer = new DataFetchProducer(this.f583b.k);
            WebpBitmapFactory webpBitmapFactory = WebpSupportStatus.a;
            this.u = j(this.f583b.a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this.j));
        }
        return this.u;
    }

    public Producer2<CloseableReference<CloseableImage>> c(ImageRequest imageRequest) {
        Producer2<CloseableReference<CloseableImage>> producer2G;
        DelayProducer delayProducer;
        FrescoSystrace.b();
        try {
            FrescoSystrace.b();
            Objects.requireNonNull(imageRequest);
            Uri uri = imageRequest.c;
            AnimatableValueParser.y(uri, "Uri is null.");
            int i = imageRequest.d;
            if (i != 0) {
                boolean z2 = false;
                switch (i) {
                    case 2:
                        producer2G = g();
                        break;
                    case 3:
                        synchronized (this) {
                            if (this.p == null) {
                                ProducerFactory producerFactory = this.f583b;
                                this.p = k(new LocalFileFetchProducer(producerFactory.j.e(), producerFactory.k));
                            }
                            producer2G = this.p;
                        }
                        break;
                    case 4:
                        if (imageRequest.h && Build.VERSION.SDK_INT >= 29) {
                            synchronized (this) {
                                if (this.v == null) {
                                    ProducerFactory producerFactory2 = this.f583b;
                                    this.v = i(new LocalThumbnailBitmapProducer(producerFactory2.j.c(), producerFactory2.a));
                                }
                                producer2G = this.v;
                            }
                        } else {
                            String type = this.a.getType(uri);
                            Map<String, String> map = MediaUtils.a;
                            if (type != null && type.startsWith("video/")) {
                                z2 = true;
                            }
                            producer2G = !z2 ? e() : g();
                        }
                        break;
                    case 5:
                        producer2G = d();
                        break;
                    case 6:
                        producer2G = f();
                        break;
                    case 7:
                        producer2G = b();
                        break;
                    case 8:
                        producer2G = h();
                        break;
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unsupported uri scheme! Uri is: ");
                        String strValueOf = String.valueOf(uri);
                        if (strValueOf.length() > 30) {
                            strValueOf = strValueOf.substring(0, 30) + "...";
                        }
                        sb.append(strValueOf);
                        throw new IllegalArgumentException(sb.toString());
                }
            } else {
                synchronized (this) {
                    FrescoSystrace.b();
                    if (this.n == null) {
                        FrescoSystrace.b();
                        this.n = j(a());
                        FrescoSystrace.b();
                    }
                    FrescoSystrace.b();
                    producer2G = this.n;
                }
            }
            FrescoSystrace.b();
            if (imageRequest.f2903s != null) {
                synchronized (this) {
                    Producer2<CloseableReference<CloseableImage>> producer2 = this.f585x.get(producer2G);
                    if (producer2 == null) {
                        ProducerFactory producerFactory3 = this.f583b;
                        PostprocessorProducer postprocessorProducer = new PostprocessorProducer(producer2G, producerFactory3.f580s, producerFactory3.j.c());
                        ProducerFactory producerFactory4 = this.f583b;
                        PostprocessedBitmapMemoryCacheProducer postprocessedBitmapMemoryCacheProducer = new PostprocessedBitmapMemoryCacheProducer(producerFactory4.o, producerFactory4.p, postprocessorProducer);
                        this.f585x.put(producer2G, postprocessedBitmapMemoryCacheProducer);
                        producer2G = postprocessedBitmapMemoryCacheProducer;
                    } else {
                        producer2G = producer2;
                    }
                }
            }
            if (this.h) {
                synchronized (this) {
                    Producer2<CloseableReference<CloseableImage>> producer3 = this.f586y.get(producer2G);
                    if (producer3 == null) {
                        ProducerFactory producerFactory5 = this.f583b;
                        BitmapPrepareProducer bitmapPrepareProducer = new BitmapPrepareProducer(producer2G, producerFactory5.t, producerFactory5.u, producerFactory5.v);
                        this.f586y.put(producer2G, bitmapPrepareProducer);
                        producer2G = bitmapPrepareProducer;
                    } else {
                        producer2G = producer3;
                    }
                }
            }
            if (this.m && imageRequest.u > 0) {
                synchronized (this) {
                    delayProducer = new DelayProducer(producer2G, this.f583b.j.g());
                }
                producer2G = delayProducer;
            }
            FrescoSystrace.b();
            return producer2G;
        } catch (Throwable th) {
            FrescoSystrace.b();
            throw th;
        }
    }

    public final synchronized Producer2<CloseableReference<CloseableImage>> d() {
        if (this.t == null) {
            ProducerFactory producerFactory = this.f583b;
            this.t = k(new LocalAssetFetchProducer(producerFactory.j.e(), producerFactory.k, producerFactory.c));
        }
        return this.t;
    }

    public final synchronized Producer2<CloseableReference<CloseableImage>> e() {
        if (this.r == null) {
            ProducerFactory producerFactory = this.f583b;
            LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory.j.e(), producerFactory.k, producerFactory.a);
            ProducerFactory producerFactory2 = this.f583b;
            Objects.requireNonNull(producerFactory2);
            ProducerFactory producerFactory3 = this.f583b;
            this.r = l(localContentUriFetchProducer, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(producerFactory2.j.e(), producerFactory2.k, producerFactory2.a), new LocalExifThumbnailProducer(producerFactory3.j.f(), producerFactory3.k, producerFactory3.a)});
        }
        return this.r;
    }

    public final synchronized Producer2<CloseableReference<CloseableImage>> f() {
        if (this.f584s == null) {
            ProducerFactory producerFactory = this.f583b;
            this.f584s = k(new LocalResourceFetchProducer(producerFactory.j.e(), producerFactory.k, producerFactory.f579b));
        }
        return this.f584s;
    }

    public final synchronized Producer2<CloseableReference<CloseableImage>> g() {
        if (this.q == null) {
            ProducerFactory producerFactory = this.f583b;
            this.q = i(new LocalVideoThumbnailProducer(producerFactory.j.e(), producerFactory.a));
        }
        return this.q;
    }

    public final synchronized Producer2<CloseableReference<CloseableImage>> h() {
        if (this.w == null) {
            ProducerFactory producerFactory = this.f583b;
            this.w = k(new QualifiedResourceFetchProducer(producerFactory.j.e(), producerFactory.k, producerFactory.a));
        }
        return this.w;
    }

    public final Producer2<CloseableReference<CloseableImage>> i(Producer2<CloseableReference<CloseableImage>> producer2) {
        ProducerFactory producerFactory = this.f583b;
        MemoryCache<CacheKey, CloseableImage> memoryCache = producerFactory.o;
        CacheKeyFactory cacheKeyFactory = producerFactory.p;
        BitmapMemoryCacheKeyMultiplexProducer bitmapMemoryCacheKeyMultiplexProducer = new BitmapMemoryCacheKeyMultiplexProducer(cacheKeyFactory, new BitmapMemoryCacheProducer(memoryCache, cacheKeyFactory, producer2));
        ProducerFactory producerFactory2 = this.f583b;
        ThreadHandoffProducerQueue threadHandoffProducerQueue = this.f;
        Objects.requireNonNull(producerFactory2);
        ThreadHandoffProducer threadHandoffProducer = new ThreadHandoffProducer(bitmapMemoryCacheKeyMultiplexProducer, threadHandoffProducerQueue);
        if (!this.k && !this.l) {
            ProducerFactory producerFactory3 = this.f583b;
            return new BitmapMemoryCacheGetProducer(producerFactory3.o, producerFactory3.p, threadHandoffProducer);
        }
        ProducerFactory producerFactory4 = this.f583b;
        MemoryCache<CacheKey, CloseableImage> memoryCache2 = producerFactory4.o;
        CacheKeyFactory cacheKeyFactory2 = producerFactory4.p;
        return new BitmapProbeProducer(producerFactory4.n, producerFactory4.l, producerFactory4.m, cacheKeyFactory2, producerFactory4.q, producerFactory4.r, new BitmapMemoryCacheGetProducer(memoryCache2, cacheKeyFactory2, threadHandoffProducer));
    }

    public final Producer2<CloseableReference<CloseableImage>> j(Producer2<EncodedImage2> producer2) {
        FrescoSystrace.b();
        ProducerFactory producerFactory = this.f583b;
        Producer2<CloseableReference<CloseableImage>> producer2I = i(new DecodeProducer(producerFactory.d, producerFactory.j.a(), producerFactory.e, producerFactory.f, producerFactory.g, producerFactory.h, producerFactory.i, producer2, producerFactory.f581x, producerFactory.w, null, Suppliers2.a));
        FrescoSystrace.b();
        return producer2I;
    }

    public final Producer2<CloseableReference<CloseableImage>> k(Producer2<EncodedImage2> producer2) {
        ProducerFactory producerFactory = this.f583b;
        return l(producer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory.j.f(), producerFactory.k, producerFactory.a)});
    }

    public final Producer2<CloseableReference<CloseableImage>> l(Producer2<EncodedImage2> producer2, ThumbnailProducer<EncodedImage2>[] thumbnailProducerArr) {
        ThrottlingProducer throttlingProducer = new ThrottlingProducer(5, this.f583b.j.b(), this.f583b.a(new AddImageTransformMetaDataProducer(m(producer2)), true, this.j));
        Objects.requireNonNull(this.f583b);
        return j(new BranchOnSeparateImagesProducer(this.f583b.a(new ThumbnailBranchProducer(thumbnailProducerArr), true, this.j), throttlingProducer));
    }

    public final Producer2<EncodedImage2> m(Producer2<EncodedImage2> producer2) {
        DiskCacheWriteProducer diskCacheWriteProducer;
        WebpBitmapFactory webpBitmapFactory = WebpSupportStatus.a;
        if (this.i) {
            FrescoSystrace.b();
            if (this.e) {
                ProducerFactory producerFactory = this.f583b;
                BufferedDiskCache2 bufferedDiskCache2 = producerFactory.l;
                CacheKeyFactory cacheKeyFactory = producerFactory.p;
                diskCacheWriteProducer = new DiskCacheWriteProducer(bufferedDiskCache2, producerFactory.m, cacheKeyFactory, new PartialDiskCacheProducer3(bufferedDiskCache2, cacheKeyFactory, producerFactory.k, producerFactory.d, producer2));
            } else {
                ProducerFactory producerFactory2 = this.f583b;
                diskCacheWriteProducer = new DiskCacheWriteProducer(producerFactory2.l, producerFactory2.m, producerFactory2.p, producer2);
            }
            ProducerFactory producerFactory3 = this.f583b;
            DiskCacheReadProducer3 diskCacheReadProducer3 = new DiskCacheReadProducer3(producerFactory3.l, producerFactory3.m, producerFactory3.p, diskCacheWriteProducer);
            FrescoSystrace.b();
            producer2 = diskCacheReadProducer3;
        }
        ProducerFactory producerFactory4 = this.f583b;
        MemoryCache<CacheKey, PooledByteBuffer> memoryCache = producerFactory4.n;
        CacheKeyFactory cacheKeyFactory2 = producerFactory4.p;
        EncodedMemoryCacheProducer encodedMemoryCacheProducer = new EncodedMemoryCacheProducer(memoryCache, cacheKeyFactory2, producer2);
        if (!this.l) {
            return new EncodedCacheKeyMultiplexProducer(cacheKeyFactory2, producerFactory4.f582y, encodedMemoryCacheProducer);
        }
        return new EncodedCacheKeyMultiplexProducer(cacheKeyFactory2, producerFactory4.f582y, new EncodedProbeProducer(producerFactory4.l, producerFactory4.m, cacheKeyFactory2, producerFactory4.q, producerFactory4.r, encodedMemoryCacheProducer));
    }
}
