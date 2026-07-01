package com.discord.stores;

import android.app.Application;
import android.content.SharedPreferences;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.fcm.NotificationClient$SettingsV2;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream$maybeLogNotificationPermissionStatus$1 extends o implements Function1<NotificationClient$SettingsV2, Unit> {
    public final /* synthetic */ Application $context;
    public final /* synthetic */ long $currentTime;
    public final /* synthetic */ SharedPreferences $sharedPrefs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStream$maybeLogNotificationPermissionStatus$1(SharedPreferences sharedPreferences, long j, Application application) {
        super(1);
        this.$sharedPrefs = sharedPreferences;
        this.$currentTime = j;
        this.$context = application;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(NotificationClient$SettingsV2 notificationClient$SettingsV2) {
        invoke2(notificationClient$SettingsV2);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(NotificationClient$SettingsV2 notificationClient$SettingsV2) {
        this.$sharedPrefs.edit().putLong(StoreStream.access$getLAST_LOGGED_NOTIFICATION_PERMISSIONS_KEY$cp(), this.$currentTime).apply();
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        Application application = this.$context;
        m.checkNotNullExpressionValue(notificationClient$SettingsV2, "it");
        analyticsTracker.notificationPermissionStatus(application, notificationClient$SettingsV2);
    }
}
