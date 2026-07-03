package com.discord.api.guildjoinrequest;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildJoinRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildJoinRequestCreateOrUpdate {
    private final long guildId;
    private final GuildJoinRequest request;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final GuildJoinRequest getRequest() {
        return this.request;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildJoinRequestCreateOrUpdate)) {
            return false;
        }
        GuildJoinRequestCreateOrUpdate guildJoinRequestCreateOrUpdate = (GuildJoinRequestCreateOrUpdate) other;
        return this.guildId == guildJoinRequestCreateOrUpdate.guildId && C12238m.areEqual(this.request, guildJoinRequestCreateOrUpdate.request);
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        GuildJoinRequest guildJoinRequest = this.request;
        return i + (guildJoinRequest != null ? guildJoinRequest.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildJoinRequestCreateOrUpdate(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", request=");
        sbM833U.append(this.request);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
