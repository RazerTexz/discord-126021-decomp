package com.discord.widgets.channels.settings;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettings$configureUI$5 implements View$OnClickListener {
    public final /* synthetic */ WidgetThreadSettings this$0;

    public WidgetThreadSettings$configureUI$5(WidgetThreadSettings widgetThreadSettings) {
        this.this$0 = widgetThreadSettings;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetThreadSettings.access$getViewModel$p(this.this$0).saveThread();
    }
}
