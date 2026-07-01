package com.google.android.material.bottomappbar;

import android.view.View;
import android.view.View$OnLayoutChangeListener;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import com.google.android.material.R$dimen;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar$Behavior$a implements View$OnLayoutChangeListener {
    public final /* synthetic */ BottomAppBar$Behavior j;

    public BottomAppBar$Behavior$a(BottomAppBar$Behavior bottomAppBar$Behavior) {
        this.j = bottomAppBar$Behavior;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        BottomAppBar bottomAppBar = (BottomAppBar) BottomAppBar$Behavior.access$2400(this.j).get();
        if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
            view.removeOnLayoutChangeListener(this);
            return;
        }
        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
        floatingActionButton.getMeasuredContentRect(BottomAppBar$Behavior.access$2500(this.j));
        int iHeight = BottomAppBar$Behavior.access$2500(this.j).height();
        bottomAppBar.setFabDiameter(iHeight);
        CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams) view.getLayoutParams();
        if (BottomAppBar$Behavior.access$2600(this.j) == 0) {
            ((ViewGroup$MarginLayoutParams) coordinatorLayout$LayoutParams).bottomMargin = BottomAppBar.access$2700(bottomAppBar) + (bottomAppBar.getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - iHeight) / 2));
            ((ViewGroup$MarginLayoutParams) coordinatorLayout$LayoutParams).leftMargin = BottomAppBar.access$2800(bottomAppBar);
            ((ViewGroup$MarginLayoutParams) coordinatorLayout$LayoutParams).rightMargin = BottomAppBar.access$2900(bottomAppBar);
            if (ViewUtils.isLayoutRtl(floatingActionButton)) {
                ((ViewGroup$MarginLayoutParams) coordinatorLayout$LayoutParams).leftMargin = BottomAppBar.access$3000(bottomAppBar) + ((ViewGroup$MarginLayoutParams) coordinatorLayout$LayoutParams).leftMargin;
            } else {
                ((ViewGroup$MarginLayoutParams) coordinatorLayout$LayoutParams).rightMargin = BottomAppBar.access$3000(bottomAppBar) + ((ViewGroup$MarginLayoutParams) coordinatorLayout$LayoutParams).rightMargin;
            }
        }
    }
}
