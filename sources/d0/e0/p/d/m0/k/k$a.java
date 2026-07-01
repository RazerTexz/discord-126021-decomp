package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.n.u0;

/* JADX INFO: compiled from: OverridingUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class k$a implements d0.e0.p.d.m0.n.l1.f$a {
    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i != 1) {
            objArr[0] = "a";
        } else {
            objArr[0] = "b";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
        objArr[2] = "equals";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // d0.e0.p.d.m0.n.l1.f$a
    public boolean equals(u0 u0Var, u0 u0Var2) {
        if (u0Var == null) {
            a(0);
            throw null;
        }
        if (u0Var2 != null) {
            return u0Var.equals(u0Var2);
        }
        a(1);
        throw null;
    }
}
