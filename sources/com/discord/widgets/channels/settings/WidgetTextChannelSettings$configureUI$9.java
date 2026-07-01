package com.discord.widgets.channels.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings$configureUI$9 implements View$OnClickListener {
    public final /* synthetic */ WidgetTextChannelSettings$Model $this_configureUI;
    public final /* synthetic */ WidgetTextChannelSettings this$0;

    public WidgetTextChannelSettings$configureUI$9(WidgetTextChannelSettings widgetTextChannelSettings, WidgetTextChannelSettings$Model widgetTextChannelSettings$Model) {
        this.this$0 = widgetTextChannelSettings;
        this.$this_configureUI = widgetTextChannelSettings$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetTextChannelSettings widgetTextChannelSettings = this.this$0;
        long id2 = this.$this_configureUI.getChannel().getId();
        CheckedSetting checkedSetting = WidgetTextChannelSettings.access$getBinding$p(this.this$0).f;
        m.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsNsfw");
        WidgetTextChannelSettings.saveChannel$default(widgetTextChannelSettings, id2, null, null, null, Boolean.valueOf(!checkedSetting.isChecked()), null, null, 110, null);
    }
}
