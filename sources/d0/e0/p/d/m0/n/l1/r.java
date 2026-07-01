package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.c0;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public final c0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f3531b;

    public r(c0 c0Var, r rVar) {
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
        this.a = c0Var;
        this.f3531b = rVar;
    }

    public final r getPrevious() {
        return this.f3531b;
    }

    public final c0 getType() {
        return this.a;
    }
}
