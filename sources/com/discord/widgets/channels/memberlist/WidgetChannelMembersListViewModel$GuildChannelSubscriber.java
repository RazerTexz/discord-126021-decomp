package com.discord.widgets.channels.memberlist;

import com.discord.api.channel.Channel;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface WidgetChannelMembersListViewModel$GuildChannelSubscriber {
    void subscribeToChannelRange(Channel channel, IntRange range);

    void subscribeToThread(Channel channel);
}
