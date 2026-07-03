package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackMessageDeleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMessageDeleted implements AnalyticsSchema, TrackBaseReceiver, TrackChannelReceiver, TrackGuildReceiver {
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
        if (!(other instanceof TrackMessageDeleted)) {
            return false;
        }
        TrackMessageDeleted trackMessageDeleted = (TrackMessageDeleted) other;
        return C12238m.areEqual(this.messageId, trackMessageDeleted.messageId) && C12238m.areEqual(this.reason, trackMessageDeleted.reason) && C12238m.areEqual(this.authorId, trackMessageDeleted.authorId) && C12238m.areEqual(this.numUrls, trackMessageDeleted.numUrls) && C12238m.areEqual(this.numAttachments, trackMessageDeleted.numAttachments) && C12238m.areEqual(this.numEmbeds, trackMessageDeleted.numEmbeds) && C12238m.areEqual(this.numMentions, trackMessageDeleted.numMentions) && C12238m.areEqual(this.length, trackMessageDeleted.length) && C12238m.areEqual(this.wordCount, trackMessageDeleted.wordCount) && C12238m.areEqual(this.urls, trackMessageDeleted.urls);
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
        StringBuilder sbM833U = C1643a.m833U("TrackMessageDeleted(messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", reason=");
        sbM833U.append(this.reason);
        sbM833U.append(", authorId=");
        sbM833U.append(this.authorId);
        sbM833U.append(", numUrls=");
        sbM833U.append(this.numUrls);
        sbM833U.append(", numAttachments=");
        sbM833U.append(this.numAttachments);
        sbM833U.append(", numEmbeds=");
        sbM833U.append(this.numEmbeds);
        sbM833U.append(", numMentions=");
        sbM833U.append(this.numMentions);
        sbM833U.append(", length=");
        sbM833U.append(this.length);
        sbM833U.append(", wordCount=");
        sbM833U.append(this.wordCount);
        sbM833U.append(", urls=");
        return C1643a.m824L(sbM833U, this.urls, ")");
    }
}
