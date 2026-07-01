package com.discord.api.guildrolesubscription;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: PayoutGroup.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class PayoutGroup {
    private final long amount;
    private final long amountDeducted;
    private final long amountPayable;
    private final long applicationId;
    private final String currency;
    private final long deductionsCount;
    private final long groupingId;
    private final PayoutGroupType groupingType;
    private final long id;
    private final long paymentsCount;
    private final Payout payout;
    private final long payoutId;
    private final String periodEndingAt;
    private final String periodStartingAt;
    private final PayoutGroupStatus status;
    private final long userId;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayoutGroup)) {
            return false;
        }
        PayoutGroup payoutGroup = (PayoutGroup) other;
        return this.id == payoutGroup.id && this.payoutId == payoutGroup.payoutId && this.userId == payoutGroup.userId && this.applicationId == payoutGroup.applicationId && this.groupingId == payoutGroup.groupingId && m.areEqual(this.status, payoutGroup.status) && this.amount == payoutGroup.amount && this.amountPayable == payoutGroup.amountPayable && this.amountDeducted == payoutGroup.amountDeducted && this.paymentsCount == payoutGroup.paymentsCount && this.deductionsCount == payoutGroup.deductionsCount && m.areEqual(this.currency, payoutGroup.currency) && m.areEqual(this.groupingType, payoutGroup.groupingType) && m.areEqual(this.periodStartingAt, payoutGroup.periodStartingAt) && m.areEqual(this.periodEndingAt, payoutGroup.periodEndingAt) && m.areEqual(this.payout, payoutGroup.payout);
    }

    public int hashCode() {
        long j = this.id;
        long j2 = this.payoutId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.userId;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.applicationId;
        int i3 = (i2 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.groupingId;
        int i4 = (i3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        PayoutGroupStatus payoutGroupStatus = this.status;
        int iHashCode = payoutGroupStatus != null ? payoutGroupStatus.hashCode() : 0;
        long j6 = this.amount;
        int i5 = (((i4 + iHashCode) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j7 = this.amountPayable;
        int i6 = (i5 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        long j8 = this.amountDeducted;
        int i7 = (i6 + ((int) (j8 ^ (j8 >>> 32)))) * 31;
        long j9 = this.paymentsCount;
        int i8 = (i7 + ((int) (j9 ^ (j9 >>> 32)))) * 31;
        long j10 = this.deductionsCount;
        int i9 = (i8 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        String str = this.currency;
        int iHashCode2 = (i9 + (str != null ? str.hashCode() : 0)) * 31;
        PayoutGroupType payoutGroupType = this.groupingType;
        int iHashCode3 = (iHashCode2 + (payoutGroupType != null ? payoutGroupType.hashCode() : 0)) * 31;
        String str2 = this.periodStartingAt;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.periodEndingAt;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Payout payout = this.payout;
        return iHashCode5 + (payout != null ? payout.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("PayoutGroup(id=");
        sbU.append(this.id);
        sbU.append(", payoutId=");
        sbU.append(this.payoutId);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", groupingId=");
        sbU.append(this.groupingId);
        sbU.append(", status=");
        sbU.append(this.status);
        sbU.append(", amount=");
        sbU.append(this.amount);
        sbU.append(", amountPayable=");
        sbU.append(this.amountPayable);
        sbU.append(", amountDeducted=");
        sbU.append(this.amountDeducted);
        sbU.append(", paymentsCount=");
        sbU.append(this.paymentsCount);
        sbU.append(", deductionsCount=");
        sbU.append(this.deductionsCount);
        sbU.append(", currency=");
        sbU.append(this.currency);
        sbU.append(", groupingType=");
        sbU.append(this.groupingType);
        sbU.append(", periodStartingAt=");
        sbU.append(this.periodStartingAt);
        sbU.append(", periodEndingAt=");
        sbU.append(this.periodEndingAt);
        sbU.append(", payout=");
        sbU.append(this.payout);
        sbU.append(")");
        return sbU.toString();
    }
}
