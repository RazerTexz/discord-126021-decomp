package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackFriendsListViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackFriendsListViewed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence tabOpened = null;
    private final Long numFriends = null;
    private final Long numOutgoingRequests = null;
    private final Long numIncomingRequests = null;
    private final Long numSuggestions = null;
    private final Boolean wasDismissed = null;
    private final Boolean contactSyncIsEnabled = null;
    private final Boolean isDiscoverableEmail = null;
    private final Boolean isDiscoverablePhone = null;
    private final transient String analyticsSchemaTypeName = "friends_list_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackFriendsListViewed)) {
            return false;
        }
        TrackFriendsListViewed trackFriendsListViewed = (TrackFriendsListViewed) other;
        return Intrinsics3.areEqual(this.tabOpened, trackFriendsListViewed.tabOpened) && Intrinsics3.areEqual(this.numFriends, trackFriendsListViewed.numFriends) && Intrinsics3.areEqual(this.numOutgoingRequests, trackFriendsListViewed.numOutgoingRequests) && Intrinsics3.areEqual(this.numIncomingRequests, trackFriendsListViewed.numIncomingRequests) && Intrinsics3.areEqual(this.numSuggestions, trackFriendsListViewed.numSuggestions) && Intrinsics3.areEqual(this.wasDismissed, trackFriendsListViewed.wasDismissed) && Intrinsics3.areEqual(this.contactSyncIsEnabled, trackFriendsListViewed.contactSyncIsEnabled) && Intrinsics3.areEqual(this.isDiscoverableEmail, trackFriendsListViewed.isDiscoverableEmail) && Intrinsics3.areEqual(this.isDiscoverablePhone, trackFriendsListViewed.isDiscoverablePhone);
    }

    public int hashCode() {
        CharSequence charSequence = this.tabOpened;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.numFriends;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numOutgoingRequests;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numIncomingRequests;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numSuggestions;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool = this.wasDismissed;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.contactSyncIsEnabled;
        int iHashCode7 = (iHashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isDiscoverableEmail;
        int iHashCode8 = (iHashCode7 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.isDiscoverablePhone;
        return iHashCode8 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackFriendsListViewed(tabOpened=");
        sbU.append(this.tabOpened);
        sbU.append(", numFriends=");
        sbU.append(this.numFriends);
        sbU.append(", numOutgoingRequests=");
        sbU.append(this.numOutgoingRequests);
        sbU.append(", numIncomingRequests=");
        sbU.append(this.numIncomingRequests);
        sbU.append(", numSuggestions=");
        sbU.append(this.numSuggestions);
        sbU.append(", wasDismissed=");
        sbU.append(this.wasDismissed);
        sbU.append(", contactSyncIsEnabled=");
        sbU.append(this.contactSyncIsEnabled);
        sbU.append(", isDiscoverableEmail=");
        sbU.append(this.isDiscoverableEmail);
        sbU.append(", isDiscoverablePhone=");
        return outline.D(sbU, this.isDiscoverablePhone, ")");
    }
}
