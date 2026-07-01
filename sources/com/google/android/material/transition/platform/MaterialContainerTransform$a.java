package com.google.android.material.transition.platform;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialContainerTransform$a implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ MaterialContainerTransform$d a;

    public MaterialContainerTransform$a(MaterialContainerTransform materialContainerTransform, MaterialContainerTransform$d materialContainerTransform$d) {
        this.a = materialContainerTransform$d;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        MaterialContainerTransform$d materialContainerTransform$d = this.a;
        float animatedFraction = valueAnimator.getAnimatedFraction();
        if (materialContainerTransform$d.L != animatedFraction) {
            materialContainerTransform$d.e(animatedFraction);
        }
    }
}
