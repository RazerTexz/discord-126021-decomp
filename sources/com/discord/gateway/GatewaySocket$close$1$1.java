package com.discord.gateway;

import com.discord.utilities.websocket.WebSocket;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$close$1$1 extends o implements Function1<WebSocket, Unit> {
    public final /* synthetic */ int $code;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$close$1$1(int i) {
        super(1);
        this.$code = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
        invoke2(webSocket);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WebSocket webSocket) {
        if (webSocket != null) {
            WebSocket.disconnect$default(webSocket, this.$code, null, 2, null);
        }
    }
}
