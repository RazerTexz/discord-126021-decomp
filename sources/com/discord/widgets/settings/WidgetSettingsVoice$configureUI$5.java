package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice$configureUI$5 implements View$OnClickListener {
    public static final WidgetSettingsVoice$configureUI$5 INSTANCE = new WidgetSettingsVoice$configureUI$5();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreStream.Companion.getMediaSettings().toggleNoiseSuppression();
    }
}
