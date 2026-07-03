package p007b.p225i.p226a.p288f.p291b;

import android.net.Uri;
import android.util.LogPrinter;
import androidx.core.app.NotificationCompat;

/* JADX INFO: renamed from: b.i.a.f.b.d */
/* JADX INFO: loaded from: classes3.dex */
public final class C3178d {
    static {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        builder.authority("local");
        builder.build();
    }

    public C3178d() {
        new LogPrinter(4, "GA/LogCatTransport");
    }
}
