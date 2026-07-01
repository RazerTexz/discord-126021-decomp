package com.discord.utilities.fcm;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.images.MGImagesBitmap;
import com.discord.utilities.images.MGImagesBitmap$CloseableBitmaps;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: NotificationRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationRenderer$loadNotificationBitmaps$1<T, R> implements b<MGImagesBitmap$CloseableBitmaps, Observable<? extends MGImagesBitmap$CloseableBitmaps>> {
    public final /* synthetic */ NotificationData $notification;

    public NotificationRenderer$loadNotificationBitmaps$1(NotificationData notificationData) {
        this.$notification = notificationData;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends MGImagesBitmap$CloseableBitmaps> call(MGImagesBitmap$CloseableBitmaps mGImagesBitmap$CloseableBitmaps) {
        return call2(mGImagesBitmap$CloseableBitmaps);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends MGImagesBitmap$CloseableBitmaps> call2(MGImagesBitmap$CloseableBitmaps mGImagesBitmap$CloseableBitmaps) {
        if (m.areEqual(this.$notification.getType(), NotificationData.TYPE_GENERIC_PUSH_NOTIFICATION_SENT)) {
            if (this.$notification.getIconUrl().length() == 0) {
                return new k(mGImagesBitmap$CloseableBitmaps);
            }
        }
        return MGImagesBitmap.INSTANCE.getBitmap(this.$notification.getIconUrl(), true).G(new NotificationRenderer$loadNotificationBitmaps$1$1(mGImagesBitmap$CloseableBitmaps));
    }
}
