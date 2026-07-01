package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.channels.WidgetChannelSelector;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsOverview$Model $this_configureUI;
    public final /* synthetic */ WidgetServerSettingsOverview this$0;

    public WidgetServerSettingsOverview$configureUI$1(WidgetServerSettingsOverview widgetServerSettingsOverview, WidgetServerSettingsOverview$Model widgetServerSettingsOverview$Model) {
        this.this$0 = widgetServerSettingsOverview;
        this.$this_configureUI = widgetServerSettingsOverview$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelSelector.Companion.launchForVoice(this.this$0, this.$this_configureUI.getGuild().getId(), "REQUEST_KEY_AFK_CHANNEL", true, 2131893234);
    }
}
