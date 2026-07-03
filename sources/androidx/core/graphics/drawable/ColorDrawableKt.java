package androidx.core.graphics.drawable;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ColorDrawable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ColorDrawableKt {
    public static final ColorDrawable toDrawable(@ColorInt int i) {
        return new ColorDrawable(i);
    }

    @RequiresApi(26)
    public static final ColorDrawable toDrawable(Color color) {
        C12238m.checkNotNullParameter(color, "<this>");
        return new ColorDrawable(color.toArgb());
    }
}
