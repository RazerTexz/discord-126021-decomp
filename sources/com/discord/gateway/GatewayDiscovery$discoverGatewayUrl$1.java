package com.discord.gateway;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GatewayDiscovery.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewayDiscovery$discoverGatewayUrl$1 extends o implements Function1<Throwable, Unit> {
    public final /* synthetic */ Function1 $onFailure;
    public final /* synthetic */ GatewayDiscovery this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewayDiscovery$discoverGatewayUrl$1(GatewayDiscovery gatewayDiscovery, Function1 function1) {
        super(1);
        this.this$0 = gatewayDiscovery;
        this.$onFailure = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        m.checkNotNullParameter(th, "throwable");
        GatewayDiscovery.access$setGatewayUrl$p(this.this$0, null);
        GatewayDiscovery$Cache.INSTANCE.setGatewayUrl(null);
        this.$onFailure.invoke(th);
    }
}
