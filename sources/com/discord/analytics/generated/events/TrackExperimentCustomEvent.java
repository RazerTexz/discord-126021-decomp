package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackExperimentCustomEvent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackExperimentCustomEvent implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.experimentName, trackExperimentCustomEvent.experimentName) && C12238m.areEqual(this.experimentBucket, trackExperimentCustomEvent.experimentBucket) && C12238m.areEqual(this.eventName, trackExperimentCustomEvent.eventName);
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
        StringBuilder sbM833U = C1643a.m833U("TrackExperimentCustomEvent(experimentName=");
        sbM833U.append(this.experimentName);
        sbM833U.append(", experimentBucket=");
        sbM833U.append(this.experimentBucket);
        sbM833U.append(", eventName=");
        return C1643a.m817E(sbM833U, this.eventName, ")");
    }
}
