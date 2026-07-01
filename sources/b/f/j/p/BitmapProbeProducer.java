package b.f.j.p;

import b.f.j.c.BoundedLinkedHashSet;
import b.f.j.c.BufferedDiskCache2;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.MemoryCache;
import b.f.j.j.CloseableImage;
import b.f.j.r.FrescoSystrace;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: renamed from: b.f.j.p.j, reason: use source file name */
/* JADX INFO: compiled from: BitmapProbeProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class BitmapProbeProducer implements Producer2<CloseableReference<CloseableImage>> {
    public final MemoryCache<CacheKey, PooledByteBuffer> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BufferedDiskCache2 f617b;
    public final BufferedDiskCache2 c;
    public final CacheKeyFactory d;
    public final Producer2<CloseableReference<CloseableImage>> e;
    public final BoundedLinkedHashSet<CacheKey> f;
    public final BoundedLinkedHashSet<CacheKey> g;

    /* JADX INFO: renamed from: b.f.j.p.j$a */
    /* JADX INFO: compiled from: BitmapProbeProducer.java */
    public static class a extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public final ProducerContext c;
        public final MemoryCache<CacheKey, PooledByteBuffer> d;
        public final BufferedDiskCache2 e;
        public final BufferedDiskCache2 f;
        public final CacheKeyFactory g;
        public final BoundedLinkedHashSet<CacheKey> h;
        public final BoundedLinkedHashSet<CacheKey> i;

        public a(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext, MemoryCache<CacheKey, PooledByteBuffer> memoryCache, BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache3, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet2) {
            super(consumer2);
            this.c = producerContext;
            this.d = memoryCache;
            this.e = bufferedDiskCache2;
            this.f = bufferedDiskCache3;
            this.g = cacheKeyFactory;
            this.h = boundedLinkedHashSet;
            this.i = boundedLinkedHashSet2;
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
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v3 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // b.f.j.p.BaseConsumer
        public void i(java.lang.Object r4, int r5) {
            /*
                r3 = this;
                com.facebook.common.references.CloseableReference r4 = (com.facebook.common.references.CloseableReference) r4
                b.f.j.r.FrescoSystrace.b()     // Catch: java.lang.Throwable -> L66
                boolean r0 = b.f.j.p.BaseConsumer.f(r5)     // Catch: java.lang.Throwable -> L66
                if (r0 != 0) goto L5d
                if (r4 == 0) goto L5d
                r0 = 8
                boolean r0 = b.f.j.p.BaseConsumer.l(r5, r0)     // Catch: java.lang.Throwable -> L66
                if (r0 == 0) goto L16
                goto L5d
            L16:
                b.f.j.p.x0 r0 = r3.c     // Catch: java.lang.Throwable -> L66
                com.facebook.imagepipeline.request.ImageRequest r0 = r0.e()     // Catch: java.lang.Throwable -> L66
                b.f.j.c.i r1 = r3.g     // Catch: java.lang.Throwable -> L66
                b.f.j.p.x0 r2 = r3.c     // Catch: java.lang.Throwable -> L66
                java.lang.Object r2 = r2.b()     // Catch: java.lang.Throwable -> L66
                b.f.j.c.n r1 = (b.f.j.c.DefaultCacheKeyFactory) r1     // Catch: java.lang.Throwable -> L66
                r1.b(r0, r2)     // Catch: java.lang.Throwable -> L66
                b.f.j.p.x0 r0 = r3.c     // Catch: java.lang.Throwable -> L66
                java.lang.String r1 = "origin"
                java.lang.Object r0 = r0.l(r1)     // Catch: java.lang.Throwable -> L66
                java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L66
                if (r0 == 0) goto L57
                java.lang.String r1 = "memory_bitmap"
                boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L66
                if (r0 == 0) goto L57
                b.f.j.p.x0 r0 = r3.c     // Catch: java.lang.Throwable -> L66
                b.f.j.e.k r0 = r0.g()     // Catch: java.lang.Throwable -> L66
                b.f.j.e.l r0 = r0.getExperiments()     // Catch: java.lang.Throwable -> L66
                java.util.Objects.requireNonNull(r0)     // Catch: java.lang.Throwable -> L66
                b.f.j.p.x0 r0 = r3.c     // Catch: java.lang.Throwable -> L66
                b.f.j.e.k r0 = r0.g()     // Catch: java.lang.Throwable -> L66
                b.f.j.e.l r0 = r0.getExperiments()     // Catch: java.lang.Throwable -> L66
                java.util.Objects.requireNonNull(r0)     // Catch: java.lang.Throwable -> L66
            L57:
                b.f.j.p.l<O> r0 = r3.f632b     // Catch: java.lang.Throwable -> L66
                r0.b(r4, r5)     // Catch: java.lang.Throwable -> L66
                goto L62
            L5d:
                b.f.j.p.l<O> r0 = r3.f632b     // Catch: java.lang.Throwable -> L66
                r0.b(r4, r5)     // Catch: java.lang.Throwable -> L66
            L62:
                b.f.j.r.FrescoSystrace.b()
                return
            L66:
                r4 = move-exception
                b.f.j.r.FrescoSystrace.b()
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.BitmapProbeProducer.a.i(java.lang.Object, int):void");
        }
    }

    public BitmapProbeProducer(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache3, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet2, Producer2<CloseableReference<CloseableImage>> producer2) {
        this.a = memoryCache;
        this.f617b = bufferedDiskCache2;
        this.c = bufferedDiskCache3;
        this.d = cacheKeyFactory;
        this.f = boundedLinkedHashSet;
        this.g = boundedLinkedHashSet2;
        this.e = producer2;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        try {
            FrescoSystrace.b();
            ProducerListener2 producerListener2O = producerContext.o();
            producerListener2O.e(producerContext, "BitmapProbeProducer");
            a aVar = new a(consumer2, producerContext, this.a, this.f617b, this.c, this.d, this.f, this.g);
            producerListener2O.j(producerContext, "BitmapProbeProducer", null);
            FrescoSystrace.b();
            this.e.b(aVar, producerContext);
            FrescoSystrace.b();
        } finally {
            FrescoSystrace.b();
        }
    }
}
