package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.initiatedBy, trackAccountDeletionInitiated.initiatedBy) && C12238m.areEqual(this.reasonCode, trackAccountDeletionInitiated.reasonCode);
    }

    public int hashCode() {
        CharSequence charSequence = this.initiatedBy;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.reasonCode;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackAccountDeletionInitiated(initiatedBy=");
        sbM833U.append(this.initiatedBy);
        sbM833U.append(", reasonCode=");
        return C1643a.m819G(sbM833U, this.reasonCode, ")");
    }
}
