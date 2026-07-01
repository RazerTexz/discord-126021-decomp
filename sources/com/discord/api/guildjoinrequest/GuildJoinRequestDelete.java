package com.discord.api.guildjoinrequest;

import b.d.b.a.a;

/* JADX INFO: compiled from: GuildJoinRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildJoinRequestDelete {
    private final long guildId;
    private final long userId;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildJoinRequestDelete)) {
            return false;
        }
        GuildJoinRequestDelete guildJoinRequestDelete = (GuildJoinRequestDelete) other;
        return this.userId == guildJoinRequestDelete.userId && this.guildId == guildJoinRequestDelete.guildId;
    }

    public int hashCode() {
        long j = this.userId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.guildId;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildJoinRequestDelete(userId=");
        sbU.append(this.userId);
        sbU.append(", guildId=");
        return a.C(sbU, this.guildId, ")");
    }
}
