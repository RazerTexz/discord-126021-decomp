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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f17270a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final Button f17271b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f17272c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final CallEventsButtonView f17273d;

    public WidgetModeratorStartStageBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Toolbar toolbar, @NonNull AppBarLayout appBarLayout, @NonNull Button button, @NonNull RecyclerView recyclerView, @NonNull CallEventsButtonView callEventsButtonView) {
        this.f17270a = constraintLayout;
        this.f17271b = button;
        this.f17272c = recyclerView;
        this.f17273d = callEventsButtonView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17270a;
    }
}
