package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsRolesBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17748a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final DimmerView f17749b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FloatingActionButton f17750c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final RecyclerView f17751d;

    public WidgetServerSettingsRolesBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DimmerView dimmerView, @NonNull FloatingActionButton floatingActionButton, @NonNull RecyclerView recyclerView) {
        this.f17748a = coordinatorLayout;
        this.f17749b = dimmerView;
        this.f17750c = floatingActionButton;
        this.f17751d = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17748a;
    }
}
