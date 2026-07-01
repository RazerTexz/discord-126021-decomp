package b.i.a.f.b;

import android.net.Uri$Builder;
import android.util.LogPrinter;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    static {
        Uri$Builder uri$Builder = new Uri$Builder();
        uri$Builder.scheme(NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        uri$Builder.authority("local");
        uri$Builder.build();
    }

    public d() {
        new LogPrinter(4, "GA/LogCatTransport");
    }
}
