package d0.e0.p.d.m0.n;

/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends n {
    public final d0.e0.p.d.m0.c.g1.g l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(j0 j0Var, d0.e0.p.d.m0.c.g1.g gVar) {
        super(j0Var);
        d0.z.d.m.checkNotNullParameter(j0Var, "delegate");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        this.l = gVar;
    }

    @Override // d0.e0.p.d.m0.n.m, d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.n.m
    public /* bridge */ /* synthetic */ m replaceDelegate(j0 j0Var) {
        return replaceDelegate(j0Var);
    }

    @Override // d0.e0.p.d.m0.n.m
    public h replaceDelegate(j0 j0Var) {
        d0.z.d.m.checkNotNullParameter(j0Var, "delegate");
        return new h(j0Var, getAnnotations());
    }
}
