package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemCategory;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$2 implements View$OnClickListener {
    public final /* synthetic */ ChannelListItem $data;
    public final /* synthetic */ WidgetChannelsListAdapter$ItemChannelCategory this$0;

    public WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$2(WidgetChannelsListAdapter$ItemChannelCategory widgetChannelsListAdapter$ItemChannelCategory, ChannelListItem channelListItem) {
        this.this$0 = widgetChannelsListAdapter$ItemChannelCategory;
        this.$data = channelListItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelsListAdapter$ItemChannelCategory.access$getAdapter$p(this.this$0).getOnCollapseCategory().invoke(((ChannelListItemCategory) this.$data).getChannel(), Boolean.valueOf(((ChannelListItemCategory) this.$data).isCollapsed()));
    }
}
