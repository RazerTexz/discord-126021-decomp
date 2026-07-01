package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.fcm.NotificationClient$SettingsV2;
import d0.z.d.m;
import java.util.HashSet;
import rx.functions.Func4;

/* JADX INFO: compiled from: StoreNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotifications$configureNotificationClient$completedSettings$2<T1, T2, T3, T4, R> implements Func4<NotificationClient$SettingsV2, String, StoreUserSettingsSystem$Settings, HashSet<Long>, NotificationClient$SettingsV2> {
    public static final StoreNotifications$configureNotificationClient$completedSettings$2 INSTANCE = new StoreNotifications$configureNotificationClient$completedSettings$2();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ NotificationClient$SettingsV2 call(NotificationClient$SettingsV2 notificationClient$SettingsV2, String str, StoreUserSettingsSystem$Settings storeUserSettingsSystem$Settings, HashSet<Long> hashSet) {
        return call2(notificationClient$SettingsV2, str, storeUserSettingsSystem$Settings, hashSet);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final NotificationClient$SettingsV2 call2(NotificationClient$SettingsV2 notificationClient$SettingsV2, String str, StoreUserSettingsSystem$Settings storeUserSettingsSystem$Settings, HashSet<Long> hashSet) {
        String locale = storeUserSettingsSystem$Settings.getLocale();
        m.checkNotNullExpressionValue(hashSet, "nonSendableChannelIds");
        return NotificationClient$SettingsV2.copy$default(notificationClient$SettingsV2, false, false, false, false, false, false, str, locale, hashSet, 63, null);
    }
}
