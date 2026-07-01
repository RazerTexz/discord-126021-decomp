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
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* JADX INFO: compiled from: StoreThreadMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadMembers extends StoreV2 {
    private final Map<Long, Set<Long>> memberLists;
    private HashMap<Long, Set<Long>> memberListsSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;

    /* JADX INFO: renamed from: com.discord.stores.StoreThreadMembers$observeThreadMembers$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreThreadMembers.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Set<? extends Long>> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Long> invoke() {
            Set<? extends Long> set = (Set) StoreThreadMembers.this.memberListsSnapshot.get(Long.valueOf(this.$channelId));
            return set != null ? set : Sets5.emptySet();
        }
    }

    public StoreThreadMembers(ObservationDeck observationDeck, StoreChannels storeChannels) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        this.observationDeck = observationDeck;
        this.storeChannels = storeChannels;
        this.memberLists = new LinkedHashMap();
        this.memberListsSnapshot = new HashMap<>();
    }

    @Store3
    public final void handleConnectionOpen() {
        this.memberLists.clear();
        markChanged();
    }

    @Store3
    public final void handleThreadCreateOrUpdate(Channel channel) {
        ThreadMetadata threadMetadata;
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (this.memberLists.containsKey(Long.valueOf(channel.getId())) && (threadMetadata = channel.getThreadMetadata()) != null && threadMetadata.getArchived()) {
            this.memberLists.remove(Long.valueOf(channel.getId()));
            markChanged();
        }
    }

    @Store3
    public final void handleThreadDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (this.memberLists.containsKey(Long.valueOf(channel.getId()))) {
            this.memberLists.remove(Long.valueOf(channel.getId()));
            markChanged();
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0060  */
    @Store3
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        Set<Long> linkedHashSet;
        Intrinsics3.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        Channel channelInternal$app_productionGoogleRelease = this.storeChannels.getChannelInternal$app_productionGoogleRelease(threadMemberListUpdate.getGuildId(), threadMemberListUpdate.getThreadId());
        if ((channelInternal$app_productionGoogleRelease != null ? Long.valueOf(channelInternal$app_productionGoogleRelease.getParentId()) : null) != null) {
            Map<Long, Set<Long>> map = this.memberLists;
            Long lValueOf = Long.valueOf(channelInternal$app_productionGoogleRelease.getId());
            List<ThreadListMember> listB = threadMemberListUpdate.b();
            if (listB != null) {
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listB, 10));
                Iterator<T> it = listB.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((ThreadListMember) it.next()).getUserId()));
                }
                linkedHashSet = _Collections.toMutableSet(arrayList);
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

    @Store3
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        User user;
        Intrinsics3.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
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
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        Map<Long, Set<Long>> map = this.memberLists;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), _Collections.toSet((Iterable) entry.getValue()));
        }
        this.memberListsSnapshot = new HashMap<>(linkedHashMap);
    }
}
