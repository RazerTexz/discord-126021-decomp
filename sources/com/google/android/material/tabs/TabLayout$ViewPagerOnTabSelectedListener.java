package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes3.dex */
public class TabLayout$ViewPagerOnTabSelectedListener implements TabLayout$OnTabSelectedListener {
    private final ViewPager viewPager;

    public TabLayout$ViewPagerOnTabSelectedListener(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    @Override // com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener
    public void onTabReselected(TabLayout$Tab tabLayout$Tab) {
    }

    @Override // com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener
    public void onTabSelected(@NonNull TabLayout$Tab tabLayout$Tab) {
        this.viewPager.setCurrentItem(tabLayout$Tab.getPosition());
    }

    @Override // com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout$Tab tabLayout$Tab) {
    }
}
