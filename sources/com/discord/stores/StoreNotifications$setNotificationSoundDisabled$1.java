package com.discord.stores;

import com.discord.utilities.fcm.NotificationClient$SettingsV2;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotifications$setNotificationSoundDisabled$1 extends o implements Function1<NotificationClient$SettingsV2, NotificationClient$SettingsV2> {
    public final /* synthetic */ boolean $notificationSoundDisabled;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNotifications$setNotificationSoundDisabled$1(boolean z2) {
        super(1);
        this.$notificationSoundDisabled = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ NotificationClient$SettingsV2 invoke(NotificationClient$SettingsV2 notificationClient$SettingsV2) {
        return invoke2(notificationClient$SettingsV2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final NotificationClient$SettingsV2 invoke2(NotificationClient$SettingsV2 notificationClient$SettingsV2) {
        m.checkNotNullParameter(notificationClient$SettingsV2, "it");
        return NotificationClient$SettingsV2.copy$default(notificationClient$SettingsV2, false, false, false, false, this.$notificationSoundDisabled, false, null, null, null, 495, null);
    }
}
