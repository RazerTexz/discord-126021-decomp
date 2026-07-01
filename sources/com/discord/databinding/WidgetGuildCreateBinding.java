package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import b.a.i.LayoutIconUploaderBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildCreateBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LoadingButton f2412b;

    @NonNull
    public final LinkifiedTextView c;

    @NonNull
    public final LayoutIconUploaderBinding d;

    @NonNull
    public final TextInputLayout e;

    @NonNull
    public final ScreenTitleView f;

    public WidgetGuildCreateBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LoadingButton loadingButton, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LayoutIconUploaderBinding layoutIconUploaderBinding, @NonNull TextInputLayout textInputLayout, @NonNull ScreenTitleView screenTitleView) {
        this.a = coordinatorLayout;
        this.f2412b = loadingButton;
        this.c = linkifiedTextView;
        this.d = layoutIconUploaderBinding;
        this.e = textInputLayout;
        this.f = screenTitleView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
