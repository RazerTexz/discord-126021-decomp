package com.discord.widgets.channels.permissions;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: AddMemberAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AddMemberAdapter$Item$PermissionOwnerItem extends AddMemberAdapter$Item {
    public static final AddMemberAdapter$Item$PermissionOwnerItem$Companion Companion = new AddMemberAdapter$Item$PermissionOwnerItem$Companion(null);
    private final AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus addStatus;
    private final boolean checked;
    private final String key;
    private final PermissionOwner permissionOwner;
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddMemberAdapter$Item$PermissionOwnerItem(PermissionOwner permissionOwner, boolean z2, AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus) {
        String strValueOf;
        super(null);
        m.checkNotNullParameter(permissionOwner, "permissionOwner");
        m.checkNotNullParameter(addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus, "addStatus");
        this.permissionOwner = permissionOwner;
        this.checked = z2;
        this.addStatus = addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus;
        this.type = 1;
        if (permissionOwner instanceof PermissionOwner$Member) {
            strValueOf = String.valueOf(((PermissionOwner$Member) permissionOwner).getUser().getId());
        } else {
            if (!(permissionOwner instanceof PermissionOwner$Role)) {
                throw new NoWhenBranchMatchedException();
            }
            strValueOf = String.valueOf(((PermissionOwner$Role) permissionOwner).getRole().getId());
        }
        this.key = strValueOf;
    }

    public static /* synthetic */ AddMemberAdapter$Item$PermissionOwnerItem copy$default(AddMemberAdapter$Item$PermissionOwnerItem addMemberAdapter$Item$PermissionOwnerItem, PermissionOwner permissionOwner, boolean z2, AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            permissionOwner = addMemberAdapter$Item$PermissionOwnerItem.permissionOwner;
        }
        if ((i & 2) != 0) {
            z2 = addMemberAdapter$Item$PermissionOwnerItem.checked;
        }
        if ((i & 4) != 0) {
            addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus = addMemberAdapter$Item$PermissionOwnerItem.addStatus;
        }
        return addMemberAdapter$Item$PermissionOwnerItem.copy(permissionOwner, z2, addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PermissionOwner getPermissionOwner() {
        return this.permissionOwner;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getChecked() {
        return this.checked;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus getAddStatus() {
        return this.addStatus;
    }

    public final AddMemberAdapter$Item$PermissionOwnerItem copy(PermissionOwner permissionOwner, boolean checked, AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus addStatus) {
        m.checkNotNullParameter(permissionOwner, "permissionOwner");
        m.checkNotNullParameter(addStatus, "addStatus");
        return new AddMemberAdapter$Item$PermissionOwnerItem(permissionOwner, checked, addStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddMemberAdapter$Item$PermissionOwnerItem)) {
            return false;
        }
        AddMemberAdapter$Item$PermissionOwnerItem addMemberAdapter$Item$PermissionOwnerItem = (AddMemberAdapter$Item$PermissionOwnerItem) other;
        return m.areEqual(this.permissionOwner, addMemberAdapter$Item$PermissionOwnerItem.permissionOwner) && this.checked == addMemberAdapter$Item$PermissionOwnerItem.checked && m.areEqual(this.addStatus, addMemberAdapter$Item$PermissionOwnerItem.addStatus);
    }

    public final AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus getAddStatus() {
        return this.addStatus;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final PermissionOwner getPermissionOwner() {
        return this.permissionOwner;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        PermissionOwner permissionOwner = this.permissionOwner;
        int iHashCode = (permissionOwner != null ? permissionOwner.hashCode() : 0) * 31;
        boolean z2 = this.checked;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus = this.addStatus;
        return i + (addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus != null ? addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("PermissionOwnerItem(permissionOwner=");
        sbU.append(this.permissionOwner);
        sbU.append(", checked=");
        sbU.append(this.checked);
        sbU.append(", addStatus=");
        sbU.append(this.addStatus);
        sbU.append(")");
        return sbU.toString();
    }
}
