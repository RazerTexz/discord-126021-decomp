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
        if (!(other instanceof TrackFeedItemInteracted)) {
            return false;
        }
        TrackFeedItemInteracted trackFeedItemInteracted = (TrackFeedItemInteracted) other;
        return C12238m.areEqual(this.feedItemType, trackFeedItemInteracted.feedItemType) && C12238m.areEqual(this.loadId, trackFeedItemInteracted.loadId) && C12238m.areEqual(this.actionType, trackFeedItemInteracted.actionType) && C12238m.areEqual(this.messageId, trackFeedItemInteracted.messageId) && C12238m.areEqual(this.homeSessionId, trackFeedItemInteracted.homeSessionId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackFeedItemInteracted(feedItemType=");
        sbM833U.append(this.feedItemType);
        sbM833U.append(", loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", actionType=");
        sbM833U.append(this.actionType);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", homeSessionId=");
        return C1643a.m817E(sbM833U, this.homeSessionId, ")");
    }
}
