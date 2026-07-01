package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.utilities.channel.ChannelSelector;

/* JADX INFO: compiled from: StoreChannelConversions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelConversions extends StoreV2 {
    private long selectedChannelId;

    @StoreThread
    public final void handleChannelCreateOrUpdate(Channel channel) {
        if (channel == null) {
            return;
        }
        long id2 = channel.getId();
        long originChannelId = channel.getOriginChannelId();
        if (originChannelId != 0 && this.selectedChannelId == originChannelId) {
            ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), 0L, id2, null, null, 12, null);
        }
    }

    @StoreThread
    public final void handleChannelSelected(long channelId) {
        this.selectedChannelId = channelId;
    }
}
