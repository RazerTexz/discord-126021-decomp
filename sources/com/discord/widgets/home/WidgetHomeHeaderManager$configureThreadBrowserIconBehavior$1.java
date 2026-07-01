package com.discord.widgets.home;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowser;

/* JADX INFO: compiled from: WidgetHomeHeaderManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeHeaderManager$configureThreadBrowserIconBehavior$1 implements View$OnClickListener {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Context $context;

    public WidgetHomeHeaderManager$configureThreadBrowserIconBehavior$1(Context context, Channel channel) {
        this.$context = context;
        this.$channel = channel;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetThreadBrowser.Companion.show(this.$context, this.$channel.getGuildId(), ChannelUtils.H(this.$channel) ? this.$channel.getParentId() : this.$channel.getId(), "Chat List Header");
    }
}
