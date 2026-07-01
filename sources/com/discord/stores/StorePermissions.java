package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadMemberUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.search.network.state.SearchState;
import d0.d0.f;
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import rx.Observable;

/* JADX INFO: compiled from: StorePermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePermissions extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final Map<Long, Map<Long, Long>> permissionsForChannels;
    private final Persister<Map<Long, Map<Long, Long>>> permissionsForChannelsCache;
    private Map<Long, Long> permissionsForChannelsFlattenedSnapshot;
    private Map<Long, ? extends Map<Long, Long>> permissionsForChannelsSnapshot;
    private final Map<Long, Long> permissionsForGuilds;
    private final Persister<Map<Long, Long>> permissionsForGuildsCache;
    private Map<Long, Long> permissionsForGuildsSnapshot;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final StoreStageInstances storeStageInstances;
    private final StoreThreadsJoined storeThreadsJoined;
    private final StoreUser storeUser;

    public StorePermissions(StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreThreadsJoined storeThreadsJoined, StoreStageInstances storeStageInstances, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
        m.checkNotNullParameter(storeStageInstances, "storeStageInstances");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeUser = storeUser;
        this.storeChannels = storeChannels;
        this.storeGuilds = storeGuilds;
        this.storeThreadsJoined = storeThreadsJoined;
        this.storeStageInstances = storeStageInstances;
        this.observationDeck = observationDeck;
        this.permissionsForGuilds = new HashMap();
        this.permissionsForGuildsSnapshot = new HashMap();
        this.permissionsForGuildsCache = new Persister<>("STORE_GUILD_PERMISSIONS_V5", new HashMap());
        this.permissionsForChannels = new HashMap();
        this.permissionsForChannelsSnapshot = new HashMap();
        this.permissionsForChannelsCache = new Persister<>("STORE_CHANNEL_PERMISSIONS_BY_GUILD_V5", new HashMap());
        this.permissionsForChannelsFlattenedSnapshot = new HashMap();
    }

    public static final /* synthetic */ Map access$getPermissionsForChannels$p(StorePermissions storePermissions) {
        return storePermissions.permissionsForChannels;
    }

    public static final /* synthetic */ Map access$getPermissionsForChannelsFlattenedSnapshot$p(StorePermissions storePermissions) {
        return storePermissions.permissionsForChannelsFlattenedSnapshot;
    }

    public static final /* synthetic */ Map access$getPermissionsForGuildsSnapshot$p(StorePermissions storePermissions) {
        return storePermissions.permissionsForGuildsSnapshot;
    }

    public static final /* synthetic */ void access$setPermissionsForChannelsFlattenedSnapshot$p(StorePermissions storePermissions, Map map) {
        storePermissions.permissionsForChannelsFlattenedSnapshot = map;
    }

    public static final /* synthetic */ void access$setPermissionsForGuildsSnapshot$p(StorePermissions storePermissions, Map map) {
        storePermissions.permissionsForGuildsSnapshot = map;
    }

    @StoreThread
    private final Map<Long, Long> computeChannelPermissions(long guildId, Iterable<Channel> channels) {
        Guild guild = this.storeGuilds.getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        if (guild == null) {
            return h0.emptyMap();
        }
        Map<Long, GuildMember> map = this.storeGuilds.getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        Map<Long, GuildRole> map2 = this.storeGuilds.getGuildRolesInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        Map<Long, StageInstance> stageInstancesForGuildInternal = this.storeStageInstances.getStageInstancesForGuildInternal(guildId);
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(channels, 10)), 16));
        for (Channel channel : channels) {
            boolean zHasJoinedInternal = this.storeThreadsJoined.hasJoinedInternal(channel.getId());
            Pair pair = d0.o.to(Long.valueOf(channel.getId()), Long.valueOf(ChannelUtils.B(channel) ? Permission.ALL : PermissionUtils.computePermissions(getMeId(), channel, this.storeChannels.getGuildChannelInternal$app_productionGoogleRelease(channel.getGuildId(), channel.getParentId()), guild.getOwnerId(), map != null ? map.get(Long.valueOf(getMeId())) : null, map2, stageInstancesForGuildInternal, zHasJoinedInternal)));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    private final long getMeId() {
        return this.storeUser.getMe().getId();
    }

    @StoreThread
    private final void recomputeAllPermissions() {
        this.permissionsForGuilds.clear();
        this.permissionsForChannels.clear();
        Collection<Channel> collectionValues = this.storeChannels.getThreadsByIdInternal$app_productionGoogleRelease().values();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : collectionValues) {
            Long lValueOf = Long.valueOf(((Channel) obj).getGuildId());
            Object arrayList = linkedHashMap.get(lValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(lValueOf, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        Set<Long> setKeySet = this.storeChannels.getChannelsByGuildInternal$app_productionGoogleRelease().keySet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : setKeySet) {
            if (((Number) obj2).longValue() != 0) {
                arrayList2.add(obj2);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            List listEmptyList = (List) linkedHashMap.get(Long.valueOf(jLongValue));
            if (listEmptyList == null) {
                listEmptyList = n.emptyList();
            }
            updateGuildPermissions(jLongValue, listEmptyList);
        }
    }

    @StoreThread
    private final void restoreFromCache() {
        this.permissionsForGuilds.putAll(this.permissionsForGuildsCache.get());
        this.permissionsForChannels.putAll(this.permissionsForChannelsCache.get());
    }

    @StoreThread
    private final void updateChannelPermissions(Channel channel) {
        if (getMeId() == 0) {
            return;
        }
        long guildId = channel.getGuildId();
        Map<Long, Long> mapEmptyMap = this.permissionsForChannels.get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        this.permissionsForChannels.put(Long.valueOf(guildId), h0.plus(mapEmptyMap, computeChannelPermissions(guildId, d0.t.m.listOf(channel))));
        markChanged();
    }

    @StoreThread
    private final void updateGuildPermissions(long guildId, Collection<Channel> guildThreads) {
        Map<Long, Channel> map;
        Guild guild;
        if (getMeId() == 0 || (map = this.storeChannels.getChannelsByGuildInternal$app_productionGoogleRelease().get(Long.valueOf(guildId))) == null || (guild = this.storeGuilds.getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId))) == null) {
            return;
        }
        Map<Long, GuildMember> map2 = this.storeGuilds.getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        long jComputeNonThreadPermissions = PermissionUtils.computeNonThreadPermissions(getMeId(), guildId, guild.getOwnerId(), map2 != null ? map2.get(Long.valueOf(getMeId())) : null, this.storeGuilds.getGuildRolesInternal$app_productionGoogleRelease().get(Long.valueOf(guildId)), null);
        Long l = this.permissionsForGuilds.get(Long.valueOf(guildId));
        if (l == null || l.longValue() != jComputeNonThreadPermissions) {
            this.permissionsForGuilds.put(Long.valueOf(guildId), Long.valueOf(jComputeNonThreadPermissions));
            markChanged();
        }
        Map<Long, Long> mapComputeChannelPermissions = computeChannelPermissions(guildId, u.plus((Collection) map.values(), (Iterable) guildThreads));
        if (!m.areEqual(this.permissionsForChannels.get(Long.valueOf(guildId)), mapComputeChannelPermissions)) {
            this.permissionsForChannels.put(Long.valueOf(guildId), mapComputeChannelPermissions);
            markChanged();
        }
    }

    public final Map<Long, Long> getGuildPermissions() {
        return this.permissionsForGuildsSnapshot;
    }

    public final Map<Long, Long> getPermissionsByChannel() {
        return this.permissionsForChannelsFlattenedSnapshot;
    }

    @StoreThread
    public final Map<Long, Long> getPermissionsByChannelInternal$app_productionGoogleRelease(long guildId) {
        Map<Long, Long> map = this.permissionsForChannels.get(Long.valueOf(guildId));
        return map != null ? map : h0.emptyMap();
    }

    @StoreThread
    public final void handleChannelOrThreadCreateOrUpdate(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        updateChannelPermissions(channel);
    }

    @StoreThread
    public final void handleChannelOrThreadDelete(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        long guildId = channel.getGuildId();
        Map<Long, Long> mapEmptyMap = this.permissionsForChannels.get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        this.permissionsForChannels.put(Long.valueOf(guildId), h0.minus(mapEmptyMap, Long.valueOf(channel.getId())));
        markChanged();
    }

    @StoreThread
    public final void handleConnectionOpen() {
        recomputeAllPermissions();
        markChanged();
    }

    @StoreThread
    public final void handleGuildAdd(com.discord.api.guild.Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        updateGuildPermissions(guild.getId(), this.storeChannels.getThreadsForGuildInternal$app_productionGoogleRelease(guild.getId()));
    }

    @StoreThread
    public final void handleGuildMemberAdd(com.discord.api.guildmember.GuildMember member) {
        m.checkNotNullParameter(member, "member");
        if (getMeId() != 0 && member.getUser().getId() == getMeId()) {
            updateGuildPermissions(member.getGuildId(), this.storeChannels.getThreadsForGuildInternal$app_productionGoogleRelease(member.getGuildId()));
        }
    }

    @StoreThread
    public final void handleGuildRemove(com.discord.api.guild.Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        long id2 = guild.getId();
        this.permissionsForChannels.remove(Long.valueOf(id2));
        this.permissionsForGuilds.remove(Long.valueOf(id2));
        markChanged();
    }

    @StoreThread
    public final void handleGuildRolesChanged(long guildId) {
        updateGuildPermissions(guildId, this.storeChannels.getThreadsForGuildInternal$app_productionGoogleRelease(guildId));
    }

    @StoreThread
    public final void handleMessagesLoaded(List<Message> messages) {
        m.checkNotNullParameter(messages, "messages");
        if (getMeId() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = messages.iterator();
        while (it.hasNext()) {
            Channel thread = ((Message) it.next()).getThread();
            if (thread != null) {
                arrayList.add(thread);
            }
        }
        Channel channel = (Channel) u.firstOrNull((List) arrayList);
        Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
        if (lValueOf != null) {
            updateGuildPermissions(lValueOf.longValue(), this.storeChannels.getThreadsForGuildInternal$app_productionGoogleRelease(lValueOf.longValue()));
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004a  */
    @StoreThread
    public final void handleSearchFinish(SearchState searchState) {
        Long lValueOf;
        m.checkNotNullParameter(searchState, "searchState");
        if (getMeId() == 0) {
            return;
        }
        List<Message> hits = searchState.getHits();
        if (hits != null) {
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(hits, 10));
            Iterator<T> it = hits.iterator();
            while (it.hasNext()) {
                arrayList.add(((Message) it.next()).getThread());
            }
            Channel channel = (Channel) u.firstOrNull((List) arrayList);
            if (channel != null) {
                lValueOf = Long.valueOf(channel.getGuildId());
            } else {
                lValueOf = null;
            }
        } else {
            lValueOf = null;
        }
        if (lValueOf != null) {
            updateGuildPermissions(lValueOf.longValue(), this.storeChannels.getThreadsForGuildInternal$app_productionGoogleRelease(lValueOf.longValue()));
        }
    }

    @StoreThread
    public final void handleStageInstanceChange(StageInstance stageInstance) {
        Channel channelInternal$app_productionGoogleRelease;
        m.checkNotNullParameter(stageInstance, "stageInstance");
        if (getMeId() == 0 || (channelInternal$app_productionGoogleRelease = this.storeChannels.getChannelInternal$app_productionGoogleRelease(stageInstance.getGuildId(), stageInstance.getChannelId())) == null) {
            return;
        }
        updateChannelPermissions(channelInternal$app_productionGoogleRelease);
    }

    @StoreThread
    public final void handleThreadListSync(ModelThreadListSync threadListSync) {
        m.checkNotNullParameter(threadListSync, "threadListSync");
        if (getMeId() == 0) {
            return;
        }
        updateGuildPermissions(threadListSync.getGuildId(), this.storeChannels.getThreadsForGuildInternal$app_productionGoogleRelease(threadListSync.getGuildId()));
    }

    @StoreThread
    public final void handleThreadMemberUpdate(ThreadMemberUpdate threadMemberUpdate) {
        m.checkNotNullParameter(threadMemberUpdate, "threadMemberUpdate");
        Channel guildChannelInternal$app_productionGoogleRelease = this.storeChannels.getGuildChannelInternal$app_productionGoogleRelease(threadMemberUpdate.getGuildId(), threadMemberUpdate.getId());
        if (guildChannelInternal$app_productionGoogleRelease != null) {
            updateChannelPermissions(guildChannelInternal$app_productionGoogleRelease);
        }
    }

    @StoreThread
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        Channel guildChannelInternal$app_productionGoogleRelease;
        Boolean boolValueOf;
        m.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        if (getMeId() == 0 || (guildChannelInternal$app_productionGoogleRelease = this.storeChannels.getGuildChannelInternal$app_productionGoogleRelease(threadMembersUpdate.getGuildId(), threadMembersUpdate.getId())) == null) {
            return;
        }
        List<AugmentedThreadMember> listA = threadMembersUpdate.a();
        if (listA != null) {
            boolean z2 = true;
            if (!listA.isEmpty()) {
                Iterator<T> it = listA.iterator();
                do {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                } while (!(((AugmentedThreadMember) it.next()).getUserId() == getMeId()));
            } else {
                z2 = false;
                break;
            }
            boolValueOf = Boolean.valueOf(z2);
        } else {
            boolValueOf = null;
        }
        List<Long> listD = threadMembersUpdate.d();
        Boolean boolValueOf2 = listD != null ? Boolean.valueOf(listD.contains(Long.valueOf(getMeId()))) : null;
        Boolean bool = Boolean.TRUE;
        if (m.areEqual(boolValueOf, bool) || m.areEqual(boolValueOf2, bool)) {
            updateChannelPermissions(guildChannelInternal$app_productionGoogleRelease);
        }
    }

    @StoreThread
    public final void init() {
        restoreFromCache();
        markChanged();
    }

    public final Observable<Map<Long, Map<Long, Long>>> observeAllPermissions() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StorePermissions$observeAllPermissions$1(this), 14, null);
    }

    public final Observable<Map<Long, Long>> observeChannelPermissionsForGuild(long guildId) {
        Observable<Map<Long, Long>> observableR = observeAllPermissions().G(new StorePermissions$observeChannelPermissionsForGuild$1(guildId)).r();
        m.checkNotNullExpressionValue(observableR, "observeAllPermissions()\n…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Long>> observePermissionsForAllChannels() {
        Observable<Map<Long, Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StorePermissions$observePermissionsForAllChannels$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Long> observePermissionsForChannel(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StorePermissions$observePermissionsForChannel$1(this, channelId), 14, null);
    }

    public final Observable<Long> observePermissionsForGuild(long guildId) {
        Observable<Long> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StorePermissions$observePermissionsForGuild$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        Iterator<T> it = this.permissionsForChannels.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((Map) it.next()).size();
        }
        HashMap map = new HashMap(size, 0.75f);
        Iterator<T> it2 = this.permissionsForChannels.values().iterator();
        while (it2.hasNext()) {
            map.putAll((Map) it2.next());
        }
        this.permissionsForGuildsSnapshot = CollectionExtensionsKt.snapshot$default(this.permissionsForGuilds, 0, 0.0f, 3, null);
        this.permissionsForChannelsSnapshot = CollectionExtensionsKt.snapshot$default(this.permissionsForChannels, 0, 0.0f, 3, null);
        this.permissionsForChannelsFlattenedSnapshot = map;
        this.permissionsForGuildsCache.set(this.permissionsForGuilds, true);
        this.permissionsForChannelsCache.set(this.permissionsForChannels, true);
    }
}
