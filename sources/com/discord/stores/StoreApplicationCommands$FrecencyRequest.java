package com.discord.stores;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreApplicationCommands$FrecencyRequest {
    private final List<String> applicationCommandIds;
    private final Long guildId;

    public StoreApplicationCommands$FrecencyRequest(Long l, List<String> list) {
        m.checkNotNullParameter(list, "applicationCommandIds");
        this.guildId = l;
        this.applicationCommandIds = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreApplicationCommands$FrecencyRequest copy$default(StoreApplicationCommands$FrecencyRequest storeApplicationCommands$FrecencyRequest, Long l, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            l = storeApplicationCommands$FrecencyRequest.guildId;
        }
        if ((i & 2) != 0) {
            list = storeApplicationCommands$FrecencyRequest.applicationCommandIds;
        }
        return storeApplicationCommands$FrecencyRequest.copy(l, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    public final List<String> component2() {
        return this.applicationCommandIds;
    }

    public final StoreApplicationCommands$FrecencyRequest copy(Long guildId, List<String> applicationCommandIds) {
        m.checkNotNullParameter(applicationCommandIds, "applicationCommandIds");
        return new StoreApplicationCommands$FrecencyRequest(guildId, applicationCommandIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreApplicationCommands$FrecencyRequest)) {
            return false;
        }
        StoreApplicationCommands$FrecencyRequest storeApplicationCommands$FrecencyRequest = (StoreApplicationCommands$FrecencyRequest) other;
        return m.areEqual(this.guildId, storeApplicationCommands$FrecencyRequest.guildId) && m.areEqual(this.applicationCommandIds, storeApplicationCommands$FrecencyRequest.applicationCommandIds);
    }

    public final List<String> getApplicationCommandIds() {
        return this.applicationCommandIds;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        List<String> list = this.applicationCommandIds;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("FrecencyRequest(guildId=");
        sbU.append(this.guildId);
        sbU.append(", applicationCommandIds=");
        return a.L(sbU, this.applicationCommandIds, ")");
    }
}
