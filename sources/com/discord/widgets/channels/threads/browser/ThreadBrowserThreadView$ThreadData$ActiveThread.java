package com.discord.widgets.channels.threads.browser;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: ThreadBrowserThreadView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ThreadBrowserThreadView$ThreadData$ActiveThread extends ThreadBrowserThreadView$ThreadData {
    private final Channel channel;
    private final Map<Long, String> channelNames;
    private final Map<Long, GuildMember> guildMembers;
    private final Map<Long, GuildRole> guildRoles;
    private final boolean isMessageBlocked;
    private final Message message;
    private final long myUserId;
    private final User owner;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadBrowserThreadView$ThreadData$ActiveThread(Channel channel, User user, Message message, long j, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Map<Long, String> map3, boolean z2) {
        super(channel, user, map, null);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(map, "guildMembers");
        m.checkNotNullParameter(map2, "guildRoles");
        m.checkNotNullParameter(map3, "channelNames");
        this.channel = channel;
        this.owner = user;
        this.message = message;
        this.myUserId = j;
        this.guildMembers = map;
        this.guildRoles = map2;
        this.channelNames = map3;
        this.isMessageBlocked = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ThreadBrowserThreadView$ThreadData$ActiveThread copy$default(ThreadBrowserThreadView$ThreadData$ActiveThread threadBrowserThreadView$ThreadData$ActiveThread, Channel channel, User user, Message message, long j, Map map, Map map2, Map map3, boolean z2, int i, Object obj) {
        return threadBrowserThreadView$ThreadData$ActiveThread.copy((i & 1) != 0 ? threadBrowserThreadView$ThreadData$ActiveThread.getChannel() : channel, (i & 2) != 0 ? threadBrowserThreadView$ThreadData$ActiveThread.getOwner() : user, (i & 4) != 0 ? threadBrowserThreadView$ThreadData$ActiveThread.message : message, (i & 8) != 0 ? threadBrowserThreadView$ThreadData$ActiveThread.myUserId : j, (i & 16) != 0 ? threadBrowserThreadView$ThreadData$ActiveThread.getGuildMembers() : map, (i & 32) != 0 ? threadBrowserThreadView$ThreadData$ActiveThread.guildRoles : map2, (i & 64) != 0 ? threadBrowserThreadView$ThreadData$ActiveThread.channelNames : map3, (i & 128) != 0 ? threadBrowserThreadView$ThreadData$ActiveThread.isMessageBlocked : z2);
    }

    public final Channel component1() {
        return getChannel();
    }

    public final User component2() {
        return getOwner();
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getMyUserId() {
        return this.myUserId;
    }

    public final Map<Long, GuildMember> component5() {
        return getGuildMembers();
    }

    public final Map<Long, GuildRole> component6() {
        return this.guildRoles;
    }

    public final Map<Long, String> component7() {
        return this.channelNames;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsMessageBlocked() {
        return this.isMessageBlocked;
    }

    public final ThreadBrowserThreadView$ThreadData$ActiveThread copy(Channel channel, User owner, Message message, long myUserId, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Map<Long, String> channelNames, boolean isMessageBlocked) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(guildMembers, "guildMembers");
        m.checkNotNullParameter(guildRoles, "guildRoles");
        m.checkNotNullParameter(channelNames, "channelNames");
        return new ThreadBrowserThreadView$ThreadData$ActiveThread(channel, owner, message, myUserId, guildMembers, guildRoles, channelNames, isMessageBlocked);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadBrowserThreadView$ThreadData$ActiveThread)) {
            return false;
        }
        ThreadBrowserThreadView$ThreadData$ActiveThread threadBrowserThreadView$ThreadData$ActiveThread = (ThreadBrowserThreadView$ThreadData$ActiveThread) other;
        return m.areEqual(getChannel(), threadBrowserThreadView$ThreadData$ActiveThread.getChannel()) && m.areEqual(getOwner(), threadBrowserThreadView$ThreadData$ActiveThread.getOwner()) && m.areEqual(this.message, threadBrowserThreadView$ThreadData$ActiveThread.message) && this.myUserId == threadBrowserThreadView$ThreadData$ActiveThread.myUserId && m.areEqual(getGuildMembers(), threadBrowserThreadView$ThreadData$ActiveThread.getGuildMembers()) && m.areEqual(this.guildRoles, threadBrowserThreadView$ThreadData$ActiveThread.guildRoles) && m.areEqual(this.channelNames, threadBrowserThreadView$ThreadData$ActiveThread.channelNames) && this.isMessageBlocked == threadBrowserThreadView$ThreadData$ActiveThread.isMessageBlocked;
    }

    @Override // com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView$ThreadData
    public Channel getChannel() {
        return this.channel;
    }

    public final Map<Long, String> getChannelNames() {
        return this.channelNames;
    }

    @Override // com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView$ThreadData
    public Map<Long, GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    public final Map<Long, GuildRole> getGuildRoles() {
        return this.guildRoles;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final long getMyUserId() {
        return this.myUserId;
    }

    @Override // com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView$ThreadData
    public User getOwner() {
        return this.owner;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    public int hashCode() {
        Channel channel = getChannel();
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        User owner = getOwner();
        int iHashCode2 = (iHashCode + (owner != null ? owner.hashCode() : 0)) * 31;
        Message message = this.message;
        int iA = (b.a(this.myUserId) + ((iHashCode2 + (message != null ? message.hashCode() : 0)) * 31)) * 31;
        Map<Long, GuildMember> guildMembers = getGuildMembers();
        int iHashCode3 = (iA + (guildMembers != null ? guildMembers.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map = this.guildRoles;
        int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, String> map2 = this.channelNames;
        int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
        boolean z2 = this.isMessageBlocked;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return iHashCode5 + r0;
    }

    public final boolean isMessageBlocked() {
        return this.isMessageBlocked;
    }

    public String toString() {
        StringBuilder sbU = a.U("ActiveThread(channel=");
        sbU.append(getChannel());
        sbU.append(", owner=");
        sbU.append(getOwner());
        sbU.append(", message=");
        sbU.append(this.message);
        sbU.append(", myUserId=");
        sbU.append(this.myUserId);
        sbU.append(", guildMembers=");
        sbU.append(getGuildMembers());
        sbU.append(", guildRoles=");
        sbU.append(this.guildRoles);
        sbU.append(", channelNames=");
        sbU.append(this.channelNames);
        sbU.append(", isMessageBlocked=");
        return a.O(sbU, this.isMessageBlocked, ")");
    }
}
