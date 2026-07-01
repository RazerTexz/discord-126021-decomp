package com.google.android.material.snackbar;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class BaseTransientBottomBar$q implements BaseTransientBottomBar$OnLayoutChangeListener {
    public final /* synthetic */ BaseTransientBottomBar a;

    public BaseTransientBottomBar$q(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar$OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4) {
        this.a.view.setOnLayoutChangeListener(null);
        BaseTransientBottomBar.access$1200(this.a);
    }
}
