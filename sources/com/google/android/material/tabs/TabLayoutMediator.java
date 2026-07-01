package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: loaded from: classes3.dex */
public final class TabLayoutMediator {

    @Nullable
    private RecyclerView$Adapter<?> adapter;
    private boolean attached;
    private final boolean autoRefresh;

    @Nullable
    private TabLayoutMediator$b onPageChangeCallback;

    @Nullable
    private TabLayout$OnTabSelectedListener onTabSelectedListener;

    @Nullable
    private RecyclerView$AdapterDataObserver pagerAdapterObserver;
    private final boolean smoothScroll;
    private final TabLayoutMediator$TabConfigurationStrategy tabConfigurationStrategy;

    @NonNull
    private final TabLayout tabLayout;

    @NonNull
    private final ViewPager2 viewPager;

    public TabLayoutMediator(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, @NonNull TabLayoutMediator$TabConfigurationStrategy tabLayoutMediator$TabConfigurationStrategy) {
        this(tabLayout, viewPager2, true, tabLayoutMediator$TabConfigurationStrategy);
    }

    public void attach() {
        if (this.attached) {
            throw new IllegalStateException("TabLayoutMediator is already attached");
        }
        RecyclerView$Adapter<?> adapter = this.viewPager.getAdapter();
        this.adapter = adapter;
        if (adapter == null) {
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        this.attached = true;
        TabLayoutMediator$b tabLayoutMediator$b = new TabLayoutMediator$b(this.tabLayout);
        this.onPageChangeCallback = tabLayoutMediator$b;
        this.viewPager.registerOnPageChangeCallback(tabLayoutMediator$b);
        TabLayoutMediator$c tabLayoutMediator$c = new TabLayoutMediator$c(this.viewPager, this.smoothScroll);
        this.onTabSelectedListener = tabLayoutMediator$c;
        this.tabLayout.addOnTabSelectedListener((TabLayout$OnTabSelectedListener) tabLayoutMediator$c);
        if (this.autoRefresh) {
            TabLayoutMediator$a tabLayoutMediator$a = new TabLayoutMediator$a(this);
            this.pagerAdapterObserver = tabLayoutMediator$a;
            this.adapter.registerAdapterDataObserver(tabLayoutMediator$a);
        }
        populateTabsFromPagerAdapter();
        this.tabLayout.setScrollPosition(this.viewPager.getCurrentItem(), 0.0f, true);
    }

    public void detach() {
        RecyclerView$Adapter<?> recyclerView$Adapter;
        if (this.autoRefresh && (recyclerView$Adapter = this.adapter) != null) {
            recyclerView$Adapter.unregisterAdapterDataObserver(this.pagerAdapterObserver);
            this.pagerAdapterObserver = null;
        }
        this.tabLayout.removeOnTabSelectedListener(this.onTabSelectedListener);
        this.viewPager.unregisterOnPageChangeCallback(this.onPageChangeCallback);
        this.onTabSelectedListener = null;
        this.onPageChangeCallback = null;
        this.adapter = null;
        this.attached = false;
    }

    public boolean isAttached() {
        return this.attached;
    }

    public void populateTabsFromPagerAdapter() {
        this.tabLayout.removeAllTabs();
        RecyclerView$Adapter<?> recyclerView$Adapter = this.adapter;
        if (recyclerView$Adapter != null) {
            int itemCount = recyclerView$Adapter.getItemCount();
            for (int i = 0; i < itemCount; i++) {
                TabLayout$Tab tabLayout$TabNewTab = this.tabLayout.newTab();
                this.tabConfigurationStrategy.onConfigureTab(tabLayout$TabNewTab, i);
                this.tabLayout.addTab(tabLayout$TabNewTab, false);
            }
            if (itemCount > 0) {
                int iMin = Math.min(this.viewPager.getCurrentItem(), this.tabLayout.getTabCount() - 1);
                if (iMin != this.tabLayout.getSelectedTabPosition()) {
                    TabLayout tabLayout = this.tabLayout;
                    tabLayout.selectTab(tabLayout.getTabAt(iMin));
                }
            }
        }
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z2, @NonNull TabLayoutMediator$TabConfigurationStrategy tabLayoutMediator$TabConfigurationStrategy) {
        this(tabLayout, viewPager2, z2, true, tabLayoutMediator$TabConfigurationStrategy);
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z2, boolean z3, @NonNull TabLayoutMediator$TabConfigurationStrategy tabLayoutMediator$TabConfigurationStrategy) {
        this.tabLayout = tabLayout;
        this.viewPager = viewPager2;
        this.autoRefresh = z2;
        this.smoothScroll = z3;
        this.tabConfigurationStrategy = tabLayoutMediator$TabConfigurationStrategy;
    }
}
