package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackStageDiscoveryLoaded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStageDiscoveryLoaded implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.loadId, trackStageDiscoveryLoaded.loadId) && C12238m.areEqual(this.stageInstanceRecommendations, trackStageDiscoveryLoaded.stageInstanceRecommendations) && C12238m.areEqual(this.lastVisibleIndexAtLoad, trackStageDiscoveryLoaded.lastVisibleIndexAtLoad) && C12238m.areEqual(this.indexes, trackStageDiscoveryLoaded.indexes) && C12238m.areEqual(this.stageInstanceIds, trackStageDiscoveryLoaded.stageInstanceIds) && C12238m.areEqual(this.recommendationSources, trackStageDiscoveryLoaded.recommendationSources) && C12238m.areEqual(this.recommendationScores, trackStageDiscoveryLoaded.recommendationScores);
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
        StringBuilder sbM833U = C1643a.m833U("TrackStageDiscoveryLoaded(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", stageInstanceRecommendations=");
        sbM833U.append(this.stageInstanceRecommendations);
        sbM833U.append(", lastVisibleIndexAtLoad=");
        sbM833U.append(this.lastVisibleIndexAtLoad);
        sbM833U.append(", indexes=");
        sbM833U.append(this.indexes);
        sbM833U.append(", stageInstanceIds=");
        sbM833U.append(this.stageInstanceIds);
        sbM833U.append(", recommendationSources=");
        sbM833U.append(this.recommendationSources);
        sbM833U.append(", recommendationScores=");
        return C1643a.m824L(sbM833U, this.recommendationScores, ")");
    }
}
