package com.discord.widgets.channels.permissions;

import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import d0.z.d.m;

/* JADX INFO: compiled from: PermissionOwner.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PermissionOwner$Role extends PermissionOwner {
    private final GuildRole role;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionOwner$Role(GuildRole guildRole) {
        super(guildRole.getId(), null);
        m.checkNotNullParameter(guildRole, "role");
        this.role = guildRole;
    }

    public static /* synthetic */ PermissionOwner$Role copy$default(PermissionOwner$Role permissionOwner$Role, GuildRole guildRole, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRole = permissionOwner$Role.role;
        }
        return permissionOwner$Role.copy(guildRole);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildRole getRole() {
        return this.role;
    }

    public final PermissionOwner$Role copy(GuildRole role) {
        m.checkNotNullParameter(role, "role");
        return new PermissionOwner$Role(role);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof PermissionOwner$Role) && m.areEqual(this.role, ((PermissionOwner$Role) other).role);
        }
        return true;
    }

    public final GuildRole getRole() {
        return this.role;
    }

    public int hashCode() {
        GuildRole guildRole = this.role;
        if (guildRole != null) {
            return guildRole.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Role(role=");
        sbU.append(this.role);
        sbU.append(")");
        return sbU.toString();
    }
}
