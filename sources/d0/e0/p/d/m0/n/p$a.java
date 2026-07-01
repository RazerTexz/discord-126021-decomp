package d0.e0.p.d.m0.n;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DisjointKeysUnionTypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p$a {
    public p$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final z0 create(z0 z0Var, z0 z0Var2) {
        d0.z.d.m.checkNotNullParameter(z0Var, "first");
        d0.z.d.m.checkNotNullParameter(z0Var2, "second");
        if (z0Var.isEmpty()) {
            return z0Var2;
        }
        return z0Var2.isEmpty() ? z0Var : new p(z0Var, z0Var2, null);
    }
}
