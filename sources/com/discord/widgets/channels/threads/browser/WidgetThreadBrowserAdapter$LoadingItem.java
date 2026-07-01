package com.discord.widgets.channels.threads.browser;

import com.discord.R$layout;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserAdapter$LoadingItem extends MGRecyclerViewHolder<WidgetThreadBrowserAdapter, WidgetThreadBrowserAdapter$Item> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserAdapter$LoadingItem(WidgetThreadBrowserAdapter widgetThreadBrowserAdapter) {
        super(R$layout.thread_browser_item_loading, widgetThreadBrowserAdapter);
        m.checkNotNullParameter(widgetThreadBrowserAdapter, "adapter");
    }
}
