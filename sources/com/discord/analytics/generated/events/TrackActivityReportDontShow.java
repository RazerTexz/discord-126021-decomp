package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackActivityReportDontShow.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityReportDontShow implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final CharSequence rating = null;
    private final transient String analyticsSchemaTypeName = "activity_report_dont_show";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityReportDontShow)) {
            return false;
        }
        TrackActivityReportDontShow trackActivityReportDontShow = (TrackActivityReportDontShow) other;
        return Intrinsics3.areEqual(this.applicationId, trackActivityReportDontShow.applicationId) && Intrinsics3.areEqual(this.rating, trackActivityReportDontShow.rating);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.rating;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityReportDontShow(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", rating=");
        return outline.E(sbU, this.rating, ")");
    }
}
