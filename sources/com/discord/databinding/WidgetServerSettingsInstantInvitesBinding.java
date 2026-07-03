package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsInstantInvitesBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17687a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f17688b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final AppViewFlipper f17689c;

    public WidgetServerSettingsInstantInvitesBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RecyclerView recyclerView, @NonNull AppViewFlipper appViewFlipper) {
        this.f17687a = coordinatorLayout;
        this.f17688b = recyclerView;
        this.f17689c = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17687a;
    }
}
