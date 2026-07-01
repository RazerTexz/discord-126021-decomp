package d0.e0.p.d.m0.n.n1;

import d0.e0.p.d.m0.n.Variance;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static final r convertVariance(Variance variance) {
        Intrinsics3.checkNotNullParameter(variance, "<this>");
        int iOrdinal = variance.ordinal();
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
