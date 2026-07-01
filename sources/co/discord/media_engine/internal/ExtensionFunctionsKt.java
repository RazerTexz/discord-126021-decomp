package co.discord.media_engine.internal;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import org.webrtc.Logging;
import org.webrtc.Logging$Severity;

/* JADX INFO: compiled from: ExtensionFunctions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ExtensionFunctionsKt {
    public static final void logi(String str, String str2) {
        m.checkNotNullParameter(str, "tag");
        m.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logging.log(Logging$Severity.LS_INFO, str, str2);
    }
}
