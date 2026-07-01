package d0.e0.p.d.m0.n;

import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.g1, reason: use source file name */
/* JADX INFO: compiled from: TypeWithEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeWithEnhancement2 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final KotlinType getEnhancement(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        if (kotlinType instanceof TypeWithEnhancement) {
            return ((TypeWithEnhancement) kotlinType).getEnhancement();
        }
        return null;
    }

    public static final KotlinType3 inheritEnhancement(KotlinType3 kotlinType3, KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType3, "<this>");
        Intrinsics3.checkNotNullParameter(kotlinType, "origin");
        return wrapEnhancement(kotlinType3, getEnhancement(kotlinType));
    }

    public static final KotlinType unwrapEnhancement(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        KotlinType enhancement = getEnhancement(kotlinType);
        return enhancement == null ? kotlinType : enhancement;
    }

    public static final KotlinType3 wrapEnhancement(KotlinType3 kotlinType3, KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType3, "<this>");
        if (kotlinType == null) {
            return kotlinType3;
        }
        if (kotlinType3 instanceof KotlinType4) {
            return new TypeWithEnhancement3((KotlinType4) kotlinType3, kotlinType);
        }
        if (kotlinType3 instanceof KotlinType6) {
            return new TypeWithEnhancement4((KotlinType6) kotlinType3, kotlinType);
        }
        throw new NoWhenBranchMatchedException();
    }
}
