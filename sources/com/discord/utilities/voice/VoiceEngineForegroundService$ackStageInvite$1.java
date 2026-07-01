package com.discord.utilities.voice;

import com.discord.utilities.error.Error;
import com.discord.widgets.stage.StageChannelNotifications;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: VoiceEngineForegroundService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineForegroundService$ackStageInvite$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ long $channelId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceEngineForegroundService$ackStageInvite$1(long j) {
        super(1);
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        StageChannelNotifications.Companion.getINSTANCE().onInvitedToSpeakAckFailed(this.$channelId);
    }
}
