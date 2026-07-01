package com.discord.widgets.voice.model;

import co.discord.media_engine.VideoInputDeviceDescription;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection$Metadata;
import com.discord.stores.StoreApplicationStreaming$ActiveApplicationStream;
import com.discord.stores.StoreAudioManagerV2$State;
import com.discord.stores.StoreMediaSettings$VoiceConfiguration;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.voice.VoiceChannelJoinability;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function10;

/* JADX INFO: compiled from: CallModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallModel$Companion$get$1$1$3 extends o implements Function10<CallModel$Companion$Chunk, StoreApplicationStreaming$ActiveApplicationStream, RtcConnection$Metadata, Integer, Integer, VoiceChannelJoinability, Guild, Long, List<? extends GuildScheduledEvent>, Map<Long, ? extends Application>, CallModel> {
    public final /* synthetic */ Map $embeddedActivities;
    public final /* synthetic */ CallModel$Companion$get$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallModel$Companion$get$1$1$3(CallModel$Companion$get$1$1 callModel$Companion$get$1$1, Map map) {
        super(10);
        this.this$0 = callModel$Companion$get$1$1;
        this.$embeddedActivities = map;
    }

    @Override // kotlin.jvm.functions.Function10
    public /* bridge */ /* synthetic */ CallModel invoke(CallModel$Companion$Chunk callModel$Companion$Chunk, StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream, RtcConnection$Metadata rtcConnection$Metadata, Integer num, Integer num2, VoiceChannelJoinability voiceChannelJoinability, Guild guild, Long l, List<? extends GuildScheduledEvent> list, Map<Long, ? extends Application> map) {
        return invoke(callModel$Companion$Chunk, storeApplicationStreaming$ActiveApplicationStream, rtcConnection$Metadata, num, num2, voiceChannelJoinability, guild, l.longValue(), (List<GuildScheduledEvent>) list, (Map<Long, Application>) map);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a7 A[SYNTHETIC] */
    public final CallModel invoke(CallModel$Companion$Chunk callModel$Companion$Chunk, StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream, RtcConnection$Metadata rtcConnection$Metadata, Integer num, Integer num2, VoiceChannelJoinability voiceChannelJoinability, Guild guild, long j, List<GuildScheduledEvent> list, Map<Long, Application> map) {
        Iterator it;
        boolean z2;
        m.checkNotNullParameter(callModel$Companion$Chunk, "chunk");
        m.checkNotNullParameter(voiceChannelJoinability, "voiceChannelJoinability");
        m.checkNotNullParameter(list, "guildScheduledEvents");
        m.checkNotNullParameter(map, "applications");
        CallModel$Companion callModel$Companion = CallModel.Companion;
        Channel channel = this.this$0.$channel;
        long myUserId = callModel$Companion$Chunk.getMyUserId();
        long timeConnectedMs = callModel$Companion$Chunk.getTimeConnectedMs();
        StoreMediaSettings$VoiceConfiguration voiceConfig = callModel$Companion$Chunk.getVoiceConfig();
        Map<Long, StoreVoiceParticipants$VoiceUser> voiceParticipants = callModel$Companion$Chunk.getVoiceParticipants();
        Long channelPermissions = callModel$Companion$Chunk.getChannelPermissions();
        List<VideoInputDeviceDescription> videoDevices = callModel$Companion$Chunk.getVideoDevices();
        boolean z3 = this.this$0.$channel.getId() == j;
        VideoInputDeviceDescription selectedVideoDevice = callModel$Companion$Chunk.getSelectedVideoDevice();
        m.checkNotNullExpressionValue(num, "callFeedbackTriggerRateDenominator");
        int iIntValue = num.intValue();
        m.checkNotNullExpressionValue(num2, "streamFeedbackTriggerRateDenominator");
        int iIntValue2 = num2.intValue();
        StoreAudioManagerV2$State audioManagerState = callModel$Companion$Chunk.getAudioManagerState();
        ArrayList arrayList = new ArrayList();
        for (Iterator it2 = list.iterator(); it2.hasNext(); it2 = it) {
            Object next = it2.next();
            Long channelId = ((GuildScheduledEvent) next).getChannelId();
            if (channelId == null) {
                it = it2;
            } else {
                it = it2;
                z2 = channelId.longValue() == this.this$0.this$0.$channelId;
                if (z2) {
                    arrayList.add(next);
                }
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        Map map2 = this.$embeddedActivities;
        m.checkNotNullExpressionValue(map2, "embeddedActivities");
        return CallModel$Companion.access$create(callModel$Companion, channel, guild, myUserId, timeConnectedMs, voiceConfig, voiceParticipants, channelPermissions, videoDevices, z3, selectedVideoDevice, storeApplicationStreaming$ActiveApplicationStream, rtcConnection$Metadata, iIntValue, iIntValue2, audioManagerState, voiceChannelJoinability, arrayList, map2, map);
    }
}
