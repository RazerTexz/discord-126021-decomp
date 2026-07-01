package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackActivityInternalClientStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalClientStatus implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final Long activityWidth = null;
    private final Long activityHeight = null;
    private final Long networkLatencyMs = null;
    private final Long networkAttempts = null;
    private final Long intervalRateMs = null;
    private final Float fpsAvg = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_client_status";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalClientStatus)) {
            return false;
        }
        TrackActivityInternalClientStatus trackActivityInternalClientStatus = (TrackActivityInternalClientStatus) other;
        return Intrinsics3.areEqual(this.activityWidth, trackActivityInternalClientStatus.activityWidth) && Intrinsics3.areEqual(this.activityHeight, trackActivityInternalClientStatus.activityHeight) && Intrinsics3.areEqual(this.networkLatencyMs, trackActivityInternalClientStatus.networkLatencyMs) && Intrinsics3.areEqual(this.networkAttempts, trackActivityInternalClientStatus.networkAttempts) && Intrinsics3.areEqual(this.intervalRateMs, trackActivityInternalClientStatus.intervalRateMs) && Intrinsics3.areEqual(this.fpsAvg, trackActivityInternalClientStatus.fpsAvg);
    }

    public int hashCode() {
        Long l = this.activityWidth;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.activityHeight;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.networkLatencyMs;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.networkAttempts;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.intervalRateMs;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Float f = this.fpsAvg;
        return iHashCode5 + (f != null ? f.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalClientStatus(activityWidth=");
        sbU.append(this.activityWidth);
        sbU.append(", activityHeight=");
        sbU.append(this.activityHeight);
        sbU.append(", networkLatencyMs=");
        sbU.append(this.networkLatencyMs);
        sbU.append(", networkAttempts=");
        sbU.append(this.networkAttempts);
        sbU.append(", intervalRateMs=");
        sbU.append(this.intervalRateMs);
        sbU.append(", fpsAvg=");
        sbU.append(this.fpsAvg);
        sbU.append(")");
        return sbU.toString();
    }
}
