package b.f.j.p;

import b.f.j.c.BoundedLinkedHashSet;
import b.f.j.c.BufferedDiskCache2;
import b.f.j.c.CacheKeyFactory;
import b.f.j.j.EncodedImage2;
import b.f.j.r.FrescoSystrace;
import com.facebook.cache.common.CacheKey;

/* JADX INFO: renamed from: b.f.j.p.w, reason: use source file name */
/* JADX INFO: compiled from: EncodedProbeProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class EncodedProbeProducer implements Producer2<EncodedImage2> {
    public final BufferedDiskCache2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BufferedDiskCache2 f641b;
    public final CacheKeyFactory c;
    public final Producer2<EncodedImage2> d;
    public final BoundedLinkedHashSet<CacheKey> e;
    public final BoundedLinkedHashSet<CacheKey> f;

    /* JADX INFO: renamed from: b.f.j.p.w$a */
    /* JADX INFO: compiled from: EncodedProbeProducer.java */
    public static class a extends DelegatingConsumer<EncodedImage2, EncodedImage2> {
        public final ProducerContext c;
        public final BufferedDiskCache2 d;
        public final BufferedDiskCache2 e;
        public final CacheKeyFactory f;
        public final BoundedLinkedHashSet<CacheKey> g;
        public final BoundedLinkedHashSet<CacheKey> h;

        public a(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext, BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache3, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet2) {
            super(consumer2);
            this.c = producerContext;
            this.d = bufferedDiskCache2;
            this.e = bufferedDiskCache3;
            this.f = cacheKeyFactory;
            this.g = boundedLinkedHashSet;
            this.h = boundedLinkedHashSet2;
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
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r6v3 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // b.f.j.p.BaseConsumer
        public void i(java.lang.Object r6, int r7) {
            /*
                r5 = this;
                b.f.j.j.e r6 = (b.f.j.j.EncodedImage2) r6
                java.lang.String r0 = "origin"
                b.f.j.r.FrescoSystrace.b()     // Catch: java.lang.Throwable -> L8b
                boolean r1 = b.f.j.p.BaseConsumer.f(r7)     // Catch: java.lang.Throwable -> L8b
                if (r1 != 0) goto L82
                if (r6 == 0) goto L82
                r1 = 10
                boolean r1 = b.f.j.p.BaseConsumer.l(r7, r1)     // Catch: java.lang.Throwable -> L8b
                if (r1 != 0) goto L82
                r6.x()     // Catch: java.lang.Throwable -> L8b
                b.f.i.c r1 = r6.l     // Catch: java.lang.Throwable -> L8b
                b.f.i.c r2 = b.f.i.ImageFormat.a     // Catch: java.lang.Throwable -> L8b
                if (r1 != r2) goto L21
                goto L82
            L21:
                b.f.j.p.x0 r1 = r5.c     // Catch: java.lang.Throwable -> L8b
                com.facebook.imagepipeline.request.ImageRequest r1 = r1.e()     // Catch: java.lang.Throwable -> L8b
                b.f.j.c.i r2 = r5.f     // Catch: java.lang.Throwable -> L8b
                b.f.j.p.x0 r3 = r5.c     // Catch: java.lang.Throwable -> L8b
                java.lang.Object r3 = r3.b()     // Catch: java.lang.Throwable -> L8b
                b.f.j.c.n r2 = (b.f.j.c.DefaultCacheKeyFactory) r2     // Catch: java.lang.Throwable -> L8b
                com.facebook.cache.common.CacheKey r2 = r2.b(r1, r3)     // Catch: java.lang.Throwable -> L8b
                b.f.j.c.d<com.facebook.cache.common.CacheKey> r3 = r5.g     // Catch: java.lang.Throwable -> L8b
                r3.a(r2)     // Catch: java.lang.Throwable -> L8b
                java.lang.String r3 = "memory_encoded"
                b.f.j.p.x0 r4 = r5.c     // Catch: java.lang.Throwable -> L8b
                java.lang.Object r4 = r4.l(r0)     // Catch: java.lang.Throwable -> L8b
                boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L8b
                if (r3 == 0) goto L69
                b.f.j.c.d<com.facebook.cache.common.CacheKey> r0 = r5.h     // Catch: java.lang.Throwable -> L8b
                boolean r0 = r0.b(r2)     // Catch: java.lang.Throwable -> L8b
                if (r0 != 0) goto L7c
                com.facebook.imagepipeline.request.ImageRequest$b r0 = r1.f2902b     // Catch: java.lang.Throwable -> L8b
                com.facebook.imagepipeline.request.ImageRequest$b r1 = com.facebook.imagepipeline.request.ImageRequest.b.SMALL     // Catch: java.lang.Throwable -> L8b
                if (r0 != r1) goto L58
                r0 = 1
                goto L59
            L58:
                r0 = 0
            L59:
                if (r0 == 0) goto L5e
                b.f.j.c.f r0 = r5.e     // Catch: java.lang.Throwable -> L8b
                goto L60
            L5e:
                b.f.j.c.f r0 = r5.d     // Catch: java.lang.Throwable -> L8b
            L60:
                r0.c(r2)     // Catch: java.lang.Throwable -> L8b
                b.f.j.c.d<com.facebook.cache.common.CacheKey> r0 = r5.h     // Catch: java.lang.Throwable -> L8b
                r0.a(r2)     // Catch: java.lang.Throwable -> L8b
                goto L7c
            L69:
                java.lang.String r1 = "disk"
                b.f.j.p.x0 r3 = r5.c     // Catch: java.lang.Throwable -> L8b
                java.lang.Object r0 = r3.l(r0)     // Catch: java.lang.Throwable -> L8b
                boolean r0 = r1.equals(r0)     // Catch: java.lang.Throwable -> L8b
                if (r0 == 0) goto L7c
                b.f.j.c.d<com.facebook.cache.common.CacheKey> r0 = r5.h     // Catch: java.lang.Throwable -> L8b
                r0.a(r2)     // Catch: java.lang.Throwable -> L8b
            L7c:
                b.f.j.p.l<O> r0 = r5.f632b     // Catch: java.lang.Throwable -> L8b
                r0.b(r6, r7)     // Catch: java.lang.Throwable -> L8b
                goto L87
            L82:
                b.f.j.p.l<O> r0 = r5.f632b     // Catch: java.lang.Throwable -> L8b
                r0.b(r6, r7)     // Catch: java.lang.Throwable -> L8b
            L87:
                b.f.j.r.FrescoSystrace.b()
                return
            L8b:
                r6 = move-exception
                b.f.j.r.FrescoSystrace.b()
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.EncodedProbeProducer.a.i(java.lang.Object, int):void");
        }
    }

    public EncodedProbeProducer(BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache3, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet boundedLinkedHashSet, BoundedLinkedHashSet boundedLinkedHashSet2, Producer2<EncodedImage2> producer2) {
        this.a = bufferedDiskCache2;
        this.f641b = bufferedDiskCache3;
        this.c = cacheKeyFactory;
        this.e = boundedLinkedHashSet;
        this.f = boundedLinkedHashSet2;
        this.d = producer2;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        try {
            FrescoSystrace.b();
            ProducerListener2 producerListener2O = producerContext.o();
            producerListener2O.e(producerContext, "EncodedProbeProducer");
            a aVar = new a(consumer2, producerContext, this.a, this.f641b, this.c, this.e, this.f);
            producerListener2O.j(producerContext, "EncodedProbeProducer", null);
            FrescoSystrace.b();
            this.d.b(aVar, producerContext);
            FrescoSystrace.b();
        } finally {
            FrescoSystrace.b();
        }
    }
}
