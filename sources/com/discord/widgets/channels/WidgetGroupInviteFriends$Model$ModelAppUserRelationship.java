package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGroupInviteFriends$Model$ModelAppUserRelationship {
    private final Map<Long, Presence> presences;
    private final Map<Long, Integer> relationships;
    private final Map<Long, ModelApplicationStream> streams;
    private final Map<Long, User> users;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGroupInviteFriends$Model$ModelAppUserRelationship(Map<Long, Integer> map, Map<Long, Presence> map2, Map<Long, ? extends User> map3, Map<Long, ? extends ModelApplicationStream> map4) {
        m.checkNotNullParameter(map, "relationships");
        m.checkNotNullParameter(map2, "presences");
        m.checkNotNullParameter(map3, "users");
        m.checkNotNullParameter(map4, "streams");
        this.relationships = map;
        this.presences = map2;
        this.users = map3;
        this.streams = map4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGroupInviteFriends$Model$ModelAppUserRelationship copy$default(WidgetGroupInviteFriends$Model$ModelAppUserRelationship widgetGroupInviteFriends$Model$ModelAppUserRelationship, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
        if ((i & 1) != 0) {
            map = widgetGroupInviteFriends$Model$ModelAppUserRelationship.relationships;
        }
        if ((i & 2) != 0) {
            map2 = widgetGroupInviteFriends$Model$ModelAppUserRelationship.presences;
        }
        if ((i & 4) != 0) {
            map3 = widgetGroupInviteFriends$Model$ModelAppUserRelationship.users;
        }
        if ((i & 8) != 0) {
            map4 = widgetGroupInviteFriends$Model$ModelAppUserRelationship.streams;
        }
        return widgetGroupInviteFriends$Model$ModelAppUserRelationship.copy(map, map2, map3, map4);
    }

    public final Map<Long, Integer> component1() {
        return this.relationships;
    }

    public final Map<Long, Presence> component2() {
        return this.presences;
    }

    public final Map<Long, User> component3() {
        return this.users;
    }

    public final Map<Long, ModelApplicationStream> component4() {
        return this.streams;
    }

    public final WidgetGroupInviteFriends$Model$ModelAppUserRelationship copy(Map<Long, Integer> relationships, Map<Long, Presence> presences, Map<Long, ? extends User> users, Map<Long, ? extends ModelApplicationStream> streams) {
        m.checkNotNullParameter(relationships, "relationships");
        m.checkNotNullParameter(presences, "presences");
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(streams, "streams");
        return new WidgetGroupInviteFriends$Model$ModelAppUserRelationship(relationships, presences, users, streams);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGroupInviteFriends$Model$ModelAppUserRelationship)) {
            return false;
        }
        WidgetGroupInviteFriends$Model$ModelAppUserRelationship widgetGroupInviteFriends$Model$ModelAppUserRelationship = (WidgetGroupInviteFriends$Model$ModelAppUserRelationship) other;
        return m.areEqual(this.relationships, widgetGroupInviteFriends$Model$ModelAppUserRelationship.relationships) && m.areEqual(this.presences, widgetGroupInviteFriends$Model$ModelAppUserRelationship.presences) && m.areEqual(this.users, widgetGroupInviteFriends$Model$ModelAppUserRelationship.users) && m.areEqual(this.streams, widgetGroupInviteFriends$Model$ModelAppUserRelationship.streams);
    }

    public final Map<Long, Presence> getPresences() {
        return this.presences;
    }

    public final Map<Long, Integer> getRelationships() {
        return this.relationships;
    }

    public final Map<Long, ModelApplicationStream> getStreams() {
        return this.streams;
    }

    public final Map<Long, User> getUsers() {
        return this.users;
    }

    public int hashCode() {
        Map<Long, Integer> map = this.relationships;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        Map<Long, Presence> map2 = this.presences;
        int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, User> map3 = this.users;
        int iHashCode3 = (iHashCode2 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<Long, ModelApplicationStream> map4 = this.streams;
        return iHashCode3 + (map4 != null ? map4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelAppUserRelationship(relationships=");
        sbU.append(this.relationships);
        sbU.append(", presences=");
        sbU.append(this.presences);
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", streams=");
        return a.M(sbU, this.streams, ")");
    }
}
