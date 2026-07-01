package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreThreadsActive.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadsActive$observeIsThreadSyncedGuild$1 extends o implements Function0<Boolean> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreThreadsActive this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadsActive$observeIsThreadSyncedGuild$1(StoreThreadsActive storeThreadsActive, long j) {
        super(0);
        this.this$0 = storeThreadsActive;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return StoreThreadsActive.access$getThreadSyncedGuildsSnapshot$p(this.this$0).contains(Long.valueOf(this.$guildId));
    }
}
