package com.discord.widgets.guilds.list;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.widgets.channels.list.WidgetChannelListUnreads$UnreadItem;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildListItem$PrivateChannelItem extends GuildListItem implements WidgetChannelListUnreads$UnreadItem {
    private final Channel channel;
    private final boolean isUnread;
    private final int mentionCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildListItem$PrivateChannelItem(Channel channel, int i) {
        super(channel.getId(), null);
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.mentionCount = i;
    }

    public static /* synthetic */ GuildListItem$PrivateChannelItem copy$default(GuildListItem$PrivateChannelItem guildListItem$PrivateChannelItem, Channel channel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            channel = guildListItem$PrivateChannelItem.channel;
        }
        if ((i2 & 2) != 0) {
            i = guildListItem$PrivateChannelItem.getMentionCount();
        }
        return guildListItem$PrivateChannelItem.copy(channel, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final int component2() {
        return getMentionCount();
    }

    public final GuildListItem$PrivateChannelItem copy(Channel channel, int mentionCount) {
        m.checkNotNullParameter(channel, "channel");
        return new GuildListItem$PrivateChannelItem(channel, mentionCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildListItem$PrivateChannelItem)) {
            return false;
        }
        GuildListItem$PrivateChannelItem guildListItem$PrivateChannelItem = (GuildListItem$PrivateChannelItem) other;
        return m.areEqual(this.channel, guildListItem$PrivateChannelItem.channel) && getMentionCount() == guildListItem$PrivateChannelItem.getMentionCount();
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads$UnreadItem
    public int getMentionCount() {
        return this.mentionCount;
    }

    public int hashCode() {
        Channel channel = this.channel;
        return getMentionCount() + ((channel != null ? channel.hashCode() : 0) * 31);
    }

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads$UnreadItem
    /* JADX INFO: renamed from: isUnread, reason: from getter */
    public boolean getIsUnread() {
        return this.isUnread;
    }

    public String toString() {
        StringBuilder sbU = a.U("PrivateChannelItem(channel=");
        sbU.append(this.channel);
        sbU.append(", mentionCount=");
        sbU.append(getMentionCount());
        sbU.append(")");
        return sbU.toString();
    }
}
