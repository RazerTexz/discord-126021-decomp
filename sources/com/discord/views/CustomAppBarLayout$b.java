package com.discord.views;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout$OnOffsetChangedListener;
import d0.z.d.m;

/* JADX INFO: compiled from: CustomAppBarLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CustomAppBarLayout$b implements AppBarLayout$OnOffsetChangedListener {
    public final /* synthetic */ CustomAppBarLayout a;

    public CustomAppBarLayout$b(CustomAppBarLayout customAppBarLayout) {
        this.a = customAppBarLayout;
    }

    @Override // com.google.android.material.appbar.AppBarLayout$OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout$BaseOnOffsetChangedListener
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        m.checkNotNullExpressionValue(appBarLayout, "appBar");
        float fAbs = appBarLayout.getTotalScrollRange() <= 0 ? 1.0f : Math.abs(i) / appBarLayout.getTotalScrollRange();
        CustomAppBarLayout customAppBarLayout = this.a;
        if (fAbs != customAppBarLayout.percentCollapsed) {
            customAppBarLayout.percentCollapsed = fAbs;
            customAppBarLayout.onPercentCollapsedCallback.invoke(Float.valueOf(fAbs));
        }
    }
}
