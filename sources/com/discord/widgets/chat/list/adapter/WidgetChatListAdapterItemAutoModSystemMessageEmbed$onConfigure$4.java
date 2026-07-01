package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.channel.Channel;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.utilities.channel.ChannelSelector;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$4 implements View$OnClickListener {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetChatListAdapterItemAutoModSystemMessageEmbed this$0;

    public WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$4(WidgetChatListAdapterItemAutoModSystemMessageEmbed widgetChatListAdapterItemAutoModSystemMessageEmbed, Channel channel) {
        this.this$0 = widgetChatListAdapterItemAutoModSystemMessageEmbed;
        this.$channel = channel;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChannelSelector.selectChannel$default(WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getChannelSelector$p(this.this$0), this.$channel, null, SelectedChannelAnalyticsLocation.THREAD_BROWSER, 2, null);
    }
}
