package com.discord.api.guildmember;

import com.discord.api.user.User;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return this.guildId == guildMemberRemove.guildId && C12238m.areEqual(this.user, guildMemberRemove.user);
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        User user = this.user;
        return i + (user != null ? user.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildMemberRemove(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", user=");
        sbM833U.append(this.user);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
