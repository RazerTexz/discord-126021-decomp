package d0.e0.p.d.m0.n.p1;

import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.v0;
import d0.e0.p.d.m0.n.w0;
import d0.e0.p.d.m0.n.y0;
import d0.z.d.m;

/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends v0 {
    @Override // d0.e0.p.d.m0.n.v0
    public w0 get(u0 u0Var) {
        m.checkNotNullParameter(u0Var, "key");
        d0.e0.p.d.m0.k.u.a.b bVar = u0Var instanceof d0.e0.p.d.m0.k.u.a.b ? (d0.e0.p.d.m0.k.u.a.b) u0Var : null;
        if (bVar == null) {
            return null;
        }
        return bVar.getProjection().isStarProjection() ? new y0(j1.OUT_VARIANCE, bVar.getProjection().getType()) : bVar.getProjection();
    }
}
