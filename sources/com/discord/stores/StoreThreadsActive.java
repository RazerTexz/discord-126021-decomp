package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.thread.ThreadMetadata;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t.Sets5;
import d0.t._Collections;
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

    /* JADX INFO: renamed from: com.discord.stores.StoreThreadsActive$observeActiveThreadsForChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreThreadsActive.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Channel>> {
        public final /* synthetic */ Long $channelId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Long l) {
            super(0);
            this.$guildId = j;
            this.$channelId = l;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Channel> invoke() {
            return StoreThreadsActive.this.getActiveThreadsForChannel(this.$guildId, this.$channelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreThreadsActive$observeActiveThreadsForGuild$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreThreadsActive.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Channel>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Channel> invoke() {
            return StoreThreadsActive.this.getActiveThreadsForGuild(this.$guildId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreThreadsActive$observeAllActiveForumThreadsById$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreThreadsActive.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Channel>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Channel> invoke() {
            return StoreThreadsActive.this.forumThreadsByIdSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreThreadsActive$observeAllActiveThreadsById$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreThreadsActive.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Channel>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Channel> invoke() {
            return StoreThreadsActive.this.threadsByIdSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreThreadsActive$observeChannelsWithActiveThreadsByGuild$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreThreadsActive.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Set<? extends Long>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Long> invoke() {
            return StoreThreadsActive.this.getChannelsWithActiveThreadsByGuild(this.$guildId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreThreadsActive$observeIsThreadSyncedGuild$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreThreadsActive.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return StoreThreadsActive.this.threadSyncedGuildsSnapshot.contains(Long.valueOf(this.$guildId));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreThreadsActive$observeThreadSyncedGuilds$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreThreadsActive.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Set<? extends Long>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Long> invoke() {
            return StoreThreadsActive.this.threadSyncedGuildsSnapshot;
        }
    }

    public /* synthetic */ StoreThreadsActive(StoreChannels storeChannels, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeChannels, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    private final void deleteThread(Channel channel) {
        Map map = (Map) outline.c(channel, this.threadsByGuild);
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
            return Maps6.emptyMap();
        }
        Map<Long, Channel> mapEmptyMap = this.threadsByGuildSnapshot.get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Channel> entry : mapEmptyMap.entrySet()) {
            if (entry.getValue().getParentId() == channelId.longValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    private final Map<Long, Channel> getActiveThreadsForGuild(long guildId) {
        Map<Long, Channel> map = this.threadsByGuildSnapshot.get(Long.valueOf(guildId));
        return map != null ? map : Maps6.emptyMap();
    }

    private final Set<Long> getChannelsWithActiveThreadsByGuild(long guildId) {
        Map<Long, Channel> mapEmptyMap = this.threadsByGuildSnapshot.get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        ArrayList arrayList = new ArrayList(mapEmptyMap.size());
        Iterator<Map.Entry<Long, Channel>> it = mapEmptyMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().getValue().getParentId()));
        }
        return _Collections.toSet(arrayList);
    }

    @Store3
    private final void rebuildThreadByIdMaps() {
        this.threadsById.clear();
        this.forumThreadsById.clear();
        for (Map.Entry<Long, Map<Long, Channel>> entry : this.threadsByGuild.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            for (Map.Entry<Long, Channel> entry2 : entry.getValue().entrySet()) {
                long jLongValue2 = entry2.getKey().longValue();
                Channel value = entry2.getValue();
                this.threadsById.put(Long.valueOf(jLongValue2), value);
                if (ChannelUtils.r(value, this.storeChannels.getChannelInternal$app_productionGoogleRelease(jLongValue, value.getParentId()))) {
                    this.forumThreadsById.put(Long.valueOf(jLongValue2), value);
                }
            }
        }
    }

    @Store3
    private final void syncThreadsFromChannelStore() {
        ThreadMetadata threadMetadata;
        this.threadsByGuild.clear();
        for (Map.Entry<Long, Channel> entry : this.storeChannels.getThreadsByIdInternal$app_productionGoogleRelease().entrySet()) {
            long jLongValue = entry.getKey().longValue();
            Channel value = entry.getValue();
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

    @Store3
    public final Map<Long, Channel> getAllActiveThreadsByIdInternal$app_productionGoogleRelease() {
        return this.threadsById;
    }

    @Store3
    public final Map<Long, Map<Long, Channel>> getAllActiveThreadsInternal$app_productionGoogleRelease() {
        return this.threadsByGuild;
    }

    @Store3
    public final Map<Long, Channel> getAllForumThreadsByIdInternal$app_productionGoogleRelease() {
        return this.forumThreadsById;
    }

    @Store3
    public final void handleChannelCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Map map = (Map) outline.c(channel, this.threadsByGuild);
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

    @Store3
    public final void handleConnectionOpen() {
        this.threadsById.clear();
        this.forumThreadsById.clear();
        this.threadsByGuild.clear();
        this.threadSyncedGuilds.clear();
        syncThreadsFromChannelStore();
        markChanged();
    }

    @Store3
    public final void handleGuildCreate() {
        syncThreadsFromChannelStore();
    }

    @Store3
    public final void handleGuildDelete(long guildId) {
        deleteThreads(guildId);
    }

    @Store3
    public final void handleThreadCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
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

    @Store3
    public final void handleThreadDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        deleteThread(channel);
    }

    @Store3
    public final void handleThreadListSync(ModelThreadListSync payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
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
        Observable<Map<Long, Channel>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId, channelId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Channel>> observeActiveThreadsForGuild(long guildId) {
        Observable<Map<Long, Channel>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Channel>> observeAllActiveForumThreadsById() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Map<Long, Channel>> observeAllActiveThreadsById() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Set<Long>> observeChannelsWithActiveThreadsByGuild(long guildId) {
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeIsThreadSyncedGuild(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null);
    }

    public final Observable<Set<Long>> observeThreadSyncedGuilds() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        this.threadsByIdSnapshot = new HashMap(this.threadsById);
        this.forumThreadsByIdSnapshot = new HashMap(this.forumThreadsById);
        Map<Long, Map<Long, Channel>> map = this.threadsByGuild;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), new HashMap((Map) entry.getValue()));
        }
        this.threadsByGuildSnapshot = linkedHashMap;
        this.threadSyncedGuildsSnapshot = _Collections.toSet(this.threadSyncedGuilds);
    }

    public StoreThreadsActive(StoreChannels storeChannels, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeChannels = storeChannels;
        this.observationDeck = observationDeck;
        this.threadsById = new HashMap();
        this.threadsByIdSnapshot = Maps6.emptyMap();
        this.forumThreadsById = new HashMap();
        this.forumThreadsByIdSnapshot = Maps6.emptyMap();
        this.threadsByGuild = new HashMap();
        this.threadsByGuildSnapshot = Maps6.emptyMap();
        this.threadSyncedGuilds = new LinkedHashSet();
        this.threadSyncedGuildsSnapshot = Sets5.emptySet();
    }
}
