package com.discord.widgets.stage;

import d0.k;
import d0.k$a;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: StageChannelJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelJoinHelper$lurkAndJoinStageAsync$2$2 extends o implements Function0<Unit> {
    public final /* synthetic */ CancellableContinuation $continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelJoinHelper$lurkAndJoinStageAsync$2$2(CancellableContinuation cancellableContinuation) {
        super(0);
        this.$continuation = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        CancellableContinuation cancellableContinuation = this.$continuation;
        k$a k_a = k.j;
        cancellableContinuation.resumeWith(k.m97constructorimpl(null));
    }
}
