package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import b.a.i.WidgetDirectoryChannelEmptyBinding;
import com.discord.views.directories.ServerDiscoveryHeader;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetDirectoryChannelBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Toolbar f2365b;

    @NonNull
    public final ServerDiscoveryHeader c;

    @NonNull
    public final TabLayout d;

    @NonNull
    public final ViewPager2 e;

    @NonNull
    public final WidgetDirectoryChannelEmptyBinding f;

    public WidgetDirectoryChannelBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar toolbar, @NonNull ServerDiscoveryHeader serverDiscoveryHeader, @NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, @NonNull WidgetDirectoryChannelEmptyBinding widgetDirectoryChannelEmptyBinding) {
        this.a = coordinatorLayout;
        this.f2365b = toolbar;
        this.c = serverDiscoveryHeader;
        this.d = tabLayout;
        this.e = viewPager2;
        this.f = widgetDirectoryChannelEmptyBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
