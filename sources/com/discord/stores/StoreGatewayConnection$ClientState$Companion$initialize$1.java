package com.discord.stores;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function5;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreGatewayConnection$ClientState$Companion$initialize$1 extends k implements Function5<Boolean, String, Long, Boolean, StoreClientDataState$ClientDataState, StoreGatewayConnection$ClientState> {
    public StoreGatewayConnection$ClientState$Companion$initialize$1(StoreGatewayConnection$ClientState$Companion storeGatewayConnection$ClientState$Companion) {
        super(5, storeGatewayConnection$ClientState$Companion, StoreGatewayConnection$ClientState$Companion.class, "create", "create(ZLjava/lang/String;JZLcom/discord/stores/StoreClientDataState$ClientDataState;)Lcom/discord/stores/StoreGatewayConnection$ClientState;", 0);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ StoreGatewayConnection$ClientState invoke(Boolean bool, String str, Long l, Boolean bool2, StoreClientDataState$ClientDataState storeClientDataState$ClientDataState) {
        return invoke(bool.booleanValue(), str, l.longValue(), bool2.booleanValue(), storeClientDataState$ClientDataState);
    }

    public final StoreGatewayConnection$ClientState invoke(boolean z2, String str, long j, boolean z3, StoreClientDataState$ClientDataState storeClientDataState$ClientDataState) {
        m.checkNotNullParameter(storeClientDataState$ClientDataState, "p5");
        return StoreGatewayConnection$ClientState$Companion.access$create((StoreGatewayConnection$ClientState$Companion) this.receiver, z2, str, j, z3, storeClientDataState$ClientDataState);
    }
}
