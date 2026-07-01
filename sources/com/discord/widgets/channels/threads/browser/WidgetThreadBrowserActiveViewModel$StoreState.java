package com.discord.widgets.channels.threads.browser;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreThreadMessages$ThreadState;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetThreadBrowserActiveViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadBrowserActiveViewModel$StoreState {
    private final Map<Long, Channel> activeJoinedThreads;
    private final Map<Long, Channel> activeThreads;
    private final Map<Long, Integer> blockedUsers;
    private final Channel channel;
    private final Map<Long, String> channelNames;
    private final Guild guild;
    private final Map<Long, GuildMember> guildMembers;
    private final Map<Long, GuildRole> guildRoles;
    private final MeUser meUser;
    private final Long permissions;
    private final Map<Long, StoreThreadMessages$ThreadState> threadStates;
    private final Map<Long, User> users;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetThreadBrowserActiveViewModel$StoreState(MeUser meUser, Map<Long, Channel> map, Map<Long, Channel> map2, Map<Long, StoreThreadMessages$ThreadState> map3, Map<Long, GuildMember> map4, Map<Long, ? extends User> map5, Map<Long, GuildRole> map6, Map<Long, String> map7, Long l, Map<Long, Integer> map8, Channel channel, Guild guild) {
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(map, "activeJoinedThreads");
        m.checkNotNullParameter(map2, "activeThreads");
        m.checkNotNullParameter(map3, "threadStates");
        m.checkNotNullParameter(map4, "guildMembers");
        m.checkNotNullParameter(map5, "users");
        m.checkNotNullParameter(map6, "guildRoles");
        m.checkNotNullParameter(map7, "channelNames");
        m.checkNotNullParameter(map8, "blockedUsers");
        this.meUser = meUser;
        this.activeJoinedThreads = map;
        this.activeThreads = map2;
        this.threadStates = map3;
        this.guildMembers = map4;
        this.users = map5;
        this.guildRoles = map6;
        this.channelNames = map7;
        this.permissions = l;
        this.blockedUsers = map8;
        this.channel = channel;
        this.guild = guild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetThreadBrowserActiveViewModel$StoreState copy$default(WidgetThreadBrowserActiveViewModel$StoreState widgetThreadBrowserActiveViewModel$StoreState, MeUser meUser, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Long l, Map map8, Channel channel, Guild guild, int i, Object obj) {
        return widgetThreadBrowserActiveViewModel$StoreState.copy((i & 1) != 0 ? widgetThreadBrowserActiveViewModel$StoreState.meUser : meUser, (i & 2) != 0 ? widgetThreadBrowserActiveViewModel$StoreState.activeJoinedThreads : map, (i & 4) != 0 ? widgetThreadBrowserActiveViewModel$StoreState.activeThreads : map2, (i & 8) != 0 ? widgetThreadBrowserActiveViewModel$StoreState.threadStates : map3, (i & 16) != 0 ? widgetThreadBrowserActiveViewModel$StoreState.guildMembers : map4, (i & 32) != 0 ? widgetThreadBrowserActiveViewModel$StoreState.users : map5, (i & 64) != 0 ? widgetThreadBrowserActiveViewModel$StoreState.guildRoles : map6, (i & 128) != 0 ? widgetThreadBrowserActiveViewModel$StoreState.channelNames : map7, (i & 256) != 0 ? widgetThreadBrowserActiveViewModel$StoreState.permissions : l, (i & 512) != 0 ? widgetThreadBrowserActiveViewModel$StoreState.blockedUsers : map8, (i & 1024) != 0 ? widgetThreadBrowserActiveViewModel$StoreState.channel : channel, (i & 2048) != 0 ? widgetThreadBrowserActiveViewModel$StoreState.guild : guild);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final Map<Long, Integer> component10() {
        return this.blockedUsers;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, Channel> component2() {
        return this.activeJoinedThreads;
    }

    public final Map<Long, Channel> component3() {
        return this.activeThreads;
    }

    public final Map<Long, StoreThreadMessages$ThreadState> component4() {
        return this.threadStates;
    }

    public final Map<Long, GuildMember> component5() {
        return this.guildMembers;
    }

    public final Map<Long, User> component6() {
        return this.users;
    }

    public final Map<Long, GuildRole> component7() {
        return this.guildRoles;
    }

    public final Map<Long, String> component8() {
        return this.channelNames;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Long getPermissions() {
        return this.permissions;
    }

    public final WidgetThreadBrowserActiveViewModel$StoreState copy(MeUser meUser, Map<Long, Channel> activeJoinedThreads, Map<Long, Channel> activeThreads, Map<Long, StoreThreadMessages$ThreadState> threadStates, Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> users, Map<Long, GuildRole> guildRoles, Map<Long, String> channelNames, Long permissions, Map<Long, Integer> blockedUsers, Channel channel, Guild guild) {
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(activeJoinedThreads, "activeJoinedThreads");
        m.checkNotNullParameter(activeThreads, "activeThreads");
        m.checkNotNullParameter(threadStates, "threadStates");
        m.checkNotNullParameter(guildMembers, "guildMembers");
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(guildRoles, "guildRoles");
        m.checkNotNullParameter(channelNames, "channelNames");
        m.checkNotNullParameter(blockedUsers, "blockedUsers");
        return new WidgetThreadBrowserActiveViewModel$StoreState(meUser, activeJoinedThreads, activeThreads, threadStates, guildMembers, users, guildRoles, channelNames, permissions, blockedUsers, channel, guild);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetThreadBrowserActiveViewModel$StoreState)) {
            return false;
        }
        WidgetThreadBrowserActiveViewModel$StoreState widgetThreadBrowserActiveViewModel$StoreState = (WidgetThreadBrowserActiveViewModel$StoreState) other;
        return m.areEqual(this.meUser, widgetThreadBrowserActiveViewModel$StoreState.meUser) && m.areEqual(this.activeJoinedThreads, widgetThreadBrowserActiveViewModel$StoreState.activeJoinedThreads) && m.areEqual(this.activeThreads, widgetThreadBrowserActiveViewModel$StoreState.activeThreads) && m.areEqual(this.threadStates, widgetThreadBrowserActiveViewModel$StoreState.threadStates) && m.areEqual(this.guildMembers, widgetThreadBrowserActiveViewModel$StoreState.guildMembers) && m.areEqual(this.users, widgetThreadBrowserActiveViewModel$StoreState.users) && m.areEqual(this.guildRoles, widgetThreadBrowserActiveViewModel$StoreState.guildRoles) && m.areEqual(this.channelNames, widgetThreadBrowserActiveViewModel$StoreState.channelNames) && m.areEqual(this.permissions, widgetThreadBrowserActiveViewModel$StoreState.permissions) && m.areEqual(this.blockedUsers, widgetThreadBrowserActiveViewModel$StoreState.blockedUsers) && m.areEqual(this.channel, widgetThreadBrowserActiveViewModel$StoreState.channel) && m.areEqual(this.guild, widgetThreadBrowserActiveViewModel$StoreState.guild);
    }

    public final Map<Long, Channel> getActiveJoinedThreads() {
        return this.activeJoinedThreads;
    }

    public final Map<Long, Channel> getActiveThreads() {
        return this.activeThreads;
    }

    public final Map<Long, Integer> getBlockedUsers() {
        return this.blockedUsers;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Map<Long, String> getChannelNames() {
        return this.channelNames;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    public final Map<Long, GuildRole> getGuildRoles() {
        return this.guildRoles;
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final Long getPermissions() {
        return this.permissions;
    }

    public final Map<Long, StoreThreadMessages$ThreadState> getThreadStates() {
        return this.threadStates;
    }

    public final Map<Long, User> getUsers() {
        return this.users;
    }

    public int hashCode() {
        MeUser meUser = this.meUser;
        int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
        Map<Long, Channel> map = this.activeJoinedThreads;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, Channel> map2 = this.activeThreads;
        int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, StoreThreadMessages$ThreadState> map3 = this.threadStates;
        int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<Long, GuildMember> map4 = this.guildMembers;
        int iHashCode5 = (iHashCode4 + (map4 != null ? map4.hashCode() : 0)) * 31;
        Map<Long, User> map5 = this.users;
        int iHashCode6 = (iHashCode5 + (map5 != null ? map5.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map6 = this.guildRoles;
        int iHashCode7 = (iHashCode6 + (map6 != null ? map6.hashCode() : 0)) * 31;
        Map<Long, String> map7 = this.channelNames;
        int iHashCode8 = (iHashCode7 + (map7 != null ? map7.hashCode() : 0)) * 31;
        Long l = this.permissions;
        int iHashCode9 = (iHashCode8 + (l != null ? l.hashCode() : 0)) * 31;
        Map<Long, Integer> map8 = this.blockedUsers;
        int iHashCode10 = (iHashCode9 + (map8 != null ? map8.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode11 = (iHashCode10 + (channel != null ? channel.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        return iHashCode11 + (guild != null ? guild.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(meUser=");
        sbU.append(this.meUser);
        sbU.append(", activeJoinedThreads=");
        sbU.append(this.activeJoinedThreads);
        sbU.append(", activeThreads=");
        sbU.append(this.activeThreads);
        sbU.append(", threadStates=");
        sbU.append(this.threadStates);
        sbU.append(", guildMembers=");
        sbU.append(this.guildMembers);
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", guildRoles=");
        sbU.append(this.guildRoles);
        sbU.append(", channelNames=");
        sbU.append(this.channelNames);
        sbU.append(", permissions=");
        sbU.append(this.permissions);
        sbU.append(", blockedUsers=");
        sbU.append(this.blockedUsers);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(")");
        return sbU.toString();
    }
}
