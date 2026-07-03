package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetHubDescriptionBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17154a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LoadingButton f17155b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f17156c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17157d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LinearLayout f17158e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextInputEditText f17159f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextInputLayout f17160g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final ScreenTitleView f17161h;

    public WidgetHubDescriptionBinding(@NonNull LinearLayout linearLayout, @NonNull LoadingButton loadingButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull TextView textView3, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout, @NonNull ScreenTitleView screenTitleView) {
        this.f17154a = linearLayout;
        this.f17155b = loadingButton;
        this.f17156c = textView;
        this.f17157d = textView2;
        this.f17158e = linearLayout2;
        this.f17159f = textInputEditText;
        this.f17160g = textInputLayout;
        this.f17161h = screenTitleView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17154a;
    }
}
