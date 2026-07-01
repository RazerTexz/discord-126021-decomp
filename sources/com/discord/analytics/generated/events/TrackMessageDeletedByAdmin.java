package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: TrackMessageDeletedByAdmin.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMessageDeletedByAdmin implements AnalyticsSchema, TrackBaseReceiver, TrackChannelReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long messageId = null;
    private final CharSequence reason = null;
    private final Long numUrls = null;
    private final Long numAttachments = null;
    private final Long numEmbeds = null;
    private final Long numMentions = null;
    private final Long length = null;
    private final Long wordCount = null;
    private final List<CharSequence> urls = null;
    private final transient String analyticsSchemaTypeName = "message_deleted_by_admin";

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
        if (!(other instanceof TrackMessageDeletedByAdmin)) {
            return false;
        }
        TrackMessageDeletedByAdmin trackMessageDeletedByAdmin = (TrackMessageDeletedByAdmin) other;
        return m.areEqual(this.messageId, trackMessageDeletedByAdmin.messageId) && m.areEqual(this.reason, trackMessageDeletedByAdmin.reason) && m.areEqual(this.numUrls, trackMessageDeletedByAdmin.numUrls) && m.areEqual(this.numAttachments, trackMessageDeletedByAdmin.numAttachments) && m.areEqual(this.numEmbeds, trackMessageDeletedByAdmin.numEmbeds) && m.areEqual(this.numMentions, trackMessageDeletedByAdmin.numMentions) && m.areEqual(this.length, trackMessageDeletedByAdmin.length) && m.areEqual(this.wordCount, trackMessageDeletedByAdmin.wordCount) && m.areEqual(this.urls, trackMessageDeletedByAdmin.urls);
    }

    public int hashCode() {
        Long l = this.messageId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.reason;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.numUrls;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numAttachments;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numEmbeds;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.numMentions;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.length;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.wordCount;
        int iHashCode8 = (iHashCode7 + (l7 != null ? l7.hashCode() : 0)) * 31;
        List<CharSequence> list = this.urls;
        return iHashCode8 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackMessageDeletedByAdmin(messageId=");
        sbU.append(this.messageId);
        sbU.append(", reason=");
        sbU.append(this.reason);
        sbU.append(", numUrls=");
        sbU.append(this.numUrls);
        sbU.append(", numAttachments=");
        sbU.append(this.numAttachments);
        sbU.append(", numEmbeds=");
        sbU.append(this.numEmbeds);
        sbU.append(", numMentions=");
        sbU.append(this.numMentions);
        sbU.append(", length=");
        sbU.append(this.length);
        sbU.append(", wordCount=");
        sbU.append(this.wordCount);
        sbU.append(", urls=");
        return a.L(sbU, this.urls, ")");
    }
}
