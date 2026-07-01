package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackActivityReportProblem.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityReportProblem implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long guildId = null;
    private final CharSequence reason = null;
    private final CharSequence rtcConnectionId = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence rating = null;
    private final CharSequence feedback = null;
    private final Long applicationId = null;
    private final CharSequence applicationName = null;
    private final transient String analyticsSchemaTypeName = "activity_report_problem";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityReportProblem)) {
            return false;
        }
        TrackActivityReportProblem trackActivityReportProblem = (TrackActivityReportProblem) other;
        return Intrinsics3.areEqual(this.channelId, trackActivityReportProblem.channelId) && Intrinsics3.areEqual(this.guildId, trackActivityReportProblem.guildId) && Intrinsics3.areEqual(this.reason, trackActivityReportProblem.reason) && Intrinsics3.areEqual(this.rtcConnectionId, trackActivityReportProblem.rtcConnectionId) && Intrinsics3.areEqual(this.mediaSessionId, trackActivityReportProblem.mediaSessionId) && Intrinsics3.areEqual(this.rating, trackActivityReportProblem.rating) && Intrinsics3.areEqual(this.feedback, trackActivityReportProblem.feedback) && Intrinsics3.areEqual(this.applicationId, trackActivityReportProblem.applicationId) && Intrinsics3.areEqual(this.applicationName, trackActivityReportProblem.applicationName);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.reason;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.rtcConnectionId;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.mediaSessionId;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.rating;
        int iHashCode6 = (iHashCode5 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.feedback;
        int iHashCode7 = (iHashCode6 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l3 = this.applicationId;
        int iHashCode8 = (iHashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.applicationName;
        return iHashCode8 + (charSequence6 != null ? charSequence6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityReportProblem(channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", reason=");
        sbU.append(this.reason);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", rating=");
        sbU.append(this.rating);
        sbU.append(", feedback=");
        sbU.append(this.feedback);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", applicationName=");
        return outline.E(sbU, this.applicationName, ")");
    }
}
