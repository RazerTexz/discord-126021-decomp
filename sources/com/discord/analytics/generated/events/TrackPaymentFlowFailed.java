package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackPaymentMetadata;
import com.discord.analytics.generated.traits.TrackPaymentMetadataReceiver;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadataReceiver;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadataReceiver;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackPaymentFlowFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPaymentFlowFailed implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackStoreSkuMetadataReceiver, TrackSubscriptionMetadataReceiver, TrackPaymentMetadataReceiver, TrackSourceMetadataReceiver {
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
        return m.areEqual(this.loadId, trackPaymentFlowFailed.loadId) && m.areEqual(this.durationMs, trackPaymentFlowFailed.durationMs) && m.areEqual(this.paymentErrorCode, trackPaymentFlowFailed.paymentErrorCode) && m.areEqual(this.paymentSourceId, trackPaymentFlowFailed.paymentSourceId) && m.areEqual(this.paymentGateway, trackPaymentFlowFailed.paymentGateway) && m.areEqual(this.eligibleForTrial, trackPaymentFlowFailed.eligibleForTrial);
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
        StringBuilder sbU = a.U("TrackPaymentFlowFailed(loadId=");
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
        return a.D(sbU, this.eligibleForTrial, ")");
    }
}
