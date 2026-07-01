package d0.e0.p.d.m0.n;

import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.y, reason: use source file name */
/* JADX INFO: compiled from: flexibleTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class flexibleTypes2 {
    public static final KotlinType6 asFlexibleType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        return (KotlinType6) kotlinType.unwrap();
    }

    public static final boolean isFlexible(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.unwrap() instanceof KotlinType6;
    }

    public static final KotlinType4 lowerIfFlexible(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        KotlinType3 kotlinType3Unwrap = kotlinType.unwrap();
        if (kotlinType3Unwrap instanceof KotlinType6) {
            return ((KotlinType6) kotlinType3Unwrap).getLowerBound();
        }
        if (kotlinType3Unwrap instanceof KotlinType4) {
            return (KotlinType4) kotlinType3Unwrap;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final KotlinType4 upperIfFlexible(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        KotlinType3 kotlinType3Unwrap = kotlinType.unwrap();
        if (kotlinType3Unwrap instanceof KotlinType6) {
            return ((KotlinType6) kotlinType3Unwrap).getUpperBound();
        }
        if (kotlinType3Unwrap instanceof KotlinType4) {
            return (KotlinType4) kotlinType3Unwrap;
        }
        throw new NoWhenBranchMatchedException();
    }
}
