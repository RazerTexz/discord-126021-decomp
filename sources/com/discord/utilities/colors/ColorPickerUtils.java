package com.discord.utilities.colors;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import com.discord.R$array;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.font.FontUtils;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialog$k;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;

/* JADX INFO: compiled from: ColorPickerUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ColorPickerUtils {
    public static final ColorPickerUtils INSTANCE = new ColorPickerUtils();

    private ColorPickerUtils() {
    }

    @ColorInt
    private static final int[] getColorsToDisplayForPicker(Resources resources, @ColorInt int i) {
        int[] intArray = resources.getIntArray(R$array.color_picker_palette);
        m.checkNotNullExpressionValue(intArray, "getIntArray(com.discord.…ray.color_picker_palette)");
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
        return u.toIntArray(arrayList);
    }

    public final ColorPickerDialog buildColorPickerDialog(Context context, @StringRes int titleResId, @ColorInt int initialColor) {
        m.checkNotNullParameter(context, "context");
        int[] iArr = ColorPickerDialog.j;
        ColorPickerDialog$k colorPickerDialog$k = new ColorPickerDialog$k();
        colorPickerDialog$k.h = initialColor;
        colorPickerDialog$k.f3148s = ColorCompat.getThemedColor(context, 2130968911);
        colorPickerDialog$k.i = false;
        Resources resources = context.getResources();
        m.checkNotNullExpressionValue(resources, "context.resources");
        colorPickerDialog$k.g = getColorsToDisplayForPicker(resources, initialColor);
        colorPickerDialog$k.a = titleResId;
        colorPickerDialog$k.r = ColorCompat.getThemedColor(context, 2130968989);
        FontUtils fontUtils = FontUtils.INSTANCE;
        colorPickerDialog$k.f3149x = fontUtils.getThemedFontResId(context, 2130969390);
        colorPickerDialog$k.o = ColorCompat.getThemedColor(context, 2130968896);
        colorPickerDialog$k.c = 2131887706;
        colorPickerDialog$k.v = ColorCompat.getColor(context, 2131100487);
        colorPickerDialog$k.f3147b = 2131887707;
        colorPickerDialog$k.p = ColorCompat.getThemedColor(context, 2130969062);
        colorPickerDialog$k.d = 2131895390;
        colorPickerDialog$k.l = true;
        colorPickerDialog$k.e = 2131894833;
        colorPickerDialog$k.w = ColorCompat.getColor(context, 2131100487);
        colorPickerDialog$k.f3150y = fontUtils.getThemedFontResId(context, 2130969396);
        colorPickerDialog$k.q = ColorCompat.getThemedColor(context, 2130968906);
        colorPickerDialog$k.t = ColorCompat.getThemedColor(context, 2130969056);
        colorPickerDialog$k.u = 2131231203;
        colorPickerDialog$k.f3151z = fontUtils.getThemedFontResId(context, 2130969395);
        ColorPickerDialog colorPickerDialogA = colorPickerDialog$k.a();
        m.checkNotNullExpressionValue(colorPickerDialogA, "ColorPickerDialog.newBui…mal))\n          .create()");
        return colorPickerDialogA;
    }
}
