package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserConnections$observeConnectedAccounts$1 extends o implements Function0<StoreUserConnections$State> {
    public final /* synthetic */ StoreUserConnections this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserConnections$observeConnectedAccounts$1(StoreUserConnections storeUserConnections) {
        super(0);
        this.this$0 = storeUserConnections;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreUserConnections$State invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreUserConnections$State invoke() {
        return this.this$0.getStateSnapshot();
    }
}
