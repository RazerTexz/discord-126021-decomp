package com.discord.widgets.user;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserMutualFriends$Model$Item$MutualFriend extends WidgetUserMutualFriends$Model$Item {
    private final Boolean isApplicationStreaming;
    private final String key;
    private final List<Guild> mutualGuilds;
    private final Presence presence;
    private final int type;
    private final User user;

    public /* synthetic */ WidgetUserMutualFriends$Model$Item$MutualFriend(User user, Presence presence, List list, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, presence, list, (i & 8) != 0 ? null : bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetUserMutualFriends$Model$Item$MutualFriend copy$default(WidgetUserMutualFriends$Model$Item$MutualFriend widgetUserMutualFriends$Model$Item$MutualFriend, User user, Presence presence, List list, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            user = widgetUserMutualFriends$Model$Item$MutualFriend.user;
        }
        if ((i & 2) != 0) {
            presence = widgetUserMutualFriends$Model$Item$MutualFriend.presence;
        }
        if ((i & 4) != 0) {
            list = widgetUserMutualFriends$Model$Item$MutualFriend.mutualGuilds;
        }
        if ((i & 8) != 0) {
            bool = widgetUserMutualFriends$Model$Item$MutualFriend.isApplicationStreaming;
        }
        return widgetUserMutualFriends$Model$Item$MutualFriend.copy(user, presence, list, bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    public final List<Guild> component3() {
        return this.mutualGuilds;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getIsApplicationStreaming() {
        return this.isApplicationStreaming;
    }

    public final WidgetUserMutualFriends$Model$Item$MutualFriend copy(User user, Presence presence, List<Guild> mutualGuilds, Boolean isApplicationStreaming) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(mutualGuilds, "mutualGuilds");
        return new WidgetUserMutualFriends$Model$Item$MutualFriend(user, presence, mutualGuilds, isApplicationStreaming);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetUserMutualFriends$Model$Item$MutualFriend)) {
            return false;
        }
        WidgetUserMutualFriends$Model$Item$MutualFriend widgetUserMutualFriends$Model$Item$MutualFriend = (WidgetUserMutualFriends$Model$Item$MutualFriend) other;
        return m.areEqual(this.user, widgetUserMutualFriends$Model$Item$MutualFriend.user) && m.areEqual(this.presence, widgetUserMutualFriends$Model$Item$MutualFriend.presence) && m.areEqual(this.mutualGuilds, widgetUserMutualFriends$Model$Item$MutualFriend.mutualGuilds) && m.areEqual(this.isApplicationStreaming, widgetUserMutualFriends$Model$Item$MutualFriend.isApplicationStreaming);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final List<Guild> getMutualGuilds() {
        return this.mutualGuilds;
    }

    public final Presence getPresence() {
        return this.presence;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        Presence presence = this.presence;
        int iHashCode2 = (iHashCode + (presence != null ? presence.hashCode() : 0)) * 31;
        List<Guild> list = this.mutualGuilds;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool = this.isApplicationStreaming;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public final Boolean isApplicationStreaming() {
        return this.isApplicationStreaming;
    }

    public String toString() {
        StringBuilder sbU = a.U("MutualFriend(user=");
        sbU.append(this.user);
        sbU.append(", presence=");
        sbU.append(this.presence);
        sbU.append(", mutualGuilds=");
        sbU.append(this.mutualGuilds);
        sbU.append(", isApplicationStreaming=");
        return a.D(sbU, this.isApplicationStreaming, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMutualFriends$Model$Item$MutualFriend(User user, Presence presence, List<Guild> list, Boolean bool) {
        super(null);
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(list, "mutualGuilds");
        this.user = user;
        this.presence = presence;
        this.mutualGuilds = list;
        this.isApplicationStreaming = bool;
        this.type = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(user.getId());
        this.key = sb.toString();
    }
}
