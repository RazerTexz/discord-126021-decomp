package com.discord.api.emoji;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: GuildEmoji.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildEmoji {
    private final boolean animated;
    private final Boolean available;
    private final long id;
    private final boolean managed;
    private final String name;
    private final boolean requireColons;
    private final List<Long> roles;

    public GuildEmoji(long j, String str, List<Long> list, boolean z2, boolean z3, boolean z4, Boolean bool) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.id = j;
        this.name = str;
        this.roles = list;
        this.requireColons = z2;
        this.managed = z3;
        this.animated = z4;
        this.available = bool;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getAnimated() {
        return this.animated;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Boolean getAvailable() {
        return this.available;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final boolean getManaged() {
        return this.managed;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildEmoji)) {
            return false;
        }
        GuildEmoji guildEmoji = (GuildEmoji) other;
        return this.id == guildEmoji.id && m.areEqual(this.name, guildEmoji.name) && m.areEqual(this.roles, guildEmoji.roles) && this.requireColons == guildEmoji.requireColons && this.managed == guildEmoji.managed && this.animated == guildEmoji.animated && m.areEqual(this.available, guildEmoji.available);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final boolean getRequireColons() {
        return this.requireColons;
    }

    public final List<Long> g() {
        return this.roles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<Long> list = this.roles;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.requireColons;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i2 = (iHashCode2 + r0) * 31;
        boolean z3 = this.managed;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i3 = (i2 + r1) * 31;
        boolean z4 = this.animated;
        int i4 = (i3 + (z4 ? 1 : z4)) * 31;
        Boolean bool = this.available;
        return i4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildEmoji(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", requireColons=");
        sbU.append(this.requireColons);
        sbU.append(", managed=");
        sbU.append(this.managed);
        sbU.append(", animated=");
        sbU.append(this.animated);
        sbU.append(", available=");
        return a.D(sbU, this.available, ")");
    }
}
