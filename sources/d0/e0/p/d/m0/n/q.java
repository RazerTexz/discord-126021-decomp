package d0.e0.p.d.m0.n;

/* JADX INFO: compiled from: dynamicTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends v implements d0.e0.p.d.m0.n.n1.e {
    public final d0.e0.p.d.m0.c.g1.g m;

    /* JADX WARN: Illegal instructions before constructor call */
    public q(d0.e0.p.d.m0.b.h hVar, d0.e0.p.d.m0.c.g1.g gVar) {
        d0.z.d.m.checkNotNullParameter(hVar, "builtIns");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        j0 nothingType = hVar.getNothingType();
        d0.z.d.m.checkNotNullExpressionValue(nothingType, "builtIns.nothingType");
        j0 nullableAnyType = hVar.getNullableAnyType();
        d0.z.d.m.checkNotNullExpressionValue(nullableAnyType, "builtIns.nullableAnyType");
        super(nothingType, nullableAnyType);
        this.m = gVar;
    }

    @Override // d0.e0.p.d.m0.n.v, d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        return this.m;
    }

    @Override // d0.e0.p.d.m0.n.v
    public j0 getDelegate() {
        return getUpperBound();
    }

    @Override // d0.e0.p.d.m0.n.v, d0.e0.p.d.m0.n.c0
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.i1
    public q makeNullableAsSpecified(boolean z2) {
        return this;
    }

    @Override // d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ c0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public q refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // d0.e0.p.d.m0.n.v
    public String render(d0.e0.p.d.m0.j.c cVar, d0.e0.p.d.m0.j.h hVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "renderer");
        d0.z.d.m.checkNotNullParameter(hVar, "options");
        return "dynamic";
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        return replaceAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ i1 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.i1
    public q replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "newAnnotations");
        return new q(d0.e0.p.d.m0.n.o1.a.getBuiltIns(getDelegate()), gVar);
    }
}
