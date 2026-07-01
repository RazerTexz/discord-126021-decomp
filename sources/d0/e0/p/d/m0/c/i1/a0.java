package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.u0;

/* JADX INFO: compiled from: PackageFragmentDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 extends l implements d0.e0.p.d.m0.c.e0 {
    public final d0.e0.p.d.m0.g.b n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(d0.e0.p.d.m0.c.c0 c0Var, d0.e0.p.d.m0.g.b bVar) {
        super(c0Var, d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), bVar.shortNameOrSpecial(), u0.a);
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        this.n = bVar;
    }

    @Override // d0.e0.p.d.m0.c.m
    public <R, D> R accept(d0.e0.p.d.m0.c.o<R, D> oVar, D d) {
        d0.z.d.m.checkNotNullParameter(oVar, "visitor");
        return oVar.visitPackageFragmentDescriptor(this, d);
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // d0.e0.p.d.m0.c.e0
    public final d0.e0.p.d.m0.g.b getFqName() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.p
    public u0 getSource() {
        u0 u0Var = u0.a;
        d0.z.d.m.checkNotNullExpressionValue(u0Var, "NO_SOURCE");
        return u0Var;
    }

    @Override // d0.e0.p.d.m0.c.i1.k
    public String toString() {
        return d0.z.d.m.stringPlus("package ", this.n);
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.c0 getContainingDeclaration() {
        return (d0.e0.p.d.m0.c.c0) super.getContainingDeclaration();
    }
}
