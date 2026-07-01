package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackStageDiscoveryStartStageCompleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStageDiscoveryStartStageCompleted implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long stageInstanceId = null;
    private final Boolean createdNewStageChannel = null;
    private final transient String analyticsSchemaTypeName = "stage_discovery_start_stage_completed";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    public void c(TrackGuild trackGuild) {
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
        if (!(other instanceof TrackStageDiscoveryStartStageCompleted)) {
            return false;
        }
        TrackStageDiscoveryStartStageCompleted trackStageDiscoveryStartStageCompleted = (TrackStageDiscoveryStartStageCompleted) other;
        return m.areEqual(this.stageInstanceId, trackStageDiscoveryStartStageCompleted.stageInstanceId) && m.areEqual(this.createdNewStageChannel, trackStageDiscoveryStartStageCompleted.createdNewStageChannel);
    }

    public int hashCode() {
        Long l = this.stageInstanceId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Boolean bool = this.createdNewStageChannel;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackStageDiscoveryStartStageCompleted(stageInstanceId=");
        sbU.append(this.stageInstanceId);
        sbU.append(", createdNewStageChannel=");
        return a.D(sbU, this.createdNewStageChannel, ")");
    }
}
