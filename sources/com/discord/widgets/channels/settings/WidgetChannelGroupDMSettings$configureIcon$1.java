package com.discord.widgets.channels.settings;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelGroupDMSettings$configureIcon$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelGroupDMSettings this$0;

    public WidgetChannelGroupDMSettings$configureIcon$1(WidgetChannelGroupDMSettings widgetChannelGroupDMSettings) {
        this.this$0 = widgetChannelGroupDMSettings;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.openMediaChooser();
    }
}
