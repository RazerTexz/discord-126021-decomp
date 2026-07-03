package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.widgets.friends.EmptyFriendsStateView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetFriendsListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f16676a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final EmptyFriendsStateView f16677b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final AppViewFlipper f16678c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final RecyclerView f16679d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final RecyclerView f16680e;

    public WidgetFriendsListBinding(@NonNull RelativeLayout relativeLayout, @NonNull EmptyFriendsStateView emptyFriendsStateView, @NonNull AppViewFlipper appViewFlipper, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2) {
        this.f16676a = relativeLayout;
        this.f16677b = emptyFriendsStateView;
        this.f16678c = appViewFlipper;
        this.f16679d = recyclerView;
        this.f16680e = recyclerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16676a;
    }
}
