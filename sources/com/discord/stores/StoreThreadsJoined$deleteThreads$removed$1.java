package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreThreadsJoined.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadsJoined$deleteThreads$removed$1 extends o implements Function1<StoreThreadsJoined$JoinedThread, Boolean> {
    public final /* synthetic */ long $guildId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadsJoined$deleteThreads$removed$1(long j) {
        super(1);
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread) {
        return Boolean.valueOf(invoke2(storeThreadsJoined$JoinedThread));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread) {
        m.checkNotNullParameter(storeThreadsJoined$JoinedThread, "joinedThread");
        return storeThreadsJoined$JoinedThread.getGuildId() == this.$guildId;
    }
}
