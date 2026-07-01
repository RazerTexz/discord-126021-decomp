package com.discord.widgets.channels;

import android.view.MenuItem;
import android.view.MenuItem$OnMenuItemClickListener;

/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopic$showContextMenu$5 implements MenuItem$OnMenuItemClickListener {
    public final /* synthetic */ WidgetChannelTopic this$0;

    public WidgetChannelTopic$showContextMenu$5(WidgetChannelTopic widgetChannelTopic) {
        this.this$0 = widgetChannelTopic;
    }

    @Override // android.view.MenuItem$OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        WidgetChannelTopic.access$getViewModel$p(this.this$0).handleClosePrivateChannel(this.this$0.requireContext());
        return true;
    }
}
