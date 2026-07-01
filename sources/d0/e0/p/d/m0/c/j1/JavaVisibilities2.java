package d0.e0.p.d.m0.c.j1;

import d0.e0.p.d.m0.c.Visibilities;
import d0.e0.p.d.m0.c.Visibility2;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.j1.b, reason: use source file name */
/* JADX INFO: compiled from: JavaVisibilities.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaVisibilities2 extends Visibility2 {
    public static final JavaVisibilities2 c = new JavaVisibilities2();

    public JavaVisibilities2() {
        super("protected_and_package", true);
    }

    @Override // d0.e0.p.d.m0.c.Visibility2
    public Integer compareTo(Visibility2 visibility2) {
        Intrinsics3.checkNotNullParameter(visibility2, "visibility");
        if (Intrinsics3.areEqual(this, visibility2)) {
            return 0;
        }
        if (visibility2 == Visibilities.b.c) {
            return null;
        }
        return Integer.valueOf(Visibilities.a.isPrivate(visibility2) ? 1 : -1);
    }

    @Override // d0.e0.p.d.m0.c.Visibility2
    public String getInternalDisplayName() {
        return "protected/*protected and package*/";
    }

    @Override // d0.e0.p.d.m0.c.Visibility2
    public Visibility2 normalize() {
        return Visibilities.g.c;
    }
}
