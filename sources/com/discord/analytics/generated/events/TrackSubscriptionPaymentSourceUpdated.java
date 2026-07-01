package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackSubscriptionPaymentSourceUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionPaymentSourceUpdated implements AnalyticsSchema, TrackBaseReceiver {
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
        return m.areEqual(this.subscriptionId, trackSubscriptionPaymentSourceUpdated.subscriptionId) && m.areEqual(this.subscriptionType, trackSubscriptionPaymentSourceUpdated.subscriptionType) && m.areEqual(this.paymentGatewayPlanId, trackSubscriptionPaymentSourceUpdated.paymentGatewayPlanId) && m.areEqual(this.planId, trackSubscriptionPaymentSourceUpdated.planId) && m.areEqual(this.paymentGateway, trackSubscriptionPaymentSourceUpdated.paymentGateway) && m.areEqual(this.previousPaymentSourceId, trackSubscriptionPaymentSourceUpdated.previousPaymentSourceId) && m.areEqual(this.previousPaymentSourceGateway, trackSubscriptionPaymentSourceUpdated.previousPaymentSourceGateway) && m.areEqual(this.previousPaymentSourceCountry, trackSubscriptionPaymentSourceUpdated.previousPaymentSourceCountry) && m.areEqual(this.paymentSourceId, trackSubscriptionPaymentSourceUpdated.paymentSourceId) && m.areEqual(this.paymentSourceGateway, trackSubscriptionPaymentSourceUpdated.paymentSourceGateway) && m.areEqual(this.paymentSourceCountry, trackSubscriptionPaymentSourceUpdated.paymentSourceCountry) && m.areEqual(this.currentPeriodStart, trackSubscriptionPaymentSourceUpdated.currentPeriodStart) && m.areEqual(this.currentPeriodEnd, trackSubscriptionPaymentSourceUpdated.currentPeriodEnd);
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
        StringBuilder sbU = a.U("TrackSubscriptionPaymentSourceUpdated(subscriptionId=");
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
        return a.G(sbU, this.currentPeriodEnd, ")");
    }
}
