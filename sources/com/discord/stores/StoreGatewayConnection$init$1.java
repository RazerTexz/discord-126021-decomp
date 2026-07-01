package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGatewayConnection$init$1 extends o implements Function1<StoreGatewayConnection$ClientState, Unit> {
    public final /* synthetic */ StoreGatewayConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGatewayConnection$init$1(StoreGatewayConnection storeGatewayConnection) {
        super(1);
        this.this$0 = storeGatewayConnection;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreGatewayConnection$ClientState storeGatewayConnection$ClientState) {
        invoke2(storeGatewayConnection$ClientState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreGatewayConnection$ClientState storeGatewayConnection$ClientState) {
        m.checkNotNullParameter(storeGatewayConnection$ClientState, "it");
        StoreGatewayConnection.access$handleClientStateUpdate(this.this$0, storeGatewayConnection$ClientState);
    }
}
