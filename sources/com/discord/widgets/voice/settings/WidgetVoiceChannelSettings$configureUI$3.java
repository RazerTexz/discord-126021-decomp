package com.discord.widgets.voice.settings;

import android.widget.SeekBar;
import android.widget.TextView;
import b.a.y.j;
import com.discord.utilities.voice.Bitrate;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceChannelSettings$configureUI$3 extends j {
    public final /* synthetic */ WidgetVoiceChannelSettings this$0;

    public WidgetVoiceChannelSettings$configureUI$3(WidgetVoiceChannelSettings widgetVoiceChannelSettings) {
        this.this$0 = widgetVoiceChannelSettings;
    }

    @Override // b.a.y.j, android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        m.checkNotNullParameter(seekBar, "seekBar");
        TextView textView = WidgetVoiceChannelSettings.access$getBinding$p(this.this$0).m;
        m.checkNotNullExpressionValue(textView, "binding.currentBitrateDisplay");
        textView.setText(WidgetVoiceChannelSettings.access$getBitrateDisplayString(this.this$0, Bitrate.MIN.getKbps() + progress));
    }
}
