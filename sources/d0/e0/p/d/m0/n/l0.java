package d0.e0.p.d.m0.n;

/* JADX INFO: compiled from: TypeWithEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l0 extends m implements f1 {
    public final j0 k;
    public final c0 l;

    public l0(j0 j0Var, c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(j0Var, "delegate");
        d0.z.d.m.checkNotNullParameter(c0Var, "enhancement");
        this.k = j0Var;
        this.l = c0Var;
    }

    @Override // d0.e0.p.d.m0.n.m
    public j0 getDelegate() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.n.f1
    public c0 getEnhancement() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.n.f1
    public i1 getOrigin() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.m, d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ c0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        return replaceAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.n.m
    public /* bridge */ /* synthetic */ m replaceDelegate(j0 j0Var) {
        return replaceDelegate(j0Var);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public j0 makeNullableAsSpecified(boolean z2) {
        return (j0) g1.wrapEnhancement(getOrigin().makeNullableAsSpecified(z2), getEnhancement().unwrap().makeNullableAsSpecified(z2));
    }

    @Override // d0.e0.p.d.m0.n.m, d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ j0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public j0 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "newAnnotations");
        return (j0) g1.wrapEnhancement(getOrigin().replaceAnnotations(gVar), getEnhancement());
    }

    @Override // d0.e0.p.d.m0.n.m
    public l0 replaceDelegate(j0 j0Var) {
        d0.z.d.m.checkNotNullParameter(j0Var, "delegate");
        return new l0(j0Var, getEnhancement());
    }

    @Override // d0.e0.p.d.m0.n.m, d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ i1 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.m, d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public l0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return new l0((j0) gVar.refineType(this.k), gVar.refineType(getEnhancement()));
    }
}
