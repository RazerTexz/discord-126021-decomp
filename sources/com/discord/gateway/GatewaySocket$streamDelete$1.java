package com.discord.gateway;

import b.d.b.a.a;
import com.discord.gateway.io.Outgoing;
import com.discord.gateway.io.OutgoingPayload$DeleteStream;
import com.discord.gateway.opcodes.Opcode;
import com.discord.utilities.logging.Logger;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$streamDelete$1 extends o implements Function0<Unit> {
    public final /* synthetic */ String $streamKey;
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$streamDelete$1(GatewaySocket gatewaySocket, String str) {
        super(0);
        this.this$0 = gatewaySocket;
        this.$streamKey = str;
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
        StringBuilder sbU = a.U("Sending STREAM_DELETE: ");
        sbU.append(this.$streamKey);
        GatewaySocket$Companion.log$default(gatewaySocket$Companion, loggerAccess$getLogger$p, sbU.toString(), false, 2, null);
        GatewaySocket.send$default(this.this$0, new Outgoing(Opcode.STREAM_DELETE, new OutgoingPayload$DeleteStream(this.$streamKey)), false, null, 6, null);
    }
}
