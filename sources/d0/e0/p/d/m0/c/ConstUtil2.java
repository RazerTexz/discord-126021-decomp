package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.b.UnsignedType3;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k, reason: use source file name */
/* JADX INFO: compiled from: ConstUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConstUtil2 {
    /* JADX WARN: Code duplicated, block: B:11:0x0020 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:6:0x0013  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    public static final boolean canBeUsedForConstVal(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        if (!KotlinBuiltIns.isPrimitiveType(kotlinType)) {
            UnsignedType3 unsignedType3 = UnsignedType3.a;
            if (UnsignedType3.isUnsignedType(kotlinType)) {
                if (TypeUtils.isNullableType(kotlinType)) {
                    if (!KotlinBuiltIns.isString(kotlinType)) {
                        return false;
                    }
                }
            } else if (!KotlinBuiltIns.isString(kotlinType)) {
                return false;
            }
        } else if (TypeUtils.isNullableType(kotlinType)) {
            if (!KotlinBuiltIns.isString(kotlinType)) {
                return false;
            }
        }
        return true;
    }
}
