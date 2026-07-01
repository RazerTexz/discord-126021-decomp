package com.discord.utilities.notifications;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.widgets.settings.WidgetSettingsNotifications;
import com.discord.widgets.settings.WidgetSettingsNotificationsOs;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: NotificationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationUtils {
    public static final NotificationUtils INSTANCE = new NotificationUtils();

    private NotificationUtils() {
    }

    public final void showNotificationPage(Fragment fragment) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        if (NotificationClient.INSTANCE.isOsLevelNotificationEnabled()) {
            WidgetSettingsNotificationsOs.Companion companion = WidgetSettingsNotificationsOs.INSTANCE;
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            companion.show(parentFragmentManager);
            return;
        }
        WidgetSettingsNotifications.Companion companion2 = WidgetSettingsNotifications.INSTANCE;
        Context contextRequireContext = fragment.requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
        companion2.launch(contextRequireContext);
    }
}
