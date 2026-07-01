package com.discord.gateway;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GatewayDiscovery.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GatewayDiscovery$discoverGatewayUrl$3 extends k implements Function1<String, Unit> {
    public final /* synthetic */ GatewayDiscovery$discoverGatewayUrl$2 $handleSuccess$2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewayDiscovery$discoverGatewayUrl$3(GatewayDiscovery$discoverGatewayUrl$2 gatewayDiscovery$discoverGatewayUrl$2) {
        super(1, null, "handleSuccess", "invoke(Ljava/lang/String;)V", 0);
        this.$handleSuccess$2 = gatewayDiscovery$discoverGatewayUrl$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        this.$handleSuccess$2.invoke2(str);
    }
}
