package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream$startStoreInitializationTimer$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreStream$startStoreInitializationTimer$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStream$startStoreInitializationTimer$1$1(StoreStream$startStoreInitializationTimer$1 storeStream$startStoreInitializationTimer$1) {
        super(0);
        this.this$0 = storeStream$startStoreInitializationTimer$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.this$0.handleStoreInitializationTimeout();
    }
}
