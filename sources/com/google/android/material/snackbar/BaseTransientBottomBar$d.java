package com.google.android.material.snackbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class BaseTransientBottomBar$d implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ BaseTransientBottomBar a;

    public BaseTransientBottomBar$d(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.a.view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
