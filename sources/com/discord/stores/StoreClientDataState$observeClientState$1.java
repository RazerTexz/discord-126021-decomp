package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreClientDataState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreClientDataState$observeClientState$1 extends o implements Function0<StoreClientDataState$ClientDataState> {
    public final /* synthetic */ StoreClientDataState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreClientDataState$observeClientState$1(StoreClientDataState storeClientDataState) {
        super(0);
        this.this$0 = storeClientDataState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreClientDataState$ClientDataState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreClientDataState$ClientDataState invoke() {
        return StoreClientDataState.access$getClientDataStateSnapshot$p(this.this$0);
    }
}
