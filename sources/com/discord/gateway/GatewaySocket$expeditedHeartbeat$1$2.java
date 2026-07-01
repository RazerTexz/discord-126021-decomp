package com.discord.gateway;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$expeditedHeartbeat$1$2 extends o implements Function0<Unit> {
    public final /* synthetic */ GatewaySocket$expeditedHeartbeat$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$expeditedHeartbeat$1$2(GatewaySocket$expeditedHeartbeat$1 gatewaySocket$expeditedHeartbeat$1) {
        super(0);
        this.this$0 = gatewaySocket$expeditedHeartbeat$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (GatewaySocket.access$getHeartbeatAck$p(this.this$0.this$0)) {
            return;
        }
        GatewaySocket.access$handleHeartbeatTimeout(this.this$0.this$0);
    }
}
