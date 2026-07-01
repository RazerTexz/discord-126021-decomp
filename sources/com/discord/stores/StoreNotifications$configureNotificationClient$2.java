package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.fcm.NotificationClient$SettingsV2;
import d0.o;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotifications$configureNotificationClient$2<T1, T2, R> implements Func2<NotificationClient$SettingsV2, Boolean, Pair<? extends NotificationClient$SettingsV2, ? extends Boolean>> {
    public static final StoreNotifications$configureNotificationClient$2 INSTANCE = new StoreNotifications$configureNotificationClient$2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends NotificationClient$SettingsV2, ? extends Boolean> call(NotificationClient$SettingsV2 notificationClient$SettingsV2, Boolean bool) {
        return call2(notificationClient$SettingsV2, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<NotificationClient$SettingsV2, Boolean> call2(NotificationClient$SettingsV2 notificationClient$SettingsV2, Boolean bool) {
        return o.to(notificationClient$SettingsV2, bool);
    }
}
