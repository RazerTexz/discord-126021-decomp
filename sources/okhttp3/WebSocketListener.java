package okhttp3;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import okio.ByteString;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WebSocketListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int code, String reason) {
        C12238m.checkParameterIsNotNull(webSocket, "webSocket");
        C12238m.checkParameterIsNotNull(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
    }

    public void onClosing(WebSocket webSocket, int code, String reason) {
        C12238m.checkParameterIsNotNull(webSocket, "webSocket");
        C12238m.checkParameterIsNotNull(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
    }

    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        C12238m.checkParameterIsNotNull(webSocket, "webSocket");
        C12238m.checkParameterIsNotNull(t, "t");
    }

    public void onMessage(WebSocket webSocket, String text) {
        C12238m.checkParameterIsNotNull(webSocket, "webSocket");
        C12238m.checkParameterIsNotNull(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
    }

    public void onMessage(WebSocket webSocket, ByteString bytes) {
        C12238m.checkParameterIsNotNull(webSocket, "webSocket");
        C12238m.checkParameterIsNotNull(bytes, "bytes");
    }

    public void onOpen(WebSocket webSocket, Response response) {
        C12238m.checkParameterIsNotNull(webSocket, "webSocket");
        C12238m.checkParameterIsNotNull(response, "response");
    }
}
