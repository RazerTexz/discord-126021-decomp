package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackExperimentUserTriggered.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackExperimentUserTriggered implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.name, trackExperimentUserTriggered.name) && C12238m.areEqual(this.bucket, trackExperimentUserTriggered.bucket) && C12238m.areEqual(this.revision, trackExperimentUserTriggered.revision) && C12238m.areEqual(this.population, trackExperimentUserTriggered.population) && C12238m.areEqual(this.contextType, trackExperimentUserTriggered.contextType) && C12238m.areEqual(this.contextGuildId, trackExperimentUserTriggered.contextGuildId) && C12238m.areEqual(this.contextChannelId, trackExperimentUserTriggered.contextChannelId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackExperimentUserTriggered(name=");
        sbM833U.append(this.name);
        sbM833U.append(", bucket=");
        sbM833U.append(this.bucket);
        sbM833U.append(", revision=");
        sbM833U.append(this.revision);
        sbM833U.append(", population=");
        sbM833U.append(this.population);
        sbM833U.append(", contextType=");
        sbM833U.append(this.contextType);
        sbM833U.append(", contextGuildId=");
        sbM833U.append(this.contextGuildId);
        sbM833U.append(", contextChannelId=");
        return C1643a.m819G(sbM833U, this.contextChannelId, ")");
    }
}
