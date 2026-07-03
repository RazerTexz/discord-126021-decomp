package com.discord.utilities.notifications;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.widgets.settings.WidgetSettingsNotifications;
import com.discord.widgets.settings.WidgetSettingsNotificationsOs;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NotificationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationUtils {
    public static final NotificationUtils INSTANCE = new NotificationUtils();

    private NotificationUtils() {
    }

    public final void showNotificationPage(Fragment fragment) {
        C12238m.checkNotNullParameter(fragment, "fragment");
        if (NotificationClient.INSTANCE.isOsLevelNotificationEnabled()) {
            WidgetSettingsNotificationsOs.Companion companion = WidgetSettingsNotificationsOs.INSTANCE;
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            companion.show(parentFragmentManager);
            return;
        }
        WidgetSettingsNotifications.Companion companion2 = WidgetSettingsNotifications.INSTANCE;
        Context contextRequireContext = fragment.requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
        companion2.launch(contextRequireContext);
    }
}
