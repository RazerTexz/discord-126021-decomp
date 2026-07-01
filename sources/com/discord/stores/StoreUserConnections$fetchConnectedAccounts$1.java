package com.discord.stores;

import com.discord.api.connectedaccounts.ConnectedAccount;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserConnections$fetchConnectedAccounts$1 extends o implements Function1<List<? extends ConnectedAccount>, Unit> {
    public final /* synthetic */ StoreUserConnections this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserConnections$fetchConnectedAccounts$1(StoreUserConnections storeUserConnections) {
        super(1);
        this.this$0 = storeUserConnections;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ConnectedAccount> list) {
        invoke2((List<ConnectedAccount>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<ConnectedAccount> list) {
        m.checkNotNullParameter(list, "connectedAccounts");
        this.this$0.getDispatcher().schedule(new StoreUserConnections$fetchConnectedAccounts$1$1(this, list));
    }
}
