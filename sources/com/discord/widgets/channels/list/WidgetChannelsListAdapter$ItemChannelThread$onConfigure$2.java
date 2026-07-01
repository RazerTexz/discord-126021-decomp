package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemThread;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelThread$onConfigure$2 implements View$OnClickListener {
    public final /* synthetic */ ChannelListItem $data;
    public final /* synthetic */ WidgetChannelsListAdapter$ItemChannelThread this$0;

    public WidgetChannelsListAdapter$ItemChannelThread$onConfigure$2(WidgetChannelsListAdapter$ItemChannelThread widgetChannelsListAdapter$ItemChannelThread, ChannelListItem channelListItem) {
        this.this$0 = widgetChannelsListAdapter$ItemChannelThread;
        this.$data = channelListItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelsListAdapter$ItemChannelThread.access$getAdapter$p(this.this$0).getOnSelectChannel().invoke(((ChannelListItemThread) this.$data).getChannel());
    }
}
