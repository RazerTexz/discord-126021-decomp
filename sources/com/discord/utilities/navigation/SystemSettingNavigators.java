package com.discord.utilities.navigation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri$Builder;
import com.discord.utilities.fcm.NotificationClient;
import d0.z.d.m;

/* JADX INFO: compiled from: SystemSettingNavigators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemSettingNavigators {
    public static final SystemSettingNavigators INSTANCE = new SystemSettingNavigators();

    private SystemSettingNavigators() {
    }

    public final void openSystemNotification(Context context) {
        m.checkNotNullParameter(context, "context");
        if (!NotificationClient.INSTANCE.isOsLevelNotificationEnabled()) {
            context.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", new Uri$Builder().scheme("package").opaquePart(context.getPackageName()).build()));
            return;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        context.startActivity(intent);
    }
}
