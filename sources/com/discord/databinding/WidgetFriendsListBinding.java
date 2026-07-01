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

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final EmptyFriendsStateView f2396b;

    @NonNull
    public final AppViewFlipper c;

    @NonNull
    public final RecyclerView d;

    @NonNull
    public final RecyclerView e;

    public WidgetFriendsListBinding(@NonNull RelativeLayout relativeLayout, @NonNull EmptyFriendsStateView emptyFriendsStateView, @NonNull AppViewFlipper appViewFlipper, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2) {
        this.a = relativeLayout;
        this.f2396b = emptyFriendsStateView;
        this.c = appViewFlipper;
        this.d = recyclerView;
        this.e = recyclerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
