package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11714c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.j */
/* JADX INFO: compiled from: BuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11560j {
    public static final C11713b access$child(C11713b c11713b, String str) {
        C11713b c11713bChild = c11713b.child(C11716e.identifier(str));
        C12238m.checkNotNullExpressionValue(c11713bChild, "child(Name.identifier(name))");
        return c11713bChild;
    }

    public static final C11713b access$childSafe(C11714c c11714c, String str) {
        C11713b safe = c11714c.child(C11716e.identifier(str)).toSafe();
        C12238m.checkNotNullExpressionValue(safe, "child(Name.identifier(name)).toSafe()");
        return safe;
    }
}
