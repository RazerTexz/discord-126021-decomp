package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.h */
/* JADX INFO: compiled from: ReflectKotlinClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11415h {
    public static final String access$toRuntimeFqName(C11712a c11712a) {
        String strAsString = c11712a.getRelativeClassName().asString();
        C12238m.checkNotNullExpressionValue(strAsString, "relativeClassName.asString()");
        String strReplace$default = C12103t.replace$default(strAsString, '.', '$', false, 4, (Object) null);
        if (c11712a.getPackageFqName().isRoot()) {
            return strReplace$default;
        }
        return c11712a.getPackageFqName() + '.' + strReplace$default;
    }
}
