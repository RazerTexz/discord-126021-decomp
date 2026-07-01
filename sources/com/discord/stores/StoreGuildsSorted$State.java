package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.ModelGuildFolder;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: StoreGuildsSorted.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGuildsSorted$State {
    private final Map<Long, Long> joinedAt;
    private final Set<Long> mutedGuilds;
    private final List<ModelGuildFolder> userSettingsGuildPositions;

    public StoreGuildsSorted$State(Set<Long> set, Map<Long, Long> map, List<ModelGuildFolder> list) {
        m.checkNotNullParameter(set, "mutedGuilds");
        m.checkNotNullParameter(map, "joinedAt");
        m.checkNotNullParameter(list, "userSettingsGuildPositions");
        this.mutedGuilds = set;
        this.joinedAt = map;
        this.userSettingsGuildPositions = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreGuildsSorted$State copy$default(StoreGuildsSorted$State storeGuildsSorted$State, Set set, Map map, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            set = storeGuildsSorted$State.mutedGuilds;
        }
        if ((i & 2) != 0) {
            map = storeGuildsSorted$State.joinedAt;
        }
        if ((i & 4) != 0) {
            list = storeGuildsSorted$State.userSettingsGuildPositions;
        }
        return storeGuildsSorted$State.copy(set, map, list);
    }

    public final Set<Long> component1() {
        return this.mutedGuilds;
    }

    public final Map<Long, Long> component2() {
        return this.joinedAt;
    }

    public final List<ModelGuildFolder> component3() {
        return this.userSettingsGuildPositions;
    }

    public final StoreGuildsSorted$State copy(Set<Long> mutedGuilds, Map<Long, Long> joinedAt, List<ModelGuildFolder> userSettingsGuildPositions) {
        m.checkNotNullParameter(mutedGuilds, "mutedGuilds");
        m.checkNotNullParameter(joinedAt, "joinedAt");
        m.checkNotNullParameter(userSettingsGuildPositions, "userSettingsGuildPositions");
        return new StoreGuildsSorted$State(mutedGuilds, joinedAt, userSettingsGuildPositions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreGuildsSorted$State)) {
            return false;
        }
        StoreGuildsSorted$State storeGuildsSorted$State = (StoreGuildsSorted$State) other;
        return m.areEqual(this.mutedGuilds, storeGuildsSorted$State.mutedGuilds) && m.areEqual(this.joinedAt, storeGuildsSorted$State.joinedAt) && m.areEqual(this.userSettingsGuildPositions, storeGuildsSorted$State.userSettingsGuildPositions);
    }

    public final Map<Long, Long> getJoinedAt() {
        return this.joinedAt;
    }

    public final Set<Long> getMutedGuilds() {
        return this.mutedGuilds;
    }

    public final List<ModelGuildFolder> getUserSettingsGuildPositions() {
        return this.userSettingsGuildPositions;
    }

    public int hashCode() {
        Set<Long> set = this.mutedGuilds;
        int iHashCode = (set != null ? set.hashCode() : 0) * 31;
        Map<Long, Long> map = this.joinedAt;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        List<ModelGuildFolder> list = this.userSettingsGuildPositions;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("State(mutedGuilds=");
        sbU.append(this.mutedGuilds);
        sbU.append(", joinedAt=");
        sbU.append(this.joinedAt);
        sbU.append(", userSettingsGuildPositions=");
        return a.L(sbU, this.userSettingsGuildPositions, ")");
    }
}
