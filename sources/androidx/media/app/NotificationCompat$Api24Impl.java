package androidx.media.app;

import android.app.Notification$DecoratedMediaCustomViewStyle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
public class NotificationCompat$Api24Impl {
    private NotificationCompat$Api24Impl() {
    }

    @DoNotInline
    public static Notification$DecoratedMediaCustomViewStyle createDecoratedMediaCustomViewStyle() {
        return new Notification$DecoratedMediaCustomViewStyle();
    }
}
