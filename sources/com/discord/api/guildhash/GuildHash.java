package com.discord.api.guildhash;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildHash.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildHash {
    private final String hash;
    private final boolean omitted;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getHash() {
        return this.hash;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getOmitted() {
        return this.omitted;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildHash)) {
            return false;
        }
        GuildHash guildHash = (GuildHash) other;
        return m.areEqual(this.hash, guildHash.hash) && this.omitted == guildHash.omitted;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        String str = this.hash;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z2 = this.omitted;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildHash(hash=");
        sbU.append(this.hash);
        sbU.append(", omitted=");
        return a.O(sbU, this.omitted, ")");
    }
}
