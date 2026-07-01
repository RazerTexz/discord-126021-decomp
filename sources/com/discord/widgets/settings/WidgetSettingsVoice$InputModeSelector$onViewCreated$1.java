package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice$InputModeSelector$onViewCreated$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsVoice$InputModeSelector this$0;

    public WidgetSettingsVoice$InputModeSelector$onViewCreated$1(WidgetSettingsVoice$InputModeSelector widgetSettingsVoice$InputModeSelector) {
        this.this$0 = widgetSettingsVoice$InputModeSelector;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreStream.Companion.getMediaSettings().setVoiceInputMode(MediaEngineConnection$InputMode.PUSH_TO_TALK);
        this.this$0.dismiss();
    }
}
