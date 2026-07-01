package com.discord.widgets.voice.model;

import androidx.core.app.NotificationCompat;
import co.discord.media_engine.VideoInputDeviceDescription;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreAudioManagerV2$State;
import com.discord.stores.StoreMediaSettings$VoiceConfiguration;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import rx.functions.Func8;

/* JADX INFO: compiled from: CallModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallModel$Companion$observeChunk$1<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<Long, Long, StoreMediaSettings$VoiceConfiguration, Map<Long, ? extends StoreVoiceParticipants$VoiceUser>, Long, List<? extends VideoInputDeviceDescription>, VideoInputDeviceDescription, StoreAudioManagerV2$State, CallModel$Companion$Chunk> {
    public final /* synthetic */ Channel $channel;

    public CallModel$Companion$observeChunk$1(Channel channel) {
        this.$channel = channel;
    }

    @Override // rx.functions.Func8
    public /* bridge */ /* synthetic */ CallModel$Companion$Chunk call(Long l, Long l2, StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, Map<Long, ? extends StoreVoiceParticipants$VoiceUser> map, Long l3, List<? extends VideoInputDeviceDescription> list, VideoInputDeviceDescription videoInputDeviceDescription, StoreAudioManagerV2$State storeAudioManagerV2$State) {
        return call2(l, l2, storeMediaSettings$VoiceConfiguration, (Map<Long, StoreVoiceParticipants$VoiceUser>) map, l3, (List<VideoInputDeviceDescription>) list, videoInputDeviceDescription, storeAudioManagerV2$State);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final CallModel$Companion$Chunk call2(Long l, Long l2, StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, Map<Long, StoreVoiceParticipants$VoiceUser> map, Long l3, List<VideoInputDeviceDescription> list, VideoInputDeviceDescription videoInputDeviceDescription, StoreAudioManagerV2$State storeAudioManagerV2$State) {
        Channel channel = this.$channel;
        m.checkNotNullExpressionValue(l, "myUserId");
        long jLongValue = l.longValue();
        m.checkNotNullExpressionValue(l2, "timeConnectedMs");
        long jLongValue2 = l2.longValue();
        m.checkNotNullExpressionValue(storeMediaSettings$VoiceConfiguration, "voiceConfig");
        m.checkNotNullExpressionValue(map, "voiceParticipants");
        m.checkNotNullExpressionValue(list, "videoDevices");
        m.checkNotNullExpressionValue(storeAudioManagerV2$State, "audioManagerState");
        return new CallModel$Companion$Chunk(channel, jLongValue, jLongValue2, storeMediaSettings$VoiceConfiguration, map, l3, list, videoInputDeviceDescription, storeAudioManagerV2$State);
    }
}
