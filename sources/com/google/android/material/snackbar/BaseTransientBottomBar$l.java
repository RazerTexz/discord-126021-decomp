package com.google.android.material.snackbar;

import android.util.Log;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;

/* JADX INFO: loaded from: classes3.dex */
public class BaseTransientBottomBar$l implements Runnable {
    public final /* synthetic */ BaseTransientBottomBar j;

    public BaseTransientBottomBar$l(BaseTransientBottomBar baseTransientBottomBar) {
        this.j = baseTransientBottomBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int iAccess$500;
        BaseTransientBottomBar baseTransientBottomBar = this.j;
        if (baseTransientBottomBar.view == null || BaseTransientBottomBar.access$400(baseTransientBottomBar) == null || (iAccess$500 = (BaseTransientBottomBar.access$500(this.j) - BaseTransientBottomBar.access$600(this.j)) + ((int) this.j.view.getTranslationY())) >= BaseTransientBottomBar.access$700(this.j)) {
            return;
        }
        ViewGroup$LayoutParams layoutParams = this.j.view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup$MarginLayoutParams)) {
            Log.w(BaseTransientBottomBar.access$800(), "Unable to apply gesture inset because layout params are not MarginLayoutParams");
            return;
        }
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams;
        viewGroup$MarginLayoutParams.bottomMargin = (BaseTransientBottomBar.access$700(this.j) - iAccess$500) + viewGroup$MarginLayoutParams.bottomMargin;
        this.j.view.requestLayout();
    }
}
