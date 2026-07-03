package p007b.p109f.p161j.p181p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import p007b.p109f.p161j.p168c.C1857d;
import p007b.p109f.p161j.p168c.C1859f;
import p007b.p109f.p161j.p168c.InterfaceC1862i;
import p007b.p109f.p161j.p168c.InterfaceC1876w;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.j.p.j */
/* JADX INFO: compiled from: BitmapProbeProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1989j implements InterfaceC2018w0<CloseableReference<AbstractC1917c>> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1876w<CacheKey, PooledByteBuffer> f4089a;

    /* JADX INFO: renamed from: b */
    public final C1859f f4090b;

    /* JADX INFO: renamed from: c */
    public final C1859f f4091c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC1862i f4092d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC2018w0<CloseableReference<AbstractC1917c>> f4093e;

    /* JADX INFO: renamed from: f */
    public final C1857d<CacheKey> f4094f;

    /* JADX INFO: renamed from: g */
    public final C1857d<CacheKey> f4095g;

    /* JADX INFO: renamed from: b.f.j.p.j$a */
    /* JADX INFO: compiled from: BitmapProbeProducer.java */
    public static class a extends AbstractC2003p<CloseableReference<AbstractC1917c>, CloseableReference<AbstractC1917c>> {

        /* JADX INFO: renamed from: c */
        public final InterfaceC2020x0 f4096c;

        /* JADX INFO: renamed from: d */
        public final InterfaceC1876w<CacheKey, PooledByteBuffer> f4097d;

        /* JADX INFO: renamed from: e */
        public final C1859f f4098e;

        /* JADX INFO: renamed from: f */
        public final C1859f f4099f;

        /* JADX INFO: renamed from: g */
        public final InterfaceC1862i f4100g;

        /* JADX INFO: renamed from: h */
        public final C1857d<CacheKey> f4101h;

        /* JADX INFO: renamed from: i */
        public final C1857d<CacheKey> f4102i;

        public a(InterfaceC1995l<CloseableReference<AbstractC1917c>> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0, InterfaceC1876w<CacheKey, PooledByteBuffer> interfaceC1876w, C1859f c1859f, C1859f c1859f2, InterfaceC1862i interfaceC1862i, C1857d<CacheKey> c1857d, C1857d<CacheKey> c1857d2) {
            super(interfaceC1995l);
            this.f4096c = interfaceC2020x0;
            this.f4097d = interfaceC1876w;
            this.f4098e = c1859f;
            this.f4099f = c1859f2;
            this.f4100g = interfaceC1862i;
            this.f4101h = c1857d;
            this.f4102i = c1857d2;
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
        @Override // p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: i */
        public void mo1320i(java.lang.Object r4, int r5) {
            /*
                r3 = this;
                com.facebook.common.references.CloseableReference r4 = (com.facebook.common.references.CloseableReference) r4
                p007b.p109f.p161j.p183r.C2030b.m1527b()     // Catch: java.lang.Throwable -> L66
                boolean r0 = p007b.p109f.p161j.p181p.AbstractC1965b.m1420f(r5)     // Catch: java.lang.Throwable -> L66
                if (r0 != 0) goto L5d
                if (r4 == 0) goto L5d
                r0 = 8
                boolean r0 = p007b.p109f.p161j.p181p.AbstractC1965b.m1421l(r5, r0)     // Catch: java.lang.Throwable -> L66
                if (r0 == 0) goto L16
                goto L5d
            L16:
                b.f.j.p.x0 r0 = r3.f4096c     // Catch: java.lang.Throwable -> L66
                com.facebook.imagepipeline.request.ImageRequest r0 = r0.mo1447e()     // Catch: java.lang.Throwable -> L66
                b.f.j.c.i r1 = r3.f4100g     // Catch: java.lang.Throwable -> L66
                b.f.j.p.x0 r2 = r3.f4096c     // Catch: java.lang.Throwable -> L66
                java.lang.Object r2 = r2.mo1444b()     // Catch: java.lang.Throwable -> L66
                b.f.j.c.n r1 = (p007b.p109f.p161j.p168c.C1867n) r1     // Catch: java.lang.Throwable -> L66
                r1.m1230b(r0, r2)     // Catch: java.lang.Throwable -> L66
                b.f.j.p.x0 r0 = r3.f4096c     // Catch: java.lang.Throwable -> L66
                java.lang.String r1 = "origin"
                java.lang.Object r0 = r0.mo1454l(r1)     // Catch: java.lang.Throwable -> L66
                java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L66
                if (r0 == 0) goto L57
                java.lang.String r1 = "memory_bitmap"
                boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L66
                if (r0 == 0) goto L57
                b.f.j.p.x0 r0 = r3.f4096c     // Catch: java.lang.Throwable -> L66
                b.f.j.e.k r0 = r0.mo1449g()     // Catch: java.lang.Throwable -> L66
                b.f.j.e.l r0 = r0.getExperiments()     // Catch: java.lang.Throwable -> L66
                java.util.Objects.requireNonNull(r0)     // Catch: java.lang.Throwable -> L66
                b.f.j.p.x0 r0 = r3.f4096c     // Catch: java.lang.Throwable -> L66
                b.f.j.e.k r0 = r0.mo1449g()     // Catch: java.lang.Throwable -> L66
                b.f.j.e.l r0 = r0.getExperiments()     // Catch: java.lang.Throwable -> L66
                java.util.Objects.requireNonNull(r0)     // Catch: java.lang.Throwable -> L66
            L57:
                b.f.j.p.l<O> r0 = r3.f4179b     // Catch: java.lang.Throwable -> L66
                r0.mo1424b(r4, r5)     // Catch: java.lang.Throwable -> L66
                goto L62
            L5d:
                b.f.j.p.l<O> r0 = r3.f4179b     // Catch: java.lang.Throwable -> L66
                r0.mo1424b(r4, r5)     // Catch: java.lang.Throwable -> L66
            L62:
                p007b.p109f.p161j.p183r.C2030b.m1527b()
                return
            L66:
                r4 = move-exception
                p007b.p109f.p161j.p183r.C2030b.m1527b()
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: p007b.p109f.p161j.p181p.C1989j.a.mo1320i(java.lang.Object, int):void");
        }
    }

    public C1989j(InterfaceC1876w<CacheKey, PooledByteBuffer> interfaceC1876w, C1859f c1859f, C1859f c1859f2, InterfaceC1862i interfaceC1862i, C1857d<CacheKey> c1857d, C1857d<CacheKey> c1857d2, InterfaceC2018w0<CloseableReference<AbstractC1917c>> interfaceC2018w0) {
        this.f4089a = interfaceC1876w;
        this.f4090b = c1859f;
        this.f4091c = c1859f2;
        this.f4092d = interfaceC1862i;
        this.f4094f = c1857d;
        this.f4095g = c1857d2;
        this.f4093e = interfaceC2018w0;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<CloseableReference<AbstractC1917c>> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        try {
            C2030b.m1527b();
            InterfaceC2024z0 interfaceC2024z0Mo1457o = interfaceC2020x0.mo1457o();
            interfaceC2024z0Mo1457o.mo1358e(interfaceC2020x0, "BitmapProbeProducer");
            a aVar = new a(interfaceC1995l, interfaceC2020x0, this.f4089a, this.f4090b, this.f4091c, this.f4092d, this.f4094f, this.f4095g);
            interfaceC2024z0Mo1457o.mo1363j(interfaceC2020x0, "BitmapProbeProducer", null);
            C2030b.m1527b();
            this.f4093e.mo1417b(aVar, interfaceC2020x0);
            C2030b.m1527b();
        } finally {
            C2030b.m1527b();
        }
    }
}
