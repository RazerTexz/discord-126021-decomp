package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSubscriptionCanceled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionCanceled implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long subscriptionId = null;
    private final Long subscriptionType = null;
    private final Long subscriptionLength = null;
    private final CharSequence paymentGatewayPlanId = null;
    private final Long planId = null;
    private final Long paymentGateway = null;
    private final CharSequence cancellationType = null;
    private final Long createdAt = null;
    private final Long currentPeriodStart = null;
    private final Long currentPeriodEnd = null;
    private final transient String analyticsSchemaTypeName = "subscription_canceled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionCanceled)) {
            return false;
        }
        TrackSubscriptionCanceled trackSubscriptionCanceled = (TrackSubscriptionCanceled) other;
        return Intrinsics3.areEqual(this.subscriptionId, trackSubscriptionCanceled.subscriptionId) && Intrinsics3.areEqual(this.subscriptionType, trackSubscriptionCanceled.subscriptionType) && Intrinsics3.areEqual(this.subscriptionLength, trackSubscriptionCanceled.subscriptionLength) && Intrinsics3.areEqual(this.paymentGatewayPlanId, trackSubscriptionCanceled.paymentGatewayPlanId) && Intrinsics3.areEqual(this.planId, trackSubscriptionCanceled.planId) && Intrinsics3.areEqual(this.paymentGateway, trackSubscriptionCanceled.paymentGateway) && Intrinsics3.areEqual(this.cancellationType, trackSubscriptionCanceled.cancellationType) && Intrinsics3.areEqual(this.createdAt, trackSubscriptionCanceled.createdAt) && Intrinsics3.areEqual(this.currentPeriodStart, trackSubscriptionCanceled.currentPeriodStart) && Intrinsics3.areEqual(this.currentPeriodEnd, trackSubscriptionCanceled.currentPeriodEnd);
    }

    public int hashCode() {
        Long l = this.subscriptionId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.subscriptionType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.subscriptionLength;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.paymentGatewayPlanId;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l4 = this.planId;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.paymentGateway;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.cancellationType;
        int iHashCode7 = (iHashCode6 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l6 = this.createdAt;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.currentPeriodStart;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.currentPeriodEnd;
        return iHashCode9 + (l8 != null ? l8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSubscriptionCanceled(subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", subscriptionType=");
        sbU.append(this.subscriptionType);
        sbU.append(", subscriptionLength=");
        sbU.append(this.subscriptionLength);
        sbU.append(", paymentGatewayPlanId=");
        sbU.append(this.paymentGatewayPlanId);
        sbU.append(", planId=");
        sbU.append(this.planId);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", cancellationType=");
        sbU.append(this.cancellationType);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", currentPeriodStart=");
        sbU.append(this.currentPeriodStart);
        sbU.append(", currentPeriodEnd=");
        return outline.G(sbU, this.currentPeriodEnd, ")");
    }
}
