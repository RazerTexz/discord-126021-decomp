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

/* JADX INFO: compiled from: TrackCancellationFlowStarted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCancellationFlowStarted implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackSubscriptionMetadataReceiver {
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
            return (other instanceof TrackCancellationFlowStarted) && C12238m.areEqual(this.subscriptionId, ((TrackCancellationFlowStarted) other).subscriptionId);
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
        return C1643a.m819G(C1643a.m833U("TrackCancellationFlowStarted(subscriptionId="), this.subscriptionId, ")");
    }
}
