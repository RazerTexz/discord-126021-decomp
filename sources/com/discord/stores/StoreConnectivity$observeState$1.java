package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreConnectivity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreConnectivity$observeState$1 extends o implements Function0<StoreConnectivity$DelayedState> {
    public final /* synthetic */ StoreConnectivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreConnectivity$observeState$1(StoreConnectivity storeConnectivity) {
        super(0);
        this.this$0 = storeConnectivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreConnectivity$DelayedState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreConnectivity$DelayedState invoke() {
        return StoreConnectivity.access$getState$p(this.this$0);
    }
}
