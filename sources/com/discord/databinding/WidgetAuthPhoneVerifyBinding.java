package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetAuthPhoneVerifyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f15695a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15696b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final CodeVerificationView f15697c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15698d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15699e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15700f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final DimmerView f15701g;

    public WidgetAuthPhoneVerifyBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull CodeVerificationView codeVerificationView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull DimmerView dimmerView) {
        this.f15695a = coordinatorLayout;
        this.f15696b = textView;
        this.f15697c = codeVerificationView;
        this.f15698d = textView2;
        this.f15699e = textView3;
        this.f15700f = textView4;
        this.f15701g = dimmerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15695a;
    }
}
