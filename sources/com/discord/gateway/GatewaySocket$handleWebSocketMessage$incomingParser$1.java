package com.discord.gateway;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$handleWebSocketMessage$incomingParser$1 extends AbstractC12240o implements Function1<String, Unit> {
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$handleWebSocketMessage$incomingParser$1(GatewaySocket gatewaySocket) {
        super(1);
        this.this$0 = gatewaySocket;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        C12238m.checkNotNullParameter(str, "it");
        GatewaySocket.Companion.log$default(GatewaySocket.INSTANCE, this.this$0.logger, str, false, 2, null);
    }
}
