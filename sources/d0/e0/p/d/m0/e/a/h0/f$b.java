package d0.e0.p.d.m0.e.a.h0;

/* JADX INFO: compiled from: JavaMethodDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public enum f$b {
    NON_STABLE_DECLARED(false, false),
    STABLE_DECLARED(true, false),
    NON_STABLE_SYNTHESIZED(false, true),
    STABLE_SYNTHESIZED(true, true);

    public final boolean isStable;
    public final boolean isSynthesized;

    f$b(boolean z2, boolean z3) {
        this.isStable = z2;
        this.isSynthesized = z3;
    }

    public static f$b get(boolean z2, boolean z3) {
        if (z2) {
            return z3 ? STABLE_SYNTHESIZED : STABLE_DECLARED;
        }
        return z3 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
    }
}
