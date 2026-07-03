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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f15692a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CodeVerificationView f15693b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final DimmerView f15694c;

    public WidgetAuthMfaBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull CodeVerificationView codeVerificationView, @NonNull DimmerView dimmerView) {
        this.f15692a = coordinatorLayout;
        this.f15693b = codeVerificationView;
        this.f15694c = dimmerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15692a;
    }
}
