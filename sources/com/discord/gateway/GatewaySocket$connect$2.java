package com.discord.gateway;

import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.websocket.WebSocket;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$connect$2 extends o implements Function1<WebSocket, Unit> {
    public static final GatewaySocket$connect$2 INSTANCE = new GatewaySocket$connect$2();

    public GatewaySocket$connect$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
        invoke2(webSocket);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WebSocket webSocket) {
        if (webSocket != null) {
            webSocket.disconnect(SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM, "Connect called with an existing web socket.");
        }
    }
}
