package com.discord.utilities.websocket;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.y.b;
import d0.y.i;
import d0.z.d.m;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.Inflater;
import okhttp3.Response;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* JADX INFO: compiled from: ZLibWebSocketListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ZLibWebSocketListener extends WebSocketListener {
    private final Inflater inflater;
    private final ZLibWebSocketListener$Listener listener;
    private final Inflater loggingInflater;

    public ZLibWebSocketListener(ZLibWebSocketListener$Listener zLibWebSocketListener$Listener) {
        m.checkNotNullParameter(zLibWebSocketListener$Listener, "listener");
        this.listener = zLibWebSocketListener$Listener;
        this.loggingInflater = new Inflater();
        this.inflater = new Inflater();
    }

    private final void resetInflaters() {
        this.inflater.reset();
        this.loggingInflater.reset();
    }

    public final ZLibWebSocketListener$Listener getListener() {
        return this.listener;
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(okhttp3.WebSocket webSocket, int code, String reason) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        resetInflaters();
        this.listener.onClosed(webSocket, code, reason);
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(okhttp3.WebSocket webSocket, int code, String reason) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        resetInflaters();
        this.listener.onClosing(webSocket, code, reason);
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(okhttp3.WebSocket webSocket, Throwable t, Response response) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(t, "t");
        resetInflaters();
        this.listener.onFailure(webSocket, t, response);
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(okhttp3.WebSocket webSocket, String text) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        this.listener.onMessage(webSocket, text);
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(okhttp3.WebSocket webSocket, Response response) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(response, "response");
        resetInflaters();
        this.listener.onOpen(webSocket, response);
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(okhttp3.WebSocket webSocket, ByteString bytes) throws IOException {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(bytes, "bytes");
        if (this.listener.getRawMessageHandler() != null) {
            try {
                InputStreamReader reader = new ZLibWebSocketListener$ZLibByteStream(bytes, this.loggingInflater).toReader();
                try {
                    String text = i.readText(reader);
                    RawMessageHandler rawMessageHandler = this.listener.getRawMessageHandler();
                    m.checkNotNull(rawMessageHandler);
                    rawMessageHandler.onRawMessage(text);
                    b.closeFinally(reader, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        b.closeFinally(reader, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                RawMessageHandler rawMessageHandler2 = this.listener.getRawMessageHandler();
                m.checkNotNull(rawMessageHandler2);
                rawMessageHandler2.onRawMessageInflateFailed(th3);
            }
        }
        try {
            InputStreamReader reader2 = new ZLibWebSocketListener$ZLibByteStream(bytes, this.inflater).toReader();
            try {
                this.listener.onInflatedMessage(webSocket, reader2, bytes.j());
                b.closeFinally(reader2, null);
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    b.closeFinally(reader2, th4);
                    throw th5;
                }
            }
        } catch (Exception e) {
            this.listener.onInflateError(e);
        }
    }
}
