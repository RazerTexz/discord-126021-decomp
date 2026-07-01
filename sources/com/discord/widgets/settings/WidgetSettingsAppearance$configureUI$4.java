package com.discord.widgets.settings;

import android.widget.SeekBar;
import android.widget.SeekBar$OnSeekBarChangeListener;
import android.widget.TextView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAppearance$configureUI$4 implements SeekBar$OnSeekBarChangeListener {
    public final /* synthetic */ WidgetSettingsAppearance this$0;

    public WidgetSettingsAppearance$configureUI$4(WidgetSettingsAppearance widgetSettingsAppearance) {
        this.this$0 = widgetSettingsAppearance;
    }

    @Override // android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            int i = progress + 80;
            WidgetSettingsAppearance.access$getNewFontScaleSubject$p(this.this$0).onNext(Integer.valueOf(i));
            TextView textView = WidgetSettingsAppearance.access$getBinding$p(this.this$0).d;
            m.checkNotNullExpressionValue(textView, "binding.settingsAppearanceFontScalePlatform");
            textView.setText(WidgetSettingsAppearance.access$getFontScaleString(this.this$0, i, false));
        }
    }

    @Override // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
