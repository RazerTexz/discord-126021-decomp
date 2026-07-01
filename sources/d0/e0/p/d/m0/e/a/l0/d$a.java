package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.n.c0;

/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public class d$a {
    public final c0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3343b;
    public final boolean c;

    public d$a(c0 c0Var, int i, boolean z2) {
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
        this.a = c0Var;
        this.f3343b = i;
        this.c = z2;
    }

    public final int getSubtreeSize() {
        return this.f3343b;
    }

    public c0 getType() {
        return this.a;
    }

    public final c0 getTypeIfChanged() {
        c0 type = getType();
        if (getWereChanges()) {
            return type;
        }
        return null;
    }

    public final boolean getWereChanges() {
        return this.c;
    }
}
