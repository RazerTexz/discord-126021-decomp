package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsVoiceBinding implements ViewBinding {

    @NonNull
    public final LinearLayout A;

    @NonNull
    public final RelativeLayout B;

    @NonNull
    public final TextView C;

    @NonNull
    public final LinkifiedTextView D;

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CheckedSetting f2641b;

    @NonNull
    public final CheckedSetting c;

    @NonNull
    public final CheckedSetting d;

    @NonNull
    public final CheckedSetting e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final CheckedSetting h;

    @NonNull
    public final RelativeLayout i;

    @NonNull
    public final TextView j;

    @NonNull
    public final CheckedSetting k;

    @NonNull
    public final CheckedSetting l;

    @NonNull
    public final TextView m;

    @NonNull
    public final CheckedSetting n;

    @NonNull
    public final CheckedSetting o;

    @NonNull
    public final CheckedSetting p;

    @NonNull
    public final TextView q;

    @NonNull
    public final TextView r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final SeekBar f2642s;

    @NonNull
    public final TextView t;

    @NonNull
    public final CheckedSetting u;

    @NonNull
    public final TextView v;

    @NonNull
    public final View w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public final TextView f2643x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    public final SeekBar f2644y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2645z;

    public WidgetSettingsVoiceBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull CheckedSetting checkedSetting4, @NonNull TextView textView, @NonNull TextView textView2, @NonNull CheckedSetting checkedSetting5, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull CheckedSetting checkedSetting6, @NonNull CheckedSetting checkedSetting7, @NonNull TextView textView5, @NonNull CheckedSetting checkedSetting8, @NonNull CheckedSetting checkedSetting9, @NonNull CheckedSetting checkedSetting10, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull SeekBar seekBar, @NonNull LinearLayout linearLayout, @NonNull TextView textView8, @NonNull CheckedSetting checkedSetting11, @NonNull TextView textView9, @NonNull View view, @NonNull TextView textView10, @NonNull TextView textView11, @NonNull SeekBar seekBar2, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout2, @NonNull LinearLayout linearLayout3, @NonNull TextView textView12, @NonNull LinkifiedTextView linkifiedTextView) {
        this.a = coordinatorLayout;
        this.f2641b = checkedSetting;
        this.c = checkedSetting2;
        this.d = checkedSetting3;
        this.e = checkedSetting4;
        this.f = textView;
        this.g = textView2;
        this.h = checkedSetting5;
        this.i = relativeLayout;
        this.j = textView4;
        this.k = checkedSetting6;
        this.l = checkedSetting7;
        this.m = textView5;
        this.n = checkedSetting8;
        this.o = checkedSetting9;
        this.p = checkedSetting10;
        this.q = textView6;
        this.r = textView7;
        this.f2642s = seekBar;
        this.t = textView8;
        this.u = checkedSetting11;
        this.v = textView9;
        this.w = view;
        this.f2643x = textView11;
        this.f2644y = seekBar2;
        this.f2645z = materialButton;
        this.A = linearLayout2;
        this.B = relativeLayout2;
        this.C = textView12;
        this.D = linkifiedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
