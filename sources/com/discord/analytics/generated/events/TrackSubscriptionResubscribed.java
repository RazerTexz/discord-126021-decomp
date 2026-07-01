package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackSubscriptionResubscribed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionResubscribed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long subscriptionId = null;
    private final Long subscriptionType = null;
    private final CharSequence paymentGatewayPlanId = null;
    private final Long planId = null;
    private final Long paymentGateway = null;
    private final Long createdAt = null;
    private final Long currentPeriodStart = null;
    private final Long currentPeriodEnd = null;
    private final Long trialId = null;
    private final Long trialEndsAt = null;
    private final transient String analyticsSchemaTypeName = "subscription_resubscribed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionResubscribed)) {
            return false;
        }
        TrackSubscriptionResubscribed trackSubscriptionResubscribed = (TrackSubscriptionResubscribed) other;
        return m.areEqual(this.subscriptionId, trackSubscriptionResubscribed.subscriptionId) && m.areEqual(this.subscriptionType, trackSubscriptionResubscribed.subscriptionType) && m.areEqual(this.paymentGatewayPlanId, trackSubscriptionResubscribed.paymentGatewayPlanId) && m.areEqual(this.planId, trackSubscriptionResubscribed.planId) && m.areEqual(this.paymentGateway, trackSubscriptionResubscribed.paymentGateway) && m.areEqual(this.createdAt, trackSubscriptionResubscribed.createdAt) && m.areEqual(this.currentPeriodStart, trackSubscriptionResubscribed.currentPeriodStart) && m.areEqual(this.currentPeriodEnd, trackSubscriptionResubscribed.currentPeriodEnd) && m.areEqual(this.trialId, trackSubscriptionResubscribed.trialId) && m.areEqual(this.trialEndsAt, trackSubscriptionResubscribed.trialEndsAt);
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
        Long l8 = this.trialId;
        int iHashCode9 = (iHashCode8 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.trialEndsAt;
        return iHashCode9 + (l9 != null ? l9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackSubscriptionResubscribed(subscriptionId=");
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
        sbU.append(", trialId=");
        sbU.append(this.trialId);
        sbU.append(", trialEndsAt=");
        return a.G(sbU, this.trialEndsAt, ")");
    }
}
