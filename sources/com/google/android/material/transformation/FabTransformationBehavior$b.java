package com.google.android.material.transformation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class FabTransformationBehavior$b implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ View a;

    public FabTransformationBehavior$b(FabTransformationBehavior fabTransformationBehavior, View view) {
        this.a = view;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.invalidate();
    }
}
