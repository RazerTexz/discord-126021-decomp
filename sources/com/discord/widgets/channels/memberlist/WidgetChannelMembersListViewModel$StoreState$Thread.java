package com.discord.widgets.channels.memberlist;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreThreadsJoined$JoinedThread;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelMembersListViewModel$StoreState$Thread extends WidgetChannelMembersListViewModel$StoreState {
    private final Channel channel;
    private final Guild guild;
    private final Map<Long, GuildMember> guildMembers;
    private final boolean isPanelOpen;
    private final StoreThreadsJoined$JoinedThread joinedThread;
    private final Channel parentChannel;
    private final Map<Long, Presence> presences;
    private final Map<Long, GuildRole> roles;
    private final Map<Long, ModelApplicationStream> streams;
    private final Set<Long> threadMembers;
    private final Map<Long, User> users;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChannelMembersListViewModel$StoreState$Thread(boolean z2, Channel channel, Channel channel2, Guild guild, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Map<Long, ? extends User> map3, Map<Long, Presence> map4, Map<Long, ? extends ModelApplicationStream> map5, Set<Long> set, StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread) {
        super(z2, channel, null);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(map, "roles");
        m.checkNotNullParameter(map2, "guildMembers");
        m.checkNotNullParameter(map3, "users");
        m.checkNotNullParameter(map4, "presences");
        m.checkNotNullParameter(map5, "streams");
        m.checkNotNullParameter(set, "threadMembers");
        this.isPanelOpen = z2;
        this.channel = channel;
        this.parentChannel = channel2;
        this.guild = guild;
        this.roles = map;
        this.guildMembers = map2;
        this.users = map3;
        this.presences = map4;
        this.streams = map5;
        this.threadMembers = set;
        this.joinedThread = storeThreadsJoined$JoinedThread;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelMembersListViewModel$StoreState$Thread copy$default(WidgetChannelMembersListViewModel$StoreState$Thread widgetChannelMembersListViewModel$StoreState$Thread, boolean z2, Channel channel, Channel channel2, Guild guild, Map map, Map map2, Map map3, Map map4, Map map5, Set set, StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread, int i, Object obj) {
        return widgetChannelMembersListViewModel$StoreState$Thread.copy((i & 1) != 0 ? widgetChannelMembersListViewModel$StoreState$Thread.getIsPanelOpen() : z2, (i & 2) != 0 ? widgetChannelMembersListViewModel$StoreState$Thread.getChannel() : channel, (i & 4) != 0 ? widgetChannelMembersListViewModel$StoreState$Thread.parentChannel : channel2, (i & 8) != 0 ? widgetChannelMembersListViewModel$StoreState$Thread.guild : guild, (i & 16) != 0 ? widgetChannelMembersListViewModel$StoreState$Thread.roles : map, (i & 32) != 0 ? widgetChannelMembersListViewModel$StoreState$Thread.guildMembers : map2, (i & 64) != 0 ? widgetChannelMembersListViewModel$StoreState$Thread.users : map3, (i & 128) != 0 ? widgetChannelMembersListViewModel$StoreState$Thread.presences : map4, (i & 256) != 0 ? widgetChannelMembersListViewModel$StoreState$Thread.streams : map5, (i & 512) != 0 ? widgetChannelMembersListViewModel$StoreState$Thread.threadMembers : set, (i & 1024) != 0 ? widgetChannelMembersListViewModel$StoreState$Thread.joinedThread : storeThreadsJoined$JoinedThread);
    }

    public final boolean component1() {
        return getIsPanelOpen();
    }

    public final Set<Long> component10() {
        return this.threadMembers;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final StoreThreadsJoined$JoinedThread getJoinedThread() {
        return this.joinedThread;
    }

    public final Channel component2() {
        return getChannel();
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, GuildRole> component5() {
        return this.roles;
    }

    public final Map<Long, GuildMember> component6() {
        return this.guildMembers;
    }

    public final Map<Long, User> component7() {
        return this.users;
    }

    public final Map<Long, Presence> component8() {
        return this.presences;
    }

    public final Map<Long, ModelApplicationStream> component9() {
        return this.streams;
    }

    public final WidgetChannelMembersListViewModel$StoreState$Thread copy(boolean isPanelOpen, Channel channel, Channel parentChannel, Guild guild, Map<Long, GuildRole> roles, Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> streams, Set<Long> threadMembers, StoreThreadsJoined$JoinedThread joinedThread) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(roles, "roles");
        m.checkNotNullParameter(guildMembers, "guildMembers");
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(presences, "presences");
        m.checkNotNullParameter(streams, "streams");
        m.checkNotNullParameter(threadMembers, "threadMembers");
        return new WidgetChannelMembersListViewModel$StoreState$Thread(isPanelOpen, channel, parentChannel, guild, roles, guildMembers, users, presences, streams, threadMembers, joinedThread);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelMembersListViewModel$StoreState$Thread)) {
            return false;
        }
        WidgetChannelMembersListViewModel$StoreState$Thread widgetChannelMembersListViewModel$StoreState$Thread = (WidgetChannelMembersListViewModel$StoreState$Thread) other;
        return getIsPanelOpen() == widgetChannelMembersListViewModel$StoreState$Thread.getIsPanelOpen() && m.areEqual(getChannel(), widgetChannelMembersListViewModel$StoreState$Thread.getChannel()) && m.areEqual(this.parentChannel, widgetChannelMembersListViewModel$StoreState$Thread.parentChannel) && m.areEqual(this.guild, widgetChannelMembersListViewModel$StoreState$Thread.guild) && m.areEqual(this.roles, widgetChannelMembersListViewModel$StoreState$Thread.roles) && m.areEqual(this.guildMembers, widgetChannelMembersListViewModel$StoreState$Thread.guildMembers) && m.areEqual(this.users, widgetChannelMembersListViewModel$StoreState$Thread.users) && m.areEqual(this.presences, widgetChannelMembersListViewModel$StoreState$Thread.presences) && m.areEqual(this.streams, widgetChannelMembersListViewModel$StoreState$Thread.streams) && m.areEqual(this.threadMembers, widgetChannelMembersListViewModel$StoreState$Thread.threadMembers) && m.areEqual(this.joinedThread, widgetChannelMembersListViewModel$StoreState$Thread.joinedThread);
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$StoreState
    public Channel getChannel() {
        return this.channel;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    public final StoreThreadsJoined$JoinedThread getJoinedThread() {
        return this.joinedThread;
    }

    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    public final Map<Long, Presence> getPresences() {
        return this.presences;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    public final Map<Long, ModelApplicationStream> getStreams() {
        return this.streams;
    }

    public final Set<Long> getThreadMembers() {
        return this.threadMembers;
    }

    public final Map<Long, User> getUsers() {
        return this.users;
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
        Channel channel2 = this.parentChannel;
        int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int iHashCode3 = (iHashCode2 + (guild != null ? guild.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map = this.roles;
        int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, GuildMember> map2 = this.guildMembers;
        int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, User> map3 = this.users;
        int iHashCode6 = (iHashCode5 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<Long, Presence> map4 = this.presences;
        int iHashCode7 = (iHashCode6 + (map4 != null ? map4.hashCode() : 0)) * 31;
        Map<Long, ModelApplicationStream> map5 = this.streams;
        int iHashCode8 = (iHashCode7 + (map5 != null ? map5.hashCode() : 0)) * 31;
        Set<Long> set = this.threadMembers;
        int iHashCode9 = (iHashCode8 + (set != null ? set.hashCode() : 0)) * 31;
        StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread = this.joinedThread;
        return iHashCode9 + (storeThreadsJoined$JoinedThread != null ? storeThreadsJoined$JoinedThread.hashCode() : 0);
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$StoreState
    /* JADX INFO: renamed from: isPanelOpen, reason: from getter */
    public boolean getIsPanelOpen() {
        return this.isPanelOpen;
    }

    public String toString() {
        StringBuilder sbU = a.U("Thread(isPanelOpen=");
        sbU.append(getIsPanelOpen());
        sbU.append(", channel=");
        sbU.append(getChannel());
        sbU.append(", parentChannel=");
        sbU.append(this.parentChannel);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", guildMembers=");
        sbU.append(this.guildMembers);
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", presences=");
        sbU.append(this.presences);
        sbU.append(", streams=");
        sbU.append(this.streams);
        sbU.append(", threadMembers=");
        sbU.append(this.threadMembers);
        sbU.append(", joinedThread=");
        sbU.append(this.joinedThread);
        sbU.append(")");
        return sbU.toString();
    }
}
