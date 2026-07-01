package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: TrackMessageReported.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMessageReported implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence reportType = null;
    private final CharSequence reportSubType = null;
    private final CharSequence subject = null;
    private final CharSequence description = null;
    private final Long reasonEnum = null;
    private final Long messageId = null;
    private final Long reportId = null;
    private final List<Long> mutualGuildIds = null;
    private final Long reportedMessageAuthorId = null;
    private final transient String analyticsSchemaTypeName = "message_reported";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
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
        if (!(other instanceof TrackMessageReported)) {
            return false;
        }
        TrackMessageReported trackMessageReported = (TrackMessageReported) other;
        return m.areEqual(this.reportType, trackMessageReported.reportType) && m.areEqual(this.reportSubType, trackMessageReported.reportSubType) && m.areEqual(this.subject, trackMessageReported.subject) && m.areEqual(this.description, trackMessageReported.description) && m.areEqual(this.reasonEnum, trackMessageReported.reasonEnum) && m.areEqual(this.messageId, trackMessageReported.messageId) && m.areEqual(this.reportId, trackMessageReported.reportId) && m.areEqual(this.mutualGuildIds, trackMessageReported.mutualGuildIds) && m.areEqual(this.reportedMessageAuthorId, trackMessageReported.reportedMessageAuthorId);
    }

    public int hashCode() {
        CharSequence charSequence = this.reportType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.reportSubType;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.subject;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.description;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l = this.reasonEnum;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.messageId;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.reportId;
        int iHashCode7 = (iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Long> list = this.mutualGuildIds;
        int iHashCode8 = (iHashCode7 + (list != null ? list.hashCode() : 0)) * 31;
        Long l4 = this.reportedMessageAuthorId;
        return iHashCode8 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackMessageReported(reportType=");
        sbU.append(this.reportType);
        sbU.append(", reportSubType=");
        sbU.append(this.reportSubType);
        sbU.append(", subject=");
        sbU.append(this.subject);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", reasonEnum=");
        sbU.append(this.reasonEnum);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", reportId=");
        sbU.append(this.reportId);
        sbU.append(", mutualGuildIds=");
        sbU.append(this.mutualGuildIds);
        sbU.append(", reportedMessageAuthorId=");
        return a.G(sbU, this.reportedMessageAuthorId, ")");
    }
}
