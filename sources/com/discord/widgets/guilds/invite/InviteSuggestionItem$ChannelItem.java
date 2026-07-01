package com.discord.widgets.guilds.invite;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: InviteSuggestionItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InviteSuggestionItem$ChannelItem extends InviteSuggestionItem {
    private final Channel channel;
    private final boolean hasSent;
    private final String key;
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InviteSuggestionItem$ChannelItem(Channel channel, boolean z2) {
        super(null);
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.hasSent = z2;
        this.type = 1;
        StringBuilder sbU = a.U("c");
        sbU.append(String.valueOf(channel.getId()));
        this.key = sbU.toString();
    }

    public static /* synthetic */ InviteSuggestionItem$ChannelItem copy$default(InviteSuggestionItem$ChannelItem inviteSuggestionItem$ChannelItem, Channel channel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = inviteSuggestionItem$ChannelItem.channel;
        }
        if ((i & 2) != 0) {
            z2 = inviteSuggestionItem$ChannelItem.hasSent;
        }
        return inviteSuggestionItem$ChannelItem.copy(channel, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasSent() {
        return this.hasSent;
    }

    public final InviteSuggestionItem$ChannelItem copy(Channel channel, boolean hasSent) {
        m.checkNotNullParameter(channel, "channel");
        return new InviteSuggestionItem$ChannelItem(channel, hasSent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteSuggestionItem$ChannelItem)) {
            return false;
        }
        InviteSuggestionItem$ChannelItem inviteSuggestionItem$ChannelItem = (InviteSuggestionItem$ChannelItem) other;
        return m.areEqual(this.channel, inviteSuggestionItem$ChannelItem.channel) && this.hasSent == inviteSuggestionItem$ChannelItem.hasSent;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final boolean getHasSent() {
        return this.hasSent;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem
    public boolean hasSentInvite() {
        return this.hasSent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.hasSent;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelItem(channel=");
        sbU.append(this.channel);
        sbU.append(", hasSent=");
        return a.O(sbU, this.hasSent, ")");
    }
}
