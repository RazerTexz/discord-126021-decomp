package com.discord.widgets.stage;

import com.discord.models.guild.Guild;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;
import p507d0.C12112k;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StageChannelJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelJoinHelper$lurkAndJoinStageAsync$2$1 extends AbstractC12240o implements Function3<Guild, Long, Boolean, Unit> {
    public final /* synthetic */ CancellableContinuation $continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelJoinHelper$lurkAndJoinStageAsync$2$1(CancellableContinuation cancellableContinuation) {
        super(3);
        this.$continuation = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild, Long l, Boolean bool) {
        invoke(guild, l, bool.booleanValue());
        return Unit.f27425a;
    }

    public final void invoke(Guild guild, Long l, boolean z2) {
        C12238m.checkNotNullParameter(guild, "<anonymous parameter 0>");
        CancellableContinuation cancellableContinuation = this.$continuation;
        Unit unit = Unit.f27425a;
        C12112k.a aVar = C12112k.f25169j;
        cancellableContinuation.resumeWith(C12112k.m11474constructorimpl(unit));
    }
}
