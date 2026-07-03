package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackStageDiscoveryStageExited.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStageDiscoveryStageExited implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final CharSequence loadId = null;
    private final CharSequence stageInstanceRecommendations = null;
    private final Long lastVisibleIndexAtLoad = null;
    private final Long index = null;
    private final Long stageInstanceId = null;
    private final List<Long> recommendationSource = null;
    private final Float recommendationScore = null;
    private final Long joinTimestamp = null;
    private final transient String analyticsSchemaTypeName = "stage_discovery_stage_exited";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStageDiscoveryStageExited)) {
            return false;
        }
        TrackStageDiscoveryStageExited trackStageDiscoveryStageExited = (TrackStageDiscoveryStageExited) other;
        return C12238m.areEqual(this.loadId, trackStageDiscoveryStageExited.loadId) && C12238m.areEqual(this.stageInstanceRecommendations, trackStageDiscoveryStageExited.stageInstanceRecommendations) && C12238m.areEqual(this.lastVisibleIndexAtLoad, trackStageDiscoveryStageExited.lastVisibleIndexAtLoad) && C12238m.areEqual(this.index, trackStageDiscoveryStageExited.index) && C12238m.areEqual(this.stageInstanceId, trackStageDiscoveryStageExited.stageInstanceId) && C12238m.areEqual(this.recommendationSource, trackStageDiscoveryStageExited.recommendationSource) && C12238m.areEqual(this.recommendationScore, trackStageDiscoveryStageExited.recommendationScore) && C12238m.areEqual(this.joinTimestamp, trackStageDiscoveryStageExited.joinTimestamp);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.stageInstanceRecommendations;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.lastVisibleIndexAtLoad;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.index;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.stageInstanceId;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Long> list = this.recommendationSource;
        int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        Float f = this.recommendationScore;
        int iHashCode7 = (iHashCode6 + (f != null ? f.hashCode() : 0)) * 31;
        Long l4 = this.joinTimestamp;
        return iHashCode7 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackStageDiscoveryStageExited(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", stageInstanceRecommendations=");
        sbM833U.append(this.stageInstanceRecommendations);
        sbM833U.append(", lastVisibleIndexAtLoad=");
        sbM833U.append(this.lastVisibleIndexAtLoad);
        sbM833U.append(", index=");
        sbM833U.append(this.index);
        sbM833U.append(", stageInstanceId=");
        sbM833U.append(this.stageInstanceId);
        sbM833U.append(", recommendationSource=");
        sbM833U.append(this.recommendationSource);
        sbM833U.append(", recommendationScore=");
        sbM833U.append(this.recommendationScore);
        sbM833U.append(", joinTimestamp=");
        return C1643a.m819G(sbM833U, this.joinTimestamp, ")");
    }
}
