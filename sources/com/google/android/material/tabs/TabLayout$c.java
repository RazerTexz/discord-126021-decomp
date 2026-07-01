package com.google.android.material.tabs;

import android.database.DataSetObserver;

/* JADX INFO: loaded from: classes3.dex */
public class TabLayout$c extends DataSetObserver {
    public final /* synthetic */ TabLayout a;

    public TabLayout$c(TabLayout tabLayout) {
        this.a = tabLayout;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.a.populateFromPagerAdapter();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.a.populateFromPagerAdapter();
    }
}
