package com.discord.widgets.channels.permissions;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: PermissionOwnerListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PermissionOwnerListView$Item {
    private final PermissionOwner permissionOwner;
    private final PermissionOwnerListView$RemoveStatus removeStatus;

    public PermissionOwnerListView$Item(PermissionOwner permissionOwner, PermissionOwnerListView$RemoveStatus permissionOwnerListView$RemoveStatus) {
        m.checkNotNullParameter(permissionOwner, "permissionOwner");
        m.checkNotNullParameter(permissionOwnerListView$RemoveStatus, "removeStatus");
        this.permissionOwner = permissionOwner;
        this.removeStatus = permissionOwnerListView$RemoveStatus;
    }

    public static /* synthetic */ PermissionOwnerListView$Item copy$default(PermissionOwnerListView$Item permissionOwnerListView$Item, PermissionOwner permissionOwner, PermissionOwnerListView$RemoveStatus permissionOwnerListView$RemoveStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            permissionOwner = permissionOwnerListView$Item.permissionOwner;
        }
        if ((i & 2) != 0) {
            permissionOwnerListView$RemoveStatus = permissionOwnerListView$Item.removeStatus;
        }
        return permissionOwnerListView$Item.copy(permissionOwner, permissionOwnerListView$RemoveStatus);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PermissionOwner getPermissionOwner() {
        return this.permissionOwner;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PermissionOwnerListView$RemoveStatus getRemoveStatus() {
        return this.removeStatus;
    }

    public final PermissionOwnerListView$Item copy(PermissionOwner permissionOwner, PermissionOwnerListView$RemoveStatus removeStatus) {
        m.checkNotNullParameter(permissionOwner, "permissionOwner");
        m.checkNotNullParameter(removeStatus, "removeStatus");
        return new PermissionOwnerListView$Item(permissionOwner, removeStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionOwnerListView$Item)) {
            return false;
        }
        PermissionOwnerListView$Item permissionOwnerListView$Item = (PermissionOwnerListView$Item) other;
        return m.areEqual(this.permissionOwner, permissionOwnerListView$Item.permissionOwner) && m.areEqual(this.removeStatus, permissionOwnerListView$Item.removeStatus);
    }

    public final PermissionOwner getPermissionOwner() {
        return this.permissionOwner;
    }

    public final PermissionOwnerListView$RemoveStatus getRemoveStatus() {
        return this.removeStatus;
    }

    public int hashCode() {
        PermissionOwner permissionOwner = this.permissionOwner;
        int iHashCode = (permissionOwner != null ? permissionOwner.hashCode() : 0) * 31;
        PermissionOwnerListView$RemoveStatus permissionOwnerListView$RemoveStatus = this.removeStatus;
        return iHashCode + (permissionOwnerListView$RemoveStatus != null ? permissionOwnerListView$RemoveStatus.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Item(permissionOwner=");
        sbU.append(this.permissionOwner);
        sbU.append(", removeStatus=");
        sbU.append(this.removeStatus);
        sbU.append(")");
        return sbU.toString();
    }
}
