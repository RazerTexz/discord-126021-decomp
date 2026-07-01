package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMuteSettingsSheet$configureNotificationSettings$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetMuteSettingsSheet this$0;

    public WidgetMuteSettingsSheet$configureNotificationSettings$2(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        this.this$0 = widgetMuteSettingsSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetMuteSettingsSheet.access$getViewModel$p(this.this$0).onChannelSettingsSelected();
    }
}
