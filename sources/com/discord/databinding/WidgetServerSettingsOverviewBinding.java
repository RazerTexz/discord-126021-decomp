package com.discord.databinding;

import android.view.View;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import b.a.i.j3;
import b.a.i.k3;
import b.a.i.l3;
import b.a.i.n3;
import b.a.i.o3;
import b.a.i.z5;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsOverviewBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final z5 f2582b;

    @NonNull
    public final j3 c;

    @NonNull
    public final k3 d;

    @NonNull
    public final FloatingActionButton e;

    @NonNull
    public final ScrollView f;

    @NonNull
    public final l3 g;

    @NonNull
    public final n3 h;

    @NonNull
    public final o3 i;

    public WidgetServerSettingsOverviewBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull z5 z5Var, @NonNull j3 j3Var, @NonNull k3 k3Var, @NonNull FloatingActionButton floatingActionButton, @NonNull ScrollView scrollView, @NonNull l3 l3Var, @NonNull n3 n3Var, @NonNull o3 o3Var) {
        this.a = coordinatorLayout;
        this.f2582b = z5Var;
        this.c = j3Var;
        this.d = k3Var;
        this.e = floatingActionButton;
        this.f = scrollView;
        this.g = l3Var;
        this.h = n3Var;
        this.i = o3Var;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
