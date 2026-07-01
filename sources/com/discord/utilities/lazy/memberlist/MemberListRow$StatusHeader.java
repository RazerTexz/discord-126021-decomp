package com.discord.utilities.lazy.memberlist;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: MemberListRow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MemberListRow$StatusHeader extends MemberListRow {
    private final int memberCount;
    private final String rowId;
    private final MemberListRow$StatusHeader$Type type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberListRow$StatusHeader(String str, MemberListRow$StatusHeader$Type memberListRow$StatusHeader$Type, int i) {
        super(str, null);
        m.checkNotNullParameter(str, "rowId");
        m.checkNotNullParameter(memberListRow$StatusHeader$Type, "type");
        this.rowId = str;
        this.type = memberListRow$StatusHeader$Type;
        this.memberCount = i;
    }

    public static /* synthetic */ MemberListRow$StatusHeader copy$default(MemberListRow$StatusHeader memberListRow$StatusHeader, String str, MemberListRow$StatusHeader$Type memberListRow$StatusHeader$Type, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = memberListRow$StatusHeader.getRowId();
        }
        if ((i2 & 2) != 0) {
            memberListRow$StatusHeader$Type = memberListRow$StatusHeader.type;
        }
        if ((i2 & 4) != 0) {
            i = memberListRow$StatusHeader.memberCount;
        }
        return memberListRow$StatusHeader.copy(str, memberListRow$StatusHeader$Type, i);
    }

    public final String component1() {
        return getRowId();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MemberListRow$StatusHeader$Type getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMemberCount() {
        return this.memberCount;
    }

    public final MemberListRow$StatusHeader copy(String rowId, MemberListRow$StatusHeader$Type type, int memberCount) {
        m.checkNotNullParameter(rowId, "rowId");
        m.checkNotNullParameter(type, "type");
        return new MemberListRow$StatusHeader(rowId, type, memberCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberListRow$StatusHeader)) {
            return false;
        }
        MemberListRow$StatusHeader memberListRow$StatusHeader = (MemberListRow$StatusHeader) other;
        return m.areEqual(getRowId(), memberListRow$StatusHeader.getRowId()) && m.areEqual(this.type, memberListRow$StatusHeader.type) && this.memberCount == memberListRow$StatusHeader.memberCount;
    }

    public final int getMemberCount() {
        return this.memberCount;
    }

    @Override // com.discord.utilities.lazy.memberlist.MemberListRow
    public String getRowId() {
        return this.rowId;
    }

    public final MemberListRow$StatusHeader$Type getType() {
        return this.type;
    }

    public int hashCode() {
        String rowId = getRowId();
        int iHashCode = (rowId != null ? rowId.hashCode() : 0) * 31;
        MemberListRow$StatusHeader$Type memberListRow$StatusHeader$Type = this.type;
        return ((iHashCode + (memberListRow$StatusHeader$Type != null ? memberListRow$StatusHeader$Type.hashCode() : 0)) * 31) + this.memberCount;
    }

    public String toString() {
        StringBuilder sbU = a.U("StatusHeader(rowId=");
        sbU.append(getRowId());
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", memberCount=");
        return a.B(sbU, this.memberCount, ")");
    }
}
