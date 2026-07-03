package com.discord.analytics.generated.events.activity_internal;

import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackActivityInternalClientStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalClientStatus implements AnalyticsSchema, TrackBaseReceiver, TrackActivityInternalMetadataReceiver {
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
        return C12238m.areEqual(this.activityWidth, trackActivityInternalClientStatus.activityWidth) && C12238m.areEqual(this.activityHeight, trackActivityInternalClientStatus.activityHeight) && C12238m.areEqual(this.networkLatencyMs, trackActivityInternalClientStatus.networkLatencyMs) && C12238m.areEqual(this.networkAttempts, trackActivityInternalClientStatus.networkAttempts) && C12238m.areEqual(this.intervalRateMs, trackActivityInternalClientStatus.intervalRateMs) && C12238m.areEqual(this.fpsAvg, trackActivityInternalClientStatus.fpsAvg);
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
        StringBuilder sbM833U = C1643a.m833U("TrackActivityInternalClientStatus(activityWidth=");
        sbM833U.append(this.activityWidth);
        sbM833U.append(", activityHeight=");
        sbM833U.append(this.activityHeight);
        sbM833U.append(", networkLatencyMs=");
        sbM833U.append(this.networkLatencyMs);
        sbM833U.append(", networkAttempts=");
        sbM833U.append(this.networkAttempts);
        sbM833U.append(", intervalRateMs=");
        sbM833U.append(this.intervalRateMs);
        sbM833U.append(", fpsAvg=");
        sbM833U.append(this.fpsAvg);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
