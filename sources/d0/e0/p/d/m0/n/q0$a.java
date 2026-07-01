package d0.e0.p.d.m0.n;

import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TypeAliasExpander.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q0$a {
    public q0$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static final void access$assertRecursionDepth(q0$a q0_a, int i, d0.e0.p.d.m0.c.y0 y0Var) {
        Objects.requireNonNull(q0_a);
        if (i > 100) {
            throw new AssertionError(d0.z.d.m.stringPlus("Too deep recursion while expanding type alias ", y0Var.getName()));
        }
    }

    public final void checkBoundsInTypeAlias(s0 s0Var, c0 c0Var, c0 c0Var2, d0.e0.p.d.m0.c.z0 z0Var, c1 c1Var) {
        d0.z.d.m.checkNotNullParameter(s0Var, "reportStrategy");
        d0.z.d.m.checkNotNullParameter(c0Var, "unsubstitutedArgument");
        d0.z.d.m.checkNotNullParameter(c0Var2, "typeArgument");
        d0.z.d.m.checkNotNullParameter(z0Var, "typeParameterDescriptor");
        d0.z.d.m.checkNotNullParameter(c1Var, "substitutor");
        Iterator<c0> it = z0Var.getUpperBounds().iterator();
        while (it.hasNext()) {
            c0 c0VarSafeSubstitute = c1Var.safeSubstitute(it.next(), j1.INVARIANT);
            d0.z.d.m.checkNotNullExpressionValue(c0VarSafeSubstitute, "substitutor.safeSubstitute(bound, Variance.INVARIANT)");
            if (!d0.e0.p.d.m0.n.l1.f.a.isSubtypeOf(c0Var2, c0VarSafeSubstitute)) {
                s0Var.boundsViolationInSubstitution(c0VarSafeSubstitute, c0Var, c0Var2, z0Var);
            }
        }
    }
}
