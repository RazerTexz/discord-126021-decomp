package com.discord.widgets.channels.list.items;


/* JADX INFO: compiled from: ChannelListItemEventsSeparator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelListItemEventsSeparator implements ChannelListItem {
    private final String key;
    private final int type = 14;

    public ChannelListItemEventsSeparator(boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(z2);
        this.key = sb.toString();
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
