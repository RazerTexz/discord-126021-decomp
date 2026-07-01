package okhttp3;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import okio.ByteString;

/* JADX INFO: compiled from: WebSocketListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int code, String reason) {
        m.checkParameterIsNotNull(webSocket, "webSocket");
        m.checkParameterIsNotNull(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
    }

    public void onClosing(WebSocket webSocket, int code, String reason) {
        m.checkParameterIsNotNull(webSocket, "webSocket");
        m.checkParameterIsNotNull(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
    }

    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        m.checkParameterIsNotNull(webSocket, "webSocket");
        m.checkParameterIsNotNull(t, "t");
    }

    public void onMessage(WebSocket webSocket, String text) {
        m.checkParameterIsNotNull(webSocket, "webSocket");
        m.checkParameterIsNotNull(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
    }

    public void onMessage(WebSocket webSocket, ByteString bytes) {
        m.checkParameterIsNotNull(webSocket, "webSocket");
        m.checkParameterIsNotNull(bytes, "bytes");
    }

    public void onOpen(WebSocket webSocket, Response response) {
        m.checkParameterIsNotNull(webSocket, "webSocket");
        m.checkParameterIsNotNull(response, "response");
    }
}
