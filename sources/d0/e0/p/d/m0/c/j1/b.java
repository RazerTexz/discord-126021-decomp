package d0.e0.p.d.m0.c.j1;

import d0.e0.p.d.m0.c.e1;
import d0.e0.p.d.m0.c.e1$b;
import d0.e0.p.d.m0.c.e1$g;
import d0.e0.p.d.m0.c.f1;
import d0.z.d.m;

/* JADX INFO: compiled from: JavaVisibilities.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends f1 {
    public static final b c = new b();

    public b() {
        super("protected_and_package", true);
    }

    @Override // d0.e0.p.d.m0.c.f1
    public Integer compareTo(f1 f1Var) {
        m.checkNotNullParameter(f1Var, "visibility");
        if (m.areEqual(this, f1Var)) {
            return 0;
        }
        if (f1Var == e1$b.c) {
            return null;
        }
        return Integer.valueOf(e1.a.isPrivate(f1Var) ? 1 : -1);
    }

    @Override // d0.e0.p.d.m0.c.f1
    public String getInternalDisplayName() {
        return "protected/*protected and package*/";
    }

    @Override // d0.e0.p.d.m0.c.f1
    public f1 normalize() {
        return e1$g.c;
    }
}
