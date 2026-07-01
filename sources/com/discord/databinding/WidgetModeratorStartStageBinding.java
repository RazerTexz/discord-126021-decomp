package com.discord.databinding;

import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.calls.CallEventsButtonView;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetModeratorStartStageBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Button f2497b;

    @NonNull
    public final RecyclerView c;

    @NonNull
    public final CallEventsButtonView d;

    public WidgetModeratorStartStageBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Toolbar toolbar, @NonNull AppBarLayout appBarLayout, @NonNull Button button, @NonNull RecyclerView recyclerView, @NonNull CallEventsButtonView callEventsButtonView) {
        this.a = constraintLayout;
        this.f2497b = button;
        this.c = recyclerView;
        this.d = callEventsButtonView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
