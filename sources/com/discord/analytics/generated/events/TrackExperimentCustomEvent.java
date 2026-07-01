package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackExperimentCustomEvent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackExperimentCustomEvent implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence experimentName = null;
    private final Long experimentBucket = null;
    private final CharSequence eventName = null;
    private final transient String analyticsSchemaTypeName = "experiment_custom_event";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackExperimentCustomEvent)) {
            return false;
        }
        TrackExperimentCustomEvent trackExperimentCustomEvent = (TrackExperimentCustomEvent) other;
        return Intrinsics3.areEqual(this.experimentName, trackExperimentCustomEvent.experimentName) && Intrinsics3.areEqual(this.experimentBucket, trackExperimentCustomEvent.experimentBucket) && Intrinsics3.areEqual(this.eventName, trackExperimentCustomEvent.eventName);
    }

    public int hashCode() {
        CharSequence charSequence = this.experimentName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.experimentBucket;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.eventName;
        return iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackExperimentCustomEvent(experimentName=");
        sbU.append(this.experimentName);
        sbU.append(", experimentBucket=");
        sbU.append(this.experimentBucket);
        sbU.append(", eventName=");
        return outline.E(sbU, this.eventName, ")");
    }
}
