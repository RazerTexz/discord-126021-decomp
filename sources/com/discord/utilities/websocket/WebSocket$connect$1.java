package com.discord.utilities.websocket;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.o;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.m;
import java.io.InputStreamReader;
import java.util.Map;
import okhttp3.Response;

/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocket$connect$1 extends ZLibWebSocketListener$Listener {
    private final RawMessageHandler rawMessageHandler;
    public final /* synthetic */ WebSocket this$0;

    public WebSocket$connect$1(WebSocket webSocket) {
        this.this$0 = webSocket;
        this.rawMessageHandler = webSocket.getRawMessageHandler();
    }

    private final void handleError(Exception exception, String errorMessage, String rawData) {
        Map mapEmptyMap;
        if (rawData == null || (mapEmptyMap = g0.mapOf(o.to("raw_data_string", rawData))) == null) {
            mapEmptyMap = h0.emptyMap();
        }
        WebSocket.access$getErrorLogger$p(this.this$0).invoke(errorMessage, exception, mapEmptyMap);
        WebSocket.access$handleOnFailure(this.this$0, exception, null, false);
    }

    public static /* synthetic */ void handleError$default(WebSocket$connect$1 webSocket$connect$1, Exception exc, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        webSocket$connect$1.handleError(exc, str, str2);
    }

    @Override // com.discord.utilities.websocket.ZLibWebSocketListener$Listener
    public RawMessageHandler getRawMessageHandler() {
        return this.rawMessageHandler;
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(okhttp3.WebSocket webSocket, int code, String reason) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        WebSocket.access$schedule(this.this$0, new WebSocket$connect$1$onClosed$1(this, code, reason));
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(okhttp3.WebSocket webSocket, int code, String reason) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        WebSocket.access$setState$p(this.this$0, WebSocket$State.CLOSING);
        this.this$0.getOnClosed().invoke(new WebSocket$Closed(code, reason));
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(okhttp3.WebSocket webSocket, Throwable t, Response response) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(t, "t");
        WebSocket.access$schedule(this.this$0, new WebSocket$connect$1$onFailure$1(this, t, response));
    }

    @Override // com.discord.utilities.websocket.ZLibWebSocketListener$Listener
    public void onInflateError(Exception e) {
        m.checkNotNullParameter(e, "e");
        handleError$default(this, e, "Unable to inflate message.", null, 4, null);
    }

    @Override // com.discord.utilities.websocket.ZLibWebSocketListener$Listener
    public void onInflatedMessage(okhttp3.WebSocket webSocket, InputStreamReader reader, int compressedByteLength) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(reader, "reader");
        try {
            this.this$0.getOnMessage().invoke(reader, Integer.valueOf(compressedByteLength));
        } catch (Exception e) {
            handleError$default(this, e, "Unable to parse model.", null, 4, null);
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(okhttp3.WebSocket webSocket, Response response) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(response, "response");
        WebSocket.access$schedule(this.this$0, new WebSocket$connect$1$onOpen$1(this, webSocket, response));
    }
}
