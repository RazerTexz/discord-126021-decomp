package com.discord.stores;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreThreadsJoined.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadsJoined$deleteThreads$removed$1 extends AbstractC12240o implements Function1<StoreThreadsJoined.JoinedThread, Boolean> {
    public final /* synthetic */ long $guildId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadsJoined$deleteThreads$removed$1(long j) {
        super(1);
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StoreThreadsJoined.JoinedThread joinedThread) {
        return Boolean.valueOf(invoke2(joinedThread));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreThreadsJoined.JoinedThread joinedThread) {
        C12238m.checkNotNullParameter(joinedThread, "joinedThread");
        return joinedThread.getGuildId() == this.$guildId;
    }
}
