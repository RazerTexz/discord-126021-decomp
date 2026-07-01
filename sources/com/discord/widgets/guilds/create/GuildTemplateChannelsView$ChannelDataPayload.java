package com.discord.widgets.guilds.create;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildTemplateChannelsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildTemplateChannelsView$ChannelDataPayload implements MGRecyclerDataPayload {
    private final Channel channel;
    private final String key;
    private final int type;

    public GuildTemplateChannelsView$ChannelDataPayload(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.key = String.valueOf(hashCode());
    }

    public static /* synthetic */ GuildTemplateChannelsView$ChannelDataPayload copy$default(GuildTemplateChannelsView$ChannelDataPayload guildTemplateChannelsView$ChannelDataPayload, Channel channel, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = guildTemplateChannelsView$ChannelDataPayload.channel;
        }
        return guildTemplateChannelsView$ChannelDataPayload.copy(channel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final GuildTemplateChannelsView$ChannelDataPayload copy(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        return new GuildTemplateChannelsView$ChannelDataPayload(channel);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildTemplateChannelsView$ChannelDataPayload) && m.areEqual(this.channel, ((GuildTemplateChannelsView$ChannelDataPayload) other).channel);
        }
        return true;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Channel channel = this.channel;
        if (channel != null) {
            return channel.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelDataPayload(channel=");
        sbU.append(this.channel);
        sbU.append(")");
        return sbU.toString();
    }
}
