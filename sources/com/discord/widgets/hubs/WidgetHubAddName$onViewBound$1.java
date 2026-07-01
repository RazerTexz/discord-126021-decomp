package com.discord.widgets.hubs;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetHubAddName.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddName$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetHubAddName this$0;

    public WidgetHubAddName$onViewBound$1(WidgetHubAddName widgetHubAddName) {
        this.this$0 = widgetHubAddName;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetHubAddName.access$maybeUpdateName(this.this$0);
    }
}
