package b.f.j.p;

import android.graphics.Bitmap;
import androidx.core.os.EnvironmentCompat;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.ImmutableMap;
import b.f.d.e.FLog;
import b.f.d.g.ByteArrayPool;
import b.f.d.l.UriUtil;
import b.f.i.DefaultImageFormats;
import b.f.i.ImageFormat;
import b.f.j.d.ImageDecodeOptions;
import b.f.j.d.ResizeOptions;
import b.f.j.e.CloseableReferenceFactory;
import b.f.j.h.ImageDecoder2;
import b.f.j.h.ProgressiveJpegConfig;
import b.f.j.h.ProgressiveJpegParser;
import b.f.j.j.CloseableBitmap;
import b.f.j.j.CloseableImage;
import b.f.j.j.CloseableStaticBitmap;
import b.f.j.j.EncodedImage2;
import b.f.j.j.ImmutableQualityInfo;
import b.f.j.j.QualityInfo;
import b.f.j.p.JobScheduler;
import b.f.j.r.FrescoSystrace;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.imagepipeline.decoder.DecodeException;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.f.j.p.n, reason: use source file name */
/* JADX INFO: compiled from: DecodeProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class DecodeProducer implements Producer2<CloseableReference<CloseableImage>> {
    public final ByteArrayPool a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f626b;
    public final ImageDecoder2 c;
    public final ProgressiveJpegConfig d;
    public final Producer2<EncodedImage2> e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final CloseableReferenceFactory j;
    public final Runnable k;
    public final Supplier<Boolean> l;

    /* JADX INFO: renamed from: b.f.j.p.n$a */
    /* JADX INFO: compiled from: DecodeProducer.java */
    public class a extends c {
        public a(DecodeProducer decodeProducer, Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext, boolean z2, int i) {
            super(consumer2, producerContext, z2, i);
        }

        @Override // b.f.j.p.DecodeProducer.c
        public int o(EncodedImage2 encodedImage2) {
            return encodedImage2.n();
        }

        @Override // b.f.j.p.DecodeProducer.c
        public QualityInfo p() {
            return new ImmutableQualityInfo(0, false, false);
        }

        @Override // b.f.j.p.DecodeProducer.c
        public synchronized boolean w(EncodedImage2 encodedImage2, int i) {
            if (BaseConsumer.f(i)) {
                return false;
            }
            return this.g.f(encodedImage2, i);
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.n$b */
    /* JADX INFO: compiled from: DecodeProducer.java */
    public class b extends c {
        public final ProgressiveJpegParser i;
        public final ProgressiveJpegConfig j;
        public int k;

        public b(DecodeProducer decodeProducer, Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext, ProgressiveJpegParser progressiveJpegParser, ProgressiveJpegConfig progressiveJpegConfig, boolean z2, int i) {
            super(consumer2, producerContext, z2, i);
            this.i = progressiveJpegParser;
            Objects.requireNonNull(progressiveJpegConfig);
            this.j = progressiveJpegConfig;
            this.k = 0;
        }

        @Override // b.f.j.p.DecodeProducer.c
        public int o(EncodedImage2 encodedImage2) {
            return this.i.f;
        }

        @Override // b.f.j.p.DecodeProducer.c
        public QualityInfo p() {
            return this.j.a(this.i.e);
        }

        @Override // b.f.j.p.DecodeProducer.c
        public synchronized boolean w(EncodedImage2 encodedImage2, int i) {
            boolean zF = this.g.f(encodedImage2, i);
            if ((BaseConsumer.f(i) || BaseConsumer.m(i, 8)) && !BaseConsumer.m(i, 4) && EncodedImage2.u(encodedImage2)) {
                encodedImage2.x();
                if (encodedImage2.l == DefaultImageFormats.a) {
                    if (!this.i.b(encodedImage2)) {
                        return false;
                    }
                    int i2 = this.i.e;
                    int i3 = this.k;
                    if (i2 <= i3) {
                        return false;
                    }
                    if (i2 < this.j.b(i3) && !this.i.g) {
                        return false;
                    }
                    this.k = i2;
                }
            }
            return zF;
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.n$c */
    /* JADX INFO: compiled from: DecodeProducer.java */
    public abstract class c extends DelegatingConsumer<EncodedImage2, CloseableReference<CloseableImage>> {
        public final ProducerContext c;
        public final ProducerListener2 d;
        public final ImageDecodeOptions e;
        public boolean f;
        public final JobScheduler g;

        /* JADX INFO: renamed from: b.f.j.p.n$c$a */
        /* JADX INFO: compiled from: DecodeProducer.java */
        public class a implements JobScheduler.c {
            public final /* synthetic */ ProducerContext a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f627b;

            public a(DecodeProducer decodeProducer, ProducerContext producerContext, int i) {
                this.a = producerContext;
                this.f627b = i;
            }

            @Override // b.f.j.p.JobScheduler.c
            public void a(EncodedImage2 encodedImage2, int i) {
                boolean z2;
                String str;
                long j;
                CloseableImage closeableImageT;
                int i2 = i;
                if (encodedImage2 != null) {
                    ProducerContext producerContext = c.this.c;
                    encodedImage2.x();
                    producerContext.d("image_format", encodedImage2.l.f541b);
                    if (DecodeProducer.this.f || !BaseConsumer.m(i2, 16)) {
                        ImageRequest imageRequestE = this.a.e();
                        if (DecodeProducer.this.g || !UriUtil.e(imageRequestE.c)) {
                            encodedImage2.q = AnimatableValueParser.a0(imageRequestE.k, imageRequestE.j, encodedImage2, this.f627b);
                        }
                    }
                    Objects.requireNonNull(this.a.g().getExperiments());
                    c cVar = c.this;
                    Objects.requireNonNull(cVar);
                    encodedImage2.x();
                    if (encodedImage2.l == DefaultImageFormats.a || !BaseConsumer.f(i)) {
                        synchronized (cVar) {
                            z2 = cVar.f;
                        }
                        if (z2 || !EncodedImage2.u(encodedImage2)) {
                            return;
                        }
                        encodedImage2.x();
                        ImageFormat imageFormat = encodedImage2.l;
                        String str2 = imageFormat != null ? imageFormat.f541b : EnvironmentCompat.MEDIA_UNKNOWN;
                        StringBuilder sb = new StringBuilder();
                        encodedImage2.x();
                        sb.append(encodedImage2.o);
                        sb.append("x");
                        encodedImage2.x();
                        sb.append(encodedImage2.p);
                        String string = sb.toString();
                        String strValueOf = String.valueOf(encodedImage2.q);
                        boolean zE = BaseConsumer.e(i);
                        boolean z3 = zE && !BaseConsumer.m(i2, 8);
                        boolean zM = BaseConsumer.m(i2, 4);
                        ResizeOptions resizeOptions = cVar.c.e().j;
                        if (resizeOptions != null) {
                            str = resizeOptions.a + "x" + resizeOptions.f566b;
                        } else {
                            str = EnvironmentCompat.MEDIA_UNKNOWN;
                        }
                        String str3 = str;
                        try {
                            JobScheduler jobScheduler = cVar.g;
                            synchronized (jobScheduler) {
                                j = jobScheduler.j - jobScheduler.i;
                            }
                            String strValueOf2 = String.valueOf(cVar.c.e().c);
                            int iN = (z3 || zM) ? encodedImage2.n() : cVar.o(encodedImage2);
                            QualityInfo qualityInfoP = (z3 || zM) ? ImmutableQualityInfo.a : cVar.p();
                            cVar.d.e(cVar.c, "DecodeProducer");
                            try {
                                try {
                                    closeableImageT = cVar.t(encodedImage2, iN, qualityInfoP);
                                    try {
                                        if (encodedImage2.q != 1) {
                                            i2 |= 16;
                                        }
                                        cVar.d.j(cVar.c, "DecodeProducer", cVar.n(closeableImageT, j, qualityInfoP, zE, str2, string, str3, strValueOf));
                                        cVar.v(encodedImage2, closeableImageT);
                                        cVar.s(closeableImageT, i2);
                                    } catch (Exception e) {
                                        e = e;
                                        cVar.d.k(cVar.c, "DecodeProducer", e, cVar.n(closeableImageT, j, qualityInfoP, zE, str2, string, str3, strValueOf));
                                        cVar.u(true);
                                        cVar.f632b.c(e);
                                    }
                                } catch (DecodeException e2) {
                                    EncodedImage2 encodedImage2A = e2.a();
                                    FLog.o("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e2.getMessage(), strValueOf2, encodedImage2A.d(10), Integer.valueOf(encodedImage2A.n()));
                                    throw e2;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                closeableImageT = null;
                            }
                            encodedImage2.close();
                        } catch (Throwable th) {
                            encodedImage2.close();
                            throw th;
                        }
                    }
                }
            }
        }

        /* JADX INFO: renamed from: b.f.j.p.n$c$b */
        /* JADX INFO: compiled from: DecodeProducer.java */
        public class b extends BaseProducerContextCallbacks {
            public final /* synthetic */ boolean a;

            public b(DecodeProducer decodeProducer, boolean z2) {
                this.a = z2;
            }

            @Override // b.f.j.p.ProducerContextCallbacks
            public void a() {
                if (this.a) {
                    c cVar = c.this;
                    cVar.u(true);
                    cVar.f632b.d();
                }
            }

            @Override // b.f.j.p.BaseProducerContextCallbacks, b.f.j.p.ProducerContextCallbacks
            public void b() {
                if (c.this.c.p()) {
                    c.this.g.d();
                }
            }
        }

        public c(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext, boolean z2, int i) {
            super(consumer2);
            this.c = producerContext;
            this.d = producerContext.o();
            ImageDecodeOptions imageDecodeOptions = producerContext.e().i;
            this.e = imageDecodeOptions;
            this.f = false;
            this.g = new JobScheduler(DecodeProducer.this.f626b, new a(DecodeProducer.this, producerContext, i), imageDecodeOptions.f564b);
            producerContext.f(new b(DecodeProducer.this, z2));
        }

        @Override // b.f.j.p.DelegatingConsumer, b.f.j.p.BaseConsumer
        public void g() {
            q();
        }

        @Override // b.f.j.p.DelegatingConsumer, b.f.j.p.BaseConsumer
        public void h(Throwable th) {
            r(th);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0034 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:3:0x0002, B:7:0x000e, B:8:0x001e, B:10:0x0024, B:11:0x0034, B:15:0x003f, B:18:0x0047, B:20:0x004f), top: B:26:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:14:0x003e  */
        /* JADX WARN: Code duplicated, block: B:20:0x004f A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:3:0x0002, B:7:0x000e, B:8:0x001e, B:10:0x0024, B:11:0x0034, B:15:0x003f, B:18:0x0047, B:20:0x004f), top: B:26:0x0002 }] */
        @Override // b.f.j.p.BaseConsumer
        public void i(Object obj, int i) {
            EncodedImage2 encodedImage2 = (EncodedImage2) obj;
            try {
                FrescoSystrace.b();
                boolean zE = BaseConsumer.e(i);
                if (zE) {
                    if (encodedImage2 == null) {
                        ExceptionWithNoStacktrace exceptionWithNoStacktrace = new ExceptionWithNoStacktrace("Encoded image is null.");
                        u(true);
                        this.f632b.c(exceptionWithNoStacktrace);
                    } else if (!encodedImage2.t()) {
                        ExceptionWithNoStacktrace exceptionWithNoStacktrace2 = new ExceptionWithNoStacktrace("Encoded image is not valid.");
                        u(true);
                        this.f632b.c(exceptionWithNoStacktrace2);
                    } else if (w(encodedImage2, i)) {
                        boolean zM = BaseConsumer.m(i, 4);
                        if (zE) {
                            this.g.d();
                        } else {
                            this.g.d();
                        }
                    }
                } else if (w(encodedImage2, i)) {
                    boolean zM2 = BaseConsumer.m(i, 4);
                    if (zE || zM2 || this.c.p()) {
                        this.g.d();
                    }
                }
            } finally {
                FrescoSystrace.b();
            }
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // b.f.j.p.DelegatingConsumer, b.f.j.p.BaseConsumer
        public void j(float f) {
            this.f632b.a(f * 0.99f);
        }

        public final Map<String, String> n(CloseableImage closeableImage, long j, QualityInfo qualityInfo, boolean z2, String str, String str2, String str3, String str4) {
            if (!this.d.g(this.c, "DecodeProducer")) {
                return null;
            }
            String strValueOf = String.valueOf(j);
            String strValueOf2 = String.valueOf(((ImmutableQualityInfo) qualityInfo).c);
            String strValueOf3 = String.valueOf(z2);
            if (!(closeableImage instanceof CloseableStaticBitmap)) {
                HashMap map = new HashMap(7);
                map.put("queueTime", strValueOf);
                map.put("hasGoodQuality", strValueOf2);
                map.put("isFinal", strValueOf3);
                map.put("encodedImageSize", str2);
                map.put("imageFormat", str);
                map.put("requestedImageSize", str3);
                map.put("sampleSize", str4);
                return new ImmutableMap(map);
            }
            Bitmap bitmap = ((CloseableStaticBitmap) closeableImage).m;
            Objects.requireNonNull(bitmap);
            String str5 = bitmap.getWidth() + "x" + bitmap.getHeight();
            HashMap map2 = new HashMap(8);
            map2.put("bitmapSize", str5);
            map2.put("queueTime", strValueOf);
            map2.put("hasGoodQuality", strValueOf2);
            map2.put("isFinal", strValueOf3);
            map2.put("encodedImageSize", str2);
            map2.put("imageFormat", str);
            map2.put("requestedImageSize", str3);
            map2.put("sampleSize", str4);
            map2.put("byteCount", bitmap.getByteCount() + "");
            return new ImmutableMap(map2);
        }

        public abstract int o(EncodedImage2 encodedImage2);

        public abstract QualityInfo p();

        public final void q() {
            u(true);
            this.f632b.d();
        }

        public final void r(Throwable th) {
            u(true);
            this.f632b.c(th);
        }

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
        public final void s(CloseableImage closeableImage, int i) {
            CloseableReference.c cVar = DecodeProducer.this.j.a;
            Class<CloseableReference> cls = CloseableReference.j;
            CloseableReference closeableReferenceI = null;
            if (closeableImage != null) {
                closeableReferenceI = CloseableReference.I(closeableImage, CloseableReference.l, cVar, cVar.b() ? new Throwable() : null);
            }
            try {
                u(BaseConsumer.e(i));
                this.f632b.b(closeableReferenceI, i);
            } finally {
                if (closeableReferenceI != null) {
                    closeableReferenceI.close();
                }
            }
        }

        public final CloseableImage t(EncodedImage2 encodedImage2, int i, QualityInfo qualityInfo) {
            DecodeProducer decodeProducer = DecodeProducer.this;
            boolean z2 = decodeProducer.k != null && decodeProducer.l.get().booleanValue();
            try {
                return DecodeProducer.this.c.a(encodedImage2, i, qualityInfo, this.e);
            } catch (OutOfMemoryError e) {
                if (!z2) {
                    throw e;
                }
                DecodeProducer.this.k.run();
                System.gc();
                return DecodeProducer.this.c.a(encodedImage2, i, qualityInfo, this.e);
            }
        }

        public final void u(boolean z2) {
            synchronized (this) {
                if (z2) {
                    if (!this.f) {
                        this.f632b.a(1.0f);
                        this.f = true;
                        this.g.a();
                    }
                }
            }
        }

        public final void v(EncodedImage2 encodedImage2, CloseableImage closeableImage) {
            ProducerContext producerContext = this.c;
            encodedImage2.x();
            producerContext.d("encoded_width", Integer.valueOf(encodedImage2.o));
            ProducerContext producerContext2 = this.c;
            encodedImage2.x();
            producerContext2.d("encoded_height", Integer.valueOf(encodedImage2.p));
            this.c.d("encoded_size", Integer.valueOf(encodedImage2.n()));
            if (closeableImage instanceof CloseableBitmap) {
                Bitmap bitmapF = ((CloseableBitmap) closeableImage).f();
                this.c.d("bitmap_config", String.valueOf(bitmapF == null ? null : bitmapF.getConfig()));
            }
            if (closeableImage != null) {
                closeableImage.e(this.c.a());
            }
        }

        public abstract boolean w(EncodedImage2 encodedImage2, int i);
    }

    public DecodeProducer(ByteArrayPool byteArrayPool, Executor executor, ImageDecoder2 imageDecoder2, ProgressiveJpegConfig progressiveJpegConfig, boolean z2, boolean z3, boolean z4, Producer2<EncodedImage2> producer2, int i, CloseableReferenceFactory closeableReferenceFactory, Runnable runnable, Supplier<Boolean> supplier) {
        Objects.requireNonNull(byteArrayPool);
        this.a = byteArrayPool;
        Objects.requireNonNull(executor);
        this.f626b = executor;
        Objects.requireNonNull(imageDecoder2);
        this.c = imageDecoder2;
        Objects.requireNonNull(progressiveJpegConfig);
        this.d = progressiveJpegConfig;
        this.f = z2;
        this.g = z3;
        Objects.requireNonNull(producer2);
        this.e = producer2;
        this.h = z4;
        this.i = i;
        this.j = closeableReferenceFactory;
        this.k = null;
        this.l = supplier;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        try {
            FrescoSystrace.b();
            this.e.b(!UriUtil.e(producerContext.e().c) ? new a(this, consumer2, producerContext, this.h, this.i) : new b(this, consumer2, producerContext, new ProgressiveJpegParser(this.a), this.d, this.h, this.i), producerContext);
        } finally {
            FrescoSystrace.b();
        }
    }
}
