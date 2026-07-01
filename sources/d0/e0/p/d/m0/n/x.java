package d0.e0.p.d.m0.n;

/* JADX INFO: compiled from: TypeWithEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x extends v implements f1 {
    public final v m;
    public final c0 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(v vVar, c0 c0Var) {
        super(vVar.getLowerBound(), vVar.getUpperBound());
        d0.z.d.m.checkNotNullParameter(vVar, "origin");
        d0.z.d.m.checkNotNullParameter(c0Var, "enhancement");
        this.m = vVar;
        this.n = c0Var;
    }

    @Override // d0.e0.p.d.m0.n.v
    public j0 getDelegate() {
        return getOrigin().getDelegate();
    }

    @Override // d0.e0.p.d.m0.n.f1
    public c0 getEnhancement() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.n.f1
    public /* bridge */ /* synthetic */ i1 getOrigin() {
        return getOrigin();
    }

    @Override // d0.e0.p.d.m0.n.i1
    public i1 makeNullableAsSpecified(boolean z2) {
        return g1.wrapEnhancement(getOrigin().makeNullableAsSpecified(z2), getEnhancement().unwrap().makeNullableAsSpecified(z2));
    }

    @Override // d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ c0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.v
    public String render(d0.e0.p.d.m0.j.c cVar, d0.e0.p.d.m0.j.h hVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "renderer");
        d0.z.d.m.checkNotNullParameter(hVar, "options");
        return hVar.getEnhancedTypes() ? cVar.renderType(getEnhancement()) : getOrigin().render(cVar, hVar);
    }

    @Override // d0.e0.p.d.m0.n.i1
    public i1 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "newAnnotations");
        return g1.wrapEnhancement(getOrigin().replaceAnnotations(gVar), getEnhancement());
    }

    @Override // d0.e0.p.d.m0.n.f1
    public v getOrigin() {
        return this.m;
    }

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ i1 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public x refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return new x((v) gVar.refineType(getOrigin()), gVar.refineType(getEnhancement()));
    }
}
