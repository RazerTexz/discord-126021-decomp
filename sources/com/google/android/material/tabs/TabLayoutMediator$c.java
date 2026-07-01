package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: loaded from: classes3.dex */
public class TabLayoutMediator$c implements TabLayout$OnTabSelectedListener {
    public final ViewPager2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3072b;

    public TabLayoutMediator$c(ViewPager2 viewPager2, boolean z2) {
        this.a = viewPager2;
        this.f3072b = z2;
    }

    @Override // com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener
    public void onTabReselected(TabLayout$Tab tabLayout$Tab) {
    }

    @Override // com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener
    public void onTabSelected(@NonNull TabLayout$Tab tabLayout$Tab) {
        this.a.setCurrentItem(tabLayout$Tab.getPosition(), this.f3072b);
    }

    @Override // com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout$Tab tabLayout$Tab) {
    }
}
