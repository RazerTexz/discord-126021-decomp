package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class StateListAnimator$a extends AnimatorListenerAdapter {
    public final /* synthetic */ StateListAnimator a;

    public StateListAnimator$a(StateListAnimator stateListAnimator) {
        this.a = stateListAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        StateListAnimator stateListAnimator = this.a;
        if (stateListAnimator.runningAnimator == animator) {
            stateListAnimator.runningAnimator = null;
        }
    }
}
