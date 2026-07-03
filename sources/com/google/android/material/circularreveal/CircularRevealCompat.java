package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.NonNull;
import com.google.android.material.circularreveal.CircularRevealWidget;

/* JADX INFO: loaded from: classes3.dex */
public final class CircularRevealCompat {

    /* JADX INFO: renamed from: com.google.android.material.circularreveal.CircularRevealCompat$a */
    public static class C10876a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ CircularRevealWidget f20956a;

        public C10876a(CircularRevealWidget circularRevealWidget) {
            this.f20956a = circularRevealWidget;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f20956a.destroyCircularRevealCache();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f20956a.buildCircularRevealCache();
        }
    }

    private CircularRevealCompat() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static Animator createCircularReveal(@NonNull CircularRevealWidget circularRevealWidget, float f, float f2, float f3) {
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(circularRevealWidget, (Property<CircularRevealWidget, V>) CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, (TypeEvaluator) CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, (Object[]) new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(f, f2, f3)});
        CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
        if (revealInfo == null) {
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal((View) circularRevealWidget, (int) f, (int) f2, revealInfo.radius, f3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, animatorCreateCircularReveal);
        return animatorSet;
    }

    @NonNull
    public static Animator.AnimatorListener createCircularRevealListener(@NonNull CircularRevealWidget circularRevealWidget) {
        return new C10876a(circularRevealWidget);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static Animator createCircularReveal(CircularRevealWidget circularRevealWidget, float f, float f2, float f3, float f4) {
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(circularRevealWidget, (Property<CircularRevealWidget, V>) CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, (TypeEvaluator) CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, (Object[]) new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(f, f2, f3), new CircularRevealWidget.RevealInfo(f, f2, f4)});
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal((View) circularRevealWidget, (int) f, (int) f2, f3, f4);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, animatorCreateCircularReveal);
        return animatorSet;
    }
}
