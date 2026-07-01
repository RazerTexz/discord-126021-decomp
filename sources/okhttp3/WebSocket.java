package okhttp3;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface WebSocket {
    boolean a(String text);

    boolean e(int code, String reason);
}
