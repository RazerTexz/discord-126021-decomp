package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadListMember;
import com.discord.api.thread.ThreadMemberListUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.thread.ThreadMetadata;
import com.discord.api.user.User;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import d0.t.g0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import rx.Observable;

/* JADX INFO: compiled from: StoreThreadMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadMembers extends StoreV2 {
    private final Map<Long, Set<Long>> memberLists;
    private HashMap<Long, Set<Long>> memberListsSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;

    public StoreThreadMembers(ObservationDeck observationDeck, StoreChannels storeChannels) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        this.observationDeck = observationDeck;
        this.storeChannels = storeChannels;
        this.memberLists = new LinkedHashMap();
        this.memberListsSnapshot = new HashMap<>();
    }

    public static final /* synthetic */ HashMap access$getMemberListsSnapshot$p(StoreThreadMembers storeThreadMembers) {
        return storeThreadMembers.memberListsSnapshot;
    }

    public static final /* synthetic */ void access$setMemberListsSnapshot$p(StoreThreadMembers storeThreadMembers, HashMap map) {
        storeThreadMembers.memberListsSnapshot = map;
    }

    @StoreThread
    public final void handleConnectionOpen() {
        this.memberLists.clear();
        markChanged();
    }

    @StoreThread
    public final void handleThreadCreateOrUpdate(Channel channel) {
        ThreadMetadata threadMetadata;
        m.checkNotNullParameter(channel, "channel");
        if (this.memberLists.containsKey(Long.valueOf(channel.getId())) && (threadMetadata = channel.getThreadMetadata()) != null && threadMetadata.getArchived()) {
            this.memberLists.remove(Long.valueOf(channel.getId()));
            markChanged();
        }
    }

    @StoreThread
    public final void handleThreadDelete(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        if (this.memberLists.containsKey(Long.valueOf(channel.getId()))) {
            this.memberLists.remove(Long.valueOf(channel.getId()));
            markChanged();
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0060  */
    @StoreThread
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        Set<Long> linkedHashSet;
        m.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        Channel channelInternal$app_productionGoogleRelease = this.storeChannels.getChannelInternal$app_productionGoogleRelease(threadMemberListUpdate.getGuildId(), threadMemberListUpdate.getThreadId());
        if ((channelInternal$app_productionGoogleRelease != null ? Long.valueOf(channelInternal$app_productionGoogleRelease.getParentId()) : null) != null) {
            Map<Long, Set<Long>> map = this.memberLists;
            Long lValueOf = Long.valueOf(channelInternal$app_productionGoogleRelease.getId());
            List<ThreadListMember> listB = threadMemberListUpdate.b();
            if (listB != null) {
                ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listB, 10));
                Iterator<T> it = listB.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((ThreadListMember) it.next()).getUserId()));
                }
                linkedHashSet = u.toMutableSet(arrayList);
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet<>();
                }
            } else {
                linkedHashSet = new LinkedHashSet<>();
            }
            map.put(lValueOf, linkedHashSet);
            markChanged();
        }
    }

    @StoreThread
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        User user;
        m.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        if (this.memberLists.containsKey(Long.valueOf(threadMembersUpdate.getId()))) {
            List<AugmentedThreadMember> listA = threadMembersUpdate.a();
            if (listA != null) {
                Iterator<T> it = listA.iterator();
                while (it.hasNext()) {
                    GuildMember member = ((AugmentedThreadMember) it.next()).getMember();
                    Long lValueOf = (member == null || (user = member.getUser()) == null) ? null : Long.valueOf(user.getId());
                    if (lValueOf != null) {
                        Set<Long> set = this.memberLists.get(Long.valueOf(threadMembersUpdate.getId()));
                        if (set != null) {
                            set.add(lValueOf);
                        }
                        markChanged();
                    }
                }
            }
            List<Long> listD = threadMembersUpdate.d();
            if (listD != null) {
                Iterator<T> it2 = listD.iterator();
                while (it2.hasNext()) {
                    long jLongValue = ((Number) it2.next()).longValue();
                    Set<Long> set2 = this.memberLists.get(Long.valueOf(threadMembersUpdate.getId()));
                    if (set2 != null) {
                        set2.remove(Long.valueOf(jLongValue));
                    }
                    markChanged();
                }
            }
        }
    }

    public final Observable<Set<Long>> observeThreadMembers(long channelId) {
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreThreadMembers$observeThreadMembers$1(this, channelId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        Map<Long, Set<Long>> map = this.memberLists;
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            linkedHashMap.put(map$Entry.getKey(), u.toSet((Iterable) map$Entry.getValue()));
        }
        this.memberListsSnapshot = new HashMap<>(linkedHashMap);
    }
}
