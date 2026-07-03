package p007b.p109f.p161j.p181p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import p007b.p109f.p115d.p119d.C1683f;
import p007b.p109f.p161j.p168c.C1867n;
import p007b.p109f.p161j.p168c.InterfaceC1862i;
import p007b.p109f.p161j.p168c.InterfaceC1876w;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p182q.InterfaceC2026b;
import p007b.p109f.p161j.p182q.InterfaceC2027c;

/* JADX INFO: renamed from: b.f.j.p.s0 */
/* JADX INFO: compiled from: PostprocessedBitmapMemoryCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2010s0 implements InterfaceC2018w0<CloseableReference<AbstractC1917c>> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1876w<CacheKey, AbstractC1917c> f4206a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1862i f4207b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2018w0<CloseableReference<AbstractC1917c>> f4208c;

    /* JADX INFO: renamed from: b.f.j.p.s0$a */
    /* JADX INFO: compiled from: PostprocessedBitmapMemoryCacheProducer.java */
    public static class a extends AbstractC2003p<CloseableReference<AbstractC1917c>, CloseableReference<AbstractC1917c>> {

        /* JADX INFO: renamed from: c */
        public final CacheKey f4209c;

        /* JADX INFO: renamed from: d */
        public final boolean f4210d;

        /* JADX INFO: renamed from: e */
        public final InterfaceC1876w<CacheKey, AbstractC1917c> f4211e;

        /* JADX INFO: renamed from: f */
        public final boolean f4212f;

        public a(InterfaceC1995l<CloseableReference<AbstractC1917c>> interfaceC1995l, CacheKey cacheKey, boolean z2, InterfaceC1876w<CacheKey, AbstractC1917c> interfaceC1876w, boolean z3) {
            super(interfaceC1995l);
            this.f4209c = cacheKey;
            this.f4210d = z2;
            this.f4211e = interfaceC1876w;
            this.f4212f = z3;
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
        @Override // p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: i */
        public void mo1320i(java.lang.Object r4, int r5) {
            /*
                r3 = this;
                com.facebook.common.references.CloseableReference r4 = (com.facebook.common.references.CloseableReference) r4
                r0 = 0
                if (r4 != 0) goto L11
                boolean r4 = p007b.p109f.p161j.p181p.AbstractC1965b.m1419e(r5)
                if (r4 == 0) goto L3e
                b.f.j.p.l<O> r4 = r3.f4179b
                r4.mo1424b(r0, r5)
                goto L3e
            L11:
                boolean r1 = p007b.p109f.p161j.p181p.AbstractC1965b.m1420f(r5)
                if (r1 == 0) goto L1c
                boolean r1 = r3.f4210d
                if (r1 != 0) goto L1c
                goto L3e
            L1c:
                boolean r1 = r3.f4212f
                if (r1 == 0) goto L28
                b.f.j.c.w<com.facebook.cache.common.CacheKey, b.f.j.j.c> r0 = r3.f4211e
                com.facebook.cache.common.CacheKey r1 = r3.f4209c
                com.facebook.common.references.CloseableReference r0 = r0.mo1235a(r1, r4)
            L28:
                b.f.j.p.l<O> r1 = r3.f4179b     // Catch: java.lang.Throwable -> L3f
                r2 = 1065353216(0x3f800000, float:1.0)
                r1.mo1423a(r2)     // Catch: java.lang.Throwable -> L3f
                b.f.j.p.l<O> r1 = r3.f4179b     // Catch: java.lang.Throwable -> L3f
                if (r0 == 0) goto L34
                r4 = r0
            L34:
                r1.mo1424b(r4, r5)     // Catch: java.lang.Throwable -> L3f
                java.lang.Class<com.facebook.common.references.CloseableReference> r4 = com.facebook.common.references.CloseableReference.f19438j
                if (r0 == 0) goto L3e
                r0.close()
            L3e:
                return
            L3f:
                r4 = move-exception
                java.lang.Class<com.facebook.common.references.CloseableReference> r5 = com.facebook.common.references.CloseableReference.f19438j
                if (r0 == 0) goto L47
                r0.close()
            L47:
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: p007b.p109f.p161j.p181p.C2010s0.a.mo1320i(java.lang.Object, int):void");
        }
    }

    public C2010s0(InterfaceC1876w<CacheKey, AbstractC1917c> interfaceC1876w, InterfaceC1862i interfaceC1862i, InterfaceC2018w0<CloseableReference<AbstractC1917c>> interfaceC2018w0) {
        this.f4206a = interfaceC1876w;
        this.f4207b = interfaceC1862i;
        this.f4208c = interfaceC2018w0;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<CloseableReference<AbstractC1917c>> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        InterfaceC2024z0 interfaceC2024z0Mo1457o = interfaceC2020x0.mo1457o();
        ImageRequest imageRequestMo1447e = interfaceC2020x0.mo1447e();
        Object objMo1444b = interfaceC2020x0.mo1444b();
        InterfaceC2026b interfaceC2026b = imageRequestMo1447e.f19601s;
        if (interfaceC2026b == null || interfaceC2026b.getPostprocessorCacheKey() == null) {
            this.f4208c.mo1417b(interfaceC1995l, interfaceC2020x0);
            return;
        }
        interfaceC2024z0Mo1457o.mo1358e(interfaceC2020x0, "PostprocessedBitmapMemoryCacheProducer");
        CacheKey cacheKeyM1231c = ((C1867n) this.f4207b).m1231c(imageRequestMo1447e, objMo1444b);
        CloseableReference<AbstractC1917c> closeableReference = interfaceC2020x0.mo1447e().m8720b(1) ? this.f4206a.get(cacheKeyM1231c) : null;
        if (closeableReference == null) {
            a aVar = new a(interfaceC1995l, cacheKeyM1231c, interfaceC2026b instanceof InterfaceC2027c, this.f4206a, interfaceC2020x0.mo1447e().m8720b(2));
            interfaceC2024z0Mo1457o.mo1363j(interfaceC2020x0, "PostprocessedBitmapMemoryCacheProducer", interfaceC2024z0Mo1457o.mo1360g(interfaceC2020x0, "PostprocessedBitmapMemoryCacheProducer") ? C1683f.m967of("cached_value_found", "false") : null);
            this.f4208c.mo1417b(aVar, interfaceC2020x0);
        } else {
            interfaceC2024z0Mo1457o.mo1363j(interfaceC2020x0, "PostprocessedBitmapMemoryCacheProducer", interfaceC2024z0Mo1457o.mo1360g(interfaceC2020x0, "PostprocessedBitmapMemoryCacheProducer") ? C1683f.m967of("cached_value_found", "true") : null);
            interfaceC2024z0Mo1457o.mo1356c(interfaceC2020x0, "PostprocessedBitmapMemoryCacheProducer", true);
            interfaceC2020x0.mo1451i("memory_bitmap", "postprocessed");
            interfaceC1995l.mo1423a(1.0f);
            interfaceC1995l.mo1424b(closeableReference, 1);
            closeableReference.close();
        }
    }
}
