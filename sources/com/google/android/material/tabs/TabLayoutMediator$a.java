package com.google.android.material.tabs;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;

/* JADX INFO: loaded from: classes3.dex */
public class TabLayoutMediator$a extends RecyclerView$AdapterDataObserver {
    public final /* synthetic */ TabLayoutMediator a;

    public TabLayoutMediator$a(TabLayoutMediator tabLayoutMediator) {
        this.a = tabLayoutMediator;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onChanged() {
        this.a.populateTabsFromPagerAdapter();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeChanged(int i, int i2) {
        this.a.populateTabsFromPagerAdapter();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeInserted(int i, int i2) {
        this.a.populateTabsFromPagerAdapter();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeMoved(int i, int i2, int i3) {
        this.a.populateTabsFromPagerAdapter();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeRemoved(int i, int i2) {
        this.a.populateTabsFromPagerAdapter();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
        this.a.populateTabsFromPagerAdapter();
    }
}
