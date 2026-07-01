package com.discord.api.guildrolesubscription;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.guildrolesubscription.Payout, reason: use source file name */
/* JADX INFO: compiled from: PayoutGroup.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class PayoutGroup2 {
    private final Long amount;
    private final long id;
    private final String payoutDate;
    private final String periodEnd;
    private final String periodStart;
    private final PayoutStatus status;
    private final long userId;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayoutGroup2)) {
            return false;
        }
        PayoutGroup2 payoutGroup2 = (PayoutGroup2) other;
        return this.id == payoutGroup2.id && this.userId == payoutGroup2.userId && Intrinsics3.areEqual(this.periodStart, payoutGroup2.periodStart) && Intrinsics3.areEqual(this.periodEnd, payoutGroup2.periodEnd) && Intrinsics3.areEqual(this.payoutDate, payoutGroup2.payoutDate) && Intrinsics3.areEqual(this.status, payoutGroup2.status) && Intrinsics3.areEqual(this.amount, payoutGroup2.amount);
    }

    public int hashCode() {
        long j = this.id;
        long j2 = this.userId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.periodStart;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.periodEnd;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.payoutDate;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        PayoutStatus payoutStatus = this.status;
        int iHashCode4 = (iHashCode3 + (payoutStatus != null ? payoutStatus.hashCode() : 0)) * 31;
        Long l = this.amount;
        return iHashCode4 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Payout(id=");
        sbU.append(this.id);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", periodStart=");
        sbU.append(this.periodStart);
        sbU.append(", periodEnd=");
        sbU.append(this.periodEnd);
        sbU.append(", payoutDate=");
        sbU.append(this.payoutDate);
        sbU.append(", status=");
        sbU.append(this.status);
        sbU.append(", amount=");
        return outline.G(sbU, this.amount, ")");
    }
}
