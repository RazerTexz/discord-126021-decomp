package com.discord.widgets.channels.list.items;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChannelListItemActiveEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelListItemActiveEvent implements ChannelListItem {
    private final ChannelListItemActiveEventData data;
    private final String key;
    private final int type;

    public ChannelListItemActiveEvent(ChannelListItemActiveEventData channelListItemActiveEventData) {
        C12238m.checkNotNullParameter(channelListItemActiveEventData, "data");
        this.data = channelListItemActiveEventData;
        this.type = 15;
        this.key = getType() + channelListItemActiveEventData.getLocationInfo().getLocationName();
    }

    public final ChannelListItemActiveEventData getData() {
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
