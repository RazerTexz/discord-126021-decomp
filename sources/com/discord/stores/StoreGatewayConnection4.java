package com.discord.stores;

import com.discord.gateway.GatewaySocket;
import d0.z.d.FunctionReferenceImpl;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.stores.StoreGatewayConnection$buildGatewaySocket$socket$1, reason: use source file name */
/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreGatewayConnection4 extends FunctionReferenceImpl implements Function0<GatewaySocket.IdentifyData> {
    public StoreGatewayConnection4(StoreGatewayConnection storeGatewayConnection) {
        super(0, storeGatewayConnection, StoreGatewayConnection.class, "getIdentifyData", "getIdentifyData()Lcom/discord/gateway/GatewaySocket$IdentifyData;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GatewaySocket.IdentifyData invoke() {
        return ((StoreGatewayConnection) this.receiver).getIdentifyData();
    }
}
