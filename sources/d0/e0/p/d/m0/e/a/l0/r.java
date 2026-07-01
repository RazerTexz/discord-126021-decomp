package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.i1;

/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public static final boolean access$isNullabilityFlexible(c0 c0Var) {
        i1 i1VarUnwrap = c0Var.unwrap();
        d0.e0.p.d.m0.n.v vVar = i1VarUnwrap instanceof d0.e0.p.d.m0.n.v ? (d0.e0.p.d.m0.n.v) i1VarUnwrap : null;
        return (vVar == null || vVar.getLowerBound().isMarkedNullable() == vVar.getUpperBound().isMarkedNullable()) ? false : true;
    }
}
