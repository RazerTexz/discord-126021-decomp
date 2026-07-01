package com.discord.gateway;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$expeditedHeartbeat$1$1 extends o implements Function1<String, Unit> {
    public final /* synthetic */ GatewaySocket$expeditedHeartbeat$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$expeditedHeartbeat$1$1(GatewaySocket$expeditedHeartbeat$1 gatewaySocket$expeditedHeartbeat$1) {
        super(1);
        this.this$0 = gatewaySocket$expeditedHeartbeat$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        GatewaySocket$Companion.log$default(GatewaySocket.Companion, GatewaySocket.access$getLogger$p(this.this$0.this$0), "Connection backoff reset " + str + '.', false, 2, null);
        GatewaySocket.access$getGatewayBackoff$p(this.this$0.this$0).succeed();
        GatewaySocket.access$setNextReconnectIsImmediate$p(this.this$0.this$0, true);
        if (GatewaySocket.access$getConnectionState$p(this.this$0.this$0) == 1) {
            GatewaySocket.access$discover(this.this$0.this$0);
        }
    }
}
