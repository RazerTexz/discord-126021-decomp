package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.n.KotlinType;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.j, reason: use source file name */
/* JADX INFO: compiled from: ConstUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConstUtil {
    public static final boolean canBeUsedForConstVal(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        return ConstUtil2.canBeUsedForConstVal(kotlinType);
    }
}
