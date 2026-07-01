package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.simple_pager.SimplePager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetFriendsAddBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimplePager f2390b;

    public WidgetFriendsAddBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TabLayout tabLayout, @NonNull AppBarLayout appBarLayout, @NonNull SimplePager simplePager) {
        this.a = coordinatorLayout;
        this.f2390b = simplePager;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
