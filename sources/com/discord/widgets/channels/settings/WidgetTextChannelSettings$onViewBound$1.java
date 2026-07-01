package com.discord.widgets.channels.settings;

import android.widget.SeekBar;
import android.widget.TextView;
import b.a.y.j;
import com.discord.R$id;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings$onViewBound$1 extends j {
    public final /* synthetic */ WidgetTextChannelSettings this$0;

    public WidgetTextChannelSettings$onViewBound$1(WidgetTextChannelSettings widgetTextChannelSettings) {
        this.this$0 = widgetTextChannelSettings;
    }

    @Override // b.a.y.j, android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        m.checkNotNullParameter(seekBar, "seekBar");
        super.onProgressChanged(seekBar, progress, fromUser);
        if (fromUser) {
            int iIntValue = WidgetTextChannelSettings.Companion.getSLOWMODE_COOLDOWN_VALUES().get(progress).intValue();
            WidgetTextChannelSettings.access$setSlowmodeLabel(this.this$0, iIntValue);
            WidgetTextChannelSettings.access$getState$p(this.this$0).put(R$id.channel_settings_slow_mode_cooldown_slider, Integer.valueOf(iIntValue));
            WidgetTextChannelSettings.access$getState$p(this.this$0).configureSaveActionView(WidgetTextChannelSettings.access$getBinding$p(this.this$0).k);
            TextView textView = WidgetTextChannelSettings.access$getBinding$p(this.this$0).p;
            m.checkNotNullExpressionValue(textView, "binding.channelSettingsSlowModeCooldownLabel");
            seekBar.setContentDescription(textView.getText());
        }
    }
}
