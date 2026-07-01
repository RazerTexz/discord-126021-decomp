package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackStageDiscoveryStartStageClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStageDiscoveryStartStageClicked implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean canStartStage = null;
    private final transient String analyticsSchemaTypeName = "stage_discovery_start_stage_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackStageDiscoveryStartStageClicked) && m.areEqual(this.canStartStage, ((TrackStageDiscoveryStartStageClicked) other).canStartStage);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.canStartStage;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.D(a.U("TrackStageDiscoveryStartStageClicked(canStartStage="), this.canStartStage, ")");
    }
}
