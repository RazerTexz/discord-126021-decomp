package d0.e0.p.d.m0.c.j1;

import d0.e0.p.d.m0.c.Visibilities;
import d0.e0.p.d.m0.c.Visibility2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.j1.c, reason: use source file name */
/* JADX INFO: compiled from: JavaVisibilities.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaVisibilities3 extends Visibility2 {
    public static final JavaVisibilities3 c = new JavaVisibilities3();

    public JavaVisibilities3() {
        super("protected_static", true);
    }

    @Override // d0.e0.p.d.m0.c.Visibility2
    public String getInternalDisplayName() {
        return "protected/*protected static*/";
    }

    @Override // d0.e0.p.d.m0.c.Visibility2
    public Visibility2 normalize() {
        return Visibilities.g.c;
    }
}
