package com.discord.stores;

import android.content.Context;
import b.a.d.o;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.guildmember.GuildMembersChunk;
import com.discord.api.guildscheduledevent.ApiGuildScheduledEventUser;
import com.discord.api.role.GuildRole;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadListMember;
import com.discord.api.thread.ThreadMemberListUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelPayload;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember$Companion;
import com.discord.models.user.MeUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.collections.SnowflakePartitionMap$CopiablePartitionMap;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.g0;
import d0.t.h0;
import d0.t.n0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds extends StoreV2 {
    private static final int HUGE_GUILD_SIZE = 2000;
    private final Dispatcher dispatcher;
    private final Map<Long, Map<Long, GuildMember>> guildMembers;
    private final Map<Long, Map<Long, com.discord.models.member.GuildMember>> guildMembersComputed;
    private Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>> guildMembersComputedSnapshot;
    private final Map<Long, Map<Long, GuildRole>> guildRoles;
    private final Persister<Map<Long, Map<Long, GuildRole>>> guildRolesCache;
    private Map<Long, ? extends Map<Long, GuildRole>> guildRolesSnapshot;
    private final Map<Long, Guild> guilds;
    private final Persister<Map<Long, Guild>> guildsCache;
    private final Map<Long, Long> guildsJoinedAt;
    private final Persister<Map<Long, Long>> guildsJoinedAtCache;
    private Map<Long, Long> guildsJoinedAtSnapshot;
    private Map<Long, Guild> guildsSnapshot;
    private final Set<Long> guildsUnavailable;
    private Set<Long> guildsUnavailableSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreUser userStore;
    public static final StoreGuilds$Companion Companion = new StoreGuilds$Companion(null);
    private static final Map<Long, com.discord.models.member.GuildMember> emptyComputedMap = new HashMap();
    private static final Map<Long, GuildRole> emptyRoles = new HashMap();
    private static final StoreGuilds$Companion$GuildsUpdate$1 GuildsUpdate = new StoreGuilds$Companion$GuildsUpdate$1();
    private static final StoreGuilds$Companion$ComputedMembersUpdate$1 ComputedMembersUpdate = new StoreGuilds$Companion$ComputedMembersUpdate$1();

    public /* synthetic */ StoreGuilds(StoreUser storeUser, Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeUser, dispatcher, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuilds storeGuilds) {
        return storeGuilds.dispatcher;
    }

    public static final /* synthetic */ Map access$getEmptyComputedMap$cp() {
        return emptyComputedMap;
    }

    public static final /* synthetic */ Map access$getEmptyRoles$cp() {
        return emptyRoles;
    }

    public static final /* synthetic */ void access$handleGuildMemberCommunicationEnabledInternal(StoreGuilds storeGuilds, long j, long j2) {
        storeGuilds.handleGuildMemberCommunicationEnabledInternal(j, j2);
    }

    private final long getMeId() {
        return this.userStore.getMe().getId();
    }

    @StoreThread
    private final void handleGuild(com.discord.api.guild.Guild guild, boolean remove) {
        long id2 = guild.getId();
        if (remove) {
            if (this.guilds.containsKey(Long.valueOf(id2))) {
                this.guilds.remove(Long.valueOf(id2));
                markChanged(GuildsUpdate);
                return;
            }
            return;
        }
        Guild guild2 = this.guilds.get(Long.valueOf(id2));
        if (guild2 == null) {
            guild2 = new Guild(null, null, null, null, null, 0, 0L, null, 0L, null, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, false, null, -1, 3, null);
        }
        Guild guildMerge = guild2.merge(guild);
        if (!m.areEqual(guildMerge, this.guilds.get(Long.valueOf(id2)))) {
            this.guilds.put(Long.valueOf(id2), guildMerge);
            markChanged(GuildsUpdate);
        }
    }

    public static /* synthetic */ void handleGuildMember$default(StoreGuilds storeGuilds, GuildMember guildMember, long j, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        storeGuilds.handleGuildMember(guildMember, j, z2);
    }

    @StoreThread
    private final void handleGuildMemberCommunicationEnabledInternal(long guildId, long userId) {
        Map<Long, GuildMember> map = this.guildMembers.get(Long.valueOf(guildId));
        GuildMember guildMember = map != null ? map.get(Long.valueOf(userId)) : null;
        if ((guildMember != null ? guildMember.getCommunicationDisabledUntil() : null) == null) {
            return;
        }
        GuildMember guildMemberA = GuildMember.a(guildMember, 0L, null, null, null, null, null, false, null, null, null, null, null, null, 4095);
        handleGuildMember$default(this, guildMemberA, guildId, false, 4, null);
        if (userId == getMeId()) {
            StoreStream.Companion.getPermissions().handleGuildMemberAdd(guildMemberA);
        }
    }

    @StoreThread
    private final void handleGuildMembers(long guildId, long removedGuildMemberUserId, Collection<GuildMember> members, boolean remove) {
        if (!remove) {
            if (members != null) {
                Iterator<T> it = members.iterator();
                while (it.hasNext()) {
                    handleGuildMember$default(this, (GuildMember) it.next(), guildId, false, 4, null);
                }
                return;
            }
            return;
        }
        if (removedGuildMemberUserId <= 0) {
            if (this.guildMembers.remove(Long.valueOf(guildId)) != null) {
                markChanged(GuildsUpdate);
            }
            if (this.guildMembersComputed.remove(Long.valueOf(guildId)) != null) {
                markChanged(ComputedMembersUpdate);
                return;
            }
            return;
        }
        Map<Long, GuildMember> map = this.guildMembers.get(Long.valueOf(guildId));
        if ((map != null ? map.remove(Long.valueOf(removedGuildMemberUserId)) : null) != null) {
            markChanged(GuildsUpdate);
        }
        Map<Long, com.discord.models.member.GuildMember> map2 = this.guildMembersComputed.get(Long.valueOf(guildId));
        if ((map2 != null ? map2.remove(Long.valueOf(removedGuildMemberUserId)) : null) != null) {
            markChanged(ComputedMembersUpdate);
        }
    }

    @StoreThread
    private final void handleGuildMembersMap(long guildId, Map<Long, GuildMember> members) {
        handleGuildMembers(guildId, 0L, members != null ? members.values() : null, false);
    }

    @StoreThread
    private final void handleGuildRoles(long guildId, long deletedRoleId, List<GuildRole> roles, boolean remove) {
        if (remove) {
            if (deletedRoleId > 0) {
                Map<Long, GuildRole> map = this.guildRoles.get(Long.valueOf(guildId));
                if ((map != null ? map.remove(Long.valueOf(deletedRoleId)) : null) != null) {
                    markChanged(GuildsUpdate);
                    return;
                }
                return;
            }
            if (this.guildRoles.containsKey(Long.valueOf(guildId))) {
                this.guildRoles.remove(Long.valueOf(guildId));
                markChanged(GuildsUpdate);
                return;
            }
            return;
        }
        Map<Long, Map<Long, GuildRole>> map2 = this.guildRoles;
        Long lValueOf = Long.valueOf(guildId);
        Map<Long, GuildRole> map3 = map2.get(lValueOf);
        if (map3 == null) {
            map3 = new HashMap<>();
            map2.put(lValueOf, map3);
        }
        Map<Long, GuildRole> map4 = map3;
        if (roles != null) {
            for (GuildRole guildRole : roles) {
                if (!m.areEqual(map4.get(Long.valueOf(guildRole.getId())), guildRole)) {
                    map4.put(Long.valueOf(guildRole.getId()), guildRole);
                    markChanged(GuildsUpdate);
                }
            }
        }
    }

    @StoreThread
    private final void handleGuildUnavailable(long guildId, boolean unavailable, boolean remove) {
        if (remove) {
            if (!unavailable || this.guildsUnavailable.contains(Long.valueOf(guildId))) {
                return;
            }
            this.guildsUnavailable.add(Long.valueOf(guildId));
            markChanged(GuildsUpdate);
            return;
        }
        if (unavailable || !this.guildsUnavailable.contains(Long.valueOf(guildId))) {
            return;
        }
        this.guildsUnavailable.remove(Long.valueOf(guildId));
        markChanged(GuildsUpdate);
    }

    @StoreThread
    private final void handleHasRoleAndJoinedAt(long guildId, Map<Long, GuildMember> members) {
        GuildMember guildMember;
        Long l;
        MeUser meInternal$app_productionGoogleRelease = this.userStore.getMe();
        if (members == null || (guildMember = members.get(Long.valueOf(meInternal$app_productionGoogleRelease.getId()))) == null) {
            return;
        }
        UtcDateTime joinedAt = guildMember.getJoinedAt();
        long dateTimeMillis = joinedAt != null ? joinedAt.getDateTimeMillis() : 0L;
        if (this.guildsJoinedAt.containsKey(Long.valueOf(guildId)) && (l = this.guildsJoinedAt.get(Long.valueOf(guildId))) != null && l.longValue() == dateTimeMillis) {
            return;
        }
        this.guildsJoinedAt.put(Long.valueOf(guildId), Long.valueOf(dateTimeMillis));
        markChanged(GuildsUpdate);
    }

    private final void initClearCommunicationDisabledObserver(Context ctx) {
        Observable observableR = Observable.j(observeCommunicationDisabledGuildMembers(), Observable.E(0L, 10L, TimeUnit.SECONDS), StoreGuilds$initClearCommunicationDisabledObserver$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observableR), StoreGuilds.class, ctx, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreGuilds$initClearCommunicationDisabledObserver$2(this), 60, (Object) null);
    }

    public final Guild getGuild(long guildId) {
        return this.guildsSnapshot.get(Long.valueOf(guildId));
    }

    @StoreThread
    public final Map<Long, Map<Long, com.discord.models.member.GuildMember>> getGuildMembersComputedInternal$app_productionGoogleRelease() {
        return this.guildMembersComputed;
    }

    @StoreThread
    public final Map<Long, Map<Long, GuildRole>> getGuildRolesInternal$app_productionGoogleRelease() {
        return this.guildRoles;
    }

    public final Map<Long, Guild> getGuilds() {
        return this.guildsSnapshot;
    }

    @StoreThread
    public final Map<Long, Guild> getGuildsInternal$app_productionGoogleRelease() {
        return this.guilds;
    }

    public final Map<Long, Long> getGuildsJoinedAt() {
        return this.guildsJoinedAtSnapshot;
    }

    @StoreThread
    public final Map<Long, Long> getGuildsJoinedAtInternal$app_productionGoogleRelease() {
        return this.guildsJoinedAt;
    }

    public final com.discord.models.member.GuildMember getMember(long guildId, long userId) {
        Map<Long, com.discord.models.member.GuildMember> map = this.guildMembersComputedSnapshot.get(Long.valueOf(guildId));
        if (map != null) {
            return map.get(Long.valueOf(userId));
        }
        return null;
    }

    public final Map<Long, Map<Long, com.discord.models.member.GuildMember>> getMembers() {
        return this.guildMembersComputedSnapshot;
    }

    public final Map<Long, Map<Long, GuildRole>> getRoles() {
        return this.guildRolesSnapshot;
    }

    public final Set<Long> getUnavailableGuilds() {
        return this.guildsUnavailableSnapshot;
    }

    @StoreThread
    public final Set<Long> getUnavailableGuildsInternal$app_productionGoogleRelease() {
        return this.guildsUnavailable;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        Map<Long, GuildMember> mapEmptyMap;
        m.checkNotNullParameter(payload, "payload");
        this.guilds.clear();
        this.guildMembers.clear();
        this.guildMembersComputed.clear();
        this.guildRoles.clear();
        this.guildsUnavailable.clear();
        for (com.discord.api.guild.Guild guild : payload.getGuilds()) {
            long id2 = guild.getId();
            if (guild.getUnavailable()) {
                this.guildsUnavailable.add(Long.valueOf(id2));
            } else {
                handleGuildRoles(id2, 0L, guild.G(), false);
                m.checkNotNullExpressionValue(guild, "guild");
                handleGuild(guild, false);
                List<GuildMember> listV = guild.v();
                if (listV == null || (mapEmptyMap = GuildUtilsKt.asMap(listV)) == null) {
                    mapEmptyMap = h0.emptyMap();
                }
                handleGuildMembersMap(id2, mapEmptyMap);
                handleHasRoleAndJoinedAt(id2, mapEmptyMap);
            }
        }
        markChanged(GuildsUpdate, ComputedMembersUpdate);
    }

    @StoreThread
    public final void handleGuildAdd(com.discord.api.guild.Guild guild) {
        Map<Long, GuildMember> mapEmptyMap;
        m.checkNotNullParameter(guild, "guild");
        handleGuildUnavailable(guild.getId(), guild.getUnavailable(), false);
        if (guild.getUnavailable()) {
            return;
        }
        handleGuildRoles(guild.getId(), 0L, guild.G(), false);
        handleGuild(guild, false);
        List<GuildMember> listV = guild.v();
        if (listV == null || (mapEmptyMap = GuildUtilsKt.asMap(listV)) == null) {
            mapEmptyMap = h0.emptyMap();
        }
        handleGuildMembersMap(guild.getId(), mapEmptyMap);
        handleHasRoleAndJoinedAt(guild.getId(), mapEmptyMap);
    }

    @StoreThread
    public final void handleGuildMember(GuildMember member, long guildId, boolean isFullGuildMember) {
        GuildMember guildMemberA = member;
        m.checkNotNullParameter(guildMemberA, "member");
        long id2 = member.getUser().getId();
        if (!this.guildMembers.containsKey(Long.valueOf(guildId))) {
            this.guildMembers.put(Long.valueOf(guildId), new HashMap());
        }
        if (!this.guildMembersComputed.containsKey(Long.valueOf(guildId))) {
            this.guildMembersComputed.put(Long.valueOf(guildId), new HashMap());
        }
        Map<Long, GuildMember> map = this.guildMembers.get(Long.valueOf(guildId));
        m.checkNotNull(map);
        GuildMember guildMember = map.get(Long.valueOf(id2));
        if (!isFullGuildMember && guildMember != null) {
            guildMemberA = GuildMember.a(member, 0L, null, null, null, null, null, false, null, null, null, guildMember.getBio(), guildMember.getBanner(), null, 5119);
        }
        GuildMember guildMember2 = guildMemberA;
        if (!m.areEqual(guildMember2, guildMember)) {
            Map<Long, GuildMember> map2 = this.guildMembers.get(Long.valueOf(guildId));
            m.checkNotNull(map2);
            map2.put(Long.valueOf(id2), guildMember2);
        }
        com.discord.models.member.GuildMember guildMemberFrom$default = GuildMember$Companion.from$default(com.discord.models.member.GuildMember.Companion, guildMember2, guildId, this.guildRoles.get(Long.valueOf(guildId)), null, 8, null);
        Map<Long, com.discord.models.member.GuildMember> map3 = this.guildMembersComputed.get(Long.valueOf(guildId));
        m.checkNotNull(map3);
        if (!m.areEqual(guildMemberFrom$default, map3.get(Long.valueOf(id2)))) {
            Map<Long, com.discord.models.member.GuildMember> map4 = this.guildMembersComputed.get(Long.valueOf(guildId));
            m.checkNotNull(map4);
            map4.put(Long.valueOf(id2), guildMemberFrom$default);
            markChanged(ComputedMembersUpdate);
        }
    }

    @StoreThread
    public final void handleGuildMemberAdd(GuildMember member) {
        m.checkNotNullParameter(member, "member");
        handleGuildMember$default(this, member, member.getGuildId(), false, 4, null);
    }

    public final void handleGuildMemberCommunicationEnabled(long guildId, long userId) {
        this.dispatcher.schedule(new StoreGuilds$handleGuildMemberCommunicationEnabled$1(this, guildId, userId));
    }

    @StoreThread
    public final void handleGuildMemberRemove(long guildId, long userId) {
        handleGuildMembers(guildId, userId, null, true);
    }

    @StoreThread
    public final void handleGuildMembersChunk(GuildMembersChunk chunk) {
        m.checkNotNullParameter(chunk, "chunk");
        handleGuildMembers(chunk.getGuildId(), 0L, chunk.b(), false);
    }

    @StoreThread
    public final void handleGuildRemove(com.discord.api.guild.Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        handleGuildUnavailable(guild.getId(), guild.getUnavailable(), true);
        handleGuild(guild, true);
        handleGuildRoles(guild.getId(), 0L, null, true);
        handleGuildMembers(guild.getId(), 0L, null, true);
    }

    @StoreThread
    public final void handleGuildRoleCreateOrUpdate(long guildId, GuildRole role) {
        m.checkNotNullParameter(role, "role");
        handleGuildRoles(guildId, 0L, d0.t.m.listOf(role), false);
        handleGuildMembersMap(guildId, this.guildMembers.get(Long.valueOf(guildId)));
        handleHasRoleAndJoinedAt(guildId, this.guildMembers.get(Long.valueOf(guildId)));
    }

    @StoreThread
    public final void handleGuildRoleRemove(long roleId, long guildId) {
        handleGuildRoles(guildId, roleId, null, true);
        handleGuildMembersMap(guildId, this.guildMembers.get(Long.valueOf(guildId)));
        handleHasRoleAndJoinedAt(guildId, this.guildMembers.get(Long.valueOf(guildId)));
    }

    @StoreThread
    public final void handleGuildScheduledEventUsersFetch(List<ApiGuildScheduledEventUser> apiGuildScheduledEventUsers, long guildId) {
        m.checkNotNullParameter(apiGuildScheduledEventUsers, "apiGuildScheduledEventUsers");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = apiGuildScheduledEventUsers.iterator();
        while (it.hasNext()) {
            GuildMember guildMemberA = ((ApiGuildScheduledEventUser) it.next()).a(guildId);
            if (guildMemberA != null) {
                arrayList.add(guildMemberA);
            }
        }
        handleGuildMembers(guildId, 0L, arrayList, false);
    }

    @StoreThread
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        ArrayList arrayList;
        m.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        long jA = threadMemberListUpdate.getGuildId();
        List<ThreadListMember> listB = threadMemberListUpdate.b();
        if (listB != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                GuildMember guildMemberA = ((ThreadListMember) it.next()).getMember();
                if (guildMemberA != null) {
                    arrayList2.add(guildMemberA);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        handleGuildMembers(jA, 0L, arrayList, false);
    }

    @StoreThread
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        ArrayList arrayList;
        m.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        long jB = threadMembersUpdate.getGuildId();
        List<AugmentedThreadMember> listA = threadMembersUpdate.a();
        if (listA != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                GuildMember guildMemberC = ((AugmentedThreadMember) it.next()).getMember();
                if (guildMemberC != null) {
                    arrayList2.add(guildMemberC);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        handleGuildMembers(jB, 0L, arrayList, false);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        this.guilds.putAll(CollectionExtensionsKt.filterNonNullValues(this.guildsCache.get()));
        Map<Long, Map<Long, GuildRole>> map = this.guildRolesCache.get();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map$Entry<Long, Map<Long, GuildRole>>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map$Entry<Long, Map<Long, GuildRole>> next = it.next();
            if (next.getKey() != null) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        for (Map$Entry map$Entry : linkedHashMap.entrySet()) {
            this.guildRoles.put(Long.valueOf(((Number) map$Entry.getKey()).longValue()), h0.toMutableMap((Map) map$Entry.getValue()));
        }
        this.guildsJoinedAt.putAll(this.guildsJoinedAtCache.get());
        markChanged(GuildsUpdate, ComputedMembersUpdate);
        initClearCommunicationDisabledObserver(context);
    }

    public final Observable<List<com.discord.models.member.GuildMember>> observeCommunicationDisabledGuildMembers() {
        Observable<List<com.discord.models.member.GuildMember>> observableR = Observable.j(observeGuildIds(), observeComputed(), StoreGuilds$observeCommunicationDisabledGuildMembers$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Map<Long, com.discord.models.member.GuildMember>>> observeComputed() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{ComputedMembersUpdate}, false, null, null, new StoreGuilds$observeComputed$1(this), 14, null);
    }

    public final Observable<com.discord.models.member.GuildMember> observeComputedMember(long guildId, long userId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{ComputedMembersUpdate}, false, null, null, new StoreGuilds$observeComputedMember$1(this, guildId, userId), 14, null);
    }

    public final Observable<Guild> observeFromChannelId(long channelId) {
        Observable observableY = StoreStream.Companion.getChannels().observeChannel(channelId).Y(new StoreGuilds$observeFromChannelId$1(this));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…ll)\n          }\n        }");
        return observableY;
    }

    public final Observable<Guild> observeGuild(long guildId) {
        Observable<Guild> observableR = observeGuilds().G(new StoreGuilds$observeGuild$1(guildId)).r();
        m.checkNotNullExpressionValue(observableR, "observeGuilds()\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Set<Long>> observeGuildIds() {
        Observable<Set<Long>> observableR = observeGuilds().Y(StoreGuilds$observeGuildIds$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "observeGuilds()\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<com.discord.models.member.GuildMember> observeGuildMember(long guildId, long userId) {
        return observeComputed().G(new StoreGuilds$observeGuildMember$1(guildId, userId)).r();
    }

    public final Observable<Map<Long, com.discord.models.member.GuildMember>> observeGuildMembers(long guildId) {
        return observeComputed().G(new StoreGuilds$observeGuildMembers$1(guildId)).r();
    }

    public final Observable<Map<Long, Guild>> observeGuilds() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{GuildsUpdate}, false, null, null, new StoreGuilds$observeGuilds$1(this), 14, null);
    }

    public final Observable<Map<Long, Long>> observeJoinedAt() {
        Observable<Map<Long, Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{GuildsUpdate}, false, null, null, new StoreGuilds$observeJoinedAt$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Map<Long, GuildRole>>> observeRoles() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{GuildsUpdate}, false, null, null, new StoreGuilds$observeRoles$1(this), 14, null);
    }

    public final Observable<List<GuildRole>> observeSortedRoles(long guildId) {
        Observable<List<GuildRole>> observableR = observeRoles(guildId).Y(StoreGuilds$observeSortedRoles$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "observeRoles(guildId)\n  …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Set<Long>> observeUnavailableGuilds() {
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{GuildsUpdate}, false, null, null, new StoreGuilds$observeUnavailableGuilds$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<GuildVerificationLevel> observeVerificationLevel(long guildId) {
        Observable<GuildVerificationLevel> observableR = observeGuild(guildId).G(StoreGuilds$observeVerificationLevel$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "observeGuild(guildId)\n  …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        SnowflakePartitionMap$CopiablePartitionMap snowflakePartitionMap$CopiablePartitionMap;
        super.snapshotData();
        if (getUpdateSources().contains(GuildsUpdate)) {
            HashMap map = new HashMap(this.guildsJoinedAt);
            this.guildsJoinedAtSnapshot = map;
            Persister.set$default(this.guildsJoinedAtCache, map, false, 2, null);
            this.guildsSnapshot = new HashMap(this.guilds);
            Persister.set$default(this.guildsCache, h0.minus((Map) this.guilds, (Iterable) StoreStream.Companion.getLurking().getLurkingGuildIdsSync()), false, 2, null);
            this.guildsUnavailableSnapshot = new HashSet(this.guildsUnavailable);
            Map<Long, Map<Long, GuildRole>> map2 = this.guildRoles;
            LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(map2.size()));
            Iterator<T> it = map2.entrySet().iterator();
            while (it.hasNext()) {
                Map$Entry map$Entry = (Map$Entry) it.next();
                linkedHashMap.put(map$Entry.getKey(), new HashMap((Map) map$Entry.getValue()));
            }
            this.guildRolesSnapshot = linkedHashMap;
            Persister.set$default(this.guildRolesCache, linkedHashMap, false, 2, null);
        }
        if (getUpdateSources().contains(ComputedMembersUpdate)) {
            HashMap map3 = new HashMap();
            for (Map$Entry<Long, Map<Long, com.discord.models.member.GuildMember>> map$Entry2 : this.guildMembersComputed.entrySet()) {
                Map<Long, com.discord.models.member.GuildMember> value = map$Entry2.getValue();
                if (value.size() < 2000) {
                    map3.put(map$Entry2.getKey(), new HashMap(value));
                } else {
                    if (value instanceof SnowflakePartitionMap$CopiablePartitionMap) {
                        snowflakePartitionMap$CopiablePartitionMap = (SnowflakePartitionMap$CopiablePartitionMap) value;
                    } else {
                        SnowflakePartitionMap$CopiablePartitionMap snowflakePartitionMap$CopiablePartitionMap2 = new SnowflakePartitionMap$CopiablePartitionMap(0, 1, null);
                        snowflakePartitionMap$CopiablePartitionMap2.putAll(value);
                        map$Entry2.setValue(snowflakePartitionMap$CopiablePartitionMap2);
                        snowflakePartitionMap$CopiablePartitionMap = snowflakePartitionMap$CopiablePartitionMap2;
                    }
                    map3.put(map$Entry2.getKey(), snowflakePartitionMap$CopiablePartitionMap.fastCopy());
                }
            }
            this.guildMembersComputedSnapshot = map3;
        }
    }

    public StoreGuilds(StoreUser storeUser, Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.userStore = storeUser;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildsSnapshot = h0.emptyMap();
        this.guildMembersComputedSnapshot = h0.emptyMap();
        this.guildRolesSnapshot = h0.emptyMap();
        this.guildsUnavailableSnapshot = n0.emptySet();
        this.guildsJoinedAtSnapshot = h0.emptyMap();
        this.guilds = new HashMap();
        this.guildMembersComputed = new HashMap();
        this.guildMembers = new HashMap();
        this.guildRoles = new HashMap();
        this.guildsUnavailable = new HashSet();
        this.guildsJoinedAt = new HashMap();
        this.guildsCache = new Persister<>("STORE_GUILDS_V34", new HashMap());
        this.guildRolesCache = new Persister<>("STORE_GUILD_ROLES_V7", new HashMap());
        this.guildsJoinedAtCache = new Persister<>("STORE_GUILD_JOINED_AT_V6", new HashMap());
    }

    public final Observable<Map<Long, com.discord.models.member.GuildMember>> observeComputed(long guildId) {
        Observable<Map<Long, com.discord.models.member.GuildMember>> observableR = observeComputed().G(new StoreGuilds$observeComputed$2(guildId)).r();
        m.checkNotNullExpressionValue(observableR, "observeComputed()\n      …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, GuildRole>> observeRoles(long guildId) {
        Observable<Map<Long, GuildRole>> observableR = observeRoles().G(new StoreGuilds$observeRoles$2(guildId)).r();
        m.checkNotNullExpressionValue(observableR, "observeRoles()\n        .…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Long> observeJoinedAt(long guildId) {
        Observable<Long> observableR = observeJoinedAt().G(new StoreGuilds$observeJoinedAt$2(guildId)).r();
        m.checkNotNullExpressionValue(observableR, "observeJoinedAt()\n      …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, com.discord.models.member.GuildMember>> observeComputed(long guildId, Collection<Long> userIds) {
        m.checkNotNullParameter(userIds, "userIds");
        Observable observableK = observeComputed(guildId).k(o.a(userIds));
        m.checkNotNullExpressionValue(observableK, "observeComputed(guildId)…mpose(filterMap(userIds))");
        return observableK;
    }

    public final Observable<Map<Long, GuildRole>> observeRoles(long guildId, Collection<Long> roleIds) {
        m.checkNotNullParameter(roleIds, "roleIds");
        Observable observableK = observeRoles(guildId).k(o.a(roleIds));
        m.checkNotNullExpressionValue(observableK, "observeRoles(guildId)\n  …mpose(filterMap(roleIds))");
        return observableK;
    }
}
