package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackTransactionCompleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackTransactionCompleted implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long paymentId = null;
    private final Long paymentGateway = null;
    private final Long createdAt = null;
    private final Long transactionId = null;
    private final Long transactionType = null;
    private final Long skuId = null;
    private final Float exchangeRate = null;
    private final CharSequence presentmentCurrency = null;
    private final CharSequence settlementCurrency = null;
    private final Long presentmentAmount = null;
    private final Long presentmentFees = null;
    private final Long presentmentTax = null;
    private final Long settlementAmount = null;
    private final Long settlementFees = null;
    private final Long settlementTax = null;
    private final Long netPresentmentAmount = null;
    private final Long netPresentmentFees = null;
    private final Long netPresentmentTax = null;
    private final Long netSettlementAmount = null;
    private final Long netSettlementFees = null;
    private final Long netSettlementTax = null;
    private final transient String analyticsSchemaTypeName = "transaction_completed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackTransactionCompleted)) {
            return false;
        }
        TrackTransactionCompleted trackTransactionCompleted = (TrackTransactionCompleted) other;
        return C12238m.areEqual(this.paymentId, trackTransactionCompleted.paymentId) && C12238m.areEqual(this.paymentGateway, trackTransactionCompleted.paymentGateway) && C12238m.areEqual(this.createdAt, trackTransactionCompleted.createdAt) && C12238m.areEqual(this.transactionId, trackTransactionCompleted.transactionId) && C12238m.areEqual(this.transactionType, trackTransactionCompleted.transactionType) && C12238m.areEqual(this.skuId, trackTransactionCompleted.skuId) && C12238m.areEqual(this.exchangeRate, trackTransactionCompleted.exchangeRate) && C12238m.areEqual(this.presentmentCurrency, trackTransactionCompleted.presentmentCurrency) && C12238m.areEqual(this.settlementCurrency, trackTransactionCompleted.settlementCurrency) && C12238m.areEqual(this.presentmentAmount, trackTransactionCompleted.presentmentAmount) && C12238m.areEqual(this.presentmentFees, trackTransactionCompleted.presentmentFees) && C12238m.areEqual(this.presentmentTax, trackTransactionCompleted.presentmentTax) && C12238m.areEqual(this.settlementAmount, trackTransactionCompleted.settlementAmount) && C12238m.areEqual(this.settlementFees, trackTransactionCompleted.settlementFees) && C12238m.areEqual(this.settlementTax, trackTransactionCompleted.settlementTax) && C12238m.areEqual(this.netPresentmentAmount, trackTransactionCompleted.netPresentmentAmount) && C12238m.areEqual(this.netPresentmentFees, trackTransactionCompleted.netPresentmentFees) && C12238m.areEqual(this.netPresentmentTax, trackTransactionCompleted.netPresentmentTax) && C12238m.areEqual(this.netSettlementAmount, trackTransactionCompleted.netSettlementAmount) && C12238m.areEqual(this.netSettlementFees, trackTransactionCompleted.netSettlementFees) && C12238m.areEqual(this.netSettlementTax, trackTransactionCompleted.netSettlementTax);
    }

    public int hashCode() {
        Long l = this.paymentId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.paymentGateway;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.createdAt;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.transactionId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.transactionType;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.skuId;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Float f = this.exchangeRate;
        int iHashCode7 = (iHashCode6 + (f != null ? f.hashCode() : 0)) * 31;
        CharSequence charSequence = this.presentmentCurrency;
        int iHashCode8 = (iHashCode7 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.settlementCurrency;
        int iHashCode9 = (iHashCode8 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l7 = this.presentmentAmount;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.presentmentFees;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.presentmentTax;
        int iHashCode12 = (iHashCode11 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.settlementAmount;
        int iHashCode13 = (iHashCode12 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.settlementFees;
        int iHashCode14 = (iHashCode13 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.settlementTax;
        int iHashCode15 = (iHashCode14 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.netPresentmentAmount;
        int iHashCode16 = (iHashCode15 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.netPresentmentFees;
        int iHashCode17 = (iHashCode16 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.netPresentmentTax;
        int iHashCode18 = (iHashCode17 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.netSettlementAmount;
        int iHashCode19 = (iHashCode18 + (l16 != null ? l16.hashCode() : 0)) * 31;
        Long l17 = this.netSettlementFees;
        int iHashCode20 = (iHashCode19 + (l17 != null ? l17.hashCode() : 0)) * 31;
        Long l18 = this.netSettlementTax;
        return iHashCode20 + (l18 != null ? l18.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackTransactionCompleted(paymentId=");
        sbM833U.append(this.paymentId);
        sbM833U.append(", paymentGateway=");
        sbM833U.append(this.paymentGateway);
        sbM833U.append(", createdAt=");
        sbM833U.append(this.createdAt);
        sbM833U.append(", transactionId=");
        sbM833U.append(this.transactionId);
        sbM833U.append(", transactionType=");
        sbM833U.append(this.transactionType);
        sbM833U.append(", skuId=");
        sbM833U.append(this.skuId);
        sbM833U.append(", exchangeRate=");
        sbM833U.append(this.exchangeRate);
        sbM833U.append(", presentmentCurrency=");
        sbM833U.append(this.presentmentCurrency);
        sbM833U.append(", settlementCurrency=");
        sbM833U.append(this.settlementCurrency);
        sbM833U.append(", presentmentAmount=");
        sbM833U.append(this.presentmentAmount);
        sbM833U.append(", presentmentFees=");
        sbM833U.append(this.presentmentFees);
        sbM833U.append(", presentmentTax=");
        sbM833U.append(this.presentmentTax);
        sbM833U.append(", settlementAmount=");
        sbM833U.append(this.settlementAmount);
        sbM833U.append(", settlementFees=");
        sbM833U.append(this.settlementFees);
        sbM833U.append(", settlementTax=");
        sbM833U.append(this.settlementTax);
        sbM833U.append(", netPresentmentAmount=");
        sbM833U.append(this.netPresentmentAmount);
        sbM833U.append(", netPresentmentFees=");
        sbM833U.append(this.netPresentmentFees);
        sbM833U.append(", netPresentmentTax=");
        sbM833U.append(this.netPresentmentTax);
        sbM833U.append(", netSettlementAmount=");
        sbM833U.append(this.netSettlementAmount);
        sbM833U.append(", netSettlementFees=");
        sbM833U.append(this.netSettlementFees);
        sbM833U.append(", netSettlementTax=");
        return C1643a.m819G(sbM833U, this.netSettlementTax, ")");
    }
}
