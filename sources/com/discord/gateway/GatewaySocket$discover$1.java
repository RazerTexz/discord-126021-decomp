package com.discord.gateway;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$discover$1 extends o implements Function1<GatewaySocket$Listener, Unit> {
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$discover$1(GatewaySocket gatewaySocket) {
        super(1);
        this.this$0 = gatewaySocket;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket$Listener gatewaySocket$Listener) {
        invoke2(gatewaySocket$Listener);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GatewaySocket$Listener gatewaySocket$Listener) {
        m.checkNotNullParameter(gatewaySocket$Listener, "it");
        gatewaySocket$Listener.onConnecting(this.this$0);
    }
}
