package com.discord.api.guildhash;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

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
        return Intrinsics3.areEqual(this.metadata, guildHashes.metadata) && Intrinsics3.areEqual(this.channels, guildHashes.channels) && Intrinsics3.areEqual(this.roles, guildHashes.roles) && this.version == guildHashes.version;
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
        StringBuilder sbU = outline.U("GuildHashes(metadata=");
        sbU.append(this.metadata);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", version=");
        return outline.B(sbU, this.version, ")");
    }
}
