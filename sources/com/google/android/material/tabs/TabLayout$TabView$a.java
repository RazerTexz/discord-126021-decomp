package com.google.android.material.tabs;

import android.view.View;
import android.view.View$OnLayoutChangeListener;

/* JADX INFO: loaded from: classes3.dex */
public class TabLayout$TabView$a implements View$OnLayoutChangeListener {
    public final /* synthetic */ View j;
    public final /* synthetic */ TabLayout$TabView k;

    public TabLayout$TabView$a(TabLayout$TabView tabLayout$TabView, View view) {
        this.k = tabLayout$TabView;
        this.j = view;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.j.getVisibility() == 0) {
            TabLayout$TabView.access$1000(this.k, this.j);
        }
    }
}
