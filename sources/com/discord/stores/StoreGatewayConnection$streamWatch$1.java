package com.discord.stores;

import com.discord.gateway.GatewaySocket;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGatewayConnection$streamWatch$1 extends o implements Function1<GatewaySocket, Unit> {
    public final /* synthetic */ String $streamKey;
    public final /* synthetic */ StoreGatewayConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGatewayConnection$streamWatch$1(StoreGatewayConnection storeGatewayConnection, String str) {
        super(1);
        this.this$0 = storeGatewayConnection;
        this.$streamKey = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
        invoke2(gatewaySocket);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GatewaySocket gatewaySocket) {
        m.checkNotNullParameter(gatewaySocket, "it");
        String activeApplicationStreamKeyInternal$app_productionGoogleRelease = StoreGatewayConnection.access$getStream$p(this.this$0).getApplicationStreaming().getActiveApplicationStreamKeyInternal$app_productionGoogleRelease();
        if (activeApplicationStreamKeyInternal$app_productionGoogleRelease != null && (!m.areEqual(activeApplicationStreamKeyInternal$app_productionGoogleRelease, this.$streamKey))) {
            this.this$0.streamDelete(activeApplicationStreamKeyInternal$app_productionGoogleRelease);
        }
        gatewaySocket.streamWatch(this.$streamKey);
    }
}
