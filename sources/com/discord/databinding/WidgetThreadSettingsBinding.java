package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetThreadSettingsBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2672b;

    @NonNull
    public final View c;

    @NonNull
    public final TextInputLayout d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final FloatingActionButton f;

    @NonNull
    public final LinearLayout g;

    @NonNull
    public final TextView h;

    @NonNull
    public final SeekBar i;

    public WidgetThreadSettingsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull View view, @NonNull NestedScrollView nestedScrollView, @NonNull TextInputLayout textInputLayout, @NonNull LinearLayout linearLayout2, @NonNull FloatingActionButton floatingActionButton, @NonNull LinearLayout linearLayout3, @NonNull TextView textView2, @NonNull SeekBar seekBar, @NonNull TextView textView3) {
        this.a = coordinatorLayout;
        this.f2672b = textView;
        this.c = view;
        this.d = textInputLayout;
        this.e = linearLayout2;
        this.f = floatingActionButton;
        this.g = linearLayout3;
        this.h = textView2;
        this.i = seekBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
