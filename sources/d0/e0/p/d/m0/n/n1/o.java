package d0.e0.p.d.m0.n.n1;

import d0.e0.p.d.m0.n.j1;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static final r convertVariance(j1 j1Var) {
        d0.z.d.m.checkNotNullParameter(j1Var, "<this>");
        int iOrdinal = j1Var.ordinal();
        if (iOrdinal == 0) {
            return r.INV;
        }
        if (iOrdinal == 1) {
            return r.IN;
        }
        if (iOrdinal == 2) {
            return r.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }
}
