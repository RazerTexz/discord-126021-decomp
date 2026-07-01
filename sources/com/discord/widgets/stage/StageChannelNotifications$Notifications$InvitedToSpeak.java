package com.discord.widgets.stage;

import android.app.Notification;
import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import d0.z.d.m;

/* JADX INFO: compiled from: StageChannelNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelNotifications$Notifications$InvitedToSpeak {
    public static final StageChannelNotifications$Notifications$InvitedToSpeak INSTANCE = new StageChannelNotifications$Notifications$InvitedToSpeak();
    private static final int NOTIFICATION_ID = 102;

    private StageChannelNotifications$Notifications$InvitedToSpeak() {
    }

    public final void cancel(Context context) {
        m.checkNotNullParameter(context, "context");
        NotificationManagerCompat.from(context).cancel(StageChannelNotifications.NOTIFICATION_TAG, 102);
    }

    public final void notify(Context context, Notification notification) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(notification, "notification");
        NotificationManagerCompat.from(context).notify(StageChannelNotifications.NOTIFICATION_TAG, 102, notification);
    }
}
