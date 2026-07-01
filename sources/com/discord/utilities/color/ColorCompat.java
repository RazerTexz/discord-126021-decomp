package com.discord.utilities.color;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ColorCompat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ColorCompat {
    public static final ColorCompat INSTANCE = new ColorCompat();

    private ColorCompat() {
    }

    @ColorInt
    public static final int getColor(Context context, @ColorRes int colorResourceId) {
        if (context != null) {
            return ContextCompat.getColor(context, colorResourceId);
        }
        return 0;
    }

    @ColorInt
    public static final int getThemedColor(Context context, @AttrRes int attributeResourceId) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context != null ? context.getTheme() : null;
        if (theme != null) {
            theme.resolveAttribute(attributeResourceId, typedValue, true);
        }
        return typedValue.data;
    }

    public static final boolean isColorDark(int i) {
        return isColorDark$default(i, 0.0f, 2, null);
    }

    public static final boolean isColorDark(int color, float darkThreshold) {
        return ((double) 1) - (((((double) Color.blue(color)) * 0.114d) + ((((double) Color.green(color)) * 0.587d) + (((double) Color.red(color)) * 0.299d))) / ((double) 255)) >= ((double) darkThreshold);
    }

    public static /* synthetic */ boolean isColorDark$default(int i, float f, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 0.4f;
        }
        return isColorDark(i, f);
    }

    public static final void setStatusBarColor(Activity activity, @ColorInt int i) {
        setStatusBarColor$default(activity, i, false, 4, (Object) null);
    }

    public static final void setStatusBarColor(Window window, @ColorInt int i) {
        setStatusBarColor$default(window, i, false, 4, (Object) null);
    }

    public static final void setStatusBarColor(Fragment fragment, @ColorInt int i) {
        setStatusBarColor$default(fragment, i, false, 4, (Object) null);
    }

    public static final void setStatusBarColor(Fragment fragment, @ColorInt int color, boolean forceDarkUi) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        setStatusBarColor(fragment.e(), color, forceDarkUi);
    }

    public static /* synthetic */ void setStatusBarColor$default(Fragment fragment, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        setStatusBarColor(fragment, i, z2);
    }

    public static final void setStatusBarColorResourceId(Fragment fragment, @ColorRes int colorResourceId) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        setStatusBarColorResourceId(fragment.e(), colorResourceId);
    }

    public static final void setStatusBarTranslucent(Fragment fragment) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        setStatusBarTranslucent(fragment.e());
    }

    public final ColorStateList createDefaultColorStateList(@ColorInt int color) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{-16842910}, new int[]{-16842912}, new int[]{R.attr.state_pressed}}, new int[]{color, color, color, color});
    }

    public final String getColorHexFromColorInt(@ColorInt int colorInt) {
        return outline.P(new Object[]{Integer.valueOf(colorInt & ViewCompat.MEASURED_SIZE_MASK)}, 1, "#%06X", "java.lang.String.format(format, *args)");
    }

    public final int removeAlphaComponent(@ColorInt int colorInt) {
        return Color.argb(0, Color.red(colorInt), Color.green(colorInt), Color.blue(colorInt));
    }

    @ColorInt
    public static final int getColor(View view, @ColorRes int colorResourceId) {
        Intrinsics3.checkNotNullParameter(view, "view");
        return getColor(view.getContext(), colorResourceId);
    }

    public static final void setStatusBarColor(Activity activity, @ColorInt int color, boolean forceDarkUi) {
        setStatusBarColor(activity != null ? activity.getWindow() : null, color, forceDarkUi);
    }

    public static /* synthetic */ void setStatusBarColor$default(Activity activity, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        setStatusBarColor(activity, i, z2);
    }

    public static final void setStatusBarColorResourceId(Activity activity, @ColorRes int colorResourceId) {
        setStatusBarColorResourceId(activity != null ? activity.getWindow() : null, colorResourceId);
    }

    public static final void setStatusBarTranslucent(Activity activity) {
        setStatusBarTranslucent(activity != null ? activity.getWindow() : null);
    }

    @ColorInt
    public static final int getColor(Fragment fragment, @ColorRes int colorResourceId) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        return getColor(fragment.getContext(), colorResourceId);
    }

    public static final void setStatusBarColor(Window window, @ColorInt int color, boolean forceDarkUi) {
        View decorView;
        if (window != null) {
            window.clearFlags(67108864);
        }
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
        }
        if (window != null) {
            window.setStatusBarColor(color);
        }
        if (Build.VERSION.SDK_INT < 23 || !forceDarkUi || window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setSystemUiVisibility(0);
    }

    public static /* synthetic */ void setStatusBarColor$default(Window window, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        setStatusBarColor(window, i, z2);
    }

    public static final void setStatusBarColorResourceId(Window window, @ColorRes int colorResourceId) {
        setStatusBarColor$default(window, getColor(window != null ? window.getContext() : null, colorResourceId), false, 4, (Object) null);
    }

    public static final void setStatusBarTranslucent(Window window) {
        if (window != null) {
            window.setFlags(67108864, 67108864);
        }
    }

    @ColorInt
    public static final int getThemedColor(View view, @AttrRes int attributeResourceId) {
        Intrinsics3.checkNotNullParameter(view, "view");
        return getThemedColor(view.getContext(), attributeResourceId);
    }

    @ColorInt
    public static final int getThemedColor(Fragment fragment, @AttrRes int attributeResourceId) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        return getThemedColor(fragment.getContext(), attributeResourceId);
    }
}
