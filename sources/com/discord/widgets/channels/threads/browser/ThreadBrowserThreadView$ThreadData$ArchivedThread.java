package com.discord.widgets.channels.threads.browser;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: ThreadBrowserThreadView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ThreadBrowserThreadView$ThreadData$ArchivedThread extends ThreadBrowserThreadView$ThreadData {
    private final Channel channel;
    private final Map<Long, GuildMember> guildMembers;
    private final User owner;
    private final ThreadBrowserThreadView$TimestampMode timestampMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadBrowserThreadView$ThreadData$ArchivedThread(Channel channel, Map<Long, GuildMember> map, User user, ThreadBrowserThreadView$TimestampMode threadBrowserThreadView$TimestampMode) {
        super(channel, user, map, null);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(map, "guildMembers");
        m.checkNotNullParameter(threadBrowserThreadView$TimestampMode, "timestampMode");
        this.channel = channel;
        this.guildMembers = map;
        this.owner = user;
        this.timestampMode = threadBrowserThreadView$TimestampMode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ThreadBrowserThreadView$ThreadData$ArchivedThread copy$default(ThreadBrowserThreadView$ThreadData$ArchivedThread threadBrowserThreadView$ThreadData$ArchivedThread, Channel channel, Map map, User user, ThreadBrowserThreadView$TimestampMode threadBrowserThreadView$TimestampMode, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = threadBrowserThreadView$ThreadData$ArchivedThread.getChannel();
        }
        if ((i & 2) != 0) {
            map = threadBrowserThreadView$ThreadData$ArchivedThread.getGuildMembers();
        }
        if ((i & 4) != 0) {
            user = threadBrowserThreadView$ThreadData$ArchivedThread.getOwner();
        }
        if ((i & 8) != 0) {
            threadBrowserThreadView$TimestampMode = threadBrowserThreadView$ThreadData$ArchivedThread.timestampMode;
        }
        return threadBrowserThreadView$ThreadData$ArchivedThread.copy(channel, map, user, threadBrowserThreadView$TimestampMode);
    }

    public final Channel component1() {
        return getChannel();
    }

    public final Map<Long, GuildMember> component2() {
        return getGuildMembers();
    }

    public final User component3() {
        return getOwner();
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ThreadBrowserThreadView$TimestampMode getTimestampMode() {
        return this.timestampMode;
    }

    public final ThreadBrowserThreadView$ThreadData$ArchivedThread copy(Channel channel, Map<Long, GuildMember> guildMembers, User owner, ThreadBrowserThreadView$TimestampMode timestampMode) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(guildMembers, "guildMembers");
        m.checkNotNullParameter(timestampMode, "timestampMode");
        return new ThreadBrowserThreadView$ThreadData$ArchivedThread(channel, guildMembers, owner, timestampMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadBrowserThreadView$ThreadData$ArchivedThread)) {
            return false;
        }
        ThreadBrowserThreadView$ThreadData$ArchivedThread threadBrowserThreadView$ThreadData$ArchivedThread = (ThreadBrowserThreadView$ThreadData$ArchivedThread) other;
        return m.areEqual(getChannel(), threadBrowserThreadView$ThreadData$ArchivedThread.getChannel()) && m.areEqual(getGuildMembers(), threadBrowserThreadView$ThreadData$ArchivedThread.getGuildMembers()) && m.areEqual(getOwner(), threadBrowserThreadView$ThreadData$ArchivedThread.getOwner()) && m.areEqual(this.timestampMode, threadBrowserThreadView$ThreadData$ArchivedThread.timestampMode);
    }

    @Override // com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView$ThreadData
    public Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView$ThreadData
    public Map<Long, GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    @Override // com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView$ThreadData
    public User getOwner() {
        return this.owner;
    }

    public final ThreadBrowserThreadView$TimestampMode getTimestampMode() {
        return this.timestampMode;
    }

    public int hashCode() {
        Channel channel = getChannel();
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Map<Long, GuildMember> guildMembers = getGuildMembers();
        int iHashCode2 = (iHashCode + (guildMembers != null ? guildMembers.hashCode() : 0)) * 31;
        User owner = getOwner();
        int iHashCode3 = (iHashCode2 + (owner != null ? owner.hashCode() : 0)) * 31;
        ThreadBrowserThreadView$TimestampMode threadBrowserThreadView$TimestampMode = this.timestampMode;
        return iHashCode3 + (threadBrowserThreadView$TimestampMode != null ? threadBrowserThreadView$TimestampMode.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ArchivedThread(channel=");
        sbU.append(getChannel());
        sbU.append(", guildMembers=");
        sbU.append(getGuildMembers());
        sbU.append(", owner=");
        sbU.append(getOwner());
        sbU.append(", timestampMode=");
        sbU.append(this.timestampMode);
        sbU.append(")");
        return sbU.toString();
    }
}
