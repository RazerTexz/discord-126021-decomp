package com.discord.api.role;

import com.discord.api.guildhash.GuildHashes;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildRoleUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildRoleUpdate {
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
        if (!(other instanceof GuildRoleUpdate)) {
            return false;
        }
        GuildRoleUpdate guildRoleUpdate = (GuildRoleUpdate) other;
        return this.guildId == guildRoleUpdate.guildId && this.roleId == guildRoleUpdate.roleId && C12238m.areEqual(this.role, guildRoleUpdate.role) && C12238m.areEqual(this.guildHashes, guildRoleUpdate.guildHashes);
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
        StringBuilder sbM833U = C1643a.m833U("GuildRoleUpdate(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", roleId=");
        sbM833U.append(this.roleId);
        sbM833U.append(", role=");
        sbM833U.append(this.role);
        sbM833U.append(", guildHashes=");
        sbM833U.append(this.guildHashes);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
