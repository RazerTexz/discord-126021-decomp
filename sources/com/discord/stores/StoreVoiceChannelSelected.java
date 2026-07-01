package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guild.GuildMaxVideoChannelUsers$Unlimited;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelPayload;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.rtcconnection.RtcConnection$State;
import com.discord.rtcconnection.RtcConnection$State$f;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.guildmember.GuildMemberUtilsKt;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSoundManager$Provider;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.voice.VoiceChannelJoinability;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils;
import d0.t.h0;
import d0.z.d.m;
import java.util.Collection;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StoreVoiceChannelSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceChannelSelected extends StoreV2 implements DispatchHandler {
    public static final StoreVoiceChannelSelected$Companion Companion = new StoreVoiceChannelSelected$Companion(null);
    public static final long VOICE_CHANNEL_ID_NONE = 0;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private long lastSelectedVoiceChannelId;
    private final ObservationDeck observationDeck;
    private Long preselectedVoiceChannelId;
    private long selectedVoiceChannelId;
    private String sessionId;
    private final StoreStream stream;
    private long timeSelectedMs;

    public /* synthetic */ StoreVoiceChannelSelected(StoreStream storeStream, Dispatcher dispatcher, Clock clock, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, clock, (i & 8) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ void access$clearInternal(StoreVoiceChannelSelected storeVoiceChannelSelected) {
        storeVoiceChannelSelected.clearInternal();
    }

    public static final /* synthetic */ long access$getSelectedVoiceChannelId$p(StoreVoiceChannelSelected storeVoiceChannelSelected) {
        return storeVoiceChannelSelected.selectedVoiceChannelId;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreVoiceChannelSelected storeVoiceChannelSelected) {
        return storeVoiceChannelSelected.stream;
    }

    public static final /* synthetic */ long access$getTimeSelectedMs$p(StoreVoiceChannelSelected storeVoiceChannelSelected) {
        return storeVoiceChannelSelected.timeSelectedMs;
    }

    public static final /* synthetic */ StoreVoiceChannelSelected$JoinVoiceChannelResult access$selectVoiceChannelInternal(StoreVoiceChannelSelected storeVoiceChannelSelected, long j, boolean z2) {
        return storeVoiceChannelSelected.selectVoiceChannelInternal(j, z2);
    }

    public static final /* synthetic */ void access$setSelectedVoiceChannelId$p(StoreVoiceChannelSelected storeVoiceChannelSelected, long j) {
        storeVoiceChannelSelected.selectedVoiceChannelId = j;
    }

    public static final /* synthetic */ void access$setTimeSelectedMs$p(StoreVoiceChannelSelected storeVoiceChannelSelected, long j) {
        storeVoiceChannelSelected.timeSelectedMs = j;
    }

    @StoreThread
    private final void clearInternal() {
        Channel channel = StoreStream.Companion.getChannels().getChannel(this.selectedVoiceChannelId);
        if (channel != null && ChannelUtils.K(channel)) {
            AppSoundManager$Provider.INSTANCE.get().play(AppSound.Companion.getSOUND_USER_LEFT());
        }
        selectVoiceChannelInternal(0L, false);
    }

    @StoreThread
    private final VoiceChannelJoinability getJoinability(long channelId) {
        GuildMaxVideoChannelUsers maxVideoChannelUsers;
        StoreChannels channels = this.stream.getChannels();
        StoreGuilds guilds = this.stream.getGuilds();
        StorePermissions permissions = this.stream.getPermissions();
        StoreVoiceStates voiceStates = this.stream.getVoiceStates();
        StoreStageInstances stageInstances = this.stream.getStageInstances();
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = channels.findChannelByIdInternal$app_productionGoogleRelease(channelId);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease == null) {
            return VoiceChannelJoinability.CHANNEL_DOES_NOT_EXIST;
        }
        StageInstance stageInstanceForChannelInternal = stageInstances.getStageInstanceForChannelInternal(channelId);
        Map mapEmptyMap = (Map) a.c(channelFindChannelByIdInternal$app_productionGoogleRelease, voiceStates.get());
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        Long l = permissions.getPermissionsByChannel().get(Long.valueOf(channelId));
        Guild guild = (Guild) a.c(channelFindChannelByIdInternal$app_productionGoogleRelease, guilds.getGuilds());
        GuildVerificationLevel verificationLevelTriggered = guild != null ? getVerificationLevelTriggered(guild) : GuildVerificationLevel.NONE;
        VoiceChannelJoinabilityUtils voiceChannelJoinabilityUtils = VoiceChannelJoinabilityUtils.INSTANCE;
        Collection<VoiceState> collectionValues = mapEmptyMap.values();
        if (guild == null || (maxVideoChannelUsers = guild.getMaxVideoChannelUsers()) == null) {
            maxVideoChannelUsers = GuildMaxVideoChannelUsers$Unlimited.INSTANCE;
        }
        return voiceChannelJoinabilityUtils.computeJoinability(channelFindChannelByIdInternal$app_productionGoogleRelease, collectionValues, l, maxVideoChannelUsers, verificationLevelTriggered, Long.valueOf(this.selectedVoiceChannelId), stageInstanceForChannelInternal);
    }

    @StoreThread
    private final GuildVerificationLevel getVerificationLevelTriggered(Guild guild) {
        StoreGuilds guilds = this.stream.getGuilds();
        StoreUser users = this.stream.getUsers();
        GuildVerificationLevel verificationLevel = guild.getVerificationLevel();
        Map map = (Map) a.e(guild, guilds.getMembers());
        MeUser meSnapshot = users.getMeSnapshot();
        GuildMember guildMember = map != null ? (GuildMember) map.get(Long.valueOf(meSnapshot.getId())) : null;
        boolean zIsOwner = guild.isOwner(meSnapshot.getId());
        boolean z2 = guildMember != null && (guildMember.getRoles().isEmpty() ^ true);
        UserUtils userUtils = UserUtils.INSTANCE;
        boolean hasPhone = userUtils.getHasPhone(meSnapshot);
        Long l = (Long) a.e(guild, guilds.getGuildsJoinedAt());
        if (zIsOwner || z2 || hasPhone) {
            return GuildVerificationLevel.NONE;
        }
        int iOrdinal = verificationLevel.ordinal();
        if (iOrdinal == 0) {
            return GuildVerificationLevel.NONE;
        }
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    if (iOrdinal == 4) {
                        return GuildVerificationLevel.HIGH;
                    }
                } else if (l != null && !GuildMemberUtilsKt.isGuildMemberOldEnough(l.longValue())) {
                    return GuildVerificationLevel.HIGH;
                }
            } else if (!userUtils.isAccountOldEnough(meSnapshot, this.clock)) {
                return GuildVerificationLevel.MEDIUM;
            }
        } else if (!meSnapshot.isVerified()) {
            return GuildVerificationLevel.LOW;
        }
        return GuildVerificationLevel.NONE;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0038  */
    @StoreThread
    private final StoreVoiceChannelSelected$JoinVoiceChannelResult selectVoiceChannelInternal(long selectedVoiceChannelId, boolean forceMoved) {
        boolean z2;
        Channel channel;
        if (this.sessionId == null) {
            this.preselectedVoiceChannelId = Long.valueOf(selectedVoiceChannelId);
            return StoreVoiceChannelSelected$JoinVoiceChannelResult.DEFERRED_UNTIL_SESSION_START;
        }
        this.preselectedVoiceChannelId = null;
        if (selectedVoiceChannelId == this.selectedVoiceChannelId) {
            return StoreVoiceChannelSelected$JoinVoiceChannelResult.ALREADY_CONNECTED;
        }
        VoiceChannelJoinability joinability = getJoinability(selectedVoiceChannelId);
        int iOrdinal = joinability.ordinal();
        if (iOrdinal == 0) {
            z2 = true;
        } else if (iOrdinal == 1) {
            z2 = forceMoved;
        } else {
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    z2 = forceMoved;
                } else if (iOrdinal != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            z2 = false;
        }
        long j = this.selectedVoiceChannelId;
        if (z2) {
            if (!forceMoved && (channel = StoreStream.Companion.getChannels().getChannel(selectedVoiceChannelId)) != null && ChannelUtils.K(channel)) {
                AppSoundManager$Provider.INSTANCE.get().play(AppSound.Companion.getSOUND_USER_JOINED());
            }
            this.selectedVoiceChannelId = selectedVoiceChannelId;
            if (selectedVoiceChannelId > 0) {
                this.lastSelectedVoiceChannelId = selectedVoiceChannelId;
            }
        } else {
            this.selectedVoiceChannelId = 0L;
        }
        if (j != this.selectedVoiceChannelId) {
            markChanged();
        }
        if (z2) {
            return StoreVoiceChannelSelected$JoinVoiceChannelResult.SUCCESS;
        }
        int iOrdinal2 = joinability.ordinal();
        if (iOrdinal2 == 0) {
            return StoreVoiceChannelSelected$JoinVoiceChannelResult.SUCCESS;
        }
        if (iOrdinal2 == 1) {
            return StoreVoiceChannelSelected$JoinVoiceChannelResult.FAILED_PERMISSIONS_MISSING;
        }
        if (iOrdinal2 == 2) {
            return StoreVoiceChannelSelected$JoinVoiceChannelResult.FAILED_GUILD_VIDEO_AT_CAPACITY;
        }
        if (iOrdinal2 == 3) {
            return StoreVoiceChannelSelected$JoinVoiceChannelResult.FAILED_CHANNEL_FULL;
        }
        if (iOrdinal2 == 4) {
            return StoreVoiceChannelSelected$JoinVoiceChannelResult.FAILED_CHANNEL_DOES_NOT_EXIST;
        }
        throw new NoWhenBranchMatchedException();
    }

    @StoreThread
    private final void validateSelectedVoiceChannel() {
        long j = this.selectedVoiceChannelId;
        if (j == 0) {
            return;
        }
        if (this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.selectedVoiceChannelId) == null) {
            clearInternal();
        }
        if (this.selectedVoiceChannelId != j) {
            markChanged();
        }
    }

    public final void clear() {
        this.dispatcher.schedule(new StoreVoiceChannelSelected$clear$1(this));
    }

    public final long getLastSelectedVoiceChannelId() {
        return this.lastSelectedVoiceChannelId;
    }

    public final Channel getSelectedVoiceChannel() {
        return this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.selectedVoiceChannelId);
    }

    public final long getSelectedVoiceChannelId() {
        return this.selectedVoiceChannelId;
    }

    public final long getTimeSelectedMs() {
        return this.timeSelectedMs;
    }

    @StoreThread
    public final void handleAuthToken(String authToken) {
        if (authToken == null) {
            clearInternal();
        }
    }

    @StoreThread
    public final void handleChannelOrThreadCreateOrUpdate() {
        validateSelectedVoiceChannel();
    }

    @StoreThread
    public final void handleChannelOrThreadDelete() {
        validateSelectedVoiceChannel();
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
        Long l = this.preselectedVoiceChannelId;
        if (l != null) {
            selectVoiceChannelInternal(l.longValue(), false);
        }
    }

    @StoreThread
    public final void handleGuildMemberAdd(com.discord.api.guildmember.GuildMember member) {
        m.checkNotNullParameter(member, "member");
        if (member.getUser().getId() == this.stream.getUsers().getMe().getId()) {
            validateSelectedVoiceChannel();
        }
    }

    @StoreThread
    public final void handleGuildRemove() {
        validateSelectedVoiceChannel();
    }

    @StoreThread
    public final void handleGuildRoleCreateOrUpdate() {
        validateSelectedVoiceChannel();
    }

    @StoreThread
    public final void handleGuildRoleRemove() {
        validateSelectedVoiceChannel();
    }

    @StoreThread
    public final void handleRtcConnectionStateChanged(RtcConnection$State state) {
        m.checkNotNullParameter(state, "state");
        if (state instanceof RtcConnection$State$f) {
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.selectedVoiceChannelId);
            Guild guild = this.stream.getGuilds().getGuildsInternal$app_productionGoogleRelease().get(channelFindChannelByIdInternal$app_productionGoogleRelease != null ? Long.valueOf(channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId()) : null);
            if (guild != null) {
                Long afkChannelId = guild.getAfkChannelId();
                long j = this.selectedVoiceChannelId;
                if (afkChannelId == null || afkChannelId.longValue() != j || this.stream.getMediaEngine().getSelectedVideoInputDevice() == null) {
                    return;
                }
                this.stream.getMediaEngine().selectVideoInputDevice(null);
            }
        }
    }

    @StoreThread
    public final void handleStreamTargeted(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        selectVoiceChannelInternal(ModelApplicationStream.Companion.decodeStreamKey(streamKey).getChannelId(), false);
    }

    @StoreThread
    public final void handleVoiceStateUpdates(VoiceState voiceState) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease;
        m.checkNotNullParameter(voiceState, "voiceState");
        if (this.stream.getUsers().getMe().getId() == voiceState.getUserId() && (channelFindChannelByIdInternal$app_productionGoogleRelease = this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.selectedVoiceChannelId)) != null && channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId() == voiceState.getGuildId()) {
            Long channelId = voiceState.getChannelId();
            long j = this.selectedVoiceChannelId;
            if ((channelId != null && channelId.longValue() == j) || !m.areEqual(voiceState.getSessionId(), this.sessionId)) {
                if (!m.areEqual(voiceState.getSessionId(), this.sessionId)) {
                    clearInternal();
                }
            } else if (channelId == null) {
                clearInternal();
            } else {
                selectVoiceChannelInternal(channelId.longValue(), true);
                AppSoundManager$Provider.INSTANCE.get().play(AppSound.Companion.getSOUND_USER_MOVED());
            }
        }
    }

    public final Observable<Channel> observeSelectedChannel() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this, this.stream.getChannels()}, false, null, null, new StoreVoiceChannelSelected$observeSelectedChannel$1(this), 14, null);
    }

    public final Observable<Long> observeSelectedVoiceChannelId() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreVoiceChannelSelected$observeSelectedVoiceChannelId$1(this), 14, null);
    }

    public final Observable<Long> observeTimeSelectedMs() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreVoiceChannelSelected$observeTimeSelectedMs$1(this), 14, null);
    }

    public final Observable<StoreVoiceChannelSelected$JoinVoiceChannelResult> selectVoiceChannel(long channelId) {
        Channel channel = this.stream.getChannels().getChannel(channelId);
        if (channel != null && ChannelUtils.D(channel)) {
            StoreStream.Companion.getMediaEngine().setAudioInputEnabled(false);
        }
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        this.dispatcher.schedule(new StoreVoiceChannelSelected$selectVoiceChannel$1(this, channelId, publishSubjectK0));
        m.checkNotNullExpressionValue(publishSubjectK0, "resultSubject");
        return publishSubjectK0;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.timeSelectedMs = this.selectedVoiceChannelId > 0 ? this.clock.currentTimeMillis() : 0L;
    }

    public StoreVoiceChannelSelected(StoreStream storeStream, Dispatcher dispatcher, Clock clock, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.observationDeck = observationDeck;
    }
}
