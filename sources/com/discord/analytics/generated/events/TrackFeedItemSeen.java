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

/* JADX INFO: compiled from: TrackFeedItemSeen.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackFeedItemSeen implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence feedItemType = null;
    private final CharSequence loadId = null;
    private final Long messageId = null;
    private final transient String analyticsSchemaTypeName = "feed_item_seen";

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
        if (!(other instanceof TrackFeedItemSeen)) {
            return false;
        }
        TrackFeedItemSeen trackFeedItemSeen = (TrackFeedItemSeen) other;
        return C12238m.areEqual(this.feedItemType, trackFeedItemSeen.feedItemType) && C12238m.areEqual(this.loadId, trackFeedItemSeen.loadId) && C12238m.areEqual(this.messageId, trackFeedItemSeen.messageId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackFeedItemSeen(feedItemType=");
        sbM833U.append(this.feedItemType);
        sbM833U.append(", loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", messageId=");
        return C1643a.m819G(sbM833U, this.messageId, ")");
    }
}
