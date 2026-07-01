package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreChannelsSelected$ResolvedSelectedChannel$Channel extends StoreChannelsSelected$ResolvedSelectedChannel {
    private final SelectedChannelAnalyticsLocation analyticsLocation;
    private final ChannelAnalyticsViewType analyticsViewType;
    private final Channel channel;
    private final Long peekParent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelsSelected$ResolvedSelectedChannel$Channel(Channel channel, Long l, SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation) {
        super(null);
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.peekParent = l;
        this.analyticsLocation = selectedChannelAnalyticsLocation;
        this.analyticsViewType = l != null ? ChannelAnalyticsViewType.PEEK_VIEW : ChannelAnalyticsViewType.FULL_VIEW;
    }

    public static /* synthetic */ StoreChannelsSelected$ResolvedSelectedChannel$Channel copy$default(StoreChannelsSelected$ResolvedSelectedChannel$Channel storeChannelsSelected$ResolvedSelectedChannel$Channel, Channel channel, Long l, SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = storeChannelsSelected$ResolvedSelectedChannel$Channel.channel;
        }
        if ((i & 2) != 0) {
            l = storeChannelsSelected$ResolvedSelectedChannel$Channel.peekParent;
        }
        if ((i & 4) != 0) {
            selectedChannelAnalyticsLocation = storeChannelsSelected$ResolvedSelectedChannel$Channel.analyticsLocation;
        }
        return storeChannelsSelected$ResolvedSelectedChannel$Channel.copy(channel, l, selectedChannelAnalyticsLocation);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getPeekParent() {
        return this.peekParent;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final SelectedChannelAnalyticsLocation getAnalyticsLocation() {
        return this.analyticsLocation;
    }

    public final StoreChannelsSelected$ResolvedSelectedChannel$Channel copy(Channel channel, Long peekParent, SelectedChannelAnalyticsLocation analyticsLocation) {
        m.checkNotNullParameter(channel, "channel");
        return new StoreChannelsSelected$ResolvedSelectedChannel$Channel(channel, peekParent, analyticsLocation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreChannelsSelected$ResolvedSelectedChannel$Channel)) {
            return false;
        }
        StoreChannelsSelected$ResolvedSelectedChannel$Channel storeChannelsSelected$ResolvedSelectedChannel$Channel = (StoreChannelsSelected$ResolvedSelectedChannel$Channel) other;
        return m.areEqual(this.channel, storeChannelsSelected$ResolvedSelectedChannel$Channel.channel) && m.areEqual(this.peekParent, storeChannelsSelected$ResolvedSelectedChannel$Channel.peekParent) && m.areEqual(this.analyticsLocation, storeChannelsSelected$ResolvedSelectedChannel$Channel.analyticsLocation);
    }

    public final SelectedChannelAnalyticsLocation getAnalyticsLocation() {
        return this.analyticsLocation;
    }

    public final ChannelAnalyticsViewType getAnalyticsViewType() {
        return this.analyticsViewType;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Long getPeekParent() {
        return this.peekParent;
    }

    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Long l = this.peekParent;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation = this.analyticsLocation;
        return iHashCode2 + (selectedChannelAnalyticsLocation != null ? selectedChannelAnalyticsLocation.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Channel(channel=");
        sbU.append(this.channel);
        sbU.append(", peekParent=");
        sbU.append(this.peekParent);
        sbU.append(", analyticsLocation=");
        sbU.append(this.analyticsLocation);
        sbU.append(")");
        return sbU.toString();
    }
}
