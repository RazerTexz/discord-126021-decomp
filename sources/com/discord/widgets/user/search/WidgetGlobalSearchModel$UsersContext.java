package com.discord.widgets.user.search;

import b.d.b.a.a;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetGlobalSearchModel$UsersContext {
    private final Map<Long, Map<Long, GuildMember>> members;
    private final Map<Long, Presence> presences;
    private final Map<Long, Integer> relationships;
    private final Map<Long, User> users;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGlobalSearchModel$UsersContext(Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, Integer> map3, Map<Long, ? extends Map<Long, GuildMember>> map4) {
        m.checkNotNullParameter(map, "users");
        m.checkNotNullParameter(map2, "presences");
        m.checkNotNullParameter(map3, "relationships");
        m.checkNotNullParameter(map4, "members");
        this.users = map;
        this.presences = map2;
        this.relationships = map3;
        this.members = map4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGlobalSearchModel$UsersContext copy$default(WidgetGlobalSearchModel$UsersContext widgetGlobalSearchModel$UsersContext, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
        if ((i & 1) != 0) {
            map = widgetGlobalSearchModel$UsersContext.users;
        }
        if ((i & 2) != 0) {
            map2 = widgetGlobalSearchModel$UsersContext.presences;
        }
        if ((i & 4) != 0) {
            map3 = widgetGlobalSearchModel$UsersContext.relationships;
        }
        if ((i & 8) != 0) {
            map4 = widgetGlobalSearchModel$UsersContext.members;
        }
        return widgetGlobalSearchModel$UsersContext.copy(map, map2, map3, map4);
    }

    public final Map<Long, User> component1() {
        return this.users;
    }

    public final Map<Long, Presence> component2() {
        return this.presences;
    }

    public final Map<Long, Integer> component3() {
        return this.relationships;
    }

    public final Map<Long, Map<Long, GuildMember>> component4() {
        return this.members;
    }

    public final WidgetGlobalSearchModel$UsersContext copy(Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, Integer> relationships, Map<Long, ? extends Map<Long, GuildMember>> members) {
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(presences, "presences");
        m.checkNotNullParameter(relationships, "relationships");
        m.checkNotNullParameter(members, "members");
        return new WidgetGlobalSearchModel$UsersContext(users, presences, relationships, members);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalSearchModel$UsersContext)) {
            return false;
        }
        WidgetGlobalSearchModel$UsersContext widgetGlobalSearchModel$UsersContext = (WidgetGlobalSearchModel$UsersContext) other;
        return m.areEqual(this.users, widgetGlobalSearchModel$UsersContext.users) && m.areEqual(this.presences, widgetGlobalSearchModel$UsersContext.presences) && m.areEqual(this.relationships, widgetGlobalSearchModel$UsersContext.relationships) && m.areEqual(this.members, widgetGlobalSearchModel$UsersContext.members);
    }

    public final Map<Long, Map<Long, GuildMember>> getMembers() {
        return this.members;
    }

    public final Map<Long, Presence> getPresences() {
        return this.presences;
    }

    public final Map<Long, Integer> getRelationships() {
        return this.relationships;
    }

    public final Map<Long, User> getUsers() {
        return this.users;
    }

    public int hashCode() {
        Map<Long, User> map = this.users;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        Map<Long, Presence> map2 = this.presences;
        int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, Integer> map3 = this.relationships;
        int iHashCode3 = (iHashCode2 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<Long, Map<Long, GuildMember>> map4 = this.members;
        return iHashCode3 + (map4 != null ? map4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("UsersContext(users=");
        sbU.append(this.users);
        sbU.append(", presences=");
        sbU.append(this.presences);
        sbU.append(", relationships=");
        sbU.append(this.relationships);
        sbU.append(", members=");
        return a.M(sbU, this.members, ")");
    }
}
