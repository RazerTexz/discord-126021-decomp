package com.discord.api.role;

import com.discord.api.guildhash.GuildHashes;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return this.guildId == guildRoleCreate.guildId && this.roleId == guildRoleCreate.roleId && C12238m.areEqual(this.role, guildRoleCreate.role) && C12238m.areEqual(this.guildHashes, guildRoleCreate.guildHashes);
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
        StringBuilder sbM833U = C1643a.m833U("GuildRoleCreate(guildId=");
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
