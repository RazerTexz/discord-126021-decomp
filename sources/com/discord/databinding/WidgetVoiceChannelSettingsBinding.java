package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceChannelSettingsBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SeekBar f2702b;

    @NonNull
    public final TextInputLayout c;

    @NonNull
    public final TextInputLayout d;

    @NonNull
    public final CheckedSetting e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final LinearLayout h;

    @NonNull
    public final TextView i;

    @NonNull
    public final FloatingActionButton j;

    @NonNull
    public final LinearLayout k;

    @NonNull
    public final LinearLayout l;

    @NonNull
    public final TextView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final View o;

    @NonNull
    public final TextView p;

    @NonNull
    public final LinearLayout q;

    @NonNull
    public final TextView r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final View f2703s;

    @NonNull
    public final SeekBar t;

    @NonNull
    public final TextView u;

    public WidgetVoiceChannelSettingsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull SeekBar seekBar, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull CheckedSetting checkedSetting, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull TextView textView4, @NonNull FloatingActionButton floatingActionButton, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull View view2, @NonNull LinearLayout linearLayout4, @NonNull TextView textView7, @NonNull LinearLayout linearLayout5, @NonNull TextView textView8, @NonNull View view3, @NonNull SeekBar seekBar2, @NonNull TextView textView9) {
        this.a = coordinatorLayout;
        this.f2702b = seekBar;
        this.c = textInputLayout;
        this.d = textInputLayout2;
        this.e = checkedSetting;
        this.f = textView2;
        this.g = textView3;
        this.h = linearLayout;
        this.i = textView4;
        this.j = floatingActionButton;
        this.k = linearLayout2;
        this.l = linearLayout3;
        this.m = textView5;
        this.n = textView6;
        this.o = view2;
        this.p = textView7;
        this.q = linearLayout5;
        this.r = textView8;
        this.f2703s = view3;
        this.t = seekBar2;
        this.u = textView9;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
