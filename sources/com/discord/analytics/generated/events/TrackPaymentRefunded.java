package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackPaymentRefunded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPaymentRefunded implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long paymentId = null;
    private final Long createdAt = null;
    private final CharSequence paymentType = null;
    private final Long paymentGateway = null;
    private final Long price = null;
    private final CharSequence currency = null;
    private final Long amount = null;
    private final Long amountRefunded = null;
    private final Long tax = null;
    private final Boolean taxInclusive = null;
    private final Long skuId = null;
    private final Long skuType = null;
    private final Long skuSubscriptionPlanId = null;
    private final Long subscriptionId = null;
    private final Long subscriptionType = null;
    private final CharSequence subscriptionPaymentGatewayPlanId = null;
    private final Long subscriptionPlanId = null;
    private final Long subscriptionCreatedAt = null;
    private final Long subscriptionCurrentPeriodStart = null;
    private final Long subscriptionCurrentPeriodEnd = null;
    private final Long paymentSourceId = null;
    private final CharSequence paymentSourceCountry = null;
    private final CharSequence failureMessage = null;
    private final Boolean isGift = null;
    private final CharSequence refundReason = null;
    private final Boolean captured = null;
    private final Long refunderType = null;
    private final Long refundedBy = null;
    private final Boolean refundedOutOfPolicy = null;
    private final transient String analyticsSchemaTypeName = "payment_refunded";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPaymentRefunded)) {
            return false;
        }
        TrackPaymentRefunded trackPaymentRefunded = (TrackPaymentRefunded) other;
        return m.areEqual(this.paymentId, trackPaymentRefunded.paymentId) && m.areEqual(this.createdAt, trackPaymentRefunded.createdAt) && m.areEqual(this.paymentType, trackPaymentRefunded.paymentType) && m.areEqual(this.paymentGateway, trackPaymentRefunded.paymentGateway) && m.areEqual(this.price, trackPaymentRefunded.price) && m.areEqual(this.currency, trackPaymentRefunded.currency) && m.areEqual(this.amount, trackPaymentRefunded.amount) && m.areEqual(this.amountRefunded, trackPaymentRefunded.amountRefunded) && m.areEqual(this.tax, trackPaymentRefunded.tax) && m.areEqual(this.taxInclusive, trackPaymentRefunded.taxInclusive) && m.areEqual(this.skuId, trackPaymentRefunded.skuId) && m.areEqual(this.skuType, trackPaymentRefunded.skuType) && m.areEqual(this.skuSubscriptionPlanId, trackPaymentRefunded.skuSubscriptionPlanId) && m.areEqual(this.subscriptionId, trackPaymentRefunded.subscriptionId) && m.areEqual(this.subscriptionType, trackPaymentRefunded.subscriptionType) && m.areEqual(this.subscriptionPaymentGatewayPlanId, trackPaymentRefunded.subscriptionPaymentGatewayPlanId) && m.areEqual(this.subscriptionPlanId, trackPaymentRefunded.subscriptionPlanId) && m.areEqual(this.subscriptionCreatedAt, trackPaymentRefunded.subscriptionCreatedAt) && m.areEqual(this.subscriptionCurrentPeriodStart, trackPaymentRefunded.subscriptionCurrentPeriodStart) && m.areEqual(this.subscriptionCurrentPeriodEnd, trackPaymentRefunded.subscriptionCurrentPeriodEnd) && m.areEqual(this.paymentSourceId, trackPaymentRefunded.paymentSourceId) && m.areEqual(this.paymentSourceCountry, trackPaymentRefunded.paymentSourceCountry) && m.areEqual(this.failureMessage, trackPaymentRefunded.failureMessage) && m.areEqual(this.isGift, trackPaymentRefunded.isGift) && m.areEqual(this.refundReason, trackPaymentRefunded.refundReason) && m.areEqual(this.captured, trackPaymentRefunded.captured) && m.areEqual(this.refunderType, trackPaymentRefunded.refunderType) && m.areEqual(this.refundedBy, trackPaymentRefunded.refundedBy) && m.areEqual(this.refundedOutOfPolicy, trackPaymentRefunded.refundedOutOfPolicy);
    }

    public int hashCode() {
        Long l = this.paymentId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.createdAt;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.paymentType;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l3 = this.paymentGateway;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.price;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.currency;
        int iHashCode6 = (iHashCode5 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l5 = this.amount;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.amountRefunded;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.tax;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Boolean bool = this.taxInclusive;
        int iHashCode10 = (iHashCode9 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l8 = this.skuId;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.skuType;
        int iHashCode12 = (iHashCode11 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.skuSubscriptionPlanId;
        int iHashCode13 = (iHashCode12 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.subscriptionId;
        int iHashCode14 = (iHashCode13 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.subscriptionType;
        int iHashCode15 = (iHashCode14 + (l12 != null ? l12.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.subscriptionPaymentGatewayPlanId;
        int iHashCode16 = (iHashCode15 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l13 = this.subscriptionPlanId;
        int iHashCode17 = (iHashCode16 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.subscriptionCreatedAt;
        int iHashCode18 = (iHashCode17 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.subscriptionCurrentPeriodStart;
        int iHashCode19 = (iHashCode18 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.subscriptionCurrentPeriodEnd;
        int iHashCode20 = (iHashCode19 + (l16 != null ? l16.hashCode() : 0)) * 31;
        Long l17 = this.paymentSourceId;
        int iHashCode21 = (iHashCode20 + (l17 != null ? l17.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.paymentSourceCountry;
        int iHashCode22 = (iHashCode21 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.failureMessage;
        int iHashCode23 = (iHashCode22 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Boolean bool2 = this.isGift;
        int iHashCode24 = (iHashCode23 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.refundReason;
        int iHashCode25 = (iHashCode24 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Boolean bool3 = this.captured;
        int iHashCode26 = (iHashCode25 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l18 = this.refunderType;
        int iHashCode27 = (iHashCode26 + (l18 != null ? l18.hashCode() : 0)) * 31;
        Long l19 = this.refundedBy;
        int iHashCode28 = (iHashCode27 + (l19 != null ? l19.hashCode() : 0)) * 31;
        Boolean bool4 = this.refundedOutOfPolicy;
        return iHashCode28 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackPaymentRefunded(paymentId=");
        sbU.append(this.paymentId);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", paymentType=");
        sbU.append(this.paymentType);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", price=");
        sbU.append(this.price);
        sbU.append(", currency=");
        sbU.append(this.currency);
        sbU.append(", amount=");
        sbU.append(this.amount);
        sbU.append(", amountRefunded=");
        sbU.append(this.amountRefunded);
        sbU.append(", tax=");
        sbU.append(this.tax);
        sbU.append(", taxInclusive=");
        sbU.append(this.taxInclusive);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", skuType=");
        sbU.append(this.skuType);
        sbU.append(", skuSubscriptionPlanId=");
        sbU.append(this.skuSubscriptionPlanId);
        sbU.append(", subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", subscriptionType=");
        sbU.append(this.subscriptionType);
        sbU.append(", subscriptionPaymentGatewayPlanId=");
        sbU.append(this.subscriptionPaymentGatewayPlanId);
        sbU.append(", subscriptionPlanId=");
        sbU.append(this.subscriptionPlanId);
        sbU.append(", subscriptionCreatedAt=");
        sbU.append(this.subscriptionCreatedAt);
        sbU.append(", subscriptionCurrentPeriodStart=");
        sbU.append(this.subscriptionCurrentPeriodStart);
        sbU.append(", subscriptionCurrentPeriodEnd=");
        sbU.append(this.subscriptionCurrentPeriodEnd);
        sbU.append(", paymentSourceId=");
        sbU.append(this.paymentSourceId);
        sbU.append(", paymentSourceCountry=");
        sbU.append(this.paymentSourceCountry);
        sbU.append(", failureMessage=");
        sbU.append(this.failureMessage);
        sbU.append(", isGift=");
        sbU.append(this.isGift);
        sbU.append(", refundReason=");
        sbU.append(this.refundReason);
        sbU.append(", captured=");
        sbU.append(this.captured);
        sbU.append(", refunderType=");
        sbU.append(this.refunderType);
        sbU.append(", refundedBy=");
        sbU.append(this.refundedBy);
        sbU.append(", refundedOutOfPolicy=");
        return a.D(sbU, this.refundedOutOfPolicy, ")");
    }
}
