package com.discord.databinding;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import b.a.i.o;
import b.a.i.p;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetForumBrowserBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ExtendedFloatingActionButton f2387b;

    @NonNull
    public final o c;

    @NonNull
    public final p d;

    @NonNull
    public final ViewStub e;

    @NonNull
    public final RecyclerView f;

    @NonNull
    public final FloatingActionButton g;

    public WidgetForumBrowserBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Guideline guideline, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull o oVar, @NonNull p pVar, @NonNull ViewStub viewStub, @NonNull RecyclerView recyclerView, @NonNull AppBarLayout appBarLayout, @NonNull Barrier barrier, @NonNull FloatingActionButton floatingActionButton) {
        this.a = constraintLayout;
        this.f2387b = extendedFloatingActionButton;
        this.c = oVar;
        this.d = pVar;
        this.e = viewStub;
        this.f = recyclerView;
        this.g = floatingActionButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
