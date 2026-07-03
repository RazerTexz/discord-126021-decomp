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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f18280a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f18281b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final View f18282c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextInputLayout f18283d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LinearLayout f18284e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final FloatingActionButton f18285f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final LinearLayout f18286g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f18287h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final SeekBar f18288i;

    public WidgetThreadSettingsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull View view, @NonNull NestedScrollView nestedScrollView, @NonNull TextInputLayout textInputLayout, @NonNull LinearLayout linearLayout2, @NonNull FloatingActionButton floatingActionButton, @NonNull LinearLayout linearLayout3, @NonNull TextView textView2, @NonNull SeekBar seekBar, @NonNull TextView textView3) {
        this.f18280a = coordinatorLayout;
        this.f18281b = textView;
        this.f18282c = view;
        this.f18283d = textInputLayout;
        this.f18284e = linearLayout2;
        this.f18285f = floatingActionButton;
        this.f18286g = linearLayout3;
        this.f18287h = textView2;
        this.f18288i = seekBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18280a;
    }
}
