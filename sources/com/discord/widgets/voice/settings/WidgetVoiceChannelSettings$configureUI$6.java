package com.discord.widgets.voice.settings;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.SeekBar;
import android.widget.TextView;
import com.discord.api.channel.ChannelUtils;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.voice.Bitrate;
import com.discord.views.CheckedSetting;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceChannelSettings$configureUI$6 implements View$OnClickListener {
    public final /* synthetic */ WidgetVoiceChannelSettings$Model $this_configureUI;
    public final /* synthetic */ WidgetVoiceChannelSettings this$0;

    public WidgetVoiceChannelSettings$configureUI$6(WidgetVoiceChannelSettings widgetVoiceChannelSettings, WidgetVoiceChannelSettings$Model widgetVoiceChannelSettings$Model) {
        this.this$0 = widgetVoiceChannelSettings;
        this.$this_configureUI = widgetVoiceChannelSettings$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetVoiceChannelSettings widgetVoiceChannelSettings = this.this$0;
        long id2 = this.$this_configureUI.getChannel().getId();
        StatefulViews statefulViewsAccess$getState$p = WidgetVoiceChannelSettings.access$getState$p(this.this$0);
        TextInputLayout textInputLayout = WidgetVoiceChannelSettings.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        String str = (String) statefulViewsAccess$getState$p.get(textInputLayout.getId(), ChannelUtils.c(this.$this_configureUI.getChannel()));
        StatefulViews statefulViewsAccess$getState$p2 = WidgetVoiceChannelSettings.access$getState$p(this.this$0);
        TextInputLayout textInputLayout2 = WidgetVoiceChannelSettings.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditTopic");
        int id3 = textInputLayout2.getId();
        String topic = this.$this_configureUI.getChannel().getTopic();
        if (topic == null) {
            topic = "";
        }
        String str2 = (String) statefulViewsAccess$getState$p2.get(id3, topic);
        CheckedSetting checkedSetting = WidgetVoiceChannelSettings.access$getBinding$p(this.this$0).e;
        m.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsNsfw");
        Boolean boolValueOf = Boolean.valueOf(checkedSetting.isChecked());
        int type = this.$this_configureUI.getChannel().getType();
        SeekBar seekBar = WidgetVoiceChannelSettings.access$getBinding$p(this.this$0).t;
        m.checkNotNullExpressionValue(seekBar, "binding.userLimitSeekbar");
        int progress = seekBar.getProgress();
        SeekBar seekBar2 = WidgetVoiceChannelSettings.access$getBinding$p(this.this$0).f2702b;
        m.checkNotNullExpressionValue(seekBar2, "binding.bitrateSeekbar");
        int kbps = (Bitrate.MIN.getKbps() + seekBar2.getProgress()) * 1000;
        StatefulViews statefulViewsAccess$getState$p3 = WidgetVoiceChannelSettings.access$getState$p(this.this$0);
        TextView textView = WidgetVoiceChannelSettings.access$getBinding$p(this.this$0).g;
        m.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverride");
        WidgetVoiceChannelSettings.access$saveChannel(widgetVoiceChannelSettings, id2, str, type, str2, boolValueOf, progress, kbps, (String) statefulViewsAccess$getState$p3.get(textView.getId(), this.$this_configureUI.getChannel().getRtcRegion()));
    }
}
