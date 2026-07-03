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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreThreadMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadMembers extends StoreV2 {
    private final Map<Long, Set<Long>> memberLists;
    private HashMap<Long, Set<Long>> memberListsSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;

    /* JADX INFO: renamed from: com.discord.stores.StoreThreadMembers$observeThreadMembers$1 */
    /* JADX INFO: compiled from: StoreThreadMembers.kt */
    public static final class C65321 extends AbstractC12240o implements Function0<Set<? extends Long>> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C65321(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Long> invoke() {
            Set<? extends Long> set = (Set) StoreThreadMembers.this.memberListsSnapshot.get(Long.valueOf(this.$channelId));
            return set != null ? set : C12148n0.emptySet();
        }
    }

    public StoreThreadMembers(ObservationDeck observationDeck, StoreChannels storeChannels) {
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        this.observationDeck = observationDeck;
        this.storeChannels = storeChannels;
        this.memberLists = new LinkedHashMap();
        this.memberListsSnapshot = new HashMap<>();
    }

    @StoreThread
    public final void handleConnectionOpen() {
        this.memberLists.clear();
        markChanged();
    }

    @StoreThread
    public final void handleThreadCreateOrUpdate(Channel channel) {
        ThreadMetadata threadMetadata;
        C12238m.checkNotNullParameter(channel, "channel");
        if (this.memberLists.containsKey(Long.valueOf(channel.getId())) && (threadMetadata = channel.getThreadMetadata()) != null && threadMetadata.getArchived()) {
            this.memberLists.remove(Long.valueOf(channel.getId()));
            markChanged();
        }
    }

    @StoreThread
    public final void handleThreadDelete(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        if (this.memberLists.containsKey(Long.valueOf(channel.getId()))) {
            this.memberLists.remove(Long.valueOf(channel.getId()));
            markChanged();
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0060  */
    @StoreThread
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        Set<Long> linkedHashSet;
        C12238m.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        Channel channelInternal$app_productionGoogleRelease = this.storeChannels.getChannelInternal$app_productionGoogleRelease(threadMemberListUpdate.getGuildId(), threadMemberListUpdate.getThreadId());
        if ((channelInternal$app_productionGoogleRelease != null ? Long.valueOf(channelInternal$app_productionGoogleRelease.getParentId()) : null) != null) {
            Map<Long, Set<Long>> map = this.memberLists;
            Long lValueOf = Long.valueOf(channelInternal$app_productionGoogleRelease.getId());
            List<ThreadListMember> listM8266b = threadMemberListUpdate.m8266b();
            if (listM8266b != null) {
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listM8266b, 10));
                Iterator<T> it = listM8266b.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((ThreadListMember) it.next()).getUserId()));
                }
                linkedHashSet = C12163u.toMutableSet(arrayList);
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
        C12238m.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        if (this.memberLists.containsKey(Long.valueOf(threadMembersUpdate.getId()))) {
            List<AugmentedThreadMember> listM8275a = threadMembersUpdate.m8275a();
            if (listM8275a != null) {
                Iterator<T> it = listM8275a.iterator();
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
            List<Long> listM8278d = threadMembersUpdate.m8278d();
            if (listM8278d != null) {
                Iterator<T> it2 = listM8278d.iterator();
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
        Observable<Set<Long>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C65321(channelId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        Map<Long, Set<Long>> map = this.memberLists;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C12134g0.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), C12163u.toSet((Iterable) entry.getValue()));
        }
        this.memberListsSnapshot = new HashMap<>(linkedHashMap);
    }
}
