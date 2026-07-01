package b.f.j.p;

import b.f.j.c.BufferedDiskCache2;
import b.f.j.c.CacheKeyFactory;
import b.f.j.j.EncodedImage2;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: renamed from: b.f.j.p.t, reason: use source file name */
/* JADX INFO: compiled from: DiskCacheWriteProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class DiskCacheWriteProducer implements Producer2<EncodedImage2> {
    public final BufferedDiskCache2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BufferedDiskCache2 f638b;
    public final CacheKeyFactory c;
    public final Producer2<EncodedImage2> d;

    /* JADX INFO: renamed from: b.f.j.p.t$b */
    /* JADX INFO: compiled from: DiskCacheWriteProducer.java */
    public static class b extends DelegatingConsumer<EncodedImage2, EncodedImage2> {
        public final ProducerContext c;
        public final BufferedDiskCache2 d;
        public final BufferedDiskCache2 e;
        public final CacheKeyFactory f;

        public b(Consumer2 consumer2, ProducerContext producerContext, BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache3, CacheKeyFactory cacheKeyFactory, a aVar) {
            super(consumer2);
            this.c = producerContext;
            this.d = bufferedDiskCache2;
            this.e = bufferedDiskCache3;
            this.f = cacheKeyFactory;
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
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r6v2 boolean
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
                b.f.j.p.x0 r0 = r5.c
                b.f.j.p.z0 r0 = r0.o()
                b.f.j.p.x0 r1 = r5.c
                java.lang.String r2 = "DiskCacheWriteProducer"
                r0.e(r1, r2)
                boolean r0 = b.f.j.p.BaseConsumer.f(r7)
                r1 = 0
                if (r0 != 0) goto L60
                if (r6 == 0) goto L60
                r0 = 10
                boolean r0 = b.f.j.p.BaseConsumer.l(r7, r0)
                if (r0 != 0) goto L60
                r6.x()
                b.f.i.c r0 = r6.l
                b.f.i.c r3 = b.f.i.ImageFormat.a
                if (r0 != r3) goto L2a
                goto L60
            L2a:
                b.f.j.p.x0 r0 = r5.c
                com.facebook.imagepipeline.request.ImageRequest r0 = r0.e()
                b.f.j.c.i r3 = r5.f
                b.f.j.p.x0 r4 = r5.c
                java.lang.Object r4 = r4.b()
                b.f.j.c.n r3 = (b.f.j.c.DefaultCacheKeyFactory) r3
                com.facebook.cache.common.CacheKey r3 = r3.b(r0, r4)
                com.facebook.imagepipeline.request.ImageRequest$b r0 = r0.f2902b
                com.facebook.imagepipeline.request.ImageRequest$b r4 = com.facebook.imagepipeline.request.ImageRequest.b.SMALL
                if (r0 != r4) goto L4a
                b.f.j.c.f r0 = r5.e
                r0.f(r3, r6)
                goto L4f
            L4a:
                b.f.j.c.f r0 = r5.d
                r0.f(r3, r6)
            L4f:
                b.f.j.p.x0 r0 = r5.c
                b.f.j.p.z0 r0 = r0.o()
                b.f.j.p.x0 r3 = r5.c
                r0.j(r3, r2, r1)
                b.f.j.p.l<O> r0 = r5.f632b
                r0.b(r6, r7)
                goto L70
            L60:
                b.f.j.p.x0 r0 = r5.c
                b.f.j.p.z0 r0 = r0.o()
                b.f.j.p.x0 r3 = r5.c
                r0.j(r3, r2, r1)
                b.f.j.p.l<O> r0 = r5.f632b
                r0.b(r6, r7)
            L70:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.DiskCacheWriteProducer.b.i(java.lang.Object, int):void");
        }
    }

    public DiskCacheWriteProducer(BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache3, CacheKeyFactory cacheKeyFactory, Producer2<EncodedImage2> producer2) {
        this.a = bufferedDiskCache2;
        this.f638b = bufferedDiskCache3;
        this.c = cacheKeyFactory;
        this.d = producer2;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        if (producerContext.q().g() >= ImageRequest.c.DISK_CACHE.g()) {
            producerContext.i("disk", "nil-result_write");
            consumer2.b(null, 1);
        } else {
            if (producerContext.e().b(32)) {
                consumer2 = new b(consumer2, producerContext, this.a, this.f638b, this.c, null);
            }
            this.d.b(consumer2, producerContext);
        }
    }
}
