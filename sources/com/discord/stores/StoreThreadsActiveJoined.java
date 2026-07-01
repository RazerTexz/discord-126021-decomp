package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.thread.ThreadMemberUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.d0.f;
import d0.t.g0;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreThreadsActiveJoined.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadsActiveJoined extends StoreV2 {
    private final Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread> activeJoinedThreads;
    private Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread> activeJoinedThreadsByThreadIdSnapshot;
    private Map<Long, ? extends Map<Long, ? extends Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>>> activeJoinedThreadsHierarchicalSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreThreadsActive storeThreadsActive;
    private final StoreThreadsJoined storeThreadsJoined;

    public /* synthetic */ StoreThreadsActiveJoined(StoreThreadsActive storeThreadsActive, StoreThreadsJoined storeThreadsJoined, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeThreadsActive, storeThreadsJoined, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Map access$getActiveJoinedThreadsByThreadIdSnapshot$p(StoreThreadsActiveJoined storeThreadsActiveJoined) {
        return storeThreadsActiveJoined.activeJoinedThreadsByThreadIdSnapshot;
    }

    public static final /* synthetic */ Map access$getActiveJoinedThreadsHierarchicalSnapshot$p(StoreThreadsActiveJoined storeThreadsActiveJoined) {
        return storeThreadsActiveJoined.activeJoinedThreadsHierarchicalSnapshot;
    }

    public static final /* synthetic */ void access$setActiveJoinedThreadsByThreadIdSnapshot$p(StoreThreadsActiveJoined storeThreadsActiveJoined, Map map) {
        storeThreadsActiveJoined.activeJoinedThreadsByThreadIdSnapshot = map;
    }

    public static final /* synthetic */ void access$setActiveJoinedThreadsHierarchicalSnapshot$p(StoreThreadsActiveJoined storeThreadsActiveJoined, Map map) {
        storeThreadsActiveJoined.activeJoinedThreadsHierarchicalSnapshot = map;
    }

    @StoreThread
    private final void saveThreads(Long guildId) {
        Channel channel;
        Map<Long, Map<Long, Channel>> allActiveThreadsInternal$app_productionGoogleRelease = this.storeThreadsActive.getAllActiveThreadsInternal$app_productionGoogleRelease();
        for (StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread : this.storeThreadsJoined.getAllJoinedThreadsInternal$app_productionGoogleRelease().values()) {
            if (guildId == null || storeThreadsJoined$JoinedThread.getGuildId() == guildId.longValue()) {
                Map<Long, Channel> map = allActiveThreadsInternal$app_productionGoogleRelease.get(Long.valueOf(storeThreadsJoined$JoinedThread.getGuildId()));
                if (map != null && (channel = map.get(Long.valueOf(storeThreadsJoined$JoinedThread.getThreadId()))) != null) {
                    this.activeJoinedThreads.put(Long.valueOf(channel.getId()), new StoreThreadsActiveJoined$ActiveJoinedThread(channel, storeThreadsJoined$JoinedThread.getJoinTimestamp(), storeThreadsJoined$JoinedThread.getMuted()));
                    markChanged();
                }
            }
        }
    }

    public static /* synthetic */ void saveThreads$default(StoreThreadsActiveJoined storeThreadsActiveJoined, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        storeThreadsActiveJoined.saveThreads(l);
    }

    @StoreThread
    private final void updateThread(long guildId, long channelId) {
        Map<Long, Channel> map = this.storeThreadsActive.getAllActiveThreadsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        Channel channel = map != null ? map.get(Long.valueOf(channelId)) : null;
        StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread = this.storeThreadsJoined.getAllJoinedThreadsInternal$app_productionGoogleRelease().get(Long.valueOf(channelId));
        if (channel != null && storeThreadsJoined$JoinedThread != null) {
            this.activeJoinedThreads.put(Long.valueOf(channelId), new StoreThreadsActiveJoined$ActiveJoinedThread(channel, storeThreadsJoined$JoinedThread.getJoinTimestamp(), storeThreadsJoined$JoinedThread.getMuted()));
            markChanged();
        } else if (this.activeJoinedThreads.containsKey(Long.valueOf(channelId))) {
            this.activeJoinedThreads.remove(Long.valueOf(channelId));
            markChanged();
        }
    }

    @StoreThread
    public final List<Channel> getActiveJoinedThreadsForChannelInternal$app_productionGoogleRelease(long channelId) {
        Collection<StoreThreadsActiveJoined$ActiveJoinedThread> collectionValues = this.activeJoinedThreads.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((StoreThreadsActiveJoined$ActiveJoinedThread) obj).getChannel().getParentId() == channelId) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((StoreThreadsActiveJoined$ActiveJoinedThread) it.next()).getChannel());
        }
        return arrayList2;
    }

    @StoreThread
    public final Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread> getActiveJoinedThreadsInternal$app_productionGoogleRelease() {
        return this.activeJoinedThreads;
    }

    @StoreThread
    public final void handleChannelCreateOrUpdate(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        for (Channel channel2 : getActiveJoinedThreadsForChannelInternal$app_productionGoogleRelease(channel.getId())) {
            updateThread(channel2.getGuildId(), channel2.getId());
        }
    }

    @StoreThread
    public final void handleConnectionOpen() {
        this.activeJoinedThreads.clear();
        saveThreads$default(this, null, 1, null);
        markChanged();
    }

    @StoreThread
    public final void handleGuildCreate(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        saveThreads(Long.valueOf(guild.getId()));
    }

    @StoreThread
    public final void handleGuildDelete(long guildId) {
        Iterator<StoreThreadsActiveJoined$ActiveJoinedThread> it = this.activeJoinedThreads.values().iterator();
        while (it.hasNext()) {
            if (it.next().getChannel().getGuildId() == guildId) {
                it.remove();
                markChanged();
            }
        }
    }

    @StoreThread
    public final void handleThreadCreateOrUpdateOrDelete(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        updateThread(channel.getGuildId(), channel.getId());
    }

    @StoreThread
    public final void handleThreadListSync(ModelThreadListSync payload) {
        m.checkNotNullParameter(payload, "payload");
        handleGuildDelete(payload.getGuildId());
        saveThreads(Long.valueOf(payload.getGuildId()));
    }

    @StoreThread
    public final void handleThreadMemberUpdate(ThreadMemberUpdate payload) {
        m.checkNotNullParameter(payload, "payload");
        updateThread(payload.getGuildId(), payload.getId());
    }

    @StoreThread
    public final void handleThreadMembersUpdate(ThreadMembersUpdate payload) {
        m.checkNotNullParameter(payload, "payload");
        updateThread(payload.getGuildId(), payload.getId());
    }

    public final Observable<Map<Long, Channel>> observeActiveJoinedThreadsChannelsForGuild(long guildId) {
        Observable<Map<Long, Channel>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreThreadsActiveJoined$observeActiveJoinedThreadsChannelsForGuild$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>> observeActiveJoinedThreadsForChannel(long guildId, long channelId) {
        Observable<Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreThreadsActiveJoined$observeActiveJoinedThreadsForChannel$1(this, guildId, channelId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>>> observeActiveJoinedThreadsForGuild(long guildId) {
        Observable<Map<Long, Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreThreadsActiveJoined$observeActiveJoinedThreadsForGuild$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>> observeAllActiveJoinedThreadsById() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreThreadsActiveJoined$observeAllActiveJoinedThreadsById$1(this), 14, null);
    }

    public final Observable<Map<Long, Channel>> observeAllActiveJoinedThreadsChannelsById() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreThreadsActiveJoined$observeAllActiveJoinedThreadsChannelsById$1(this), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.activeJoinedThreadsByThreadIdSnapshot = new HashMap(this.activeJoinedThreads);
        Collection<StoreThreadsActiveJoined$ActiveJoinedThread> collectionValues = this.activeJoinedThreads.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : collectionValues) {
            Long lValueOf = Long.valueOf(((StoreThreadsActiveJoined$ActiveJoinedThread) obj).getChannel().getGuildId());
            Object arrayList = linkedHashMap.get(lValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(lValueOf, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(linkedHashMap.size()));
        for (Map$Entry map$Entry : linkedHashMap.entrySet()) {
            Object key = map$Entry.getKey();
            List list = (List) map$Entry.getValue();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Object obj2 : list) {
                Long lValueOf2 = Long.valueOf(((StoreThreadsActiveJoined$ActiveJoinedThread) obj2).getChannel().getParentId());
                Object arrayList2 = linkedHashMap3.get(lValueOf2);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap3.put(lValueOf2, arrayList2);
                }
                ((List) arrayList2).add(obj2);
            }
            LinkedHashMap linkedHashMap4 = new LinkedHashMap(g0.mapCapacity(linkedHashMap3.size()));
            for (Map$Entry map$Entry2 : linkedHashMap3.entrySet()) {
                Object key2 = map$Entry2.getKey();
                List list2 = (List) map$Entry2.getValue();
                LinkedHashMap linkedHashMap5 = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(list2, 10)), 16));
                for (Object obj3 : list2) {
                    linkedHashMap5.put(Long.valueOf(((StoreThreadsActiveJoined$ActiveJoinedThread) obj3).getChannel().getId()), obj3);
                }
                linkedHashMap4.put(key2, linkedHashMap5);
            }
            linkedHashMap2.put(key, linkedHashMap4);
        }
        this.activeJoinedThreadsHierarchicalSnapshot = linkedHashMap2;
    }

    public StoreThreadsActiveJoined(StoreThreadsActive storeThreadsActive, StoreThreadsJoined storeThreadsJoined, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        m.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeThreadsActive = storeThreadsActive;
        this.storeThreadsJoined = storeThreadsJoined;
        this.observationDeck = observationDeck;
        this.activeJoinedThreads = new HashMap();
        this.activeJoinedThreadsByThreadIdSnapshot = new HashMap();
        this.activeJoinedThreadsHierarchicalSnapshot = new HashMap();
    }
}
