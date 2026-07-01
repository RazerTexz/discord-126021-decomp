package com.discord.gateway;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$startHeartbeater$1 extends o implements Function0<Unit> {
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$startHeartbeater$1(GatewaySocket gatewaySocket) {
        super(0);
        this.this$0 = gatewaySocket;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (GatewaySocket.access$getHeartbeatAck$p(this.this$0)) {
            GatewaySocket.access$setHeartbeatAck$p(this.this$0, false);
            GatewaySocket gatewaySocket = this.this$0;
            GatewaySocket.access$heartbeat(gatewaySocket, GatewaySocket.access$getSeq$p(gatewaySocket));
        } else {
            if (GatewaySocket.access$getHeartbeatExpeditedTimeout$p(this.this$0).getPending()) {
                return;
            }
            GatewaySocket.access$handleHeartbeatTimeout(this.this$0);
        }
    }
}
