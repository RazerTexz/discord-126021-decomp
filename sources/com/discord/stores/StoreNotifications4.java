package com.discord.stores;

import com.discord.utilities.fcm.NotificationClient;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.stores.StoreNotifications$setEnabledInApp$oldValue$1, reason: use source file name */
/* JADX INFO: compiled from: StoreNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotifications4 extends Lambda implements Function1<NotificationClient.SettingsV2, NotificationClient.SettingsV2> {
    public final /* synthetic */ boolean $isEnabledInApp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNotifications4(boolean z2) {
        super(1);
        this.$isEnabledInApp = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final NotificationClient.SettingsV2 invoke(NotificationClient.SettingsV2 settingsV2) {
        Intrinsics3.checkNotNullParameter(settingsV2, "it");
        return settingsV2.copy((509 & 1) != 0 ? settingsV2.isEnabled : false, (509 & 2) != 0 ? settingsV2.isEnabledInApp : this.$isEnabledInApp, (509 & 4) != 0 ? settingsV2.isWake : false, (509 & 8) != 0 ? settingsV2.isDisableBlink : false, (509 & 16) != 0 ? settingsV2.isDisableSound : false, (509 & 32) != 0 ? settingsV2.isDisableVibrate : false, (509 & 64) != 0 ? settingsV2.token : null, (509 & 128) != 0 ? settingsV2.locale : null, (509 & 256) != 0 ? settingsV2.sendBlockedChannels : null);
    }
}
