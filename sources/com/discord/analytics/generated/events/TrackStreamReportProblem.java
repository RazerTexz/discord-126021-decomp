package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackStreamReportProblem.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStreamReportProblem implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.reason, trackStreamReportProblem.reason) && C12238m.areEqual(this.streamerUserId, trackStreamReportProblem.streamerUserId) && C12238m.areEqual(this.streamChannelId, trackStreamReportProblem.streamChannelId) && C12238m.areEqual(this.guildId, trackStreamReportProblem.guildId) && C12238m.areEqual(this.applicationName, trackStreamReportProblem.applicationName) && C12238m.areEqual(this.applicationId, trackStreamReportProblem.applicationId) && C12238m.areEqual(this.mediaSessionId, trackStreamReportProblem.mediaSessionId) && C12238m.areEqual(this.rtcConnectionId, trackStreamReportProblem.rtcConnectionId) && C12238m.areEqual(this.rating, trackStreamReportProblem.rating) && C12238m.areEqual(this.feedback, trackStreamReportProblem.feedback);
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
        StringBuilder sbM833U = C1643a.m833U("TrackStreamReportProblem(reason=");
        sbM833U.append(this.reason);
        sbM833U.append(", streamerUserId=");
        sbM833U.append(this.streamerUserId);
        sbM833U.append(", streamChannelId=");
        sbM833U.append(this.streamChannelId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", applicationName=");
        sbM833U.append(this.applicationName);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", rtcConnectionId=");
        sbM833U.append(this.rtcConnectionId);
        sbM833U.append(", rating=");
        sbM833U.append(this.rating);
        sbM833U.append(", feedback=");
        return C1643a.m817E(sbM833U, this.feedback, ")");
    }
}
