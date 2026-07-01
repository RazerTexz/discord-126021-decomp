package com.discord.gateway;

import com.discord.gateway.GatewaySocket;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$handleWebSocketMessage$incomingParser$1 extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$handleWebSocketMessage$incomingParser$1(GatewaySocket gatewaySocket) {
        super(1);
        this.this$0 = gatewaySocket;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "it");
        GatewaySocket.Companion.log$default(GatewaySocket.INSTANCE, this.this$0.logger, str, false, 2, null);
    }
}
