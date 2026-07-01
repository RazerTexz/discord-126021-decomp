package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackPaymentMetadata;
import com.discord.analytics.generated.traits.TrackPaymentMetadata2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackPaymentFlowFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPaymentFlowFailed implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackStoreSkuMetadata2, TrackSubscriptionMetadata2, TrackPaymentMetadata2, TrackSourceMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackPaymentMetadata trackPaymentMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private TrackSubscriptionMetadata trackSubscriptionMetadata;
    private final CharSequence loadId = null;
    private final Long durationMs = null;
    private final Long paymentErrorCode = null;
    private final Long paymentSourceId = null;
    private final Long paymentGateway = null;
    private final Boolean eligibleForTrial = null;
    private final transient String analyticsSchemaTypeName = "payment_flow_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPaymentFlowFailed)) {
            return false;
        }
        TrackPaymentFlowFailed trackPaymentFlowFailed = (TrackPaymentFlowFailed) other;
        return Intrinsics3.areEqual(this.loadId, trackPaymentFlowFailed.loadId) && Intrinsics3.areEqual(this.durationMs, trackPaymentFlowFailed.durationMs) && Intrinsics3.areEqual(this.paymentErrorCode, trackPaymentFlowFailed.paymentErrorCode) && Intrinsics3.areEqual(this.paymentSourceId, trackPaymentFlowFailed.paymentSourceId) && Intrinsics3.areEqual(this.paymentGateway, trackPaymentFlowFailed.paymentGateway) && Intrinsics3.areEqual(this.eligibleForTrial, trackPaymentFlowFailed.eligibleForTrial);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.durationMs;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.paymentErrorCode;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.paymentSourceId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.paymentGateway;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool = this.eligibleForTrial;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPaymentFlowFailed(loadId=");
        sbU.append(this.loadId);
        sbU.append(", durationMs=");
        sbU.append(this.durationMs);
        sbU.append(", paymentErrorCode=");
        sbU.append(this.paymentErrorCode);
        sbU.append(", paymentSourceId=");
        sbU.append(this.paymentSourceId);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", eligibleForTrial=");
        return outline.D(sbU, this.eligibleForTrial, ")");
    }
}
