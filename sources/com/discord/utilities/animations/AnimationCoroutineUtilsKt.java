package com.discord.utilities.animations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuation;
import p507d0.C12112k;
import p507d0.p584w.p585h.C12182b;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.C12190g;
import p659s.p660a.C13126l;

/* JADX INFO: compiled from: AnimationCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnimationCoroutineUtilsKt {
    public static final Object await(final ViewPropertyAnimator viewPropertyAnimator, Continuation<? super Unit> continuation) {
        final C13126l c13126l = new C13126l(C12182b.intercepted(continuation), 1);
        c13126l.m11318A();
        c13126l.mo10902f(new C6685x9d347c01(viewPropertyAnimator));
        viewPropertyAnimator.setListener(new AnimatorListenerAdapter() { // from class: com.discord.utilities.animations.AnimationCoroutineUtilsKt$await$$inlined$suspendCancellableCoroutine$lambda$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                viewPropertyAnimator.setListener(null);
                if (c13126l.mo10900a()) {
                    c13126l.mo10906k(null);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                viewPropertyAnimator.setListener(null);
                if (c13126l.mo10900a()) {
                    CancellableContinuation cancellableContinuation = c13126l;
                    Unit unit = Unit.f27425a;
                    C12112k.a aVar = C12112k.f25169j;
                    cancellableContinuation.resumeWith(C12112k.m11474constructorimpl(unit));
                }
            }
        });
        viewPropertyAnimator.start();
        Object objM11326u = c13126l.m11326u();
        if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
            C12190g.probeCoroutineSuspended(continuation);
        }
        return objM11326u;
    }
}
