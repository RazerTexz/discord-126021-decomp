package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackPaymentFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPaymentFailed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence failureReason = null;
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
    private final CharSequence failureCode = null;
    private final CharSequence failureSubCode = null;
    private final Boolean captured = null;
    private final transient String analyticsSchemaTypeName = "payment_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPaymentFailed)) {
            return false;
        }
        TrackPaymentFailed trackPaymentFailed = (TrackPaymentFailed) other;
        return C12238m.areEqual(this.failureReason, trackPaymentFailed.failureReason) && C12238m.areEqual(this.paymentId, trackPaymentFailed.paymentId) && C12238m.areEqual(this.createdAt, trackPaymentFailed.createdAt) && C12238m.areEqual(this.paymentType, trackPaymentFailed.paymentType) && C12238m.areEqual(this.paymentGateway, trackPaymentFailed.paymentGateway) && C12238m.areEqual(this.price, trackPaymentFailed.price) && C12238m.areEqual(this.currency, trackPaymentFailed.currency) && C12238m.areEqual(this.amount, trackPaymentFailed.amount) && C12238m.areEqual(this.amountRefunded, trackPaymentFailed.amountRefunded) && C12238m.areEqual(this.tax, trackPaymentFailed.tax) && C12238m.areEqual(this.taxInclusive, trackPaymentFailed.taxInclusive) && C12238m.areEqual(this.skuId, trackPaymentFailed.skuId) && C12238m.areEqual(this.skuType, trackPaymentFailed.skuType) && C12238m.areEqual(this.skuSubscriptionPlanId, trackPaymentFailed.skuSubscriptionPlanId) && C12238m.areEqual(this.subscriptionId, trackPaymentFailed.subscriptionId) && C12238m.areEqual(this.subscriptionType, trackPaymentFailed.subscriptionType) && C12238m.areEqual(this.subscriptionPaymentGatewayPlanId, trackPaymentFailed.subscriptionPaymentGatewayPlanId) && C12238m.areEqual(this.subscriptionPlanId, trackPaymentFailed.subscriptionPlanId) && C12238m.areEqual(this.subscriptionCreatedAt, trackPaymentFailed.subscriptionCreatedAt) && C12238m.areEqual(this.subscriptionCurrentPeriodStart, trackPaymentFailed.subscriptionCurrentPeriodStart) && C12238m.areEqual(this.subscriptionCurrentPeriodEnd, trackPaymentFailed.subscriptionCurrentPeriodEnd) && C12238m.areEqual(this.paymentSourceId, trackPaymentFailed.paymentSourceId) && C12238m.areEqual(this.paymentSourceCountry, trackPaymentFailed.paymentSourceCountry) && C12238m.areEqual(this.failureMessage, trackPaymentFailed.failureMessage) && C12238m.areEqual(this.isGift, trackPaymentFailed.isGift) && C12238m.areEqual(this.failureCode, trackPaymentFailed.failureCode) && C12238m.areEqual(this.failureSubCode, trackPaymentFailed.failureSubCode) && C12238m.areEqual(this.captured, trackPaymentFailed.captured);
    }

    public int hashCode() {
        CharSequence charSequence = this.failureReason;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.paymentId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.createdAt;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.paymentType;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l3 = this.paymentGateway;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.price;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.currency;
        int iHashCode7 = (iHashCode6 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l5 = this.amount;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.amountRefunded;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.tax;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Boolean bool = this.taxInclusive;
        int iHashCode11 = (iHashCode10 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l8 = this.skuId;
        int iHashCode12 = (iHashCode11 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.skuType;
        int iHashCode13 = (iHashCode12 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.skuSubscriptionPlanId;
        int iHashCode14 = (iHashCode13 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.subscriptionId;
        int iHashCode15 = (iHashCode14 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.subscriptionType;
        int iHashCode16 = (iHashCode15 + (l12 != null ? l12.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.subscriptionPaymentGatewayPlanId;
        int iHashCode17 = (iHashCode16 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l13 = this.subscriptionPlanId;
        int iHashCode18 = (iHashCode17 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.subscriptionCreatedAt;
        int iHashCode19 = (iHashCode18 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.subscriptionCurrentPeriodStart;
        int iHashCode20 = (iHashCode19 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.subscriptionCurrentPeriodEnd;
        int iHashCode21 = (iHashCode20 + (l16 != null ? l16.hashCode() : 0)) * 31;
        Long l17 = this.paymentSourceId;
        int iHashCode22 = (iHashCode21 + (l17 != null ? l17.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.paymentSourceCountry;
        int iHashCode23 = (iHashCode22 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.failureMessage;
        int iHashCode24 = (iHashCode23 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Boolean bool2 = this.isGift;
        int iHashCode25 = (iHashCode24 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.failureCode;
        int iHashCode26 = (iHashCode25 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.failureSubCode;
        int iHashCode27 = (iHashCode26 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        Boolean bool3 = this.captured;
        return iHashCode27 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackPaymentFailed(failureReason=");
        sbM833U.append(this.failureReason);
        sbM833U.append(", paymentId=");
        sbM833U.append(this.paymentId);
        sbM833U.append(", createdAt=");
        sbM833U.append(this.createdAt);
        sbM833U.append(", paymentType=");
        sbM833U.append(this.paymentType);
        sbM833U.append(", paymentGateway=");
        sbM833U.append(this.paymentGateway);
        sbM833U.append(", price=");
        sbM833U.append(this.price);
        sbM833U.append(", currency=");
        sbM833U.append(this.currency);
        sbM833U.append(", amount=");
        sbM833U.append(this.amount);
        sbM833U.append(", amountRefunded=");
        sbM833U.append(this.amountRefunded);
        sbM833U.append(", tax=");
        sbM833U.append(this.tax);
        sbM833U.append(", taxInclusive=");
        sbM833U.append(this.taxInclusive);
        sbM833U.append(", skuId=");
        sbM833U.append(this.skuId);
        sbM833U.append(", skuType=");
        sbM833U.append(this.skuType);
        sbM833U.append(", skuSubscriptionPlanId=");
        sbM833U.append(this.skuSubscriptionPlanId);
        sbM833U.append(", subscriptionId=");
        sbM833U.append(this.subscriptionId);
        sbM833U.append(", subscriptionType=");
        sbM833U.append(this.subscriptionType);
        sbM833U.append(", subscriptionPaymentGatewayPlanId=");
        sbM833U.append(this.subscriptionPaymentGatewayPlanId);
        sbM833U.append(", subscriptionPlanId=");
        sbM833U.append(this.subscriptionPlanId);
        sbM833U.append(", subscriptionCreatedAt=");
        sbM833U.append(this.subscriptionCreatedAt);
        sbM833U.append(", subscriptionCurrentPeriodStart=");
        sbM833U.append(this.subscriptionCurrentPeriodStart);
        sbM833U.append(", subscriptionCurrentPeriodEnd=");
        sbM833U.append(this.subscriptionCurrentPeriodEnd);
        sbM833U.append(", paymentSourceId=");
        sbM833U.append(this.paymentSourceId);
        sbM833U.append(", paymentSourceCountry=");
        sbM833U.append(this.paymentSourceCountry);
        sbM833U.append(", failureMessage=");
        sbM833U.append(this.failureMessage);
        sbM833U.append(", isGift=");
        sbM833U.append(this.isGift);
        sbM833U.append(", failureCode=");
        sbM833U.append(this.failureCode);
        sbM833U.append(", failureSubCode=");
        sbM833U.append(this.failureSubCode);
        sbM833U.append(", captured=");
        return C1643a.m816D(sbM833U, this.captured, ")");
    }
}
