package p007b.p109f.p161j.p181p;

import com.facebook.imagepipeline.request.ImageRequest;
import p007b.p109f.p161j.p168c.C1859f;
import p007b.p109f.p161j.p168c.InterfaceC1862i;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.p.t */
/* JADX INFO: compiled from: DiskCacheWriteProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2011t implements InterfaceC2018w0<C1919e> {

    /* JADX INFO: renamed from: a */
    public final C1859f f4213a;

    /* JADX INFO: renamed from: b */
    public final C1859f f4214b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC1862i f4215c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC2018w0<C1919e> f4216d;

    /* JADX INFO: renamed from: b.f.j.p.t$b */
    /* JADX INFO: compiled from: DiskCacheWriteProducer.java */
    public static class b extends AbstractC2003p<C1919e, C1919e> {

        /* JADX INFO: renamed from: c */
        public final InterfaceC2020x0 f4217c;

        /* JADX INFO: renamed from: d */
        public final C1859f f4218d;

        /* JADX INFO: renamed from: e */
        public final C1859f f4219e;

        /* JADX INFO: renamed from: f */
        public final InterfaceC1862i f4220f;

        public b(InterfaceC1995l interfaceC1995l, InterfaceC2020x0 interfaceC2020x0, C1859f c1859f, C1859f c1859f2, InterfaceC1862i interfaceC1862i, a aVar) {
            super(interfaceC1995l);
            this.f4217c = interfaceC2020x0;
            this.f4218d = c1859f;
            this.f4219e = c1859f2;
            this.f4220f = interfaceC1862i;
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
        @Override // p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: i */
        public void mo1320i(java.lang.Object r6, int r7) {
            /*
                r5 = this;
                b.f.j.j.e r6 = (p007b.p109f.p161j.p175j.C1919e) r6
                b.f.j.p.x0 r0 = r5.f4217c
                b.f.j.p.z0 r0 = r0.mo1457o()
                b.f.j.p.x0 r1 = r5.f4217c
                java.lang.String r2 = "DiskCacheWriteProducer"
                r0.mo1358e(r1, r2)
                boolean r0 = p007b.p109f.p161j.p181p.AbstractC1965b.m1420f(r7)
                r1 = 0
                if (r0 != 0) goto L60
                if (r6 == 0) goto L60
                r0 = 10
                boolean r0 = p007b.p109f.p161j.p181p.AbstractC1965b.m1421l(r7, r0)
                if (r0 != 0) goto L60
                r6.m1347x()
                b.f.i.c r0 = r6.f3893l
                b.f.i.c r3 = p007b.p109f.p160i.C1832c.f3597a
                if (r0 != r3) goto L2a
                goto L60
            L2a:
                b.f.j.p.x0 r0 = r5.f4217c
                com.facebook.imagepipeline.request.ImageRequest r0 = r0.mo1447e()
                b.f.j.c.i r3 = r5.f4220f
                b.f.j.p.x0 r4 = r5.f4217c
                java.lang.Object r4 = r4.mo1444b()
                b.f.j.c.n r3 = (p007b.p109f.p161j.p168c.C1867n) r3
                com.facebook.cache.common.CacheKey r3 = r3.m1230b(r0, r4)
                com.facebook.imagepipeline.request.ImageRequest$b r0 = r0.f19584b
                com.facebook.imagepipeline.request.ImageRequest$b r4 = com.facebook.imagepipeline.request.ImageRequest.EnumC10666b.SMALL
                if (r0 != r4) goto L4a
                b.f.j.c.f r0 = r5.f4219e
                r0.m1220f(r3, r6)
                goto L4f
            L4a:
                b.f.j.c.f r0 = r5.f4218d
                r0.m1220f(r3, r6)
            L4f:
                b.f.j.p.x0 r0 = r5.f4217c
                b.f.j.p.z0 r0 = r0.mo1457o()
                b.f.j.p.x0 r3 = r5.f4217c
                r0.mo1363j(r3, r2, r1)
                b.f.j.p.l<O> r0 = r5.f4179b
                r0.mo1424b(r6, r7)
                goto L70
            L60:
                b.f.j.p.x0 r0 = r5.f4217c
                b.f.j.p.z0 r0 = r0.mo1457o()
                b.f.j.p.x0 r3 = r5.f4217c
                r0.mo1363j(r3, r2, r1)
                b.f.j.p.l<O> r0 = r5.f4179b
                r0.mo1424b(r6, r7)
            L70:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p007b.p109f.p161j.p181p.C2011t.b.mo1320i(java.lang.Object, int):void");
        }
    }

    public C2011t(C1859f c1859f, C1859f c1859f2, InterfaceC1862i interfaceC1862i, InterfaceC2018w0<C1919e> interfaceC2018w0) {
        this.f4213a = c1859f;
        this.f4214b = c1859f2;
        this.f4215c = interfaceC1862i;
        this.f4216d = interfaceC2018w0;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        if (interfaceC2020x0.mo1459q().m8722g() >= ImageRequest.EnumC10667c.DISK_CACHE.m8722g()) {
            interfaceC2020x0.mo1451i("disk", "nil-result_write");
            interfaceC1995l.mo1424b(null, 1);
        } else {
            if (interfaceC2020x0.mo1447e().m8720b(32)) {
                interfaceC1995l = new b(interfaceC1995l, interfaceC2020x0, this.f4213a, this.f4214b, this.f4215c, null);
            }
            this.f4216d.mo1417b(interfaceC1995l, interfaceC2020x0);
        }
    }
}
