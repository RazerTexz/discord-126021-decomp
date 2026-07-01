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

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2235b;

    @NonNull
    public final CodeVerificationView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final DimmerView g;

    public WidgetAuthPhoneVerifyBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull CodeVerificationView codeVerificationView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull DimmerView dimmerView) {
        this.a = coordinatorLayout;
        this.f2235b = textView;
        this.c = codeVerificationView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
        this.g = dimmerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
