package com.google.android.material.snackbar;

/* JADX INFO: loaded from: classes3.dex */
public class BaseTransientBottomBar$a implements Runnable {
    public final /* synthetic */ BaseTransientBottomBar j;

    public BaseTransientBottomBar$a(BaseTransientBottomBar baseTransientBottomBar) {
        this.j = baseTransientBottomBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseTransientBottomBar$SnackbarBaseLayout baseTransientBottomBar$SnackbarBaseLayout = this.j.view;
        if (baseTransientBottomBar$SnackbarBaseLayout == null) {
            return;
        }
        if (baseTransientBottomBar$SnackbarBaseLayout.getParent() != null) {
            this.j.view.setVisibility(0);
        }
        if (this.j.view.getAnimationMode() == 1) {
            BaseTransientBottomBar.access$1400(this.j);
        } else {
            BaseTransientBottomBar.access$1500(this.j);
        }
    }
}
