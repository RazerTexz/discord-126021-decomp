package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackStageDiscoveryLoaded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStageDiscoveryLoaded implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence loadId = null;
    private final CharSequence stageInstanceRecommendations = null;
    private final Long lastVisibleIndexAtLoad = null;
    private final List<Long> indexes = null;
    private final List<Long> stageInstanceIds = null;
    private final List<Long> recommendationSources = null;
    private final List<Float> recommendationScores = null;
    private final transient String analyticsSchemaTypeName = "stage_discovery_loaded";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStageDiscoveryLoaded)) {
            return false;
        }
        TrackStageDiscoveryLoaded trackStageDiscoveryLoaded = (TrackStageDiscoveryLoaded) other;
        return Intrinsics3.areEqual(this.loadId, trackStageDiscoveryLoaded.loadId) && Intrinsics3.areEqual(this.stageInstanceRecommendations, trackStageDiscoveryLoaded.stageInstanceRecommendations) && Intrinsics3.areEqual(this.lastVisibleIndexAtLoad, trackStageDiscoveryLoaded.lastVisibleIndexAtLoad) && Intrinsics3.areEqual(this.indexes, trackStageDiscoveryLoaded.indexes) && Intrinsics3.areEqual(this.stageInstanceIds, trackStageDiscoveryLoaded.stageInstanceIds) && Intrinsics3.areEqual(this.recommendationSources, trackStageDiscoveryLoaded.recommendationSources) && Intrinsics3.areEqual(this.recommendationScores, trackStageDiscoveryLoaded.recommendationScores);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.stageInstanceRecommendations;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.lastVisibleIndexAtLoad;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        List<Long> list = this.indexes;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.stageInstanceIds;
        int iHashCode5 = (iHashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Long> list3 = this.recommendationSources;
        int iHashCode6 = (iHashCode5 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<Float> list4 = this.recommendationScores;
        return iHashCode6 + (list4 != null ? list4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStageDiscoveryLoaded(loadId=");
        sbU.append(this.loadId);
        sbU.append(", stageInstanceRecommendations=");
        sbU.append(this.stageInstanceRecommendations);
        sbU.append(", lastVisibleIndexAtLoad=");
        sbU.append(this.lastVisibleIndexAtLoad);
        sbU.append(", indexes=");
        sbU.append(this.indexes);
        sbU.append(", stageInstanceIds=");
        sbU.append(this.stageInstanceIds);
        sbU.append(", recommendationSources=");
        sbU.append(this.recommendationSources);
        sbU.append(", recommendationScores=");
        return outline.L(sbU, this.recommendationScores, ")");
    }
}
