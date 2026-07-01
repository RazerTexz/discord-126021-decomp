package com.discord.stores;

import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreThreadMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadMessages$observeThreadCountAndLatestMessage$1 extends o implements Function0<Map<Long, ? extends StoreThreadMessages$ThreadState>> {
    public final /* synthetic */ StoreThreadMessages this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadMessages$observeThreadCountAndLatestMessage$1(StoreThreadMessages storeThreadMessages) {
        super(0);
        this.this$0 = storeThreadMessages;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends StoreThreadMessages$ThreadState> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends StoreThreadMessages$ThreadState> invoke2() {
        return StoreThreadMessages.access$getThreadsSnapshot$p(this.this$0);
    }
}
