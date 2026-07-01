package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackExperimentGuildTriggered.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackExperimentGuildTriggered implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence name = null;
    private final Long bucket = null;
    private final Long revision = null;
    private final Long guildId = null;
    private final CharSequence linkedUserExperimentName = null;
    private final Long linkedUserExperimentBucket = null;
    private final Long linkedUserExperimentRevision = null;
    private final transient String analyticsSchemaTypeName = "experiment_guild_triggered";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackExperimentGuildTriggered)) {
            return false;
        }
        TrackExperimentGuildTriggered trackExperimentGuildTriggered = (TrackExperimentGuildTriggered) other;
        return Intrinsics3.areEqual(this.name, trackExperimentGuildTriggered.name) && Intrinsics3.areEqual(this.bucket, trackExperimentGuildTriggered.bucket) && Intrinsics3.areEqual(this.revision, trackExperimentGuildTriggered.revision) && Intrinsics3.areEqual(this.guildId, trackExperimentGuildTriggered.guildId) && Intrinsics3.areEqual(this.linkedUserExperimentName, trackExperimentGuildTriggered.linkedUserExperimentName) && Intrinsics3.areEqual(this.linkedUserExperimentBucket, trackExperimentGuildTriggered.linkedUserExperimentBucket) && Intrinsics3.areEqual(this.linkedUserExperimentRevision, trackExperimentGuildTriggered.linkedUserExperimentRevision);
    }

    public int hashCode() {
        CharSequence charSequence = this.name;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.bucket;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.revision;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.linkedUserExperimentName;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l4 = this.linkedUserExperimentBucket;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.linkedUserExperimentRevision;
        return iHashCode6 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackExperimentGuildTriggered(name=");
        sbU.append(this.name);
        sbU.append(", bucket=");
        sbU.append(this.bucket);
        sbU.append(", revision=");
        sbU.append(this.revision);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", linkedUserExperimentName=");
        sbU.append(this.linkedUserExperimentName);
        sbU.append(", linkedUserExperimentBucket=");
        sbU.append(this.linkedUserExperimentBucket);
        sbU.append(", linkedUserExperimentRevision=");
        return outline.G(sbU, this.linkedUserExperimentRevision, ")");
    }
}
