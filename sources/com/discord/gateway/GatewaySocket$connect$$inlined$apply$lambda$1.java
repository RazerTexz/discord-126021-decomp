package com.discord.gateway;

import com.discord.utilities.websocket.WebSocket$Opened;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$connect$$inlined$apply$lambda$1 extends o implements Function1<WebSocket$Opened, Unit> {
    public final /* synthetic */ String $gatewayUrl$inlined;
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$connect$$inlined$apply$lambda$1(GatewaySocket gatewaySocket, String str) {
        super(1);
        this.this$0 = gatewaySocket;
        this.$gatewayUrl$inlined = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WebSocket$Opened webSocket$Opened) {
        invoke2(webSocket$Opened);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WebSocket$Opened webSocket$Opened) {
        m.checkNotNullParameter(webSocket$Opened, "it");
        GatewaySocket.access$handleWebSocketOpened(this.this$0, this.$gatewayUrl$inlined);
    }
}
