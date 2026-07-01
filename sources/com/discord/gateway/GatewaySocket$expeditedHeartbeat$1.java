package com.discord.gateway;

import b.d.b.a.a;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$expeditedHeartbeat$1 extends o implements Function0<Unit> {
    public final /* synthetic */ String $reason;
    public final /* synthetic */ boolean $shouldResetBackoff;
    public final /* synthetic */ long $timeout;
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$expeditedHeartbeat$1(GatewaySocket gatewaySocket, String str, long j, boolean z2) {
        super(0);
        this.this$0 = gatewaySocket;
        this.$reason = str;
        this.$timeout = j;
        this.$shouldResetBackoff = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String strH = this.$reason != null ? a.H(a.U("with reason '"), this.$reason, '\'') : "";
        GatewaySocket$expeditedHeartbeat$1$1 gatewaySocket$expeditedHeartbeat$1$1 = new GatewaySocket$expeditedHeartbeat$1$1(this);
        if (GatewaySocket.access$getWebSocket$p(this.this$0) == null) {
            if (this.$shouldResetBackoff) {
                gatewaySocket$expeditedHeartbeat$1$1.invoke2(strH);
                return;
            } else {
                GatewaySocket$Companion.log$default(GatewaySocket.Companion, GatewaySocket.access$getLogger$p(this.this$0), a.y("Expedited heartbeat requested ", strH, ", but disconnected and no reset backoff."), false, 2, null);
                return;
            }
        }
        GatewaySocket$Companion.log$default(GatewaySocket.Companion, GatewaySocket.access$getLogger$p(this.this$0), "Performing an expedited heartbeat " + strH + '.', false, 2, null);
        GatewaySocket gatewaySocket = this.this$0;
        GatewaySocket.access$heartbeat(gatewaySocket, GatewaySocket.access$getSeq$p(gatewaySocket));
        GatewaySocket.access$setHeartbeatAck$p(this.this$0, false);
        GatewaySocket.access$getHeartbeatExpeditedTimeout$p(this.this$0).schedule(new GatewaySocket$expeditedHeartbeat$1$2(this), this.$timeout);
    }
}
