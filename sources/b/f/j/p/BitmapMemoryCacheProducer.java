package b.f.j.p;

import b.f.d.d.ImmutableMap;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.DefaultCacheKeyFactory;
import b.f.j.c.MemoryCache;
import b.f.j.j.CloseableImage;
import b.f.j.j.ImmutableQualityInfo;
import b.f.j.r.FrescoSystrace;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: renamed from: b.f.j.p.h, reason: use source file name */
/* JADX INFO: compiled from: BitmapMemoryCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class BitmapMemoryCacheProducer implements Producer2<CloseableReference<CloseableImage>> {
    public final MemoryCache<CacheKey, CloseableImage> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CacheKeyFactory f613b;
    public final Producer2<CloseableReference<CloseableImage>> c;

    /* JADX INFO: renamed from: b.f.j.p.h$a */
    /* JADX INFO: compiled from: BitmapMemoryCacheProducer.java */
    public class a extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public final /* synthetic */ CacheKey c;
        public final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer2 consumer2, CacheKey cacheKey, boolean z2) {
            super(consumer2);
            this.c = cacheKey;
            this.d = z2;
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
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v9 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // b.f.j.p.BaseConsumer
        public void i(java.lang.Object r7, int r8) {
            /*
                r6 = this;
                com.facebook.common.references.CloseableReference r7 = (com.facebook.common.references.CloseableReference) r7
                b.f.j.r.FrescoSystrace.b()     // Catch: java.lang.Throwable -> La9
                boolean r0 = b.f.j.p.BaseConsumer.e(r8)     // Catch: java.lang.Throwable -> La9
                r1 = 0
                if (r7 != 0) goto L18
                if (r0 == 0) goto L13
                b.f.j.p.l<O> r7 = r6.f632b     // Catch: java.lang.Throwable -> La9
                r7.b(r1, r8)     // Catch: java.lang.Throwable -> La9
            L13:
                b.f.j.r.FrescoSystrace.b()
                goto La8
            L18:
                java.lang.Object r2 = r7.u()     // Catch: java.lang.Throwable -> La9
                b.f.j.j.c r2 = (b.f.j.j.CloseableImage) r2     // Catch: java.lang.Throwable -> La9
                boolean r2 = r2.d()     // Catch: java.lang.Throwable -> La9
                if (r2 != 0) goto La1
                r2 = 8
                boolean r2 = b.f.j.p.BaseConsumer.m(r8, r2)     // Catch: java.lang.Throwable -> La9
                if (r2 == 0) goto L2e
                goto La1
            L2e:
                if (r0 != 0) goto L74
                b.f.j.p.h r2 = b.f.j.p.BitmapMemoryCacheProducer.this     // Catch: java.lang.Throwable -> La9
                b.f.j.c.w<com.facebook.cache.common.CacheKey, b.f.j.j.c> r2 = r2.a     // Catch: java.lang.Throwable -> La9
                com.facebook.cache.common.CacheKey r3 = r6.c     // Catch: java.lang.Throwable -> La9
                com.facebook.common.references.CloseableReference r2 = r2.get(r3)     // Catch: java.lang.Throwable -> La9
                if (r2 == 0) goto L74
                java.lang.Object r3 = r7.u()     // Catch: java.lang.Throwable -> L6f
                b.f.j.j.c r3 = (b.f.j.j.CloseableImage) r3     // Catch: java.lang.Throwable -> L6f
                b.f.j.j.i r3 = r3.b()     // Catch: java.lang.Throwable -> L6f
                java.lang.Object r4 = r2.u()     // Catch: java.lang.Throwable -> L6f
                b.f.j.j.c r4 = (b.f.j.j.CloseableImage) r4     // Catch: java.lang.Throwable -> L6f
                b.f.j.j.i r4 = r4.b()     // Catch: java.lang.Throwable -> L6f
                r5 = r4
                b.f.j.j.h r5 = (b.f.j.j.ImmutableQualityInfo) r5     // Catch: java.lang.Throwable -> L6f
                boolean r5 = r5.d     // Catch: java.lang.Throwable -> L6f
                if (r5 != 0) goto L66
                b.f.j.j.h r4 = (b.f.j.j.ImmutableQualityInfo) r4     // Catch: java.lang.Throwable -> L6f
                int r4 = r4.f591b     // Catch: java.lang.Throwable -> L6f
                b.f.j.j.h r3 = (b.f.j.j.ImmutableQualityInfo) r3     // Catch: java.lang.Throwable -> L6f
                int r3 = r3.f591b     // Catch: java.lang.Throwable -> L6f
                if (r4 < r3) goto L62
                goto L66
            L62:
                r2.close()     // Catch: java.lang.Throwable -> La9
                goto L74
            L66:
                b.f.j.p.l<O> r7 = r6.f632b     // Catch: java.lang.Throwable -> L6f
                r7.b(r2, r8)     // Catch: java.lang.Throwable -> L6f
                r2.close()     // Catch: java.lang.Throwable -> La9
                goto L13
            L6f:
                r7 = move-exception
                r2.close()     // Catch: java.lang.Throwable -> La9
                throw r7     // Catch: java.lang.Throwable -> La9
            L74:
                boolean r2 = r6.d     // Catch: java.lang.Throwable -> La9
                if (r2 == 0) goto L82
                b.f.j.p.h r1 = b.f.j.p.BitmapMemoryCacheProducer.this     // Catch: java.lang.Throwable -> La9
                b.f.j.c.w<com.facebook.cache.common.CacheKey, b.f.j.j.c> r1 = r1.a     // Catch: java.lang.Throwable -> La9
                com.facebook.cache.common.CacheKey r2 = r6.c     // Catch: java.lang.Throwable -> La9
                com.facebook.common.references.CloseableReference r1 = r1.a(r2, r7)     // Catch: java.lang.Throwable -> La9
            L82:
                if (r0 == 0) goto L8b
                b.f.j.p.l<O> r0 = r6.f632b     // Catch: java.lang.Throwable -> L9a
                r2 = 1065353216(0x3f800000, float:1.0)
                r0.a(r2)     // Catch: java.lang.Throwable -> L9a
            L8b:
                b.f.j.p.l<O> r0 = r6.f632b     // Catch: java.lang.Throwable -> L9a
                if (r1 == 0) goto L90
                r7 = r1
            L90:
                r0.b(r7, r8)     // Catch: java.lang.Throwable -> L9a
                if (r1 == 0) goto L13
                r1.close()     // Catch: java.lang.Throwable -> La9
                goto L13
            L9a:
                r7 = move-exception
                if (r1 == 0) goto La0
                r1.close()     // Catch: java.lang.Throwable -> La9
            La0:
                throw r7     // Catch: java.lang.Throwable -> La9
            La1:
                b.f.j.p.l<O> r0 = r6.f632b     // Catch: java.lang.Throwable -> La9
                r0.b(r7, r8)     // Catch: java.lang.Throwable -> La9
                goto L13
            La8:
                return
            La9:
                r7 = move-exception
                b.f.j.r.FrescoSystrace.b()
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.BitmapMemoryCacheProducer.a.i(java.lang.Object, int):void");
        }
    }

    public BitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer2<CloseableReference<CloseableImage>> producer2) {
        this.a = memoryCache;
        this.f613b = cacheKeyFactory;
        this.c = producer2;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        try {
            FrescoSystrace.b();
            ProducerListener2 producerListener2O = producerContext.o();
            producerListener2O.e(producerContext, d());
            CacheKey cacheKeyA = ((DefaultCacheKeyFactory) this.f613b).a(producerContext.e(), producerContext.b());
            CloseableReference<CloseableImage> closeableReference = producerContext.e().b(1) ? this.a.get(cacheKeyA) : null;
            if (closeableReference != null) {
                producerContext.j(closeableReference.u().a());
                boolean z2 = ((ImmutableQualityInfo) closeableReference.u().b()).d;
                if (z2) {
                    producerListener2O.j(producerContext, d(), producerListener2O.g(producerContext, d()) ? ImmutableMap.of("cached_value_found", "true") : null);
                    producerListener2O.c(producerContext, d(), true);
                    producerContext.i("memory_bitmap", c());
                    consumer2.a(1.0f);
                }
                consumer2.b(closeableReference, z2 ? 1 : 0);
                closeableReference.close();
                if (z2) {
                    return;
                }
            }
            if (producerContext.q().g() >= ImageRequest.c.BITMAP_MEMORY_CACHE.g()) {
                producerListener2O.j(producerContext, d(), producerListener2O.g(producerContext, d()) ? ImmutableMap.of("cached_value_found", "false") : null);
                producerListener2O.c(producerContext, d(), false);
                producerContext.i("memory_bitmap", c());
                consumer2.b(null, 1);
                return;
            }
            Consumer2<CloseableReference<CloseableImage>> consumer2E = e(consumer2, cacheKeyA, producerContext.e().b(2));
            producerListener2O.j(producerContext, d(), producerListener2O.g(producerContext, d()) ? ImmutableMap.of("cached_value_found", "false") : null);
            FrescoSystrace.b();
            this.c.b(consumer2E, producerContext);
            FrescoSystrace.b();
        } finally {
            FrescoSystrace.b();
        }
    }

    public String c() {
        return "pipe_bg";
    }

    public String d() {
        return "BitmapMemoryCacheProducer";
    }

    public Consumer2<CloseableReference<CloseableImage>> e(Consumer2<CloseableReference<CloseableImage>> consumer2, CacheKey cacheKey, boolean z2) {
        return new a(consumer2, cacheKey, z2);
    }
}
