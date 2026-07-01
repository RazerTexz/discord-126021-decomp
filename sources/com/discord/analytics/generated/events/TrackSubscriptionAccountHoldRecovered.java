package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSubscriptionAccountHoldRecovered.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionAccountHoldRecovered implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long subscriptionId = null;
    private final Long subscriptionType = null;
    private final CharSequence paymentGatewayPlanId = null;
    private final Long planId = null;
    private final Long paymentGateway = null;
    private final Long createdAt = null;
    private final Long currentPeriodStart = null;
    private final Long currentPeriodEnd = null;
    private final transient String analyticsSchemaTypeName = "subscription_account_hold_recovered";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionAccountHoldRecovered)) {
            return false;
        }
        TrackSubscriptionAccountHoldRecovered trackSubscriptionAccountHoldRecovered = (TrackSubscriptionAccountHoldRecovered) other;
        return Intrinsics3.areEqual(this.subscriptionId, trackSubscriptionAccountHoldRecovered.subscriptionId) && Intrinsics3.areEqual(this.subscriptionType, trackSubscriptionAccountHoldRecovered.subscriptionType) && Intrinsics3.areEqual(this.paymentGatewayPlanId, trackSubscriptionAccountHoldRecovered.paymentGatewayPlanId) && Intrinsics3.areEqual(this.planId, trackSubscriptionAccountHoldRecovered.planId) && Intrinsics3.areEqual(this.paymentGateway, trackSubscriptionAccountHoldRecovered.paymentGateway) && Intrinsics3.areEqual(this.createdAt, trackSubscriptionAccountHoldRecovered.createdAt) && Intrinsics3.areEqual(this.currentPeriodStart, trackSubscriptionAccountHoldRecovered.currentPeriodStart) && Intrinsics3.areEqual(this.currentPeriodEnd, trackSubscriptionAccountHoldRecovered.currentPeriodEnd);
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
        return iHashCode7 + (l7 != null ? l7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSubscriptionAccountHoldRecovered(subscriptionId=");
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
        return outline.G(sbU, this.currentPeriodEnd, ")");
    }
}
