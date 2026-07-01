package com.discord.widgets.channels.list.items;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.widgets.channels.list.WidgetChannelListUnreads$UnreadItem;
import d0.z.d.m;

/* JADX INFO: compiled from: ChannelListItemTextChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelListItemTextChannel implements ChannelListItem, WidgetChannelListUnreads$UnreadItem {
    private final Channel channel;
    private final boolean hasActiveThreads;
    private final boolean isGuildRoleSubscriptionChannel;
    private final boolean isGuildRoleSubscriptionLockedChannel;
    private final boolean isLocked;
    private final boolean isUnread;
    private final String key;
    private final int mentionCount;
    private final boolean muted;
    private final boolean selected;
    private final int type;

    public ChannelListItemTextChannel(Channel channel, boolean z2, int i, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.selected = z2;
        this.mentionCount = i;
        this.isUnread = z3;
        this.muted = z4;
        this.isLocked = z5;
        this.hasActiveThreads = z6;
        this.isGuildRoleSubscriptionLockedChannel = z7;
        this.isGuildRoleSubscriptionChannel = z8;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(channel.getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ ChannelListItemTextChannel copy$default(ChannelListItemTextChannel channelListItemTextChannel, Channel channel, boolean z2, int i, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, int i2, Object obj) {
        return channelListItemTextChannel.copy((i2 & 1) != 0 ? channelListItemTextChannel.channel : channel, (i2 & 2) != 0 ? channelListItemTextChannel.selected : z2, (i2 & 4) != 0 ? channelListItemTextChannel.getMentionCount() : i, (i2 & 8) != 0 ? channelListItemTextChannel.getIsUnread() : z3, (i2 & 16) != 0 ? channelListItemTextChannel.muted : z4, (i2 & 32) != 0 ? channelListItemTextChannel.isLocked : z5, (i2 & 64) != 0 ? channelListItemTextChannel.hasActiveThreads : z6, (i2 & 128) != 0 ? channelListItemTextChannel.isGuildRoleSubscriptionLockedChannel : z7, (i2 & 256) != 0 ? channelListItemTextChannel.isGuildRoleSubscriptionChannel : z8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    public final int component3() {
        return getMentionCount();
    }

    public final boolean component4() {
        return getIsUnread();
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getMuted() {
        return this.muted;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsLocked() {
        return this.isLocked;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getHasActiveThreads() {
        return this.hasActiveThreads;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsGuildRoleSubscriptionLockedChannel() {
        return this.isGuildRoleSubscriptionLockedChannel;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsGuildRoleSubscriptionChannel() {
        return this.isGuildRoleSubscriptionChannel;
    }

    public final ChannelListItemTextChannel copy(Channel channel, boolean selected, int mentionCount, boolean isUnread, boolean muted, boolean isLocked, boolean hasActiveThreads, boolean isGuildRoleSubscriptionLockedChannel, boolean isGuildRoleSubscriptionChannel) {
        m.checkNotNullParameter(channel, "channel");
        return new ChannelListItemTextChannel(channel, selected, mentionCount, isUnread, muted, isLocked, hasActiveThreads, isGuildRoleSubscriptionLockedChannel, isGuildRoleSubscriptionChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemTextChannel)) {
            return false;
        }
        ChannelListItemTextChannel channelListItemTextChannel = (ChannelListItemTextChannel) other;
        return m.areEqual(this.channel, channelListItemTextChannel.channel) && this.selected == channelListItemTextChannel.selected && getMentionCount() == channelListItemTextChannel.getMentionCount() && getIsUnread() == channelListItemTextChannel.getIsUnread() && this.muted == channelListItemTextChannel.muted && this.isLocked == channelListItemTextChannel.isLocked && this.hasActiveThreads == channelListItemTextChannel.hasActiveThreads && this.isGuildRoleSubscriptionLockedChannel == channelListItemTextChannel.isGuildRoleSubscriptionLockedChannel && this.isGuildRoleSubscriptionChannel == channelListItemTextChannel.isGuildRoleSubscriptionChannel;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final boolean getHasActiveThreads() {
        return this.hasActiveThreads;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads$UnreadItem
    public int getMentionCount() {
        return this.mentionCount;
    }

    public final boolean getMuted() {
        return this.muted;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.selected;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int mentionCount = (getMentionCount() + ((iHashCode + r1) * 31)) * 31;
        boolean isUnread = getIsUnread();
        ?? r0 = isUnread;
        if (isUnread) {
            r0 = 1;
        }
        int i = (mentionCount + r0) * 31;
        boolean z3 = this.muted;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.isLocked;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.hasActiveThreads;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z6 = this.isGuildRoleSubscriptionLockedChannel;
        ?? r5 = z6;
        if (z6) {
            r5 = 1;
        }
        int i5 = (i4 + r5) * 31;
        boolean z7 = this.isGuildRoleSubscriptionChannel;
        return i5 + (z7 ? 1 : z7);
    }

    public final boolean isGuildRoleSubscriptionChannel() {
        return this.isGuildRoleSubscriptionChannel;
    }

    public final boolean isGuildRoleSubscriptionLockedChannel() {
        return this.isGuildRoleSubscriptionLockedChannel;
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads$UnreadItem
    /* JADX INFO: renamed from: isUnread, reason: from getter */
    public boolean getIsUnread() {
        return this.isUnread;
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelListItemTextChannel(channel=");
        sbU.append(this.channel);
        sbU.append(", selected=");
        sbU.append(this.selected);
        sbU.append(", mentionCount=");
        sbU.append(getMentionCount());
        sbU.append(", isUnread=");
        sbU.append(getIsUnread());
        sbU.append(", muted=");
        sbU.append(this.muted);
        sbU.append(", isLocked=");
        sbU.append(this.isLocked);
        sbU.append(", hasActiveThreads=");
        sbU.append(this.hasActiveThreads);
        sbU.append(", isGuildRoleSubscriptionLockedChannel=");
        sbU.append(this.isGuildRoleSubscriptionLockedChannel);
        sbU.append(", isGuildRoleSubscriptionChannel=");
        return a.O(sbU, this.isGuildRoleSubscriptionChannel, ")");
    }
}
