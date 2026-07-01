package com.google.android.material.tabs;

import com.google.android.material.tabs.TabLayout$Tab;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface TabLayout$BaseOnTabSelectedListener<T extends TabLayout$Tab> {
    void onTabReselected(T t);

    void onTabSelected(T t);

    void onTabUnselected(T t);
}
