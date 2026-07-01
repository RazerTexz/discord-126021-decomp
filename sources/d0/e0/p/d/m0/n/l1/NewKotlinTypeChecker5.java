package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.AbstractStrictEqualityTypeChecker;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.q, reason: use source file name */
/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NewKotlinTypeChecker5 {
    public static final NewKotlinTypeChecker5 a = new NewKotlinTypeChecker5();

    public final boolean strictEqualTypes(KotlinType3 kotlinType3, KotlinType3 kotlinType4) {
        Intrinsics3.checkNotNullParameter(kotlinType3, "a");
        Intrinsics3.checkNotNullParameter(kotlinType4, "b");
        return AbstractStrictEqualityTypeChecker.a.strictEqualTypes(NewKotlinTypeChecker4.a, kotlinType3, kotlinType4);
    }
}
