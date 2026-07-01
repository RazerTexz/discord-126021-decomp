package com.discord.widgets.channels.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.channel.ChannelUtils;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings$configureUI$8 implements View$OnClickListener {
    public final /* synthetic */ WidgetTextChannelSettings$Model $this_configureUI;
    public final /* synthetic */ WidgetTextChannelSettings this$0;

    public WidgetTextChannelSettings$configureUI$8(WidgetTextChannelSettings widgetTextChannelSettings, WidgetTextChannelSettings$Model widgetTextChannelSettings$Model) {
        this.this$0 = widgetTextChannelSettings;
        this.$this_configureUI = widgetTextChannelSettings$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (ChannelUtils.i(this.$this_configureUI.getChannel())) {
            WidgetTextChannelSettings.saveChannel$default(this.this$0, this.$this_configureUI.getChannel().getId(), null, 0, null, null, null, null, 122, null);
        } else {
            WidgetTextChannelSettings.saveChannel$default(this.this$0, this.$this_configureUI.getChannel().getId(), null, 5, null, null, null, null, 122, null);
        }
    }
}
