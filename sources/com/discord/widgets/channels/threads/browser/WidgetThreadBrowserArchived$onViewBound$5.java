package com.discord.widgets.channels.threads.browser;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetThreadBrowserArchived.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserArchived$onViewBound$5 implements View$OnClickListener {
    public final /* synthetic */ WidgetThreadBrowserArchived this$0;

    public WidgetThreadBrowserArchived$onViewBound$5(WidgetThreadBrowserArchived widgetThreadBrowserArchived) {
        this.this$0 = widgetThreadBrowserArchived;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetThreadBrowserArchived.access$getViewModel$p(this.this$0).maybeLoadMore(true);
    }
}
