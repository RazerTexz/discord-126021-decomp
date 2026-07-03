package com.discord.widgets.stage;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;
import p507d0.C12112k;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: StageChannelJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelJoinHelper$lurkAndJoinStageAsync$2$2 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ CancellableContinuation $continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelJoinHelper$lurkAndJoinStageAsync$2$2(CancellableContinuation cancellableContinuation) {
        super(0);
        this.$continuation = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        CancellableContinuation cancellableContinuation = this.$continuation;
        C12112k.a aVar = C12112k.f25169j;
        cancellableContinuation.resumeWith(C12112k.m11474constructorimpl(null));
    }
}
