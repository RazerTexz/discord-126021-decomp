package d0.e0.p.d.m0.n.p1;

import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.l1.f;
import d0.z.d.m;

/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public final z0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f3535b;
    public final c0 c;

    public d(z0 z0Var, c0 c0Var, c0 c0Var2) {
        m.checkNotNullParameter(z0Var, "typeParameter");
        m.checkNotNullParameter(c0Var, "inProjection");
        m.checkNotNullParameter(c0Var2, "outProjection");
        this.a = z0Var;
        this.f3535b = c0Var;
        this.c = c0Var2;
    }

    public final c0 getInProjection() {
        return this.f3535b;
    }

    public final c0 getOutProjection() {
        return this.c;
    }

    public final z0 getTypeParameter() {
        return this.a;
    }

    public final boolean isConsistent() {
        return f.a.isSubtypeOf(this.f3535b, this.c);
    }
}
