package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackUserReportSubmitted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserReportSubmitted implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Boolean skipped = null;
    private final CharSequence reportName = null;
    private final CharSequence reason = null;
    private final CharSequence feedback = null;
    private final transient String analyticsSchemaTypeName = "user_report_submitted";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserReportSubmitted)) {
            return false;
        }
        TrackUserReportSubmitted trackUserReportSubmitted = (TrackUserReportSubmitted) other;
        return Intrinsics3.areEqual(this.skipped, trackUserReportSubmitted.skipped) && Intrinsics3.areEqual(this.reportName, trackUserReportSubmitted.reportName) && Intrinsics3.areEqual(this.reason, trackUserReportSubmitted.reason) && Intrinsics3.areEqual(this.feedback, trackUserReportSubmitted.feedback);
    }

    public int hashCode() {
        Boolean bool = this.skipped;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.reportName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.reason;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.feedback;
        return iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackUserReportSubmitted(skipped=");
        sbU.append(this.skipped);
        sbU.append(", reportName=");
        sbU.append(this.reportName);
        sbU.append(", reason=");
        sbU.append(this.reason);
        sbU.append(", feedback=");
        return outline.E(sbU, this.feedback, ")");
    }
}
