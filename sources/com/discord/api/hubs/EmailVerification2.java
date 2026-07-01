package com.discord.api.hubs;

import b.d.b.a.outline;
import com.discord.api.guild.Guild;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.hubs.EmailVerificationCode, reason: use source file name */
/* JADX INFO: compiled from: EmailVerification.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EmailVerification2 {
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
        if (!(other instanceof EmailVerification2)) {
            return false;
        }
        EmailVerification2 emailVerification2 = (EmailVerification2) other;
        return Intrinsics3.areEqual(this.guild, emailVerification2.guild) && this.joined == emailVerification2.joined;
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
        StringBuilder sbU = outline.U("EmailVerificationCode(guild=");
        sbU.append(this.guild);
        sbU.append(", joined=");
        return outline.O(sbU, this.joined, ")");
    }
}
