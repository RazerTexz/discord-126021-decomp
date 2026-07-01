package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackSubscriptionPlanUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionPlanUpdated implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long subscriptionId = null;
    private final Long subscriptionType = null;
    private final CharSequence paymentGatewayPlanId = null;
    private final Long planId = null;
    private final Long paymentGateway = null;
    private final Long createdAt = null;
    private final Long currentPeriodStart = null;
    private final Long currentPeriodEnd = null;
    private final Long previousSubscriptionId = null;
    private final Long previousSubscriptionType = null;
    private final CharSequence previousPaymentGatewayPlanId = null;
    private final Long previousPlanId = null;
    private final Long previousCurrentPeriodStart = null;
    private final Long previousCurrentPeriodEnd = null;
    private final transient String analyticsSchemaTypeName = "subscription_plan_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionPlanUpdated)) {
            return false;
        }
        TrackSubscriptionPlanUpdated trackSubscriptionPlanUpdated = (TrackSubscriptionPlanUpdated) other;
        return m.areEqual(this.subscriptionId, trackSubscriptionPlanUpdated.subscriptionId) && m.areEqual(this.subscriptionType, trackSubscriptionPlanUpdated.subscriptionType) && m.areEqual(this.paymentGatewayPlanId, trackSubscriptionPlanUpdated.paymentGatewayPlanId) && m.areEqual(this.planId, trackSubscriptionPlanUpdated.planId) && m.areEqual(this.paymentGateway, trackSubscriptionPlanUpdated.paymentGateway) && m.areEqual(this.createdAt, trackSubscriptionPlanUpdated.createdAt) && m.areEqual(this.currentPeriodStart, trackSubscriptionPlanUpdated.currentPeriodStart) && m.areEqual(this.currentPeriodEnd, trackSubscriptionPlanUpdated.currentPeriodEnd) && m.areEqual(this.previousSubscriptionId, trackSubscriptionPlanUpdated.previousSubscriptionId) && m.areEqual(this.previousSubscriptionType, trackSubscriptionPlanUpdated.previousSubscriptionType) && m.areEqual(this.previousPaymentGatewayPlanId, trackSubscriptionPlanUpdated.previousPaymentGatewayPlanId) && m.areEqual(this.previousPlanId, trackSubscriptionPlanUpdated.previousPlanId) && m.areEqual(this.previousCurrentPeriodStart, trackSubscriptionPlanUpdated.previousCurrentPeriodStart) && m.areEqual(this.previousCurrentPeriodEnd, trackSubscriptionPlanUpdated.previousCurrentPeriodEnd);
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
        Long l5 = this.createdAt;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.currentPeriodStart;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.currentPeriodEnd;
        int iHashCode8 = (iHashCode7 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.previousSubscriptionId;
        int iHashCode9 = (iHashCode8 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.previousSubscriptionType;
        int iHashCode10 = (iHashCode9 + (l9 != null ? l9.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.previousPaymentGatewayPlanId;
        int iHashCode11 = (iHashCode10 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l10 = this.previousPlanId;
        int iHashCode12 = (iHashCode11 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.previousCurrentPeriodStart;
        int iHashCode13 = (iHashCode12 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.previousCurrentPeriodEnd;
        return iHashCode13 + (l12 != null ? l12.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackSubscriptionPlanUpdated(subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", subscriptionType=");
        sbU.append(this.subscriptionType);
        sbU.append(", paymentGatewayPlanId=");
        sbU.append(this.paymentGatewayPlanId);
        sbU.append(", planId=");
        sbU.append(this.planId);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", currentPeriodStart=");
        sbU.append(this.currentPeriodStart);
        sbU.append(", currentPeriodEnd=");
        sbU.append(this.currentPeriodEnd);
        sbU.append(", previousSubscriptionId=");
        sbU.append(this.previousSubscriptionId);
        sbU.append(", previousSubscriptionType=");
        sbU.append(this.previousSubscriptionType);
        sbU.append(", previousPaymentGatewayPlanId=");
        sbU.append(this.previousPaymentGatewayPlanId);
        sbU.append(", previousPlanId=");
        sbU.append(this.previousPlanId);
        sbU.append(", previousCurrentPeriodStart=");
        sbU.append(this.previousCurrentPeriodStart);
        sbU.append(", previousCurrentPeriodEnd=");
        return a.G(sbU, this.previousCurrentPeriodEnd, ")");
    }
}
