package com.discord.stores;

import com.discord.stores.StoreThreadsJoined;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.stores.StoreThreadsJoined$deleteThreads$removed$1, reason: use source file name */
/* JADX INFO: compiled from: StoreThreadsJoined.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadsJoined2 extends Lambda implements Function1<StoreThreadsJoined.JoinedThread, Boolean> {
    public final /* synthetic */ long $guildId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadsJoined2(long j) {
        super(1);
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StoreThreadsJoined.JoinedThread joinedThread) {
        return Boolean.valueOf(invoke2(joinedThread));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreThreadsJoined.JoinedThread joinedThread) {
        Intrinsics3.checkNotNullParameter(joinedThread, "joinedThread");
        return joinedThread.getGuildId() == this.$guildId;
    }
}
