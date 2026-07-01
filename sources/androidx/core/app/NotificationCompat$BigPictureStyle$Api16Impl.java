package androidx.core.app;

import android.app.Notification$BigPictureStyle;
import android.graphics.Bitmap;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(16)
public class NotificationCompat$BigPictureStyle$Api16Impl {
    private NotificationCompat$BigPictureStyle$Api16Impl() {
    }

    @RequiresApi(16)
    public static void setBigLargeIcon(Notification$BigPictureStyle notification$BigPictureStyle, Bitmap bitmap) {
        notification$BigPictureStyle.bigLargeIcon(bitmap);
    }

    @RequiresApi(16)
    public static void setSummaryText(Notification$BigPictureStyle notification$BigPictureStyle, CharSequence charSequence) {
        notification$BigPictureStyle.setSummaryText(charSequence);
    }
}
