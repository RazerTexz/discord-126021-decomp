package com.discord.api.role;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.io.Serializable;

/* JADX INFO: compiled from: GuildRole.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildRole implements Serializable {
    private final int color;
    private final boolean hoist;
    private final String icon;
    private final long id;
    private final boolean managed;
    private final boolean mentionable;
    private final String name;
    private final long permissions;
    private final int position;
    private final GuildRoleTags tags;
    private final String unicodeEmoji;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final boolean getHoist() {
        return this.hoist;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final boolean getManaged() {
        return this.managed;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRole)) {
            return false;
        }
        GuildRole guildRole = (GuildRole) other;
        return this.position == guildRole.position && m.areEqual(this.name, guildRole.name) && this.id == guildRole.id && this.color == guildRole.color && this.hoist == guildRole.hoist && this.permissions == guildRole.permissions && this.mentionable == guildRole.mentionable && this.managed == guildRole.managed && m.areEqual(this.icon, guildRole.icon) && m.areEqual(this.tags, guildRole.tags) && m.areEqual(this.unicodeEmoji, guildRole.unicodeEmoji);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final boolean getMentionable() {
        return this.mentionable;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final long getPermissions() {
        return this.permissions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3 */
    public int hashCode() {
        int i = this.position * 31;
        String str = this.name;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.id;
        int i2 = (((((i + iHashCode) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.color) * 31;
        boolean z2 = this.hoist;
        ?? r3 = z2;
        if (z2) {
            r3 = 1;
        }
        long j2 = this.permissions;
        int i3 = (((i2 + r3) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        boolean z3 = this.mentionable;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i4 = (i3 + r1) * 31;
        boolean z4 = this.managed;
        int i5 = (i4 + (z4 ? 1 : z4)) * 31;
        String str2 = this.icon;
        int iHashCode2 = (i5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        GuildRoleTags guildRoleTags = this.tags;
        int iHashCode3 = (iHashCode2 + (guildRoleTags != null ? guildRoleTags.hashCode() : 0)) * 31;
        String str3 = this.unicodeEmoji;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final GuildRoleTags getTags() {
        return this.tags;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final String getUnicodeEmoji() {
        return this.unicodeEmoji;
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildRole(position=");
        sbU.append(this.position);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", color=");
        sbU.append(this.color);
        sbU.append(", hoist=");
        sbU.append(this.hoist);
        sbU.append(", permissions=");
        sbU.append(this.permissions);
        sbU.append(", mentionable=");
        sbU.append(this.mentionable);
        sbU.append(", managed=");
        sbU.append(this.managed);
        sbU.append(", icon=");
        sbU.append(this.icon);
        sbU.append(", tags=");
        sbU.append(this.tags);
        sbU.append(", unicodeEmoji=");
        return a.J(sbU, this.unicodeEmoji, ")");
    }
}
