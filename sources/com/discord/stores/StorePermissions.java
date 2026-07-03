package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadMemberUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.search.network.state.SearchState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import p507d0.C12116o;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;

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

    /* JADX INFO: renamed from: com.discord.stores.StorePermissions$observeAllPermissions$1 */
    /* JADX INFO: compiled from: StorePermissions.kt */
    public static final class C63291 extends AbstractC12240o implements Function0<Map<Long, ? extends Map<Long, ? extends Long>>> {
        public C63291() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Map<Long, ? extends Long>> invoke() {
            return StorePermissions.this.permissionsForChannels;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StorePermissions$observePermissionsForAllChannels$1 */
    /* JADX INFO: compiled from: StorePermissions.kt */
    public static final class C63311 extends AbstractC12240o implements Function0<Map<Long, ? extends Long>> {
        public C63311() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Long> invoke() {
            return StorePermissions.this.permissionsForChannelsFlattenedSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StorePermissions$observePermissionsForChannel$1 */
    /* JADX INFO: compiled from: StorePermissions.kt */
    public static final class C63321 extends AbstractC12240o implements Function0<Long> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63321(long j) {
            super(0);
            this.$channelId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return (Long) StorePermissions.this.permissionsForChannelsFlattenedSnapshot.get(Long.valueOf(this.$channelId));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StorePermissions$observePermissionsForGuild$1 */
    /* JADX INFO: compiled from: StorePermissions.kt */
    public static final class C63331 extends AbstractC12240o implements Function0<Long> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63331(long j) {
            super(0);
            this.$guildId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return (Long) StorePermissions.this.permissionsForGuildsSnapshot.get(Long.valueOf(this.$guildId));
        }
    }

    public StorePermissions(StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreThreadsJoined storeThreadsJoined, StoreStageInstances storeStageInstances, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
        C12238m.checkNotNullParameter(storeStageInstances, "storeStageInstances");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
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

    @StoreThread
    private final Map<Long, Long> computeChannelPermissions(long guildId, Iterable<Channel> channels) {
        Guild guild = this.storeGuilds.getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        if (guild == null) {
            return C12136h0.emptyMap();
        }
        Map<Long, GuildMember> map = this.storeGuilds.getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        Map<Long, GuildRole> map2 = this.storeGuilds.getGuildRolesInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        Map<Long, StageInstance> stageInstancesForGuildInternal = this.storeStageInstances.getStageInstancesForGuildInternal(guildId);
        LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(channels, 10)), 16));
        for (Channel channel : channels) {
            boolean zHasJoinedInternal = this.storeThreadsJoined.hasJoinedInternal(channel.getId());
            Pair pairM10073to = C12116o.m10073to(Long.valueOf(channel.getId()), Long.valueOf(ChannelUtils.m7667B(channel) ? Permission.ALL : PermissionUtils.computePermissions(getMeId(), channel, this.storeChannels.getGuildChannelInternal$app_productionGoogleRelease(channel.getGuildId(), channel.getParentId()), guild.getOwnerId(), map != null ? map.get(Long.valueOf(getMeId())) : null, map2, stageInstancesForGuildInternal, zHasJoinedInternal)));
            linkedHashMap.put(pairM10073to.getFirst(), pairM10073to.getSecond());
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
                listEmptyList = C12147n.emptyList();
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
            mapEmptyMap = C12136h0.emptyMap();
        }
        this.permissionsForChannels.put(Long.valueOf(guildId), C12136h0.plus(mapEmptyMap, computeChannelPermissions(guildId, C12145m.listOf(channel))));
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
        Map<Long, Long> mapComputeChannelPermissions = computeChannelPermissions(guildId, C12163u.plus((Collection) map.values(), (Iterable) guildThreads));
        if (!C12238m.areEqual(this.permissionsForChannels.get(Long.valueOf(guildId)), mapComputeChannelPermissions)) {
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
        return map != null ? map : C12136h0.emptyMap();
    }

    @StoreThread
    public final void handleChannelOrThreadCreateOrUpdate(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        updateChannelPermissions(channel);
    }

    @StoreThread
    public final void handleChannelOrThreadDelete(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        long guildId = channel.getGuildId();
        Map<Long, Long> mapEmptyMap = this.permissionsForChannels.get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = C12136h0.emptyMap();
        }
        this.permissionsForChannels.put(Long.valueOf(guildId), C12136h0.minus(mapEmptyMap, Long.valueOf(channel.getId())));
        markChanged();
    }

    @StoreThread
    public final void handleConnectionOpen() {
        recomputeAllPermissions();
        markChanged();
    }

    @StoreThread
    public final void handleGuildAdd(com.discord.api.guild.Guild guild) {
        C12238m.checkNotNullParameter(guild, "guild");
        updateGuildPermissions(guild.getId(), this.storeChannels.getThreadsForGuildInternal$app_productionGoogleRelease(guild.getId()));
    }

    @StoreThread
    public final void handleGuildMemberAdd(com.discord.api.guildmember.GuildMember member) {
        C12238m.checkNotNullParameter(member, "member");
        if (getMeId() != 0 && member.getUser().getId() == getMeId()) {
            updateGuildPermissions(member.getGuildId(), this.storeChannels.getThreadsForGuildInternal$app_productionGoogleRelease(member.getGuildId()));
        }
    }

    @StoreThread
    public final void handleGuildRemove(com.discord.api.guild.Guild guild) {
        C12238m.checkNotNullParameter(guild, "guild");
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
        C12238m.checkNotNullParameter(messages, "messages");
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
        Channel channel = (Channel) C12163u.firstOrNull((List) arrayList);
        Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
        if (lValueOf != null) {
            updateGuildPermissions(lValueOf.longValue(), this.storeChannels.getThreadsForGuildInternal$app_productionGoogleRelease(lValueOf.longValue()));
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004a  */
    @StoreThread
    public final void handleSearchFinish(SearchState searchState) {
        Long lValueOf;
        C12238m.checkNotNullParameter(searchState, "searchState");
        if (getMeId() == 0) {
            return;
        }
        List<Message> hits = searchState.getHits();
        if (hits != null) {
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(hits, 10));
            Iterator<T> it = hits.iterator();
            while (it.hasNext()) {
                arrayList.add(((Message) it.next()).getThread());
            }
            Channel channel = (Channel) C12163u.firstOrNull((List) arrayList);
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
        C12238m.checkNotNullParameter(stageInstance, "stageInstance");
        if (getMeId() == 0 || (channelInternal$app_productionGoogleRelease = this.storeChannels.getChannelInternal$app_productionGoogleRelease(stageInstance.getGuildId(), stageInstance.getChannelId())) == null) {
            return;
        }
        updateChannelPermissions(channelInternal$app_productionGoogleRelease);
    }

    @StoreThread
    public final void handleThreadListSync(ModelThreadListSync threadListSync) {
        C12238m.checkNotNullParameter(threadListSync, "threadListSync");
        if (getMeId() == 0) {
            return;
        }
        updateGuildPermissions(threadListSync.getGuildId(), this.storeChannels.getThreadsForGuildInternal$app_productionGoogleRelease(threadListSync.getGuildId()));
    }

    @StoreThread
    public final void handleThreadMemberUpdate(ThreadMemberUpdate threadMemberUpdate) {
        C12238m.checkNotNullParameter(threadMemberUpdate, "threadMemberUpdate");
        Channel guildChannelInternal$app_productionGoogleRelease = this.storeChannels.getGuildChannelInternal$app_productionGoogleRelease(threadMemberUpdate.getGuildId(), threadMemberUpdate.getId());
        if (guildChannelInternal$app_productionGoogleRelease != null) {
            updateChannelPermissions(guildChannelInternal$app_productionGoogleRelease);
        }
    }

    @StoreThread
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        Channel guildChannelInternal$app_productionGoogleRelease;
        Boolean boolValueOf;
        C12238m.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        if (getMeId() == 0 || (guildChannelInternal$app_productionGoogleRelease = this.storeChannels.getGuildChannelInternal$app_productionGoogleRelease(threadMembersUpdate.getGuildId(), threadMembersUpdate.getId())) == null) {
            return;
        }
        List<AugmentedThreadMember> listM8275a = threadMembersUpdate.m8275a();
        if (listM8275a != null) {
            boolean z2 = true;
            if (!listM8275a.isEmpty()) {
                Iterator<T> it = listM8275a.iterator();
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
        List<Long> listM8278d = threadMembersUpdate.m8278d();
        Boolean boolValueOf2 = listM8278d != null ? Boolean.valueOf(listM8278d.contains(Long.valueOf(getMeId()))) : null;
        Boolean bool = Boolean.TRUE;
        if (C12238m.areEqual(boolValueOf, bool) || C12238m.areEqual(boolValueOf2, bool)) {
            updateChannelPermissions(guildChannelInternal$app_productionGoogleRelease);
        }
    }

    @StoreThread
    public final void init() {
        restoreFromCache();
        markChanged();
    }

    public final Observable<Map<Long, Map<Long, Long>>> observeAllPermissions() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C63291(), 14, null);
    }

    public final Observable<Map<Long, Long>> observeChannelPermissionsForGuild(final long guildId) {
        Observable<Map<Long, Long>> observableM11112r = observeAllPermissions().m11083G(new InterfaceC12589b<Map<Long, ? extends Map<Long, ? extends Long>>, Map<Long, ? extends Long>>() { // from class: com.discord.stores.StorePermissions.observeChannelPermissionsForGuild.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Map<Long, ? extends Long> call(Map<Long, ? extends Map<Long, ? extends Long>> map) {
                return call2((Map<Long, ? extends Map<Long, Long>>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, Long> call2(Map<Long, ? extends Map<Long, Long>> map) {
                C12238m.checkNotNullExpressionValue(map, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS);
                Map<Long, Long> mapEmptyMap = map.get(Long.valueOf(guildId));
                if (mapEmptyMap == null) {
                    mapEmptyMap = C12136h0.emptyMap();
                }
                return mapEmptyMap;
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeAllPermissions()\n…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, Long>> observePermissionsForAllChannels() {
        Observable<Map<Long, Long>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C63311(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Long> observePermissionsForChannel(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C63321(channelId), 14, null);
    }

    public final Observable<Long> observePermissionsForGuild(long guildId) {
        Observable<Long> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C63331(guildId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck\n        …  .distinctUntilChanged()");
        return observableM11112r;
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
