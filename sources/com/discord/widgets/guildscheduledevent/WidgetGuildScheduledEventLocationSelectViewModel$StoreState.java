package com.discord.widgets.guildscheduledevent;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildScheduledEventLocationSelectViewModel$StoreState {
    private final Map<Long, Long> channelPermissions;
    private final Map<Long, Channel> channels;
    private final GuildScheduledEvent existingGuildScheduledEvent;
    private final Guild guild;
    private final Long guildPermissions;

    public WidgetGuildScheduledEventLocationSelectViewModel$StoreState(Guild guild, Map<Long, Channel> map, Map<Long, Long> map2, Long l, GuildScheduledEvent guildScheduledEvent) {
        m.checkNotNullParameter(map, "channels");
        m.checkNotNullParameter(map2, "channelPermissions");
        this.guild = guild;
        this.channels = map;
        this.channelPermissions = map2;
        this.guildPermissions = l;
        this.existingGuildScheduledEvent = guildScheduledEvent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGuildScheduledEventLocationSelectViewModel$StoreState copy$default(WidgetGuildScheduledEventLocationSelectViewModel$StoreState widgetGuildScheduledEventLocationSelectViewModel$StoreState, Guild guild, Map map, Map map2, Long l, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetGuildScheduledEventLocationSelectViewModel$StoreState.guild;
        }
        if ((i & 2) != 0) {
            map = widgetGuildScheduledEventLocationSelectViewModel$StoreState.channels;
        }
        Map map3 = map;
        if ((i & 4) != 0) {
            map2 = widgetGuildScheduledEventLocationSelectViewModel$StoreState.channelPermissions;
        }
        Map map4 = map2;
        if ((i & 8) != 0) {
            l = widgetGuildScheduledEventLocationSelectViewModel$StoreState.guildPermissions;
        }
        Long l2 = l;
        if ((i & 16) != 0) {
            guildScheduledEvent = widgetGuildScheduledEventLocationSelectViewModel$StoreState.existingGuildScheduledEvent;
        }
        return widgetGuildScheduledEventLocationSelectViewModel$StoreState.copy(guild, map3, map4, l2, guildScheduledEvent);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, Channel> component2() {
        return this.channels;
    }

    public final Map<Long, Long> component3() {
        return this.channelPermissions;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getGuildPermissions() {
        return this.guildPermissions;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final GuildScheduledEvent getExistingGuildScheduledEvent() {
        return this.existingGuildScheduledEvent;
    }

    public final WidgetGuildScheduledEventLocationSelectViewModel$StoreState copy(Guild guild, Map<Long, Channel> channels, Map<Long, Long> channelPermissions, Long guildPermissions, GuildScheduledEvent existingGuildScheduledEvent) {
        m.checkNotNullParameter(channels, "channels");
        m.checkNotNullParameter(channelPermissions, "channelPermissions");
        return new WidgetGuildScheduledEventLocationSelectViewModel$StoreState(guild, channels, channelPermissions, guildPermissions, existingGuildScheduledEvent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildScheduledEventLocationSelectViewModel$StoreState)) {
            return false;
        }
        WidgetGuildScheduledEventLocationSelectViewModel$StoreState widgetGuildScheduledEventLocationSelectViewModel$StoreState = (WidgetGuildScheduledEventLocationSelectViewModel$StoreState) other;
        return m.areEqual(this.guild, widgetGuildScheduledEventLocationSelectViewModel$StoreState.guild) && m.areEqual(this.channels, widgetGuildScheduledEventLocationSelectViewModel$StoreState.channels) && m.areEqual(this.channelPermissions, widgetGuildScheduledEventLocationSelectViewModel$StoreState.channelPermissions) && m.areEqual(this.guildPermissions, widgetGuildScheduledEventLocationSelectViewModel$StoreState.guildPermissions) && m.areEqual(this.existingGuildScheduledEvent, widgetGuildScheduledEventLocationSelectViewModel$StoreState.existingGuildScheduledEvent);
    }

    public final Map<Long, Long> getChannelPermissions() {
        return this.channelPermissions;
    }

    public final Map<Long, Channel> getChannels() {
        return this.channels;
    }

    public final GuildScheduledEvent getExistingGuildScheduledEvent() {
        return this.existingGuildScheduledEvent;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Long getGuildPermissions() {
        return this.guildPermissions;
    }

    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        Map<Long, Channel> map = this.channels;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, Long> map2 = this.channelPermissions;
        int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Long l = this.guildPermissions;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        GuildScheduledEvent guildScheduledEvent = this.existingGuildScheduledEvent;
        return iHashCode4 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(guild=");
        sbU.append(this.guild);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", channelPermissions=");
        sbU.append(this.channelPermissions);
        sbU.append(", guildPermissions=");
        sbU.append(this.guildPermissions);
        sbU.append(", existingGuildScheduledEvent=");
        sbU.append(this.existingGuildScheduledEvent);
        sbU.append(")");
        return sbU.toString();
    }
}
