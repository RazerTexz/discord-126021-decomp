package com.discord.api.role;

import b.d.b.a.outline;
import com.discord.api.guildhash.GuildHashes;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: GuildRoleCreate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildRoleCreate {
    private final GuildHashes guildHashes;
    private final long guildId;
    private final GuildRole role;
    private final long roleId;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final GuildHashes getGuildHashes() {
        return this.guildHashes;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final GuildRole getRole() {
        return this.role;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleCreate)) {
            return false;
        }
        GuildRoleCreate guildRoleCreate = (GuildRoleCreate) other;
        return this.guildId == guildRoleCreate.guildId && this.roleId == guildRoleCreate.roleId && Intrinsics3.areEqual(this.role, guildRoleCreate.role) && Intrinsics3.areEqual(this.guildHashes, guildRoleCreate.guildHashes);
    }

    public int hashCode() {
        long j = this.guildId;
        long j2 = this.roleId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        GuildRole guildRole = this.role;
        int iHashCode = (i + (guildRole != null ? guildRole.hashCode() : 0)) * 31;
        GuildHashes guildHashes = this.guildHashes;
        return iHashCode + (guildHashes != null ? guildHashes.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildRoleCreate(guildId=");
        sbU.append(this.guildId);
        sbU.append(", roleId=");
        sbU.append(this.roleId);
        sbU.append(", role=");
        sbU.append(this.role);
        sbU.append(", guildHashes=");
        sbU.append(this.guildHashes);
        sbU.append(")");
        return sbU.toString();
    }
}
