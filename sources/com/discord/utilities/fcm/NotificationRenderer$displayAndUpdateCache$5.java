package com.discord.utilities.fcm;

import android.content.Context;
import androidx.core.app.NotificationCompat$Builder;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NotificationRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationRenderer$displayAndUpdateCache$5 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ NotificationData$DisplayPayload $displayPayload;
    public final /* synthetic */ NotificationData $notification;
    public final /* synthetic */ NotificationCompat$Builder $notificationBuilder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationRenderer$displayAndUpdateCache$5(Context context, NotificationData$DisplayPayload notificationData$DisplayPayload, NotificationCompat$Builder notificationCompat$Builder, NotificationData notificationData) {
        super(1);
        this.$context = context;
        this.$displayPayload = notificationData$DisplayPayload;
        this.$notificationBuilder = notificationCompat$Builder;
        this.$notification = notificationData;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        NotificationRenderer notificationRenderer = NotificationRenderer.INSTANCE;
        NotificationRenderer.access$displayNotification(notificationRenderer, this.$context, this.$displayPayload.getId(), this.$notificationBuilder);
        NotificationRenderer.pushShortcut$default(notificationRenderer, this.$context, this.$notification, this.$notificationBuilder, null, 8, null);
    }
}
