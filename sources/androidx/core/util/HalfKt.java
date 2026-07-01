package androidx.core.util;

import android.util.Half;
import androidx.annotation.RequiresApi;
import d0.z.d.m;

/* JADX INFO: compiled from: Half.kt */
/* JADX INFO: loaded from: classes.dex */
public final class HalfKt {
    @RequiresApi(26)
    public static final Half toHalf(short s2) {
        Half halfValueOf = Half.valueOf(s2);
        m.checkNotNullExpressionValue(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(float f) {
        Half halfValueOf = Half.valueOf(f);
        m.checkNotNullExpressionValue(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(String str) {
        m.checkNotNullParameter(str, "<this>");
        Half halfValueOf = Half.valueOf(str);
        m.checkNotNullExpressionValue(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(double d) {
        Half halfValueOf = Half.valueOf((float) d);
        m.checkNotNullExpressionValue(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }
}
