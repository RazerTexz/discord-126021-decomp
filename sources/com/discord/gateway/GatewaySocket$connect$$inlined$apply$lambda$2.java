package com.discord.gateway;

import com.discord.utilities.websocket.WebSocket;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$connect$$inlined$apply$lambda$2 extends Lambda implements Function1<WebSocket.Closed, Unit> {
    public final /* synthetic */ String $gatewayUrl$inlined;
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$connect$$inlined$apply$lambda$2(GatewaySocket gatewaySocket, String str) {
        super(1);
        this.this$0 = gatewaySocket;
        this.$gatewayUrl$inlined = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WebSocket.Closed closed) {
        invoke2(closed);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WebSocket.Closed closed) {
        Intrinsics3.checkNotNullParameter(closed, "it");
        this.this$0.handleWebSocketClose(closed);
    }
}
