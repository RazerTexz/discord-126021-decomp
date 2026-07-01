package d0.e0.p.d.m0.c.j1;

import d0.e0.p.d.m0.c.Visibilities;
import d0.e0.p.d.m0.c.Visibility2;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.j1.a, reason: use source file name */
/* JADX INFO: compiled from: JavaVisibilities.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaVisibilities extends Visibility2 {
    public static final JavaVisibilities c = new JavaVisibilities();

    public JavaVisibilities() {
        super("package", false);
    }

    @Override // d0.e0.p.d.m0.c.Visibility2
    public Integer compareTo(Visibility2 visibility2) {
        Intrinsics3.checkNotNullParameter(visibility2, "visibility");
        if (this == visibility2) {
            return 0;
        }
        return Visibilities.a.isPrivate(visibility2) ? 1 : -1;
    }

    @Override // d0.e0.p.d.m0.c.Visibility2
    public String getInternalDisplayName() {
        return "public/*package*/";
    }

    @Override // d0.e0.p.d.m0.c.Visibility2
    public Visibility2 normalize() {
        return Visibilities.g.c;
    }
}
