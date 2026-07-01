package com.discord.api.guildjoinrequest;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.guildjoinrequest.GuildJoinRequestCreateOrUpdate, reason: use source file name */
/* JADX INFO: compiled from: GuildJoinRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildJoinRequest2 {
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
        if (!(other instanceof GuildJoinRequest2)) {
            return false;
        }
        GuildJoinRequest2 guildJoinRequest2 = (GuildJoinRequest2) other;
        return this.guildId == guildJoinRequest2.guildId && Intrinsics3.areEqual(this.request, guildJoinRequest2.request);
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        GuildJoinRequest guildJoinRequest = this.request;
        return i + (guildJoinRequest != null ? guildJoinRequest.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildJoinRequestCreateOrUpdate(guildId=");
        sbU.append(this.guildId);
        sbU.append(", request=");
        sbU.append(this.request);
        sbU.append(")");
        return sbU.toString();
    }
}
