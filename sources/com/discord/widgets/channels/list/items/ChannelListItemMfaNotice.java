package com.discord.widgets.channels.list.items;

import com.discord.widgets.channels.list.items.ChannelListItem;

/* JADX INFO: compiled from: ChannelListItemMfaNotice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelListItemMfaNotice implements ChannelListItem {
    private final int type = 7;

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return ChannelListItem.DefaultImpls.getKey(this);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }
}
