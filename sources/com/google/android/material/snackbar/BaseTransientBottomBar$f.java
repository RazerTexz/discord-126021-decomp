package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class BaseTransientBottomBar$f extends AnimatorListenerAdapter {
    public final /* synthetic */ BaseTransientBottomBar a;

    public BaseTransientBottomBar$f(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.onViewShown();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        BaseTransientBottomBar.access$1600(this.a).animateContentIn(70, 180);
    }
}
