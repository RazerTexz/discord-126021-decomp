package b.f.j.p;

import b.f.d.d.ImmutableMap;
import b.f.d.g.PooledByteBufferFactory;
import b.f.j.d.ResizeOptions;
import b.f.j.j.EncodedImage2;
import b.f.j.p.JobScheduler;
import b.f.j.s.ImageTranscodeResult;
import b.f.j.s.ImageTranscoderFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.f.j.p.c1, reason: use source file name */
/* JADX INFO: compiled from: ResizeAndRotateProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class ResizeAndRotateProducer implements Producer2<EncodedImage2> {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PooledByteBufferFactory f607b;
    public final Producer2<EncodedImage2> c;
    public final boolean d;
    public final ImageTranscoderFactory e;

    /* JADX INFO: renamed from: b.f.j.p.c1$a */
    /* JADX INFO: compiled from: ResizeAndRotateProducer.java */
    public class a extends DelegatingConsumer<EncodedImage2, EncodedImage2> {
        public final boolean c;
        public final ImageTranscoderFactory d;
        public final ProducerContext e;
        public boolean f;
        public final JobScheduler g;

        /* JADX INFO: renamed from: b.f.j.p.c1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ResizeAndRotateProducer.java */
        public class C0025a implements JobScheduler.c {
            public C0025a(ResizeAndRotateProducer resizeAndRotateProducer) {
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
            /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
                jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v8 boolean
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
                	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
                */
            @Override // b.f.j.p.JobScheduler.c
            public void a(b.f.j.j.EncodedImage2 r14, int r15) {
                /*
                    r13 = this;
                    b.f.j.p.c1$a r0 = b.f.j.p.ResizeAndRotateProducer.a.this
                    b.f.j.s.c r1 = r0.d
                    r14.x()
                    b.f.i.c r2 = r14.l
                    b.f.j.p.c1$a r3 = b.f.j.p.ResizeAndRotateProducer.a.this
                    boolean r3 = r3.c
                    b.f.j.s.b r1 = r1.createImageTranscoder(r2, r3)
                    java.util.Objects.requireNonNull(r1)
                    b.f.j.p.x0 r2 = r0.e
                    b.f.j.p.z0 r2 = r2.o()
                    b.f.j.p.x0 r3 = r0.e
                    java.lang.String r11 = "ResizeAndRotateProducer"
                    r2.e(r3, r11)
                    b.f.j.p.x0 r2 = r0.e
                    com.facebook.imagepipeline.request.ImageRequest r2 = r2.e()
                    b.f.j.p.c1 r3 = b.f.j.p.ResizeAndRotateProducer.this
                    b.f.d.g.g r3 = r3.f607b
                    b.f.d.g.i r3 = r3.a()
                    r12 = 0
                    b.f.j.d.f r7 = r2.k     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    b.f.j.d.e r8 = r2.j     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    r9 = 0
                    r4 = 85
                    java.lang.Integer r10 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    r4 = r1
                    r5 = r14
                    r6 = r3
                    b.f.j.s.a r4 = r4.c(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    int r5 = r4.a     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    r6 = 2
                    if (r5 == r6) goto L94
                    b.f.j.d.e r2 = r2.j     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    java.lang.String r1 = r1.a()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    java.util.Map r12 = r0.n(r14, r2, r4, r1)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    r14 = r3
                    com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream r14 = (com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream) r14     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    b.f.j.l.t r14 = r14.b()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    com.facebook.common.references.CloseableReference r14 = com.facebook.common.references.CloseableReference.A(r14)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    b.f.j.j.e r1 = new b.f.j.j.e     // Catch: java.lang.Throwable -> L8d
                    r1.<init>(r14)     // Catch: java.lang.Throwable -> L8d
                    b.f.i.c r2 = b.f.i.DefaultImageFormats.a     // Catch: java.lang.Throwable -> L8d
                    r1.l = r2     // Catch: java.lang.Throwable -> L8d
                    r1.q()     // Catch: java.lang.Throwable -> L88
                    b.f.j.p.x0 r2 = r0.e     // Catch: java.lang.Throwable -> L88
                    b.f.j.p.z0 r2 = r2.o()     // Catch: java.lang.Throwable -> L88
                    b.f.j.p.x0 r5 = r0.e     // Catch: java.lang.Throwable -> L88
                    r2.j(r5, r11, r12)     // Catch: java.lang.Throwable -> L88
                    int r2 = r4.a     // Catch: java.lang.Throwable -> L88
                    r4 = 1
                    if (r2 == r4) goto L7a
                    r15 = r15 | 16
                L7a:
                    b.f.j.p.l<O> r2 = r0.f632b     // Catch: java.lang.Throwable -> L88
                    r2.b(r1, r15)     // Catch: java.lang.Throwable -> L88
                    r1.close()     // Catch: java.lang.Throwable -> L8d
                    if (r14 == 0) goto Lb5
                    r14.close()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    goto Lb5
                L88:
                    r2 = move-exception
                    r1.close()     // Catch: java.lang.Throwable -> L8d
                    throw r2     // Catch: java.lang.Throwable -> L8d
                L8d:
                    r1 = move-exception
                    if (r14 == 0) goto L93
                    r14.close()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                L93:
                    throw r1     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                L94:
                    java.lang.RuntimeException r14 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    java.lang.String r1 = "Error while transcoding the image"
                    r14.<init>(r1)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    throw r14     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                L9c:
                    r14 = move-exception
                    goto Lb9
                L9e:
                    r14 = move-exception
                    b.f.j.p.x0 r1 = r0.e     // Catch: java.lang.Throwable -> L9c
                    b.f.j.p.z0 r1 = r1.o()     // Catch: java.lang.Throwable -> L9c
                    b.f.j.p.x0 r2 = r0.e     // Catch: java.lang.Throwable -> L9c
                    r1.k(r2, r11, r14, r12)     // Catch: java.lang.Throwable -> L9c
                    boolean r15 = b.f.j.p.BaseConsumer.e(r15)     // Catch: java.lang.Throwable -> L9c
                    if (r15 == 0) goto Lb5
                    b.f.j.p.l<O> r15 = r0.f632b     // Catch: java.lang.Throwable -> L9c
                    r15.c(r14)     // Catch: java.lang.Throwable -> L9c
                Lb5:
                    r3.close()
                    return
                Lb9:
                    r3.close()
                    throw r14
                */
                throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.ResizeAndRotateProducer.a.C0025a.a(b.f.j.j.e, int):void");
            }
        }

        /* JADX INFO: renamed from: b.f.j.p.c1$a$b */
        /* JADX INFO: compiled from: ResizeAndRotateProducer.java */
        public class b extends BaseProducerContextCallbacks {
            public final /* synthetic */ Consumer2 a;

            public b(ResizeAndRotateProducer resizeAndRotateProducer, Consumer2 consumer2) {
                this.a = consumer2;
            }

            @Override // b.f.j.p.ProducerContextCallbacks
            public void a() {
                a.this.g.a();
                a.this.f = true;
                this.a.d();
            }

            @Override // b.f.j.p.BaseProducerContextCallbacks, b.f.j.p.ProducerContextCallbacks
            public void b() {
                if (a.this.e.p()) {
                    a.this.g.d();
                }
            }
        }

        public a(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext, boolean z2, ImageTranscoderFactory imageTranscoderFactory) {
            super(consumer2);
            this.f = false;
            this.e = producerContext;
            Objects.requireNonNull(producerContext.e());
            this.c = z2;
            this.d = imageTranscoderFactory;
            this.g = new JobScheduler(ResizeAndRotateProducer.this.a, new C0025a(ResizeAndRotateProducer.this), 100);
            producerContext.f(new b(ResizeAndRotateProducer.this, consumer2));
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
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v10 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // b.f.j.p.BaseConsumer
        public void i(java.lang.Object r10, int r11) {
            /*
                Method dump skipped, instruction units count: 258
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.ResizeAndRotateProducer.a.i(java.lang.Object, int):void");
        }

        public final Map<String, String> n(EncodedImage2 encodedImage2, ResizeOptions resizeOptions, ImageTranscodeResult imageTranscodeResult, String str) {
            String str2;
            long j;
            if (!this.e.o().g(this.e, "ResizeAndRotateProducer")) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            encodedImage2.x();
            sb.append(encodedImage2.o);
            sb.append("x");
            encodedImage2.x();
            sb.append(encodedImage2.p);
            String string = sb.toString();
            if (resizeOptions != null) {
                str2 = resizeOptions.a + "x" + resizeOptions.f566b;
            } else {
                str2 = "Unspecified";
            }
            HashMap map = new HashMap();
            encodedImage2.x();
            map.put("Image format", String.valueOf(encodedImage2.l));
            map.put("Original size", string);
            map.put("Requested size", str2);
            JobScheduler jobScheduler = this.g;
            synchronized (jobScheduler) {
                j = jobScheduler.j - jobScheduler.i;
            }
            map.put("queueTime", String.valueOf(j));
            map.put("Transcoder id", str);
            map.put("Transcoding result", String.valueOf(imageTranscodeResult));
            return new ImmutableMap(map);
        }
    }

    public ResizeAndRotateProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer2<EncodedImage2> producer2, boolean z2, ImageTranscoderFactory imageTranscoderFactory) {
        Objects.requireNonNull(executor);
        this.a = executor;
        Objects.requireNonNull(pooledByteBufferFactory);
        this.f607b = pooledByteBufferFactory;
        Objects.requireNonNull(producer2);
        this.c = producer2;
        Objects.requireNonNull(imageTranscoderFactory);
        this.e = imageTranscoderFactory;
        this.d = z2;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        this.c.b(new a(consumer2, producerContext, this.d, this.e), producerContext);
    }
}
