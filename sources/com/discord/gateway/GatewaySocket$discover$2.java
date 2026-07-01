package com.discord.gateway;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$discover$2 extends o implements Function1<String, Unit> {
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$discover$2(GatewaySocket gatewaySocket) {
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
        String str2;
        m.checkNotNullParameter(str, "gatewayUrl");
        GatewaySocket gatewaySocket = this.this$0;
        Function1 function1Access$getGatewayUrlTransform$p = GatewaySocket.access$getGatewayUrlTransform$p(gatewaySocket);
        if (function1Access$getGatewayUrlTransform$p != null && (str2 = (String) function1Access$getGatewayUrlTransform$p.invoke(str)) != null) {
            str = str2;
        }
        GatewaySocket.access$connect(gatewaySocket, str);
    }
}
