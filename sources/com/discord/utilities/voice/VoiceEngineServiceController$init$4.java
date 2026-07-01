package com.discord.utilities.voice;

import android.content.Context;
import b.a.k.b;
import com.discord.rtcconnection.RtcConnection$State$d;
import com.discord.rtcconnection.RtcConnection$State$f;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: VoiceEngineServiceController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineServiceController$init$4 extends o implements Function1<VoiceEngineServiceController$NotificationData, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ VoiceEngineServiceController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceEngineServiceController$init$4(VoiceEngineServiceController voiceEngineServiceController, Context context) {
        super(1);
        this.this$0 = voiceEngineServiceController;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(VoiceEngineServiceController$NotificationData voiceEngineServiceController$NotificationData) {
        invoke2(voiceEngineServiceController$NotificationData);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(VoiceEngineServiceController$NotificationData voiceEngineServiceController$NotificationData) {
        if (voiceEngineServiceController$NotificationData.getRtcConnectionState() instanceof RtcConnection$State$d) {
            DiscordOverlayService.Companion.launchForClose(this.$context);
            VoiceEngineForegroundService.Companion.stopForegroundAndUnbind(VoiceEngineServiceController.access$getServiceBinding$p(this.this$0));
            return;
        }
        Context context = this.$context;
        VoiceEngineForegroundService.Companion.startForegroundAndBind(VoiceEngineServiceController.access$getServiceBinding$p(this.this$0), b.h(context, 2131887382, new Object[]{b.h(context, voiceEngineServiceController$NotificationData.getStateString(), new Object[0], null, 4)}, null, 4), voiceEngineServiceController$NotificationData.getChannelName(), voiceEngineServiceController$NotificationData.isSelfMuted(), voiceEngineServiceController$NotificationData.isSelfDeafened(), voiceEngineServiceController$NotificationData.isSelfStreaming(), voiceEngineServiceController$NotificationData.getChannelId(), voiceEngineServiceController$NotificationData.getGuildId(), voiceEngineServiceController$NotificationData.getProximityLockEnabled(), voiceEngineServiceController$NotificationData.getCanSpeak());
        if (m.areEqual(voiceEngineServiceController$NotificationData.getRtcConnectionState(), RtcConnection$State$f.a)) {
            DiscordOverlayService.Companion.launchForVoice(this.$context);
        }
    }
}
