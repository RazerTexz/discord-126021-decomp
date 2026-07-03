package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.suggestionCount, trackFriendAddViewed.suggestionCount) && C12238m.areEqual(this.friendAddType, trackFriendAddViewed.friendAddType);
    }

    public int hashCode() {
        Long l = this.suggestionCount;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.friendAddType;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackFriendAddViewed(suggestionCount=");
        sbM833U.append(this.suggestionCount);
        sbM833U.append(", friendAddType=");
        return C1643a.m817E(sbM833U, this.friendAddType, ")");
    }
}
