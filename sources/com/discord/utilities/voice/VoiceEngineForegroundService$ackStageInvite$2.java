package com.discord.utilities.voice;

import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.stage.StageChannelNotifications$Notifications$InvitedToSpeak;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: VoiceEngineForegroundService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineForegroundService$ackStageInvite$2 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ boolean $accept;
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ VoiceEngineForegroundService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceEngineForegroundService$ackStageInvite$2(VoiceEngineForegroundService voiceEngineForegroundService, boolean z2, long j) {
        super(1);
        this.this$0 = voiceEngineForegroundService;
        this.$accept = z2;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r3) {
        if (this.$accept) {
            AnalyticsTracker.INSTANCE.promotedToSpeaker(this.$channelId);
        }
        StageChannelNotifications$Notifications$InvitedToSpeak.INSTANCE.cancel(this.this$0);
    }
}
