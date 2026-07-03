package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackSubscriptionAccountHoldStarted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionAccountHoldStarted implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long subscriptionId = null;
    private final Long subscriptionType = null;
    private final CharSequence paymentGatewayPlanId = null;
    private final Long planId = null;
    private final Long paymentGateway = null;
    private final Long createdAt = null;
    private final Long currentPeriodStart = null;
    private final Long currentPeriodEnd = null;
    private final transient String analyticsSchemaTypeName = "subscription_account_hold_started";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionAccountHoldStarted)) {
            return false;
        }
        TrackSubscriptionAccountHoldStarted trackSubscriptionAccountHoldStarted = (TrackSubscriptionAccountHoldStarted) other;
        return C12238m.areEqual(this.subscriptionId, trackSubscriptionAccountHoldStarted.subscriptionId) && C12238m.areEqual(this.subscriptionType, trackSubscriptionAccountHoldStarted.subscriptionType) && C12238m.areEqual(this.paymentGatewayPlanId, trackSubscriptionAccountHoldStarted.paymentGatewayPlanId) && C12238m.areEqual(this.planId, trackSubscriptionAccountHoldStarted.planId) && C12238m.areEqual(this.paymentGateway, trackSubscriptionAccountHoldStarted.paymentGateway) && C12238m.areEqual(this.createdAt, trackSubscriptionAccountHoldStarted.createdAt) && C12238m.areEqual(this.currentPeriodStart, trackSubscriptionAccountHoldStarted.currentPeriodStart) && C12238m.areEqual(this.currentPeriodEnd, trackSubscriptionAccountHoldStarted.currentPeriodEnd);
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
        StringBuilder sbM833U = C1643a.m833U("TrackSubscriptionAccountHoldStarted(subscriptionId=");
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
        return C1643a.m819G(sbM833U, this.currentPeriodEnd, ")");
    }
}
