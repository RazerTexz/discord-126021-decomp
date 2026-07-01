package com.discord.widgets.voice.model;

import co.discord.media_engine.VideoInputDeviceDescription;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guild.GuildMaxVideoChannelUsers$Unlimited;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection$Metadata;
import com.discord.stores.StoreApplicationStreaming$ActiveApplicationStream;
import com.discord.stores.StoreAudioManagerV2$State;
import com.discord.stores.StoreMediaSettings$VoiceConfiguration;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.voice.VoiceChannelJoinability;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: CallModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallModel$Companion {
    private CallModel$Companion() {
    }

    public static final /* synthetic */ CallModel access$create(CallModel$Companion callModel$Companion, Channel channel, Guild guild, long j, long j2, StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, Map map, Long l, List list, boolean z2, VideoInputDeviceDescription videoInputDeviceDescription, StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream, RtcConnection$Metadata rtcConnection$Metadata, int i, int i2, StoreAudioManagerV2$State storeAudioManagerV2$State, VoiceChannelJoinability voiceChannelJoinability, List list2, Map map2, Map map3) {
        return callModel$Companion.create(channel, guild, j, j2, storeMediaSettings$VoiceConfiguration, map, l, list, z2, videoInputDeviceDescription, storeApplicationStreaming$ActiveApplicationStream, rtcConnection$Metadata, i, i2, storeAudioManagerV2$State, voiceChannelJoinability, list2, map2, map3);
    }

    public static final /* synthetic */ Observable access$observeChunk(CallModel$Companion callModel$Companion, Channel channel) {
        return callModel$Companion.observeChunk(channel);
    }

    private final CallModel create(Channel channel, Guild guild, long myUserId, long timeConnectedMs, StoreMediaSettings$VoiceConfiguration voiceConfig, Map<Long, StoreVoiceParticipants$VoiceUser> voiceParticipants, Long channelPermissions, List<VideoInputDeviceDescription> videoDevices, boolean isChannelSelected, VideoInputDeviceDescription selectedVideoDevice, StoreApplicationStreaming$ActiveApplicationStream activeStream, RtcConnection$Metadata rtcConnectionMetadata, int callFeedbackTriggerRateDenominator, int streamFeedbackTriggerRateDenominator, StoreAudioManagerV2$State audioManagerState, VoiceChannelJoinability voiceChannelJoinability, List<GuildScheduledEvent> guildScheduledEvents, Map<Long, EmbeddedActivity> embeddedActivitiesForChannel, Map<Long, Application> applications) {
        int i;
        GuildMaxVideoChannelUsers maxVideoChannelUsers;
        if (voiceParticipants.isEmpty()) {
            i = 0;
        } else {
            Iterator<Map$Entry<Long, StoreVoiceParticipants$VoiceUser>> it = voiceParticipants.entrySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getValue().isConnected()) {
                    i2++;
                }
            }
            i = i2;
        }
        StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser = voiceParticipants.get(Long.valueOf(myUserId));
        boolean z2 = storeVoiceParticipants$VoiceUser != null && storeVoiceParticipants$VoiceUser.getIsRequestingToSpeak();
        if (guild == null || (maxVideoChannelUsers = guild.getMaxVideoChannelUsers()) == null) {
            maxVideoChannelUsers = GuildMaxVideoChannelUsers$Unlimited.INSTANCE;
        }
        return new CallModel(voiceParticipants, myUserId, timeConnectedMs, videoDevices, selectedVideoDevice, voiceConfig, rtcConnectionMetadata, callFeedbackTriggerRateDenominator, streamFeedbackTriggerRateDenominator, activeStream, voiceChannelJoinability, maxVideoChannelUsers, guild, isChannelSelected, z2, guildScheduledEvents, embeddedActivitiesForChannel, applications, channel, i, channelPermissions, audioManagerState);
    }

    private final Observable<CallModel$Companion$Chunk> observeChunk(Channel channel) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<CallModel$Companion$Chunk> observableD = Observable.d(storeStream$Companion.getUsers().observeMeId(), storeStream$Companion.getVoiceChannelSelected().observeTimeSelectedMs(), storeStream$Companion.getMediaSettings().getVoiceConfiguration(), ObservableExtensionsKt.leadingEdgeThrottle(storeStream$Companion.getVoiceParticipants().get(channel.getId()), 250L, TimeUnit.MILLISECONDS), storeStream$Companion.getPermissions().observePermissionsForChannel(channel.getId()), storeStream$Companion.getMediaEngine().getVideoInputDevices(), storeStream$Companion.getMediaEngine().getSelectedVideoInputDevice(), storeStream$Companion.getAudioManagerV2().observeAudioManagerState(), new CallModel$Companion$observeChunk$1(channel));
        m.checkNotNullExpressionValue(observableD, "Observable\n          .co…            )\n          }");
        return observableD;
    }

    public final Observable<CallModel> get(long channelId) {
        Observable observableY = StoreStream.Companion.getChannels().observeChannel(channelId).Y(new CallModel$Companion$get$1(channelId));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n          .g…            }\n          }");
        return observableY;
    }

    public /* synthetic */ CallModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
