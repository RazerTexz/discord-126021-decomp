package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSiteReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

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
        return m.areEqual(this.discriminator, trackFriendRequestFailed.discriminator) && m.areEqual(this.email, trackFriendRequestFailed.email) && m.areEqual(this.reason, trackFriendRequestFailed.reason) && m.areEqual(this.username, trackFriendRequestFailed.username) && m.areEqual(this.discrimLen, trackFriendRequestFailed.discrimLen) && m.areEqual(this.usernameLen, trackFriendRequestFailed.usernameLen) && m.areEqual(this.isEmailLike, trackFriendRequestFailed.isEmailLike) && m.areEqual(this.isInviteLike, trackFriendRequestFailed.isInviteLike) && m.areEqual(this.isNumOnly, trackFriendRequestFailed.isNumOnly) && m.areEqual(this.query, trackFriendRequestFailed.query);
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
        StringBuilder sbU = a.U("TrackFriendRequestFailed(discriminator=");
        sbU.append(this.discriminator);
        sbU.append(", email=");
        sbU.append(this.email);
        sbU.append(", reason=");
        sbU.append(this.reason);
        sbU.append(", username=");
        sbU.append(this.username);
        sbU.append(", discrimLen=");
        sbU.append(this.discrimLen);
        sbU.append(", usernameLen=");
        sbU.append(this.usernameLen);
        sbU.append(", isEmailLike=");
        sbU.append(this.isEmailLike);
        sbU.append(", isInviteLike=");
        sbU.append(this.isInviteLike);
        sbU.append(", isNumOnly=");
        sbU.append(this.isNumOnly);
        sbU.append(", query=");
        return a.E(sbU, this.query, ")");
    }
}
