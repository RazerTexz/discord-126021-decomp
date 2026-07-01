package com.discord.widgets.voice.sheet;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheet$configureUI$7 implements View$OnClickListener {
    public final /* synthetic */ WidgetVoiceSettingsBottomSheet this$0;

    public WidgetVoiceSettingsBottomSheet$configureUI$7(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet) {
        this.this$0 = widgetVoiceSettingsBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetVoiceSettingsBottomSheet.access$getViewModel$p(this.this$0).onToggleNoiseCancellation();
    }
}
