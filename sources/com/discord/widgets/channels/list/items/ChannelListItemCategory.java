package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ChannelListItemCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelListItemCategory implements ChannelListItem {
    private final boolean canManageChannels;
    private final Channel channel;
    private final boolean isCollapsed;
    private final boolean isMuted;
    private final String key;
    private final int type;

    public ChannelListItemCategory(Channel channel, boolean z2, boolean z3, boolean z4) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.isCollapsed = z2;
        this.isMuted = z3;
        this.canManageChannels = z4;
        this.type = 8;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(channel.getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ ChannelListItemCategory copy$default(ChannelListItemCategory channelListItemCategory, Channel channel, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = channelListItemCategory.channel;
        }
        if ((i & 2) != 0) {
            z2 = channelListItemCategory.isCollapsed;
        }
        if ((i & 4) != 0) {
            z3 = channelListItemCategory.isMuted;
        }
        if ((i & 8) != 0) {
            z4 = channelListItemCategory.canManageChannels;
        }
        return channelListItemCategory.copy(channel, z2, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsCollapsed() {
        return this.isCollapsed;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCanManageChannels() {
        return this.canManageChannels;
    }

    public final ChannelListItemCategory copy(Channel channel, boolean isCollapsed, boolean isMuted, boolean canManageChannels) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelListItemCategory(channel, isCollapsed, isMuted, canManageChannels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemCategory)) {
            return false;
        }
        ChannelListItemCategory channelListItemCategory = (ChannelListItemCategory) other;
        return Intrinsics3.areEqual(this.channel, channelListItemCategory.channel) && this.isCollapsed == channelListItemCategory.isCollapsed && this.isMuted == channelListItemCategory.isMuted && this.canManageChannels == channelListItemCategory.canManageChannels;
    }

    public final boolean getCanManageChannels() {
        return this.canManageChannels;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.isCollapsed;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.isMuted;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.canManageChannels;
        return i2 + (z4 ? 1 : z4);
    }

    public final boolean isCollapsed() {
        return this.isCollapsed;
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemCategory(channel=");
        sbU.append(this.channel);
        sbU.append(", isCollapsed=");
        sbU.append(this.isCollapsed);
        sbU.append(", isMuted=");
        sbU.append(this.isMuted);
        sbU.append(", canManageChannels=");
        return outline.O(sbU, this.canManageChannels, ")");
    }
}
