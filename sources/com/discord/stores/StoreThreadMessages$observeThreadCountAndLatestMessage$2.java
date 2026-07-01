package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreThreadMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadMessages$observeThreadCountAndLatestMessage$2 extends o implements Function0<StoreThreadMessages$ThreadState> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreThreadMessages this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadMessages$observeThreadCountAndLatestMessage$2(StoreThreadMessages storeThreadMessages, long j) {
        super(0);
        this.this$0 = storeThreadMessages;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreThreadMessages$ThreadState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreThreadMessages$ThreadState invoke() {
        return (StoreThreadMessages$ThreadState) StoreThreadMessages.access$getThreadsSnapshot$p(this.this$0).get(Long.valueOf(this.$channelId));
    }
}
