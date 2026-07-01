package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackAttachmentReportedToNcmec.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAttachmentReportedToNcmec implements AnalyticsSchema, TrackBaseReceiver, TrackChannelReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long ncmecReportId = null;
    private final CharSequence archiveId = null;
    private final Long messageId = null;
    private final Long attachmentId = null;
    private final CharSequence attachmentHash = null;
    private final transient String analyticsSchemaTypeName = "attachment_reported_to_ncmec";

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
        if (!(other instanceof TrackAttachmentReportedToNcmec)) {
            return false;
        }
        TrackAttachmentReportedToNcmec trackAttachmentReportedToNcmec = (TrackAttachmentReportedToNcmec) other;
        return m.areEqual(this.ncmecReportId, trackAttachmentReportedToNcmec.ncmecReportId) && m.areEqual(this.archiveId, trackAttachmentReportedToNcmec.archiveId) && m.areEqual(this.messageId, trackAttachmentReportedToNcmec.messageId) && m.areEqual(this.attachmentId, trackAttachmentReportedToNcmec.attachmentId) && m.areEqual(this.attachmentHash, trackAttachmentReportedToNcmec.attachmentHash);
    }

    public int hashCode() {
        Long l = this.ncmecReportId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.archiveId;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.messageId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.attachmentId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.attachmentHash;
        return iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackAttachmentReportedToNcmec(ncmecReportId=");
        sbU.append(this.ncmecReportId);
        sbU.append(", archiveId=");
        sbU.append(this.archiveId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", attachmentId=");
        sbU.append(this.attachmentId);
        sbU.append(", attachmentHash=");
        return a.E(sbU, this.attachmentHash, ")");
    }
}
