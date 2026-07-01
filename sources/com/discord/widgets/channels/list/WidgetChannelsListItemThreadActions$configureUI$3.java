package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelsListItemThreadActions$Model $this_configureUI;
    public final /* synthetic */ WidgetChannelsListItemThreadActions this$0;

    public WidgetChannelsListItemThreadActions$configureUI$3(WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions, WidgetChannelsListItemThreadActions$Model widgetChannelsListItemThreadActions$Model) {
        this.this$0 = widgetChannelsListItemThreadActions;
        this.$this_configureUI = widgetChannelsListItemThreadActions$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelNotificationSettings$Companion widgetChannelNotificationSettings$Companion = WidgetChannelNotificationSettings.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetChannelNotificationSettings$Companion.launch$default(widgetChannelNotificationSettings$Companion, contextRequireContext, this.$this_configureUI.getChannel().getId(), false, 4, null);
    }
}
