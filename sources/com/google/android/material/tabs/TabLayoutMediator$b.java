package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class TabLayoutMediator$b extends ViewPager2$OnPageChangeCallback {

    @NonNull
    public final WeakReference<TabLayout> a;
    public int c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3071b = 0;

    public TabLayoutMediator$b(TabLayout tabLayout) {
        this.a = new WeakReference<>(tabLayout);
    }

    @Override // androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback
    public void onPageScrollStateChanged(int i) {
        this.f3071b = this.c;
        this.c = i;
    }

    @Override // androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback
    public void onPageScrolled(int i, float f, int i2) {
        TabLayout tabLayout = this.a.get();
        if (tabLayout != null) {
            int i3 = this.c;
            tabLayout.setScrollPosition(i, f, i3 != 2 || this.f3071b == 1, (i3 == 2 && this.f3071b == 0) ? false : true);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback
    public void onPageSelected(int i) {
        TabLayout tabLayout = this.a.get();
        if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
            return;
        }
        int i2 = this.c;
        tabLayout.selectTab(tabLayout.getTabAt(i), i2 == 0 || (i2 == 2 && this.f3071b == 0));
    }
}
