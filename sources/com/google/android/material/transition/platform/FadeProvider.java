package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import p007b.p225i.p226a.p341g.p353l.p354l.C4480k;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public final class FadeProvider implements VisibilityAnimatorProvider {
    private float incomingEndThreshold = 1.0f;

    /* JADX INFO: renamed from: com.google.android.material.transition.platform.FadeProvider$a */
    public static class C11051a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ View f21326a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ float f21327b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ float f21328c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ float f21329d;

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ float f21330e;

        public C11051a(View view, float f, float f2, float f3, float f4) {
            this.f21326a = view;
            this.f21327b = f;
            this.f21328c = f2;
            this.f21329d = f3;
            this.f21330e = f4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f21326a.setAlpha(C4480k.m6204e(this.f21327b, this.f21328c, this.f21329d, this.f21330e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.transition.platform.FadeProvider$b */
    public static class C11052b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ View f21331a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ float f21332b;

        public C11052b(View view, float f) {
            this.f21331a = view;
            this.f21332b = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f21331a.setAlpha(this.f21332b);
        }
    }

    private static Animator createFadeAnimator(View view, float f, float f2, @FloatRange(from = 0.0d, m75to = 1.0d) float f3, @FloatRange(from = 0.0d, m75to = 1.0d) float f4, float f5) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new C11051a(view, f, f2, f3, f4));
        valueAnimatorOfFloat.addListener(new C11052b(view, f5));
        return valueAnimatorOfFloat;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return createFadeAnimator(view, 0.0f, alpha, 0.0f, this.incomingEndThreshold, alpha);
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
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
