package com.discord.stores;

import d0.z.d.o;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreCallsIncoming.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCallsIncoming$observeIncoming$1 extends o implements Function0<Set<? extends Long>> {
    public final /* synthetic */ StoreCallsIncoming this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreCallsIncoming$observeIncoming$1(StoreCallsIncoming storeCallsIncoming) {
        super(0);
        this.this$0 = storeCallsIncoming;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends Long> invoke2() {
        return this.this$0.getIncomingCalls();
    }
}
