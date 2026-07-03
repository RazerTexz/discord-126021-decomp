package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackFeedItemSeenBatch.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackFeedItemSeenBatch implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final CharSequence loadId = null;
    private final List<CharSequence> feedItemIds = null;
    private final List<Long> additionalSeenTimeMillis = null;
    private final CharSequence homeSessionId = null;
    private final transient String analyticsSchemaTypeName = "feed_item_seen_batch";

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
        if (!(other instanceof TrackFeedItemSeenBatch)) {
            return false;
        }
        TrackFeedItemSeenBatch trackFeedItemSeenBatch = (TrackFeedItemSeenBatch) other;
        return C12238m.areEqual(this.loadId, trackFeedItemSeenBatch.loadId) && C12238m.areEqual(this.feedItemIds, trackFeedItemSeenBatch.feedItemIds) && C12238m.areEqual(this.additionalSeenTimeMillis, trackFeedItemSeenBatch.additionalSeenTimeMillis) && C12238m.areEqual(this.homeSessionId, trackFeedItemSeenBatch.homeSessionId);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<CharSequence> list = this.feedItemIds;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.additionalSeenTimeMillis;
        int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.homeSessionId;
        return iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackFeedItemSeenBatch(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", feedItemIds=");
        sbM833U.append(this.feedItemIds);
        sbM833U.append(", additionalSeenTimeMillis=");
        sbM833U.append(this.additionalSeenTimeMillis);
        sbM833U.append(", homeSessionId=");
        return C1643a.m817E(sbM833U, this.homeSessionId, ")");
    }
}
