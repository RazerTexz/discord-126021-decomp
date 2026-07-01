package androidx.core.util;

import androidx.annotation.RequiresApi;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.util.HalfKt, reason: use source file name */
/* JADX INFO: compiled from: Half.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Half {
    @RequiresApi(26)
    public static final android.util.Half toHalf(short s2) {
        android.util.Half halfValueOf = android.util.Half.valueOf(s2);
        Intrinsics3.checkNotNullExpressionValue(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    public static final android.util.Half toHalf(float f) {
        android.util.Half halfValueOf = android.util.Half.valueOf(f);
        Intrinsics3.checkNotNullExpressionValue(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    public static final android.util.Half toHalf(String str) {
        Intrinsics3.checkNotNullParameter(str, "<this>");
        android.util.Half halfValueOf = android.util.Half.valueOf(str);
        Intrinsics3.checkNotNullExpressionValue(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    public static final android.util.Half toHalf(double d) {
        android.util.Half halfValueOf = android.util.Half.valueOf((float) d);
        Intrinsics3.checkNotNullExpressionValue(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }
}
