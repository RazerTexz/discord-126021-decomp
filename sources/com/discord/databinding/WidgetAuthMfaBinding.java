package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetAuthMfaBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CodeVerificationView f2234b;

    @NonNull
    public final DimmerView c;

    public WidgetAuthMfaBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull CodeVerificationView codeVerificationView, @NonNull DimmerView dimmerView) {
        this.a = coordinatorLayout;
        this.f2234b = codeVerificationView;
        this.c = dimmerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
