package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
        return m.areEqual(this.paymentId, trackTransactionCompleted.paymentId) && m.areEqual(this.paymentGateway, trackTransactionCompleted.paymentGateway) && m.areEqual(this.createdAt, trackTransactionCompleted.createdAt) && m.areEqual(this.transactionId, trackTransactionCompleted.transactionId) && m.areEqual(this.transactionType, trackTransactionCompleted.transactionType) && m.areEqual(this.skuId, trackTransactionCompleted.skuId) && m.areEqual(this.exchangeRate, trackTransactionCompleted.exchangeRate) && m.areEqual(this.presentmentCurrency, trackTransactionCompleted.presentmentCurrency) && m.areEqual(this.settlementCurrency, trackTransactionCompleted.settlementCurrency) && m.areEqual(this.presentmentAmount, trackTransactionCompleted.presentmentAmount) && m.areEqual(this.presentmentFees, trackTransactionCompleted.presentmentFees) && m.areEqual(this.presentmentTax, trackTransactionCompleted.presentmentTax) && m.areEqual(this.settlementAmount, trackTransactionCompleted.settlementAmount) && m.areEqual(this.settlementFees, trackTransactionCompleted.settlementFees) && m.areEqual(this.settlementTax, trackTransactionCompleted.settlementTax) && m.areEqual(this.netPresentmentAmount, trackTransactionCompleted.netPresentmentAmount) && m.areEqual(this.netPresentmentFees, trackTransactionCompleted.netPresentmentFees) && m.areEqual(this.netPresentmentTax, trackTransactionCompleted.netPresentmentTax) && m.areEqual(this.netSettlementAmount, trackTransactionCompleted.netSettlementAmount) && m.areEqual(this.netSettlementFees, trackTransactionCompleted.netSettlementFees) && m.areEqual(this.netSettlementTax, trackTransactionCompleted.netSettlementTax);
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
        StringBuilder sbU = a.U("TrackTransactionCompleted(paymentId=");
        sbU.append(this.paymentId);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", transactionId=");
        sbU.append(this.transactionId);
        sbU.append(", transactionType=");
        sbU.append(this.transactionType);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", exchangeRate=");
        sbU.append(this.exchangeRate);
        sbU.append(", presentmentCurrency=");
        sbU.append(this.presentmentCurrency);
        sbU.append(", settlementCurrency=");
        sbU.append(this.settlementCurrency);
        sbU.append(", presentmentAmount=");
        sbU.append(this.presentmentAmount);
        sbU.append(", presentmentFees=");
        sbU.append(this.presentmentFees);
        sbU.append(", presentmentTax=");
        sbU.append(this.presentmentTax);
        sbU.append(", settlementAmount=");
        sbU.append(this.settlementAmount);
        sbU.append(", settlementFees=");
        sbU.append(this.settlementFees);
        sbU.append(", settlementTax=");
        sbU.append(this.settlementTax);
        sbU.append(", netPresentmentAmount=");
        sbU.append(this.netPresentmentAmount);
        sbU.append(", netPresentmentFees=");
        sbU.append(this.netPresentmentFees);
        sbU.append(", netPresentmentTax=");
        sbU.append(this.netPresentmentTax);
        sbU.append(", netSettlementAmount=");
        sbU.append(this.netSettlementAmount);
        sbU.append(", netSettlementFees=");
        sbU.append(this.netSettlementFees);
        sbU.append(", netSettlementTax=");
        return a.G(sbU, this.netSettlementTax, ")");
    }
}
