package com.discord.api.hubs;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: EmailVerification.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EmailVerification {
    private final List<GuildInfo> guildsInfo;
    private final boolean hasMatchingGuild;

    /* JADX INFO: renamed from: a */
    public final List<GuildInfo> m7998a() {
        return this.guildsInfo;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getHasMatchingGuild() {
        return this.hasMatchingGuild;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmailVerification)) {
            return false;
        }
        EmailVerification emailVerification = (EmailVerification) other;
        return C12238m.areEqual(this.guildsInfo, emailVerification.guildsInfo) && this.hasMatchingGuild == emailVerification.hasMatchingGuild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        List<GuildInfo> list = this.guildsInfo;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z2 = this.hasMatchingGuild;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EmailVerification(guildsInfo=");
        sbM833U.append(this.guildsInfo);
        sbM833U.append(", hasMatchingGuild=");
        return C1643a.m827O(sbM833U, this.hasMatchingGuild, ")");
    }
}
