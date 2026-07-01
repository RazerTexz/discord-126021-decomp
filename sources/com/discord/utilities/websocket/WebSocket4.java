package com.discord.utilities.websocket;

import com.discord.utilities.websocket.WebSocket;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import okhttp3.Response;

/* JADX INFO: renamed from: com.discord.utilities.websocket.WebSocket$connect$1$onOpen$1, reason: use source file name */
/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocket4 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Response $response;
    public final /* synthetic */ okhttp3.WebSocket $webSocket;
    public final /* synthetic */ WebSocket.AnonymousClass1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocket4(WebSocket.AnonymousClass1 anonymousClass1, okhttp3.WebSocket webSocket, Response response) {
        super(0);
        this.this$0 = anonymousClass1;
        this.$webSocket = webSocket;
        this.$response = response;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WebSocket.this.client = this.$webSocket;
        WebSocket.this.state = WebSocket.State.CONNECTED;
        WebSocket.this.getOnOpened().invoke(new WebSocket.Opened(this.$response));
    }
}
