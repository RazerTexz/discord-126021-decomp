package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.widgets.channels.list.items.ChannelListItem;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ChannelListItemStageAudienceCount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelListItemStageAudienceCount implements ChannelListItem {
    private final int audienceSize;
    private final Channel channel;
    private final int type;

    public ChannelListItemStageAudienceCount(Channel channel, int i) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.audienceSize = i;
        this.type = 16;
    }

    public static /* synthetic */ ChannelListItemStageAudienceCount copy$default(ChannelListItemStageAudienceCount channelListItemStageAudienceCount, Channel channel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            channel = channelListItemStageAudienceCount.channel;
        }
        if ((i2 & 2) != 0) {
            i = channelListItemStageAudienceCount.audienceSize;
        }
        return channelListItemStageAudienceCount.copy(channel, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAudienceSize() {
        return this.audienceSize;
    }

    public final ChannelListItemStageAudienceCount copy(Channel channel, int audienceSize) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelListItemStageAudienceCount(channel, audienceSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemStageAudienceCount)) {
            return false;
        }
        ChannelListItemStageAudienceCount channelListItemStageAudienceCount = (ChannelListItemStageAudienceCount) other;
        return Intrinsics3.areEqual(this.channel, channelListItemStageAudienceCount.channel) && this.audienceSize == channelListItemStageAudienceCount.audienceSize;
    }

    public final int getAudienceSize() {
        return this.audienceSize;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return ChannelListItem.DefaultImpls.getKey(this);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Channel channel = this.channel;
        return ((channel != null ? channel.hashCode() : 0) * 31) + this.audienceSize;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemStageAudienceCount(channel=");
        sbU.append(this.channel);
        sbU.append(", audienceSize=");
        return outline.B(sbU, this.audienceSize, ")");
    }
}
