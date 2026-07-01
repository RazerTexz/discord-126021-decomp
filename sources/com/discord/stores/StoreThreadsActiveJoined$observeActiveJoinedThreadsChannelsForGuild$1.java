package com.discord.stores;

import com.discord.api.channel.Channel;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.o;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreThreadsActiveJoined.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadsActiveJoined$observeActiveJoinedThreadsChannelsForGuild$1 extends o implements Function0<Map<Long, ? extends Channel>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreThreadsActiveJoined this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadsActiveJoined$observeActiveJoinedThreadsChannelsForGuild$1(StoreThreadsActiveJoined storeThreadsActiveJoined, long j) {
        super(0);
        this.this$0 = storeThreadsActiveJoined;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends Channel> invoke2() {
        Collection<Map> collectionValues;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map map = (Map) StoreThreadsActiveJoined.access$getActiveJoinedThreadsHierarchicalSnapshot$p(this.this$0).get(Long.valueOf(this.$guildId));
        if (map != null && (collectionValues = map.values()) != null) {
            for (Map map2 : collectionValues) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(map2.size()));
                for (Map$Entry map$Entry : map2.entrySet()) {
                    linkedHashMap2.put(map$Entry.getKey(), ((StoreThreadsActiveJoined$ActiveJoinedThread) map$Entry.getValue()).getChannel());
                }
                linkedHashMap.putAll(linkedHashMap2);
            }
        }
        return h0.toMap(linkedHashMap);
    }
}
