package b.f.j.p;

import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import b.f.b.a.SimpleCacheKey;
import b.f.d.d.ImmutableMap;
import b.f.d.e.FLog;
import b.f.d.g.ByteArrayPool;
import b.f.d.g.PooledByteBufferFactory;
import b.f.d.g.PooledByteBufferOutputStream;
import b.f.i.ImageFormat;
import b.f.j.c.BufferedDiskCache2;
import b.f.j.c.BufferedDiskCache3;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.DefaultCacheKeyFactory;
import b.f.j.d.BytesRange;
import b.f.j.j.EncodedImage2;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import z.Task6;

/* JADX INFO: renamed from: b.f.j.p.r0, reason: use source file name */
/* JADX INFO: compiled from: PartialDiskCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class PartialDiskCacheProducer3 implements Producer2<EncodedImage2> {
    public final BufferedDiskCache2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CacheKeyFactory f635b;
    public final PooledByteBufferFactory c;
    public final ByteArrayPool d;
    public final Producer2<EncodedImage2> e;

    /* JADX INFO: renamed from: b.f.j.p.r0$a */
    /* JADX INFO: compiled from: PartialDiskCacheProducer.java */
    public static class a extends DelegatingConsumer<EncodedImage2, EncodedImage2> {
        public final BufferedDiskCache2 c;
        public final CacheKey d;
        public final PooledByteBufferFactory e;
        public final ByteArrayPool f;
        public final EncodedImage2 g;
        public final boolean h;

        public a(Consumer2 consumer2, BufferedDiskCache2 bufferedDiskCache2, CacheKey cacheKey, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, EncodedImage2 encodedImage2, boolean z2, PartialDiskCacheProducer partialDiskCacheProducer) {
            super(consumer2);
            this.c = bufferedDiskCache2;
            this.d = cacheKey;
            this.e = pooledByteBufferFactory;
            this.f = byteArrayPool;
            this.g = encodedImage2;
            this.h = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [b.f.j.c.f] */
        /* JADX WARN: Type inference failed for: r3v0, types: [b.f.j.p.p, b.f.j.p.r0$a] */
        /* JADX WARN: Type inference failed for: r4v1, types: [b.f.j.j.e, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v2, types: [b.f.j.j.e] */
        /* JADX WARN: Type inference failed for: r4v5, types: [b.f.j.c.f, java.lang.Object] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // b.f.j.p.BaseConsumer
        public void i(Object obj, int i) {
            ?? r4 = (EncodedImage2) obj;
            if (BaseConsumer.f(i)) {
                return;
            }
            EncodedImage2 encodedImage2 = this.g;
            if (encodedImage2 != null && r4 != 0) {
                try {
                    if (r4.f590s != null) {
                        try {
                            p(o(encodedImage2, r4));
                        } catch (IOException e) {
                            FLog.f("PartialDiskCacheProducer", "Error while merging image data", e);
                            this.f632b.c(e);
                        }
                        r4.close();
                        this.g.close();
                        r4 = this.c;
                        CacheKey cacheKey = this.d;
                        Objects.requireNonNull(r4);
                        Objects.requireNonNull(cacheKey);
                        r4.f.c(cacheKey);
                        try {
                            Task6.a(new BufferedDiskCache3(r4, null, cacheKey), r4.e);
                            return;
                        } catch (Exception e2) {
                            FLog.n(BufferedDiskCache2.class, e2, "Failed to schedule disk-cache remove for %s", cacheKey.b());
                            Task6.c(e2);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    r4.close();
                    this.g.close();
                    throw th;
                }
            }
            if (this.h && BaseConsumer.m(i, 8) && BaseConsumer.e(i) && r4 != 0) {
                r4.x();
                if (r4.l != ImageFormat.a) {
                    this.c.f(this.d, r4);
                    this.f632b.b(r4, i);
                    return;
                }
            }
            this.f632b.b(r4, i);
        }

        public final void n(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.f.get(16384);
            int i2 = i;
            while (i2 > 0) {
                try {
                    int i3 = inputStream.read(bArr, 0, Math.min(16384, i2));
                    if (i3 < 0) {
                        break;
                    } else if (i3 > 0) {
                        outputStream.write(bArr, 0, i3);
                        i2 -= i3;
                    }
                } catch (Throwable th) {
                    this.f.release(bArr);
                    throw th;
                }
            }
            this.f.release(bArr);
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        public final PooledByteBufferOutputStream o(EncodedImage2 encodedImage2, EncodedImage2 encodedImage3) throws IOException {
            BytesRange bytesRange = encodedImage3.f590s;
            Objects.requireNonNull(bytesRange);
            int i = bytesRange.a;
            PooledByteBufferOutputStream pooledByteBufferOutputStreamE = this.e.e(encodedImage3.n() + i);
            n(encodedImage2.f(), pooledByteBufferOutputStreamE, i);
            n(encodedImage3.f(), pooledByteBufferOutputStreamE, encodedImage3.n());
            return pooledByteBufferOutputStreamE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v2, types: [b.f.j.j.e] */
        /* JADX WARN: Type inference failed for: r1v3, types: [b.f.j.j.e, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final void p(PooledByteBufferOutputStream pooledByteBufferOutputStream) throws Throwable {
            ?? encodedImage2;
            Throwable th;
            CloseableReference closeableReferenceA = CloseableReference.A(((MemoryPooledByteBufferOutputStream) pooledByteBufferOutputStream).b());
            try {
                encodedImage2 = new EncodedImage2(closeableReferenceA);
                try {
                    encodedImage2.q();
                    this.f632b.b((O) encodedImage2, 1);
                    encodedImage2.close();
                    if (closeableReferenceA != null) {
                        closeableReferenceA.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (encodedImage2 != null) {
                        encodedImage2.close();
                    }
                    if (closeableReferenceA != null) {
                        closeableReferenceA.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                encodedImage2 = null;
                th = th3;
            }
        }
    }

    public PartialDiskCacheProducer3(BufferedDiskCache2 bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, Producer2<EncodedImage2> producer2) {
        this.a = bufferedDiskCache2;
        this.f635b = cacheKeyFactory;
        this.c = pooledByteBufferFactory;
        this.d = byteArrayPool;
        this.e = producer2;
    }

    @VisibleForTesting
    public static Map<String, String> c(ProducerListener2 producerListener2, ProducerContext producerContext, boolean z2, int i) {
        if (producerListener2.g(producerContext, "PartialDiskCacheProducer")) {
            return z2 ? ImmutableMap.of("cached_value_found", String.valueOf(z2), "encodedImageSize", String.valueOf(i)) : ImmutableMap.of("cached_value_found", String.valueOf(z2));
        }
        return null;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        ImageRequest imageRequestE = producerContext.e();
        boolean zB = producerContext.e().b(16);
        ProducerListener2 producerListener2O = producerContext.o();
        producerListener2O.e(producerContext, "PartialDiskCacheProducer");
        Uri uriBuild = imageRequestE.c.buildUpon().appendQueryParameter("fresco_partial", "true").build();
        CacheKeyFactory cacheKeyFactory = this.f635b;
        producerContext.b();
        Objects.requireNonNull((DefaultCacheKeyFactory) cacheKeyFactory);
        SimpleCacheKey simpleCacheKey = new SimpleCacheKey(uriBuild.toString());
        if (!zB) {
            producerListener2O.j(producerContext, "PartialDiskCacheProducer", c(producerListener2O, producerContext, false, 0));
            d(consumer2, producerContext, simpleCacheKey, null);
        } else {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            this.a.e(simpleCacheKey, atomicBoolean).b(new PartialDiskCacheProducer(this, producerContext.o(), producerContext, consumer2, simpleCacheKey));
            producerContext.f(new PartialDiskCacheProducer2(this, atomicBoolean));
        }
    }

    public final void d(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext, CacheKey cacheKey, EncodedImage2 encodedImage2) {
        this.e.b(new a(consumer2, this.a, cacheKey, this.c, this.d, encodedImage2, producerContext.e().b(32), null), producerContext);
    }
}
