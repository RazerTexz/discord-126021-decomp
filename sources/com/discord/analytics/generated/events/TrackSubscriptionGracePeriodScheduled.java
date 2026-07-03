package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackSubscriptionGracePeriodScheduled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionGracePeriodScheduled implements AnalyticsSchema, TrackBaseReceiver, TrackSubscriptionMetadataReceiver {
    private TrackBase trackBase;
    private TrackSubscriptionMetadata trackSubscriptionMetadata;
    private final Long subscriptionId = null;
    private final Long paymentGateway = null;
    private final Long currentPeriodStart = null;
    private final Long currentPeriodEnd = null;
    private final Long invoiceId = null;
    private final Long invoiceDueAt = null;
    private final Long gracePeriodDays = null;
    private final transient String analyticsSchemaTypeName = "subscription_grace_period_scheduled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionGracePeriodScheduled)) {
            return false;
        }
        TrackSubscriptionGracePeriodScheduled trackSubscriptionGracePeriodScheduled = (TrackSubscriptionGracePeriodScheduled) other;
        return C12238m.areEqual(this.subscriptionId, trackSubscriptionGracePeriodScheduled.subscriptionId) && C12238m.areEqual(this.paymentGateway, trackSubscriptionGracePeriodScheduled.paymentGateway) && C12238m.areEqual(this.currentPeriodStart, trackSubscriptionGracePeriodScheduled.currentPeriodStart) && C12238m.areEqual(this.currentPeriodEnd, trackSubscriptionGracePeriodScheduled.currentPeriodEnd) && C12238m.areEqual(this.invoiceId, trackSubscriptionGracePeriodScheduled.invoiceId) && C12238m.areEqual(this.invoiceDueAt, trackSubscriptionGracePeriodScheduled.invoiceDueAt) && C12238m.areEqual(this.gracePeriodDays, trackSubscriptionGracePeriodScheduled.gracePeriodDays);
    }

    public int hashCode() {
        Long l = this.subscriptionId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.paymentGateway;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.currentPeriodStart;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.currentPeriodEnd;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.invoiceId;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.invoiceDueAt;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.gracePeriodDays;
        return iHashCode6 + (l7 != null ? l7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackSubscriptionGracePeriodScheduled(subscriptionId=");
        sbM833U.append(this.subscriptionId);
        sbM833U.append(", paymentGateway=");
        sbM833U.append(this.paymentGateway);
        sbM833U.append(", currentPeriodStart=");
        sbM833U.append(this.currentPeriodStart);
        sbM833U.append(", currentPeriodEnd=");
        sbM833U.append(this.currentPeriodEnd);
        sbM833U.append(", invoiceId=");
        sbM833U.append(this.invoiceId);
        sbM833U.append(", invoiceDueAt=");
        sbM833U.append(this.invoiceDueAt);
        sbM833U.append(", gracePeriodDays=");
        return C1643a.m819G(sbM833U, this.gracePeriodDays, ")");
    }
}
