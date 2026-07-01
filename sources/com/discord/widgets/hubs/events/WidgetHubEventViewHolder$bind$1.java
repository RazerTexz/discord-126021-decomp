package com.discord.widgets.hubs.events;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetHubEventsPageViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventViewHolder$bind$1 implements View$OnClickListener {
    public final /* synthetic */ HubGuildScheduledEventData $eventData;
    public final /* synthetic */ WidgetHubEventViewHolder this$0;

    public WidgetHubEventViewHolder$bind$1(WidgetHubEventViewHolder widgetHubEventViewHolder, HubGuildScheduledEventData hubGuildScheduledEventData) {
        this.this$0 = widgetHubEventViewHolder;
        this.$eventData = hubGuildScheduledEventData;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.getListener().onCardClicked(this.$eventData);
    }
}
