package com.discord.gateway;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GatewayDiscovery.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewayDiscovery$discoverGatewayUrl$2 extends o implements Function1<String, Unit> {
    public final /* synthetic */ GatewayDiscovery$discoverGatewayUrl$1 $handleFailure$1;
    public final /* synthetic */ Function1 $onSuccess;
    public final /* synthetic */ GatewayDiscovery this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewayDiscovery$discoverGatewayUrl$2(GatewayDiscovery gatewayDiscovery, GatewayDiscovery$discoverGatewayUrl$1 gatewayDiscovery$discoverGatewayUrl$1, Function1 function1) {
        super(1);
        this.this$0 = gatewayDiscovery;
        this.$handleFailure$1 = gatewayDiscovery$discoverGatewayUrl$1;
        this.$onSuccess = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        if (str == null) {
            this.$handleFailure$1.invoke2(new Throwable("Malformed gateway url."));
            return;
        }
        GatewayDiscovery.access$setGatewayUrl$p(this.this$0, str);
        GatewayDiscovery$Cache.INSTANCE.setGatewayUrl(str);
        GatewayDiscovery.access$getLog$p(this.this$0).invoke("Discovered gateway url: " + str);
        this.$onSuccess.invoke(str);
    }
}
