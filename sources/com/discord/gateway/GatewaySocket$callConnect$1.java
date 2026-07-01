package com.discord.gateway;

import b.d.b.a.a;
import com.discord.gateway.io.Outgoing;
import com.discord.gateway.io.OutgoingPayload$CallConnect;
import com.discord.gateway.opcodes.Opcode;
import com.discord.utilities.logging.Logger;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$callConnect$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$callConnect$1(GatewaySocket gatewaySocket, long j) {
        super(0);
        this.this$0 = gatewaySocket;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        GatewaySocket$Companion gatewaySocket$Companion = GatewaySocket.Companion;
        Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(this.this$0);
        StringBuilder sbU = a.U("Sending call connect sync on channel id: ");
        sbU.append(this.$channelId);
        sbU.append('.');
        GatewaySocket$Companion.log$default(gatewaySocket$Companion, loggerAccess$getLogger$p, sbU.toString(), false, 2, null);
        GatewaySocket.send$default(this.this$0, new Outgoing(Opcode.CALL_CONNECT, new OutgoingPayload$CallConnect(this.$channelId)), false, null, 6, null);
    }
}
