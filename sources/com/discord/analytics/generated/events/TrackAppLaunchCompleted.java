package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackAppLaunchCompleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAppLaunchCompleted implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence loadId = null;
    private final CharSequence screenName = null;
    private final Long durationMsSinceAppOpened = null;
    private final Boolean hasCachedData = null;
    private final CharSequence manifest = null;
    private final transient String analyticsSchemaTypeName = "app_launch_completed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAppLaunchCompleted)) {
            return false;
        }
        TrackAppLaunchCompleted trackAppLaunchCompleted = (TrackAppLaunchCompleted) other;
        return m.areEqual(this.loadId, trackAppLaunchCompleted.loadId) && m.areEqual(this.screenName, trackAppLaunchCompleted.screenName) && m.areEqual(this.durationMsSinceAppOpened, trackAppLaunchCompleted.durationMsSinceAppOpened) && m.areEqual(this.hasCachedData, trackAppLaunchCompleted.hasCachedData) && m.areEqual(this.manifest, trackAppLaunchCompleted.manifest);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.screenName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.durationMsSinceAppOpened;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool = this.hasCachedData;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.manifest;
        return iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackAppLaunchCompleted(loadId=");
        sbU.append(this.loadId);
        sbU.append(", screenName=");
        sbU.append(this.screenName);
        sbU.append(", durationMsSinceAppOpened=");
        sbU.append(this.durationMsSinceAppOpened);
        sbU.append(", hasCachedData=");
        sbU.append(this.hasCachedData);
        sbU.append(", manifest=");
        return a.E(sbU, this.manifest, ")");
    }
}
