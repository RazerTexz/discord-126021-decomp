package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackStageDiscoveryExited.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStageDiscoveryExited implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence loadId = null;
    private final CharSequence stageInstanceRecommendations = null;
    private final Long lastVisibleIndexAtLoad = null;
    private final Long lastVisibleIndex = null;
    private final Boolean hasScrolled = null;
    private final transient String analyticsSchemaTypeName = "stage_discovery_exited";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStageDiscoveryExited)) {
            return false;
        }
        TrackStageDiscoveryExited trackStageDiscoveryExited = (TrackStageDiscoveryExited) other;
        return Intrinsics3.areEqual(this.loadId, trackStageDiscoveryExited.loadId) && Intrinsics3.areEqual(this.stageInstanceRecommendations, trackStageDiscoveryExited.stageInstanceRecommendations) && Intrinsics3.areEqual(this.lastVisibleIndexAtLoad, trackStageDiscoveryExited.lastVisibleIndexAtLoad) && Intrinsics3.areEqual(this.lastVisibleIndex, trackStageDiscoveryExited.lastVisibleIndex) && Intrinsics3.areEqual(this.hasScrolled, trackStageDiscoveryExited.hasScrolled);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.stageInstanceRecommendations;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.lastVisibleIndexAtLoad;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.lastVisibleIndex;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.hasScrolled;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStageDiscoveryExited(loadId=");
        sbU.append(this.loadId);
        sbU.append(", stageInstanceRecommendations=");
        sbU.append(this.stageInstanceRecommendations);
        sbU.append(", lastVisibleIndexAtLoad=");
        sbU.append(this.lastVisibleIndexAtLoad);
        sbU.append(", lastVisibleIndex=");
        sbU.append(this.lastVisibleIndex);
        sbU.append(", hasScrolled=");
        return outline.D(sbU, this.hasScrolled, ")");
    }
}
