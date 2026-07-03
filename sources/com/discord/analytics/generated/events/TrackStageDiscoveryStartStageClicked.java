package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
            return (other instanceof TrackStageDiscoveryStartStageClicked) && C12238m.areEqual(this.canStartStage, ((TrackStageDiscoveryStartStageClicked) other).canStartStage);
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
        return C1643a.m816D(C1643a.m833U("TrackStageDiscoveryStartStageClicked(canStartStage="), this.canStartStage, ")");
    }
}
