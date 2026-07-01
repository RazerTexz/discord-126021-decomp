package com.discord.api.guildjoinrequest;

import b.d.b.a.a;
import d0.z.d.m;

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
        return this.guildId == guildJoinRequestCreateOrUpdate.guildId && m.areEqual(this.request, guildJoinRequestCreateOrUpdate.request);
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        GuildJoinRequest guildJoinRequest = this.request;
        return i + (guildJoinRequest != null ? guildJoinRequest.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildJoinRequestCreateOrUpdate(guildId=");
        sbU.append(this.guildId);
        sbU.append(", request=");
        sbU.append(this.request);
        sbU.append(")");
        return sbU.toString();
    }
}
