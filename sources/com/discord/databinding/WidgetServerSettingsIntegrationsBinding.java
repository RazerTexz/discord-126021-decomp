package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsIntegrationsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17699a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f17700b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final AppViewFlipper f17701c;

    public WidgetServerSettingsIntegrationsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RecyclerView recyclerView, @NonNull AppViewFlipper appViewFlipper) {
        this.f17699a = coordinatorLayout;
        this.f17700b = recyclerView;
        this.f17701c = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17699a;
    }
}
