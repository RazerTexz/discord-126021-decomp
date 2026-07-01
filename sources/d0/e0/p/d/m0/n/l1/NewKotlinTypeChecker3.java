package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.AbstractTypeChecker;
import d0.e0.p.d.m0.n.AbstractTypeChecker3;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.e0.p.d.m0.n.flexibleTypes2;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.n, reason: use source file name */
/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NewKotlinTypeChecker3 {
    public static final NewKotlinTypeChecker3 a = new NewKotlinTypeChecker3();

    public final boolean isSubtypeOfAny(KotlinType3 kotlinType3) {
        Intrinsics3.checkNotNullParameter(kotlinType3, "type");
        return AbstractTypeChecker.a.hasNotNullSupertype(NewKotlinTypeChecker4.a.newBaseTypeCheckerContext(false, true), flexibleTypes2.lowerIfFlexible(kotlinType3), AbstractTypeChecker3.b.C0411b.a);
    }
}
