package com.google.android.material.snackbar;

import android.view.ViewTreeObserver$OnGlobalLayoutListener;

/* JADX INFO: loaded from: classes3.dex */
public class BaseTransientBottomBar$k implements ViewTreeObserver$OnGlobalLayoutListener {
    public final /* synthetic */ BaseTransientBottomBar j;

    public BaseTransientBottomBar$k(BaseTransientBottomBar baseTransientBottomBar) {
        this.j = baseTransientBottomBar;
    }

    @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (BaseTransientBottomBar.access$000(this.j)) {
            BaseTransientBottomBar baseTransientBottomBar = this.j;
            BaseTransientBottomBar.access$102(baseTransientBottomBar, BaseTransientBottomBar.access$200(baseTransientBottomBar));
            BaseTransientBottomBar.access$300(this.j);
        }
    }
}
