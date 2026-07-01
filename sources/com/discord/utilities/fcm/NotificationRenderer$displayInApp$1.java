package com.discord.utilities.fcm;

import android.app.PendingIntent$CanceledException;
import android.content.Context;
import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NotificationRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationRenderer$displayInApp$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ NotificationData $notificationData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationRenderer$displayInApp$1(NotificationData notificationData, Context context) {
        super(1);
        this.$notificationData = notificationData;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) throws PendingIntent$CanceledException {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) throws PendingIntent$CanceledException {
        m.checkNotNullParameter(view, "it");
        this.$notificationData.getContentIntentInApp(this.$context).send();
    }
}
