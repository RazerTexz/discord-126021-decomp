package com.google.android.material.snackbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class BaseTransientBottomBar$e implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ BaseTransientBottomBar a;

    public BaseTransientBottomBar$e(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.view.setScaleX(fFloatValue);
        this.a.view.setScaleY(fFloatValue);
    }
}
