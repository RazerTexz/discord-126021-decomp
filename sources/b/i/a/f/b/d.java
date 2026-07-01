package b.i.a.f.b;

import android.net.Uri;
import android.util.LogPrinter;
import androidx.core.app.NotificationCompat;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    static {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        builder.authority("local");
        builder.build();
    }

    public d() {
        new LogPrinter(4, "GA/LogCatTransport");
    }
}
