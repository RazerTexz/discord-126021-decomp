package com.discord.widgets.channels;

import android.view.MenuItem;
import android.view.MenuItem$OnMenuItemClickListener;
import com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings;

/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopic$showContextMenu$3 implements MenuItem$OnMenuItemClickListener {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ WidgetChannelTopic this$0;

    public WidgetChannelTopic$showContextMenu$3(WidgetChannelTopic widgetChannelTopic, long j) {
        this.this$0 = widgetChannelTopic;
        this.$channelId = j;
    }

    @Override // android.view.MenuItem$OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        WidgetChannelGroupDMSettings.Companion.create(this.$channelId, this.this$0.requireContext());
        return true;
    }
}
