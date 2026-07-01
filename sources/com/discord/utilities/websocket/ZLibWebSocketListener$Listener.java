package com.discord.utilities.websocket;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import d0.z.d.m;
import java.io.InputStreamReader;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* JADX INFO: compiled from: ZLibWebSocketListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ZLibWebSocketListener$Listener extends WebSocketListener {
    private final RawMessageHandler rawMessageHandler;

    public RawMessageHandler getRawMessageHandler() {
        return this.rawMessageHandler;
    }

    public abstract void onInflateError(Exception e);

    public abstract void onInflatedMessage(okhttp3.WebSocket webSocket, InputStreamReader reader, int compressedByteLength);

    @Override // okhttp3.WebSocketListener
    public final void onMessage(okhttp3.WebSocket webSocket, ByteString bytes) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(bytes, "bytes");
        throw new UnsupportedOperationException();
    }

    @Override // okhttp3.WebSocketListener
    public final void onMessage(okhttp3.WebSocket webSocket, String text) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        throw new UnsupportedOperationException();
    }
}
