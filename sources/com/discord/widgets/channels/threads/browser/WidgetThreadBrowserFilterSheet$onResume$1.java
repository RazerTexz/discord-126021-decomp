package com.discord.widgets.channels.threads.browser;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetThreadBrowserFilterSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserFilterSheet$onResume$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetThreadBrowserFilterSheet this$0;

    public WidgetThreadBrowserFilterSheet$onResume$1(WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet) {
        this.this$0 = widgetThreadBrowserFilterSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetThreadBrowserFilterSheet.access$getViewModel$p(this.this$0).onVisibilityChanged(WidgetThreadBrowserArchivedViewModel$VisibilityMode.PublicThreads);
    }
}
