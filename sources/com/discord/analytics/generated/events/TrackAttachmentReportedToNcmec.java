package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
    /* JADX INFO: renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
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
        return C12238m.areEqual(this.ncmecReportId, trackAttachmentReportedToNcmec.ncmecReportId) && C12238m.areEqual(this.archiveId, trackAttachmentReportedToNcmec.archiveId) && C12238m.areEqual(this.messageId, trackAttachmentReportedToNcmec.messageId) && C12238m.areEqual(this.attachmentId, trackAttachmentReportedToNcmec.attachmentId) && C12238m.areEqual(this.attachmentHash, trackAttachmentReportedToNcmec.attachmentHash);
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
        StringBuilder sbM833U = C1643a.m833U("TrackAttachmentReportedToNcmec(ncmecReportId=");
        sbM833U.append(this.ncmecReportId);
        sbM833U.append(", archiveId=");
        sbM833U.append(this.archiveId);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", attachmentId=");
        sbM833U.append(this.attachmentId);
        sbM833U.append(", attachmentHash=");
        return C1643a.m817E(sbM833U, this.attachmentHash, ")");
    }
}
