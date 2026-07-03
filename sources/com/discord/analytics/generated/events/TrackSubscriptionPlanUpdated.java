package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.subscriptionId, trackSubscriptionPlanUpdated.subscriptionId) && C12238m.areEqual(this.subscriptionType, trackSubscriptionPlanUpdated.subscriptionType) && C12238m.areEqual(this.paymentGatewayPlanId, trackSubscriptionPlanUpdated.paymentGatewayPlanId) && C12238m.areEqual(this.planId, trackSubscriptionPlanUpdated.planId) && C12238m.areEqual(this.paymentGateway, trackSubscriptionPlanUpdated.paymentGateway) && C12238m.areEqual(this.createdAt, trackSubscriptionPlanUpdated.createdAt) && C12238m.areEqual(this.currentPeriodStart, trackSubscriptionPlanUpdated.currentPeriodStart) && C12238m.areEqual(this.currentPeriodEnd, trackSubscriptionPlanUpdated.currentPeriodEnd) && C12238m.areEqual(this.previousSubscriptionId, trackSubscriptionPlanUpdated.previousSubscriptionId) && C12238m.areEqual(this.previousSubscriptionType, trackSubscriptionPlanUpdated.previousSubscriptionType) && C12238m.areEqual(this.previousPaymentGatewayPlanId, trackSubscriptionPlanUpdated.previousPaymentGatewayPlanId) && C12238m.areEqual(this.previousPlanId, trackSubscriptionPlanUpdated.previousPlanId) && C12238m.areEqual(this.previousCurrentPeriodStart, trackSubscriptionPlanUpdated.previousCurrentPeriodStart) && C12238m.areEqual(this.previousCurrentPeriodEnd, trackSubscriptionPlanUpdated.previousCurrentPeriodEnd);
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
        StringBuilder sbM833U = C1643a.m833U("TrackSubscriptionPlanUpdated(subscriptionId=");
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
        sbM833U.append(", previousSubscriptionId=");
        sbM833U.append(this.previousSubscriptionId);
        sbM833U.append(", previousSubscriptionType=");
        sbM833U.append(this.previousSubscriptionType);
        sbM833U.append(", previousPaymentGatewayPlanId=");
        sbM833U.append(this.previousPaymentGatewayPlanId);
        sbM833U.append(", previousPlanId=");
        sbM833U.append(this.previousPlanId);
        sbM833U.append(", previousCurrentPeriodStart=");
        sbM833U.append(this.previousCurrentPeriodStart);
        sbM833U.append(", previousCurrentPeriodEnd=");
        return C1643a.m819G(sbM833U, this.previousCurrentPeriodEnd, ")");
    }
}
