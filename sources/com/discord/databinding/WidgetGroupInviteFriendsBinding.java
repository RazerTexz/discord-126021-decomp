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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f16727a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ChipsView f16728b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RelativeLayout f16729c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final RecyclerView f16730d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final FloatingActionButton f16731e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final AppViewFlipper f16732f;

    public WidgetGroupInviteFriendsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ChipsView chipsView, @NonNull RelativeLayout relativeLayout, @NonNull RecyclerView recyclerView, @NonNull FloatingActionButton floatingActionButton, @NonNull TextView textView, @NonNull AppViewFlipper appViewFlipper) {
        this.f16727a = coordinatorLayout;
        this.f16728b = chipsView;
        this.f16729c = relativeLayout;
        this.f16730d = recyclerView;
        this.f16731e = floatingActionButton;
        this.f16732f = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16727a;
    }
}
