package com.discord.stores;

import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreThreadsActiveJoined.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadsActiveJoined$observeAllActiveJoinedThreadsById$1 extends o implements Function0<Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread>> {
    public final /* synthetic */ StoreThreadsActiveJoined this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadsActiveJoined$observeAllActiveJoinedThreadsById$1(StoreThreadsActiveJoined storeThreadsActiveJoined) {
        super(0);
        this.this$0 = storeThreadsActiveJoined;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread> invoke2() {
        return StoreThreadsActiveJoined.access$getActiveJoinedThreadsByThreadIdSnapshot$p(this.this$0);
    }
}
