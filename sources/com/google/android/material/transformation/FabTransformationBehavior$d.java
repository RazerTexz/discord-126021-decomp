package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo;

/* JADX INFO: loaded from: classes3.dex */
public class FabTransformationBehavior$d extends AnimatorListenerAdapter {
    public final /* synthetic */ CircularRevealWidget a;

    public FabTransformationBehavior$d(FabTransformationBehavior fabTransformationBehavior, CircularRevealWidget circularRevealWidget) {
        this.a = circularRevealWidget;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        CircularRevealWidget$RevealInfo revealInfo = this.a.getRevealInfo();
        revealInfo.radius = Float.MAX_VALUE;
        this.a.setRevealInfo(revealInfo);
    }
}
