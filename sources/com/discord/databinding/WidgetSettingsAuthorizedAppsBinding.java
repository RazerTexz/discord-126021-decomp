package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsAuthorizedAppsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17861a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f17862b;

    public WidgetSettingsAuthorizedAppsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView) {
        this.f17861a = coordinatorLayout;
        this.f17862b = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17861a;
    }
}
