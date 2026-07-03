package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionTierListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17668a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f17669b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final AppViewFlipper f17670c;

    public WidgetServerSettingsGuildRoleSubscriptionTierListBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView, @NonNull AppViewFlipper appViewFlipper) {
        this.f17668a = coordinatorLayout;
        this.f17669b = recyclerView;
        this.f17670c = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17668a;
    }
}
