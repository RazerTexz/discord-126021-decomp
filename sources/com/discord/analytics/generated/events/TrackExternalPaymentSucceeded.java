package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.amount, trackExternalPaymentSucceeded.amount) && C12238m.areEqual(this.createdAt, trackExternalPaymentSucceeded.createdAt) && C12238m.areEqual(this.currency, trackExternalPaymentSucceeded.currency) && C12238m.areEqual(this.amountRefunded, trackExternalPaymentSucceeded.amountRefunded) && C12238m.areEqual(this.paymentGateway, trackExternalPaymentSucceeded.paymentGateway) && C12238m.areEqual(this.paymentId, trackExternalPaymentSucceeded.paymentId) && C12238m.areEqual(this.paymentType, trackExternalPaymentSucceeded.paymentType) && C12238m.areEqual(this.price, trackExternalPaymentSucceeded.price) && C12238m.areEqual(this.skuId, trackExternalPaymentSucceeded.skuId) && C12238m.areEqual(this.skuSubscriptionPlanId, trackExternalPaymentSucceeded.skuSubscriptionPlanId) && C12238m.areEqual(this.skuType, trackExternalPaymentSucceeded.skuType) && C12238m.areEqual(this.subscriptionCurrentPeriodEnd, trackExternalPaymentSucceeded.subscriptionCurrentPeriodEnd) && C12238m.areEqual(this.subscriptionCurrentPeriodStart, trackExternalPaymentSucceeded.subscriptionCurrentPeriodStart) && C12238m.areEqual(this.subscriptionId, trackExternalPaymentSucceeded.subscriptionId) && C12238m.areEqual(this.subscriptionPaymentGatewayPlanId, trackExternalPaymentSucceeded.subscriptionPaymentGatewayPlanId) && C12238m.areEqual(this.subscriptionPlanId, trackExternalPaymentSucceeded.subscriptionPlanId) && C12238m.areEqual(this.subscriptionPremiumGuildPlanId, trackExternalPaymentSucceeded.subscriptionPremiumGuildPlanId) && C12238m.areEqual(this.subscriptionPremiumGuildQuantity, trackExternalPaymentSucceeded.subscriptionPremiumGuildQuantity) && C12238m.areEqual(this.subscriptionPremiumPlanId, trackExternalPaymentSucceeded.subscriptionPremiumPlanId) && C12238m.areEqual(this.subscriptionType, trackExternalPaymentSucceeded.subscriptionType);
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
        StringBuilder sbM833U = C1643a.m833U("TrackExternalPaymentSucceeded(amount=");
        sbM833U.append(this.amount);
        sbM833U.append(", createdAt=");
        sbM833U.append(this.createdAt);
        sbM833U.append(", currency=");
        sbM833U.append(this.currency);
        sbM833U.append(", amountRefunded=");
        sbM833U.append(this.amountRefunded);
        sbM833U.append(", paymentGateway=");
        sbM833U.append(this.paymentGateway);
        sbM833U.append(", paymentId=");
        sbM833U.append(this.paymentId);
        sbM833U.append(", paymentType=");
        sbM833U.append(this.paymentType);
        sbM833U.append(", price=");
        sbM833U.append(this.price);
        sbM833U.append(", skuId=");
        sbM833U.append(this.skuId);
        sbM833U.append(", skuSubscriptionPlanId=");
        sbM833U.append(this.skuSubscriptionPlanId);
        sbM833U.append(", skuType=");
        sbM833U.append(this.skuType);
        sbM833U.append(", subscriptionCurrentPeriodEnd=");
        sbM833U.append(this.subscriptionCurrentPeriodEnd);
        sbM833U.append(", subscriptionCurrentPeriodStart=");
        sbM833U.append(this.subscriptionCurrentPeriodStart);
        sbM833U.append(", subscriptionId=");
        sbM833U.append(this.subscriptionId);
        sbM833U.append(", subscriptionPaymentGatewayPlanId=");
        sbM833U.append(this.subscriptionPaymentGatewayPlanId);
        sbM833U.append(", subscriptionPlanId=");
        sbM833U.append(this.subscriptionPlanId);
        sbM833U.append(", subscriptionPremiumGuildPlanId=");
        sbM833U.append(this.subscriptionPremiumGuildPlanId);
        sbM833U.append(", subscriptionPremiumGuildQuantity=");
        sbM833U.append(this.subscriptionPremiumGuildQuantity);
        sbM833U.append(", subscriptionPremiumPlanId=");
        sbM833U.append(this.subscriptionPremiumPlanId);
        sbM833U.append(", subscriptionType=");
        return C1643a.m819G(sbM833U, this.subscriptionType, ")");
    }
}
