package p007b.p109f.p161j.p181p;

import com.facebook.imagepipeline.request.ImageRequest;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.p.k */
/* JADX INFO: compiled from: BranchOnSeparateImagesProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1992k implements InterfaceC2018w0<C1919e> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2018w0<C1919e> f4116a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2018w0<C1919e> f4117b;

    /* JADX INFO: renamed from: b.f.j.p.k$b */
    /* JADX INFO: compiled from: BranchOnSeparateImagesProducer.java */
    public class b extends AbstractC2003p<C1919e, C1919e> {

        /* JADX INFO: renamed from: c */
        public InterfaceC2020x0 f4118c;

        public b(InterfaceC1995l interfaceC1995l, InterfaceC2020x0 interfaceC2020x0, a aVar) {
            super(interfaceC1995l);
            this.f4118c = interfaceC2020x0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // p007b.p109f.p161j.p181p.AbstractC2003p, p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: h */
        public void mo1319h(Throwable th) {
            C1992k.this.f4117b.mo1417b(this.f4179b, this.f4118c);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: i */
        public void mo1320i(Object obj, int i) {
            C1919e c1919e = (C1919e) obj;
            ImageRequest imageRequestMo1447e = this.f4118c.mo1447e();
            boolean zM1419e = AbstractC1965b.m1419e(i);
            boolean zM475T0 = C1460d.m475T0(c1919e, imageRequestMo1447e.f19592j);
            if (c1919e != null && (zM475T0 || imageRequestMo1447e.f19589g)) {
                if (zM1419e && zM475T0) {
                    this.f4179b.mo1424b(c1919e, i);
                } else {
                    this.f4179b.mo1424b(c1919e, i & (-2));
                }
            }
            if (!zM1419e || zM475T0 || imageRequestMo1447e.f19590h) {
                return;
            }
            if (c1919e != null) {
                c1919e.close();
            }
            C1992k.this.f4117b.mo1417b(this.f4179b, this.f4118c);
        }
    }

    public C1992k(InterfaceC2018w0<C1919e> interfaceC2018w0, InterfaceC2018w0<C1919e> interfaceC2018w1) {
        this.f4116a = interfaceC2018w0;
        this.f4117b = interfaceC2018w1;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        this.f4116a.mo1417b(new b(interfaceC1995l, interfaceC2020x0, null), interfaceC2020x0);
    }
}
