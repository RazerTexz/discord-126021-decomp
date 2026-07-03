package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSiteReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackFriendRequestFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackFriendRequestFailed implements AnalyticsSchema, TrackBaseReceiver, TrackMarketingSiteReceiver {
    private TrackBase trackBase;
    private TrackMarketingSite trackMarketingSite;
    private final Long discriminator = null;
    private final CharSequence email = null;
    private final CharSequence reason = null;
    private final CharSequence username = null;
    private final Long discrimLen = null;
    private final Long usernameLen = null;
    private final Boolean isEmailLike = null;
    private final Boolean isInviteLike = null;
    private final Boolean isNumOnly = null;
    private final CharSequence query = null;
    private final transient String analyticsSchemaTypeName = "friend_request_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackFriendRequestFailed)) {
            return false;
        }
        TrackFriendRequestFailed trackFriendRequestFailed = (TrackFriendRequestFailed) other;
        return C12238m.areEqual(this.discriminator, trackFriendRequestFailed.discriminator) && C12238m.areEqual(this.email, trackFriendRequestFailed.email) && C12238m.areEqual(this.reason, trackFriendRequestFailed.reason) && C12238m.areEqual(this.username, trackFriendRequestFailed.username) && C12238m.areEqual(this.discrimLen, trackFriendRequestFailed.discrimLen) && C12238m.areEqual(this.usernameLen, trackFriendRequestFailed.usernameLen) && C12238m.areEqual(this.isEmailLike, trackFriendRequestFailed.isEmailLike) && C12238m.areEqual(this.isInviteLike, trackFriendRequestFailed.isInviteLike) && C12238m.areEqual(this.isNumOnly, trackFriendRequestFailed.isNumOnly) && C12238m.areEqual(this.query, trackFriendRequestFailed.query);
    }

    public int hashCode() {
        Long l = this.discriminator;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.email;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.reason;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.username;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l2 = this.discrimLen;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.usernameLen;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.isEmailLike;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isInviteLike;
        int iHashCode8 = (iHashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isNumOnly;
        int iHashCode9 = (iHashCode8 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.query;
        return iHashCode9 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackFriendRequestFailed(discriminator=");
        sbM833U.append(this.discriminator);
        sbM833U.append(", email=");
        sbM833U.append(this.email);
        sbM833U.append(", reason=");
        sbM833U.append(this.reason);
        sbM833U.append(", username=");
        sbM833U.append(this.username);
        sbM833U.append(", discrimLen=");
        sbM833U.append(this.discrimLen);
        sbM833U.append(", usernameLen=");
        sbM833U.append(this.usernameLen);
        sbM833U.append(", isEmailLike=");
        sbM833U.append(this.isEmailLike);
        sbM833U.append(", isInviteLike=");
        sbM833U.append(this.isInviteLike);
        sbM833U.append(", isNumOnly=");
        sbM833U.append(this.isNumOnly);
        sbM833U.append(", query=");
        return C1643a.m817E(sbM833U, this.query, ")");
    }
}
