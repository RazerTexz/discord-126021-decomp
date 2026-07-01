package com.discord.api.application;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: Team.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Team {
    private final String icon;
    private final long id;
    private final String name;
    private final long ownerUserId;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Team)) {
            return false;
        }
        Team team = (Team) other;
        return this.id == team.id && Intrinsics3.areEqual(this.icon, team.icon) && Intrinsics3.areEqual(this.name, team.name) && this.ownerUserId == team.ownerUserId;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.icon;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j2 = this.ownerUserId;
        return iHashCode2 + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("Team(id=");
        sbU.append(this.id);
        sbU.append(", icon=");
        sbU.append(this.icon);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", ownerUserId=");
        return outline.C(sbU, this.ownerUserId, ")");
    }
}
