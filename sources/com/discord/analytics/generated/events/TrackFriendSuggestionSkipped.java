package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackFriendSuggestionSkipped.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackFriendSuggestionSkipped implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long suggestedUserId = null;
    private final CharSequence platformType = null;
    private final Boolean isNonMutual = null;
    private final Boolean isReverseSuggestion = null;
    private final Long existingRelationshipType = null;
    private final Long userAllowedInSuggestions = null;
    private final Boolean userConsents = null;
    private final Boolean userIsDiscoverable = null;
    private final Long otherUserAllowedInSuggestions = null;
    private final Boolean otherUserConsents = null;
    private final Boolean otherUserDiscoverable = null;
    private final transient String analyticsSchemaTypeName = "friend_suggestion_skipped";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackFriendSuggestionSkipped)) {
            return false;
        }
        TrackFriendSuggestionSkipped trackFriendSuggestionSkipped = (TrackFriendSuggestionSkipped) other;
        return C12238m.areEqual(this.suggestedUserId, trackFriendSuggestionSkipped.suggestedUserId) && C12238m.areEqual(this.platformType, trackFriendSuggestionSkipped.platformType) && C12238m.areEqual(this.isNonMutual, trackFriendSuggestionSkipped.isNonMutual) && C12238m.areEqual(this.isReverseSuggestion, trackFriendSuggestionSkipped.isReverseSuggestion) && C12238m.areEqual(this.existingRelationshipType, trackFriendSuggestionSkipped.existingRelationshipType) && C12238m.areEqual(this.userAllowedInSuggestions, trackFriendSuggestionSkipped.userAllowedInSuggestions) && C12238m.areEqual(this.userConsents, trackFriendSuggestionSkipped.userConsents) && C12238m.areEqual(this.userIsDiscoverable, trackFriendSuggestionSkipped.userIsDiscoverable) && C12238m.areEqual(this.otherUserAllowedInSuggestions, trackFriendSuggestionSkipped.otherUserAllowedInSuggestions) && C12238m.areEqual(this.otherUserConsents, trackFriendSuggestionSkipped.otherUserConsents) && C12238m.areEqual(this.otherUserDiscoverable, trackFriendSuggestionSkipped.otherUserDiscoverable);
    }

    public int hashCode() {
        Long l = this.suggestedUserId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.platformType;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.isNonMutual;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isReverseSuggestion;
        int iHashCode4 = (iHashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l2 = this.existingRelationshipType;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.userAllowedInSuggestions;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool3 = this.userConsents;
        int iHashCode7 = (iHashCode6 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.userIsDiscoverable;
        int iHashCode8 = (iHashCode7 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Long l4 = this.otherUserAllowedInSuggestions;
        int iHashCode9 = (iHashCode8 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool5 = this.otherUserConsents;
        int iHashCode10 = (iHashCode9 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.otherUserDiscoverable;
        return iHashCode10 + (bool6 != null ? bool6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackFriendSuggestionSkipped(suggestedUserId=");
        sbM833U.append(this.suggestedUserId);
        sbM833U.append(", platformType=");
        sbM833U.append(this.platformType);
        sbM833U.append(", isNonMutual=");
        sbM833U.append(this.isNonMutual);
        sbM833U.append(", isReverseSuggestion=");
        sbM833U.append(this.isReverseSuggestion);
        sbM833U.append(", existingRelationshipType=");
        sbM833U.append(this.existingRelationshipType);
        sbM833U.append(", userAllowedInSuggestions=");
        sbM833U.append(this.userAllowedInSuggestions);
        sbM833U.append(", userConsents=");
        sbM833U.append(this.userConsents);
        sbM833U.append(", userIsDiscoverable=");
        sbM833U.append(this.userIsDiscoverable);
        sbM833U.append(", otherUserAllowedInSuggestions=");
        sbM833U.append(this.otherUserAllowedInSuggestions);
        sbM833U.append(", otherUserConsents=");
        sbM833U.append(this.otherUserConsents);
        sbM833U.append(", otherUserDiscoverable=");
        return C1643a.m816D(sbM833U, this.otherUserDiscoverable, ")");
    }
}
