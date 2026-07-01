package com.discord.api.guildmember;

import b.d.b.a.a;
import com.discord.api.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildMemberRemove.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildMemberRemove {
    private final long guildId;
    private final User user;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMemberRemove)) {
            return false;
        }
        GuildMemberRemove guildMemberRemove = (GuildMemberRemove) other;
        return this.guildId == guildMemberRemove.guildId && m.areEqual(this.user, guildMemberRemove.user);
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        User user = this.user;
        return i + (user != null ? user.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildMemberRemove(guildId=");
        sbU.append(this.guildId);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(")");
        return sbU.toString();
    }
}
