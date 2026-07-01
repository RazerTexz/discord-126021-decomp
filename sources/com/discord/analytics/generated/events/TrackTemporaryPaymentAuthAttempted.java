package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackTemporaryPaymentAuthAttempted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackTemporaryPaymentAuthAttempted implements AnalyticsSchema, TrackBase2 {
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
    private final CharSequence loadId = null;
    private final Boolean isGift = null;
    private final Boolean captured = null;
    private final transient String analyticsSchemaTypeName = "temporary_payment_auth_attempted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackTemporaryPaymentAuthAttempted)) {
            return false;
        }
        TrackTemporaryPaymentAuthAttempted trackTemporaryPaymentAuthAttempted = (TrackTemporaryPaymentAuthAttempted) other;
        return Intrinsics3.areEqual(this.paymentId, trackTemporaryPaymentAuthAttempted.paymentId) && Intrinsics3.areEqual(this.createdAt, trackTemporaryPaymentAuthAttempted.createdAt) && Intrinsics3.areEqual(this.paymentType, trackTemporaryPaymentAuthAttempted.paymentType) && Intrinsics3.areEqual(this.paymentGateway, trackTemporaryPaymentAuthAttempted.paymentGateway) && Intrinsics3.areEqual(this.price, trackTemporaryPaymentAuthAttempted.price) && Intrinsics3.areEqual(this.currency, trackTemporaryPaymentAuthAttempted.currency) && Intrinsics3.areEqual(this.amount, trackTemporaryPaymentAuthAttempted.amount) && Intrinsics3.areEqual(this.amountRefunded, trackTemporaryPaymentAuthAttempted.amountRefunded) && Intrinsics3.areEqual(this.tax, trackTemporaryPaymentAuthAttempted.tax) && Intrinsics3.areEqual(this.taxInclusive, trackTemporaryPaymentAuthAttempted.taxInclusive) && Intrinsics3.areEqual(this.skuId, trackTemporaryPaymentAuthAttempted.skuId) && Intrinsics3.areEqual(this.skuType, trackTemporaryPaymentAuthAttempted.skuType) && Intrinsics3.areEqual(this.skuSubscriptionPlanId, trackTemporaryPaymentAuthAttempted.skuSubscriptionPlanId) && Intrinsics3.areEqual(this.subscriptionId, trackTemporaryPaymentAuthAttempted.subscriptionId) && Intrinsics3.areEqual(this.subscriptionType, trackTemporaryPaymentAuthAttempted.subscriptionType) && Intrinsics3.areEqual(this.subscriptionPaymentGatewayPlanId, trackTemporaryPaymentAuthAttempted.subscriptionPaymentGatewayPlanId) && Intrinsics3.areEqual(this.subscriptionPlanId, trackTemporaryPaymentAuthAttempted.subscriptionPlanId) && Intrinsics3.areEqual(this.subscriptionCreatedAt, trackTemporaryPaymentAuthAttempted.subscriptionCreatedAt) && Intrinsics3.areEqual(this.subscriptionCurrentPeriodStart, trackTemporaryPaymentAuthAttempted.subscriptionCurrentPeriodStart) && Intrinsics3.areEqual(this.subscriptionCurrentPeriodEnd, trackTemporaryPaymentAuthAttempted.subscriptionCurrentPeriodEnd) && Intrinsics3.areEqual(this.paymentSourceId, trackTemporaryPaymentAuthAttempted.paymentSourceId) && Intrinsics3.areEqual(this.paymentSourceCountry, trackTemporaryPaymentAuthAttempted.paymentSourceCountry) && Intrinsics3.areEqual(this.failureMessage, trackTemporaryPaymentAuthAttempted.failureMessage) && Intrinsics3.areEqual(this.loadId, trackTemporaryPaymentAuthAttempted.loadId) && Intrinsics3.areEqual(this.isGift, trackTemporaryPaymentAuthAttempted.isGift) && Intrinsics3.areEqual(this.captured, trackTemporaryPaymentAuthAttempted.captured);
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
        CharSequence charSequence6 = this.loadId;
        int iHashCode24 = (iHashCode23 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Boolean bool2 = this.isGift;
        int iHashCode25 = (iHashCode24 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.captured;
        return iHashCode25 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackTemporaryPaymentAuthAttempted(paymentId=");
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
        sbU.append(", loadId=");
        sbU.append(this.loadId);
        sbU.append(", isGift=");
        sbU.append(this.isGift);
        sbU.append(", captured=");
        return outline.D(sbU, this.captured, ")");
    }
}
