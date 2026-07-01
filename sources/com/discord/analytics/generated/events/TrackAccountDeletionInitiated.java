package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackAccountDeletionInitiated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAccountDeletionInitiated implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence initiatedBy = null;
    private final Long reasonCode = null;
    private final transient String analyticsSchemaTypeName = "account_deletion_initiated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAccountDeletionInitiated)) {
            return false;
        }
        TrackAccountDeletionInitiated trackAccountDeletionInitiated = (TrackAccountDeletionInitiated) other;
        return m.areEqual(this.initiatedBy, trackAccountDeletionInitiated.initiatedBy) && m.areEqual(this.reasonCode, trackAccountDeletionInitiated.reasonCode);
    }

    public int hashCode() {
        CharSequence charSequence = this.initiatedBy;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.reasonCode;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackAccountDeletionInitiated(initiatedBy=");
        sbU.append(this.initiatedBy);
        sbU.append(", reasonCode=");
        return a.G(sbU, this.reasonCode, ")");
    }
}
