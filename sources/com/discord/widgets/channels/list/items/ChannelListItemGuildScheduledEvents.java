package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.guild.Guild;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: ChannelListItemGuildScheduledEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelListItemGuildScheduledEvents implements ChannelListItem {
    private final List<GuildScheduledEvent> data;
    private final Guild guild;
    private final String key;
    private final int type;

    public ChannelListItemGuildScheduledEvents(List<GuildScheduledEvent> list, Guild guild) {
        Intrinsics3.checkNotNullParameter(list, "data");
        Intrinsics3.checkNotNullParameter(guild, "guild");
        this.data = list;
        this.guild = guild;
        this.type = 19;
        this.key = String.valueOf(getType());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChannelListItemGuildScheduledEvents copy$default(ChannelListItemGuildScheduledEvents channelListItemGuildScheduledEvents, List list, Guild guild, int i, Object obj) {
        if ((i & 1) != 0) {
            list = channelListItemGuildScheduledEvents.data;
        }
        if ((i & 2) != 0) {
            guild = channelListItemGuildScheduledEvents.guild;
        }
        return channelListItemGuildScheduledEvents.copy(list, guild);
    }

    public final List<GuildScheduledEvent> component1() {
        return this.data;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final ChannelListItemGuildScheduledEvents copy(List<GuildScheduledEvent> data, Guild guild) {
        Intrinsics3.checkNotNullParameter(data, "data");
        Intrinsics3.checkNotNullParameter(guild, "guild");
        return new ChannelListItemGuildScheduledEvents(data, guild);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemGuildScheduledEvents)) {
            return false;
        }
        ChannelListItemGuildScheduledEvents channelListItemGuildScheduledEvents = (ChannelListItemGuildScheduledEvents) other;
        return Intrinsics3.areEqual(this.data, channelListItemGuildScheduledEvents.data) && Intrinsics3.areEqual(this.guild, channelListItemGuildScheduledEvents.guild);
    }

    public final List<GuildScheduledEvent> getData() {
        return this.data;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        List<GuildScheduledEvent> list = this.data;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        Guild guild = this.guild;
        return iHashCode + (guild != null ? guild.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemGuildScheduledEvents(data=");
        sbU.append(this.data);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(")");
        return sbU.toString();
    }
}
