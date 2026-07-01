package com.discord.widgets.channels.memberlist;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.utilities.lazy.memberlist.ChannelMemberList;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelMembersListViewModel$StoreState$Guild extends WidgetChannelMembersListViewModel$StoreState {
    private final Channel channel;
    private final ChannelMemberList channelMembers;
    private final Long channelPermissions;
    private final Guild guild;
    private final Map<Long, GuildRole> guildRoles;
    private final boolean isPanelOpen;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelMembersListViewModel$StoreState$Guild(boolean z2, Channel channel, Guild guild, ChannelMemberList channelMemberList, Long l, Map<Long, GuildRole> map) {
        super(z2, channel, null);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(channelMemberList, "channelMembers");
        m.checkNotNullParameter(map, "guildRoles");
        this.isPanelOpen = z2;
        this.channel = channel;
        this.guild = guild;
        this.channelMembers = channelMemberList;
        this.channelPermissions = l;
        this.guildRoles = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelMembersListViewModel$StoreState$Guild copy$default(WidgetChannelMembersListViewModel$StoreState$Guild widgetChannelMembersListViewModel$StoreState$Guild, boolean z2, Channel channel, Guild guild, ChannelMemberList channelMemberList, Long l, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetChannelMembersListViewModel$StoreState$Guild.getIsPanelOpen();
        }
        if ((i & 2) != 0) {
            channel = widgetChannelMembersListViewModel$StoreState$Guild.getChannel();
        }
        Channel channel2 = channel;
        if ((i & 4) != 0) {
            guild = widgetChannelMembersListViewModel$StoreState$Guild.guild;
        }
        Guild guild2 = guild;
        if ((i & 8) != 0) {
            channelMemberList = widgetChannelMembersListViewModel$StoreState$Guild.channelMembers;
        }
        ChannelMemberList channelMemberList2 = channelMemberList;
        if ((i & 16) != 0) {
            l = widgetChannelMembersListViewModel$StoreState$Guild.channelPermissions;
        }
        Long l2 = l;
        if ((i & 32) != 0) {
            map = widgetChannelMembersListViewModel$StoreState$Guild.guildRoles;
        }
        return widgetChannelMembersListViewModel$StoreState$Guild.copy(z2, channel2, guild2, channelMemberList2, l2, map);
    }

    public final boolean component1() {
        return getIsPanelOpen();
    }

    public final Channel component2() {
        return getChannel();
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ChannelMemberList getChannelMembers() {
        return this.channelMembers;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getChannelPermissions() {
        return this.channelPermissions;
    }

    public final Map<Long, GuildRole> component6() {
        return this.guildRoles;
    }

    public final WidgetChannelMembersListViewModel$StoreState$Guild copy(boolean isPanelOpen, Channel channel, Guild guild, ChannelMemberList channelMembers, Long channelPermissions, Map<Long, GuildRole> guildRoles) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(channelMembers, "channelMembers");
        m.checkNotNullParameter(guildRoles, "guildRoles");
        return new WidgetChannelMembersListViewModel$StoreState$Guild(isPanelOpen, channel, guild, channelMembers, channelPermissions, guildRoles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelMembersListViewModel$StoreState$Guild)) {
            return false;
        }
        WidgetChannelMembersListViewModel$StoreState$Guild widgetChannelMembersListViewModel$StoreState$Guild = (WidgetChannelMembersListViewModel$StoreState$Guild) other;
        return getIsPanelOpen() == widgetChannelMembersListViewModel$StoreState$Guild.getIsPanelOpen() && m.areEqual(getChannel(), widgetChannelMembersListViewModel$StoreState$Guild.getChannel()) && m.areEqual(this.guild, widgetChannelMembersListViewModel$StoreState$Guild.guild) && m.areEqual(this.channelMembers, widgetChannelMembersListViewModel$StoreState$Guild.channelMembers) && m.areEqual(this.channelPermissions, widgetChannelMembersListViewModel$StoreState$Guild.channelPermissions) && m.areEqual(this.guildRoles, widgetChannelMembersListViewModel$StoreState$Guild.guildRoles);
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$StoreState
    public Channel getChannel() {
        return this.channel;
    }

    public final ChannelMemberList getChannelMembers() {
        return this.channelMembers;
    }

    public final Long getChannelPermissions() {
        return this.channelPermissions;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, GuildRole> getGuildRoles() {
        return this.guildRoles;
    }

    public int hashCode() {
        boolean isPanelOpen = getIsPanelOpen();
        int i = isPanelOpen;
        if (isPanelOpen) {
            i = 1;
        }
        int i2 = i * 31;
        Channel channel = getChannel();
        int iHashCode = (i2 + (channel != null ? channel.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        ChannelMemberList channelMemberList = this.channelMembers;
        int iHashCode3 = (iHashCode2 + (channelMemberList != null ? channelMemberList.hashCode() : 0)) * 31;
        Long l = this.channelPermissions;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map = this.guildRoles;
        return iHashCode4 + (map != null ? map.hashCode() : 0);
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$StoreState
    /* JADX INFO: renamed from: isPanelOpen, reason: from getter */
    public boolean getIsPanelOpen() {
        return this.isPanelOpen;
    }

    public String toString() {
        StringBuilder sbU = a.U("Guild(isPanelOpen=");
        sbU.append(getIsPanelOpen());
        sbU.append(", channel=");
        sbU.append(getChannel());
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", channelMembers=");
        sbU.append(this.channelMembers);
        sbU.append(", channelPermissions=");
        sbU.append(this.channelPermissions);
        sbU.append(", guildRoles=");
        return a.M(sbU, this.guildRoles, ")");
    }
}
