package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetConnectionsAddXboxBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CodeVerificationView f2354b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final DimmerView d;

    public WidgetConnectionsAddXboxBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CodeVerificationView codeVerificationView, @NonNull LinearLayout linearLayout, @NonNull DimmerView dimmerView) {
        this.a = coordinatorLayout;
        this.f2354b = codeVerificationView;
        this.c = linearLayout;
        this.d = dimmerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
