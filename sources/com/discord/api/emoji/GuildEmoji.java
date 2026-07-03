package com.discord.api.emoji;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
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
        return this.id == guildEmoji.id && C12238m.areEqual(this.name, guildEmoji.name) && C12238m.areEqual(this.roles, guildEmoji.roles) && this.requireColons == guildEmoji.requireColons && this.managed == guildEmoji.managed && this.animated == guildEmoji.animated && C12238m.areEqual(this.available, guildEmoji.available);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final boolean getRequireColons() {
        return this.requireColons;
    }

    /* JADX INFO: renamed from: g */
    public final List<Long> m7815g() {
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
        StringBuilder sbM833U = C1643a.m833U("GuildEmoji(id=");
        sbM833U.append(this.id);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", roles=");
        sbM833U.append(this.roles);
        sbM833U.append(", requireColons=");
        sbM833U.append(this.requireColons);
        sbM833U.append(", managed=");
        sbM833U.append(this.managed);
        sbM833U.append(", animated=");
        sbM833U.append(this.animated);
        sbM833U.append(", available=");
        return C1643a.m816D(sbM833U, this.available, ")");
    }
}
