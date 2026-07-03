package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsChannelsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17565a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final DimmerView f17566b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FloatingActionButton f17567c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final RecyclerView f17568d;

    public WidgetServerSettingsChannelsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DimmerView dimmerView, @NonNull FloatingActionButton floatingActionButton, @NonNull RecyclerView recyclerView, @NonNull FrameLayout frameLayout) {
        this.f17565a = coordinatorLayout;
        this.f17566b = dimmerView;
        this.f17567c = floatingActionButton;
        this.f17568d = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17565a;
    }
}
