package com.discord.stores;

import com.discord.gateway.GatewaySocket;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.C12236k;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreGatewayConnection$buildGatewaySocket$socket$1 extends C12236k implements Function0<GatewaySocket.IdentifyData> {
    public StoreGatewayConnection$buildGatewaySocket$socket$1(StoreGatewayConnection storeGatewayConnection) {
        super(0, storeGatewayConnection, StoreGatewayConnection.class, "getIdentifyData", "getIdentifyData()Lcom/discord/gateway/GatewaySocket$IdentifyData;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GatewaySocket.IdentifyData invoke() {
        return ((StoreGatewayConnection) this.receiver).getIdentifyData();
    }
}
