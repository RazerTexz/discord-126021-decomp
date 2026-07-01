package com.discord.widgets.hubs.events;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetHubEventsPageViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPageFooterViewHolder$bind$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ HubEventsPage$Footer $footer$inlined;
    public final /* synthetic */ WidgetHubEventsPageFooterViewHolder this$0;

    public WidgetHubEventsPageFooterViewHolder$bind$$inlined$apply$lambda$1(WidgetHubEventsPageFooterViewHolder widgetHubEventsPageFooterViewHolder, HubEventsPage$Footer hubEventsPage$Footer) {
        this.this$0 = widgetHubEventsPageFooterViewHolder;
        this.$footer$inlined = hubEventsPage$Footer;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.getListener().fetchGuildScheduledEvents();
    }
}
