package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import b.a.i.LayoutAgeVerifyBinding;
import b.a.i.LayoutAgeVerifyConfirmBinding;
import b.a.i.LayoutAgeVerifyUnderageBinding;
import com.discord.app.AppViewFlipper;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetAgeVerifyBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppViewFlipper f2224b;

    @NonNull
    public final LayoutAgeVerifyConfirmBinding c;

    @NonNull
    public final LayoutAgeVerifyUnderageBinding d;

    @NonNull
    public final LayoutAgeVerifyBinding e;

    public WidgetAgeVerifyBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppViewFlipper appViewFlipper, @NonNull LayoutAgeVerifyConfirmBinding layoutAgeVerifyConfirmBinding, @NonNull LayoutAgeVerifyUnderageBinding layoutAgeVerifyUnderageBinding, @NonNull LayoutAgeVerifyBinding layoutAgeVerifyBinding) {
        this.a = coordinatorLayout;
        this.f2224b = appViewFlipper;
        this.c = layoutAgeVerifyConfirmBinding;
        this.d = layoutAgeVerifyUnderageBinding;
        this.e = layoutAgeVerifyBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
