package com.discord.stores;

import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserConnections$fetchConnectedAccounts$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $connectedAccounts;
    public final /* synthetic */ StoreUserConnections$fetchConnectedAccounts$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserConnections$fetchConnectedAccounts$1$1(StoreUserConnections$fetchConnectedAccounts$1 storeUserConnections$fetchConnectedAccounts$1, List list) {
        super(0);
        this.this$0 = storeUserConnections$fetchConnectedAccounts$1;
        this.$connectedAccounts = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.this$0.getStream().handleUserConnections(this.$connectedAccounts);
    }
}
