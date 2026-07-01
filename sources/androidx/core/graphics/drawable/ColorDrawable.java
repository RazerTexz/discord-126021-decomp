package androidx.core.graphics.drawable;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.graphics.drawable.ColorDrawableKt, reason: use source file name */
/* JADX INFO: compiled from: ColorDrawable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ColorDrawable {
    public static final android.graphics.drawable.ColorDrawable toDrawable(@ColorInt int i) {
        return new android.graphics.drawable.ColorDrawable(i);
    }

    @RequiresApi(26)
    public static final android.graphics.drawable.ColorDrawable toDrawable(Color color) {
        Intrinsics3.checkNotNullParameter(color, "<this>");
        return new android.graphics.drawable.ColorDrawable(color.toArgb());
    }
}
