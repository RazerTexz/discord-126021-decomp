package com.discord.utilities.colors;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import com.discord.C5419R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.font.FontUtils;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import java.util.ArrayList;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ColorPickerUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ColorPickerUtils {
    public static final ColorPickerUtils INSTANCE = new ColorPickerUtils();

    private ColorPickerUtils() {
    }

    @ColorInt
    private static final int[] getColorsToDisplayForPicker(Resources resources, @ColorInt int i) {
        int[] intArray = resources.getIntArray(C5419R.array.color_picker_palette);
        C12238m.checkNotNullExpressionValue(intArray, "getIntArray(com.discord.…ray.color_picker_palette)");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (int i2 : intArray) {
            arrayList.add(Integer.valueOf(i2));
            if (i2 == i) {
                z2 = true;
            }
        }
        if (!z2) {
            arrayList.add(Integer.valueOf(i));
        }
        return C12163u.toIntArray(arrayList);
    }

    public final ColorPickerDialog buildColorPickerDialog(Context context, @StringRes int titleResId, @ColorInt int initialColor) {
        C12238m.checkNotNullParameter(context, "context");
        int[] iArr = ColorPickerDialog.f21707j;
        ColorPickerDialog.C11163k c11163k = new ColorPickerDialog.C11163k();
        c11163k.f21754h = initialColor;
        c11163k.f21765s = ColorCompat.getThemedColor(context, C5419R.attr.colorBackgroundPrimary);
        c11163k.f21755i = false;
        Resources resources = context.getResources();
        C12238m.checkNotNullExpressionValue(resources, "context.resources");
        c11163k.f21753g = getColorsToDisplayForPicker(resources, initialColor);
        c11163k.f21747a = titleResId;
        c11163k.f21764r = ColorCompat.getThemedColor(context, C5419R.attr.colorHeaderPrimary);
        FontUtils fontUtils = FontUtils.INSTANCE;
        c11163k.f21770x = fontUtils.getThemedFontResId(context, C5419R.attr.font_display_bold);
        c11163k.f21761o = ColorCompat.getThemedColor(context, C5419R.attr.colorBackgroundAccent);
        c11163k.f21749c = C5419R.string.color_picker_custom;
        c11163k.f21768v = ColorCompat.getColor(context, C5419R.color.white);
        c11163k.f21748b = C5419R.string.color_picker_presets;
        c11163k.f21762p = ColorCompat.getThemedColor(context, C5419R.attr.color_brand);
        c11163k.f21750d = C5419R.string.select;
        c11163k.f21758l = true;
        c11163k.f21751e = C5419R.string.reset;
        c11163k.f21769w = ColorCompat.getColor(context, C5419R.color.white);
        c11163k.f21771y = fontUtils.getThemedFontResId(context, C5419R.attr.font_primary_semibold);
        c11163k.f21763q = ColorCompat.getThemedColor(context, C5419R.attr.colorBackgroundModifierAccent);
        c11163k.f21766t = ColorCompat.getThemedColor(context, C5419R.attr.colorTextMuted);
        c11163k.f21767u = C5419R.drawable.drawable_cpv_edit_text_background;
        c11163k.f21772z = fontUtils.getThemedFontResId(context, C5419R.attr.font_primary_normal);
        ColorPickerDialog colorPickerDialogM9275a = c11163k.m9275a();
        C12238m.checkNotNullExpressionValue(colorPickerDialogM9275a, "ColorPickerDialog.newBui…mal))\n          .create()");
        return colorPickerDialogM9275a;
    }
}
