package com.discord.utilities.fcm;

import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NotificationData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationType$Companion {
    private NotificationType$Companion() {
    }

    public final NotificationType parse(String value) {
        NotificationType[] notificationTypeArrValues = NotificationType.values();
        for (int i = 0; i < 1; i++) {
            NotificationType notificationType = notificationTypeArrValues[i];
            if (m.areEqual(notificationType.getValue(), value)) {
                return notificationType;
            }
        }
        return null;
    }

    public /* synthetic */ NotificationType$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
