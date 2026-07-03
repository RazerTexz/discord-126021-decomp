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
public final class FadeThroughProvider implements VisibilityAnimatorProvider {
    public static final float PROGRESS_THRESHOLD = 0.35f;

    /* JADX INFO: renamed from: com.google.android.material.transition.platform.FadeThroughProvider$a */
    public static class C11053a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ View f21333a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ float f21334b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ float f21335c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ float f21336d;

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ float f21337e;

        public C11053a(View view, float f, float f2, float f3, float f4) {
            this.f21333a = view;
            this.f21334b = f;
            this.f21335c = f2;
            this.f21336d = f3;
            this.f21337e = f4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f21333a.setAlpha(C4480k.m6204e(this.f21334b, this.f21335c, this.f21336d, this.f21337e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.transition.platform.FadeThroughProvider$b */
    public static class C11054b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ View f21338a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ float f21339b;

        public C11054b(View view, float f) {
            this.f21338a = view;
            this.f21339b = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f21338a.setAlpha(this.f21339b);
        }
    }

    private static Animator createFadeThroughAnimator(View view, float f, float f2, @FloatRange(from = 0.0d, m75to = 1.0d) float f3, @FloatRange(from = 0.0d, m75to = 1.0d) float f4, float f5) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new C11053a(view, f, f2, f3, f4));
        valueAnimatorOfFloat.addListener(new C11054b(view, f5));
        return valueAnimatorOfFloat;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return createFadeThroughAnimator(view, 0.0f, alpha, 0.35f, 1.0f, alpha);
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return createFadeThroughAnimator(view, alpha, 0.0f, 0.0f, 0.35f, alpha);
    }
}
