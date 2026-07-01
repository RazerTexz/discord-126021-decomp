package com.discord.stores;

import b.d.b.a.a;
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
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.stage.StageChannelNotifications;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.model.StageChannel;
import d0.d0.f;
import d0.f0.n;
import d0.f0.q;
import d0.t.g0;
import d0.t.h0;
import d0.t.o;
import d0.t.o0;
import d0.t.r;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;
import rx.Observable;

/* JADX INFO: compiled from: StoreStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageChannels extends StoreV2 {
    public static final long CAN_MODERATE_STAGE_CHANNELS = 20971536;
    public static final StoreStageChannels$Companion Companion = new StoreStageChannels$Companion(null);
    private static final StoreStageChannels$Companion$EventStateUpdateSource$1 EventStateUpdateSource = new StoreStageChannels$Companion$EventStateUpdateSource$1();
    private final StoreChannels channelsStore;
    private final Set<Long> dirtyChannelIds;
    private final StoreGuilds guildsStore;
    private final ObservationDeck observationDeck;
    private final StorePermissions permissionsStore;
    private final Map<Long, Map<Long, StoreStageChannels$StageEventActivationState>> stageEventStates;
    private final StoreStageInstances stageInstancesStore;
    private final Map<Long, Map<Long, StageRoles>> stageRolesByChannel;
    private Map<Long, ? extends Map<Long, StageRoles>> stageRolesByChannelSnapshot;
    private final StoreUser userStore;
    private final StoreVoiceStates voiceStatesStore;

    public /* synthetic */ StoreStageChannels(StoreUser storeUser, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreVoiceStates storeVoiceStates, StorePermissions storePermissions, StoreStageInstances storeStageInstances, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeUser, storeGuilds, storeChannels, storeVoiceStates, storePermissions, storeStageInstances, (i & 64) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ StoreChannels access$getChannelsStore$p(StoreStageChannels storeStageChannels) {
        return storeStageChannels.channelsStore;
    }

    public static final /* synthetic */ StoreGuilds access$getGuildsStore$p(StoreStageChannels storeStageChannels) {
        return storeStageChannels.guildsStore;
    }

    public static final /* synthetic */ Map access$getStageRolesByChannelSnapshot$p(StoreStageChannels storeStageChannels) {
        return storeStageChannels.stageRolesByChannelSnapshot;
    }

    public static final /* synthetic */ StoreUser access$getUserStore$p(StoreStageChannels storeStageChannels) {
        return storeStageChannels.userStore;
    }

    public static final /* synthetic */ StoreVoiceStates access$getVoiceStatesStore$p(StoreStageChannels storeStageChannels) {
        return storeStageChannels.voiceStatesStore;
    }

    public static final /* synthetic */ void access$setStageRolesByChannelSnapshot$p(StoreStageChannels storeStageChannels, Map map) {
        storeStageChannels.stageRolesByChannelSnapshot = map;
    }

    /* JADX INFO: renamed from: computeUserRolesInDispatch-t27eFtU, reason: not valid java name */
    private final int m9computeUserRolesInDispatcht27eFtU(long userId, Channel channel, Map<Long, VoiceState> voiceStates, Map<Long, GuildRole> roles) {
        Guild guild = (Guild) a.c(channel, this.guildsStore.getGuildsInternal$app_productionGoogleRelease());
        if (guild == null) {
            return StageRoles.Companion.m37getAUDIENCE1LxfuJo();
        }
        Map map = (Map) a.c(channel, this.guildsStore.getGuildMembersComputedInternal$app_productionGoogleRelease());
        if (map == null) {
            return StageRoles.Companion.m37getAUDIENCE1LxfuJo();
        }
        GuildMember guildMember = (GuildMember) map.get(Long.valueOf(userId));
        if (guildMember == null) {
            return StageRoles.Companion.m37getAUDIENCE1LxfuJo();
        }
        if (roles == null) {
            roles = (Map) a.c(channel, this.guildsStore.getGuildRolesInternal$app_productionGoogleRelease());
        }
        if (voiceStates == null) {
            voiceStates = (Map) a.c(channel, this.voiceStatesStore.getInternal$app_productionGoogleRelease());
        }
        if (voiceStates == null) {
            return StageRoles.Companion.m37getAUDIENCE1LxfuJo();
        }
        StageChannelRoleContext stageChannelRoleContextRoleContext = roleContext(channel, guild, voiceStates, roles);
        return stageChannelRoleContextRoleContext != null ? stageChannelRoleContextRoleContext.m7getRoleK6mKVE(userId, guildMember) : StageRoles.Companion.m37getAUDIENCE1LxfuJo();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: computeUserRolesInDispatch-t27eFtU$default, reason: not valid java name */
    public static /* synthetic */ int m10computeUserRolesInDispatcht27eFtU$default(StoreStageChannels storeStageChannels, long j, Channel channel, Map map, Map map2, int i, Object obj) {
        return storeStageChannels.m9computeUserRolesInDispatcht27eFtU(j, channel, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : map2);
    }

    private final Guild getGuild(Channel channel) {
        return (Guild) a.c(channel, this.guildsStore.getGuilds());
    }

    public static /* synthetic */ int getOtherModeratorsCountInChannel$default(StoreStageChannels storeStageChannels, Channel channel, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = storeStageChannels.userStore.getMeSnapshot().getId();
        }
        return storeStageChannels.getOtherModeratorsCountInChannel(channel, j);
    }

    private final Map<Long, GuildRole> getRolesMap(Guild guild) {
        Map<Long, GuildRole> map = (Map) a.e(guild, this.guildsStore.getRoles());
        return map != null ? map : h0.emptyMap();
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
                mapEmptyMap = h0.emptyMap();
            }
            map4 = mapEmptyMap;
        } else {
            map4 = map3;
        }
        return storeStageChannels.getStageChannelsInGuild(j, channelsForGuild, id2, users, map4);
    }

    /* JADX INFO: renamed from: handleUserJoinedStageOrGainedRole-oRmTEFA, reason: not valid java name */
    private final void m11handleUserJoinedStageOrGainedRoleoRmTEFA(Channel channel, long userId, int roles) {
        if (StageRoles.m32isModeratorimpl(roles) || StageRoles.m33isSpeakerimpl(roles)) {
            Map<Long, StoreStageChannels$StageEventActivationState> linkedHashMap = (Map) a.c(channel, this.stageEventStates);
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>();
                this.stageEventStates.put(Long.valueOf(channel.getGuildId()), linkedHashMap);
            }
            StoreStageChannels$StageEventActivationState storeStageChannels$StageEventActivationState = (StoreStageChannels$StageEventActivationState) a.d(channel, linkedHashMap);
            if (storeStageChannels$StageEventActivationState == null) {
                storeStageChannels$StageEventActivationState = new StoreStageChannels$StageEventActivationState(null, 1, null);
                linkedHashMap.put(Long.valueOf(channel.getId()), storeStageChannels$StageEventActivationState);
            }
            boolean z2 = StageRoles.m32isModeratorimpl(roles) && !storeStageChannels$StageEventActivationState.getModerators().contains(Long.valueOf(userId));
            if (z2) {
                linkedHashMap.put(Long.valueOf(channel.getId()), storeStageChannels$StageEventActivationState.copy(z2 ? o0.plus(storeStageChannels$StageEventActivationState.getModerators(), Long.valueOf(userId)) : storeStageChannels$StageEventActivationState.getModerators()));
                markStageEventDirty();
            }
        }
    }

    /* JADX INFO: renamed from: handleUserLeftStageOrLostRoles-GM3QuyE, reason: not valid java name */
    private final void m12handleUserLeftStageOrLostRolesGM3QuyE(Channel channel, long userId, int oldRoles, int newRoles) {
        Map map;
        StoreStageChannels$StageEventActivationState storeStageChannels$StageEventActivationState;
        if ((!StageRoles.m32isModeratorimpl(oldRoles) && !StageRoles.m33isSpeakerimpl(oldRoles)) || (map = (Map) a.c(channel, this.stageEventStates)) == null || (storeStageChannels$StageEventActivationState = (StoreStageChannels$StageEventActivationState) a.d(channel, map)) == null) {
            return;
        }
        boolean z2 = !StageRoles.m32isModeratorimpl(newRoles) && StageRoles.m32isModeratorimpl(oldRoles) && storeStageChannels$StageEventActivationState.getModerators().contains(Long.valueOf(userId));
        if (z2) {
            map.put(Long.valueOf(channel.getId()), storeStageChannels$StageEventActivationState.copy(z2 ? o0.minus(storeStageChannels$StageEventActivationState.getModerators(), Long.valueOf(userId)) : storeStageChannels$StageEventActivationState.getModerators()));
            markStageEventDirty();
        }
    }

    /* JADX INFO: renamed from: handleUserLeftStageOrLostRoles-GM3QuyE$default, reason: not valid java name */
    public static /* synthetic */ void m13handleUserLeftStageOrLostRolesGM3QuyE$default(StoreStageChannels storeStageChannels, Channel channel, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = StageRoles.Companion.m37getAUDIENCE1LxfuJo();
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
                StageChannelNotifications.Companion.getINSTANCE().onInvitedToSpeak(channel.getId());
            } else {
                if (oldRole == null || !StageRoles.m31isInvitedToSpeakimpl(oldRole.m35unboximpl()) || StageRoles.m31isInvitedToSpeakimpl(newRole)) {
                    return;
                }
                StageChannelNotifications.Companion.getINSTANCE().onInviteToSpeakRescinded();
            }
        }
    }

    private final void markStageEventDirty() {
        markChanged(EventStateUpdateSource);
    }

    private final StageChannelRoleContext roleContext(Channel channel, Guild guild, Map<Long, VoiceState> voiceStates, Map<Long, GuildRole> roles) {
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
        return new StageChannelRoleContext(guild, channel, roles, voiceStates);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StageChannelRoleContext roleContext$default(StoreStageChannels storeStageChannels, Channel channel, Guild guild, Map map, Map map2, int i, Object obj) {
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
        return (channelsForGuildInternal$app_productionGoogleRelease == null || (collectionValues = channelsForGuildInternal$app_productionGoogleRelease.values()) == null || (sequenceAsSequence = u.asSequence(collectionValues)) == null || (sequenceMapNotNull = q.mapNotNull(sequenceAsSequence, StoreStageChannels$stageChannelIdsInGuildForDispatch$1.INSTANCE)) == null) ? n.emptySequence() : sequenceMapNotNull;
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
        StoreStageChannels$StageEventActivationState storeStageChannels$StageEventActivationState;
        m.checkNotNullParameter(channel, "channel");
        Map map = (Map) a.c(channel, this.stageEventStates);
        if (map == null || (storeStageChannels$StageEventActivationState = (StoreStageChannels$StageEventActivationState) a.d(channel, map)) == null) {
            return 0;
        }
        int size = storeStageChannels$StageEventActivationState.getModerators().size();
        return storeStageChannels$StageEventActivationState.getModerators().contains(Long.valueOf(myId)) ? size - 1 : size;
    }

    public final Map<Long, StageChannel> getStageChannelsInGuild(long guildId, Map<Long, Channel> channelsInGuild, long myId, Map<Long, ? extends User> users, Map<Long, VoiceState> voiceStates) {
        Map<Long, ? extends User> map = users;
        m.checkNotNullParameter(channelsInGuild, "channelsInGuild");
        m.checkNotNullParameter(map, "users");
        m.checkNotNullParameter(voiceStates, "voiceStates");
        Collection<Channel> collectionValues = channelsInGuild.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (ChannelUtils.D((Channel) obj)) {
                arrayList.add(obj);
            }
        }
        int i = 10;
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Channel channel = (Channel) it.next();
            Map mapEmptyMap = (Map) a.d(channel, this.stageRolesByChannelSnapshot);
            if (mapEmptyMap == null) {
                mapEmptyMap = h0.emptyMap();
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
            ArrayList arrayList5 = new ArrayList(o.collectionSizeOrDefault(arrayList4, 10));
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                arrayList5.add(Long.valueOf(((User) it3.next()).getId()));
            }
            Set set = u.toSet(arrayList5);
            int size = arrayList3.size() - set.size();
            Long l = (Long) a.d(channel, this.permissionsStore.getPermissionsByChannel());
            boolean z2 = PermissionUtils.can(Permission.CONNECT, l) && PermissionUtils.can(Permission.VIEW_CHANNEL, l);
            Map<Long, GuildMember> map2 = this.guildsStore.getMembers().get(Long.valueOf(guildId));
            ArrayList<User> arrayList6 = new ArrayList();
            for (Object obj3 : arrayList3) {
                if (set.contains(Long.valueOf(((User) obj3).getId()))) {
                    arrayList6.add(obj3);
                }
            }
            ArrayList arrayList7 = new ArrayList(o.collectionSizeOrDefault(arrayList6, 10));
            for (User user2 : arrayList6) {
                arrayList7.add(new UserGuildMember(user2, map2 != null ? (GuildMember) a.f(user2, map2) : null));
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
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(arrayList9, i)), 16));
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
        return StageRoles.m25boximpl(stageRoles != null ? stageRoles.m35unboximpl() : StageRoles.Companion.m37getAUDIENCE1LxfuJo());
    }

    /* JADX INFO: renamed from: getUserRolesInternal-uOBN1zc, reason: not valid java name */
    public final StageRoles m18getUserRolesInternaluOBN1zc(long userId, long channelId) {
        Map<Long, StageRoles> map = this.stageRolesByChannel.get(Long.valueOf(channelId));
        if (map == null) {
            return null;
        }
        StageRoles stageRoles = map.get(Long.valueOf(userId));
        return StageRoles.m25boximpl(stageRoles != null ? stageRoles.m35unboximpl() : StageRoles.Companion.m37getAUDIENCE1LxfuJo());
    }

    @StoreThread
    public final void handleChannelDelete(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.D(channel)) {
            if (this.stageRolesByChannel.remove(Long.valueOf(channel.getId())) != null) {
                this.dirtyChannelIds.add(Long.valueOf(channel.getId()));
                markChanged();
            }
            Map map = (Map) a.c(channel, this.stageEventStates);
            if (map == null || ((StoreStageChannels$StageEventActivationState) map.remove(Long.valueOf(channel.getId()))) == null) {
                return;
            }
            markStageEventDirty();
        }
    }

    @StoreThread
    public final void handleConnectionOpen() {
        this.stageRolesByChannel.clear();
        this.stageEventStates.clear();
    }

    @StoreThread
    public final void handleGuildMemberAdd(com.discord.api.guildmember.GuildMember member) {
        StageRoles stageRoles;
        m.checkNotNullParameter(member, "member");
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

    @StoreThread
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

    @StoreThread
    public final void handleGuildRemove(com.discord.api.guild.Guild guild) {
        m.checkNotNullParameter(guild, "guild");
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
            r.addAll(this.dirtyChannelIds, linkedHashSet);
            markChanged();
        }
    }

    @StoreThread
    public final void handleGuildRoleCreateOrUpdate(long guildId) {
        Iterator<Long> it = stageChannelIdsInGuildForDispatch(guildId).iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            Map<Long, StageRoles> map = this.stageRolesByChannel.get(Long.valueOf(jLongValue));
            if (map != null) {
                Iterator it2 = u.toList(map.keySet()).iterator();
                while (it2.hasNext()) {
                    handleVoiceStatesUpdated(guildId, jLongValue, ((Number) it2.next()).longValue());
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0097  */
    @StoreThread
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
        Observable<Map<Long, StageChannel>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this, this.channelsStore, this.userStore, this.voiceStatesStore, this.stageInstancesStore}, false, null, null, new StoreStageChannels$observeGuildStageChannels$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<StageRequestToSpeakState> observeMyRequestToSpeakState(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this, this.channelsStore, this.guildsStore, this.userStore, this.voiceStatesStore}, false, null, null, new StoreStageChannels$observeMyRequestToSpeakState$1(this, channelId), 14, null);
    }

    public final Observable<StageRoles> observeMyRoles(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this, this.channelsStore}, false, null, null, new StoreStageChannels$observeMyRoles$1(this, channelId), 14, null);
    }

    public final Observable<Map<Long, Map<Long, StageRoles>>> observeRoles() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreStageChannels$observeRoles$1(this), 14, null);
    }

    public final Observable<Map<Long, StageChannel>> observeStageChannels() {
        Observable<Map<Long, StageChannel>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this, this.channelsStore, this.guildsStore, this.userStore, this.voiceStatesStore, this.stageInstancesStore}, false, null, null, new StoreStageChannels$observeStageChannels$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, StageRoles>> observeStageRolesByChannel(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreStageChannels$observeStageRolesByChannel$1(this, channelId), 14, null);
    }

    public final Observable<StageRequestToSpeakState> observeUserRequestToSpeakState(long userId, long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this, this.channelsStore, this.guildsStore, this.voiceStatesStore}, false, null, null, new StoreStageChannels$observeUserRequestToSpeakState$1(this, channelId, userId), 14, null);
    }

    public final Observable<StageRoles> observeUserRoles(long userId, long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this, this.channelsStore}, false, null, null, new StoreStageChannels$observeUserRoles$1(this, channelId, userId), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        Map<Long, Map<Long, StageRoles>> map = this.stageRolesByChannel;
        Map<Long, ? extends Map<Long, StageRoles>> map2 = this.stageRolesByChannelSnapshot;
        Set<Long> set = this.dirtyChannelIds;
        if (!set.isEmpty()) {
            HashMap map3 = new HashMap(map.size());
            for (Map$Entry<Long, Map<Long, StageRoles>> map$Entry : map.entrySet()) {
                Long key = map$Entry.getKey();
                Map<Long, StageRoles> value = map$Entry.getValue();
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
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storeVoiceStates, "voiceStatesStore");
        m.checkNotNullParameter(storePermissions, "permissionsStore");
        m.checkNotNullParameter(storeStageInstances, "stageInstancesStore");
        m.checkNotNullParameter(observationDeck, "observationDeck");
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
