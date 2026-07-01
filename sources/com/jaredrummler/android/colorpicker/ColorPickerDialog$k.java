package com.jaredrummler.android.colorpicker;

import android.os.Bundle;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.StringRes;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.ViewCompat;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: loaded from: classes3.dex */
public final class ColorPickerDialog$k {

    @StringRes
    public int a = R$e.cpv_default_title;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @StringRes
    public int f3147b = R$e.cpv_presets;

    @StringRes
    public int c = R$e.cpv_custom;

    @StringRes
    public int d = R$e.cpv_select;

    @StringRes
    public int e = 0;
    public int f = 1;
    public int[] g = ColorPickerDialog.j;

    @ColorInt
    public int h = ViewCompat.MEASURED_STATE_MASK;
    public boolean i = false;
    public boolean j = true;
    public boolean k = true;
    public boolean l = true;
    public boolean m = true;
    public int n = 1;

    @ColorInt
    public int o = 0;

    @ColorInt
    public int p = 0;

    @ColorInt
    public int q = 0;

    @ColorInt
    public int r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @ColorInt
    public int f3148s = 0;

    @ColorInt
    public int t = 0;

    @DrawableRes
    public int u = 0;

    @ColorInt
    public int v = 0;

    @ColorInt
    public int w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @FontRes
    public int f3149x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @FontRes
    public int f3150y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @FontRes
    public int f3151z = 0;

    public ColorPickerDialog a() {
        ColorPickerDialog colorPickerDialog = new ColorPickerDialog();
        Bundle bundle = new Bundle();
        bundle.putInt(ModelAuditLogEntry.CHANGE_KEY_ID, 0);
        bundle.putInt("dialogType", this.f);
        bundle.putInt(ModelAuditLogEntry.CHANGE_KEY_COLOR, this.h);
        bundle.putIntArray("presets", this.g);
        bundle.putBoolean(Key.ALPHA, this.i);
        bundle.putBoolean("allowCustom", this.k);
        bundle.putBoolean("allowPresets", this.j);
        bundle.putBoolean("allowReset", this.l);
        bundle.putInt("dialogTitle", this.a);
        bundle.putBoolean("showColorShades", this.m);
        bundle.putInt("colorShape", this.n);
        bundle.putInt("presetsButtonText", this.f3147b);
        bundle.putInt("customButtonText", this.c);
        bundle.putInt("customButtonColor", this.o);
        bundle.putInt("customButtonTextColor", this.v);
        bundle.putInt("selectedButtonText", this.d);
        bundle.putInt("selectedButtonColor", this.p);
        bundle.putInt("selectedButtonTextColor", this.w);
        bundle.putInt("resetButtonText", this.e);
        bundle.putInt("buttonFont", this.f3150y);
        bundle.putInt("titleTextColor", this.r);
        bundle.putInt("titleFont", this.f3149x);
        bundle.putInt("dividerColor", this.q);
        bundle.putInt("backgroundColor", this.f3148s);
        bundle.putInt("inputTextColor", this.t);
        bundle.putInt("inputBackground", this.u);
        bundle.putInt("inputFont", this.f3151z);
        colorPickerDialog.setArguments(bundle);
        return colorPickerDialog;
    }
}
