package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackSubscriptionCanceled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionCanceled implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.subscriptionId, trackSubscriptionCanceled.subscriptionId) && C12238m.areEqual(this.subscriptionType, trackSubscriptionCanceled.subscriptionType) && C12238m.areEqual(this.subscriptionLength, trackSubscriptionCanceled.subscriptionLength) && C12238m.areEqual(this.paymentGatewayPlanId, trackSubscriptionCanceled.paymentGatewayPlanId) && C12238m.areEqual(this.planId, trackSubscriptionCanceled.planId) && C12238m.areEqual(this.paymentGateway, trackSubscriptionCanceled.paymentGateway) && C12238m.areEqual(this.cancellationType, trackSubscriptionCanceled.cancellationType) && C12238m.areEqual(this.createdAt, trackSubscriptionCanceled.createdAt) && C12238m.areEqual(this.currentPeriodStart, trackSubscriptionCanceled.currentPeriodStart) && C12238m.areEqual(this.currentPeriodEnd, trackSubscriptionCanceled.currentPeriodEnd);
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
        StringBuilder sbM833U = C1643a.m833U("TrackSubscriptionCanceled(subscriptionId=");
        sbM833U.append(this.subscriptionId);
        sbM833U.append(", subscriptionType=");
        sbM833U.append(this.subscriptionType);
        sbM833U.append(", subscriptionLength=");
        sbM833U.append(this.subscriptionLength);
        sbM833U.append(", paymentGatewayPlanId=");
        sbM833U.append(this.paymentGatewayPlanId);
        sbM833U.append(", planId=");
        sbM833U.append(this.planId);
        sbM833U.append(", paymentGateway=");
        sbM833U.append(this.paymentGateway);
        sbM833U.append(", cancellationType=");
        sbM833U.append(this.cancellationType);
        sbM833U.append(", createdAt=");
        sbM833U.append(this.createdAt);
        sbM833U.append(", currentPeriodStart=");
        sbM833U.append(this.currentPeriodStart);
        sbM833U.append(", currentPeriodEnd=");
        return C1643a.m819G(sbM833U, this.currentPeriodEnd, ")");
    }
}
