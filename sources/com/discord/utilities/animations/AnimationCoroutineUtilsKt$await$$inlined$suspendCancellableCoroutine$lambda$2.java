package com.discord.utilities.animations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import d0.k;
import d0.k$a;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: AnimationCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnimationCoroutineUtilsKt$await$$inlined$suspendCancellableCoroutine$lambda$2 extends AnimatorListenerAdapter {
    public final /* synthetic */ CancellableContinuation $cont;
    public final /* synthetic */ ViewPropertyAnimator $this_await$inlined;

    public AnimationCoroutineUtilsKt$await$$inlined$suspendCancellableCoroutine$lambda$2(CancellableContinuation cancellableContinuation, ViewPropertyAnimator viewPropertyAnimator) {
        this.$cont = cancellableContinuation;
        this.$this_await$inlined = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animation) {
        this.$this_await$inlined.setListener(null);
        if (this.$cont.a()) {
            this.$cont.k(null);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animation) {
        this.$this_await$inlined.setListener(null);
        if (this.$cont.a()) {
            CancellableContinuation cancellableContinuation = this.$cont;
            Unit unit = Unit.a;
            k$a k_a = k.j;
            cancellableContinuation.resumeWith(k.m97constructorimpl(unit));
        }
    }
}
