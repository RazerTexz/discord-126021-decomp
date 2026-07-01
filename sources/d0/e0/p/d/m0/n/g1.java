package d0.e0.p.d.m0.n;

import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: TypeWithEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g1 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final c0 getEnhancement(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        if (c0Var instanceof f1) {
            return ((f1) c0Var).getEnhancement();
        }
        return null;
    }

    public static final i1 inheritEnhancement(i1 i1Var, c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(i1Var, "<this>");
        d0.z.d.m.checkNotNullParameter(c0Var, "origin");
        return wrapEnhancement(i1Var, getEnhancement(c0Var));
    }

    public static final c0 unwrapEnhancement(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        c0 enhancement = getEnhancement(c0Var);
        return enhancement == null ? c0Var : enhancement;
    }

    public static final i1 wrapEnhancement(i1 i1Var, c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(i1Var, "<this>");
        if (c0Var == null) {
            return i1Var;
        }
        if (i1Var instanceof j0) {
            return new l0((j0) i1Var, c0Var);
        }
        if (i1Var instanceof v) {
            return new x((v) i1Var, c0Var);
        }
        throw new NoWhenBranchMatchedException();
    }
}
