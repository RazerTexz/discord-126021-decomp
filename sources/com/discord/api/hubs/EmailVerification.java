package com.discord.api.hubs;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: EmailVerification.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EmailVerification {
    private final List<EmailVerification3> guildsInfo;
    private final boolean hasMatchingGuild;

    public final List<EmailVerification3> a() {
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
        return Intrinsics3.areEqual(this.guildsInfo, emailVerification.guildsInfo) && this.hasMatchingGuild == emailVerification.hasMatchingGuild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        List<EmailVerification3> list = this.guildsInfo;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z2 = this.hasMatchingGuild;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = outline.U("EmailVerification(guildsInfo=");
        sbU.append(this.guildsInfo);
        sbU.append(", hasMatchingGuild=");
        return outline.O(sbU, this.hasMatchingGuild, ")");
    }
}
