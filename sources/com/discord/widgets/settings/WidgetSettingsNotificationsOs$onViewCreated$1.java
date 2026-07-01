package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreNotifications;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsNotificationsOs$onViewCreated$1<T> implements Action1<Boolean> {
    public static final WidgetSettingsNotificationsOs$onViewCreated$1 INSTANCE = new WidgetSettingsNotificationsOs$onViewCreated$1();

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreNotifications notifications = StoreStream.Companion.getNotifications();
        m.checkNotNullExpressionValue(bool, "it");
        notifications.setEnabled(bool.booleanValue());
    }
}
