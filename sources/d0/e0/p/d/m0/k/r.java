package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.c.b0;
import d0.e0.p.d.m0.c.c0;

/* JADX INFO: compiled from: ResolutionAnchorProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public static final b0<q> a = new b0<>("ResolutionAnchorProvider");

    public static final c0 getResolutionAnchorIfAny(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        q qVar = (q) c0Var.getCapability(a);
        if (qVar == null) {
            return null;
        }
        return qVar.getResolutionAnchor(c0Var);
    }
}
