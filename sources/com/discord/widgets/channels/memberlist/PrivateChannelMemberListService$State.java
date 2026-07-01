package com.discord.widgets.channels.memberlist;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: PrivateChannelMemberListService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PrivateChannelMemberListService$State {
    private final Map<Long, ModelApplicationStream> applicationStreams;
    private final Channel channel;
    private final Map<Long, Presence> presences;
    private final Map<Long, User> users;

    /* JADX WARN: Multi-variable type inference failed */
    public PrivateChannelMemberListService$State(Channel channel, Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(map, "users");
        m.checkNotNullParameter(map2, "presences");
        m.checkNotNullParameter(map3, "applicationStreams");
        this.channel = channel;
        this.users = map;
        this.presences = map2;
        this.applicationStreams = map3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PrivateChannelMemberListService$State copy$default(PrivateChannelMemberListService$State privateChannelMemberListService$State, Channel channel, Map map, Map map2, Map map3, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = privateChannelMemberListService$State.channel;
        }
        if ((i & 2) != 0) {
            map = privateChannelMemberListService$State.users;
        }
        if ((i & 4) != 0) {
            map2 = privateChannelMemberListService$State.presences;
        }
        if ((i & 8) != 0) {
            map3 = privateChannelMemberListService$State.applicationStreams;
        }
        return privateChannelMemberListService$State.copy(channel, map, map2, map3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final Map<Long, User> component2() {
        return this.users;
    }

    public final Map<Long, Presence> component3() {
        return this.presences;
    }

    public final Map<Long, ModelApplicationStream> component4() {
        return this.applicationStreams;
    }

    public final PrivateChannelMemberListService$State copy(Channel channel, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> applicationStreams) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(presences, "presences");
        m.checkNotNullParameter(applicationStreams, "applicationStreams");
        return new PrivateChannelMemberListService$State(channel, users, presences, applicationStreams);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrivateChannelMemberListService$State)) {
            return false;
        }
        PrivateChannelMemberListService$State privateChannelMemberListService$State = (PrivateChannelMemberListService$State) other;
        return m.areEqual(this.channel, privateChannelMemberListService$State.channel) && m.areEqual(this.users, privateChannelMemberListService$State.users) && m.areEqual(this.presences, privateChannelMemberListService$State.presences) && m.areEqual(this.applicationStreams, privateChannelMemberListService$State.applicationStreams);
    }

    public final Map<Long, ModelApplicationStream> getApplicationStreams() {
        return this.applicationStreams;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Map<Long, Presence> getPresences() {
        return this.presences;
    }

    public final Map<Long, User> getUsers() {
        return this.users;
    }

    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Map<Long, User> map = this.users;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, Presence> map2 = this.presences;
        int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, ModelApplicationStream> map3 = this.applicationStreams;
        return iHashCode3 + (map3 != null ? map3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("State(channel=");
        sbU.append(this.channel);
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", presences=");
        sbU.append(this.presences);
        sbU.append(", applicationStreams=");
        return a.M(sbU, this.applicationStreams, ")");
    }
}
