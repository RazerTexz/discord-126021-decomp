package com.discord.widgets.stage;

import com.discord.models.guild.Guild;
import d0.k;
import d0.k$a;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: StageChannelJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelJoinHelper$lurkAndJoinStageAsync$2$1 extends o implements Function3<Guild, Long, Boolean, Unit> {
    public final /* synthetic */ CancellableContinuation $continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelJoinHelper$lurkAndJoinStageAsync$2$1(CancellableContinuation cancellableContinuation) {
        super(3);
        this.$continuation = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild, Long l, Boolean bool) {
        invoke(guild, l, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(Guild guild, Long l, boolean z2) {
        m.checkNotNullParameter(guild, "<anonymous parameter 0>");
        CancellableContinuation cancellableContinuation = this.$continuation;
        Unit unit = Unit.a;
        k$a k_a = k.j;
        cancellableContinuation.resumeWith(k.m97constructorimpl(unit));
    }
}
