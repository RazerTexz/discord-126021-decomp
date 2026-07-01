package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.n.c0;

/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public class l$a {
    public final c0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3349b;
    public final boolean c;

    public l$a(c0 c0Var, boolean z2, boolean z3) {
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
        this.a = c0Var;
        this.f3349b = z2;
        this.c = z3;
    }

    public final boolean getContainsFunctionN() {
        return this.c;
    }

    public final c0 getType() {
        return this.a;
    }

    public final boolean getWereChanges() {
        return this.f3349b;
    }
}
