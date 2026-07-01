package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import b.a.i.g0;
import b.a.i.h0;
import b.a.i.i0;
import com.discord.app.AppViewFlipper;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetAgeVerifyBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppViewFlipper f2224b;

    @NonNull
    public final h0 c;

    @NonNull
    public final i0 d;

    @NonNull
    public final g0 e;

    public WidgetAgeVerifyBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppViewFlipper appViewFlipper, @NonNull h0 h0Var, @NonNull i0 i0Var, @NonNull g0 g0Var) {
        this.a = coordinatorLayout;
        this.f2224b = appViewFlipper;
        this.c = h0Var;
        this.d = i0Var;
        this.e = g0Var;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
