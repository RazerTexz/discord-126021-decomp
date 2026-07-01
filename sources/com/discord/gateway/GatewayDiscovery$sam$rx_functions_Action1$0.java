package com.discord.gateway;

import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* JADX INFO: compiled from: GatewayDiscovery.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewayDiscovery$sam$rx_functions_Action1$0 implements Action1 {
    private final /* synthetic */ Function1 function;

    public GatewayDiscovery$sam$rx_functions_Action1$0(Function1 function1) {
        this.function = function1;
    }

    @Override // rx.functions.Action1
    public final /* synthetic */ void call(Object obj) {
        m.checkNotNullExpressionValue(this.function.invoke(obj), "invoke(...)");
    }
}
