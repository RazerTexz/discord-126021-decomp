package com.discord.widgets.channels.list.items;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ChannelListBottomNavSpaceItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelListBottomNavSpaceItem implements ChannelListItem {
    private final long guildId;
    private final String key;
    private final int type;

    public ChannelListBottomNavSpaceItem() {
        this(0L, 1, null);
    }

    public ChannelListBottomNavSpaceItem(long j) {
        this.guildId = j;
        this.type = 11;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(j);
        this.key = sb.toString();
    }

    public final long getGuildId() {
        return this.guildId;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public /* synthetic */ ChannelListBottomNavSpaceItem(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j);
    }
}
