package com.discord.utilities.fcm;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NotificationData.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum NotificationType {
    Reminder(NotificationCompat.CATEGORY_REMINDER);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String value;

    /* JADX INFO: compiled from: NotificationData.kt */
    public static final class Companion {
        private Companion() {
        }

        public final NotificationType parse(String value) {
            NotificationType[] notificationTypeArrValues = NotificationType.values();
            for (int i = 0; i < 1; i++) {
                NotificationType notificationType = notificationTypeArrValues[i];
                if (C12238m.areEqual(notificationType.getValue(), value)) {
                    return notificationType;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    NotificationType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
