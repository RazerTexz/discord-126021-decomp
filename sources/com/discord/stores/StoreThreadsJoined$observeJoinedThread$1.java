package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreThreadsJoined.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadsJoined$observeJoinedThread$1 extends o implements Function0<StoreThreadsJoined$JoinedThread> {
    public final /* synthetic */ long $threadId;
    public final /* synthetic */ StoreThreadsJoined this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadsJoined$observeJoinedThread$1(StoreThreadsJoined storeThreadsJoined, long j) {
        super(0);
        this.this$0 = storeThreadsJoined;
        this.$threadId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreThreadsJoined$JoinedThread invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreThreadsJoined$JoinedThread invoke() {
        return this.this$0.getJoinedThread(this.$threadId);
    }
}
