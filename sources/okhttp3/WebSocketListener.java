package okhttp3;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import okio.ByteString;

/* JADX INFO: compiled from: WebSocketListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int code, String reason) {
        Intrinsics3.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics3.checkParameterIsNotNull(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
    }

    public void onClosing(WebSocket webSocket, int code, String reason) {
        Intrinsics3.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics3.checkParameterIsNotNull(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
    }

    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        Intrinsics3.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics3.checkParameterIsNotNull(t, "t");
    }

    public void onMessage(WebSocket webSocket, String text) {
        Intrinsics3.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics3.checkParameterIsNotNull(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
    }

    public void onMessage(WebSocket webSocket, ByteString bytes) {
        Intrinsics3.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics3.checkParameterIsNotNull(bytes, "bytes");
    }

    public void onOpen(WebSocket webSocket, Response response) {
        Intrinsics3.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics3.checkParameterIsNotNull(response, "response");
    }
}
