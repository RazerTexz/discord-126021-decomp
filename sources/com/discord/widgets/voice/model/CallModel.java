package com.discord.widgets.voice.model;

import a0.a.a.b;
import b.c.a.a0.d;
import b.d.b.a.a;
import co.discord.media_engine.VideoInputDeviceDescription;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection$Metadata;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode;
import com.discord.stores.StoreApplicationStreaming$ActiveApplicationStream;
import com.discord.stores.StoreAudioManagerV2$State;
import com.discord.stores.StoreMediaSettings$VoiceConfiguration;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.voice.VoiceChannelJoinability;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: CallModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CallModel {
    public static final CallModel$Companion Companion = new CallModel$Companion(null);
    private final StoreApplicationStreaming$ActiveApplicationStream activeStream;
    private final Map<Long, Application> applications;
    private final StoreAudioManagerV2$State audioManagerState;
    private final int callFeedbackTriggerRateDenominator;
    private final CameraState cameraState;
    private final Channel channel;
    private final Long channelPermissions;
    private final Map<Long, EmbeddedActivity> embeddedActivitiesForChannel;
    private final Guild guild;
    private final GuildMaxVideoChannelUsers guildMaxVideoChannelMembers;
    private final List<GuildScheduledEvent> guildScheduledEvents;
    private final boolean isChannelSelected;
    private final boolean isMyHandRaised;
    private final boolean isVideoCall;
    private final long myId;
    private final int numUsersConnected;
    private final Map<Long, StoreVoiceParticipants$VoiceUser> participants;
    private final RtcConnection$Metadata rtcConnectionMetadata;
    private final VideoInputDeviceDescription selectedVideoDevice;
    private final int streamFeedbackTriggerRateDenominator;
    private final long timeConnectedMs;
    private final List<VideoInputDeviceDescription> videoDevices;
    private final VoiceChannelJoinability voiceChannelJoinability;
    private final StoreMediaSettings$VoiceConfiguration voiceSettings;

    public CallModel(Map<Long, StoreVoiceParticipants$VoiceUser> map, long j, long j2, List<VideoInputDeviceDescription> list, VideoInputDeviceDescription videoInputDeviceDescription, StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, RtcConnection$Metadata rtcConnection$Metadata, int i, int i2, StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream, VoiceChannelJoinability voiceChannelJoinability, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, Guild guild, boolean z2, boolean z3, List<GuildScheduledEvent> list2, Map<Long, EmbeddedActivity> map2, Map<Long, Application> map3, Channel channel, int i3, Long l, StoreAudioManagerV2$State storeAudioManagerV2$State) {
        boolean z4;
        m.checkNotNullParameter(map, "participants");
        m.checkNotNullParameter(list, "videoDevices");
        m.checkNotNullParameter(storeMediaSettings$VoiceConfiguration, "voiceSettings");
        m.checkNotNullParameter(voiceChannelJoinability, "voiceChannelJoinability");
        m.checkNotNullParameter(guildMaxVideoChannelUsers, "guildMaxVideoChannelMembers");
        m.checkNotNullParameter(list2, "guildScheduledEvents");
        m.checkNotNullParameter(map2, "embeddedActivitiesForChannel");
        m.checkNotNullParameter(map3, "applications");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(storeAudioManagerV2$State, "audioManagerState");
        this.participants = map;
        this.myId = j;
        this.timeConnectedMs = j2;
        this.videoDevices = list;
        this.selectedVideoDevice = videoInputDeviceDescription;
        this.voiceSettings = storeMediaSettings$VoiceConfiguration;
        this.rtcConnectionMetadata = rtcConnection$Metadata;
        this.callFeedbackTriggerRateDenominator = i;
        this.streamFeedbackTriggerRateDenominator = i2;
        this.activeStream = storeApplicationStreaming$ActiveApplicationStream;
        this.voiceChannelJoinability = voiceChannelJoinability;
        this.guildMaxVideoChannelMembers = guildMaxVideoChannelUsers;
        this.guild = guild;
        this.isChannelSelected = z2;
        this.isMyHandRaised = z3;
        this.guildScheduledEvents = list2;
        this.embeddedActivitiesForChannel = map2;
        this.applications = map3;
        this.channel = channel;
        this.numUsersConnected = i3;
        this.channelPermissions = l;
        this.audioManagerState = storeAudioManagerV2$State;
        this.cameraState = videoInputDeviceDescription != null ? CameraState.CAMERA_ON : CameraState.CAMERA_OFF;
        boolean z5 = true;
        if (!isStreaming()) {
            if (!map.isEmpty()) {
                Iterator<Map$Entry<Long, StoreVoiceParticipants$VoiceUser>> it = map.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z4 = false;
                        break;
                    }
                    VoiceState voiceState = it.next().getValue().getVoiceState();
                    if (voiceState != null ? voiceState.getSelfVideo() : false) {
                        z4 = true;
                        break;
                    }
                }
            } else {
                z4 = false;
                break;
            }
            if (!z4) {
                z5 = false;
            }
        }
        this.isVideoCall = z5;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    private final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    private final int getNumUsersConnected() {
        return this.numUsersConnected;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    private final Long getChannelPermissions() {
        return this.channelPermissions;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    private final StoreAudioManagerV2$State getAudioManagerState() {
        return this.audioManagerState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallModel copy$default(CallModel callModel, Map map, long j, long j2, List list, VideoInputDeviceDescription videoInputDeviceDescription, StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, RtcConnection$Metadata rtcConnection$Metadata, int i, int i2, StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream, VoiceChannelJoinability voiceChannelJoinability, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, Guild guild, boolean z2, boolean z3, List list2, Map map2, Map map3, Channel channel, int i3, Long l, StoreAudioManagerV2$State storeAudioManagerV2$State, int i4, Object obj) {
        return callModel.copy((i4 & 1) != 0 ? callModel.participants : map, (i4 & 2) != 0 ? callModel.myId : j, (i4 & 4) != 0 ? callModel.timeConnectedMs : j2, (i4 & 8) != 0 ? callModel.videoDevices : list, (i4 & 16) != 0 ? callModel.selectedVideoDevice : videoInputDeviceDescription, (i4 & 32) != 0 ? callModel.voiceSettings : storeMediaSettings$VoiceConfiguration, (i4 & 64) != 0 ? callModel.rtcConnectionMetadata : rtcConnection$Metadata, (i4 & 128) != 0 ? callModel.callFeedbackTriggerRateDenominator : i, (i4 & 256) != 0 ? callModel.streamFeedbackTriggerRateDenominator : i2, (i4 & 512) != 0 ? callModel.activeStream : storeApplicationStreaming$ActiveApplicationStream, (i4 & 1024) != 0 ? callModel.voiceChannelJoinability : voiceChannelJoinability, (i4 & 2048) != 0 ? callModel.guildMaxVideoChannelMembers : guildMaxVideoChannelUsers, (i4 & 4096) != 0 ? callModel.guild : guild, (i4 & 8192) != 0 ? callModel.isChannelSelected : z2, (i4 & 16384) != 0 ? callModel.isMyHandRaised : z3, (i4 & 32768) != 0 ? callModel.guildScheduledEvents : list2, (i4 & 65536) != 0 ? callModel.embeddedActivitiesForChannel : map2, (i4 & 131072) != 0 ? callModel.applications : map3, (i4 & 262144) != 0 ? callModel.channel : channel, (i4 & 524288) != 0 ? callModel.numUsersConnected : i3, (i4 & 1048576) != 0 ? callModel.channelPermissions : l, (i4 & 2097152) != 0 ? callModel.audioManagerState : storeAudioManagerV2$State);
    }

    public final boolean canInvite() {
        boolean zB = ChannelUtils.B(this.channel);
        boolean z2 = ChannelUtils.w(this.channel) && PermissionUtils.can(1L, this.channelPermissions);
        StageInstance stageInstanceForChannel = StoreStream.Companion.getStageInstances().getStageInstanceForChannel(this.channel.getId());
        return zB || z2 || ((stageInstanceForChannel != null ? stageInstanceForChannel.getInviteCode() : null) != null);
    }

    public final boolean canManageEvent() {
        return GuildScheduledEventUtilities.Companion.canStartEventInChannel(this.channel, this.channelPermissions);
    }

    public final boolean canRequestToSpeak() {
        return ChannelUtils.D(this.channel) && PermissionUtils.can(Permission.REQUEST_TO_SPEAK, this.channelPermissions);
    }

    public final Map<Long, StoreVoiceParticipants$VoiceUser> component1() {
        return this.participants;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final StoreApplicationStreaming$ActiveApplicationStream getActiveStream() {
        return this.activeStream;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final VoiceChannelJoinability getVoiceChannelJoinability() {
        return this.voiceChannelJoinability;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final GuildMaxVideoChannelUsers getGuildMaxVideoChannelMembers() {
        return this.guildMaxVideoChannelMembers;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getIsChannelSelected() {
        return this.isChannelSelected;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getIsMyHandRaised() {
        return this.isMyHandRaised;
    }

    public final List<GuildScheduledEvent> component16() {
        return this.guildScheduledEvents;
    }

    public final Map<Long, EmbeddedActivity> component17() {
        return this.embeddedActivitiesForChannel;
    }

    public final Map<Long, Application> component18() {
        return this.applications;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMyId() {
        return this.myId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getTimeConnectedMs() {
        return this.timeConnectedMs;
    }

    public final List<VideoInputDeviceDescription> component4() {
        return this.videoDevices;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final VideoInputDeviceDescription getSelectedVideoDevice() {
        return this.selectedVideoDevice;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final StoreMediaSettings$VoiceConfiguration getVoiceSettings() {
        return this.voiceSettings;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final RtcConnection$Metadata getRtcConnectionMetadata() {
        return this.rtcConnectionMetadata;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getCallFeedbackTriggerRateDenominator() {
        return this.callFeedbackTriggerRateDenominator;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getStreamFeedbackTriggerRateDenominator() {
        return this.streamFeedbackTriggerRateDenominator;
    }

    public final CallModel copy(Map<Long, StoreVoiceParticipants$VoiceUser> participants, long myId, long timeConnectedMs, List<VideoInputDeviceDescription> videoDevices, VideoInputDeviceDescription selectedVideoDevice, StoreMediaSettings$VoiceConfiguration voiceSettings, RtcConnection$Metadata rtcConnectionMetadata, int callFeedbackTriggerRateDenominator, int streamFeedbackTriggerRateDenominator, StoreApplicationStreaming$ActiveApplicationStream activeStream, VoiceChannelJoinability voiceChannelJoinability, GuildMaxVideoChannelUsers guildMaxVideoChannelMembers, Guild guild, boolean isChannelSelected, boolean isMyHandRaised, List<GuildScheduledEvent> guildScheduledEvents, Map<Long, EmbeddedActivity> embeddedActivitiesForChannel, Map<Long, Application> applications, Channel channel, int numUsersConnected, Long channelPermissions, StoreAudioManagerV2$State audioManagerState) {
        m.checkNotNullParameter(participants, "participants");
        m.checkNotNullParameter(videoDevices, "videoDevices");
        m.checkNotNullParameter(voiceSettings, "voiceSettings");
        m.checkNotNullParameter(voiceChannelJoinability, "voiceChannelJoinability");
        m.checkNotNullParameter(guildMaxVideoChannelMembers, "guildMaxVideoChannelMembers");
        m.checkNotNullParameter(guildScheduledEvents, "guildScheduledEvents");
        m.checkNotNullParameter(embeddedActivitiesForChannel, "embeddedActivitiesForChannel");
        m.checkNotNullParameter(applications, "applications");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(audioManagerState, "audioManagerState");
        return new CallModel(participants, myId, timeConnectedMs, videoDevices, selectedVideoDevice, voiceSettings, rtcConnectionMetadata, callFeedbackTriggerRateDenominator, streamFeedbackTriggerRateDenominator, activeStream, voiceChannelJoinability, guildMaxVideoChannelMembers, guild, isChannelSelected, isMyHandRaised, guildScheduledEvents, embeddedActivitiesForChannel, applications, channel, numUsersConnected, channelPermissions, audioManagerState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallModel)) {
            return false;
        }
        CallModel callModel = (CallModel) other;
        return m.areEqual(this.participants, callModel.participants) && this.myId == callModel.myId && this.timeConnectedMs == callModel.timeConnectedMs && m.areEqual(this.videoDevices, callModel.videoDevices) && m.areEqual(this.selectedVideoDevice, callModel.selectedVideoDevice) && m.areEqual(this.voiceSettings, callModel.voiceSettings) && m.areEqual(this.rtcConnectionMetadata, callModel.rtcConnectionMetadata) && this.callFeedbackTriggerRateDenominator == callModel.callFeedbackTriggerRateDenominator && this.streamFeedbackTriggerRateDenominator == callModel.streamFeedbackTriggerRateDenominator && m.areEqual(this.activeStream, callModel.activeStream) && m.areEqual(this.voiceChannelJoinability, callModel.voiceChannelJoinability) && m.areEqual(this.guildMaxVideoChannelMembers, callModel.guildMaxVideoChannelMembers) && m.areEqual(this.guild, callModel.guild) && this.isChannelSelected == callModel.isChannelSelected && this.isMyHandRaised == callModel.isMyHandRaised && m.areEqual(this.guildScheduledEvents, callModel.guildScheduledEvents) && m.areEqual(this.embeddedActivitiesForChannel, callModel.embeddedActivitiesForChannel) && m.areEqual(this.applications, callModel.applications) && m.areEqual(this.channel, callModel.channel) && this.numUsersConnected == callModel.numUsersConnected && m.areEqual(this.channelPermissions, callModel.channelPermissions) && m.areEqual(this.audioManagerState, callModel.audioManagerState);
    }

    public final StoreApplicationStreaming$ActiveApplicationStream getActiveStream() {
        return this.activeStream;
    }

    public final Map<Long, Application> getApplications() {
        return this.applications;
    }

    public final StoreAudioManagerV2$State getAudioManagerState() {
        return this.audioManagerState;
    }

    public final long getCallDurationMs(Clock clock) {
        m.checkNotNullParameter(clock, "clock");
        return clock.currentTimeMillis() - this.timeConnectedMs;
    }

    public final int getCallFeedbackTriggerRateDenominator() {
        return this.callFeedbackTriggerRateDenominator;
    }

    public final CameraState getCameraState() {
        return this.cameraState;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Long getChannelPermissions() {
        return this.channelPermissions;
    }

    public final StoreVoiceParticipants$VoiceUser getDmRecipient() {
        Object obj = null;
        if (this.channel.getType() != 1) {
            return null;
        }
        for (Object obj2 : this.participants.values()) {
            if (((StoreVoiceParticipants$VoiceUser) obj2).getUser().getId() != this.myId) {
                obj = obj2;
                break;
            }
        }
        return (StoreVoiceParticipants$VoiceUser) obj;
    }

    public final Map<Long, EmbeddedActivity> getEmbeddedActivitiesForChannel() {
        return this.embeddedActivitiesForChannel;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final GuildMaxVideoChannelUsers getGuildMaxVideoChannelMembers() {
        return this.guildMaxVideoChannelMembers;
    }

    public final List<GuildScheduledEvent> getGuildScheduledEvents() {
        return this.guildScheduledEvents;
    }

    public final MediaEngineConnection$InputMode getInputMode() {
        return this.voiceSettings.getInputMode();
    }

    public final long getMyId() {
        return this.myId;
    }

    public final int getNumUsersConnected() {
        return this.numUsersConnected;
    }

    public final Map<Long, StoreVoiceParticipants$VoiceUser> getParticipants() {
        return this.participants;
    }

    public final RtcConnection$Metadata getRtcConnectionMetadata() {
        return this.rtcConnectionMetadata;
    }

    public final VideoInputDeviceDescription getSelectedVideoDevice() {
        return this.selectedVideoDevice;
    }

    public final int getStreamFeedbackTriggerRateDenominator() {
        return this.streamFeedbackTriggerRateDenominator;
    }

    public final long getTimeConnectedMs() {
        return this.timeConnectedMs;
    }

    public final List<VideoInputDeviceDescription> getVideoDevices() {
        return this.videoDevices;
    }

    public final VoiceChannelJoinability getVoiceChannelJoinability() {
        return this.voiceChannelJoinability;
    }

    public final StoreMediaSettings$VoiceConfiguration getVoiceSettings() {
        return this.voiceSettings;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v31, types: [int] */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public int hashCode() {
        Map<Long, StoreVoiceParticipants$VoiceUser> map = this.participants;
        int iA = (b.a(this.timeConnectedMs) + ((b.a(this.myId) + ((map != null ? map.hashCode() : 0) * 31)) * 31)) * 31;
        List<VideoInputDeviceDescription> list = this.videoDevices;
        int iHashCode = (iA + (list != null ? list.hashCode() : 0)) * 31;
        VideoInputDeviceDescription videoInputDeviceDescription = this.selectedVideoDevice;
        int iHashCode2 = (iHashCode + (videoInputDeviceDescription != null ? videoInputDeviceDescription.hashCode() : 0)) * 31;
        StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration = this.voiceSettings;
        int iHashCode3 = (iHashCode2 + (storeMediaSettings$VoiceConfiguration != null ? storeMediaSettings$VoiceConfiguration.hashCode() : 0)) * 31;
        RtcConnection$Metadata rtcConnection$Metadata = this.rtcConnectionMetadata;
        int iHashCode4 = (((((iHashCode3 + (rtcConnection$Metadata != null ? rtcConnection$Metadata.hashCode() : 0)) * 31) + this.callFeedbackTriggerRateDenominator) * 31) + this.streamFeedbackTriggerRateDenominator) * 31;
        StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream = this.activeStream;
        int iHashCode5 = (iHashCode4 + (storeApplicationStreaming$ActiveApplicationStream != null ? storeApplicationStreaming$ActiveApplicationStream.hashCode() : 0)) * 31;
        VoiceChannelJoinability voiceChannelJoinability = this.voiceChannelJoinability;
        int iHashCode6 = (iHashCode5 + (voiceChannelJoinability != null ? voiceChannelJoinability.hashCode() : 0)) * 31;
        GuildMaxVideoChannelUsers guildMaxVideoChannelUsers = this.guildMaxVideoChannelMembers;
        int iHashCode7 = (iHashCode6 + (guildMaxVideoChannelUsers != null ? guildMaxVideoChannelUsers.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int iHashCode8 = (iHashCode7 + (guild != null ? guild.hashCode() : 0)) * 31;
        boolean z2 = this.isChannelSelected;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode8 + r2) * 31;
        boolean z3 = this.isMyHandRaised;
        int i2 = (i + (z3 ? 1 : z3)) * 31;
        List<GuildScheduledEvent> list2 = this.guildScheduledEvents;
        int iHashCode9 = (i2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Map<Long, EmbeddedActivity> map2 = this.embeddedActivitiesForChannel;
        int iHashCode10 = (iHashCode9 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, Application> map3 = this.applications;
        int iHashCode11 = (iHashCode10 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode12 = (((iHashCode11 + (channel != null ? channel.hashCode() : 0)) * 31) + this.numUsersConnected) * 31;
        Long l = this.channelPermissions;
        int iHashCode13 = (iHashCode12 + (l != null ? l.hashCode() : 0)) * 31;
        StoreAudioManagerV2$State storeAudioManagerV2$State = this.audioManagerState;
        return iHashCode13 + (storeAudioManagerV2$State != null ? storeAudioManagerV2$State.hashCode() : 0);
    }

    public final boolean isChannelSelected() {
        return this.isChannelSelected;
    }

    public final boolean isConnected() {
        StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser = this.participants.get(Long.valueOf(this.myId));
        if (storeVoiceParticipants$VoiceUser != null) {
            return storeVoiceParticipants$VoiceUser.isConnected();
        }
        return false;
    }

    public final boolean isDeafenedByAnySource() {
        return isSelfDeafened() || isServerDeafened();
    }

    public final boolean isMeMutedByAnySource() {
        VoiceState voiceState;
        StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser = this.participants.get(Long.valueOf(this.myId));
        if (storeVoiceParticipants$VoiceUser == null || (voiceState = storeVoiceParticipants$VoiceUser.getVoiceState()) == null) {
            return false;
        }
        return d.V0(voiceState);
    }

    public final boolean isMuted() {
        VoiceState voiceState;
        StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser = this.participants.get(Long.valueOf(this.myId));
        if (storeVoiceParticipants$VoiceUser == null || (voiceState = storeVoiceParticipants$VoiceUser.getVoiceState()) == null) {
            return false;
        }
        return voiceState.getMute();
    }

    public final boolean isMyHandRaised() {
        return this.isMyHandRaised;
    }

    public final boolean isSelfDeafened() {
        return this.voiceSettings.isSelfDeafened();
    }

    public final boolean isServerDeafened() {
        VoiceState voiceState;
        StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser = this.participants.get(Long.valueOf(this.myId));
        if (storeVoiceParticipants$VoiceUser == null || (voiceState = storeVoiceParticipants$VoiceUser.getVoiceState()) == null) {
            return false;
        }
        return voiceState.getDeaf();
    }

    public final boolean isStreaming() {
        ModelApplicationStream stream;
        long j = this.myId;
        StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream = this.activeStream;
        return (storeApplicationStreaming$ActiveApplicationStream == null || (stream = storeApplicationStreaming$ActiveApplicationStream.getStream()) == null || j != stream.getOwnerId()) ? false : true;
    }

    public final boolean isSuppressed() {
        VoiceState voiceState;
        StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser = this.participants.get(Long.valueOf(this.myId));
        if (storeVoiceParticipants$VoiceUser == null || (voiceState = storeVoiceParticipants$VoiceUser.getVoiceState()) == null) {
            return false;
        }
        return voiceState.getSuppress();
    }

    /* JADX INFO: renamed from: isVideoCall, reason: from getter */
    public final boolean getIsVideoCall() {
        return this.isVideoCall;
    }

    public String toString() {
        StringBuilder sbU = a.U("CallModel(participants=");
        sbU.append(this.participants);
        sbU.append(", myId=");
        sbU.append(this.myId);
        sbU.append(", timeConnectedMs=");
        sbU.append(this.timeConnectedMs);
        sbU.append(", videoDevices=");
        sbU.append(this.videoDevices);
        sbU.append(", selectedVideoDevice=");
        sbU.append(this.selectedVideoDevice);
        sbU.append(", voiceSettings=");
        sbU.append(this.voiceSettings);
        sbU.append(", rtcConnectionMetadata=");
        sbU.append(this.rtcConnectionMetadata);
        sbU.append(", callFeedbackTriggerRateDenominator=");
        sbU.append(this.callFeedbackTriggerRateDenominator);
        sbU.append(", streamFeedbackTriggerRateDenominator=");
        sbU.append(this.streamFeedbackTriggerRateDenominator);
        sbU.append(", activeStream=");
        sbU.append(this.activeStream);
        sbU.append(", voiceChannelJoinability=");
        sbU.append(this.voiceChannelJoinability);
        sbU.append(", guildMaxVideoChannelMembers=");
        sbU.append(this.guildMaxVideoChannelMembers);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", isChannelSelected=");
        sbU.append(this.isChannelSelected);
        sbU.append(", isMyHandRaised=");
        sbU.append(this.isMyHandRaised);
        sbU.append(", guildScheduledEvents=");
        sbU.append(this.guildScheduledEvents);
        sbU.append(", embeddedActivitiesForChannel=");
        sbU.append(this.embeddedActivitiesForChannel);
        sbU.append(", applications=");
        sbU.append(this.applications);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", numUsersConnected=");
        sbU.append(this.numUsersConnected);
        sbU.append(", channelPermissions=");
        sbU.append(this.channelPermissions);
        sbU.append(", audioManagerState=");
        sbU.append(this.audioManagerState);
        sbU.append(")");
        return sbU.toString();
    }
}
