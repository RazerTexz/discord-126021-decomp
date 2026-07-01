package d0.e0.p.d.m0.n;

/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n extends m {
    public final j0 k;

    public n(j0 j0Var) {
        d0.z.d.m.checkNotNullParameter(j0Var, "delegate");
        this.k = j0Var;
    }

    @Override // d0.e0.p.d.m0.n.m
    public j0 getDelegate() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ j0 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        return replaceAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public j0 makeNullableAsSpecified(boolean z2) {
        return z2 == isMarkedNullable() ? this : this.k.makeNullableAsSpecified(z2).replaceAnnotations(getAnnotations());
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        return replaceAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public n replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "newAnnotations");
        return gVar != getAnnotations() ? new h(this, gVar) : this;
    }
}
