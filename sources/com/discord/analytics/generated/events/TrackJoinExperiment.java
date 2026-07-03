package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackJoinExperiment.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackJoinExperiment implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.type, trackJoinExperiment.type) && C12238m.areEqual(this.name, trackJoinExperiment.name) && C12238m.areEqual(this.bucket, trackJoinExperiment.bucket) && C12238m.areEqual(this.revision, trackJoinExperiment.revision);
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
        StringBuilder sbM833U = C1643a.m833U("TrackJoinExperiment(type=");
        sbM833U.append(this.type);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", bucket=");
        sbM833U.append(this.bucket);
        sbM833U.append(", revision=");
        return C1643a.m819G(sbM833U, this.revision, ")");
    }
}
