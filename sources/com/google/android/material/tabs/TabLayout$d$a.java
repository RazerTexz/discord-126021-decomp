package com.google.android.material.tabs;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class TabLayout$d$a implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f3069b;
    public final /* synthetic */ TabLayout$d c;

    public TabLayout$d$a(TabLayout$d tabLayout$d, View view, View view2) {
        this.c = tabLayout$d;
        this.a = view;
        this.f3069b = view2;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.c.c(this.a, this.f3069b, valueAnimator.getAnimatedFraction());
    }
}
