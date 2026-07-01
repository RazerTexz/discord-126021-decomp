package com.discord.utilities.font;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.provider.Settings;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.core.content.res.ResourcesCompat;
import com.discord.stores.StoreStream;
import d0.a0.MathJVM;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: FontUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FontUtils {
    public static final FontUtils INSTANCE = new FontUtils();
    public static final int MAX_FONT_SCALING = 150;
    public static final int MIN_FONT_SCALING = 80;
    public static final int USE_SYSTEM_FONT_SCALE = -1;

    private FontUtils() {
    }

    public final int getSystemFontScaleInt(ContentResolver contentResolver) {
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        return MathJVM.roundToInt(Settings.System.getFloat(contentResolver, "font_scale", 1.0f) * 100);
    }

    public final float getTargetFontScaleFloat(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return companion.getUserSettingsSystem().getFontScale() == -1 ? Settings.System.getFloat(context.getContentResolver(), "font_scale", 1.0f) : companion.getUserSettingsSystem().getFontScale() / 100.0f;
    }

    public final Typeface getThemedFont(Context context, @AttrRes int attrResourceId) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return ResourcesCompat.getFont(context, getThemedFontResId(context, attrResourceId));
    }

    public final int getThemedFontResId(Context context, @AttrRes int attrResourceId) {
        Resources.Theme theme;
        TypedValue typedValue = new TypedValue();
        if (context != null && (theme = context.getTheme()) != null) {
            theme.resolveAttribute(attrResourceId, typedValue, true);
        }
        return typedValue.resourceId;
    }
}
