package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p225i.p226a.p341g.p353l.C4469k;

/* JADX INFO: loaded from: classes3.dex */
public final class FadeThroughProvider implements VisibilityAnimatorProvider {
    public static final float PROGRESS_THRESHOLD = 0.35f;

    /* JADX INFO: renamed from: com.google.android.material.transition.FadeThroughProvider$a */
    public static class C11042a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ View f21259a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ float f21260b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ float f21261c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ float f21262d;

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ float f21263e;

        public C11042a(View view, float f, float f2, float f3, float f4) {
            this.f21259a = view;
            this.f21260b = f;
            this.f21261c = f2;
            this.f21262d = f3;
            this.f21263e = f4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f21259a.setAlpha(C4469k.m6190e(this.f21260b, this.f21261c, this.f21262d, this.f21263e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.transition.FadeThroughProvider$b */
    public static class C11043b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ View f21264a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ float f21265b;

        public C11043b(View view, float f) {
            this.f21264a = view;
            this.f21265b = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f21264a.setAlpha(this.f21265b);
        }
    }

    private static Animator createFadeThroughAnimator(View view, float f, float f2, @FloatRange(from = 0.0d, m75to = 1.0d) float f3, @FloatRange(from = 0.0d, m75to = 1.0d) float f4, float f5) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new C11042a(view, f, f2, f3, f4));
        valueAnimatorOfFloat.addListener(new C11043b(view, f5));
        return valueAnimatorOfFloat;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return createFadeThroughAnimator(view, 0.0f, alpha, 0.35f, 1.0f, alpha);
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return createFadeThroughAnimator(view, alpha, 0.0f, 0.0f, 0.35f, alpha);
    }
}
