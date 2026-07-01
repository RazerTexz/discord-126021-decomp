package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackStreamReportProblem.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStreamReportProblem implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence reason = null;
    private final Long streamerUserId = null;
    private final Long streamChannelId = null;
    private final Long guildId = null;
    private final CharSequence applicationName = null;
    private final Long applicationId = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence rtcConnectionId = null;
    private final CharSequence rating = null;
    private final CharSequence feedback = null;
    private final transient String analyticsSchemaTypeName = "stream_report_problem";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStreamReportProblem)) {
            return false;
        }
        TrackStreamReportProblem trackStreamReportProblem = (TrackStreamReportProblem) other;
        return Intrinsics3.areEqual(this.reason, trackStreamReportProblem.reason) && Intrinsics3.areEqual(this.streamerUserId, trackStreamReportProblem.streamerUserId) && Intrinsics3.areEqual(this.streamChannelId, trackStreamReportProblem.streamChannelId) && Intrinsics3.areEqual(this.guildId, trackStreamReportProblem.guildId) && Intrinsics3.areEqual(this.applicationName, trackStreamReportProblem.applicationName) && Intrinsics3.areEqual(this.applicationId, trackStreamReportProblem.applicationId) && Intrinsics3.areEqual(this.mediaSessionId, trackStreamReportProblem.mediaSessionId) && Intrinsics3.areEqual(this.rtcConnectionId, trackStreamReportProblem.rtcConnectionId) && Intrinsics3.areEqual(this.rating, trackStreamReportProblem.rating) && Intrinsics3.areEqual(this.feedback, trackStreamReportProblem.feedback);
    }

    public int hashCode() {
        CharSequence charSequence = this.reason;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.streamerUserId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.streamChannelId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.applicationName;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l4 = this.applicationId;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.mediaSessionId;
        int iHashCode7 = (iHashCode6 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.rtcConnectionId;
        int iHashCode8 = (iHashCode7 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.rating;
        int iHashCode9 = (iHashCode8 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.feedback;
        return iHashCode9 + (charSequence6 != null ? charSequence6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStreamReportProblem(reason=");
        sbU.append(this.reason);
        sbU.append(", streamerUserId=");
        sbU.append(this.streamerUserId);
        sbU.append(", streamChannelId=");
        sbU.append(this.streamChannelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", applicationName=");
        sbU.append(this.applicationName);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", rating=");
        sbU.append(this.rating);
        sbU.append(", feedback=");
        return outline.E(sbU, this.feedback, ")");
    }
}
