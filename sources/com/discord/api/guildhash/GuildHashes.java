package com.discord.api.guildhash;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildHashes.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildHashes {
    private final GuildHash channels;
    private final GuildHash metadata;
    private final GuildHash roles;
    private final int version;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final GuildHash getChannels() {
        return this.channels;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final GuildHash getMetadata() {
        return this.metadata;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final GuildHash getRoles() {
        return this.roles;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildHashes)) {
            return false;
        }
        GuildHashes guildHashes = (GuildHashes) other;
        return C12238m.areEqual(this.metadata, guildHashes.metadata) && C12238m.areEqual(this.channels, guildHashes.channels) && C12238m.areEqual(this.roles, guildHashes.roles) && this.version == guildHashes.version;
    }

    public int hashCode() {
        GuildHash guildHash = this.metadata;
        int iHashCode = (guildHash != null ? guildHash.hashCode() : 0) * 31;
        GuildHash guildHash2 = this.channels;
        int iHashCode2 = (iHashCode + (guildHash2 != null ? guildHash2.hashCode() : 0)) * 31;
        GuildHash guildHash3 = this.roles;
        return ((iHashCode2 + (guildHash3 != null ? guildHash3.hashCode() : 0)) * 31) + this.version;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildHashes(metadata=");
        sbM833U.append(this.metadata);
        sbM833U.append(", channels=");
        sbM833U.append(this.channels);
        sbM833U.append(", roles=");
        sbM833U.append(this.roles);
        sbM833U.append(", version=");
        return C1643a.m814B(sbM833U, this.version, ")");
    }
}
