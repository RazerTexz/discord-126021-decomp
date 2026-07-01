package com.discord.stores;

import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.fcm.NotificationClient$SettingsV2;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotifications$configureNotificationClient$3 extends o implements Function1<Pair<? extends NotificationClient$SettingsV2, ? extends Boolean>, Unit> {
    public static final StoreNotifications$configureNotificationClient$3 INSTANCE = new StoreNotifications$configureNotificationClient$3();

    public StoreNotifications$configureNotificationClient$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends NotificationClient$SettingsV2, ? extends Boolean> pair) {
        invoke2((Pair<NotificationClient$SettingsV2, Boolean>) pair);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<NotificationClient$SettingsV2, Boolean> pair) {
        NotificationClient$SettingsV2 notificationClient$SettingsV2Component1 = pair.component1();
        Boolean boolComponent2 = pair.component2();
        NotificationClient notificationClient = NotificationClient.INSTANCE;
        m.checkNotNullExpressionValue(notificationClient$SettingsV2Component1, "settings");
        m.checkNotNullExpressionValue(boolComponent2, "isBackgrounded");
        notificationClient.updateSettings$app_productionGoogleRelease(notificationClient$SettingsV2Component1, boolComponent2.booleanValue());
    }
}
