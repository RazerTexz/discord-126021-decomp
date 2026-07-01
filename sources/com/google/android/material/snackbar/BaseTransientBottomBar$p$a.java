package com.google.android.material.snackbar;

/* JADX INFO: loaded from: classes3.dex */
public class BaseTransientBottomBar$p$a implements Runnable {
    public final /* synthetic */ BaseTransientBottomBar$p j;

    public BaseTransientBottomBar$p$a(BaseTransientBottomBar$p baseTransientBottomBar$p) {
        this.j = baseTransientBottomBar$p;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.j.a.onViewHidden(3);
    }
}
