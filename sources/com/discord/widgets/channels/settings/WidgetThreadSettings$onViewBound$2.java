package com.discord.widgets.channels.settings;

import android.widget.SeekBar;
import android.widget.TextView;
import b.a.y.j;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettings$onViewBound$2 extends j {
    public final /* synthetic */ WidgetThreadSettings this$0;

    public WidgetThreadSettings$onViewBound$2(WidgetThreadSettings widgetThreadSettings) {
        this.this$0 = widgetThreadSettings;
    }

    @Override // b.a.y.j, android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        m.checkNotNullParameter(seekBar, "seekBar");
        super.onProgressChanged(seekBar, progress, fromUser);
        if (fromUser) {
            int iIntValue = WidgetTextChannelSettings.Companion.getSLOWMODE_COOLDOWN_VALUES().get(progress).intValue();
            WidgetThreadSettings.access$setSlowmodeLabel(this.this$0, iIntValue);
            WidgetThreadSettings.access$getViewModel$p(this.this$0).onSlowModeInputChanged(iIntValue);
            TextView textView = WidgetThreadSettings.access$getBinding$p(this.this$0).h;
            m.checkNotNullExpressionValue(textView, "binding.threadSettingsSlowModeCooldownLabel");
            seekBar.setContentDescription(textView.getText());
        }
    }
}
