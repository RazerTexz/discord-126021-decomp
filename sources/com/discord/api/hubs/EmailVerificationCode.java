package com.discord.api.hubs;

import com.discord.api.guild.Guild;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: EmailVerification.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EmailVerificationCode {
    private final Guild guild;
    private final boolean joined;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getJoined() {
        return this.joined;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmailVerificationCode)) {
            return false;
        }
        EmailVerificationCode emailVerificationCode = (EmailVerificationCode) other;
        return C12238m.areEqual(this.guild, emailVerificationCode.guild) && this.joined == emailVerificationCode.joined;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        boolean z2 = this.joined;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EmailVerificationCode(guild=");
        sbM833U.append(this.guild);
        sbM833U.append(", joined=");
        return C1643a.m827O(sbM833U, this.joined, ")");
    }
}
