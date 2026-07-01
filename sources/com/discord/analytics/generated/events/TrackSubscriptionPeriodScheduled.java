package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackEntitlementMetadata;
import com.discord.analytics.generated.traits.TrackEntitlementMetadata2;
import com.discord.analytics.generated.traits.TrackPaymentMetadata;
import com.discord.analytics.generated.traits.TrackPaymentMetadata2;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSubscriptionPeriodScheduled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionPeriodScheduled implements AnalyticsSchema, TrackBase2, TrackSubscriptionMetadata2, TrackEntitlementMetadata2, TrackPaymentMetadata2 {
    private TrackBase trackBase;
    private TrackEntitlementMetadata trackEntitlementMetadata;
    private TrackPaymentMetadata trackPaymentMetadata;
    private TrackSubscriptionMetadata trackSubscriptionMetadata;
    private final Long subscriptionId = null;
    private final Long paymentId = null;
    private final Long paymentGateway = null;
    private final Long skuId = null;
    private final Long scheduledStartTimestamp = null;
    private final Long scheduledEndTimestamp = null;
    private final CharSequence accessType = null;
    private final Boolean expectedToAutorenew = null;
    private final Boolean renewal = null;
    private final transient String analyticsSchemaTypeName = "subscription_period_scheduled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionPeriodScheduled)) {
            return false;
        }
        TrackSubscriptionPeriodScheduled trackSubscriptionPeriodScheduled = (TrackSubscriptionPeriodScheduled) other;
        return Intrinsics3.areEqual(this.subscriptionId, trackSubscriptionPeriodScheduled.subscriptionId) && Intrinsics3.areEqual(this.paymentId, trackSubscriptionPeriodScheduled.paymentId) && Intrinsics3.areEqual(this.paymentGateway, trackSubscriptionPeriodScheduled.paymentGateway) && Intrinsics3.areEqual(this.skuId, trackSubscriptionPeriodScheduled.skuId) && Intrinsics3.areEqual(this.scheduledStartTimestamp, trackSubscriptionPeriodScheduled.scheduledStartTimestamp) && Intrinsics3.areEqual(this.scheduledEndTimestamp, trackSubscriptionPeriodScheduled.scheduledEndTimestamp) && Intrinsics3.areEqual(this.accessType, trackSubscriptionPeriodScheduled.accessType) && Intrinsics3.areEqual(this.expectedToAutorenew, trackSubscriptionPeriodScheduled.expectedToAutorenew) && Intrinsics3.areEqual(this.renewal, trackSubscriptionPeriodScheduled.renewal);
    }

    public int hashCode() {
        Long l = this.subscriptionId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.paymentId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.paymentGateway;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.skuId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.scheduledStartTimestamp;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.scheduledEndTimestamp;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence = this.accessType;
        int iHashCode7 = (iHashCode6 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.expectedToAutorenew;
        int iHashCode8 = (iHashCode7 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.renewal;
        return iHashCode8 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSubscriptionPeriodScheduled(subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", paymentId=");
        sbU.append(this.paymentId);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", scheduledStartTimestamp=");
        sbU.append(this.scheduledStartTimestamp);
        sbU.append(", scheduledEndTimestamp=");
        sbU.append(this.scheduledEndTimestamp);
        sbU.append(", accessType=");
        sbU.append(this.accessType);
        sbU.append(", expectedToAutorenew=");
        sbU.append(this.expectedToAutorenew);
        sbU.append(", renewal=");
        return outline.D(sbU, this.renewal, ")");
    }
}
