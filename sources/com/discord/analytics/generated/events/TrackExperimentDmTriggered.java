package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackExperimentDmTriggered.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackExperimentDmTriggered implements AnalyticsSchema, TrackBaseReceiver, TrackChannelReceiver {
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
        return C12238m.areEqual(this.name, trackExperimentDmTriggered.name) && C12238m.areEqual(this.bucket, trackExperimentDmTriggered.bucket) && C12238m.areEqual(this.revision, trackExperimentDmTriggered.revision) && C12238m.areEqual(this.otherUserId, trackExperimentDmTriggered.otherUserId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackExperimentDmTriggered(name=");
        sbM833U.append(this.name);
        sbM833U.append(", bucket=");
        sbM833U.append(this.bucket);
        sbM833U.append(", revision=");
        sbM833U.append(this.revision);
        sbM833U.append(", otherUserId=");
        return C1643a.m819G(sbM833U, this.otherUserId, ")");
    }
}
