package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackStartStageOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStartStageOpened implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Boolean canStartPublicStage = null;
    private final Long stageInstanceId = null;
    private final transient String analyticsSchemaTypeName = "start_stage_opened";

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
        if (!(other instanceof TrackStartStageOpened)) {
            return false;
        }
        TrackStartStageOpened trackStartStageOpened = (TrackStartStageOpened) other;
        return C12238m.areEqual(this.canStartPublicStage, trackStartStageOpened.canStartPublicStage) && C12238m.areEqual(this.stageInstanceId, trackStartStageOpened.stageInstanceId);
    }

    public int hashCode() {
        Boolean bool = this.canStartPublicStage;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.stageInstanceId;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackStartStageOpened(canStartPublicStage=");
        sbM833U.append(this.canStartPublicStage);
        sbM833U.append(", stageInstanceId=");
        return C1643a.m819G(sbM833U, this.stageInstanceId, ")");
    }
}
