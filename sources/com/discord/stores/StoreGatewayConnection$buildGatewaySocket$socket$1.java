package com.discord.stores;

import com.discord.gateway.GatewaySocket$IdentifyData;
import d0.z.d.k;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreGatewayConnection$buildGatewaySocket$socket$1 extends k implements Function0<GatewaySocket$IdentifyData> {
    public StoreGatewayConnection$buildGatewaySocket$socket$1(StoreGatewayConnection storeGatewayConnection) {
        super(0, storeGatewayConnection, StoreGatewayConnection.class, "getIdentifyData", "getIdentifyData()Lcom/discord/gateway/GatewaySocket$IdentifyData;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GatewaySocket$IdentifyData invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GatewaySocket$IdentifyData invoke() {
        return StoreGatewayConnection.access$getIdentifyData((StoreGatewayConnection) this.receiver);
    }
}
