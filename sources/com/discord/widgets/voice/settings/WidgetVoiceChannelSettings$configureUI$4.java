package com.discord.widgets.voice.settings;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceChannelSettings$configureUI$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetVoiceChannelSettings$Model $this_configureUI;
    public final /* synthetic */ WidgetVoiceChannelSettings this$0;

    public WidgetVoiceChannelSettings$configureUI$4(WidgetVoiceChannelSettings widgetVoiceChannelSettings, WidgetVoiceChannelSettings$Model widgetVoiceChannelSettings$Model) {
        this.this$0 = widgetVoiceChannelSettings;
        this.$this_configureUI = widgetVoiceChannelSettings$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetVoiceChannelSettings.access$showRegionDialog(this.this$0, this.$this_configureUI.getRegions());
    }
}
