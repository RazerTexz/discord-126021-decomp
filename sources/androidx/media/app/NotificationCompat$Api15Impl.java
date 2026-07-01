package androidx.media.app;

import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(15)
public class NotificationCompat$Api15Impl {
    private NotificationCompat$Api15Impl() {
    }

    @DoNotInline
    public static void setContentDescription(RemoteViews remoteViews, int i, CharSequence charSequence) {
        remoteViews.setContentDescription(i, charSequence);
    }
}
