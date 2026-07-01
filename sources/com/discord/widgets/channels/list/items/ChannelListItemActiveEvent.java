package com.discord.widgets.channels.list.items;

import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ChannelListItemActiveEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelListItemActiveEvent implements ChannelListItem {
    private final ChannelListItemActiveEvent2 data;
    private final String key;
    private final int type;

    public ChannelListItemActiveEvent(ChannelListItemActiveEvent2 channelListItemActiveEvent2) {
        Intrinsics3.checkNotNullParameter(channelListItemActiveEvent2, "data");
        this.data = channelListItemActiveEvent2;
        this.type = 15;
        this.key = getType() + channelListItemActiveEvent2.getLocationInfo().getLocationName();
    }

    public final ChannelListItemActiveEvent2 getData() {
        return this.data;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }
}
