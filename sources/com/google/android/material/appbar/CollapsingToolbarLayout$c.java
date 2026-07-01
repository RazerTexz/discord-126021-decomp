package com.google.android.material.appbar;

import android.view.View;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import b.i.a.g.a.d;

/* JADX INFO: loaded from: classes3.dex */
public class CollapsingToolbarLayout$c implements AppBarLayout$OnOffsetChangedListener {
    public final /* synthetic */ CollapsingToolbarLayout a;

    public CollapsingToolbarLayout$c(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.a = collapsingToolbarLayout;
    }

    @Override // com.google.android.material.appbar.AppBarLayout$OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout$BaseOnOffsetChangedListener
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        CollapsingToolbarLayout collapsingToolbarLayout = this.a;
        collapsingToolbarLayout.currentOffset = i;
        WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.lastInsets;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int childCount = this.a.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.a.getChildAt(i2);
            CollapsingToolbarLayout$LayoutParams collapsingToolbarLayout$LayoutParams = (CollapsingToolbarLayout$LayoutParams) childAt.getLayoutParams();
            d viewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(childAt);
            int i3 = collapsingToolbarLayout$LayoutParams.collapseMode;
            if (i3 == 1) {
                viewOffsetHelper.b(MathUtils.clamp(-i, 0, this.a.getMaxOffsetForPinChild(childAt)));
            } else if (i3 == 2) {
                viewOffsetHelper.b(Math.round((-i) * collapsingToolbarLayout$LayoutParams.parallaxMult));
            }
        }
        this.a.updateScrimVisibility();
        CollapsingToolbarLayout collapsingToolbarLayout2 = this.a;
        if (collapsingToolbarLayout2.statusBarScrim != null && systemWindowInsetTop > 0) {
            ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
        }
        this.a.collapsingTextHelper.setExpansionFraction(Math.abs(i) / ((this.a.getHeight() - ViewCompat.getMinimumHeight(this.a)) - systemWindowInsetTop));
    }
}
