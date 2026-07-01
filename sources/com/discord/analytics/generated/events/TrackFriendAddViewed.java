package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackFriendAddViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackFriendAddViewed implements AnalyticsSchema, TrackBaseReceiver, TrackSourceMetadataReceiver {
    private TrackBase trackBase;
    private TrackSourceMetadata trackSourceMetadata;
    private final Long suggestionCount = null;
    private final CharSequence friendAddType = null;
    private final transient String analyticsSchemaTypeName = "friend_add_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackFriendAddViewed)) {
            return false;
        }
        TrackFriendAddViewed trackFriendAddViewed = (TrackFriendAddViewed) other;
        return m.areEqual(this.suggestionCount, trackFriendAddViewed.suggestionCount) && m.areEqual(this.friendAddType, trackFriendAddViewed.friendAddType);
    }

    public int hashCode() {
        Long l = this.suggestionCount;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.friendAddType;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackFriendAddViewed(suggestionCount=");
        sbU.append(this.suggestionCount);
        sbU.append(", friendAddType=");
        return a.E(sbU, this.friendAddType, ")");
    }
}
