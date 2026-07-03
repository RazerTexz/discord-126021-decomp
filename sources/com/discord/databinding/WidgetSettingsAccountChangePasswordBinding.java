package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsAccountChangePasswordBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17818a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f17819b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputLayout f17820c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextInputLayout f17821d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LoadingButton f17822e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextInputLayout f17823f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f17824g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final DimmerView f17825h;

    public WidgetSettingsAccountChangePasswordBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ImageView imageView, @NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull LoadingButton loadingButton, @NonNull ScreenTitleView screenTitleView, @NonNull TextInputLayout textInputLayout3, @NonNull TextView textView, @NonNull DimmerView dimmerView) {
        this.f17818a = coordinatorLayout;
        this.f17819b = imageView;
        this.f17820c = textInputLayout;
        this.f17821d = textInputLayout2;
        this.f17822e = loadingButton;
        this.f17823f = textInputLayout3;
        this.f17824g = textView;
        this.f17825h = dimmerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17818a;
    }
}
