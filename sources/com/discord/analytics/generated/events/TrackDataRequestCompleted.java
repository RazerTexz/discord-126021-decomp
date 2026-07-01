package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackDataRequestCompleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDataRequestCompleted implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long harvestId = null;
    private final transient String analyticsSchemaTypeName = "data_request_completed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackDataRequestCompleted) && Intrinsics3.areEqual(this.harvestId, ((TrackDataRequestCompleted) other).harvestId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.harvestId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.G(outline.U("TrackDataRequestCompleted(harvestId="), this.harvestId, ")");
    }
}
