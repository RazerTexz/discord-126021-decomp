package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class BaseTransientBottomBar$b extends AnimatorListenerAdapter {
    public final /* synthetic */ BaseTransientBottomBar a;

    public BaseTransientBottomBar$b(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.onViewShown();
    }
}
