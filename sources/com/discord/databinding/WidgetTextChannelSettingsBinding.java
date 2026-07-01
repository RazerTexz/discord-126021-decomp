package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetTextChannelSettingsBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CheckedSetting f2665b;

    @NonNull
    public final TextInputLayout c;

    @NonNull
    public final TextInputLayout d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final CheckedSetting f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final LinearLayout i;

    @NonNull
    public final View j;

    @NonNull
    public final FloatingActionButton k;

    @NonNull
    public final LinearLayout l;

    @NonNull
    public final LinearLayout m;

    @NonNull
    public final LinearLayout n;

    @NonNull
    public final LinearLayout o;

    @NonNull
    public final TextView p;

    @NonNull
    public final SeekBar q;

    @NonNull
    public final WidgetThreadArchiveActionsSheetBinding r;

    public WidgetTextChannelSettingsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CheckedSetting checkedSetting, @NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull LinearLayout linearLayout, @NonNull CheckedSetting checkedSetting2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull View view, @NonNull FloatingActionButton floatingActionButton, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull LinearLayout linearLayout6, @NonNull TextView textView3, @NonNull SeekBar seekBar, @NonNull TextView textView4, @NonNull WidgetThreadArchiveActionsSheetBinding widgetThreadArchiveActionsSheetBinding, @NonNull NestedScrollView nestedScrollView) {
        this.a = coordinatorLayout;
        this.f2665b = checkedSetting;
        this.c = textInputLayout;
        this.d = textInputLayout2;
        this.e = linearLayout;
        this.f = checkedSetting2;
        this.g = textView;
        this.h = textView2;
        this.i = linearLayout2;
        this.j = view;
        this.k = floatingActionButton;
        this.l = linearLayout3;
        this.m = linearLayout4;
        this.n = linearLayout5;
        this.o = linearLayout6;
        this.p = textView3;
        this.q = seekBar;
        this.r = widgetThreadArchiveActionsSheetBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
