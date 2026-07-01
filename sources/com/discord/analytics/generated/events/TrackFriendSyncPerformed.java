package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackFriendSyncPerformed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackFriendSyncPerformed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean isBackgroundSync = null;
    private final CharSequence platformType = null;
    private final Long numExternalFriendsAdded = null;
    private final Long numExternalFriendsRemoved = null;
    private final Long numSuggestionsMutual = null;
    private final Long numReverseSuggestionsMutual = null;
    private final Long numSuggestionsNonmutual = null;
    private final Long numReverseSuggestionsNonmutual = null;
    private final Long uploadedContactsLength = null;
    private final Long externalFriendListLength = null;
    private final Boolean friendSyncEnabled = null;
    private final transient String analyticsSchemaTypeName = "friend_sync_performed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackFriendSyncPerformed)) {
            return false;
        }
        TrackFriendSyncPerformed trackFriendSyncPerformed = (TrackFriendSyncPerformed) other;
        return Intrinsics3.areEqual(this.isBackgroundSync, trackFriendSyncPerformed.isBackgroundSync) && Intrinsics3.areEqual(this.platformType, trackFriendSyncPerformed.platformType) && Intrinsics3.areEqual(this.numExternalFriendsAdded, trackFriendSyncPerformed.numExternalFriendsAdded) && Intrinsics3.areEqual(this.numExternalFriendsRemoved, trackFriendSyncPerformed.numExternalFriendsRemoved) && Intrinsics3.areEqual(this.numSuggestionsMutual, trackFriendSyncPerformed.numSuggestionsMutual) && Intrinsics3.areEqual(this.numReverseSuggestionsMutual, trackFriendSyncPerformed.numReverseSuggestionsMutual) && Intrinsics3.areEqual(this.numSuggestionsNonmutual, trackFriendSyncPerformed.numSuggestionsNonmutual) && Intrinsics3.areEqual(this.numReverseSuggestionsNonmutual, trackFriendSyncPerformed.numReverseSuggestionsNonmutual) && Intrinsics3.areEqual(this.uploadedContactsLength, trackFriendSyncPerformed.uploadedContactsLength) && Intrinsics3.areEqual(this.externalFriendListLength, trackFriendSyncPerformed.externalFriendListLength) && Intrinsics3.areEqual(this.friendSyncEnabled, trackFriendSyncPerformed.friendSyncEnabled);
    }

    public int hashCode() {
        Boolean bool = this.isBackgroundSync;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.platformType;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l = this.numExternalFriendsAdded;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numExternalFriendsRemoved;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numSuggestionsMutual;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numReverseSuggestionsMutual;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.numSuggestionsNonmutual;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.numReverseSuggestionsNonmutual;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.uploadedContactsLength;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.externalFriendListLength;
        int iHashCode10 = (iHashCode9 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Boolean bool2 = this.friendSyncEnabled;
        return iHashCode10 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackFriendSyncPerformed(isBackgroundSync=");
        sbU.append(this.isBackgroundSync);
        sbU.append(", platformType=");
        sbU.append(this.platformType);
        sbU.append(", numExternalFriendsAdded=");
        sbU.append(this.numExternalFriendsAdded);
        sbU.append(", numExternalFriendsRemoved=");
        sbU.append(this.numExternalFriendsRemoved);
        sbU.append(", numSuggestionsMutual=");
        sbU.append(this.numSuggestionsMutual);
        sbU.append(", numReverseSuggestionsMutual=");
        sbU.append(this.numReverseSuggestionsMutual);
        sbU.append(", numSuggestionsNonmutual=");
        sbU.append(this.numSuggestionsNonmutual);
        sbU.append(", numReverseSuggestionsNonmutual=");
        sbU.append(this.numReverseSuggestionsNonmutual);
        sbU.append(", uploadedContactsLength=");
        sbU.append(this.uploadedContactsLength);
        sbU.append(", externalFriendListLength=");
        sbU.append(this.externalFriendListLength);
        sbU.append(", friendSyncEnabled=");
        return outline.D(sbU, this.friendSyncEnabled, ")");
    }
}
