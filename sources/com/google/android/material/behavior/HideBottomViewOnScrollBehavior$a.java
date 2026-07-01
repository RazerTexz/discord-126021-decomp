package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class HideBottomViewOnScrollBehavior$a extends AnimatorListenerAdapter {
    public final /* synthetic */ HideBottomViewOnScrollBehavior a;

    public HideBottomViewOnScrollBehavior$a(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior) {
        this.a = hideBottomViewOnScrollBehavior;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        HideBottomViewOnScrollBehavior.access$002(this.a, null);
    }
}
