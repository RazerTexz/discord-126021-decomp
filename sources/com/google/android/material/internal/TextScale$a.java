package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class TextScale$a implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ TextView a;

    public TextScale$a(TextScale textScale, TextView textView) {
        this.a = textView;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.setScaleX(fFloatValue);
        this.a.setScaleY(fFloatValue);
    }
}
