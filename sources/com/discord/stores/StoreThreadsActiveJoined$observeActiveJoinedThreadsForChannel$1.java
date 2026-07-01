package com.discord.stores;

import d0.t.h0;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreThreadsActiveJoined.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadsActiveJoined$observeActiveJoinedThreadsForChannel$1 extends o implements Function0<Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreThreadsActiveJoined this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadsActiveJoined$observeActiveJoinedThreadsForChannel$1(StoreThreadsActiveJoined storeThreadsActiveJoined, long j, long j2) {
        super(0);
        this.this$0 = storeThreadsActiveJoined;
        this.$guildId = j;
        this.$channelId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread> invoke2() {
        Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread> map;
        Map map2 = (Map) StoreThreadsActiveJoined.access$getActiveJoinedThreadsHierarchicalSnapshot$p(this.this$0).get(Long.valueOf(this.$guildId));
        return (map2 == null || (map = (Map) map2.get(Long.valueOf(this.$channelId))) == null) ? h0.emptyMap() : map;
    }
}
