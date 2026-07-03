package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.subscriptionId, trackSubscriptionResubscribed.subscriptionId) && C12238m.areEqual(this.subscriptionType, trackSubscriptionResubscribed.subscriptionType) && C12238m.areEqual(this.paymentGatewayPlanId, trackSubscriptionResubscribed.paymentGatewayPlanId) && C12238m.areEqual(this.planId, trackSubscriptionResubscribed.planId) && C12238m.areEqual(this.paymentGateway, trackSubscriptionResubscribed.paymentGateway) && C12238m.areEqual(this.createdAt, trackSubscriptionResubscribed.createdAt) && C12238m.areEqual(this.currentPeriodStart, trackSubscriptionResubscribed.currentPeriodStart) && C12238m.areEqual(this.currentPeriodEnd, trackSubscriptionResubscribed.currentPeriodEnd) && C12238m.areEqual(this.trialId, trackSubscriptionResubscribed.trialId) && C12238m.areEqual(this.trialEndsAt, trackSubscriptionResubscribed.trialEndsAt);
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
        StringBuilder sbM833U = C1643a.m833U("TrackSubscriptionResubscribed(subscriptionId=");
        sbM833U.append(this.subscriptionId);
        sbM833U.append(", subscriptionType=");
        sbM833U.append(this.subscriptionType);
        sbM833U.append(", paymentGatewayPlanId=");
        sbM833U.append(this.paymentGatewayPlanId);
        sbM833U.append(", planId=");
        sbM833U.append(this.planId);
        sbM833U.append(", paymentGateway=");
        sbM833U.append(this.paymentGateway);
        sbM833U.append(", createdAt=");
        sbM833U.append(this.createdAt);
        sbM833U.append(", currentPeriodStart=");
        sbM833U.append(this.currentPeriodStart);
        sbM833U.append(", currentPeriodEnd=");
        sbM833U.append(this.currentPeriodEnd);
        sbM833U.append(", trialId=");
        sbM833U.append(this.trialId);
        sbM833U.append(", trialEndsAt=");
        return C1643a.m819G(sbM833U, this.trialEndsAt, ")");
    }
}
