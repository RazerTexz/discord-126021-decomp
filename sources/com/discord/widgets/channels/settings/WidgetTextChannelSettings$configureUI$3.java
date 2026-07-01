package com.discord.widgets.channels.settings;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.SeekBar;
import com.discord.R$id;
import com.discord.utilities.stateful.StatefulViews;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetTextChannelSettings$Model $this_configureUI;
    public final /* synthetic */ WidgetTextChannelSettings this$0;

    public WidgetTextChannelSettings$configureUI$3(WidgetTextChannelSettings widgetTextChannelSettings, WidgetTextChannelSettings$Model widgetTextChannelSettings$Model) {
        this.this$0 = widgetTextChannelSettings;
        this.$this_configureUI = widgetTextChannelSettings$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetTextChannelSettings widgetTextChannelSettings = this.this$0;
        long id2 = this.$this_configureUI.getChannel().getId();
        StatefulViews statefulViewsAccess$getState$p = WidgetTextChannelSettings.access$getState$p(this.this$0);
        TextInputLayout textInputLayout = WidgetTextChannelSettings.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        String str = (String) statefulViewsAccess$getState$p.getIfChanged(textInputLayout.getId());
        StatefulViews statefulViewsAccess$getState$p2 = WidgetTextChannelSettings.access$getState$p(this.this$0);
        TextInputLayout textInputLayout2 = WidgetTextChannelSettings.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditTopic");
        String str2 = (String) statefulViewsAccess$getState$p2.getIfChanged(textInputLayout2.getId());
        StatefulViews statefulViewsAccess$getState$p3 = WidgetTextChannelSettings.access$getState$p(this.this$0);
        SeekBar seekBar = WidgetTextChannelSettings.access$getBinding$p(this.this$0).q;
        m.checkNotNullExpressionValue(seekBar, "binding.channelSettingsSlowModeCooldownSlider");
        WidgetTextChannelSettings.saveChannel$default(widgetTextChannelSettings, id2, str, null, str2, null, (Integer) statefulViewsAccess$getState$p3.getIfChanged(seekBar.getId()), (Integer) WidgetTextChannelSettings.access$getState$p(this.this$0).getIfChanged(R$id.duration_selector), 20, null);
    }
}
