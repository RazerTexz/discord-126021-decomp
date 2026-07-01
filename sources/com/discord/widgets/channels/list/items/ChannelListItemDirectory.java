package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ChannelListItemDirectory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelListItemDirectory implements ChannelListItem {
    private final Channel channel;
    private final String key;
    private final boolean selected;
    private final int type;
    private final int unreadCount;

    public ChannelListItemDirectory(Channel channel, boolean z2, int i) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.selected = z2;
        this.unreadCount = i;
        this.type = 17;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(channel.getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ ChannelListItemDirectory copy$default(ChannelListItemDirectory channelListItemDirectory, Channel channel, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            channel = channelListItemDirectory.channel;
        }
        if ((i2 & 2) != 0) {
            z2 = channelListItemDirectory.selected;
        }
        if ((i2 & 4) != 0) {
            i = channelListItemDirectory.unreadCount;
        }
        return channelListItemDirectory.copy(channel, z2, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getUnreadCount() {
        return this.unreadCount;
    }

    public final ChannelListItemDirectory copy(Channel channel, boolean selected, int unreadCount) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelListItemDirectory(channel, selected, unreadCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemDirectory)) {
            return false;
        }
        ChannelListItemDirectory channelListItemDirectory = (ChannelListItemDirectory) other;
        return Intrinsics3.areEqual(this.channel, channelListItemDirectory.channel) && this.selected == channelListItemDirectory.selected && this.unreadCount == channelListItemDirectory.unreadCount;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.selected;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return ((iHashCode + r1) * 31) + this.unreadCount;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemDirectory(channel=");
        sbU.append(this.channel);
        sbU.append(", selected=");
        sbU.append(this.selected);
        sbU.append(", unreadCount=");
        return outline.B(sbU, this.unreadCount, ")");
    }
}
