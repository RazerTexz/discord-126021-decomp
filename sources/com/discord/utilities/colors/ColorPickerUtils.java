package com.discord.utilities.colors;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import com.discord.R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.font.FontUtils;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;

/* JADX INFO: compiled from: ColorPickerUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ColorPickerUtils {
    public static final ColorPickerUtils INSTANCE = new ColorPickerUtils();

    private ColorPickerUtils() {
    }

    @ColorInt
    private static final int[] getColorsToDisplayForPicker(Resources resources, @ColorInt int i) {
        int[] intArray = resources.getIntArray(R.array.color_picker_palette);
        Intrinsics3.checkNotNullExpressionValue(intArray, "getIntArray(com.discord.…ray.color_picker_palette)");
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
        return _Collections.toIntArray(arrayList);
    }

    public final ColorPickerDialog buildColorPickerDialog(Context context, @StringRes int titleResId, @ColorInt int initialColor) {
        Intrinsics3.checkNotNullParameter(context, "context");
        int[] iArr = ColorPickerDialog.j;
        ColorPickerDialog.k kVar = new ColorPickerDialog.k();
        kVar.h = initialColor;
        kVar.f3148s = ColorCompat.getThemedColor(context, R.attr.colorBackgroundPrimary);
        kVar.i = false;
        Resources resources = context.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
        kVar.g = getColorsToDisplayForPicker(resources, initialColor);
        kVar.a = titleResId;
        kVar.r = ColorCompat.getThemedColor(context, R.attr.colorHeaderPrimary);
        FontUtils fontUtils = FontUtils.INSTANCE;
        kVar.f3149x = fontUtils.getThemedFontResId(context, R.attr.font_display_bold);
        kVar.o = ColorCompat.getThemedColor(context, R.attr.colorBackgroundAccent);
        kVar.c = R.string.color_picker_custom;
        kVar.v = ColorCompat.getColor(context, R.color.white);
        kVar.f3147b = R.string.color_picker_presets;
        kVar.p = ColorCompat.getThemedColor(context, R.attr.color_brand);
        kVar.d = R.string.select;
        kVar.l = true;
        kVar.e = R.string.reset;
        kVar.w = ColorCompat.getColor(context, R.color.white);
        kVar.f3150y = fontUtils.getThemedFontResId(context, R.attr.font_primary_semibold);
        kVar.q = ColorCompat.getThemedColor(context, R.attr.colorBackgroundModifierAccent);
        kVar.t = ColorCompat.getThemedColor(context, R.attr.colorTextMuted);
        kVar.u = R.drawable.drawable_cpv_edit_text_background;
        kVar.f3151z = fontUtils.getThemedFontResId(context, R.attr.font_primary_normal);
        ColorPickerDialog colorPickerDialogA = kVar.a();
        Intrinsics3.checkNotNullExpressionValue(colorPickerDialogA, "ColorPickerDialog.newBui…mal))\n          .create()");
        return colorPickerDialogA;
    }
}
