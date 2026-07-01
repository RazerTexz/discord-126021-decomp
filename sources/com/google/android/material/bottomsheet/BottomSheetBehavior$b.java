package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetBehavior$b implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ BottomSheetBehavior a;

    public BottomSheetBehavior$b(BottomSheetBehavior bottomSheetBehavior) {
        this.a = bottomSheetBehavior;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (BottomSheetBehavior.access$000(this.a) != null) {
            BottomSheetBehavior.access$000(this.a).setInterpolation(fFloatValue);
        }
    }
}
