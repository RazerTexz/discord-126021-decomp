package com.discord.widgets.forums;

import com.discord.R$layout;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetForumBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserAdapter$LoadingItem extends MGRecyclerViewHolder<WidgetForumBrowserAdapter, ForumBrowserItem> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowserAdapter$LoadingItem(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
        super(R$layout.forum_browser_loading_item, widgetForumBrowserAdapter);
        m.checkNotNullParameter(widgetForumBrowserAdapter, "adapter");
    }
}
