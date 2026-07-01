package d0.e0.p.d.m0.n;

/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends m {
    public final j0 k;
    public final j0 l;

    public a(j0 j0Var, j0 j0Var2) {
        d0.z.d.m.checkNotNullParameter(j0Var, "delegate");
        d0.z.d.m.checkNotNullParameter(j0Var2, "abbreviation");
        this.k = j0Var;
        this.l = j0Var2;
    }

    public final j0 getAbbreviation() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.n.m
    public j0 getDelegate() {
        return this.k;
    }

    public final j0 getExpandedType() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ j0 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.m, d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ c0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ j0 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        return replaceAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.n.m
    public /* bridge */ /* synthetic */ m replaceDelegate(j0 j0Var) {
        return replaceDelegate(j0Var);
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.m, d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ j0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        return replaceAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.n.m
    public a replaceDelegate(j0 j0Var) {
        d0.z.d.m.checkNotNullParameter(j0Var, "delegate");
        return new a(j0Var, this.l);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public a makeNullableAsSpecified(boolean z2) {
        return new a(this.k.makeNullableAsSpecified(z2), this.l.makeNullableAsSpecified(z2));
    }

    @Override // d0.e0.p.d.m0.n.m, d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ i1 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public a replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "newAnnotations");
        return new a(this.k.replaceAnnotations(gVar), this.l);
    }

    @Override // d0.e0.p.d.m0.n.m, d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public a refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return new a((j0) gVar.refineType(this.k), (j0) gVar.refineType(this.l));
    }
}
