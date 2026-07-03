package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.loadId, trackAppLaunchCompleted.loadId) && C12238m.areEqual(this.screenName, trackAppLaunchCompleted.screenName) && C12238m.areEqual(this.durationMsSinceAppOpened, trackAppLaunchCompleted.durationMsSinceAppOpened) && C12238m.areEqual(this.hasCachedData, trackAppLaunchCompleted.hasCachedData) && C12238m.areEqual(this.manifest, trackAppLaunchCompleted.manifest);
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
        StringBuilder sbM833U = C1643a.m833U("TrackAppLaunchCompleted(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", screenName=");
        sbM833U.append(this.screenName);
        sbM833U.append(", durationMsSinceAppOpened=");
        sbM833U.append(this.durationMsSinceAppOpened);
        sbM833U.append(", hasCachedData=");
        sbM833U.append(this.hasCachedData);
        sbM833U.append(", manifest=");
        return C1643a.m817E(sbM833U, this.manifest, ")");
    }
}
