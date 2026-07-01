package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackReceiveFriendSuggestion.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackReceiveFriendSuggestion implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long suggestedUserId = null;
    private final CharSequence platformType = null;
    private final Boolean isNonMutual = null;
    private final Boolean isReverseSuggestion = null;
    private final Boolean dispatched = null;
    private final Boolean pushNotificationSent = null;
    private final Boolean namePresent = null;
    private final transient String analyticsSchemaTypeName = "receive_friend_suggestion";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackReceiveFriendSuggestion)) {
            return false;
        }
        TrackReceiveFriendSuggestion trackReceiveFriendSuggestion = (TrackReceiveFriendSuggestion) other;
        return m.areEqual(this.suggestedUserId, trackReceiveFriendSuggestion.suggestedUserId) && m.areEqual(this.platformType, trackReceiveFriendSuggestion.platformType) && m.areEqual(this.isNonMutual, trackReceiveFriendSuggestion.isNonMutual) && m.areEqual(this.isReverseSuggestion, trackReceiveFriendSuggestion.isReverseSuggestion) && m.areEqual(this.dispatched, trackReceiveFriendSuggestion.dispatched) && m.areEqual(this.pushNotificationSent, trackReceiveFriendSuggestion.pushNotificationSent) && m.areEqual(this.namePresent, trackReceiveFriendSuggestion.namePresent);
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
        Boolean bool3 = this.dispatched;
        int iHashCode5 = (iHashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.pushNotificationSent;
        int iHashCode6 = (iHashCode5 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.namePresent;
        return iHashCode6 + (bool5 != null ? bool5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackReceiveFriendSuggestion(suggestedUserId=");
        sbU.append(this.suggestedUserId);
        sbU.append(", platformType=");
        sbU.append(this.platformType);
        sbU.append(", isNonMutual=");
        sbU.append(this.isNonMutual);
        sbU.append(", isReverseSuggestion=");
        sbU.append(this.isReverseSuggestion);
        sbU.append(", dispatched=");
        sbU.append(this.dispatched);
        sbU.append(", pushNotificationSent=");
        sbU.append(this.pushNotificationSent);
        sbU.append(", namePresent=");
        return a.D(sbU, this.namePresent, ")");
    }
}
