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

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2596b;

    @NonNull
    public final TextInputLayout c;

    @NonNull
    public final TextInputLayout d;

    @NonNull
    public final LoadingButton e;

    @NonNull
    public final TextInputLayout f;

    @NonNull
    public final TextView g;

    @NonNull
    public final DimmerView h;

    public WidgetSettingsAccountChangePasswordBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ImageView imageView, @NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull LoadingButton loadingButton, @NonNull ScreenTitleView screenTitleView, @NonNull TextInputLayout textInputLayout3, @NonNull TextView textView, @NonNull DimmerView dimmerView) {
        this.a = coordinatorLayout;
        this.f2596b = imageView;
        this.c = textInputLayout;
        this.d = textInputLayout2;
        this.e = loadingButton;
        this.f = textInputLayout3;
        this.g = textView;
        this.h = dimmerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
