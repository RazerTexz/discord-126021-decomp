package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsEmojisBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17637a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f17638b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final AppViewFlipper f17639c;

    public WidgetServerSettingsEmojisBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView, @NonNull AppViewFlipper appViewFlipper) {
        this.f17637a = coordinatorLayout;
        this.f17638b = recyclerView;
        this.f17639c = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17637a;
    }
}
