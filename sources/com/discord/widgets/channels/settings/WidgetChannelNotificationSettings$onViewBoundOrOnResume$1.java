package com.discord.widgets.channels.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.notifications.NotificationUtils;

/* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings$onViewBoundOrOnResume$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelNotificationSettings this$0;

    public WidgetChannelNotificationSettings$onViewBoundOrOnResume$1(WidgetChannelNotificationSettings widgetChannelNotificationSettings) {
        this.this$0 = widgetChannelNotificationSettings;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        NotificationUtils.INSTANCE.showNotificationPage(this.this$0);
    }
}
