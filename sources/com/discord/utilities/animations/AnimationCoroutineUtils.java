package com.discord.utilities.animations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import d0.Result2;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.DebugProbes;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuation;
import s.a.CancellableContinuationImpl5;

/* JADX INFO: renamed from: com.discord.utilities.animations.AnimationCoroutineUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: AnimationCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnimationCoroutineUtils {
    public static final Object await(final ViewPropertyAnimator viewPropertyAnimator, Continuation<? super Unit> continuation) {
        final CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        cancellableContinuationImpl5.A();
        cancellableContinuationImpl5.f(new AnimationCoroutineUtils2(viewPropertyAnimator));
        viewPropertyAnimator.setListener(new AnimatorListenerAdapter() { // from class: com.discord.utilities.animations.AnimationCoroutineUtilsKt$await$$inlined$suspendCancellableCoroutine$lambda$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                viewPropertyAnimator.setListener(null);
                if (cancellableContinuationImpl5.a()) {
                    cancellableContinuationImpl5.k(null);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                viewPropertyAnimator.setListener(null);
                if (cancellableContinuationImpl5.a()) {
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl5;
                    Unit unit = Unit.a;
                    Result2.a aVar = Result2.j;
                    cancellableContinuation.resumeWith(Result2.m97constructorimpl(unit));
                }
            }
        });
        viewPropertyAnimator.start();
        Object objU = cancellableContinuationImpl5.u();
        if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return objU;
    }
}
