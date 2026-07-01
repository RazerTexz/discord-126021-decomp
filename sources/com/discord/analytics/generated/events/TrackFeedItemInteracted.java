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

/* JADX INFO: compiled from: TrackFeedItemInteracted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackFeedItemInteracted implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence feedItemType = null;
    private final CharSequence loadId = null;
    private final CharSequence actionType = null;
    private final Long messageId = null;
    private final CharSequence homeSessionId = null;
    private final transient String analyticsSchemaTypeName = "feed_item_interacted";

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
        if (!(other instanceof TrackFeedItemInteracted)) {
            return false;
        }
        TrackFeedItemInteracted trackFeedItemInteracted = (TrackFeedItemInteracted) other;
        return Intrinsics3.areEqual(this.feedItemType, trackFeedItemInteracted.feedItemType) && Intrinsics3.areEqual(this.loadId, trackFeedItemInteracted.loadId) && Intrinsics3.areEqual(this.actionType, trackFeedItemInteracted.actionType) && Intrinsics3.areEqual(this.messageId, trackFeedItemInteracted.messageId) && Intrinsics3.areEqual(this.homeSessionId, trackFeedItemInteracted.homeSessionId);
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
        StringBuilder sbU = outline.U("TrackFeedItemInteracted(feedItemType=");
        sbU.append(this.feedItemType);
        sbU.append(", loadId=");
        sbU.append(this.loadId);
        sbU.append(", actionType=");
        sbU.append(this.actionType);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", homeSessionId=");
        return outline.E(sbU, this.homeSessionId, ")");
    }
}
