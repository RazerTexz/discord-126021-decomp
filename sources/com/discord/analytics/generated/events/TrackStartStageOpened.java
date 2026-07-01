package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackStartStageOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStartStageOpened implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Boolean canStartPublicStage = null;
    private final Long stageInstanceId = null;
    private final transient String analyticsSchemaTypeName = "start_stage_opened";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
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
        if (!(other instanceof TrackStartStageOpened)) {
            return false;
        }
        TrackStartStageOpened trackStartStageOpened = (TrackStartStageOpened) other;
        return Intrinsics3.areEqual(this.canStartPublicStage, trackStartStageOpened.canStartPublicStage) && Intrinsics3.areEqual(this.stageInstanceId, trackStartStageOpened.stageInstanceId);
    }

    public int hashCode() {
        Boolean bool = this.canStartPublicStage;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.stageInstanceId;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStartStageOpened(canStartPublicStage=");
        sbU.append(this.canStartPublicStage);
        sbU.append(", stageInstanceId=");
        return outline.G(sbU, this.stageInstanceId, ")");
    }
}
