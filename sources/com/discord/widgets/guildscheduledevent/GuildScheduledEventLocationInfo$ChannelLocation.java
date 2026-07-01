package com.discord.widgets.guildscheduledevent;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildScheduledEventLocationInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventLocationInfo$ChannelLocation extends GuildScheduledEventLocationInfo {
    private final Channel channel;

    public GuildScheduledEventLocationInfo$ChannelLocation(Channel channel) {
        super(null);
        this.channel = channel;
    }

    public static /* synthetic */ GuildScheduledEventLocationInfo$ChannelLocation copy$default(GuildScheduledEventLocationInfo$ChannelLocation guildScheduledEventLocationInfo$ChannelLocation, Channel channel, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = guildScheduledEventLocationInfo$ChannelLocation.channel;
        }
        return guildScheduledEventLocationInfo$ChannelLocation.copy(channel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final GuildScheduledEventLocationInfo$ChannelLocation copy(Channel channel) {
        return new GuildScheduledEventLocationInfo$ChannelLocation(channel);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildScheduledEventLocationInfo$ChannelLocation) && m.areEqual(this.channel, ((GuildScheduledEventLocationInfo$ChannelLocation) other).channel);
        }
        return true;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public int hashCode() {
        Channel channel = this.channel;
        if (channel != null) {
            return channel.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelLocation(channel=");
        sbU.append(this.channel);
        sbU.append(")");
        return sbU.toString();
    }
}
