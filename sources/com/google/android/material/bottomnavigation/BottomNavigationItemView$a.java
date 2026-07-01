package com.google.android.material.bottomnavigation;

import android.view.View;
import android.view.View$OnLayoutChangeListener;

/* JADX INFO: loaded from: classes3.dex */
public class BottomNavigationItemView$a implements View$OnLayoutChangeListener {
    public final /* synthetic */ BottomNavigationItemView j;

    public BottomNavigationItemView$a(BottomNavigationItemView bottomNavigationItemView) {
        this.j = bottomNavigationItemView;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (BottomNavigationItemView.access$000(this.j).getVisibility() == 0) {
            BottomNavigationItemView bottomNavigationItemView = this.j;
            BottomNavigationItemView.access$100(bottomNavigationItemView, BottomNavigationItemView.access$000(bottomNavigationItemView));
        }
    }
}
