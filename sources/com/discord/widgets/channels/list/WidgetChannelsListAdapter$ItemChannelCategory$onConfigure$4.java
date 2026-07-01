package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.widgets.channels.WidgetCreateChannel;
import com.discord.widgets.channels.list.items.ChannelListItemCategory;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$4 implements View$OnClickListener {
    public final /* synthetic */ ChannelListItemCategory $item;
    public final /* synthetic */ WidgetChannelsListAdapter$ItemChannelCategory this$0;

    public WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$4(WidgetChannelsListAdapter$ItemChannelCategory widgetChannelsListAdapter$ItemChannelCategory, ChannelListItemCategory channelListItemCategory) {
        this.this$0 = widgetChannelsListAdapter$ItemChannelCategory;
        this.$item = channelListItemCategory;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetCreateChannel.Companion.show(a.x(this.this$0.itemView, "itemView", "itemView.context"), this.$item.getChannel().getGuildId(), 0, Long.valueOf(this.$item.getChannel().getId()));
    }
}
