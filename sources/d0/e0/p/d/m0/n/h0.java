package d0.e0.p.d.m0.n;

/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends n {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(j0 j0Var) {
        super(j0Var);
        d0.z.d.m.checkNotNullParameter(j0Var, "delegate");
    }

    @Override // d0.e0.p.d.m0.n.m, d0.e0.p.d.m0.n.c0
    public boolean isMarkedNullable() {
        return true;
    }

    @Override // d0.e0.p.d.m0.n.m
    public /* bridge */ /* synthetic */ m replaceDelegate(j0 j0Var) {
        return replaceDelegate(j0Var);
    }

    @Override // d0.e0.p.d.m0.n.m
    public h0 replaceDelegate(j0 j0Var) {
        d0.z.d.m.checkNotNullParameter(j0Var, "delegate");
        return new h0(j0Var);
    }
}
