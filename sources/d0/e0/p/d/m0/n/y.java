package d0.e0.p.d.m0.n;

import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: flexibleTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y {
    public static final v asFlexibleType(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        return (v) c0Var.unwrap();
    }

    public static final boolean isFlexible(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        return c0Var.unwrap() instanceof v;
    }

    public static final j0 lowerIfFlexible(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        i1 i1VarUnwrap = c0Var.unwrap();
        if (i1VarUnwrap instanceof v) {
            return ((v) i1VarUnwrap).getLowerBound();
        }
        if (i1VarUnwrap instanceof j0) {
            return (j0) i1VarUnwrap;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final j0 upperIfFlexible(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        i1 i1VarUnwrap = c0Var.unwrap();
        if (i1VarUnwrap instanceof v) {
            return ((v) i1VarUnwrap).getUpperBound();
        }
        if (i1VarUnwrap instanceof j0) {
            return (j0) i1VarUnwrap;
        }
        throw new NoWhenBranchMatchedException();
    }
}
