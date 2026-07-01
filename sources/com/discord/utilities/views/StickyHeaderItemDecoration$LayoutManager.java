package com.discord.utilities.views;

import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import d0.z.d.m;

/* JADX INFO: compiled from: StickyHeaderItemDecoration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickyHeaderItemDecoration$LayoutManager {
    public static final StickyHeaderItemDecoration$LayoutManager INSTANCE = new StickyHeaderItemDecoration$LayoutManager();

    private StickyHeaderItemDecoration$LayoutManager() {
    }

    public static final void layoutHeaderView(ViewGroup parent, View view) {
        m.checkNotNullParameter(parent, "parent");
        m.checkNotNullParameter(view, "view");
        int iMakeMeasureSpec = View$MeasureSpec.makeMeasureSpec(parent.getWidth(), BasicMeasure.EXACTLY);
        int iMakeMeasureSpec2 = View$MeasureSpec.makeMeasureSpec(parent.getHeight(), 0);
        view.measure(ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, parent.getPaddingRight() + parent.getPaddingLeft(), view.getLayoutParams().width), ViewGroup.getChildMeasureSpec(iMakeMeasureSpec2, parent.getPaddingBottom() + parent.getPaddingTop(), view.getLayoutParams().height));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
