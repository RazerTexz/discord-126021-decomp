package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackExperimentDmTriggered.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackExperimentDmTriggered implements AnalyticsSchema, TrackBase2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private final CharSequence name = null;
    private final Long bucket = null;
    private final Long revision = null;
    private final Long otherUserId = null;
    private final transient String analyticsSchemaTypeName = "experiment_dm_triggered";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackExperimentDmTriggered)) {
            return false;
        }
        TrackExperimentDmTriggered trackExperimentDmTriggered = (TrackExperimentDmTriggered) other;
        return Intrinsics3.areEqual(this.name, trackExperimentDmTriggered.name) && Intrinsics3.areEqual(this.bucket, trackExperimentDmTriggered.bucket) && Intrinsics3.areEqual(this.revision, trackExperimentDmTriggered.revision) && Intrinsics3.areEqual(this.otherUserId, trackExperimentDmTriggered.otherUserId);
    }

    public int hashCode() {
        CharSequence charSequence = this.name;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.bucket;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.revision;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.otherUserId;
        return iHashCode3 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackExperimentDmTriggered(name=");
        sbU.append(this.name);
        sbU.append(", bucket=");
        sbU.append(this.bucket);
        sbU.append(", revision=");
        sbU.append(this.revision);
        sbU.append(", otherUserId=");
        return outline.G(sbU, this.otherUserId, ")");
    }
}
