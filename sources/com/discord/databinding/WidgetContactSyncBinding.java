package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import b.a.i.j0;
import b.a.i.k0;
import b.a.i.l0;
import b.a.i.m0;
import b.a.i.n0;
import b.a.i.p0;
import com.discord.app.AppViewFlipper;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetContactSyncBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final j0 f2355b;

    @NonNull
    public final m0 c;

    @NonNull
    public final n0 d;

    @NonNull
    public final k0 e;

    @NonNull
    public final l0 f;

    @NonNull
    public final p0 g;

    @NonNull
    public final AppViewFlipper h;

    public WidgetContactSyncBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull j0 j0Var, @NonNull m0 m0Var, @NonNull n0 n0Var, @NonNull k0 k0Var, @NonNull l0 l0Var, @NonNull p0 p0Var, @NonNull AppViewFlipper appViewFlipper) {
        this.a = coordinatorLayout;
        this.f2355b = j0Var;
        this.c = m0Var;
        this.d = n0Var;
        this.e = k0Var;
        this.f = l0Var;
        this.g = p0Var;
        this.h = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
