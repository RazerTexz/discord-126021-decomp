package com.discord.utilities.fcm;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.graphics.drawable.IconCompat;
import com.discord.utilities.images.MGImagesBitmap$CloseableBitmaps;
import d0.y.b;
import d0.z.d.m;
import d0.z.d.o;
import java.io.IOException;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NotificationRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationRenderer$displayAndUpdateCache$7 extends o implements Function1<MGImagesBitmap$CloseableBitmaps, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ NotificationData$DisplayPayload $displayPayload;
    public final /* synthetic */ List $displayPayloadExtras;
    public final /* synthetic */ NotificationData $notification;
    public final /* synthetic */ NotificationCompat$Builder $notificationBuilder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationRenderer$displayAndUpdateCache$7(NotificationData notificationData, NotificationCompat$Builder notificationCompat$Builder, List list, Context context, NotificationData$DisplayPayload notificationData$DisplayPayload) {
        super(1);
        this.$notification = notificationData;
        this.$notificationBuilder = notificationCompat$Builder;
        this.$displayPayloadExtras = list;
        this.$context = context;
        this.$displayPayload = notificationData$DisplayPayload;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MGImagesBitmap$CloseableBitmaps mGImagesBitmap$CloseableBitmaps) throws IOException {
        invoke2(mGImagesBitmap$CloseableBitmaps);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MGImagesBitmap$CloseableBitmaps mGImagesBitmap$CloseableBitmaps) throws IOException {
        IconCompat iconCompatCreateWithBitmap;
        m.checkNotNullParameter(mGImagesBitmap$CloseableBitmaps, "bitmapsForIconUris");
        try {
            Bitmap bitmap = (Bitmap) mGImagesBitmap$CloseableBitmaps.get("com.discord.utilities.NON_ADAPTIVE_NOTIFICATION_ICON ");
            if (bitmap == null) {
                bitmap = (Bitmap) mGImagesBitmap$CloseableBitmaps.get((Object) this.$notification.getIconUrl());
            }
            if (bitmap != null) {
                this.$notificationBuilder.setLargeIcon(bitmap);
            }
            if (!this.$displayPayloadExtras.isEmpty()) {
                this.$notificationBuilder.setNumber(this.$displayPayloadExtras.size());
                NotificationCompat$Builder notificationCompat$Builder = this.$notificationBuilder;
                NotificationRenderer notificationRenderer = NotificationRenderer.INSTANCE;
                notificationCompat$Builder.setStyle(NotificationRenderer.access$getMessageStyle(notificationRenderer, this.$context, this.$notification, this.$displayPayloadExtras, mGImagesBitmap$CloseableBitmaps));
                Bitmap bitmap2 = (Bitmap) mGImagesBitmap$CloseableBitmaps.get((Object) this.$notification.getIconUrl());
                if (bitmap2 == null || (iconCompatCreateWithBitmap = IconCompat.createWithAdaptiveBitmap(bitmap2)) == null) {
                    Bitmap bitmap3 = (Bitmap) mGImagesBitmap$CloseableBitmaps.get("com.discord.utilities.NON_ADAPTIVE_NOTIFICATION_ICON ");
                    iconCompatCreateWithBitmap = bitmap3 != null ? IconCompat.createWithBitmap(bitmap3) : null;
                }
                NotificationRenderer.access$pushShortcut(notificationRenderer, this.$context, this.$notification, this.$notificationBuilder, iconCompatCreateWithBitmap);
            }
            NotificationRenderer.access$displayNotification(NotificationRenderer.INSTANCE, this.$context, this.$displayPayload.getId(), this.$notificationBuilder);
            b.closeFinally(mGImagesBitmap$CloseableBitmaps, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.closeFinally(mGImagesBitmap$CloseableBitmaps, th);
                throw th2;
            }
        }
    }
}
