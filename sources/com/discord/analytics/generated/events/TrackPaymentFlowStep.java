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

/* JADX INFO: compiled from: TrackPaymentFlowStep.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPaymentFlowStep implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackStoreSkuMetadata2, TrackSubscriptionMetadata2, TrackPaymentMetadata2, TrackSourceMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackPaymentMetadata trackPaymentMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private TrackSubscriptionMetadata trackSubscriptionMetadata;
    private final CharSequence toStep = null;
    private final CharSequence fromStep = null;
    private final CharSequence loadId = null;
    private final Long stepDurationMs = null;
    private final Long flowDurationMs = null;
    private final Boolean eligibleForTrial = null;
    private final Long guildId = null;
    private final transient String analyticsSchemaTypeName = "payment_flow_step";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPaymentFlowStep)) {
            return false;
        }
        TrackPaymentFlowStep trackPaymentFlowStep = (TrackPaymentFlowStep) other;
        return Intrinsics3.areEqual(this.toStep, trackPaymentFlowStep.toStep) && Intrinsics3.areEqual(this.fromStep, trackPaymentFlowStep.fromStep) && Intrinsics3.areEqual(this.loadId, trackPaymentFlowStep.loadId) && Intrinsics3.areEqual(this.stepDurationMs, trackPaymentFlowStep.stepDurationMs) && Intrinsics3.areEqual(this.flowDurationMs, trackPaymentFlowStep.flowDurationMs) && Intrinsics3.areEqual(this.eligibleForTrial, trackPaymentFlowStep.eligibleForTrial) && Intrinsics3.areEqual(this.guildId, trackPaymentFlowStep.guildId);
    }

    public int hashCode() {
        CharSequence charSequence = this.toStep;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.fromStep;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.loadId;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.stepDurationMs;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.flowDurationMs;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.eligibleForTrial;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        return iHashCode6 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPaymentFlowStep(toStep=");
        sbU.append(this.toStep);
        sbU.append(", fromStep=");
        sbU.append(this.fromStep);
        sbU.append(", loadId=");
        sbU.append(this.loadId);
        sbU.append(", stepDurationMs=");
        sbU.append(this.stepDurationMs);
        sbU.append(", flowDurationMs=");
        sbU.append(this.flowDurationMs);
        sbU.append(", eligibleForTrial=");
        sbU.append(this.eligibleForTrial);
        sbU.append(", guildId=");
        return outline.G(sbU, this.guildId, ")");
    }
}
