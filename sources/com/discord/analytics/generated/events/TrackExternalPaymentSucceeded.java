package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackExternalPaymentSucceeded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackExternalPaymentSucceeded implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long amount = null;
    private final Long createdAt = null;
    private final CharSequence currency = null;
    private final Long amountRefunded = null;
    private final Long paymentGateway = null;
    private final Long paymentId = null;
    private final CharSequence paymentType = null;
    private final Long price = null;
    private final Long skuId = null;
    private final Long skuSubscriptionPlanId = null;
    private final Long skuType = null;
    private final Long subscriptionCurrentPeriodEnd = null;
    private final Long subscriptionCurrentPeriodStart = null;
    private final Long subscriptionId = null;
    private final CharSequence subscriptionPaymentGatewayPlanId = null;
    private final Long subscriptionPlanId = null;
    private final Long subscriptionPremiumGuildPlanId = null;
    private final Long subscriptionPremiumGuildQuantity = null;
    private final Long subscriptionPremiumPlanId = null;
    private final Long subscriptionType = null;
    private final transient String analyticsSchemaTypeName = "external_payment_succeeded";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackExternalPaymentSucceeded)) {
            return false;
        }
        TrackExternalPaymentSucceeded trackExternalPaymentSucceeded = (TrackExternalPaymentSucceeded) other;
        return m.areEqual(this.amount, trackExternalPaymentSucceeded.amount) && m.areEqual(this.createdAt, trackExternalPaymentSucceeded.createdAt) && m.areEqual(this.currency, trackExternalPaymentSucceeded.currency) && m.areEqual(this.amountRefunded, trackExternalPaymentSucceeded.amountRefunded) && m.areEqual(this.paymentGateway, trackExternalPaymentSucceeded.paymentGateway) && m.areEqual(this.paymentId, trackExternalPaymentSucceeded.paymentId) && m.areEqual(this.paymentType, trackExternalPaymentSucceeded.paymentType) && m.areEqual(this.price, trackExternalPaymentSucceeded.price) && m.areEqual(this.skuId, trackExternalPaymentSucceeded.skuId) && m.areEqual(this.skuSubscriptionPlanId, trackExternalPaymentSucceeded.skuSubscriptionPlanId) && m.areEqual(this.skuType, trackExternalPaymentSucceeded.skuType) && m.areEqual(this.subscriptionCurrentPeriodEnd, trackExternalPaymentSucceeded.subscriptionCurrentPeriodEnd) && m.areEqual(this.subscriptionCurrentPeriodStart, trackExternalPaymentSucceeded.subscriptionCurrentPeriodStart) && m.areEqual(this.subscriptionId, trackExternalPaymentSucceeded.subscriptionId) && m.areEqual(this.subscriptionPaymentGatewayPlanId, trackExternalPaymentSucceeded.subscriptionPaymentGatewayPlanId) && m.areEqual(this.subscriptionPlanId, trackExternalPaymentSucceeded.subscriptionPlanId) && m.areEqual(this.subscriptionPremiumGuildPlanId, trackExternalPaymentSucceeded.subscriptionPremiumGuildPlanId) && m.areEqual(this.subscriptionPremiumGuildQuantity, trackExternalPaymentSucceeded.subscriptionPremiumGuildQuantity) && m.areEqual(this.subscriptionPremiumPlanId, trackExternalPaymentSucceeded.subscriptionPremiumPlanId) && m.areEqual(this.subscriptionType, trackExternalPaymentSucceeded.subscriptionType);
    }

    public int hashCode() {
        Long l = this.amount;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.createdAt;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.currency;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l3 = this.amountRefunded;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.paymentGateway;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.paymentId;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.paymentType;
        int iHashCode7 = (iHashCode6 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l6 = this.price;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.skuId;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.skuSubscriptionPlanId;
        int iHashCode10 = (iHashCode9 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.skuType;
        int iHashCode11 = (iHashCode10 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.subscriptionCurrentPeriodEnd;
        int iHashCode12 = (iHashCode11 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.subscriptionCurrentPeriodStart;
        int iHashCode13 = (iHashCode12 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.subscriptionId;
        int iHashCode14 = (iHashCode13 + (l12 != null ? l12.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.subscriptionPaymentGatewayPlanId;
        int iHashCode15 = (iHashCode14 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l13 = this.subscriptionPlanId;
        int iHashCode16 = (iHashCode15 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.subscriptionPremiumGuildPlanId;
        int iHashCode17 = (iHashCode16 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.subscriptionPremiumGuildQuantity;
        int iHashCode18 = (iHashCode17 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.subscriptionPremiumPlanId;
        int iHashCode19 = (iHashCode18 + (l16 != null ? l16.hashCode() : 0)) * 31;
        Long l17 = this.subscriptionType;
        return iHashCode19 + (l17 != null ? l17.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackExternalPaymentSucceeded(amount=");
        sbU.append(this.amount);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", currency=");
        sbU.append(this.currency);
        sbU.append(", amountRefunded=");
        sbU.append(this.amountRefunded);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", paymentId=");
        sbU.append(this.paymentId);
        sbU.append(", paymentType=");
        sbU.append(this.paymentType);
        sbU.append(", price=");
        sbU.append(this.price);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", skuSubscriptionPlanId=");
        sbU.append(this.skuSubscriptionPlanId);
        sbU.append(", skuType=");
        sbU.append(this.skuType);
        sbU.append(", subscriptionCurrentPeriodEnd=");
        sbU.append(this.subscriptionCurrentPeriodEnd);
        sbU.append(", subscriptionCurrentPeriodStart=");
        sbU.append(this.subscriptionCurrentPeriodStart);
        sbU.append(", subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", subscriptionPaymentGatewayPlanId=");
        sbU.append(this.subscriptionPaymentGatewayPlanId);
        sbU.append(", subscriptionPlanId=");
        sbU.append(this.subscriptionPlanId);
        sbU.append(", subscriptionPremiumGuildPlanId=");
        sbU.append(this.subscriptionPremiumGuildPlanId);
        sbU.append(", subscriptionPremiumGuildQuantity=");
        sbU.append(this.subscriptionPremiumGuildQuantity);
        sbU.append(", subscriptionPremiumPlanId=");
        sbU.append(this.subscriptionPremiumPlanId);
        sbU.append(", subscriptionType=");
        return a.G(sbU, this.subscriptionType, ")");
    }
}
