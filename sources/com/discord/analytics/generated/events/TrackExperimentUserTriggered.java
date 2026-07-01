package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackExperimentUserTriggered.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackExperimentUserTriggered implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence name = null;
    private final Long bucket = null;
    private final Long revision = null;
    private final Long population = null;
    private final CharSequence contextType = null;
    private final Long contextGuildId = null;
    private final Long contextChannelId = null;
    private final transient String analyticsSchemaTypeName = "experiment_user_triggered";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackExperimentUserTriggered)) {
            return false;
        }
        TrackExperimentUserTriggered trackExperimentUserTriggered = (TrackExperimentUserTriggered) other;
        return Intrinsics3.areEqual(this.name, trackExperimentUserTriggered.name) && Intrinsics3.areEqual(this.bucket, trackExperimentUserTriggered.bucket) && Intrinsics3.areEqual(this.revision, trackExperimentUserTriggered.revision) && Intrinsics3.areEqual(this.population, trackExperimentUserTriggered.population) && Intrinsics3.areEqual(this.contextType, trackExperimentUserTriggered.contextType) && Intrinsics3.areEqual(this.contextGuildId, trackExperimentUserTriggered.contextGuildId) && Intrinsics3.areEqual(this.contextChannelId, trackExperimentUserTriggered.contextChannelId);
    }

    public int hashCode() {
        CharSequence charSequence = this.name;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.bucket;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.revision;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.population;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.contextType;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l4 = this.contextGuildId;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.contextChannelId;
        return iHashCode6 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackExperimentUserTriggered(name=");
        sbU.append(this.name);
        sbU.append(", bucket=");
        sbU.append(this.bucket);
        sbU.append(", revision=");
        sbU.append(this.revision);
        sbU.append(", population=");
        sbU.append(this.population);
        sbU.append(", contextType=");
        sbU.append(this.contextType);
        sbU.append(", contextGuildId=");
        sbU.append(this.contextGuildId);
        sbU.append(", contextChannelId=");
        return outline.G(sbU, this.contextChannelId, ")");
    }
}
