package com.discord.stores;

import com.discord.api.channel.Channel;
import d0.t.g0;
import d0.z.d.o;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreThreadsActiveJoined.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadsActiveJoined$observeAllActiveJoinedThreadsChannelsById$1 extends o implements Function0<Map<Long, ? extends Channel>> {
    public final /* synthetic */ StoreThreadsActiveJoined this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadsActiveJoined$observeAllActiveJoinedThreadsChannelsById$1(StoreThreadsActiveJoined storeThreadsActiveJoined) {
        super(0);
        this.this$0 = storeThreadsActiveJoined;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends Channel> invoke2() {
        Map mapAccess$getActiveJoinedThreadsByThreadIdSnapshot$p = StoreThreadsActiveJoined.access$getActiveJoinedThreadsByThreadIdSnapshot$p(this.this$0);
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(mapAccess$getActiveJoinedThreadsByThreadIdSnapshot$p.size()));
        for (Map$Entry map$Entry : mapAccess$getActiveJoinedThreadsByThreadIdSnapshot$p.entrySet()) {
            linkedHashMap.put(map$Entry.getKey(), ((StoreThreadsActiveJoined$ActiveJoinedThread) map$Entry.getValue()).getChannel());
        }
        return linkedHashMap;
    }
}
