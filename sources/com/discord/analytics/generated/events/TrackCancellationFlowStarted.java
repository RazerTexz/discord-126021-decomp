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

/* JADX INFO: compiled from: TrackCancellationFlowStarted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCancellationFlowStarted implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackSubscriptionMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackSubscriptionMetadata trackSubscriptionMetadata;
    private final Long subscriptionId = null;
    private final transient String analyticsSchemaTypeName = "cancellation_flow_started";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackCancellationFlowStarted) && Intrinsics3.areEqual(this.subscriptionId, ((TrackCancellationFlowStarted) other).subscriptionId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.subscriptionId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.G(outline.U("TrackCancellationFlowStarted(subscriptionId="), this.subscriptionId, ")");
    }
}
