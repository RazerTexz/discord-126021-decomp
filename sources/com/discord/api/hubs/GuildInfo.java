package com.discord.api.hubs;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: EmailVerification.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildInfo {
    private final String icon;
    private final long id;
    private final String name;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildInfo)) {
            return false;
        }
        GuildInfo guildInfo = (GuildInfo) other;
        return m.areEqual(this.icon, guildInfo.icon) && this.id == guildInfo.id && m.areEqual(this.name, guildInfo.name);
    }

    public int hashCode() {
        String str = this.icon;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.id;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.name;
        return i + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildInfo(icon=");
        sbU.append(this.icon);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", name=");
        return a.J(sbU, this.name, ")");
    }
}
