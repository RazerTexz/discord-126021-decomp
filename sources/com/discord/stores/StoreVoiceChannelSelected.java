package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelPayload;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.guildmember.GuildMemberUtilsKt;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSoundManager;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.voice.VoiceChannelJoinability;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils;
import java.util.Collection;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StoreVoiceChannelSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceChannelSelected extends StoreV2 implements DispatchHandler {
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

    /* JADX INFO: compiled from: StoreVoiceChannelSelected.kt */
    public enum JoinVoiceChannelResult {
        SUCCESS,
        DEFERRED_UNTIL_SESSION_START,
        ALREADY_CONNECTED,
        FAILED_PERMISSIONS_MISSING,
        FAILED_GUILD_VIDEO_AT_CAPACITY,
        FAILED_CHANNEL_FULL,
        FAILED_CHANNEL_DOES_NOT_EXIST
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            VoiceChannelJoinability.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            VoiceChannelJoinability voiceChannelJoinability = VoiceChannelJoinability.CAN_JOIN;
            iArr[voiceChannelJoinability.ordinal()] = 1;
            VoiceChannelJoinability voiceChannelJoinability2 = VoiceChannelJoinability.PERMISSIONS_MISSING;
            iArr[voiceChannelJoinability2.ordinal()] = 2;
            VoiceChannelJoinability voiceChannelJoinability3 = VoiceChannelJoinability.CHANNEL_FULL;
            iArr[voiceChannelJoinability3.ordinal()] = 3;
            VoiceChannelJoinability voiceChannelJoinability4 = VoiceChannelJoinability.GUILD_VIDEO_AT_CAPACITY;
            iArr[voiceChannelJoinability4.ordinal()] = 4;
            VoiceChannelJoinability voiceChannelJoinability5 = VoiceChannelJoinability.CHANNEL_DOES_NOT_EXIST;
            iArr[voiceChannelJoinability5.ordinal()] = 5;
            VoiceChannelJoinability.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[voiceChannelJoinability2.ordinal()] = 1;
            iArr2[voiceChannelJoinability4.ordinal()] = 2;
            iArr2[voiceChannelJoinability3.ordinal()] = 3;
            iArr2[voiceChannelJoinability5.ordinal()] = 4;
            iArr2[voiceChannelJoinability.ordinal()] = 5;
            GuildVerificationLevel.values();
            int[] iArr3 = new int[5];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[GuildVerificationLevel.HIGHEST.ordinal()] = 1;
            iArr3[GuildVerificationLevel.HIGH.ordinal()] = 2;
            iArr3[GuildVerificationLevel.MEDIUM.ordinal()] = 3;
            iArr3[GuildVerificationLevel.LOW.ordinal()] = 4;
            iArr3[GuildVerificationLevel.NONE.ordinal()] = 5;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreVoiceChannelSelected$clear$1 */
    /* JADX INFO: compiled from: StoreVoiceChannelSelected.kt */
    public static final /* synthetic */ class C66181 extends C12236k implements Function0<Unit> {
        public C66181(StoreVoiceChannelSelected storeVoiceChannelSelected) {
            super(0, storeVoiceChannelSelected, StoreVoiceChannelSelected.class, "clearInternal", "clearInternal()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((StoreVoiceChannelSelected) this.receiver).clearInternal();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreVoiceChannelSelected$observeSelectedChannel$1 */
    /* JADX INFO: compiled from: StoreVoiceChannelSelected.kt */
    public static final class C66191 extends AbstractC12240o implements Function0<Channel> {
        public C66191() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Channel invoke() {
            return StoreVoiceChannelSelected.this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(StoreVoiceChannelSelected.this.selectedVoiceChannelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreVoiceChannelSelected$observeSelectedVoiceChannelId$1 */
    /* JADX INFO: compiled from: StoreVoiceChannelSelected.kt */
    public static final class C66201 extends AbstractC12240o implements Function0<Long> {
        public C66201() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return Long.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2() {
            return StoreVoiceChannelSelected.this.selectedVoiceChannelId;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreVoiceChannelSelected$observeTimeSelectedMs$1 */
    /* JADX INFO: compiled from: StoreVoiceChannelSelected.kt */
    public static final class C66211 extends AbstractC12240o implements Function0<Long> {
        public C66211() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return Long.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2() {
            return StoreVoiceChannelSelected.this.timeSelectedMs;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreVoiceChannelSelected$selectVoiceChannel$1 */
    /* JADX INFO: compiled from: StoreVoiceChannelSelected.kt */
    public static final class C66221 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ PublishSubject $resultSubject;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C66221(long j, PublishSubject publishSubject) {
            super(0);
            this.$channelId = j;
            this.$resultSubject = publishSubject;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$resultSubject.f27650k.onNext((T) StoreVoiceChannelSelected.this.selectVoiceChannelInternal(this.$channelId, false));
            this.$resultSubject.f27650k.onCompleted();
        }
    }

    public /* synthetic */ StoreVoiceChannelSelected(StoreStream storeStream, Dispatcher dispatcher, Clock clock, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, clock, (i & 8) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    @StoreThread
    private final void clearInternal() {
        Channel channel = StoreStream.INSTANCE.getChannels().getChannel(this.selectedVoiceChannelId);
        if (channel != null && ChannelUtils.m7676K(channel)) {
            AppSoundManager.Provider.INSTANCE.get().play(AppSound.INSTANCE.getSOUND_USER_LEFT());
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
        Map mapEmptyMap = (Map) C1643a.m843c(channelFindChannelByIdInternal$app_productionGoogleRelease, voiceStates.get());
        if (mapEmptyMap == null) {
            mapEmptyMap = C12136h0.emptyMap();
        }
        Long l = permissions.getPermissionsByChannel().get(Long.valueOf(channelId));
        Guild guild = (Guild) C1643a.m843c(channelFindChannelByIdInternal$app_productionGoogleRelease, guilds.getGuilds());
        GuildVerificationLevel verificationLevelTriggered = guild != null ? getVerificationLevelTriggered(guild) : GuildVerificationLevel.NONE;
        VoiceChannelJoinabilityUtils voiceChannelJoinabilityUtils = VoiceChannelJoinabilityUtils.INSTANCE;
        Collection<VoiceState> collectionValues = mapEmptyMap.values();
        if (guild == null || (maxVideoChannelUsers = guild.getMaxVideoChannelUsers()) == null) {
            maxVideoChannelUsers = GuildMaxVideoChannelUsers.Unlimited.INSTANCE;
        }
        return voiceChannelJoinabilityUtils.computeJoinability(channelFindChannelByIdInternal$app_productionGoogleRelease, collectionValues, l, maxVideoChannelUsers, verificationLevelTriggered, Long.valueOf(this.selectedVoiceChannelId), stageInstanceForChannelInternal);
    }

    @StoreThread
    private final GuildVerificationLevel getVerificationLevelTriggered(Guild guild) {
        StoreGuilds guilds = this.stream.getGuilds();
        StoreUser users = this.stream.getUsers();
        GuildVerificationLevel verificationLevel = guild.getVerificationLevel();
        Map map = (Map) C1643a.m847e(guild, guilds.getMembers());
        MeUser meSnapshot = users.getMeSnapshot();
        GuildMember guildMember = map != null ? (GuildMember) map.get(Long.valueOf(meSnapshot.getId())) : null;
        boolean zIsOwner = guild.isOwner(meSnapshot.getId());
        boolean z2 = guildMember != null && (guildMember.getRoles().isEmpty() ^ true);
        UserUtils userUtils = UserUtils.INSTANCE;
        boolean hasPhone = userUtils.getHasPhone(meSnapshot);
        Long l = (Long) C1643a.m847e(guild, guilds.getGuildsJoinedAt());
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
    private final JoinVoiceChannelResult selectVoiceChannelInternal(long selectedVoiceChannelId, boolean forceMoved) {
        boolean z2;
        Channel channel;
        if (this.sessionId == null) {
            this.preselectedVoiceChannelId = Long.valueOf(selectedVoiceChannelId);
            return JoinVoiceChannelResult.DEFERRED_UNTIL_SESSION_START;
        }
        this.preselectedVoiceChannelId = null;
        if (selectedVoiceChannelId == this.selectedVoiceChannelId) {
            return JoinVoiceChannelResult.ALREADY_CONNECTED;
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
            if (!forceMoved && (channel = StoreStream.INSTANCE.getChannels().getChannel(selectedVoiceChannelId)) != null && ChannelUtils.m7676K(channel)) {
                AppSoundManager.Provider.INSTANCE.get().play(AppSound.INSTANCE.getSOUND_USER_JOINED());
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
            return JoinVoiceChannelResult.SUCCESS;
        }
        int iOrdinal2 = joinability.ordinal();
        if (iOrdinal2 == 0) {
            return JoinVoiceChannelResult.SUCCESS;
        }
        if (iOrdinal2 == 1) {
            return JoinVoiceChannelResult.FAILED_PERMISSIONS_MISSING;
        }
        if (iOrdinal2 == 2) {
            return JoinVoiceChannelResult.FAILED_GUILD_VIDEO_AT_CAPACITY;
        }
        if (iOrdinal2 == 3) {
            return JoinVoiceChannelResult.FAILED_CHANNEL_FULL;
        }
        if (iOrdinal2 == 4) {
            return JoinVoiceChannelResult.FAILED_CHANNEL_DOES_NOT_EXIST;
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
        this.dispatcher.schedule(new C66181(this));
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
        C12238m.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
        Long l = this.preselectedVoiceChannelId;
        if (l != null) {
            selectVoiceChannelInternal(l.longValue(), false);
        }
    }

    @StoreThread
    public final void handleGuildMemberAdd(com.discord.api.guildmember.GuildMember member) {
        C12238m.checkNotNullParameter(member, "member");
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
    public final void handleRtcConnectionStateChanged(RtcConnection.State state) {
        C12238m.checkNotNullParameter(state, "state");
        if (state instanceof RtcConnection.State.C5612f) {
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
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        selectVoiceChannelInternal(ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey).getChannelId(), false);
    }

    @StoreThread
    public final void handleVoiceStateUpdates(VoiceState voiceState) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease;
        C12238m.checkNotNullParameter(voiceState, "voiceState");
        if (this.stream.getUsers().getMe().getId() == voiceState.getUserId() && (channelFindChannelByIdInternal$app_productionGoogleRelease = this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.selectedVoiceChannelId)) != null && channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId() == voiceState.getGuildId()) {
            Long channelId = voiceState.getChannelId();
            long j = this.selectedVoiceChannelId;
            if ((channelId != null && channelId.longValue() == j) || !C12238m.areEqual(voiceState.getSessionId(), this.sessionId)) {
                if (!C12238m.areEqual(voiceState.getSessionId(), this.sessionId)) {
                    clearInternal();
                }
            } else if (channelId == null) {
                clearInternal();
            } else {
                selectVoiceChannelInternal(channelId.longValue(), true);
                AppSoundManager.Provider.INSTANCE.get().play(AppSound.INSTANCE.getSOUND_USER_MOVED());
            }
        }
    }

    public final Observable<Channel> observeSelectedChannel() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, this.stream.getChannels()}, false, null, null, new C66191(), 14, null);
    }

    public final Observable<Long> observeSelectedVoiceChannelId() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C66201(), 14, null);
    }

    public final Observable<Long> observeTimeSelectedMs() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C66211(), 14, null);
    }

    public final Observable<JoinVoiceChannelResult> selectVoiceChannel(long channelId) {
        Channel channel = this.stream.getChannels().getChannel(channelId);
        if (channel != null && ChannelUtils.m7669D(channel)) {
            StoreStream.INSTANCE.getMediaEngine().setAudioInputEnabled(false);
        }
        PublishSubject publishSubjectM11133k0 = PublishSubject.m11133k0();
        this.dispatcher.schedule(new C66221(channelId, publishSubjectM11133k0));
        C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "resultSubject");
        return publishSubjectM11133k0;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.timeSelectedMs = this.selectedVoiceChannelId > 0 ? this.clock.currentTimeMillis() : 0L;
    }

    public StoreVoiceChannelSelected(StoreStream storeStream, Dispatcher dispatcher, Clock clock, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(storeStream, "stream");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(clock, "clock");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.observationDeck = observationDeck;
    }
}
