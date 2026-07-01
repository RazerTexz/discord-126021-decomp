package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackJoinExperiment.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackJoinExperiment implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence type = null;
    private final CharSequence name = null;
    private final Long bucket = null;
    private final Long revision = null;
    private final transient String analyticsSchemaTypeName = "join_experiment";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackJoinExperiment)) {
            return false;
        }
        TrackJoinExperiment trackJoinExperiment = (TrackJoinExperiment) other;
        return Intrinsics3.areEqual(this.type, trackJoinExperiment.type) && Intrinsics3.areEqual(this.name, trackJoinExperiment.name) && Intrinsics3.areEqual(this.bucket, trackJoinExperiment.bucket) && Intrinsics3.areEqual(this.revision, trackJoinExperiment.revision);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.name;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.bucket;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.revision;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackJoinExperiment(type=");
        sbU.append(this.type);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", bucket=");
        sbU.append(this.bucket);
        sbU.append(", revision=");
        return outline.G(sbU, this.revision, ")");
    }
}
