package com.discord.widgets.channels.list.items;


/* JADX INFO: compiled from: ChannelListItemGuildRoleSubscriptionsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelListItemGuildRoleSubscriptionsOverview implements ChannelListItem {
    public static final ChannelListItemGuildRoleSubscriptionsOverview INSTANCE;
    private static final String key;
    private static final int type;

    static {
        ChannelListItemGuildRoleSubscriptionsOverview channelListItemGuildRoleSubscriptionsOverview = new ChannelListItemGuildRoleSubscriptionsOverview();
        INSTANCE = channelListItemGuildRoleSubscriptionsOverview;
        type = 21;
        key = String.valueOf(channelListItemGuildRoleSubscriptionsOverview.getType());
    }

    private ChannelListItemGuildRoleSubscriptionsOverview() {
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return type;
    }
}
