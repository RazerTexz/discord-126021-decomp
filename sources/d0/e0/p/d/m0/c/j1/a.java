package d0.e0.p.d.m0.c.j1;

import d0.e0.p.d.m0.c.e1;
import d0.e0.p.d.m0.c.e1$g;
import d0.e0.p.d.m0.c.f1;
import d0.z.d.m;

/* JADX INFO: compiled from: JavaVisibilities.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends f1 {
    public static final a c = new a();

    public a() {
        super("package", false);
    }

    @Override // d0.e0.p.d.m0.c.f1
    public Integer compareTo(f1 f1Var) {
        m.checkNotNullParameter(f1Var, "visibility");
        if (this == f1Var) {
            return 0;
        }
        return e1.a.isPrivate(f1Var) ? 1 : -1;
    }

    @Override // d0.e0.p.d.m0.c.f1
    public String getInternalDisplayName() {
        return "public/*package*/";
    }

    @Override // d0.e0.p.d.m0.c.f1
    public f1 normalize() {
        return e1$g.c;
    }
}
