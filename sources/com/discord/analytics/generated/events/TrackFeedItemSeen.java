package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackFeedItemSeen.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackFeedItemSeen implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence feedItemType = null;
    private final CharSequence loadId = null;
    private final Long messageId = null;
    private final transient String analyticsSchemaTypeName = "feed_item_seen";

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
        if (!(other instanceof TrackFeedItemSeen)) {
            return false;
        }
        TrackFeedItemSeen trackFeedItemSeen = (TrackFeedItemSeen) other;
        return Intrinsics3.areEqual(this.feedItemType, trackFeedItemSeen.feedItemType) && Intrinsics3.areEqual(this.loadId, trackFeedItemSeen.loadId) && Intrinsics3.areEqual(this.messageId, trackFeedItemSeen.messageId);
    }

    public int hashCode() {
        CharSequence charSequence = this.feedItemType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.loadId;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.messageId;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackFeedItemSeen(feedItemType=");
        sbU.append(this.feedItemType);
        sbU.append(", loadId=");
        sbU.append(this.loadId);
        sbU.append(", messageId=");
        return outline.G(sbU, this.messageId, ")");
    }
}
