package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackCancellationFlowStep.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCancellationFlowStep implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackSubscriptionMetadataReceiver {
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
        return C12238m.areEqual(this.toStep, trackCancellationFlowStep.toStep) && C12238m.areEqual(this.fromStep, trackCancellationFlowStep.fromStep) && C12238m.areEqual(this.stepDurationMs, trackCancellationFlowStep.stepDurationMs) && C12238m.areEqual(this.flowDurationMs, trackCancellationFlowStep.flowDurationMs) && C12238m.areEqual(this.subscriptionId, trackCancellationFlowStep.subscriptionId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackCancellationFlowStep(toStep=");
        sbM833U.append(this.toStep);
        sbM833U.append(", fromStep=");
        sbM833U.append(this.fromStep);
        sbM833U.append(", stepDurationMs=");
        sbM833U.append(this.stepDurationMs);
        sbM833U.append(", flowDurationMs=");
        sbM833U.append(this.flowDurationMs);
        sbM833U.append(", subscriptionId=");
        return C1643a.m819G(sbM833U, this.subscriptionId, ")");
    }
}
