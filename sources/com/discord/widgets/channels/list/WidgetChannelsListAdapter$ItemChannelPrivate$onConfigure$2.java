package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemPrivate;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelPrivate$onConfigure$2 implements View$OnClickListener {
    public final /* synthetic */ ChannelListItem $data;
    public final /* synthetic */ WidgetChannelsListAdapter$ItemChannelPrivate this$0;

    public WidgetChannelsListAdapter$ItemChannelPrivate$onConfigure$2(WidgetChannelsListAdapter$ItemChannelPrivate widgetChannelsListAdapter$ItemChannelPrivate, ChannelListItem channelListItem) {
        this.this$0 = widgetChannelsListAdapter$ItemChannelPrivate;
        this.$data = channelListItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelsListAdapter$ItemChannelPrivate.access$getAdapter$p(this.this$0).getOnSelectChannel().invoke(((ChannelListItemPrivate) this.$data).getChannel());
    }
}
