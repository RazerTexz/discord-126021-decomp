package com.discord.gateway;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GatewayDiscovery.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GatewayDiscovery$discoverGatewayUrl$4 extends k implements Function1<Throwable, Unit> {
    public final /* synthetic */ GatewayDiscovery$discoverGatewayUrl$1 $handleFailure$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewayDiscovery$discoverGatewayUrl$4(GatewayDiscovery$discoverGatewayUrl$1 gatewayDiscovery$discoverGatewayUrl$1) {
        super(1, null, "handleFailure", "invoke(Ljava/lang/Throwable;)V", 0);
        this.$handleFailure$1 = gatewayDiscovery$discoverGatewayUrl$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        m.checkNotNullParameter(th, "p1");
        this.$handleFailure$1.invoke2(th);
    }
}
