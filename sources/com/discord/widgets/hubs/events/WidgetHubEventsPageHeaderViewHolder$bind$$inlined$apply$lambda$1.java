package com.discord.widgets.hubs.events;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetHubEventsPageViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPageHeaderViewHolder$bind$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetHubEventsPageHeaderViewHolder this$0;

    public WidgetHubEventsPageHeaderViewHolder$bind$$inlined$apply$lambda$1(WidgetHubEventsPageHeaderViewHolder widgetHubEventsPageHeaderViewHolder) {
        this.this$0 = widgetHubEventsPageHeaderViewHolder;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.getListener().dismissHeader();
    }
}
