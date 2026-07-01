package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class TextInputLayout$d implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ TextInputLayout a;

    public TextInputLayout$d(TextInputLayout textInputLayout) {
        this.a = textInputLayout;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.a.collapsingTextHelper.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
