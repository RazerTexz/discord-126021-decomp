package com.discord.api.guildjoinrequest;

import b.d.b.a.outline;

/* JADX INFO: renamed from: com.discord.api.guildjoinrequest.GuildJoinRequestDelete, reason: use source file name */
/* JADX INFO: compiled from: GuildJoinRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildJoinRequest3 {
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
        if (!(other instanceof GuildJoinRequest3)) {
            return false;
        }
        GuildJoinRequest3 guildJoinRequest3 = (GuildJoinRequest3) other;
        return this.userId == guildJoinRequest3.userId && this.guildId == guildJoinRequest3.guildId;
    }

    public int hashCode() {
        long j = this.userId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.guildId;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildJoinRequestDelete(userId=");
        sbU.append(this.userId);
        sbU.append(", guildId=");
        return outline.C(sbU, this.guildId, ")");
    }
}
