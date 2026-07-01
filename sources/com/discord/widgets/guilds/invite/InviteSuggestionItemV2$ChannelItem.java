package com.discord.widgets.guilds.invite;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: InviteSuggestionItemV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InviteSuggestionItemV2$ChannelItem extends InviteSuggestionItemV2 {
    private final Channel channel;
    private final boolean hasSent;
    private final String key;
    private final String searchQuery;
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InviteSuggestionItemV2$ChannelItem(Channel channel, boolean z2, String str) {
        super(null);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(str, "searchQuery");
        this.channel = channel;
        this.hasSent = z2;
        this.searchQuery = str;
        this.type = 3;
        StringBuilder sbU = a.U("c");
        sbU.append(String.valueOf(channel.getId()));
        sbU.append(str);
        this.key = sbU.toString();
    }

    public static /* synthetic */ InviteSuggestionItemV2$ChannelItem copy$default(InviteSuggestionItemV2$ChannelItem inviteSuggestionItemV2$ChannelItem, Channel channel, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = inviteSuggestionItemV2$ChannelItem.channel;
        }
        if ((i & 2) != 0) {
            z2 = inviteSuggestionItemV2$ChannelItem.hasSent;
        }
        if ((i & 4) != 0) {
            str = inviteSuggestionItemV2$ChannelItem.searchQuery;
        }
        return inviteSuggestionItemV2$ChannelItem.copy(channel, z2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasSent() {
        return this.hasSent;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSearchQuery() {
        return this.searchQuery;
    }

    public final InviteSuggestionItemV2$ChannelItem copy(Channel channel, boolean hasSent, String searchQuery) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(searchQuery, "searchQuery");
        return new InviteSuggestionItemV2$ChannelItem(channel, hasSent, searchQuery);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteSuggestionItemV2$ChannelItem)) {
            return false;
        }
        InviteSuggestionItemV2$ChannelItem inviteSuggestionItemV2$ChannelItem = (InviteSuggestionItemV2$ChannelItem) other;
        return m.areEqual(this.channel, inviteSuggestionItemV2$ChannelItem.channel) && this.hasSent == inviteSuggestionItemV2$ChannelItem.hasSent && m.areEqual(this.searchQuery, inviteSuggestionItemV2$ChannelItem.searchQuery);
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

    public final String getSearchQuery() {
        return this.searchQuery;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    @Override // com.discord.widgets.guilds.invite.InviteSuggestionItemV2
    public boolean hasSentInvite() {
        return this.hasSent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.hasSent;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        String str = this.searchQuery;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelItem(channel=");
        sbU.append(this.channel);
        sbU.append(", hasSent=");
        sbU.append(this.hasSent);
        sbU.append(", searchQuery=");
        return a.J(sbU, this.searchQuery, ")");
    }
}
