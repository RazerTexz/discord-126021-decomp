package com.discord.api.commands;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: ApplicationCommandPermission.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApplicationCommandPermission {
    private final long id;
    private final boolean permission;
    private final ApplicationCommandPermissionType type;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getPermission() {
        return this.permission;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandPermission)) {
            return false;
        }
        ApplicationCommandPermission applicationCommandPermission = (ApplicationCommandPermission) other;
        return this.id == applicationCommandPermission.id && m.areEqual(this.type, applicationCommandPermission.type) && this.permission == applicationCommandPermission.permission;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        ApplicationCommandPermissionType applicationCommandPermissionType = this.type;
        int iHashCode = (i + (applicationCommandPermissionType != null ? applicationCommandPermissionType.hashCode() : 0)) * 31;
        boolean z2 = this.permission;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return iHashCode + r0;
    }

    public String toString() {
        StringBuilder sbU = a.U("ApplicationCommandPermission(id=");
        sbU.append(this.id);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", permission=");
        return a.O(sbU, this.permission, ")");
    }
}
