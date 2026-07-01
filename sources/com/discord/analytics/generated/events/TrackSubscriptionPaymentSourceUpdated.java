package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSubscriptionPaymentSourceUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionPaymentSourceUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long subscriptionId = null;
    private final Long subscriptionType = null;
    private final CharSequence paymentGatewayPlanId = null;
    private final Long planId = null;
    private final Long paymentGateway = null;
    private final Long previousPaymentSourceId = null;
    private final Long previousPaymentSourceGateway = null;
    private final CharSequence previousPaymentSourceCountry = null;
    private final Long paymentSourceId = null;
    private final Long paymentSourceGateway = null;
    private final CharSequence paymentSourceCountry = null;
    private final Long currentPeriodStart = null;
    private final Long currentPeriodEnd = null;
    private final transient String analyticsSchemaTypeName = "subscription_payment_source_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionPaymentSourceUpdated)) {
            return false;
        }
        TrackSubscriptionPaymentSourceUpdated trackSubscriptionPaymentSourceUpdated = (TrackSubscriptionPaymentSourceUpdated) other;
        return Intrinsics3.areEqual(this.subscriptionId, trackSubscriptionPaymentSourceUpdated.subscriptionId) && Intrinsics3.areEqual(this.subscriptionType, trackSubscriptionPaymentSourceUpdated.subscriptionType) && Intrinsics3.areEqual(this.paymentGatewayPlanId, trackSubscriptionPaymentSourceUpdated.paymentGatewayPlanId) && Intrinsics3.areEqual(this.planId, trackSubscriptionPaymentSourceUpdated.planId) && Intrinsics3.areEqual(this.paymentGateway, trackSubscriptionPaymentSourceUpdated.paymentGateway) && Intrinsics3.areEqual(this.previousPaymentSourceId, trackSubscriptionPaymentSourceUpdated.previousPaymentSourceId) && Intrinsics3.areEqual(this.previousPaymentSourceGateway, trackSubscriptionPaymentSourceUpdated.previousPaymentSourceGateway) && Intrinsics3.areEqual(this.previousPaymentSourceCountry, trackSubscriptionPaymentSourceUpdated.previousPaymentSourceCountry) && Intrinsics3.areEqual(this.paymentSourceId, trackSubscriptionPaymentSourceUpdated.paymentSourceId) && Intrinsics3.areEqual(this.paymentSourceGateway, trackSubscriptionPaymentSourceUpdated.paymentSourceGateway) && Intrinsics3.areEqual(this.paymentSourceCountry, trackSubscriptionPaymentSourceUpdated.paymentSourceCountry) && Intrinsics3.areEqual(this.currentPeriodStart, trackSubscriptionPaymentSourceUpdated.currentPeriodStart) && Intrinsics3.areEqual(this.currentPeriodEnd, trackSubscriptionPaymentSourceUpdated.currentPeriodEnd);
    }

    public int hashCode() {
        Long l = this.subscriptionId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.subscriptionType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.paymentGatewayPlanId;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l3 = this.planId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.paymentGateway;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.previousPaymentSourceId;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.previousPaymentSourceGateway;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.previousPaymentSourceCountry;
        int iHashCode8 = (iHashCode7 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l7 = this.paymentSourceId;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.paymentSourceGateway;
        int iHashCode10 = (iHashCode9 + (l8 != null ? l8.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.paymentSourceCountry;
        int iHashCode11 = (iHashCode10 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l9 = this.currentPeriodStart;
        int iHashCode12 = (iHashCode11 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.currentPeriodEnd;
        return iHashCode12 + (l10 != null ? l10.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSubscriptionPaymentSourceUpdated(subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", subscriptionType=");
        sbU.append(this.subscriptionType);
        sbU.append(", paymentGatewayPlanId=");
        sbU.append(this.paymentGatewayPlanId);
        sbU.append(", planId=");
        sbU.append(this.planId);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", previousPaymentSourceId=");
        sbU.append(this.previousPaymentSourceId);
        sbU.append(", previousPaymentSourceGateway=");
        sbU.append(this.previousPaymentSourceGateway);
        sbU.append(", previousPaymentSourceCountry=");
        sbU.append(this.previousPaymentSourceCountry);
        sbU.append(", paymentSourceId=");
        sbU.append(this.paymentSourceId);
        sbU.append(", paymentSourceGateway=");
        sbU.append(this.paymentSourceGateway);
        sbU.append(", paymentSourceCountry=");
        sbU.append(this.paymentSourceCountry);
        sbU.append(", currentPeriodStart=");
        sbU.append(this.currentPeriodStart);
        sbU.append(", currentPeriodEnd=");
        return outline.G(sbU, this.currentPeriodEnd, ")");
    }
}
