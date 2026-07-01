package com.discord.utilities.animations;

import android.view.ViewPropertyAnimator;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AnimationCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnimationCoroutineUtilsKt$await$$inlined$suspendCancellableCoroutine$lambda$1 extends o implements Function1<Throwable, Unit> {
    public final /* synthetic */ ViewPropertyAnimator $this_await$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimationCoroutineUtilsKt$await$$inlined$suspendCancellableCoroutine$lambda$1(ViewPropertyAnimator viewPropertyAnimator) {
        super(1);
        this.$this_await$inlined = viewPropertyAnimator;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.$this_await$inlined.setListener(null);
        this.$this_await$inlined.cancel();
    }
}
