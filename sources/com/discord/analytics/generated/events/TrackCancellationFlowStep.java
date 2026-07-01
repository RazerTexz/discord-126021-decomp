package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackCancellationFlowStep.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCancellationFlowStep implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackSubscriptionMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackSubscriptionMetadata trackSubscriptionMetadata;
    private final CharSequence toStep = null;
    private final CharSequence fromStep = null;
    private final Long stepDurationMs = null;
    private final Long flowDurationMs = null;
    private final Long subscriptionId = null;
    private final transient String analyticsSchemaTypeName = "cancellation_flow_step";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCancellationFlowStep)) {
            return false;
        }
        TrackCancellationFlowStep trackCancellationFlowStep = (TrackCancellationFlowStep) other;
        return Intrinsics3.areEqual(this.toStep, trackCancellationFlowStep.toStep) && Intrinsics3.areEqual(this.fromStep, trackCancellationFlowStep.fromStep) && Intrinsics3.areEqual(this.stepDurationMs, trackCancellationFlowStep.stepDurationMs) && Intrinsics3.areEqual(this.flowDurationMs, trackCancellationFlowStep.flowDurationMs) && Intrinsics3.areEqual(this.subscriptionId, trackCancellationFlowStep.subscriptionId);
    }

    public int hashCode() {
        CharSequence charSequence = this.toStep;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.fromStep;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.stepDurationMs;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.flowDurationMs;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.subscriptionId;
        return iHashCode4 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackCancellationFlowStep(toStep=");
        sbU.append(this.toStep);
        sbU.append(", fromStep=");
        sbU.append(this.fromStep);
        sbU.append(", stepDurationMs=");
        sbU.append(this.stepDurationMs);
        sbU.append(", flowDurationMs=");
        sbU.append(this.flowDurationMs);
        sbU.append(", subscriptionId=");
        return outline.G(sbU, this.subscriptionId, ")");
    }
}
