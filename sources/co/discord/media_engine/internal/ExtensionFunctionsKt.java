package co.discord.media_engine.internal;

import androidx.core.app.NotificationCompat;
import org.webrtc.Logging;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ExtensionFunctions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ExtensionFunctionsKt {
    public static final void logi(String str, String str2) {
        C12238m.checkNotNullParameter(str, "tag");
        C12238m.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logging.log(Logging.Severity.LS_INFO, str, str2);
    }
}
