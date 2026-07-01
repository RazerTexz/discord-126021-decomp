package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import androidx.annotation.NonNull;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: loaded from: classes3.dex */
public class AppBarLayout$b implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ MaterialShapeDrawable a;

    public AppBarLayout$b(AppBarLayout appBarLayout, MaterialShapeDrawable materialShapeDrawable) {
        this.a = materialShapeDrawable;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.a.setElevation(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
