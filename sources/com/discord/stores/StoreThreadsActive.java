package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.thread.ThreadMetadata;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.t.g0;
import d0.t.h0;
import d0.t.n0;
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
import rx.Observable;

/* JADX INFO: compiled from: StoreThreadsActive.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadsActive extends StoreV2 {
    private final Map<Long, Channel> forumThreadsById;
    private Map<Long, Channel> forumThreadsByIdSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;
    private final Set<Long> threadSyncedGuilds;
    private Set<Long> threadSyncedGuildsSnapshot;
    private final Map<Long, Map<Long, Channel>> threadsByGuild;
    private Map<Long, ? extends Map<Long, Channel>> threadsByGuildSnapshot;
    private final Map<Long, Channel> threadsById;
    private Map<Long, Channel> threadsByIdSnapshot;

    public /* synthetic */ StoreThreadsActive(StoreChannels storeChannels, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeChannels, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Map access$getActiveThreadsForChannel(StoreThreadsActive storeThreadsActive, long j, Long l) {
        return storeThreadsActive.getActiveThreadsForChannel(j, l);
    }

    public static final /* synthetic */ Map access$getActiveThreadsForGuild(StoreThreadsActive storeThreadsActive, long j) {
        return storeThreadsActive.getActiveThreadsForGuild(j);
    }

    public static final /* synthetic */ Set access$getChannelsWithActiveThreadsByGuild(StoreThreadsActive storeThreadsActive, long j) {
        return storeThreadsActive.getChannelsWithActiveThreadsByGuild(j);
    }

    public static final /* synthetic */ Map access$getForumThreadsByIdSnapshot$p(StoreThreadsActive storeThreadsActive) {
        return storeThreadsActive.forumThreadsByIdSnapshot;
    }

    public static final /* synthetic */ Set access$getThreadSyncedGuildsSnapshot$p(StoreThreadsActive storeThreadsActive) {
        return storeThreadsActive.threadSyncedGuildsSnapshot;
    }

    public static final /* synthetic */ Map access$getThreadsByIdSnapshot$p(StoreThreadsActive storeThreadsActive) {
        return storeThreadsActive.threadsByIdSnapshot;
    }

    public static final /* synthetic */ void access$setForumThreadsByIdSnapshot$p(StoreThreadsActive storeThreadsActive, Map map) {
        storeThreadsActive.forumThreadsByIdSnapshot = map;
    }

    public static final /* synthetic */ void access$setThreadSyncedGuildsSnapshot$p(StoreThreadsActive storeThreadsActive, Set set) {
        storeThreadsActive.threadSyncedGuildsSnapshot = set;
    }

    public static final /* synthetic */ void access$setThreadsByIdSnapshot$p(StoreThreadsActive storeThreadsActive, Map map) {
        storeThreadsActive.threadsByIdSnapshot = map;
    }

    private final void deleteThread(Channel channel) {
        Map map = (Map) a.c(channel, this.threadsByGuild);
        if (map != null && map.containsKey(Long.valueOf(channel.getId()))) {
            map.remove(Long.valueOf(channel.getId()));
            markChanged();
        }
        if (this.threadsById.containsKey(Long.valueOf(channel.getId()))) {
            this.threadsById.remove(Long.valueOf(channel.getId()));
            markChanged();
        }
        if (this.forumThreadsById.containsKey(Long.valueOf(channel.getId()))) {
            this.forumThreadsById.remove(Long.valueOf(channel.getId()));
            markChanged();
        }
    }

    private final void deleteThreads(long guildId) {
        if (this.threadsByGuild.containsKey(Long.valueOf(guildId))) {
            this.threadsByGuild.remove(Long.valueOf(guildId));
            rebuildThreadByIdMaps();
            markChanged();
        }
    }

    private final Map<Long, Channel> getActiveThreadsForChannel(long guildId, Long channelId) {
        if (channelId == null) {
            return h0.emptyMap();
        }
        Map<Long, Channel> mapEmptyMap = this.threadsByGuildSnapshot.get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, Channel> map$Entry : mapEmptyMap.entrySet()) {
            if (map$Entry.getValue().getParentId() == channelId.longValue()) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        return linkedHashMap;
    }

    private final Map<Long, Channel> getActiveThreadsForGuild(long guildId) {
        Map<Long, Channel> map = this.threadsByGuildSnapshot.get(Long.valueOf(guildId));
        return map != null ? map : h0.emptyMap();
    }

    private final Set<Long> getChannelsWithActiveThreadsByGuild(long guildId) {
        Map<Long, Channel> mapEmptyMap = this.threadsByGuildSnapshot.get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        ArrayList arrayList = new ArrayList(mapEmptyMap.size());
        Iterator<Map$Entry<Long, Channel>> it = mapEmptyMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().getValue().getParentId()));
        }
        return u.toSet(arrayList);
    }

    @StoreThread
    private final void rebuildThreadByIdMaps() {
        this.threadsById.clear();
        this.forumThreadsById.clear();
        for (Map$Entry<Long, Map<Long, Channel>> map$Entry : this.threadsByGuild.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            for (Map$Entry<Long, Channel> map$Entry2 : map$Entry.getValue().entrySet()) {
                long jLongValue2 = map$Entry2.getKey().longValue();
                Channel value = map$Entry2.getValue();
                this.threadsById.put(Long.valueOf(jLongValue2), value);
                if (ChannelUtils.r(value, this.storeChannels.getChannelInternal$app_productionGoogleRelease(jLongValue, value.getParentId()))) {
                    this.forumThreadsById.put(Long.valueOf(jLongValue2), value);
                }
            }
        }
    }

    @StoreThread
    private final void syncThreadsFromChannelStore() {
        ThreadMetadata threadMetadata;
        this.threadsByGuild.clear();
        for (Map$Entry<Long, Channel> map$Entry : this.storeChannels.getThreadsByIdInternal$app_productionGoogleRelease().entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            Channel value = map$Entry.getValue();
            if (ChannelUtils.H(value) && ((threadMetadata = value.getThreadMetadata()) == null || !threadMetadata.getArchived())) {
                Map<Long, Map<Long, Channel>> map = this.threadsByGuild;
                Long lValueOf = Long.valueOf(value.getGuildId());
                Map<Long, Channel> map2 = map.get(lValueOf);
                if (map2 == null) {
                    map2 = new HashMap<>();
                    map.put(lValueOf, map2);
                }
                map2.put(Long.valueOf(jLongValue), value);
            }
        }
        rebuildThreadByIdMaps();
        markChanged();
    }

    @StoreThread
    public final Map<Long, Channel> getAllActiveThreadsByIdInternal$app_productionGoogleRelease() {
        return this.threadsById;
    }

    @StoreThread
    public final Map<Long, Map<Long, Channel>> getAllActiveThreadsInternal$app_productionGoogleRelease() {
        return this.threadsByGuild;
    }

    @StoreThread
    public final Map<Long, Channel> getAllForumThreadsByIdInternal$app_productionGoogleRelease() {
        return this.forumThreadsById;
    }

    @StoreThread
    public final void handleChannelCreateOrUpdate(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        Map map = (Map) a.c(channel, this.threadsByGuild);
        if (map != null) {
            Collection collectionValues = map.values();
            ArrayList<Channel> arrayList = new ArrayList();
            Iterator it = collectionValues.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Channel channel2 = (Channel) next;
                if (channel2.getParentId() == channel.getId() && channel2.getNsfw() != channel.getNsfw()) {
                    arrayList.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                for (Channel channel3 : arrayList) {
                    Channel channelInternal$app_productionGoogleRelease = this.storeChannels.getChannelInternal$app_productionGoogleRelease(channel3.getGuildId(), channel3.getId());
                    if (channelInternal$app_productionGoogleRelease != null) {
                        map.put(Long.valueOf(channelInternal$app_productionGoogleRelease.getId()), channelInternal$app_productionGoogleRelease);
                    }
                }
                rebuildThreadByIdMaps();
                markChanged();
            }
        }
    }

    @StoreThread
    public final void handleConnectionOpen() {
        this.threadsById.clear();
        this.forumThreadsById.clear();
        this.threadsByGuild.clear();
        this.threadSyncedGuilds.clear();
        syncThreadsFromChannelStore();
        markChanged();
    }

    @StoreThread
    public final void handleGuildCreate() {
        syncThreadsFromChannelStore();
    }

    @StoreThread
    public final void handleGuildDelete(long guildId) {
        deleteThreads(guildId);
    }

    @StoreThread
    public final void handleThreadCreateOrUpdate(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.H(channel)) {
            ThreadMetadata threadMetadata = channel.getThreadMetadata();
            if (threadMetadata != null && threadMetadata.getArchived()) {
                deleteThread(channel);
                return;
            }
            Map<Long, Map<Long, Channel>> map = this.threadsByGuild;
            Long lValueOf = Long.valueOf(channel.getGuildId());
            Map<Long, Channel> map2 = map.get(lValueOf);
            if (map2 == null) {
                map2 = new HashMap<>();
                map.put(lValueOf, map2);
            }
            map2.put(Long.valueOf(channel.getId()), channel);
            this.threadsById.put(Long.valueOf(channel.getId()), channel);
            if (ChannelUtils.r(channel, this.storeChannels.getChannelInternal$app_productionGoogleRelease(channel.getGuildId(), channel.getParentId()))) {
                this.forumThreadsById.put(Long.valueOf(channel.getId()), channel);
            }
            markChanged();
        }
    }

    @StoreThread
    public final void handleThreadDelete(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        deleteThread(channel);
    }

    @StoreThread
    public final void handleThreadListSync(ModelThreadListSync payload) {
        m.checkNotNullParameter(payload, "payload");
        Map<Long, Map<Long, Channel>> map = this.threadsByGuild;
        Long lValueOf = Long.valueOf(payload.getGuildId());
        Map<Long, Channel> map2 = map.get(lValueOf);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(lValueOf, map2);
        }
        Map<Long, Channel> map3 = map2;
        for (Channel channel : payload.getThreads()) {
            if (ChannelUtils.H(channel)) {
                map3.put(Long.valueOf(channel.getId()), channel);
                this.threadsById.put(Long.valueOf(channel.getId()), channel);
            }
            if (ChannelUtils.r(channel, this.storeChannels.getChannelInternal$app_productionGoogleRelease(channel.getGuildId(), channel.getParentId()))) {
                this.forumThreadsById.put(Long.valueOf(channel.getId()), channel);
            }
        }
        this.threadSyncedGuilds.add(Long.valueOf(payload.getGuildId()));
        markChanged();
    }

    public final Observable<Map<Long, Channel>> observeActiveThreadsForChannel(long guildId, Long channelId) {
        Observable<Map<Long, Channel>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreThreadsActive$observeActiveThreadsForChannel$1(this, guildId, channelId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Channel>> observeActiveThreadsForGuild(long guildId) {
        Observable<Map<Long, Channel>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreThreadsActive$observeActiveThreadsForGuild$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Channel>> observeAllActiveForumThreadsById() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreThreadsActive$observeAllActiveForumThreadsById$1(this), 14, null);
    }

    public final Observable<Map<Long, Channel>> observeAllActiveThreadsById() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreThreadsActive$observeAllActiveThreadsById$1(this), 14, null);
    }

    public final Observable<Set<Long>> observeChannelsWithActiveThreadsByGuild(long guildId) {
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreThreadsActive$observeChannelsWithActiveThreadsByGuild$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeIsThreadSyncedGuild(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreThreadsActive$observeIsThreadSyncedGuild$1(this, guildId), 14, null);
    }

    public final Observable<Set<Long>> observeThreadSyncedGuilds() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreThreadsActive$observeThreadSyncedGuilds$1(this), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.threadsByIdSnapshot = new HashMap(this.threadsById);
        this.forumThreadsByIdSnapshot = new HashMap(this.forumThreadsById);
        Map<Long, Map<Long, Channel>> map = this.threadsByGuild;
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            linkedHashMap.put(map$Entry.getKey(), new HashMap((Map) map$Entry.getValue()));
        }
        this.threadsByGuildSnapshot = linkedHashMap;
        this.threadSyncedGuildsSnapshot = u.toSet(this.threadSyncedGuilds);
    }

    public StoreThreadsActive(StoreChannels storeChannels, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeChannels = storeChannels;
        this.observationDeck = observationDeck;
        this.threadsById = new HashMap();
        this.threadsByIdSnapshot = h0.emptyMap();
        this.forumThreadsById = new HashMap();
        this.forumThreadsByIdSnapshot = h0.emptyMap();
        this.threadsByGuild = new HashMap();
        this.threadsByGuildSnapshot = h0.emptyMap();
        this.threadSyncedGuilds = new LinkedHashSet();
        this.threadSyncedGuildsSnapshot = n0.emptySet();
    }
}
