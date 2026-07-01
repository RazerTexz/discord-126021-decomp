package com.discord.utilities.fcm;

import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.images.MGImagesBitmap$CloseableBitmaps;
import d0.o;
import d0.t.g0;
import j0.k.b;

/* JADX INFO: compiled from: NotificationRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationRenderer$loadNotificationBitmaps$1$1<T, R> implements b<Bitmap, MGImagesBitmap$CloseableBitmaps> {
    public final /* synthetic */ MGImagesBitmap$CloseableBitmaps $adaptive;

    public NotificationRenderer$loadNotificationBitmaps$1$1(MGImagesBitmap$CloseableBitmaps mGImagesBitmap$CloseableBitmaps) {
        this.$adaptive = mGImagesBitmap$CloseableBitmaps;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ MGImagesBitmap$CloseableBitmaps call(Bitmap bitmap) {
        return call2(bitmap);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final MGImagesBitmap$CloseableBitmaps call2(Bitmap bitmap) {
        return this.$adaptive.plus(new MGImagesBitmap$CloseableBitmaps(g0.mapOf(o.to("com.discord.utilities.NON_ADAPTIVE_NOTIFICATION_ICON ", bitmap)), false, 2, null));
    }
}
