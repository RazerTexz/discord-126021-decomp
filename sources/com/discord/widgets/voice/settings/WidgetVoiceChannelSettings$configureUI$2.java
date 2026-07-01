package com.discord.widgets.voice.settings;

import android.widget.SeekBar;
import android.widget.TextView;
import b.a.y.j;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceChannelSettings$configureUI$2 extends j {
    public final /* synthetic */ WidgetVoiceChannelSettings this$0;

    public WidgetVoiceChannelSettings$configureUI$2(WidgetVoiceChannelSettings widgetVoiceChannelSettings) {
        this.this$0 = widgetVoiceChannelSettings;
    }

    @Override // b.a.y.j, android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        m.checkNotNullParameter(seekBar, "seekBar");
        TextView textView = WidgetVoiceChannelSettings.access$getBinding$p(this.this$0).n;
        m.checkNotNullExpressionValue(textView, "binding.currentUserLimitDisplay");
        textView.setText(WidgetVoiceChannelSettings.access$getUserLimitDisplayString(this.this$0, progress));
    }
}
