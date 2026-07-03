package com.discord.gateway;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$handleHeartbeatTimeout$delay$1 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$handleHeartbeatTimeout$delay$1(GatewaySocket gatewaySocket) {
        super(0);
        this.this$0 = gatewaySocket;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.discover();
    }
}
