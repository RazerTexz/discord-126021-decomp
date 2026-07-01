package d0.e0.p.d.m0.n;

import kotlin.Lazy;

/* JADX INFO: compiled from: StarProjectionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o0 extends x0 {
    public final d0.e0.p.d.m0.c.z0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f3532b;

    public o0(d0.e0.p.d.m0.c.z0 z0Var) {
        d0.z.d.m.checkNotNullParameter(z0Var, "typeParameter");
        this.a = z0Var;
        this.f3532b = d0.g.lazy(d0.i.PUBLICATION, new o0$a(this));
    }

    public static final /* synthetic */ d0.e0.p.d.m0.c.z0 access$getTypeParameter$p(o0 o0Var) {
        return o0Var.a;
    }

    @Override // d0.e0.p.d.m0.n.w0
    public j1 getProjectionKind() {
        return j1.OUT_VARIANCE;
    }

    @Override // d0.e0.p.d.m0.n.w0
    public c0 getType() {
        return (c0) this.f3532b.getValue();
    }

    @Override // d0.e0.p.d.m0.n.w0
    public boolean isStarProjection() {
        return true;
    }

    @Override // d0.e0.p.d.m0.n.w0
    public w0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return this;
    }
}
