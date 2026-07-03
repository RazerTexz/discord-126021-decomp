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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f16650a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimplePager f16651b;

    public WidgetFriendsAddBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TabLayout tabLayout, @NonNull AppBarLayout appBarLayout, @NonNull SimplePager simplePager) {
        this.f16650a = coordinatorLayout;
        this.f16651b = simplePager;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16650a;
    }
}
