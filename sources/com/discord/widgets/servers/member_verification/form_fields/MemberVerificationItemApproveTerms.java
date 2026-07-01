package com.discord.widgets.servers.member_verification.form_fields;

import b.d.b.a.a;

/* JADX INFO: compiled from: MemberVerificationItemApproveTerms.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MemberVerificationItemApproveTerms implements MemberVerificationItem {
    private final int fieldIndex;
    private final boolean isApproved;
    private final int type = 2;
    private final String key = String.valueOf(getType());

    public MemberVerificationItemApproveTerms(int i, boolean z2) {
        this.fieldIndex = i;
        this.isApproved = z2;
    }

    public static /* synthetic */ MemberVerificationItemApproveTerms copy$default(MemberVerificationItemApproveTerms memberVerificationItemApproveTerms, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = memberVerificationItemApproveTerms.fieldIndex;
        }
        if ((i2 & 2) != 0) {
            z2 = memberVerificationItemApproveTerms.isApproved;
        }
        return memberVerificationItemApproveTerms.copy(i, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFieldIndex() {
        return this.fieldIndex;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsApproved() {
        return this.isApproved;
    }

    public final MemberVerificationItemApproveTerms copy(int fieldIndex, boolean isApproved) {
        return new MemberVerificationItemApproveTerms(fieldIndex, isApproved);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberVerificationItemApproveTerms)) {
            return false;
        }
        MemberVerificationItemApproveTerms memberVerificationItemApproveTerms = (MemberVerificationItemApproveTerms) other;
        return this.fieldIndex == memberVerificationItemApproveTerms.fieldIndex && this.isApproved == memberVerificationItemApproveTerms.isApproved;
    }

    public final int getFieldIndex() {
        return this.fieldIndex;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int i = this.fieldIndex * 31;
        boolean z2 = this.isApproved;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return i + r1;
    }

    public final boolean isApproved() {
        return this.isApproved;
    }

    public String toString() {
        StringBuilder sbU = a.U("MemberVerificationItemApproveTerms(fieldIndex=");
        sbU.append(this.fieldIndex);
        sbU.append(", isApproved=");
        return a.O(sbU, this.isApproved, ")");
    }
}
