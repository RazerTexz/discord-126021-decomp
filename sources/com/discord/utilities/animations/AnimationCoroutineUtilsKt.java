package com.discord.utilities.animations;

import android.view.ViewPropertyAnimator;
import d0.w.h.b;
import d0.w.h.c;
import d0.w.i.a.g;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import s.a.l;

/* JADX INFO: compiled from: AnimationCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnimationCoroutineUtilsKt {
    public static final Object await(ViewPropertyAnimator viewPropertyAnimator, Continuation<? super Unit> continuation) {
        l lVar = new l(b.intercepted(continuation), 1);
        lVar.A();
        lVar.f(new AnimationCoroutineUtilsKt$await$$inlined$suspendCancellableCoroutine$lambda$1(viewPropertyAnimator));
        viewPropertyAnimator.setListener(new AnimationCoroutineUtilsKt$await$$inlined$suspendCancellableCoroutine$lambda$2(lVar, viewPropertyAnimator));
        viewPropertyAnimator.start();
        Object objU = lVar.u();
        if (objU == c.getCOROUTINE_SUSPENDED()) {
            g.probeCoroutineSuspended(continuation);
        }
        return objU;
    }
}
