package com.discord.api.guildrolesubscription;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PayoutGroup.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Payout {
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
        if (!(other instanceof Payout)) {
            return false;
        }
        Payout payout = (Payout) other;
        return this.id == payout.id && this.userId == payout.userId && C12238m.areEqual(this.periodStart, payout.periodStart) && C12238m.areEqual(this.periodEnd, payout.periodEnd) && C12238m.areEqual(this.payoutDate, payout.payoutDate) && C12238m.areEqual(this.status, payout.status) && C12238m.areEqual(this.amount, payout.amount);
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
        StringBuilder sbM833U = C1643a.m833U("Payout(id=");
        sbM833U.append(this.id);
        sbM833U.append(", userId=");
        sbM833U.append(this.userId);
        sbM833U.append(", periodStart=");
        sbM833U.append(this.periodStart);
        sbM833U.append(", periodEnd=");
        sbM833U.append(this.periodEnd);
        sbM833U.append(", payoutDate=");
        sbM833U.append(this.payoutDate);
        sbM833U.append(", status=");
        sbM833U.append(this.status);
        sbM833U.append(", amount=");
        return C1643a.m819G(sbM833U, this.amount, ")");
    }
}
