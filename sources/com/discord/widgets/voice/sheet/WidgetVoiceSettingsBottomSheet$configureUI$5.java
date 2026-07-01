package com.discord.widgets.voice.sheet;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import android.widget.TextView;
import com.discord.widgets.settings.WidgetSettingsVoice;
import com.discord.widgets.settings.WidgetSettingsVoice$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheet$configureUI$5 implements View$OnClickListener {
    public final /* synthetic */ WidgetVoiceSettingsBottomSheet this$0;

    public WidgetVoiceSettingsBottomSheet$configureUI$5(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet) {
        this.this$0 = widgetVoiceSettingsBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        WidgetSettingsVoice$Companion widgetSettingsVoice$Companion = WidgetSettingsVoice.Companion;
        TextView textView = WidgetVoiceSettingsBottomSheet.access$getBinding$p(this.this$0).i;
        m.checkNotNullExpressionValue(textView, "binding.voiceSettingsVoiceSettings");
        Context context = textView.getContext();
        m.checkNotNullExpressionValue(context, "binding.voiceSettingsVoiceSettings.context");
        WidgetSettingsVoice$Companion.launch$default(widgetSettingsVoice$Companion, context, null, false, 6, null);
    }
}
