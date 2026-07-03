package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackUploadFileLimitError.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUploadFileLimitError implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long existingCount = null;
    private final Long newCount = null;
    private final transient String analyticsSchemaTypeName = "upload_file_limit_error";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUploadFileLimitError)) {
            return false;
        }
        TrackUploadFileLimitError trackUploadFileLimitError = (TrackUploadFileLimitError) other;
        return C12238m.areEqual(this.existingCount, trackUploadFileLimitError.existingCount) && C12238m.areEqual(this.newCount, trackUploadFileLimitError.newCount);
    }

    public int hashCode() {
        Long l = this.existingCount;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.newCount;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackUploadFileLimitError(existingCount=");
        sbM833U.append(this.existingCount);
        sbM833U.append(", newCount=");
        return C1643a.m819G(sbM833U, this.newCount, ")");
    }
}
