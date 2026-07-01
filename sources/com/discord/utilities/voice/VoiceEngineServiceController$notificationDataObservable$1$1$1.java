package com.discord.utilities.voice;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.rtcconnection.RtcConnection$State;
import com.discord.rtcconnection.audio.DiscordAudioManager$DeviceTypes;
import com.discord.stores.StoreAudioManagerV2$State;
import com.discord.stores.StoreMediaSettings$VoiceConfiguration;
import com.discord.widgets.voice.model.CallModel;
import rx.functions.Func3;

/* JADX INFO: compiled from: VoiceEngineServiceController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineServiceController$notificationDataObservable$1$1$1<T1, T2, T3, R> implements Func3<StoreMediaSettings$VoiceConfiguration, StoreAudioManagerV2$State, CallModel, VoiceEngineServiceController$NotificationData> {
    public final /* synthetic */ VoiceEngineServiceController$notificationDataObservable$1$1 this$0;

    public VoiceEngineServiceController$notificationDataObservable$1$1$1(VoiceEngineServiceController$notificationDataObservable$1$1 voiceEngineServiceController$notificationDataObservable$1$1) {
        this.this$0 = voiceEngineServiceController$notificationDataObservable$1$1;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ VoiceEngineServiceController$NotificationData call(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, StoreAudioManagerV2$State storeAudioManagerV2$State, CallModel callModel) {
        return call2(storeMediaSettings$VoiceConfiguration, storeAudioManagerV2$State, callModel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final VoiceEngineServiceController$NotificationData call2(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, StoreAudioManagerV2$State storeAudioManagerV2$State, CallModel callModel) {
        Channel channel;
        Channel channel2;
        Channel channel3;
        boolean z2 = false;
        boolean z3 = callModel != null && callModel.getIsVideoCall();
        boolean z4 = !z3 && (storeAudioManagerV2$State.getActiveAudioDevice() == DiscordAudioManager$DeviceTypes.EARPIECE);
        boolean z5 = callModel == null || !callModel.isSuppressed();
        RtcConnection$State rtcConnection$State = this.this$0.$state;
        String strC = (callModel == null || (channel3 = callModel.getChannel()) == null) ? null : ChannelUtils.c(channel3);
        if (strC == null) {
            strC = "";
        }
        boolean zIsSelfMuted = storeMediaSettings$VoiceConfiguration.isSelfMuted();
        boolean zIsSelfDeafened = storeMediaSettings$VoiceConfiguration.isSelfDeafened();
        boolean z6 = callModel != null && callModel.isStreaming();
        long id2 = (callModel == null || (channel2 = callModel.getChannel()) == null) ? -1L : channel2.getId();
        Long lValueOf = (callModel == null || (channel = callModel.getChannel()) == null) ? null : Long.valueOf(channel.getGuildId());
        if (lValueOf != null && lValueOf.longValue() > 0) {
            z2 = true;
        }
        if (!z2) {
            lValueOf = null;
        }
        return new VoiceEngineServiceController$NotificationData(rtcConnection$State, strC, zIsSelfMuted, zIsSelfDeafened, z6, z3, id2, lValueOf, z4, z5);
    }
}
