package com.discord.stores;

import d0.z.d.o;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreThreadsActive.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadsActive$observeThreadSyncedGuilds$1 extends o implements Function0<Set<? extends Long>> {
    public final /* synthetic */ StoreThreadsActive this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadsActive$observeThreadSyncedGuilds$1(StoreThreadsActive storeThreadsActive) {
        super(0);
        this.this$0 = storeThreadsActive;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends Long> invoke2() {
        return StoreThreadsActive.access$getThreadSyncedGuildsSnapshot$p(this.this$0);
    }
}
