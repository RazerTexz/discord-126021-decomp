package com.discord.widgets.guilds.invite;

import b.d.b.a.a;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: InviteSuggestionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InviteSuggestionsManager$UserAffinityData {
    private final Map<Long, Integer> relationships;
    private final List<Long> userIds;
    private final Map<Long, User> users;

    /* JADX WARN: Multi-variable type inference failed */
    public InviteSuggestionsManager$UserAffinityData(List<Long> list, Map<Long, ? extends User> map, Map<Long, Integer> map2) {
        m.checkNotNullParameter(list, "userIds");
        m.checkNotNullParameter(map, "users");
        m.checkNotNullParameter(map2, "relationships");
        this.userIds = list;
        this.users = map;
        this.relationships = map2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InviteSuggestionsManager$UserAffinityData copy$default(InviteSuggestionsManager$UserAffinityData inviteSuggestionsManager$UserAffinityData, List list, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = inviteSuggestionsManager$UserAffinityData.userIds;
        }
        if ((i & 2) != 0) {
            map = inviteSuggestionsManager$UserAffinityData.users;
        }
        if ((i & 4) != 0) {
            map2 = inviteSuggestionsManager$UserAffinityData.relationships;
        }
        return inviteSuggestionsManager$UserAffinityData.copy(list, map, map2);
    }

    public final List<Long> component1() {
        return this.userIds;
    }

    public final Map<Long, User> component2() {
        return this.users;
    }

    public final Map<Long, Integer> component3() {
        return this.relationships;
    }

    public final InviteSuggestionsManager$UserAffinityData copy(List<Long> userIds, Map<Long, ? extends User> users, Map<Long, Integer> relationships) {
        m.checkNotNullParameter(userIds, "userIds");
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(relationships, "relationships");
        return new InviteSuggestionsManager$UserAffinityData(userIds, users, relationships);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteSuggestionsManager$UserAffinityData)) {
            return false;
        }
        InviteSuggestionsManager$UserAffinityData inviteSuggestionsManager$UserAffinityData = (InviteSuggestionsManager$UserAffinityData) other;
        return m.areEqual(this.userIds, inviteSuggestionsManager$UserAffinityData.userIds) && m.areEqual(this.users, inviteSuggestionsManager$UserAffinityData.users) && m.areEqual(this.relationships, inviteSuggestionsManager$UserAffinityData.relationships);
    }

    public final Map<Long, Integer> getRelationships() {
        return this.relationships;
    }

    public final List<Long> getUserIds() {
        return this.userIds;
    }

    public final Map<Long, User> getUsers() {
        return this.users;
    }

    public int hashCode() {
        List<Long> list = this.userIds;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        Map<Long, User> map = this.users;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, Integer> map2 = this.relationships;
        return iHashCode2 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("UserAffinityData(userIds=");
        sbU.append(this.userIds);
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", relationships=");
        return a.M(sbU, this.relationships, ")");
    }
}
