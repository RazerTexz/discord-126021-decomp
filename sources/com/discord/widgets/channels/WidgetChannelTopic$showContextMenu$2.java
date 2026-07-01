package com.discord.widgets.channels;

import android.view.MenuItem;
import android.view.MenuItem$OnMenuItemClickListener;
import b.a.d.m;

/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopic$showContextMenu$2 implements MenuItem$OnMenuItemClickListener {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ WidgetChannelTopic this$0;

    public WidgetChannelTopic$showContextMenu$2(WidgetChannelTopic widgetChannelTopic, long j) {
        this.this$0 = widgetChannelTopic;
        this.$channelId = j;
    }

    @Override // android.view.MenuItem$OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        m.c(this.this$0.requireContext(), String.valueOf(this.$channelId), 0, 4);
        return true;
    }
}
