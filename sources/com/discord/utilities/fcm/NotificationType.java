package com.discord.utilities.fcm;

import androidx.core.app.NotificationCompat;

/* JADX INFO: compiled from: NotificationData.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum NotificationType {
    Reminder(NotificationCompat.CATEGORY_REMINDER);

    public static final NotificationType$Companion Companion = new NotificationType$Companion(null);
    private final String value;

    NotificationType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
