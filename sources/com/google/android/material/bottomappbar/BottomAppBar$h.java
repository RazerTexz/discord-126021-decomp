package com.google.android.material.bottomappbar;

import androidx.appcompat.widget.ActionMenuView;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar$h implements Runnable {
    public final /* synthetic */ ActionMenuView j;
    public final /* synthetic */ int k;
    public final /* synthetic */ boolean l;
    public final /* synthetic */ BottomAppBar m;

    public BottomAppBar$h(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z2) {
        this.m = bottomAppBar;
        this.j = actionMenuView;
        this.k = i;
        this.l = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActionMenuView actionMenuView = this.j;
        actionMenuView.setTranslationX(this.m.getActionMenuViewTranslationX(actionMenuView, this.k, this.l));
    }
}
