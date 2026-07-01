package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelPickerAdapterItem$ChannelItem extends ChannelPickerAdapterItem {
    private final Channel channel;
    private final boolean isSelected;
    private final String key;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelPickerAdapterItem$ChannelItem(Channel channel, boolean z2) {
        super(null);
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.isSelected = z2;
        this.key = String.valueOf(channel.getId());
    }

    public static /* synthetic */ ChannelPickerAdapterItem$ChannelItem copy$default(ChannelPickerAdapterItem$ChannelItem channelPickerAdapterItem$ChannelItem, Channel channel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = channelPickerAdapterItem$ChannelItem.channel;
        }
        if ((i & 2) != 0) {
            z2 = channelPickerAdapterItem$ChannelItem.isSelected;
        }
        return channelPickerAdapterItem$ChannelItem.copy(channel, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final ChannelPickerAdapterItem$ChannelItem copy(Channel channel, boolean isSelected) {
        m.checkNotNullParameter(channel, "channel");
        return new ChannelPickerAdapterItem$ChannelItem(channel, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelPickerAdapterItem$ChannelItem)) {
            return false;
        }
        ChannelPickerAdapterItem$ChannelItem channelPickerAdapterItem$ChannelItem = (ChannelPickerAdapterItem$ChannelItem) other;
        return m.areEqual(this.channel, channelPickerAdapterItem$ChannelItem.channel) && this.isSelected == channelPickerAdapterItem$ChannelItem.isSelected;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.isSelected;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelItem(channel=");
        sbU.append(this.channel);
        sbU.append(", isSelected=");
        return a.O(sbU, this.isSelected, ")");
    }
}
