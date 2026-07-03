package p007b.p109f.p161j.p181p;

import com.facebook.cache.common.CacheKey;
import p007b.p109f.p161j.p168c.C1857d;
import p007b.p109f.p161j.p168c.C1859f;
import p007b.p109f.p161j.p168c.InterfaceC1862i;
import p007b.p109f.p161j.p175j.C1919e;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.j.p.w */
/* JADX INFO: compiled from: EncodedProbeProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2017w implements InterfaceC2018w0<C1919e> {

    /* JADX INFO: renamed from: a */
    public final C1859f f4246a;

    /* JADX INFO: renamed from: b */
    public final C1859f f4247b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC1862i f4248c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC2018w0<C1919e> f4249d;

    /* JADX INFO: renamed from: e */
    public final C1857d<CacheKey> f4250e;

    /* JADX INFO: renamed from: f */
    public final C1857d<CacheKey> f4251f;

    /* JADX INFO: renamed from: b.f.j.p.w$a */
    /* JADX INFO: compiled from: EncodedProbeProducer.java */
    public static class a extends AbstractC2003p<C1919e, C1919e> {

        /* JADX INFO: renamed from: c */
        public final InterfaceC2020x0 f4252c;

        /* JADX INFO: renamed from: d */
        public final C1859f f4253d;

        /* JADX INFO: renamed from: e */
        public final C1859f f4254e;

        /* JADX INFO: renamed from: f */
        public final InterfaceC1862i f4255f;

        /* JADX INFO: renamed from: g */
        public final C1857d<CacheKey> f4256g;

        /* JADX INFO: renamed from: h */
        public final C1857d<CacheKey> f4257h;

        public a(InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0, C1859f c1859f, C1859f c1859f2, InterfaceC1862i interfaceC1862i, C1857d<CacheKey> c1857d, C1857d<CacheKey> c1857d2) {
            super(interfaceC1995l);
            this.f4252c = interfaceC2020x0;
            this.f4253d = c1859f;
            this.f4254e = c1859f2;
            this.f4255f = interfaceC1862i;
            this.f4256g = c1857d;
            this.f4257h = c1857d2;
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
        @Override // p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: i */
        public void mo1320i(java.lang.Object r6, int r7) {
            /*
                r5 = this;
                b.f.j.j.e r6 = (p007b.p109f.p161j.p175j.C1919e) r6
                java.lang.String r0 = "origin"
                p007b.p109f.p161j.p183r.C2030b.m1527b()     // Catch: java.lang.Throwable -> L8b
                boolean r1 = p007b.p109f.p161j.p181p.AbstractC1965b.m1420f(r7)     // Catch: java.lang.Throwable -> L8b
                if (r1 != 0) goto L82
                if (r6 == 0) goto L82
                r1 = 10
                boolean r1 = p007b.p109f.p161j.p181p.AbstractC1965b.m1421l(r7, r1)     // Catch: java.lang.Throwable -> L8b
                if (r1 != 0) goto L82
                r6.m1347x()     // Catch: java.lang.Throwable -> L8b
                b.f.i.c r1 = r6.f3893l     // Catch: java.lang.Throwable -> L8b
                b.f.i.c r2 = p007b.p109f.p160i.C1832c.f3597a     // Catch: java.lang.Throwable -> L8b
                if (r1 != r2) goto L21
                goto L82
            L21:
                b.f.j.p.x0 r1 = r5.f4252c     // Catch: java.lang.Throwable -> L8b
                com.facebook.imagepipeline.request.ImageRequest r1 = r1.mo1447e()     // Catch: java.lang.Throwable -> L8b
                b.f.j.c.i r2 = r5.f4255f     // Catch: java.lang.Throwable -> L8b
                b.f.j.p.x0 r3 = r5.f4252c     // Catch: java.lang.Throwable -> L8b
                java.lang.Object r3 = r3.mo1444b()     // Catch: java.lang.Throwable -> L8b
                b.f.j.c.n r2 = (p007b.p109f.p161j.p168c.C1867n) r2     // Catch: java.lang.Throwable -> L8b
                com.facebook.cache.common.CacheKey r2 = r2.m1230b(r1, r3)     // Catch: java.lang.Throwable -> L8b
                b.f.j.c.d<com.facebook.cache.common.CacheKey> r3 = r5.f4256g     // Catch: java.lang.Throwable -> L8b
                r3.m1213a(r2)     // Catch: java.lang.Throwable -> L8b
                java.lang.String r3 = "memory_encoded"
                b.f.j.p.x0 r4 = r5.f4252c     // Catch: java.lang.Throwable -> L8b
                java.lang.Object r4 = r4.mo1454l(r0)     // Catch: java.lang.Throwable -> L8b
                boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L8b
                if (r3 == 0) goto L69
                b.f.j.c.d<com.facebook.cache.common.CacheKey> r0 = r5.f4257h     // Catch: java.lang.Throwable -> L8b
                boolean r0 = r0.m1214b(r2)     // Catch: java.lang.Throwable -> L8b
                if (r0 != 0) goto L7c
                com.facebook.imagepipeline.request.ImageRequest$b r0 = r1.f19584b     // Catch: java.lang.Throwable -> L8b
                com.facebook.imagepipeline.request.ImageRequest$b r1 = com.facebook.imagepipeline.request.ImageRequest.EnumC10666b.SMALL     // Catch: java.lang.Throwable -> L8b
                if (r0 != r1) goto L58
                r0 = 1
                goto L59
            L58:
                r0 = 0
            L59:
                if (r0 == 0) goto L5e
                b.f.j.c.f r0 = r5.f4254e     // Catch: java.lang.Throwable -> L8b
                goto L60
            L5e:
                b.f.j.c.f r0 = r5.f4253d     // Catch: java.lang.Throwable -> L8b
            L60:
                r0.m1217c(r2)     // Catch: java.lang.Throwable -> L8b
                b.f.j.c.d<com.facebook.cache.common.CacheKey> r0 = r5.f4257h     // Catch: java.lang.Throwable -> L8b
                r0.m1213a(r2)     // Catch: java.lang.Throwable -> L8b
                goto L7c
            L69:
                java.lang.String r1 = "disk"
                b.f.j.p.x0 r3 = r5.f4252c     // Catch: java.lang.Throwable -> L8b
                java.lang.Object r0 = r3.mo1454l(r0)     // Catch: java.lang.Throwable -> L8b
                boolean r0 = r1.equals(r0)     // Catch: java.lang.Throwable -> L8b
                if (r0 == 0) goto L7c
                b.f.j.c.d<com.facebook.cache.common.CacheKey> r0 = r5.f4257h     // Catch: java.lang.Throwable -> L8b
                r0.m1213a(r2)     // Catch: java.lang.Throwable -> L8b
            L7c:
                b.f.j.p.l<O> r0 = r5.f4179b     // Catch: java.lang.Throwable -> L8b
                r0.mo1424b(r6, r7)     // Catch: java.lang.Throwable -> L8b
                goto L87
            L82:
                b.f.j.p.l<O> r0 = r5.f4179b     // Catch: java.lang.Throwable -> L8b
                r0.mo1424b(r6, r7)     // Catch: java.lang.Throwable -> L8b
            L87:
                p007b.p109f.p161j.p183r.C2030b.m1527b()
                return
            L8b:
                r6 = move-exception
                p007b.p109f.p161j.p183r.C2030b.m1527b()
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: p007b.p109f.p161j.p181p.C2017w.a.mo1320i(java.lang.Object, int):void");
        }
    }

    public C2017w(C1859f c1859f, C1859f c1859f2, InterfaceC1862i interfaceC1862i, C1857d c1857d, C1857d c1857d2, InterfaceC2018w0<C1919e> interfaceC2018w0) {
        this.f4246a = c1859f;
        this.f4247b = c1859f2;
        this.f4248c = interfaceC1862i;
        this.f4250e = c1857d;
        this.f4251f = c1857d2;
        this.f4249d = interfaceC2018w0;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        try {
            C2030b.m1527b();
            InterfaceC2024z0 interfaceC2024z0Mo1457o = interfaceC2020x0.mo1457o();
            interfaceC2024z0Mo1457o.mo1358e(interfaceC2020x0, "EncodedProbeProducer");
            a aVar = new a(interfaceC1995l, interfaceC2020x0, this.f4246a, this.f4247b, this.f4248c, this.f4250e, this.f4251f);
            interfaceC2024z0Mo1457o.mo1363j(interfaceC2020x0, "EncodedProbeProducer", null);
            C2030b.m1527b();
            this.f4249d.mo1417b(aVar, interfaceC2020x0);
            C2030b.m1527b();
        } finally {
            C2030b.m1527b();
        }
    }
}
