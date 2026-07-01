package androidx.core.app;

import android.app.Notification$BigPictureStyle;
import android.graphics.drawable.Icon;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public class NotificationCompat$BigPictureStyle$Api23Impl {
    private NotificationCompat$BigPictureStyle$Api23Impl() {
    }

    @RequiresApi(23)
    public static void setBigLargeIcon(Notification$BigPictureStyle notification$BigPictureStyle, Icon icon) {
        notification$BigPictureStyle.bigLargeIcon(icon);
    }
}
