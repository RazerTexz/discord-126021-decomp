package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager$OnPageChangeListener;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class TabLayout$TabLayoutOnPageChangeListener implements ViewPager$OnPageChangeListener {
    private int previousScrollState;
    private int scrollState;

    @NonNull
    private final WeakReference<TabLayout> tabLayoutRef;

    public TabLayout$TabLayoutOnPageChangeListener(TabLayout tabLayout) {
        this.tabLayoutRef = new WeakReference<>(tabLayout);
    }

    @Override // androidx.viewpager.widget.ViewPager$OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        this.previousScrollState = this.scrollState;
        this.scrollState = i;
    }

    @Override // androidx.viewpager.widget.ViewPager$OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        TabLayout tabLayout = this.tabLayoutRef.get();
        if (tabLayout != null) {
            int i3 = this.scrollState;
            tabLayout.setScrollPosition(i, f, i3 != 2 || this.previousScrollState == 1, (i3 == 2 && this.previousScrollState == 0) ? false : true);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager$OnPageChangeListener
    public void onPageSelected(int i) {
        TabLayout tabLayout = this.tabLayoutRef.get();
        if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
            return;
        }
        int i2 = this.scrollState;
        tabLayout.selectTab(tabLayout.getTabAt(i), i2 == 0 || (i2 == 2 && this.previousScrollState == 0));
    }

    public void reset() {
        this.scrollState = 0;
        this.previousScrollState = 0;
    }
}
