package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSubscriptionRemoved.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionRemoved implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long subscriptionId = null;
    private final Long subscriptionType = null;
    private final CharSequence paymentGatewayPlanId = null;
    private final Long planId = null;
    private final Long paymentGateway = null;
    private final CharSequence removalType = null;
    private final transient String analyticsSchemaTypeName = "subscription_removed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionRemoved)) {
            return false;
        }
        TrackSubscriptionRemoved trackSubscriptionRemoved = (TrackSubscriptionRemoved) other;
        return Intrinsics3.areEqual(this.subscriptionId, trackSubscriptionRemoved.subscriptionId) && Intrinsics3.areEqual(this.subscriptionType, trackSubscriptionRemoved.subscriptionType) && Intrinsics3.areEqual(this.paymentGatewayPlanId, trackSubscriptionRemoved.paymentGatewayPlanId) && Intrinsics3.areEqual(this.planId, trackSubscriptionRemoved.planId) && Intrinsics3.areEqual(this.paymentGateway, trackSubscriptionRemoved.paymentGateway) && Intrinsics3.areEqual(this.removalType, trackSubscriptionRemoved.removalType);
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
        CharSequence charSequence2 = this.removalType;
        return iHashCode5 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSubscriptionRemoved(subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", subscriptionType=");
        sbU.append(this.subscriptionType);
        sbU.append(", paymentGatewayPlanId=");
        sbU.append(this.paymentGatewayPlanId);
        sbU.append(", planId=");
        sbU.append(this.planId);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", removalType=");
        return outline.E(sbU, this.removalType, ")");
    }
}
