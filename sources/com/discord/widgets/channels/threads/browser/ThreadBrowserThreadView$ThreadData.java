package com.discord.widgets.channels.threads.browser;

import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ThreadBrowserThreadView.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ThreadBrowserThreadView$ThreadData {
    private final Channel channel;
    private final Map<Long, GuildMember> guildMembers;
    private final User owner;

    private ThreadBrowserThreadView$ThreadData(Channel channel, User user, Map<Long, GuildMember> map) {
        this.channel = channel;
        this.owner = user;
        this.guildMembers = map;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public Map<Long, GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    public User getOwner() {
        return this.owner;
    }

    public /* synthetic */ ThreadBrowserThreadView$ThreadData(Channel channel, User user, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, user, map);
    }
}
