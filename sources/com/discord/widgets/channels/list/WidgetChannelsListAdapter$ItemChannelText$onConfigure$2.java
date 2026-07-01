package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemTextChannel;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelText$onConfigure$2 implements View$OnClickListener {
    public final /* synthetic */ ChannelListItem $data;
    public final /* synthetic */ ChannelListItemTextChannel $item;
    public final /* synthetic */ WidgetChannelsListAdapter$ItemChannelText this$0;

    public WidgetChannelsListAdapter$ItemChannelText$onConfigure$2(WidgetChannelsListAdapter$ItemChannelText widgetChannelsListAdapter$ItemChannelText, ChannelListItemTextChannel channelListItemTextChannel, ChannelListItem channelListItem) {
        this.this$0 = widgetChannelsListAdapter$ItemChannelText;
        this.$item = channelListItemTextChannel;
        this.$data = channelListItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$item.isGuildRoleSubscriptionLockedChannel()) {
            WidgetChannelsListAdapter$ItemChannelText.access$getAdapter$p(this.this$0).getOnSelectGuildRoleSubscriptionLockedChannel().invoke(((ChannelListItemTextChannel) this.$data).getChannel());
        } else {
            WidgetChannelsListAdapter$ItemChannelText.access$getAdapter$p(this.this$0).getOnSelectChannel().invoke(((ChannelListItemTextChannel) this.$data).getChannel());
        }
    }
}
