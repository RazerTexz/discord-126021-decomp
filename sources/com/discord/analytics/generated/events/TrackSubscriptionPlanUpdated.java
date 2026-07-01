package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSubscriptionPlanUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionPlanUpdated implements AnalyticsSchema, TrackBase2 {
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
        return Intrinsics3.areEqual(this.subscriptionId, trackSubscriptionPlanUpdated.subscriptionId) && Intrinsics3.areEqual(this.subscriptionType, trackSubscriptionPlanUpdated.subscriptionType) && Intrinsics3.areEqual(this.paymentGatewayPlanId, trackSubscriptionPlanUpdated.paymentGatewayPlanId) && Intrinsics3.areEqual(this.planId, trackSubscriptionPlanUpdated.planId) && Intrinsics3.areEqual(this.paymentGateway, trackSubscriptionPlanUpdated.paymentGateway) && Intrinsics3.areEqual(this.createdAt, trackSubscriptionPlanUpdated.createdAt) && Intrinsics3.areEqual(this.currentPeriodStart, trackSubscriptionPlanUpdated.currentPeriodStart) && Intrinsics3.areEqual(this.currentPeriodEnd, trackSubscriptionPlanUpdated.currentPeriodEnd) && Intrinsics3.areEqual(this.previousSubscriptionId, trackSubscriptionPlanUpdated.previousSubscriptionId) && Intrinsics3.areEqual(this.previousSubscriptionType, trackSubscriptionPlanUpdated.previousSubscriptionType) && Intrinsics3.areEqual(this.previousPaymentGatewayPlanId, trackSubscriptionPlanUpdated.previousPaymentGatewayPlanId) && Intrinsics3.areEqual(this.previousPlanId, trackSubscriptionPlanUpdated.previousPlanId) && Intrinsics3.areEqual(this.previousCurrentPeriodStart, trackSubscriptionPlanUpdated.previousCurrentPeriodStart) && Intrinsics3.areEqual(this.previousCurrentPeriodEnd, trackSubscriptionPlanUpdated.previousCurrentPeriodEnd);
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
        StringBuilder sbU = outline.U("TrackSubscriptionPlanUpdated(subscriptionId=");
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
        return outline.G(sbU, this.previousCurrentPeriodEnd, ")");
    }
}
