package com.google.android.material.snackbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
public class BaseTransientBottomBar$g implements ValueAnimator$AnimatorUpdateListener {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3064b;
    public final /* synthetic */ BaseTransientBottomBar c;

    public BaseTransientBottomBar$g(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.c = baseTransientBottomBar;
        this.f3064b = i;
        this.a = i;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (BaseTransientBottomBar.access$1700()) {
            ViewCompat.offsetTopAndBottom(this.c.view, iIntValue - this.a);
        } else {
            this.c.view.setTranslationY(iIntValue);
        }
        this.a = iIntValue;
    }
}
