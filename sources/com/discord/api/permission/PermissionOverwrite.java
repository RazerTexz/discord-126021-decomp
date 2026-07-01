package com.discord.api.permission;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: PermissionOverwrite.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class PermissionOverwrite {
    private final long allow;
    private final long deny;
    private final long id;
    private final Type type;

    /* JADX INFO: compiled from: PermissionOverwrite.kt */
    public enum Type {
        ROLE,
        MEMBER
    }

    public PermissionOverwrite(long j, Type type, long j2, long j3) {
        Intrinsics3.checkNotNullParameter(type, "type");
        this.id = j;
        this.type = type;
        this.allow = j2;
        this.deny = j3;
    }

    public static PermissionOverwrite b(PermissionOverwrite permissionOverwrite, long j, Type type, long j2, long j3, int i) {
        long j4 = (i & 1) != 0 ? permissionOverwrite.id : j;
        Type type2 = (i & 2) != 0 ? permissionOverwrite.type : null;
        long j5 = (i & 4) != 0 ? permissionOverwrite.allow : j2;
        long j6 = (i & 8) != 0 ? permissionOverwrite.deny : j3;
        Intrinsics3.checkNotNullParameter(type2, "type");
        return new PermissionOverwrite(j4, type2, j5, j6);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getAllow() {
        return this.allow;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final long getDeny() {
        return this.deny;
    }

    public final long e() {
        return this.id;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionOverwrite)) {
            return false;
        }
        PermissionOverwrite permissionOverwrite = (PermissionOverwrite) other;
        return this.id == permissionOverwrite.id && Intrinsics3.areEqual(this.type, permissionOverwrite.type) && this.allow == permissionOverwrite.allow && this.deny == permissionOverwrite.deny;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Type type = this.type;
        int iHashCode = type != null ? type.hashCode() : 0;
        long j2 = this.allow;
        int i2 = (((i + iHashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.deny;
        return i2 + ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("PermissionOverwrite(id=");
        sbU.append(this.id);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", allow=");
        sbU.append(this.allow);
        sbU.append(", deny=");
        return outline.C(sbU, this.deny, ")");
    }
}
