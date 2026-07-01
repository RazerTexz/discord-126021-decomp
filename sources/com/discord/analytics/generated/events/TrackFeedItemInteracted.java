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

/* JADX INFO: compiled from: TrackFeedItemInteracted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackFeedItemInteracted implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence feedItemType = null;
    private final CharSequence loadId = null;
    private final CharSequence actionType = null;
    private final Long messageId = null;
    private final CharSequence homeSessionId = null;
    private final transient String analyticsSchemaTypeName = "feed_item_interacted";

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
        if (!(other instanceof TrackFeedItemInteracted)) {
            return false;
        }
        TrackFeedItemInteracted trackFeedItemInteracted = (TrackFeedItemInteracted) other;
        return m.areEqual(this.feedItemType, trackFeedItemInteracted.feedItemType) && m.areEqual(this.loadId, trackFeedItemInteracted.loadId) && m.areEqual(this.actionType, trackFeedItemInteracted.actionType) && m.areEqual(this.messageId, trackFeedItemInteracted.messageId) && m.areEqual(this.homeSessionId, trackFeedItemInteracted.homeSessionId);
    }

    public int hashCode() {
        CharSequence charSequence = this.feedItemType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.loadId;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.actionType;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.messageId;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.homeSessionId;
        return iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackFeedItemInteracted(feedItemType=");
        sbU.append(this.feedItemType);
        sbU.append(", loadId=");
        sbU.append(this.loadId);
        sbU.append(", actionType=");
        sbU.append(this.actionType);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", homeSessionId=");
        return a.E(sbU, this.homeSessionId, ")");
    }
}
