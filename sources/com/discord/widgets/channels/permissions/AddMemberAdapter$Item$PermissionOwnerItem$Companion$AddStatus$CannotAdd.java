package com.discord.widgets.channels.permissions;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: AddMemberAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd extends AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus {
    private final AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd$Reason reason;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd(AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd$Reason addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd$Reason) {
        super(null);
        m.checkNotNullParameter(addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd$Reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        this.reason = addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd$Reason;
    }

    public static /* synthetic */ AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd copy$default(AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd, AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd$Reason addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd$Reason, int i, Object obj) {
        if ((i & 1) != 0) {
            addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd$Reason = addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd.reason;
        }
        return addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd.copy(addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd$Reason);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd$Reason getReason() {
        return this.reason;
    }

    public final AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd copy(AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd$Reason reason) {
        m.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        return new AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd(reason);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd) && m.areEqual(this.reason, ((AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd) other).reason);
        }
        return true;
    }

    public final AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd$Reason getReason() {
        return this.reason;
    }

    public int hashCode() {
        AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd$Reason addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd$Reason = this.reason;
        if (addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd$Reason != null) {
            return addMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd$Reason.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("CannotAdd(reason=");
        sbU.append(this.reason);
        sbU.append(")");
        return sbU.toString();
    }
}
