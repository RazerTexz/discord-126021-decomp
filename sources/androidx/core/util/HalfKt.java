package androidx.core.util;

import android.util.Half;
import androidx.annotation.RequiresApi;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Half.kt */
/* JADX INFO: loaded from: classes.dex */
public final class HalfKt {
    @RequiresApi(26)
    public static final Half toHalf(short s2) {
        Half halfValueOf = Half.valueOf(s2);
        C12238m.checkNotNullExpressionValue(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(float f) {
        Half halfValueOf = Half.valueOf(f);
        C12238m.checkNotNullExpressionValue(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(String str) {
        C12238m.checkNotNullParameter(str, "<this>");
        Half halfValueOf = Half.valueOf(str);
        C12238m.checkNotNullExpressionValue(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(double d) {
        Half halfValueOf = Half.valueOf((float) d);
        C12238m.checkNotNullExpressionValue(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }
}
