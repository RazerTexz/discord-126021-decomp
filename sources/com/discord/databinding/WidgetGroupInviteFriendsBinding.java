package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.chips_view.ChipsView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGroupInviteFriendsBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ChipsView f2406b;

    @NonNull
    public final RelativeLayout c;

    @NonNull
    public final RecyclerView d;

    @NonNull
    public final FloatingActionButton e;

    @NonNull
    public final AppViewFlipper f;

    public WidgetGroupInviteFriendsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ChipsView chipsView, @NonNull RelativeLayout relativeLayout, @NonNull RecyclerView recyclerView, @NonNull FloatingActionButton floatingActionButton, @NonNull TextView textView, @NonNull AppViewFlipper appViewFlipper) {
        this.a = coordinatorLayout;
        this.f2406b = chipsView;
        this.c = relativeLayout;
        this.d = recyclerView;
        this.e = floatingActionButton;
        this.f = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
