package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackMessageDeleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMessageDeleted implements AnalyticsSchema, TrackBase2, TrackChannel2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long messageId = null;
    private final CharSequence reason = null;
    private final Long authorId = null;
    private final Long numUrls = null;
    private final Long numAttachments = null;
    private final Long numEmbeds = null;
    private final Long numMentions = null;
    private final Long length = null;
    private final Long wordCount = null;
    private final List<CharSequence> urls = null;
    private final transient String analyticsSchemaTypeName = "message_deleted";

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
        if (!(other instanceof TrackMessageDeleted)) {
            return false;
        }
        TrackMessageDeleted trackMessageDeleted = (TrackMessageDeleted) other;
        return Intrinsics3.areEqual(this.messageId, trackMessageDeleted.messageId) && Intrinsics3.areEqual(this.reason, trackMessageDeleted.reason) && Intrinsics3.areEqual(this.authorId, trackMessageDeleted.authorId) && Intrinsics3.areEqual(this.numUrls, trackMessageDeleted.numUrls) && Intrinsics3.areEqual(this.numAttachments, trackMessageDeleted.numAttachments) && Intrinsics3.areEqual(this.numEmbeds, trackMessageDeleted.numEmbeds) && Intrinsics3.areEqual(this.numMentions, trackMessageDeleted.numMentions) && Intrinsics3.areEqual(this.length, trackMessageDeleted.length) && Intrinsics3.areEqual(this.wordCount, trackMessageDeleted.wordCount) && Intrinsics3.areEqual(this.urls, trackMessageDeleted.urls);
    }

    public int hashCode() {
        Long l = this.messageId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.reason;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.authorId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numUrls;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numAttachments;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.numEmbeds;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.numMentions;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.length;
        int iHashCode8 = (iHashCode7 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.wordCount;
        int iHashCode9 = (iHashCode8 + (l8 != null ? l8.hashCode() : 0)) * 31;
        List<CharSequence> list = this.urls;
        return iHashCode9 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackMessageDeleted(messageId=");
        sbU.append(this.messageId);
        sbU.append(", reason=");
        sbU.append(this.reason);
        sbU.append(", authorId=");
        sbU.append(this.authorId);
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
        return outline.L(sbU, this.urls, ")");
    }
}
