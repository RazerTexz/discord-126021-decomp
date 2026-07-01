package com.google.android.material.tabs;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class TabLayout$a implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ TabLayout a;

    public TabLayout$a(TabLayout tabLayout) {
        this.a = tabLayout;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.a.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
    }
}
