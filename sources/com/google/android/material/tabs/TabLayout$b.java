package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager$OnAdapterChangeListener;

/* JADX INFO: loaded from: classes3.dex */
public class TabLayout$b implements ViewPager$OnAdapterChangeListener {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TabLayout f3068b;

    public TabLayout$b(TabLayout tabLayout) {
        this.f3068b = tabLayout;
    }

    @Override // androidx.viewpager.widget.ViewPager$OnAdapterChangeListener
    public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
        TabLayout tabLayout = this.f3068b;
        if (tabLayout.viewPager == viewPager) {
            tabLayout.setPagerAdapter(pagerAdapter2, this.a);
        }
    }
}
