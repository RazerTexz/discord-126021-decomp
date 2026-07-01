package com.discord.widgets.channels.permissions;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelSettingsAddMemberFragmentViewModel$StoreState {
    private final Channel channel;
    private final Map<Long, PermissionOverwrite> channelPermissionOverwritesMap;
    private final Guild guild;
    private final Map<Long, GuildMember> members;
    private final Map<Long, GuildRole> roles;
    private final Map<Long, User> users;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChannelSettingsAddMemberFragmentViewModel$StoreState(Guild guild, Channel channel, Map<Long, PermissionOverwrite> map, Map<Long, GuildRole> map2, Map<Long, GuildMember> map3, Map<Long, ? extends User> map4) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(map, "channelPermissionOverwritesMap");
        m.checkNotNullParameter(map2, "roles");
        m.checkNotNullParameter(map3, "members");
        m.checkNotNullParameter(map4, "users");
        this.guild = guild;
        this.channel = channel;
        this.channelPermissionOverwritesMap = map;
        this.roles = map2;
        this.members = map3;
        this.users = map4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelSettingsAddMemberFragmentViewModel$StoreState copy$default(WidgetChannelSettingsAddMemberFragmentViewModel$StoreState widgetChannelSettingsAddMemberFragmentViewModel$StoreState, Guild guild, Channel channel, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetChannelSettingsAddMemberFragmentViewModel$StoreState.guild;
        }
        if ((i & 2) != 0) {
            channel = widgetChannelSettingsAddMemberFragmentViewModel$StoreState.channel;
        }
        Channel channel2 = channel;
        if ((i & 4) != 0) {
            map = widgetChannelSettingsAddMemberFragmentViewModel$StoreState.channelPermissionOverwritesMap;
        }
        Map map5 = map;
        if ((i & 8) != 0) {
            map2 = widgetChannelSettingsAddMemberFragmentViewModel$StoreState.roles;
        }
        Map map6 = map2;
        if ((i & 16) != 0) {
            map3 = widgetChannelSettingsAddMemberFragmentViewModel$StoreState.members;
        }
        Map map7 = map3;
        if ((i & 32) != 0) {
            map4 = widgetChannelSettingsAddMemberFragmentViewModel$StoreState.users;
        }
        return widgetChannelSettingsAddMemberFragmentViewModel$StoreState.copy(guild, channel2, map5, map6, map7, map4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final Map<Long, PermissionOverwrite> component3() {
        return this.channelPermissionOverwritesMap;
    }

    public final Map<Long, GuildRole> component4() {
        return this.roles;
    }

    public final Map<Long, GuildMember> component5() {
        return this.members;
    }

    public final Map<Long, User> component6() {
        return this.users;
    }

    public final WidgetChannelSettingsAddMemberFragmentViewModel$StoreState copy(Guild guild, Channel channel, Map<Long, PermissionOverwrite> channelPermissionOverwritesMap, Map<Long, GuildRole> roles, Map<Long, GuildMember> members, Map<Long, ? extends User> users) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(channelPermissionOverwritesMap, "channelPermissionOverwritesMap");
        m.checkNotNullParameter(roles, "roles");
        m.checkNotNullParameter(members, "members");
        m.checkNotNullParameter(users, "users");
        return new WidgetChannelSettingsAddMemberFragmentViewModel$StoreState(guild, channel, channelPermissionOverwritesMap, roles, members, users);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelSettingsAddMemberFragmentViewModel$StoreState)) {
            return false;
        }
        WidgetChannelSettingsAddMemberFragmentViewModel$StoreState widgetChannelSettingsAddMemberFragmentViewModel$StoreState = (WidgetChannelSettingsAddMemberFragmentViewModel$StoreState) other;
        return m.areEqual(this.guild, widgetChannelSettingsAddMemberFragmentViewModel$StoreState.guild) && m.areEqual(this.channel, widgetChannelSettingsAddMemberFragmentViewModel$StoreState.channel) && m.areEqual(this.channelPermissionOverwritesMap, widgetChannelSettingsAddMemberFragmentViewModel$StoreState.channelPermissionOverwritesMap) && m.areEqual(this.roles, widgetChannelSettingsAddMemberFragmentViewModel$StoreState.roles) && m.areEqual(this.members, widgetChannelSettingsAddMemberFragmentViewModel$StoreState.members) && m.areEqual(this.users, widgetChannelSettingsAddMemberFragmentViewModel$StoreState.users);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Map<Long, PermissionOverwrite> getChannelPermissionOverwritesMap() {
        return this.channelPermissionOverwritesMap;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, GuildMember> getMembers() {
        return this.members;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    public final Map<Long, User> getUsers() {
        return this.users;
    }

    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        Channel channel = this.channel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        Map<Long, PermissionOverwrite> map = this.channelPermissionOverwritesMap;
        int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map2 = this.roles;
        int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, GuildMember> map3 = this.members;
        int iHashCode5 = (iHashCode4 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<Long, User> map4 = this.users;
        return iHashCode5 + (map4 != null ? map4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(guild=");
        sbU.append(this.guild);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", channelPermissionOverwritesMap=");
        sbU.append(this.channelPermissionOverwritesMap);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", members=");
        sbU.append(this.members);
        sbU.append(", users=");
        return a.M(sbU, this.users, ")");
    }
}
