package com.discord.widgets.voice.model;

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
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.voice.VoiceChannelJoinability;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.functions.Func8;

/* JADX INFO: compiled from: CallModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CallModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreApplicationStreaming.ActiveApplicationStream activeStream;
    private final Map<Long, Application> applications;
    private final StoreAudioManagerV2.State audioManagerState;
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
    private final Map<Long, StoreVoiceParticipants.VoiceUser> participants;
    private final RtcConnection.Metadata rtcConnectionMetadata;
    private final VideoInputDeviceDescription selectedVideoDevice;
    private final int streamFeedbackTriggerRateDenominator;
    private final long timeConnectedMs;
    private final List<VideoInputDeviceDescription> videoDevices;
    private final VoiceChannelJoinability voiceChannelJoinability;
    private final StoreMediaSettings.VoiceConfiguration voiceSettings;

    /* JADX INFO: compiled from: CallModel.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: CallModel.kt */
        public static final /* data */ class Chunk {
            private final StoreAudioManagerV2.State audioManagerState;
            private final Channel channel;
            private final Long channelPermissions;
            private final long myUserId;
            private final VideoInputDeviceDescription selectedVideoDevice;
            private final long timeConnectedMs;
            private final List<VideoInputDeviceDescription> videoDevices;
            private final StoreMediaSettings.VoiceConfiguration voiceConfig;
            private final Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants;

            public Chunk(Channel channel, long j, long j2, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map<Long, StoreVoiceParticipants.VoiceUser> map, Long l, List<VideoInputDeviceDescription> list, VideoInputDeviceDescription videoInputDeviceDescription, StoreAudioManagerV2.State state) {
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(voiceConfiguration, "voiceConfig");
                C12238m.checkNotNullParameter(map, "voiceParticipants");
                C12238m.checkNotNullParameter(list, "videoDevices");
                C12238m.checkNotNullParameter(state, "audioManagerState");
                this.channel = channel;
                this.myUserId = j;
                this.timeConnectedMs = j2;
                this.voiceConfig = voiceConfiguration;
                this.voiceParticipants = map;
                this.channelPermissions = l;
                this.videoDevices = list;
                this.selectedVideoDevice = videoInputDeviceDescription;
                this.audioManagerState = state;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getMyUserId() {
                return this.myUserId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final long getTimeConnectedMs() {
                return this.timeConnectedMs;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final StoreMediaSettings.VoiceConfiguration getVoiceConfig() {
                return this.voiceConfig;
            }

            public final Map<Long, StoreVoiceParticipants.VoiceUser> component5() {
                return this.voiceParticipants;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final Long getChannelPermissions() {
                return this.channelPermissions;
            }

            public final List<VideoInputDeviceDescription> component7() {
                return this.videoDevices;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final VideoInputDeviceDescription getSelectedVideoDevice() {
                return this.selectedVideoDevice;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final StoreAudioManagerV2.State getAudioManagerState() {
                return this.audioManagerState;
            }

            public final Chunk copy(Channel channel, long myUserId, long timeConnectedMs, StoreMediaSettings.VoiceConfiguration voiceConfig, Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants, Long channelPermissions, List<VideoInputDeviceDescription> videoDevices, VideoInputDeviceDescription selectedVideoDevice, StoreAudioManagerV2.State audioManagerState) {
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(voiceConfig, "voiceConfig");
                C12238m.checkNotNullParameter(voiceParticipants, "voiceParticipants");
                C12238m.checkNotNullParameter(videoDevices, "videoDevices");
                C12238m.checkNotNullParameter(audioManagerState, "audioManagerState");
                return new Chunk(channel, myUserId, timeConnectedMs, voiceConfig, voiceParticipants, channelPermissions, videoDevices, selectedVideoDevice, audioManagerState);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Chunk)) {
                    return false;
                }
                Chunk chunk = (Chunk) other;
                return C12238m.areEqual(this.channel, chunk.channel) && this.myUserId == chunk.myUserId && this.timeConnectedMs == chunk.timeConnectedMs && C12238m.areEqual(this.voiceConfig, chunk.voiceConfig) && C12238m.areEqual(this.voiceParticipants, chunk.voiceParticipants) && C12238m.areEqual(this.channelPermissions, chunk.channelPermissions) && C12238m.areEqual(this.videoDevices, chunk.videoDevices) && C12238m.areEqual(this.selectedVideoDevice, chunk.selectedVideoDevice) && C12238m.areEqual(this.audioManagerState, chunk.audioManagerState);
            }

            public final StoreAudioManagerV2.State getAudioManagerState() {
                return this.audioManagerState;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final Long getChannelPermissions() {
                return this.channelPermissions;
            }

            public final long getMyUserId() {
                return this.myUserId;
            }

            public final VideoInputDeviceDescription getSelectedVideoDevice() {
                return this.selectedVideoDevice;
            }

            public final long getTimeConnectedMs() {
                return this.timeConnectedMs;
            }

            public final List<VideoInputDeviceDescription> getVideoDevices() {
                return this.videoDevices;
            }

            public final StoreMediaSettings.VoiceConfiguration getVoiceConfig() {
                return this.voiceConfig;
            }

            public final Map<Long, StoreVoiceParticipants.VoiceUser> getVoiceParticipants() {
                return this.voiceParticipants;
            }

            public int hashCode() {
                Channel channel = this.channel;
                int iM3a = (C0002b.m3a(this.timeConnectedMs) + ((C0002b.m3a(this.myUserId) + ((channel != null ? channel.hashCode() : 0) * 31)) * 31)) * 31;
                StoreMediaSettings.VoiceConfiguration voiceConfiguration = this.voiceConfig;
                int iHashCode = (iM3a + (voiceConfiguration != null ? voiceConfiguration.hashCode() : 0)) * 31;
                Map<Long, StoreVoiceParticipants.VoiceUser> map = this.voiceParticipants;
                int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
                Long l = this.channelPermissions;
                int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
                List<VideoInputDeviceDescription> list = this.videoDevices;
                int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
                VideoInputDeviceDescription videoInputDeviceDescription = this.selectedVideoDevice;
                int iHashCode5 = (iHashCode4 + (videoInputDeviceDescription != null ? videoInputDeviceDescription.hashCode() : 0)) * 31;
                StoreAudioManagerV2.State state = this.audioManagerState;
                return iHashCode5 + (state != null ? state.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Chunk(channel=");
                sbM833U.append(this.channel);
                sbM833U.append(", myUserId=");
                sbM833U.append(this.myUserId);
                sbM833U.append(", timeConnectedMs=");
                sbM833U.append(this.timeConnectedMs);
                sbM833U.append(", voiceConfig=");
                sbM833U.append(this.voiceConfig);
                sbM833U.append(", voiceParticipants=");
                sbM833U.append(this.voiceParticipants);
                sbM833U.append(", channelPermissions=");
                sbM833U.append(this.channelPermissions);
                sbM833U.append(", videoDevices=");
                sbM833U.append(this.videoDevices);
                sbM833U.append(", selectedVideoDevice=");
                sbM833U.append(this.selectedVideoDevice);
                sbM833U.append(", audioManagerState=");
                sbM833U.append(this.audioManagerState);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private Companion() {
        }

        private final CallModel create(Channel channel, Guild guild, long myUserId, long timeConnectedMs, StoreMediaSettings.VoiceConfiguration voiceConfig, Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants, Long channelPermissions, List<VideoInputDeviceDescription> videoDevices, boolean isChannelSelected, VideoInputDeviceDescription selectedVideoDevice, StoreApplicationStreaming.ActiveApplicationStream activeStream, RtcConnection.Metadata rtcConnectionMetadata, int callFeedbackTriggerRateDenominator, int streamFeedbackTriggerRateDenominator, StoreAudioManagerV2.State audioManagerState, VoiceChannelJoinability voiceChannelJoinability, List<GuildScheduledEvent> guildScheduledEvents, Map<Long, EmbeddedActivity> embeddedActivitiesForChannel, Map<Long, Application> applications) {
            int i;
            GuildMaxVideoChannelUsers maxVideoChannelUsers;
            if (voiceParticipants.isEmpty()) {
                i = 0;
            } else {
                Iterator<Map.Entry<Long, StoreVoiceParticipants.VoiceUser>> it = voiceParticipants.entrySet().iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (it.next().getValue().isConnected()) {
                        i2++;
                    }
                }
                i = i2;
            }
            StoreVoiceParticipants.VoiceUser voiceUser = voiceParticipants.get(Long.valueOf(myUserId));
            boolean z2 = voiceUser != null && voiceUser.getIsRequestingToSpeak();
            if (guild == null || (maxVideoChannelUsers = guild.getMaxVideoChannelUsers()) == null) {
                maxVideoChannelUsers = GuildMaxVideoChannelUsers.Unlimited.INSTANCE;
            }
            return new CallModel(voiceParticipants, myUserId, timeConnectedMs, videoDevices, selectedVideoDevice, voiceConfig, rtcConnectionMetadata, callFeedbackTriggerRateDenominator, streamFeedbackTriggerRateDenominator, activeStream, voiceChannelJoinability, maxVideoChannelUsers, guild, isChannelSelected, z2, guildScheduledEvents, embeddedActivitiesForChannel, applications, channel, i, channelPermissions, audioManagerState);
        }

        private final Observable<Chunk> observeChunk(final Channel channel) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Chunk> observableM11067d = Observable.m11067d(companion.getUsers().observeMeId(), companion.getVoiceChannelSelected().observeTimeSelectedMs(), companion.getMediaSettings().getVoiceConfiguration(), ObservableExtensionsKt.leadingEdgeThrottle(companion.getVoiceParticipants().get(channel.getId()), 250L, TimeUnit.MILLISECONDS), companion.getPermissions().observePermissionsForChannel(channel.getId()), companion.getMediaEngine().getVideoInputDevices(), companion.getMediaEngine().getSelectedVideoInputDevice(), companion.getAudioManagerV2().observeAudioManagerState(), new Func8<Long, Long, StoreMediaSettings.VoiceConfiguration, Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, Long, List<? extends VideoInputDeviceDescription>, VideoInputDeviceDescription, StoreAudioManagerV2.State, Chunk>() { // from class: com.discord.widgets.voice.model.CallModel$Companion$observeChunk$1
                @Override // p658rx.functions.Func8
                public /* bridge */ /* synthetic */ CallModel.Companion.Chunk call(Long l, Long l2, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map, Long l3, List<? extends VideoInputDeviceDescription> list, VideoInputDeviceDescription videoInputDeviceDescription, StoreAudioManagerV2.State state) {
                    return call2(l, l2, voiceConfiguration, (Map<Long, StoreVoiceParticipants.VoiceUser>) map, l3, (List<VideoInputDeviceDescription>) list, videoInputDeviceDescription, state);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final CallModel.Companion.Chunk call2(Long l, Long l2, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map<Long, StoreVoiceParticipants.VoiceUser> map, Long l3, List<VideoInputDeviceDescription> list, VideoInputDeviceDescription videoInputDeviceDescription, StoreAudioManagerV2.State state) {
                    Channel channel2 = channel;
                    C12238m.checkNotNullExpressionValue(l, "myUserId");
                    long jLongValue = l.longValue();
                    C12238m.checkNotNullExpressionValue(l2, "timeConnectedMs");
                    long jLongValue2 = l2.longValue();
                    C12238m.checkNotNullExpressionValue(voiceConfiguration, "voiceConfig");
                    C12238m.checkNotNullExpressionValue(map, "voiceParticipants");
                    C12238m.checkNotNullExpressionValue(list, "videoDevices");
                    C12238m.checkNotNullExpressionValue(state, "audioManagerState");
                    return new CallModel.Companion.Chunk(channel2, jLongValue, jLongValue2, voiceConfiguration, map, l3, list, videoInputDeviceDescription, state);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11067d, "Observable\n          .co…            )\n          }");
            return observableM11067d;
        }

        public final Observable<CallModel> get(long channelId) {
            Observable observableM11099Y = StoreStream.INSTANCE.getChannels().observeChannel(channelId).m11099Y(new CallModel$Companion$get$1(channelId));
            C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n          .g…            }\n          }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CallModel(Map<Long, StoreVoiceParticipants.VoiceUser> map, long j, long j2, List<VideoInputDeviceDescription> list, VideoInputDeviceDescription videoInputDeviceDescription, StoreMediaSettings.VoiceConfiguration voiceConfiguration, RtcConnection.Metadata metadata, int i, int i2, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, VoiceChannelJoinability voiceChannelJoinability, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, Guild guild, boolean z2, boolean z3, List<GuildScheduledEvent> list2, Map<Long, EmbeddedActivity> map2, Map<Long, Application> map3, Channel channel, int i3, Long l, StoreAudioManagerV2.State state) {
        boolean z4;
        C12238m.checkNotNullParameter(map, "participants");
        C12238m.checkNotNullParameter(list, "videoDevices");
        C12238m.checkNotNullParameter(voiceConfiguration, "voiceSettings");
        C12238m.checkNotNullParameter(voiceChannelJoinability, "voiceChannelJoinability");
        C12238m.checkNotNullParameter(guildMaxVideoChannelUsers, "guildMaxVideoChannelMembers");
        C12238m.checkNotNullParameter(list2, "guildScheduledEvents");
        C12238m.checkNotNullParameter(map2, "embeddedActivitiesForChannel");
        C12238m.checkNotNullParameter(map3, "applications");
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(state, "audioManagerState");
        this.participants = map;
        this.myId = j;
        this.timeConnectedMs = j2;
        this.videoDevices = list;
        this.selectedVideoDevice = videoInputDeviceDescription;
        this.voiceSettings = voiceConfiguration;
        this.rtcConnectionMetadata = metadata;
        this.callFeedbackTriggerRateDenominator = i;
        this.streamFeedbackTriggerRateDenominator = i2;
        this.activeStream = activeApplicationStream;
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
        this.audioManagerState = state;
        this.cameraState = videoInputDeviceDescription != null ? CameraState.CAMERA_ON : CameraState.CAMERA_OFF;
        boolean z5 = true;
        if (!isStreaming()) {
            if (!map.isEmpty()) {
                Iterator<Map.Entry<Long, StoreVoiceParticipants.VoiceUser>> it = map.entrySet().iterator();
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
    private final StoreAudioManagerV2.State getAudioManagerState() {
        return this.audioManagerState;
    }

    public final boolean canInvite() {
        boolean zM7667B = ChannelUtils.m7667B(this.channel);
        boolean z2 = ChannelUtils.m7699w(this.channel) && PermissionUtils.can(1L, this.channelPermissions);
        StageInstance stageInstanceForChannel = StoreStream.INSTANCE.getStageInstances().getStageInstanceForChannel(this.channel.getId());
        return zM7667B || z2 || ((stageInstanceForChannel != null ? stageInstanceForChannel.getInviteCode() : null) != null);
    }

    public final boolean canManageEvent() {
        return GuildScheduledEventUtilities.INSTANCE.canStartEventInChannel(this.channel, this.channelPermissions);
    }

    public final boolean canRequestToSpeak() {
        return ChannelUtils.m7669D(this.channel) && PermissionUtils.can(Permission.REQUEST_TO_SPEAK, this.channelPermissions);
    }

    public final Map<Long, StoreVoiceParticipants.VoiceUser> component1() {
        return this.participants;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final StoreApplicationStreaming.ActiveApplicationStream getActiveStream() {
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
    public final StoreMediaSettings.VoiceConfiguration getVoiceSettings() {
        return this.voiceSettings;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final RtcConnection.Metadata getRtcConnectionMetadata() {
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

    public final CallModel copy(Map<Long, StoreVoiceParticipants.VoiceUser> participants, long myId, long timeConnectedMs, List<VideoInputDeviceDescription> videoDevices, VideoInputDeviceDescription selectedVideoDevice, StoreMediaSettings.VoiceConfiguration voiceSettings, RtcConnection.Metadata rtcConnectionMetadata, int callFeedbackTriggerRateDenominator, int streamFeedbackTriggerRateDenominator, StoreApplicationStreaming.ActiveApplicationStream activeStream, VoiceChannelJoinability voiceChannelJoinability, GuildMaxVideoChannelUsers guildMaxVideoChannelMembers, Guild guild, boolean isChannelSelected, boolean isMyHandRaised, List<GuildScheduledEvent> guildScheduledEvents, Map<Long, EmbeddedActivity> embeddedActivitiesForChannel, Map<Long, Application> applications, Channel channel, int numUsersConnected, Long channelPermissions, StoreAudioManagerV2.State audioManagerState) {
        C12238m.checkNotNullParameter(participants, "participants");
        C12238m.checkNotNullParameter(videoDevices, "videoDevices");
        C12238m.checkNotNullParameter(voiceSettings, "voiceSettings");
        C12238m.checkNotNullParameter(voiceChannelJoinability, "voiceChannelJoinability");
        C12238m.checkNotNullParameter(guildMaxVideoChannelMembers, "guildMaxVideoChannelMembers");
        C12238m.checkNotNullParameter(guildScheduledEvents, "guildScheduledEvents");
        C12238m.checkNotNullParameter(embeddedActivitiesForChannel, "embeddedActivitiesForChannel");
        C12238m.checkNotNullParameter(applications, "applications");
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(audioManagerState, "audioManagerState");
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
        return C12238m.areEqual(this.participants, callModel.participants) && this.myId == callModel.myId && this.timeConnectedMs == callModel.timeConnectedMs && C12238m.areEqual(this.videoDevices, callModel.videoDevices) && C12238m.areEqual(this.selectedVideoDevice, callModel.selectedVideoDevice) && C12238m.areEqual(this.voiceSettings, callModel.voiceSettings) && C12238m.areEqual(this.rtcConnectionMetadata, callModel.rtcConnectionMetadata) && this.callFeedbackTriggerRateDenominator == callModel.callFeedbackTriggerRateDenominator && this.streamFeedbackTriggerRateDenominator == callModel.streamFeedbackTriggerRateDenominator && C12238m.areEqual(this.activeStream, callModel.activeStream) && C12238m.areEqual(this.voiceChannelJoinability, callModel.voiceChannelJoinability) && C12238m.areEqual(this.guildMaxVideoChannelMembers, callModel.guildMaxVideoChannelMembers) && C12238m.areEqual(this.guild, callModel.guild) && this.isChannelSelected == callModel.isChannelSelected && this.isMyHandRaised == callModel.isMyHandRaised && C12238m.areEqual(this.guildScheduledEvents, callModel.guildScheduledEvents) && C12238m.areEqual(this.embeddedActivitiesForChannel, callModel.embeddedActivitiesForChannel) && C12238m.areEqual(this.applications, callModel.applications) && C12238m.areEqual(this.channel, callModel.channel) && this.numUsersConnected == callModel.numUsersConnected && C12238m.areEqual(this.channelPermissions, callModel.channelPermissions) && C12238m.areEqual(this.audioManagerState, callModel.audioManagerState);
    }

    public final StoreApplicationStreaming.ActiveApplicationStream getActiveStream() {
        return this.activeStream;
    }

    public final Map<Long, Application> getApplications() {
        return this.applications;
    }

    public final StoreAudioManagerV2.State getAudioManagerState() {
        return this.audioManagerState;
    }

    public final long getCallDurationMs(Clock clock) {
        C12238m.checkNotNullParameter(clock, "clock");
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

    public final StoreVoiceParticipants.VoiceUser getDmRecipient() {
        Object obj = null;
        if (this.channel.getType() != 1) {
            return null;
        }
        for (Object obj2 : this.participants.values()) {
            if (((StoreVoiceParticipants.VoiceUser) obj2).getUser().getId() != this.myId) {
                obj = obj2;
                break;
            }
        }
        return (StoreVoiceParticipants.VoiceUser) obj;
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

    public final MediaEngineConnection.InputMode getInputMode() {
        return this.voiceSettings.getInputMode();
    }

    public final long getMyId() {
        return this.myId;
    }

    public final int getNumUsersConnected() {
        return this.numUsersConnected;
    }

    public final Map<Long, StoreVoiceParticipants.VoiceUser> getParticipants() {
        return this.participants;
    }

    public final RtcConnection.Metadata getRtcConnectionMetadata() {
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

    public final StoreMediaSettings.VoiceConfiguration getVoiceSettings() {
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
        Map<Long, StoreVoiceParticipants.VoiceUser> map = this.participants;
        int iM3a = (C0002b.m3a(this.timeConnectedMs) + ((C0002b.m3a(this.myId) + ((map != null ? map.hashCode() : 0) * 31)) * 31)) * 31;
        List<VideoInputDeviceDescription> list = this.videoDevices;
        int iHashCode = (iM3a + (list != null ? list.hashCode() : 0)) * 31;
        VideoInputDeviceDescription videoInputDeviceDescription = this.selectedVideoDevice;
        int iHashCode2 = (iHashCode + (videoInputDeviceDescription != null ? videoInputDeviceDescription.hashCode() : 0)) * 31;
        StoreMediaSettings.VoiceConfiguration voiceConfiguration = this.voiceSettings;
        int iHashCode3 = (iHashCode2 + (voiceConfiguration != null ? voiceConfiguration.hashCode() : 0)) * 31;
        RtcConnection.Metadata metadata = this.rtcConnectionMetadata;
        int iHashCode4 = (((((iHashCode3 + (metadata != null ? metadata.hashCode() : 0)) * 31) + this.callFeedbackTriggerRateDenominator) * 31) + this.streamFeedbackTriggerRateDenominator) * 31;
        StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream = this.activeStream;
        int iHashCode5 = (iHashCode4 + (activeApplicationStream != null ? activeApplicationStream.hashCode() : 0)) * 31;
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
        StoreAudioManagerV2.State state = this.audioManagerState;
        return iHashCode13 + (state != null ? state.hashCode() : 0);
    }

    public final boolean isChannelSelected() {
        return this.isChannelSelected;
    }

    public final boolean isConnected() {
        StoreVoiceParticipants.VoiceUser voiceUser = this.participants.get(Long.valueOf(this.myId));
        if (voiceUser != null) {
            return voiceUser.isConnected();
        }
        return false;
    }

    public final boolean isDeafenedByAnySource() {
        return isSelfDeafened() || isServerDeafened();
    }

    public final boolean isMeMutedByAnySource() {
        VoiceState voiceState;
        StoreVoiceParticipants.VoiceUser voiceUser = this.participants.get(Long.valueOf(this.myId));
        if (voiceUser == null || (voiceState = voiceUser.getVoiceState()) == null) {
            return false;
        }
        return C1460d.m481V0(voiceState);
    }

    public final boolean isMuted() {
        VoiceState voiceState;
        StoreVoiceParticipants.VoiceUser voiceUser = this.participants.get(Long.valueOf(this.myId));
        if (voiceUser == null || (voiceState = voiceUser.getVoiceState()) == null) {
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
        StoreVoiceParticipants.VoiceUser voiceUser = this.participants.get(Long.valueOf(this.myId));
        if (voiceUser == null || (voiceState = voiceUser.getVoiceState()) == null) {
            return false;
        }
        return voiceState.getDeaf();
    }

    public final boolean isStreaming() {
        ModelApplicationStream stream;
        long j = this.myId;
        StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream = this.activeStream;
        return (activeApplicationStream == null || (stream = activeApplicationStream.getStream()) == null || j != stream.getOwnerId()) ? false : true;
    }

    public final boolean isSuppressed() {
        VoiceState voiceState;
        StoreVoiceParticipants.VoiceUser voiceUser = this.participants.get(Long.valueOf(this.myId));
        if (voiceUser == null || (voiceState = voiceUser.getVoiceState()) == null) {
            return false;
        }
        return voiceState.getSuppress();
    }

    /* JADX INFO: renamed from: isVideoCall, reason: from getter */
    public final boolean getIsVideoCall() {
        return this.isVideoCall;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("CallModel(participants=");
        sbM833U.append(this.participants);
        sbM833U.append(", myId=");
        sbM833U.append(this.myId);
        sbM833U.append(", timeConnectedMs=");
        sbM833U.append(this.timeConnectedMs);
        sbM833U.append(", videoDevices=");
        sbM833U.append(this.videoDevices);
        sbM833U.append(", selectedVideoDevice=");
        sbM833U.append(this.selectedVideoDevice);
        sbM833U.append(", voiceSettings=");
        sbM833U.append(this.voiceSettings);
        sbM833U.append(", rtcConnectionMetadata=");
        sbM833U.append(this.rtcConnectionMetadata);
        sbM833U.append(", callFeedbackTriggerRateDenominator=");
        sbM833U.append(this.callFeedbackTriggerRateDenominator);
        sbM833U.append(", streamFeedbackTriggerRateDenominator=");
        sbM833U.append(this.streamFeedbackTriggerRateDenominator);
        sbM833U.append(", activeStream=");
        sbM833U.append(this.activeStream);
        sbM833U.append(", voiceChannelJoinability=");
        sbM833U.append(this.voiceChannelJoinability);
        sbM833U.append(", guildMaxVideoChannelMembers=");
        sbM833U.append(this.guildMaxVideoChannelMembers);
        sbM833U.append(", guild=");
        sbM833U.append(this.guild);
        sbM833U.append(", isChannelSelected=");
        sbM833U.append(this.isChannelSelected);
        sbM833U.append(", isMyHandRaised=");
        sbM833U.append(this.isMyHandRaised);
        sbM833U.append(", guildScheduledEvents=");
        sbM833U.append(this.guildScheduledEvents);
        sbM833U.append(", embeddedActivitiesForChannel=");
        sbM833U.append(this.embeddedActivitiesForChannel);
        sbM833U.append(", applications=");
        sbM833U.append(this.applications);
        sbM833U.append(", channel=");
        sbM833U.append(this.channel);
        sbM833U.append(", numUsersConnected=");
        sbM833U.append(this.numUsersConnected);
        sbM833U.append(", channelPermissions=");
        sbM833U.append(this.channelPermissions);
        sbM833U.append(", audioManagerState=");
        sbM833U.append(this.audioManagerState);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
