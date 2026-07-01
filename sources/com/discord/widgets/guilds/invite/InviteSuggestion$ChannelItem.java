package com.discord.widgets.guilds.invite;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: InviteSuggestion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InviteSuggestion$ChannelItem extends InviteSuggestion {
    private final Channel channel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InviteSuggestion$ChannelItem(Channel channel) {
        super(null);
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
    }

    public static /* synthetic */ InviteSuggestion$ChannelItem copy$default(InviteSuggestion$ChannelItem inviteSuggestion$ChannelItem, Channel channel, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = inviteSuggestion$ChannelItem.channel;
        }
        return inviteSuggestion$ChannelItem.copy(channel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final InviteSuggestion$ChannelItem copy(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        return new InviteSuggestion$ChannelItem(channel);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof InviteSuggestion$ChannelItem) && m.areEqual(this.channel, ((InviteSuggestion$ChannelItem) other).channel);
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
        StringBuilder sbU = a.U("ChannelItem(channel=");
        sbU.append(this.channel);
        sbU.append(")");
        return sbU.toString();
    }
}
