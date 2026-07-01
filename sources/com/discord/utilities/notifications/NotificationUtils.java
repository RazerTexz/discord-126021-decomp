package com.discord.utilities.notifications;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.widgets.settings.WidgetSettingsNotifications;
import com.discord.widgets.settings.WidgetSettingsNotifications$Companion;
import com.discord.widgets.settings.WidgetSettingsNotificationsOs;
import com.discord.widgets.settings.WidgetSettingsNotificationsOs$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: NotificationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationUtils {
    public static final NotificationUtils INSTANCE = new NotificationUtils();

    private NotificationUtils() {
    }

    public final void showNotificationPage(Fragment fragment) {
        m.checkNotNullParameter(fragment, "fragment");
        if (NotificationClient.INSTANCE.isOsLevelNotificationEnabled()) {
            WidgetSettingsNotificationsOs$Companion widgetSettingsNotificationsOs$Companion = WidgetSettingsNotificationsOs.Companion;
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetSettingsNotificationsOs$Companion.show(parentFragmentManager);
            return;
        }
        WidgetSettingsNotifications$Companion widgetSettingsNotifications$Companion = WidgetSettingsNotifications.Companion;
        Context contextRequireContext = fragment.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
        widgetSettingsNotifications$Companion.launch(contextRequireContext);
    }
}
