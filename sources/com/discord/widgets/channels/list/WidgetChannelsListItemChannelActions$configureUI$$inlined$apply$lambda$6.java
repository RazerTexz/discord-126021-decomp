package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$Companion;

/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$6 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelsListItemChannelActions$Model $this_configureUI$inlined;

    public WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$6(WidgetChannelsListItemChannelActions$Model widgetChannelsListItemChannelActions$Model) {
        this.$this_configureUI$inlined = widgetChannelsListItemChannelActions$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelNotificationSettings$Companion.launch$default(WidgetChannelNotificationSettings.Companion, a.x(view, "it", "it.context"), this.$this_configureUI$inlined.getChannel().getId(), false, 4, null);
    }
}
