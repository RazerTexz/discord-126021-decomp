package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackActivityReportDontShow.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityReportDontShow implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.applicationId, trackActivityReportDontShow.applicationId) && C12238m.areEqual(this.rating, trackActivityReportDontShow.rating);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.rating;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackActivityReportDontShow(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", rating=");
        return C1643a.m817E(sbM833U, this.rating, ")");
    }
}
