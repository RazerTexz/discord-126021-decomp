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
public final class FadeProvider implements VisibilityAnimatorProvider {
    private float incomingEndThreshold = 1.0f;

    /* JADX INFO: renamed from: com.google.android.material.transition.FadeProvider$a */
    public static class C11040a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ View f21252a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ float f21253b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ float f21254c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ float f21255d;

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ float f21256e;

        public C11040a(View view, float f, float f2, float f3, float f4) {
            this.f21252a = view;
            this.f21253b = f;
            this.f21254c = f2;
            this.f21255d = f3;
            this.f21256e = f4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f21252a.setAlpha(C4469k.m6190e(this.f21253b, this.f21254c, this.f21255d, this.f21256e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.transition.FadeProvider$b */
    public static class C11041b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ View f21257a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ float f21258b;

        public C11041b(View view, float f) {
            this.f21257a = view;
            this.f21258b = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f21257a.setAlpha(this.f21258b);
        }
    }

    private static Animator createFadeAnimator(View view, float f, float f2, @FloatRange(from = 0.0d, m75to = 1.0d) float f3, @FloatRange(from = 0.0d, m75to = 1.0d) float f4, float f5) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new C11040a(view, f, f2, f3, f4));
        valueAnimatorOfFloat.addListener(new C11041b(view, f5));
        return valueAnimatorOfFloat;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return createFadeAnimator(view, 0.0f, alpha, 0.0f, this.incomingEndThreshold, alpha);
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return createFadeAnimator(view, alpha, 0.0f, 0.0f, 1.0f, alpha);
    }

    public float getIncomingEndThreshold() {
        return this.incomingEndThreshold;
    }

    public void setIncomingEndThreshold(float f) {
        this.incomingEndThreshold = f;
    }
}
