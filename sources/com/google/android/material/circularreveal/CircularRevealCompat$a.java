package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class CircularRevealCompat$a extends AnimatorListenerAdapter {
    public final /* synthetic */ CircularRevealWidget a;

    public CircularRevealCompat$a(CircularRevealWidget circularRevealWidget) {
        this.a = circularRevealWidget;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.destroyCircularRevealCache();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.a.buildCircularRevealCache();
    }
}
