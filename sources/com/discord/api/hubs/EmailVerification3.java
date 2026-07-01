package com.discord.api.hubs;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.hubs.GuildInfo, reason: use source file name */
/* JADX INFO: compiled from: EmailVerification.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EmailVerification3 {
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
        if (!(other instanceof EmailVerification3)) {
            return false;
        }
        EmailVerification3 emailVerification3 = (EmailVerification3) other;
        return Intrinsics3.areEqual(this.icon, emailVerification3.icon) && this.id == emailVerification3.id && Intrinsics3.areEqual(this.name, emailVerification3.name);
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
        StringBuilder sbU = outline.U("GuildInfo(icon=");
        sbU.append(this.icon);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", name=");
        return outline.J(sbU, this.name, ")");
    }
}
