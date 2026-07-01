package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class CollapsingToolbarLayout$b implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ CollapsingToolbarLayout a;

    public CollapsingToolbarLayout$b(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.a = collapsingToolbarLayout;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.a.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
