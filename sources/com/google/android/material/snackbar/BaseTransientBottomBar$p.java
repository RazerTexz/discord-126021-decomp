package com.google.android.material.snackbar;

import android.os.Build$VERSION;
import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes3.dex */
public class BaseTransientBottomBar$p implements BaseTransientBottomBar$OnAttachStateChangeListener {
    public final /* synthetic */ BaseTransientBottomBar a;

    public BaseTransientBottomBar$p(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar$OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        WindowInsets rootWindowInsets;
        if (Build$VERSION.SDK_INT < 29 || (rootWindowInsets = this.a.view.getRootWindowInsets()) == null) {
            return;
        }
        BaseTransientBottomBar.access$702(this.a, rootWindowInsets.getMandatorySystemGestureInsets().bottom);
        BaseTransientBottomBar.access$300(this.a);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar$OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        if (this.a.isShownOrQueued()) {
            BaseTransientBottomBar.handler.post(new BaseTransientBottomBar$p$a(this));
        }
    }
}
