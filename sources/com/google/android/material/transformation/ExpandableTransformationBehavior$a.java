package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class ExpandableTransformationBehavior$a extends AnimatorListenerAdapter {
    public final /* synthetic */ ExpandableTransformationBehavior a;

    public ExpandableTransformationBehavior$a(ExpandableTransformationBehavior expandableTransformationBehavior) {
        this.a = expandableTransformationBehavior;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ExpandableTransformationBehavior.access$002(this.a, null);
    }
}
