package com.discord.utilities.fcm;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.utilities.fcm.NotificationType, reason: use source file name */
/* JADX INFO: compiled from: NotificationData.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum NotificationData3 {
    Reminder(NotificationCompat.CATEGORY_REMINDER);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String value;

    /* JADX INFO: renamed from: com.discord.utilities.fcm.NotificationType$Companion, reason: from kotlin metadata */
    /* JADX INFO: compiled from: NotificationData.kt */
    public static final class Companion {
        private Companion() {
        }

        public final NotificationData3 parse(String value) {
            NotificationData3[] notificationData3ArrValues = NotificationData3.values();
            for (int i = 0; i < 1; i++) {
                NotificationData3 notificationData3 = notificationData3ArrValues[i];
                if (Intrinsics3.areEqual(notificationData3.getValue(), value)) {
                    return notificationData3;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    NotificationData3(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
