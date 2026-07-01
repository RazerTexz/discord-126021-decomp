package com.discord.widgets.channels.permissions;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: PermissionOwnerListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PermissionOwnerListView$RemoveStatus$CannotRemove extends PermissionOwnerListView$RemoveStatus {
    private final PermissionOwnerListView$RemoveStatus$CannotRemove$Reason reason;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionOwnerListView$RemoveStatus$CannotRemove(PermissionOwnerListView$RemoveStatus$CannotRemove$Reason permissionOwnerListView$RemoveStatus$CannotRemove$Reason) {
        super(null);
        m.checkNotNullParameter(permissionOwnerListView$RemoveStatus$CannotRemove$Reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        this.reason = permissionOwnerListView$RemoveStatus$CannotRemove$Reason;
    }

    public static /* synthetic */ PermissionOwnerListView$RemoveStatus$CannotRemove copy$default(PermissionOwnerListView$RemoveStatus$CannotRemove permissionOwnerListView$RemoveStatus$CannotRemove, PermissionOwnerListView$RemoveStatus$CannotRemove$Reason permissionOwnerListView$RemoveStatus$CannotRemove$Reason, int i, Object obj) {
        if ((i & 1) != 0) {
            permissionOwnerListView$RemoveStatus$CannotRemove$Reason = permissionOwnerListView$RemoveStatus$CannotRemove.reason;
        }
        return permissionOwnerListView$RemoveStatus$CannotRemove.copy(permissionOwnerListView$RemoveStatus$CannotRemove$Reason);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PermissionOwnerListView$RemoveStatus$CannotRemove$Reason getReason() {
        return this.reason;
    }

    public final PermissionOwnerListView$RemoveStatus$CannotRemove copy(PermissionOwnerListView$RemoveStatus$CannotRemove$Reason reason) {
        m.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        return new PermissionOwnerListView$RemoveStatus$CannotRemove(reason);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof PermissionOwnerListView$RemoveStatus$CannotRemove) && m.areEqual(this.reason, ((PermissionOwnerListView$RemoveStatus$CannotRemove) other).reason);
        }
        return true;
    }

    public final PermissionOwnerListView$RemoveStatus$CannotRemove$Reason getReason() {
        return this.reason;
    }

    public int hashCode() {
        PermissionOwnerListView$RemoveStatus$CannotRemove$Reason permissionOwnerListView$RemoveStatus$CannotRemove$Reason = this.reason;
        if (permissionOwnerListView$RemoveStatus$CannotRemove$Reason != null) {
            return permissionOwnerListView$RemoveStatus$CannotRemove$Reason.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("CannotRemove(reason=");
        sbU.append(this.reason);
        sbU.append(")");
        return sbU.toString();
    }
}
