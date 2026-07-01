package com.discord.widgets.voice.sheet;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.settings.WidgetSettingsVoice;
import com.discord.widgets.settings.WidgetSettingsVoice$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheet$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetVoiceBottomSheet this$0;

    public WidgetVoiceBottomSheet$configureUI$3(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        this.this$0 = widgetVoiceBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsVoice$Companion widgetSettingsVoice$Companion = WidgetSettingsVoice.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetSettingsVoice$Companion.launch$default(widgetSettingsVoice$Companion, contextRequireContext, null, false, 6, null);
    }
}
