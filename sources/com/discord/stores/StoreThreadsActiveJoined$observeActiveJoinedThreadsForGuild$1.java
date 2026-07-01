package com.discord.stores;

import d0.t.h0;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreThreadsActiveJoined.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadsActiveJoined$observeActiveJoinedThreadsForGuild$1 extends o implements Function0<Map<Long, ? extends Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread>>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreThreadsActiveJoined this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadsActiveJoined$observeActiveJoinedThreadsForGuild$1(StoreThreadsActiveJoined storeThreadsActiveJoined, long j) {
        super(0);
        this.this$0 = storeThreadsActiveJoined;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread>> invoke2() {
        Map<Long, ? extends Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread>> map = (Map) StoreThreadsActiveJoined.access$getActiveJoinedThreadsHierarchicalSnapshot$p(this.this$0).get(Long.valueOf(this.$guildId));
        return map != null ? map : h0.emptyMap();
    }
}
