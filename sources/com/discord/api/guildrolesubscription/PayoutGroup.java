package com.discord.api.guildrolesubscription;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return this.id == payoutGroup.id && this.payoutId == payoutGroup.payoutId && this.userId == payoutGroup.userId && this.applicationId == payoutGroup.applicationId && this.groupingId == payoutGroup.groupingId && C12238m.areEqual(this.status, payoutGroup.status) && this.amount == payoutGroup.amount && this.amountPayable == payoutGroup.amountPayable && this.amountDeducted == payoutGroup.amountDeducted && this.paymentsCount == payoutGroup.paymentsCount && this.deductionsCount == payoutGroup.deductionsCount && C12238m.areEqual(this.currency, payoutGroup.currency) && C12238m.areEqual(this.groupingType, payoutGroup.groupingType) && C12238m.areEqual(this.periodStartingAt, payoutGroup.periodStartingAt) && C12238m.areEqual(this.periodEndingAt, payoutGroup.periodEndingAt) && C12238m.areEqual(this.payout, payoutGroup.payout);
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
        StringBuilder sbM833U = C1643a.m833U("PayoutGroup(id=");
        sbM833U.append(this.id);
        sbM833U.append(", payoutId=");
        sbM833U.append(this.payoutId);
        sbM833U.append(", userId=");
        sbM833U.append(this.userId);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", groupingId=");
        sbM833U.append(this.groupingId);
        sbM833U.append(", status=");
        sbM833U.append(this.status);
        sbM833U.append(", amount=");
        sbM833U.append(this.amount);
        sbM833U.append(", amountPayable=");
        sbM833U.append(this.amountPayable);
        sbM833U.append(", amountDeducted=");
        sbM833U.append(this.amountDeducted);
        sbM833U.append(", paymentsCount=");
        sbM833U.append(this.paymentsCount);
        sbM833U.append(", deductionsCount=");
        sbM833U.append(this.deductionsCount);
        sbM833U.append(", currency=");
        sbM833U.append(this.currency);
        sbM833U.append(", groupingType=");
        sbM833U.append(this.groupingType);
        sbM833U.append(", periodStartingAt=");
        sbM833U.append(this.periodStartingAt);
        sbM833U.append(", periodEndingAt=");
        sbM833U.append(this.periodEndingAt);
        sbM833U.append(", payout=");
        sbM833U.append(this.payout);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
