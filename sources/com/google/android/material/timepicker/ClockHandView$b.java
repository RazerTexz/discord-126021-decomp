package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class ClockHandView$b extends AnimatorListenerAdapter {
    public ClockHandView$b(ClockHandView clockHandView) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
        animator.end();
    }
}
