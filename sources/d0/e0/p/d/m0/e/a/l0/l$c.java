package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.n.c0;

/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l$c extends l$a {
    public final boolean d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l$c(c0 c0Var, boolean z2, boolean z3, boolean z4) {
        super(c0Var, z3, z4);
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
        this.d = z2;
    }

    public final boolean getHasDefaultValue() {
        return this.d;
    }
}
