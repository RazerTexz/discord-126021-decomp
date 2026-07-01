package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.stage.StageChannelNotifications;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.model.StageChannel;
import d0.d0._Ranges;
import d0.f0._Sequences2;
import d0.f0.n;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t.MutableCollections;
import d0.t.Sets5;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;
import rx.Observable;

/* JADX INFO: compiled from: StoreStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageChannels extends StoreV2 {
    public static final long CAN_MODERATE_STAGE_CHANNELS = 20971536;
    private static final StoreStageChannels3 EventStateUpdateSource = new ObservationDeck.UpdateSource() { // from class: com.discord.stores.StoreStageChannels$Companion$EventStateUpdateSource$1
    };
    private final StoreChannels channelsStore;
    private final Set<Long> dirtyChannelIds;
    private final StoreGuilds guildsStore;
    private final ObservationDeck observationDeck;
    private final StorePermissions permissionsStore;
    private final Map<Long, Map<Long, StageEventActivationState>> stageEventStates;
    private final StoreStageInstances stageInstancesStore;
    private final Map<Long, Map<Long, StageRoles>> stageRolesByChannel;
    private Map<Long, ? extends Map<Long, StageRoles>> stageRolesByChannelSnapshot;
    private final StoreUser userStore;
    private final StoreVoiceStates voiceStatesStore;

    /* JADX INFO: compiled from: StoreStageChannels.kt */
    public static final /* data */ class StageEventActivationState {
        private final Set<Long> moderators;

        /* JADX WARN: Multi-variable type inference failed */
        public StageEventActivationState() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public StageEventActivationState(Set<Long> set) {
            Intrinsics3.checkNotNullParameter(set, "moderators");
            this.moderators = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StageEventActivationState copy$default(StageEventActivationState stageEventActivationState, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = stageEventActivationState.moderators;
            }
            return stageEventActivationState.copy(set);
        }

        public final Set<Long> component1() {
            return this.moderators;
        }

        public final StageEventActivationState copy(Set<Long> moderators) {
            Intrinsics3.checkNotNullParameter(moderators, "moderators");
            return new StageEventActivationState(moderators);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StageEventActivationState) && Intrinsics3.areEqual(this.moderators, ((StageEventActivationState) other).moderators);
            }
            return true;
        }

        public final Set<Long> getModerators() {
            return this.moderators;
        }

        public int hashCode() {
            Set<Long> set = this.moderators;
            if (set != null) {
                return set.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.N(outline.U("StageEventActivationState(moderators="), this.moderators, ")");
        }

        public /* synthetic */ StageEventActivationState(Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Sets5.emptySet() : set);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStageChannels$observeGuildStageChannels$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStageChannels.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends StageChannel>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends StageChannel> invoke() {
            StoreStageChannels storeStageChannels = StoreStageChannels.this;
            long j = this.$guildId;
            Map<Long, Channel> channelsForGuild = storeStageChannels.channelsStore.getChannelsForGuild(this.$guildId);
            long id2 = StoreStageChannels.this.userStore.getMeSnapshot().getId();
            Map<Long, User> users = StoreStageChannels.this.userStore.getUsers();
            Map<Long, VoiceState> mapEmptyMap = StoreStageChannels.this.voiceStatesStore.get().get(Long.valueOf(this.$guildId));
            if (mapEmptyMap == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            return storeStageChannels.getStageChannelsInGuild(j, channelsForGuild, id2, users, mapEmptyMap);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStageChannels$observeMyRequestToSpeakState$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStageChannels.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<StageRequestToSpeakState> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StageRequestToSpeakState invoke() {
            StageRequestToSpeakState requestToSpeakState;
            Channel channel = StoreStageChannels.this.channelsStore.getChannel(this.$channelId);
            if (channel == null) {
                return StageRequestToSpeakState.NONE;
            }
            StoreStageChannels2 storeStageChannels2RoleContext$default = StoreStageChannels.roleContext$default(StoreStageChannels.this, channel, null, null, null, 14, null);
            return (storeStageChannels2RoleContext$default == null || (requestToSpeakState = storeStageChannels2RoleContext$default.getRequestToSpeakState(StoreStageChannels.this.userStore.getMeSnapshot().getId())) == null) ? StageRequestToSpeakState.NONE : requestToSpeakState;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStageChannels$observeMyRoles$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStageChannels.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<StageRoles> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StageRoles invoke() {
            Channel channel = StoreStageChannels.this.channelsStore.getChannel(this.$channelId);
            if (channel != null) {
                return StoreStageChannels.this.m15getMyRolesvisDeB4(channel.getId());
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStageChannels$observeRoles$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStageChannels.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Map<Long, ? extends StageRoles>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Map<Long, ? extends StageRoles>> invoke() {
            return StoreStageChannels.this.stageRolesByChannelSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStageChannels$observeStageChannels$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStageChannels.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends StageChannel>> {

        /* JADX INFO: renamed from: com.discord.stores.StoreStageChannels$observeStageChannels$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreStageChannels.kt */
        public static final class C01731 extends Lambda implements Function1<Long, Map<Long, ? extends StageChannel>> {
            public C01731() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Map<Long, ? extends StageChannel> invoke(Long l) {
                return invoke(l.longValue());
            }

            public final Map<Long, StageChannel> invoke(long j) {
                return StoreStageChannels.getStageChannelsInGuild$default(StoreStageChannels.this, j, null, 0L, null, null, 30, null);
            }
        }

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends StageChannel> invoke() {
            Object obj;
            Iterator it = _Sequences2.map(_Collections.asSequence(StoreStageChannels.this.guildsStore.getGuilds().keySet()), new C01731()).iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    next = Maps6.plus((Map) next, (Map) it.next());
                }
                obj = next;
            } else {
                obj = null;
            }
            Map<Long, ? extends StageChannel> map = (Map) obj;
            return map != null ? map : Maps6.emptyMap();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStageChannels$observeStageRolesByChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStageChannels.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends StageRoles>> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends StageRoles> invoke() {
            return (Map) StoreStageChannels.this.stageRolesByChannelSnapshot.get(Long.valueOf(this.$channelId));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStageChannels$observeUserRequestToSpeakState$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStageChannels.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<StageRequestToSpeakState> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$channelId = j;
            this.$userId = j2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StageRequestToSpeakState invoke() {
            StageRequestToSpeakState requestToSpeakState;
            Channel channel = StoreStageChannels.this.channelsStore.getChannel(this.$channelId);
            if (channel == null) {
                return StageRequestToSpeakState.NONE;
            }
            StoreStageChannels2 storeStageChannels2RoleContext$default = StoreStageChannels.roleContext$default(StoreStageChannels.this, channel, null, null, null, 14, null);
            return (storeStageChannels2RoleContext$default == null || (requestToSpeakState = storeStageChannels2RoleContext$default.getRequestToSpeakState(this.$userId)) == null) ? StageRequestToSpeakState.NONE : requestToSpeakState;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStageChannels$observeUserRoles$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStageChannels.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<StageRoles> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$channelId = j;
            this.$userId = j2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StageRoles invoke() {
            Channel channel = StoreStageChannels.this.channelsStore.getChannel(this.$channelId);
            if (channel != null) {
                return StoreStageChannels.this.m17getUserRolesuOBN1zc(this.$userId, channel.getId());
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStageChannels$stageChannelIdsInGuildForDispatch$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStageChannels.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Long> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Long invoke(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Long lValueOf = Long.valueOf(channel.getId());
            lValueOf.longValue();
            if (ChannelUtils.D(channel)) {
                return lValueOf;
            }
            return null;
        }
    }

    public /* synthetic */ StoreStageChannels(StoreUser storeUser, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreVoiceStates storeVoiceStates, StorePermissions storePermissions, StoreStageInstances storeStageInstances, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeUser, storeGuilds, storeChannels, storeVoiceStates, storePermissions, storeStageInstances, (i & 64) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    /* JADX INFO: renamed from: computeUserRolesInDispatch-t27eFtU, reason: not valid java name */
    private final int m9computeUserRolesInDispatcht27eFtU(long userId, Channel channel, Map<Long, VoiceState> voiceStates, Map<Long, GuildRole> roles) {
        Guild guild = (Guild) outline.c(channel, this.guildsStore.getGuildsInternal$app_productionGoogleRelease());
        if (guild == null) {
            return StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo();
        }
        Map map = (Map) outline.c(channel, this.guildsStore.getGuildMembersComputedInternal$app_productionGoogleRelease());
        if (map == null) {
            return StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo();
        }
        GuildMember guildMember = (GuildMember) map.get(Long.valueOf(userId));
        if (guildMember == null) {
            return StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo();
        }
        if (roles == null) {
            roles = (Map) outline.c(channel, this.guildsStore.getGuildRolesInternal$app_productionGoogleRelease());
        }
        if (voiceStates == null) {
            voiceStates = (Map) outline.c(channel, this.voiceStatesStore.getInternal$app_productionGoogleRelease());
        }
        if (voiceStates == null) {
            return StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo();
        }
        StoreStageChannels2 storeStageChannels2RoleContext = roleContext(channel, guild, voiceStates, roles);
        return storeStageChannels2RoleContext != null ? storeStageChannels2RoleContext.m7getRoleK6mKVE(userId, guildMember) : StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: computeUserRolesInDispatch-t27eFtU$default, reason: not valid java name */
    public static /* synthetic */ int m10computeUserRolesInDispatcht27eFtU$default(StoreStageChannels storeStageChannels, long j, Channel channel, Map map, Map map2, int i, Object obj) {
        return storeStageChannels.m9computeUserRolesInDispatcht27eFtU(j, channel, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : map2);
    }

    private final Guild getGuild(Channel channel) {
        return (Guild) outline.c(channel, this.guildsStore.getGuilds());
    }

    public static /* synthetic */ int getOtherModeratorsCountInChannel$default(StoreStageChannels storeStageChannels, Channel channel, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = storeStageChannels.userStore.getMeSnapshot().getId();
        }
        return storeStageChannels.getOtherModeratorsCountInChannel(channel, j);
    }

    private final Map<Long, GuildRole> getRolesMap(Guild guild) {
        Map<Long, GuildRole> map = (Map) outline.e(guild, this.guildsStore.getRoles());
        return map != null ? map : Maps6.emptyMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Map getStageChannelsInGuild$default(StoreStageChannels storeStageChannels, long j, Map map, long j2, Map map2, Map map3, int i, Object obj) {
        Map map4;
        Map channelsForGuild = (i & 2) != 0 ? storeStageChannels.channelsStore.getChannelsForGuild(j) : map;
        long id2 = (i & 4) != 0 ? storeStageChannels.userStore.getMeSnapshot().getId() : j2;
        Map users = (i & 8) != 0 ? storeStageChannels.userStore.getUsers() : map2;
        if ((i & 16) != 0) {
            Map<Long, VoiceState> mapEmptyMap = storeStageChannels.voiceStatesStore.get().get(Long.valueOf(j));
            if (mapEmptyMap == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            map4 = mapEmptyMap;
        } else {
            map4 = map3;
        }
        return storeStageChannels.getStageChannelsInGuild(j, channelsForGuild, id2, users, map4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: handleUserJoinedStageOrGainedRole-oRmTEFA, reason: not valid java name */
    private final void m11handleUserJoinedStageOrGainedRoleoRmTEFA(Channel channel, long userId, int roles) {
        if (StageRoles.m32isModeratorimpl(roles) || StageRoles.m33isSpeakerimpl(roles)) {
            Map<Long, StageEventActivationState> linkedHashMap = (Map) outline.c(channel, this.stageEventStates);
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>();
                this.stageEventStates.put(Long.valueOf(channel.getGuildId()), linkedHashMap);
            }
            StageEventActivationState stageEventActivationState = (StageEventActivationState) outline.d(channel, linkedHashMap);
            int i = 1;
            if (stageEventActivationState == null) {
                stageEventActivationState = new StageEventActivationState(null, i, 0 == true ? 1 : 0);
                linkedHashMap.put(Long.valueOf(channel.getId()), stageEventActivationState);
            }
            i = (!StageRoles.m32isModeratorimpl(roles) || stageEventActivationState.getModerators().contains(Long.valueOf(userId))) ? 0 : 1;
            if (i != 0) {
                linkedHashMap.put(Long.valueOf(channel.getId()), stageEventActivationState.copy(i != 0 ? _Sets.plus(stageEventActivationState.getModerators(), Long.valueOf(userId)) : stageEventActivationState.getModerators()));
                markStageEventDirty();
            }
        }
    }

    /* JADX INFO: renamed from: handleUserLeftStageOrLostRoles-GM3QuyE, reason: not valid java name */
    private final void m12handleUserLeftStageOrLostRolesGM3QuyE(Channel channel, long userId, int oldRoles, int newRoles) {
        Map map;
        StageEventActivationState stageEventActivationState;
        if ((!StageRoles.m32isModeratorimpl(oldRoles) && !StageRoles.m33isSpeakerimpl(oldRoles)) || (map = (Map) outline.c(channel, this.stageEventStates)) == null || (stageEventActivationState = (StageEventActivationState) outline.d(channel, map)) == null) {
            return;
        }
        boolean z2 = !StageRoles.m32isModeratorimpl(newRoles) && StageRoles.m32isModeratorimpl(oldRoles) && stageEventActivationState.getModerators().contains(Long.valueOf(userId));
        if (z2) {
            map.put(Long.valueOf(channel.getId()), stageEventActivationState.copy(z2 ? _Sets.minus(stageEventActivationState.getModerators(), Long.valueOf(userId)) : stageEventActivationState.getModerators()));
            markStageEventDirty();
        }
    }

    /* JADX INFO: renamed from: handleUserLeftStageOrLostRoles-GM3QuyE$default, reason: not valid java name */
    public static /* synthetic */ void m13handleUserLeftStageOrLostRolesGM3QuyE$default(StoreStageChannels storeStageChannels, Channel channel, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo();
        }
        storeStageChannels.m12handleUserLeftStageOrLostRolesGM3QuyE(channel, j, i, i2);
    }

    /* JADX INFO: renamed from: handleUserRoleChange-uOJZ9lM, reason: not valid java name */
    private final void m14handleUserRoleChangeuOJZ9lM(Channel channel, long userId, StageRoles oldRole, int newRole) {
        if ((StageRoles.m32isModeratorimpl(newRole) && (oldRole == null || !StageRoles.m32isModeratorimpl(oldRole.m35unboximpl()))) || (StageRoles.m33isSpeakerimpl(newRole) && (oldRole == null || !StageRoles.m33isSpeakerimpl(oldRole.m35unboximpl())))) {
            m11handleUserJoinedStageOrGainedRoleoRmTEFA(channel, userId, newRole);
        }
        if ((oldRole != null && StageRoles.m32isModeratorimpl(oldRole.m35unboximpl()) && !StageRoles.m32isModeratorimpl(newRole)) || (oldRole != null && StageRoles.m33isSpeakerimpl(oldRole.m35unboximpl()) && !StageRoles.m33isSpeakerimpl(newRole))) {
            m12handleUserLeftStageOrLostRolesGM3QuyE(channel, userId, oldRole.m35unboximpl(), newRole);
        }
        if (userId == this.userStore.getMeSnapshot().getId()) {
            if (oldRole != null && !StageRoles.m31isInvitedToSpeakimpl(oldRole.m35unboximpl()) && StageRoles.m31isInvitedToSpeakimpl(newRole)) {
                StageChannelNotifications.INSTANCE.getINSTANCE().onInvitedToSpeak(channel.getId());
            } else {
                if (oldRole == null || !StageRoles.m31isInvitedToSpeakimpl(oldRole.m35unboximpl()) || StageRoles.m31isInvitedToSpeakimpl(newRole)) {
                    return;
                }
                StageChannelNotifications.INSTANCE.getINSTANCE().onInviteToSpeakRescinded();
            }
        }
    }

    private final void markStageEventDirty() {
        markChanged(EventStateUpdateSource);
    }

    private final StoreStageChannels2 roleContext(Channel channel, Guild guild, Map<Long, VoiceState> voiceStates, Map<Long, GuildRole> roles) {
        if (guild == null) {
            guild = getGuild(channel);
        }
        if (guild == null) {
            return null;
        }
        if (voiceStates == null) {
            voiceStates = this.voiceStatesStore.getForChannel(guild.getId(), channel.getId());
        }
        if (roles == null) {
            roles = getRolesMap(guild);
        }
        return new StoreStageChannels2(guild, channel, roles, voiceStates);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreStageChannels2 roleContext$default(StoreStageChannels storeStageChannels, Channel channel, Guild guild, Map map, Map map2, int i, Object obj) {
        if ((i & 2) != 0) {
            guild = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        if ((i & 8) != 0) {
            map2 = null;
        }
        return storeStageChannels.roleContext(channel, guild, map, map2);
    }

    private final Sequence<Long> stageChannelIdsInGuildForDispatch(long guildId) {
        Collection<Channel> collectionValues;
        Sequence sequenceAsSequence;
        Sequence<Long> sequenceMapNotNull;
        Map<Long, Channel> channelsForGuildInternal$app_productionGoogleRelease = this.channelsStore.getChannelsForGuildInternal$app_productionGoogleRelease(guildId);
        return (channelsForGuildInternal$app_productionGoogleRelease == null || (collectionValues = channelsForGuildInternal$app_productionGoogleRelease.values()) == null || (sequenceAsSequence = _Collections.asSequence(collectionValues)) == null || (sequenceMapNotNull = _Sequences2.mapNotNull(sequenceAsSequence, AnonymousClass1.INSTANCE)) == null) ? n.emptySequence() : sequenceMapNotNull;
    }

    public final Map<Long, StageRoles> getChannelRoles(long channelId) {
        return this.stageRolesByChannelSnapshot.get(Long.valueOf(channelId));
    }

    public final Map<Long, StageRoles> getChannelRolesInternal(long channelId) {
        return this.stageRolesByChannel.get(Long.valueOf(channelId));
    }

    /* JADX INFO: renamed from: getMyRoles-visDeB4, reason: not valid java name */
    public final StageRoles m15getMyRolesvisDeB4(long channelId) {
        return m17getUserRolesuOBN1zc(this.userStore.getMeSnapshot().getId(), channelId);
    }

    /* JADX INFO: renamed from: getMyRolesInternal-visDeB4, reason: not valid java name */
    public final StageRoles m16getMyRolesInternalvisDeB4(long channelId) {
        return m18getUserRolesInternaluOBN1zc(this.userStore.getMeSnapshot().getId(), channelId);
    }

    public final int getOtherModeratorsCountInChannel(Channel channel, long myId) {
        StageEventActivationState stageEventActivationState;
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Map map = (Map) outline.c(channel, this.stageEventStates);
        if (map == null || (stageEventActivationState = (StageEventActivationState) outline.d(channel, map)) == null) {
            return 0;
        }
        int size = stageEventActivationState.getModerators().size();
        return stageEventActivationState.getModerators().contains(Long.valueOf(myId)) ? size - 1 : size;
    }

    public final Map<Long, StageChannel> getStageChannelsInGuild(long guildId, Map<Long, Channel> channelsInGuild, long myId, Map<Long, ? extends User> users, Map<Long, VoiceState> voiceStates) {
        Map<Long, ? extends User> map = users;
        Intrinsics3.checkNotNullParameter(channelsInGuild, "channelsInGuild");
        Intrinsics3.checkNotNullParameter(map, "users");
        Intrinsics3.checkNotNullParameter(voiceStates, "voiceStates");
        Collection<Channel> collectionValues = channelsInGuild.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (ChannelUtils.D((Channel) obj)) {
                arrayList.add(obj);
            }
        }
        int i = 10;
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Channel channel = (Channel) it.next();
            Map mapEmptyMap = (Map) outline.d(channel, this.stageRolesByChannelSnapshot);
            if (mapEmptyMap == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            Set setKeySet = mapEmptyMap.keySet();
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = setKeySet.iterator();
            while (it2.hasNext()) {
                User user = map.get(Long.valueOf(((Number) it2.next()).longValue()));
                if (user != null) {
                    arrayList3.add(user);
                }
            }
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : arrayList3) {
                StageRoles stageRolesM17getUserRolesuOBN1zc = m17getUserRolesuOBN1zc(((User) obj2).getId(), channel.getId());
                if (stageRolesM17getUserRolesuOBN1zc != null && StageRoles.m33isSpeakerimpl(stageRolesM17getUserRolesuOBN1zc.m35unboximpl())) {
                    arrayList4.add(obj2);
                }
            }
            ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList4, 10));
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                arrayList5.add(Long.valueOf(((User) it3.next()).getId()));
            }
            Set set = _Collections.toSet(arrayList5);
            int size = arrayList3.size() - set.size();
            Long l = (Long) outline.d(channel, this.permissionsStore.getPermissionsByChannel());
            boolean z2 = PermissionUtils.can(Permission.CONNECT, l) && PermissionUtils.can(Permission.VIEW_CHANNEL, l);
            Map<Long, GuildMember> map2 = this.guildsStore.getMembers().get(Long.valueOf(guildId));
            ArrayList<User> arrayList6 = new ArrayList();
            for (Object obj3 : arrayList3) {
                if (set.contains(Long.valueOf(((User) obj3).getId()))) {
                    arrayList6.add(obj3);
                }
            }
            ArrayList arrayList7 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList6, 10));
            for (User user2 : arrayList6) {
                arrayList7.add(new UserGuildMember(user2, map2 != null ? (GuildMember) outline.f(user2, map2) : null));
            }
            ArrayList arrayList8 = arrayList2;
            Iterator it4 = it;
            StageRoles stageRolesM15getMyRolesvisDeB4 = m15getMyRolesvisDeB4(channel.getId());
            StageInstance stageInstanceForChannel = this.stageInstancesStore.getStageInstanceForChannel(channel.getId());
            VoiceState voiceState = voiceStates.get(Long.valueOf(myId));
            Long channelId = voiceState != null ? voiceState.getChannelId() : null;
            arrayList8.add(new StageChannel(channel, arrayList3, stageRolesM15getMyRolesvisDeB4, set, arrayList7, size, stageInstanceForChannel, z2, channelId != null && channelId.longValue() == channel.getId(), null));
            i = 10;
            map = users;
            arrayList2 = arrayList8;
            it = it4;
        }
        ArrayList arrayList9 = arrayList2;
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList9, i)), 16));
        for (Object obj4 : arrayList9) {
            linkedHashMap.put(Long.valueOf(((StageChannel) obj4).getChannel().getId()), obj4);
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: getUserRoles-uOBN1zc, reason: not valid java name */
    public final StageRoles m17getUserRolesuOBN1zc(long userId, long channelId) {
        Map<Long, StageRoles> map = this.stageRolesByChannelSnapshot.get(Long.valueOf(channelId));
        if (map == null) {
            return null;
        }
        StageRoles stageRoles = map.get(Long.valueOf(userId));
        return StageRoles.m25boximpl(stageRoles != null ? stageRoles.m35unboximpl() : StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo());
    }

    /* JADX INFO: renamed from: getUserRolesInternal-uOBN1zc, reason: not valid java name */
    public final StageRoles m18getUserRolesInternaluOBN1zc(long userId, long channelId) {
        Map<Long, StageRoles> map = this.stageRolesByChannel.get(Long.valueOf(channelId));
        if (map == null) {
            return null;
        }
        StageRoles stageRoles = map.get(Long.valueOf(userId));
        return StageRoles.m25boximpl(stageRoles != null ? stageRoles.m35unboximpl() : StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo());
    }

    @Store3
    public final void handleChannelDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.D(channel)) {
            if (this.stageRolesByChannel.remove(Long.valueOf(channel.getId())) != null) {
                this.dirtyChannelIds.add(Long.valueOf(channel.getId()));
                markChanged();
            }
            Map map = (Map) outline.c(channel, this.stageEventStates);
            if (map == null || ((StageEventActivationState) map.remove(Long.valueOf(channel.getId()))) == null) {
                return;
            }
            markStageEventDirty();
        }
    }

    @Store3
    public final void handleConnectionOpen() {
        this.stageRolesByChannel.clear();
        this.stageEventStates.clear();
    }

    @Store3
    public final void handleGuildMemberAdd(com.discord.api.guildmember.GuildMember member) {
        StageRoles stageRoles;
        Intrinsics3.checkNotNullParameter(member, "member");
        User user = this.userStore.getUsersInternal$app_productionGoogleRelease().get(Long.valueOf(member.getUser().getId()));
        if (user == null || !user.getIsBot()) {
            Iterator<Long> it = stageChannelIdsInGuildForDispatch(member.getGuildId()).iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                Map<Long, StageRoles> map = this.stageRolesByChannel.get(Long.valueOf(jLongValue));
                if (map != null && (stageRoles = map.get(Long.valueOf(member.getUser().getId()))) != null) {
                    int iM35unboximpl = stageRoles.m35unboximpl();
                    Channel channel = this.channelsStore.getChannelsByIdInternal$app_productionGoogleRelease().get(Long.valueOf(jLongValue));
                    if (channel != null) {
                        int iM10computeUserRolesInDispatcht27eFtU$default = m10computeUserRolesInDispatcht27eFtU$default(this, member.getUser().getId(), channel, null, null, 12, null);
                        if (!StageRoles.m28equalsimpl0(iM10computeUserRolesInDispatcht27eFtU$default, iM35unboximpl)) {
                            map.put(Long.valueOf(member.getUser().getId()), StageRoles.m25boximpl(iM10computeUserRolesInDispatcht27eFtU$default));
                            m14handleUserRoleChangeuOJZ9lM(channel, member.getUser().getId(), StageRoles.m25boximpl(iM35unboximpl), iM10computeUserRolesInDispatcht27eFtU$default);
                            this.dirtyChannelIds.add(Long.valueOf(jLongValue));
                            markChanged();
                        }
                    }
                }
            }
        }
    }

    @Store3
    public final void handleGuildMemberRemove(long guildId, long userId) {
        StageRoles stageRoles;
        Channel channel;
        User user = this.userStore.getUsersInternal$app_productionGoogleRelease().get(Long.valueOf(userId));
        if (user == null || !user.getIsBot()) {
            Iterator<Long> it = stageChannelIdsInGuildForDispatch(guildId).iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                Map<Long, StageRoles> map = this.stageRolesByChannel.get(Long.valueOf(jLongValue));
                if (map != null && (stageRoles = map.get(Long.valueOf(userId))) != null && (channel = this.channelsStore.getChannelsByIdInternal$app_productionGoogleRelease().get(Long.valueOf(jLongValue))) != null) {
                    m13handleUserLeftStageOrLostRolesGM3QuyE$default(this, channel, userId, stageRoles.m35unboximpl(), 0, 8, null);
                    this.dirtyChannelIds.add(Long.valueOf(jLongValue));
                    markChanged();
                }
            }
        }
    }

    @Store3
    public final void handleGuildRemove(com.discord.api.guild.Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        if (this.stageEventStates.remove(Long.valueOf(guild.getId())) != null) {
            markStageEventDirty();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = this.channelsStore.getChannelsForGuild(guild.getId()).keySet().iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            if (this.stageRolesByChannel.remove(Long.valueOf(jLongValue)) != null) {
                linkedHashSet.add(Long.valueOf(jLongValue));
            }
        }
        if (!linkedHashSet.isEmpty()) {
            MutableCollections.addAll(this.dirtyChannelIds, linkedHashSet);
            markChanged();
        }
    }

    @Store3
    public final void handleGuildRoleCreateOrUpdate(long guildId) {
        Iterator<Long> it = stageChannelIdsInGuildForDispatch(guildId).iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            Map<Long, StageRoles> map = this.stageRolesByChannel.get(Long.valueOf(jLongValue));
            if (map != null) {
                Iterator it2 = _Collections.toList(map.keySet()).iterator();
                while (it2.hasNext()) {
                    handleVoiceStatesUpdated(guildId, jLongValue, ((Number) it2.next()).longValue());
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0097  */
    @Store3
    public final void handleVoiceStatesUpdated(long guildId, long fromChannelId, long userId) {
        boolean z2;
        Long channelId;
        Long channelId2;
        Map<Long, VoiceState> map = this.voiceStatesStore.getInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        VoiceState voiceState = map != null ? map.get(Long.valueOf(userId)) : null;
        long jLongValue = (voiceState == null || (channelId2 = voiceState.getChannelId()) == null) ? fromChannelId : channelId2.longValue();
        Channel channelInternal$app_productionGoogleRelease = this.channelsStore.getChannelInternal$app_productionGoogleRelease(guildId, jLongValue);
        Channel channelInternal$app_productionGoogleRelease2 = this.channelsStore.getChannelInternal$app_productionGoogleRelease(guildId, fromChannelId);
        if (channelInternal$app_productionGoogleRelease2 != null && ChannelUtils.D(channelInternal$app_productionGoogleRelease2) && (voiceState == null || (channelId = voiceState.getChannelId()) == null || channelId.longValue() != fromChannelId)) {
            Map<Long, StageRoles> map2 = this.stageRolesByChannel.get(Long.valueOf(fromChannelId));
            StageRoles stageRolesRemove = map2 != null ? map2.remove(Long.valueOf(userId)) : null;
            if (stageRolesRemove != null) {
                z2 = true;
                m13handleUserLeftStageOrLostRolesGM3QuyE$default(this, channelInternal$app_productionGoogleRelease2, userId, stageRolesRemove.m35unboximpl(), 0, 8, null);
                this.dirtyChannelIds.add(Long.valueOf(fromChannelId));
                markChanged();
            } else {
                z2 = true;
            }
        } else {
            z2 = true;
        }
        if (voiceState == null || channelInternal$app_productionGoogleRelease == null || ChannelUtils.D(channelInternal$app_productionGoogleRelease) != z2) {
            return;
        }
        Map<Long, StageRoles> linkedHashMap = this.stageRolesByChannel.get(Long.valueOf(jLongValue));
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
            this.stageRolesByChannel.put(Long.valueOf(jLongValue), linkedHashMap);
        }
        Map<Long, StageRoles> map3 = linkedHashMap;
        StageRoles stageRoles = map3.get(Long.valueOf(userId));
        int iM10computeUserRolesInDispatcht27eFtU$default = m10computeUserRolesInDispatcht27eFtU$default(this, userId, channelInternal$app_productionGoogleRelease, map, null, 8, null);
        if (StageRoles.m27equalsimpl(iM10computeUserRolesInDispatcht27eFtU$default, stageRoles) ^ z2) {
            m14handleUserRoleChangeuOJZ9lM(channelInternal$app_productionGoogleRelease, userId, stageRoles, iM10computeUserRolesInDispatcht27eFtU$default);
            map3.put(Long.valueOf(userId), StageRoles.m25boximpl(iM10computeUserRolesInDispatcht27eFtU$default));
            this.dirtyChannelIds.add(Long.valueOf(jLongValue));
            markChanged();
        }
    }

    public final Observable<Map<Long, StageChannel>> observeGuildStageChannels(long guildId) {
        Observable<Map<Long, StageChannel>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, this.channelsStore, this.userStore, this.voiceStatesStore, this.stageInstancesStore}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<StageRequestToSpeakState> observeMyRequestToSpeakState(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, this.channelsStore, this.guildsStore, this.userStore, this.voiceStatesStore}, false, null, null, new AnonymousClass1(channelId), 14, null);
    }

    public final Observable<StageRoles> observeMyRoles(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, this.channelsStore}, false, null, null, new AnonymousClass1(channelId), 14, null);
    }

    public final Observable<Map<Long, Map<Long, StageRoles>>> observeRoles() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Map<Long, StageChannel>> observeStageChannels() {
        Observable<Map<Long, StageChannel>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, this.channelsStore, this.guildsStore, this.userStore, this.voiceStatesStore, this.stageInstancesStore}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, StageRoles>> observeStageRolesByChannel(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null);
    }

    public final Observable<StageRequestToSpeakState> observeUserRequestToSpeakState(long userId, long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, this.channelsStore, this.guildsStore, this.voiceStatesStore}, false, null, null, new AnonymousClass1(channelId, userId), 14, null);
    }

    public final Observable<StageRoles> observeUserRoles(long userId, long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, this.channelsStore}, false, null, null, new AnonymousClass1(channelId, userId), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        Map<Long, Map<Long, StageRoles>> map = this.stageRolesByChannel;
        Map<Long, ? extends Map<Long, StageRoles>> map2 = this.stageRolesByChannelSnapshot;
        Set<Long> set = this.dirtyChannelIds;
        if (!set.isEmpty()) {
            HashMap map3 = new HashMap(map.size());
            for (Map.Entry<Long, Map<Long, StageRoles>> entry : map.entrySet()) {
                Long key = entry.getKey();
                Map<Long, StageRoles> value = entry.getValue();
                if (set.contains(key)) {
                    key.longValue();
                    map3.put(key, new HashMap(value));
                } else {
                    Map<Long, StageRoles> map4 = map2.get(key);
                    if (map4 != null) {
                        map3.put(key, map4);
                    }
                }
            }
            map2 = map3;
        }
        this.stageRolesByChannelSnapshot = map2;
        this.dirtyChannelIds.clear();
    }

    public StoreStageChannels(StoreUser storeUser, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreVoiceStates storeVoiceStates, StorePermissions storePermissions, StoreStageInstances storeStageInstances, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceStates, "voiceStatesStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeStageInstances, "stageInstancesStore");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.userStore = storeUser;
        this.guildsStore = storeGuilds;
        this.channelsStore = storeChannels;
        this.voiceStatesStore = storeVoiceStates;
        this.permissionsStore = storePermissions;
        this.stageInstancesStore = storeStageInstances;
        this.observationDeck = observationDeck;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.stageRolesByChannel = linkedHashMap;
        this.stageRolesByChannelSnapshot = new HashMap(linkedHashMap);
        this.stageEventStates = new LinkedHashMap();
        this.dirtyChannelIds = new LinkedHashSet();
    }
}
