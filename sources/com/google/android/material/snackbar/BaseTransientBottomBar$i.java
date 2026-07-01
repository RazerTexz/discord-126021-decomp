package com.google.android.material.snackbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
public class BaseTransientBottomBar$i implements ValueAnimator$AnimatorUpdateListener {
    public int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f3066b;

    public BaseTransientBottomBar$i(BaseTransientBottomBar baseTransientBottomBar) {
        this.f3066b = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (BaseTransientBottomBar.access$1700()) {
            ViewCompat.offsetTopAndBottom(this.f3066b.view, iIntValue - this.a);
        } else {
            this.f3066b.view.setTranslationY(iIntValue);
        }
        this.a = iIntValue;
    }
}
