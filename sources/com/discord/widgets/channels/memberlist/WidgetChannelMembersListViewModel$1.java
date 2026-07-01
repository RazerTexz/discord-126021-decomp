package com.discord.widgets.channels.memberlist;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel$1 implements WidgetChannelMembersListViewModel$GuildChannelSubscriber {
    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$GuildChannelSubscriber
    public void subscribeToChannelRange(Channel channel, IntRange range) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(range, "range");
        StoreStream.Companion.getGuildSubscriptions().subscribeChannelRange(channel.getGuildId(), channel.getId(), range);
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$GuildChannelSubscriber
    public void subscribeToThread(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        StoreStream.Companion.getGuildSubscriptions().subscribeThread(channel.getGuildId(), channel.getId());
    }
}
