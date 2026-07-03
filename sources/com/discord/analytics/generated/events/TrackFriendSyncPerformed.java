package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackFriendSyncPerformed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackFriendSyncPerformed implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.isBackgroundSync, trackFriendSyncPerformed.isBackgroundSync) && C12238m.areEqual(this.platformType, trackFriendSyncPerformed.platformType) && C12238m.areEqual(this.numExternalFriendsAdded, trackFriendSyncPerformed.numExternalFriendsAdded) && C12238m.areEqual(this.numExternalFriendsRemoved, trackFriendSyncPerformed.numExternalFriendsRemoved) && C12238m.areEqual(this.numSuggestionsMutual, trackFriendSyncPerformed.numSuggestionsMutual) && C12238m.areEqual(this.numReverseSuggestionsMutual, trackFriendSyncPerformed.numReverseSuggestionsMutual) && C12238m.areEqual(this.numSuggestionsNonmutual, trackFriendSyncPerformed.numSuggestionsNonmutual) && C12238m.areEqual(this.numReverseSuggestionsNonmutual, trackFriendSyncPerformed.numReverseSuggestionsNonmutual) && C12238m.areEqual(this.uploadedContactsLength, trackFriendSyncPerformed.uploadedContactsLength) && C12238m.areEqual(this.externalFriendListLength, trackFriendSyncPerformed.externalFriendListLength) && C12238m.areEqual(this.friendSyncEnabled, trackFriendSyncPerformed.friendSyncEnabled);
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
        StringBuilder sbM833U = C1643a.m833U("TrackFriendSyncPerformed(isBackgroundSync=");
        sbM833U.append(this.isBackgroundSync);
        sbM833U.append(", platformType=");
        sbM833U.append(this.platformType);
        sbM833U.append(", numExternalFriendsAdded=");
        sbM833U.append(this.numExternalFriendsAdded);
        sbM833U.append(", numExternalFriendsRemoved=");
        sbM833U.append(this.numExternalFriendsRemoved);
        sbM833U.append(", numSuggestionsMutual=");
        sbM833U.append(this.numSuggestionsMutual);
        sbM833U.append(", numReverseSuggestionsMutual=");
        sbM833U.append(this.numReverseSuggestionsMutual);
        sbM833U.append(", numSuggestionsNonmutual=");
        sbM833U.append(this.numSuggestionsNonmutual);
        sbM833U.append(", numReverseSuggestionsNonmutual=");
        sbM833U.append(this.numReverseSuggestionsNonmutual);
        sbM833U.append(", uploadedContactsLength=");
        sbM833U.append(this.uploadedContactsLength);
        sbM833U.append(", externalFriendListLength=");
        sbM833U.append(this.externalFriendListLength);
        sbM833U.append(", friendSyncEnabled=");
        return C1643a.m816D(sbM833U, this.friendSyncEnabled, ")");
    }
}
