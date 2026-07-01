package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.presence.Presence;
import com.discord.widgets.channels.list.WidgetChannelListUnreads;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ChannelListItemPrivate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelListItemPrivate implements ChannelListItem, WidgetChannelListUnreads.UnreadItem {
    private final Channel channel;
    private final boolean isApplicationStreaming;
    private final String key;
    private final int mentionCount;
    private final boolean muted;
    private final Presence presence;
    private final boolean selected;
    private final int type;

    public ChannelListItemPrivate(Channel channel, Presence presence, boolean z2, int i, boolean z3, boolean z4) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.presence = presence;
        this.selected = z2;
        this.mentionCount = i;
        this.isApplicationStreaming = z3;
        this.muted = z4;
        this.type = 3;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(channel.getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ ChannelListItemPrivate copy$default(ChannelListItemPrivate channelListItemPrivate, Channel channel, Presence presence, boolean z2, int i, boolean z3, boolean z4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            channel = channelListItemPrivate.channel;
        }
        if ((i2 & 2) != 0) {
            presence = channelListItemPrivate.presence;
        }
        Presence presence2 = presence;
        if ((i2 & 4) != 0) {
            z2 = channelListItemPrivate.selected;
        }
        boolean z5 = z2;
        if ((i2 & 8) != 0) {
            i = channelListItemPrivate.getMentionCount();
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            z3 = channelListItemPrivate.isApplicationStreaming;
        }
        boolean z6 = z3;
        if ((i2 & 32) != 0) {
            z4 = channelListItemPrivate.muted;
        }
        return channelListItemPrivate.copy(channel, presence2, z5, i3, z6, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    public final int component4() {
        return getMentionCount();
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsApplicationStreaming() {
        return this.isApplicationStreaming;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getMuted() {
        return this.muted;
    }

    public final ChannelListItemPrivate copy(Channel channel, Presence presence, boolean selected, int mentionCount, boolean isApplicationStreaming, boolean muted) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelListItemPrivate(channel, presence, selected, mentionCount, isApplicationStreaming, muted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemPrivate)) {
            return false;
        }
        ChannelListItemPrivate channelListItemPrivate = (ChannelListItemPrivate) other;
        return Intrinsics3.areEqual(this.channel, channelListItemPrivate.channel) && Intrinsics3.areEqual(this.presence, channelListItemPrivate.presence) && this.selected == channelListItemPrivate.selected && getMentionCount() == channelListItemPrivate.getMentionCount() && this.isApplicationStreaming == channelListItemPrivate.isApplicationStreaming && this.muted == channelListItemPrivate.muted;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
    public int getMentionCount() {
        return this.mentionCount;
    }

    public final boolean getMuted() {
        return this.muted;
    }

    public final Presence getPresence() {
        return this.presence;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Presence presence = this.presence;
        int iHashCode2 = (iHashCode + (presence != null ? presence.hashCode() : 0)) * 31;
        boolean z2 = this.selected;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int mentionCount = (getMentionCount() + ((iHashCode2 + r1) * 31)) * 31;
        boolean z3 = this.isApplicationStreaming;
        ?? r0 = z3;
        if (z3) {
            r0 = 1;
        }
        int i = (mentionCount + r0) * 31;
        boolean z4 = this.muted;
        return i + (z4 ? 1 : z4);
    }

    public final boolean isApplicationStreaming() {
        return this.isApplicationStreaming;
    }

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
    /* JADX INFO: renamed from: isUnread */
    public boolean getIsUnread() {
        return false;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemPrivate(channel=");
        sbU.append(this.channel);
        sbU.append(", presence=");
        sbU.append(this.presence);
        sbU.append(", selected=");
        sbU.append(this.selected);
        sbU.append(", mentionCount=");
        sbU.append(getMentionCount());
        sbU.append(", isApplicationStreaming=");
        sbU.append(this.isApplicationStreaming);
        sbU.append(", muted=");
        return outline.O(sbU, this.muted, ")");
    }
}
