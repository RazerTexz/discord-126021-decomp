package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes3.dex */
public class AppBarLayout$BaseBehavior$a implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f3025b;
    public final /* synthetic */ AppBarLayout$BaseBehavior c;

    public AppBarLayout$BaseBehavior$a(AppBarLayout$BaseBehavior appBarLayout$BaseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.c = appBarLayout$BaseBehavior;
        this.a = coordinatorLayout;
        this.f3025b = appBarLayout;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.c.setHeaderTopBottomOffset(this.a, this.f3025b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
