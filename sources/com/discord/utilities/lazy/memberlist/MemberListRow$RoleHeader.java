package com.discord.utilities.lazy.memberlist;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: MemberListRow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MemberListRow$RoleHeader extends MemberListRow {
    private final int memberCount;
    private final long roleId;
    private final String roleName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberListRow$RoleHeader(long j, String str, int i) {
        super(String.valueOf(j), null);
        m.checkNotNullParameter(str, "roleName");
        this.roleId = j;
        this.roleName = str;
        this.memberCount = i;
    }

    public static /* synthetic */ MemberListRow$RoleHeader copy$default(MemberListRow$RoleHeader memberListRow$RoleHeader, long j, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = memberListRow$RoleHeader.roleId;
        }
        if ((i2 & 2) != 0) {
            str = memberListRow$RoleHeader.roleName;
        }
        if ((i2 & 4) != 0) {
            i = memberListRow$RoleHeader.memberCount;
        }
        return memberListRow$RoleHeader.copy(j, str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getRoleId() {
        return this.roleId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRoleName() {
        return this.roleName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMemberCount() {
        return this.memberCount;
    }

    public final MemberListRow$RoleHeader copy(long roleId, String roleName, int memberCount) {
        m.checkNotNullParameter(roleName, "roleName");
        return new MemberListRow$RoleHeader(roleId, roleName, memberCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberListRow$RoleHeader)) {
            return false;
        }
        MemberListRow$RoleHeader memberListRow$RoleHeader = (MemberListRow$RoleHeader) other;
        return this.roleId == memberListRow$RoleHeader.roleId && m.areEqual(this.roleName, memberListRow$RoleHeader.roleName) && this.memberCount == memberListRow$RoleHeader.memberCount;
    }

    public final int getMemberCount() {
        return this.memberCount;
    }

    public final long getRoleId() {
        return this.roleId;
    }

    public final String getRoleName() {
        return this.roleName;
    }

    public int hashCode() {
        int iA = b.a(this.roleId) * 31;
        String str = this.roleName;
        return ((iA + (str != null ? str.hashCode() : 0)) * 31) + this.memberCount;
    }

    public String toString() {
        StringBuilder sbU = a.U("RoleHeader(roleId=");
        sbU.append(this.roleId);
        sbU.append(", roleName=");
        sbU.append(this.roleName);
        sbU.append(", memberCount=");
        return a.B(sbU, this.memberCount, ")");
    }
}
