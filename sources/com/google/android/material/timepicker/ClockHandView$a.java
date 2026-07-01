package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;

/* JADX INFO: loaded from: classes3.dex */
public class ClockHandView$a implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ ClockHandView a;

    public ClockHandView$a(ClockHandView clockHandView) {
        this.a = clockHandView;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        ClockHandView clockHandView = this.a;
        int i = ClockHandView.j;
        clockHandView.c(fFloatValue, true);
    }
}
