package b.f.j.p;

import b.f.d.d.ImmutableMap;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.DefaultCacheKeyFactory;
import b.f.j.c.MemoryCache;
import b.f.j.j.EncodedImage2;
import b.f.j.r.FrescoSystrace;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: renamed from: b.f.j.p.v, reason: use source file name */
/* JADX INFO: compiled from: EncodedMemoryCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class EncodedMemoryCacheProducer implements Producer2<EncodedImage2> {
    public final MemoryCache<CacheKey, PooledByteBuffer> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CacheKeyFactory f640b;
    public final Producer2<EncodedImage2> c;

    /* JADX INFO: renamed from: b.f.j.p.v$a */
    /* JADX INFO: compiled from: EncodedMemoryCacheProducer.java */
    public static class a extends DelegatingConsumer<EncodedImage2, EncodedImage2> {
        public final MemoryCache<CacheKey, PooledByteBuffer> c;
        public final CacheKey d;
        public final boolean e;
        public final boolean f;

        public a(Consumer2<EncodedImage2> consumer2, MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKey cacheKey, boolean z2, boolean z3) {
            super(consumer2);
            this.c = memoryCache;
            this.d = cacheKey;
            this.e = z2;
            this.f = z3;
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
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v8 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // b.f.j.p.BaseConsumer
        public void i(java.lang.Object r4, int r5) {
            /*
                r3 = this;
                b.f.j.j.e r4 = (b.f.j.j.EncodedImage2) r4
                b.f.j.r.FrescoSystrace.b()     // Catch: java.lang.Throwable -> L74
                boolean r0 = b.f.j.p.BaseConsumer.f(r5)     // Catch: java.lang.Throwable -> L74
                if (r0 != 0) goto L6b
                if (r4 == 0) goto L6b
                r0 = 10
                boolean r0 = b.f.j.p.BaseConsumer.l(r5, r0)     // Catch: java.lang.Throwable -> L74
                if (r0 != 0) goto L6b
                r4.x()     // Catch: java.lang.Throwable -> L74
                b.f.i.c r0 = r4.l     // Catch: java.lang.Throwable -> L74
                b.f.i.c r1 = b.f.i.ImageFormat.a     // Catch: java.lang.Throwable -> L74
                if (r0 != r1) goto L1f
                goto L6b
            L1f:
                com.facebook.common.references.CloseableReference r0 = r4.c()     // Catch: java.lang.Throwable -> L74
                if (r0 == 0) goto L65
                r1 = 0
                boolean r2 = r3.f     // Catch: java.lang.Throwable -> L60
                if (r2 == 0) goto L36
                boolean r2 = r3.e     // Catch: java.lang.Throwable -> L60
                if (r2 == 0) goto L36
                b.f.j.c.w<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> r1 = r3.c     // Catch: java.lang.Throwable -> L60
                com.facebook.cache.common.CacheKey r2 = r3.d     // Catch: java.lang.Throwable -> L60
                com.facebook.common.references.CloseableReference r1 = r1.a(r2, r0)     // Catch: java.lang.Throwable -> L60
            L36:
                r0.close()     // Catch: java.lang.Throwable -> L74
                if (r1 == 0) goto L65
                b.f.j.j.e r0 = new b.f.j.j.e     // Catch: java.lang.Throwable -> L5b
                r0.<init>(r1)     // Catch: java.lang.Throwable -> L5b
                r0.b(r4)     // Catch: java.lang.Throwable -> L5b
                r1.close()     // Catch: java.lang.Throwable -> L74
                b.f.j.p.l<O> r4 = r3.f632b     // Catch: java.lang.Throwable -> L56
                r1 = 1065353216(0x3f800000, float:1.0)
                r4.a(r1)     // Catch: java.lang.Throwable -> L56
                b.f.j.p.l<O> r4 = r3.f632b     // Catch: java.lang.Throwable -> L56
                r4.b(r0, r5)     // Catch: java.lang.Throwable -> L56
                r0.close()     // Catch: java.lang.Throwable -> L74
                goto L70
            L56:
                r4 = move-exception
                r0.close()     // Catch: java.lang.Throwable -> L74
                throw r4     // Catch: java.lang.Throwable -> L74
            L5b:
                r4 = move-exception
                r1.close()     // Catch: java.lang.Throwable -> L74
                throw r4     // Catch: java.lang.Throwable -> L74
            L60:
                r4 = move-exception
                r0.close()     // Catch: java.lang.Throwable -> L74
                throw r4     // Catch: java.lang.Throwable -> L74
            L65:
                b.f.j.p.l<O> r0 = r3.f632b     // Catch: java.lang.Throwable -> L74
                r0.b(r4, r5)     // Catch: java.lang.Throwable -> L74
                goto L70
            L6b:
                b.f.j.p.l<O> r0 = r3.f632b     // Catch: java.lang.Throwable -> L74
                r0.b(r4, r5)     // Catch: java.lang.Throwable -> L74
            L70:
                b.f.j.r.FrescoSystrace.b()
                return
            L74:
                r4 = move-exception
                b.f.j.r.FrescoSystrace.b()
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.EncodedMemoryCacheProducer.a.i(java.lang.Object, int):void");
        }
    }

    public EncodedMemoryCacheProducer(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKeyFactory cacheKeyFactory, Producer2<EncodedImage2> producer2) {
        this.a = memoryCache;
        this.f640b = cacheKeyFactory;
        this.c = producer2;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        try {
            FrescoSystrace.b();
            ProducerListener2 producerListener2O = producerContext.o();
            producerListener2O.e(producerContext, "EncodedMemoryCacheProducer");
            CacheKey cacheKeyB = ((DefaultCacheKeyFactory) this.f640b).b(producerContext.e(), producerContext.b());
            CloseableReference<PooledByteBuffer> closeableReference = producerContext.e().b(4) ? this.a.get(cacheKeyB) : null;
            try {
                if (closeableReference != null) {
                    EncodedImage2 encodedImage2 = new EncodedImage2(closeableReference);
                    try {
                        producerListener2O.j(producerContext, "EncodedMemoryCacheProducer", producerListener2O.g(producerContext, "EncodedMemoryCacheProducer") ? ImmutableMap.of("cached_value_found", "true") : null);
                        producerListener2O.c(producerContext, "EncodedMemoryCacheProducer", true);
                        producerContext.n("memory_encoded");
                        consumer2.a(1.0f);
                        consumer2.b(encodedImage2, 1);
                        encodedImage2.close();
                        closeableReference.close();
                        FrescoSystrace.b();
                        return;
                    } catch (Throwable th) {
                        encodedImage2.close();
                        throw th;
                    }
                }
                if (producerContext.q().g() < ImageRequest.c.ENCODED_MEMORY_CACHE.g()) {
                    a aVar = new a(consumer2, this.a, cacheKeyB, producerContext.e().b(8), producerContext.g().getExperiments().e);
                    producerListener2O.j(producerContext, "EncodedMemoryCacheProducer", producerListener2O.g(producerContext, "EncodedMemoryCacheProducer") ? ImmutableMap.of("cached_value_found", "false") : null);
                    this.c.b(aVar, producerContext);
                    Class<CloseableReference> cls = CloseableReference.j;
                    if (closeableReference != null) {
                        closeableReference.close();
                    }
                    FrescoSystrace.b();
                    return;
                }
                producerListener2O.j(producerContext, "EncodedMemoryCacheProducer", producerListener2O.g(producerContext, "EncodedMemoryCacheProducer") ? ImmutableMap.of("cached_value_found", "false") : null);
                producerListener2O.c(producerContext, "EncodedMemoryCacheProducer", false);
                producerContext.i("memory_encoded", "nil-result");
                consumer2.b(null, 1);
                Class<CloseableReference> cls2 = CloseableReference.j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                FrescoSystrace.b();
            } catch (Throwable th2) {
                Class<CloseableReference> cls3 = CloseableReference.j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                throw th2;
            }
        } catch (Throwable th3) {
            FrescoSystrace.b();
            throw th3;
        }
    }
}
