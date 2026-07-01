package d0.e0.p.d.m0.n;

import java.util.List;

/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m extends j0 {
    @Override // d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        return getDelegate().getAnnotations();
    }

    @Override // d0.e0.p.d.m0.n.c0
    public List<w0> getArguments() {
        return getDelegate().getArguments();
    }

    @Override // d0.e0.p.d.m0.n.c0
    public u0 getConstructor() {
        return getDelegate().getConstructor();
    }

    public abstract j0 getDelegate();

    @Override // d0.e0.p.d.m0.n.c0
    public d0.e0.p.d.m0.k.a0.i getMemberScope() {
        return getDelegate().getMemberScope();
    }

    @Override // d0.e0.p.d.m0.n.c0
    public boolean isMarkedNullable() {
        return getDelegate().isMarkedNullable();
    }

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ c0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    public abstract m replaceDelegate(j0 j0Var);

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ i1 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public j0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return replaceDelegate((j0) gVar.refineType(getDelegate()));
    }
}
