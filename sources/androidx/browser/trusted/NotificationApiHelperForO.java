package androidx.browser.trusted;

import android.app.Notification;
import android.app.Notification$Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY})
public class NotificationApiHelperForO {
    private NotificationApiHelperForO() {
    }

    @Nullable
    @RequiresApi(26)
    public static Notification copyNotificationOntoChannel(Context context, NotificationManager notificationManager, Notification notification, String str, String str2) {
        notificationManager.createNotificationChannel(new NotificationChannel(str, str2, 3));
        if (notificationManager.getNotificationChannel(str).getImportance() == 0) {
            return null;
        }
        Notification$Builder notification$BuilderRecoverBuilder = Notification$Builder.recoverBuilder(context, notification);
        notification$BuilderRecoverBuilder.setChannelId(str);
        return notification$BuilderRecoverBuilder.build();
    }

    @RequiresApi(26)
    public static boolean isChannelEnabled(NotificationManager notificationManager, String str) {
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
        return notificationChannel == null || notificationChannel.getImportance() != 0;
    }
}
