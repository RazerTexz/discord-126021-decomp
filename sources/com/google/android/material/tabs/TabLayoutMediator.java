package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class TabLayoutMediator {

    @Nullable
    private RecyclerView.Adapter<?> adapter;
    private boolean attached;
    private final boolean autoRefresh;

    @Nullable
    private C11011b onPageChangeCallback;

    @Nullable
    private TabLayout.OnTabSelectedListener onTabSelectedListener;

    @Nullable
    private RecyclerView.AdapterDataObserver pagerAdapterObserver;
    private final boolean smoothScroll;
    private final TabConfigurationStrategy tabConfigurationStrategy;

    @NonNull
    private final TabLayout tabLayout;

    @NonNull
    private final ViewPager2 viewPager;

    public interface TabConfigurationStrategy {
        void onConfigureTab(@NonNull TabLayout.Tab tab, int i);
    }

    /* JADX INFO: renamed from: com.google.android.material.tabs.TabLayoutMediator$a */
    public class C11010a extends RecyclerView.AdapterDataObserver {
        public C11010a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.tabs.TabLayoutMediator$b */
    public static class C11011b extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: a */
        @NonNull
        public final WeakReference<TabLayout> f21166a;

        /* JADX INFO: renamed from: c */
        public int f21168c = 0;

        /* JADX INFO: renamed from: b */
        public int f21167b = 0;

        public C11011b(TabLayout tabLayout) {
            this.f21166a = new WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            this.f21167b = this.f21168c;
            this.f21168c = i;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i, float f, int i2) {
            TabLayout tabLayout = this.f21166a.get();
            if (tabLayout != null) {
                int i3 = this.f21168c;
                tabLayout.setScrollPosition(i, f, i3 != 2 || this.f21167b == 1, (i3 == 2 && this.f21167b == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            TabLayout tabLayout = this.f21166a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
                return;
            }
            int i2 = this.f21168c;
            tabLayout.selectTab(tabLayout.getTabAt(i), i2 == 0 || (i2 == 2 && this.f21167b == 0));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.tabs.TabLayoutMediator$c */
    public static class C11012c implements TabLayout.OnTabSelectedListener {

        /* JADX INFO: renamed from: a */
        public final ViewPager2 f21169a;

        /* JADX INFO: renamed from: b */
        public final boolean f21170b;

        public C11012c(ViewPager2 viewPager2, boolean z2) {
            this.f21169a = viewPager2;
            this.f21170b = z2;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@NonNull TabLayout.Tab tab) {
            this.f21169a.setCurrentItem(tab.getPosition(), this.f21170b);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, @NonNull TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, viewPager2, true, tabConfigurationStrategy);
    }

    public void attach() {
        if (this.attached) {
            throw new IllegalStateException("TabLayoutMediator is already attached");
        }
        RecyclerView.Adapter<?> adapter = this.viewPager.getAdapter();
        this.adapter = adapter;
        if (adapter == null) {
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        this.attached = true;
        C11011b c11011b = new C11011b(this.tabLayout);
        this.onPageChangeCallback = c11011b;
        this.viewPager.registerOnPageChangeCallback(c11011b);
        C11012c c11012c = new C11012c(this.viewPager, this.smoothScroll);
        this.onTabSelectedListener = c11012c;
        this.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) c11012c);
        if (this.autoRefresh) {
            C11010a c11010a = new C11010a();
            this.pagerAdapterObserver = c11010a;
            this.adapter.registerAdapterDataObserver(c11010a);
        }
        populateTabsFromPagerAdapter();
        this.tabLayout.setScrollPosition(this.viewPager.getCurrentItem(), 0.0f, true);
    }

    public void detach() {
        RecyclerView.Adapter<?> adapter;
        if (this.autoRefresh && (adapter = this.adapter) != null) {
            adapter.unregisterAdapterDataObserver(this.pagerAdapterObserver);
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
        RecyclerView.Adapter<?> adapter = this.adapter;
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            for (int i = 0; i < itemCount; i++) {
                TabLayout.Tab tabNewTab = this.tabLayout.newTab();
                this.tabConfigurationStrategy.onConfigureTab(tabNewTab, i);
                this.tabLayout.addTab(tabNewTab, false);
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

    public TabLayoutMediator(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z2, @NonNull TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, viewPager2, z2, true, tabConfigurationStrategy);
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z2, boolean z3, @NonNull TabConfigurationStrategy tabConfigurationStrategy) {
        this.tabLayout = tabLayout;
        this.viewPager = viewPager2;
        this.autoRefresh = z2;
        this.smoothScroll = z3;
        this.tabConfigurationStrategy = tabConfigurationStrategy;
    }
}
