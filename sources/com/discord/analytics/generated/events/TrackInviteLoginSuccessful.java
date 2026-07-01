package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackInviteLoginSuccessful.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackInviteLoginSuccessful implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence inviteCode = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long inviterId = null;
    private final Long prevUserId = null;
    private final transient String analyticsSchemaTypeName = "invite_login_successful";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackInviteLoginSuccessful)) {
            return false;
        }
        TrackInviteLoginSuccessful trackInviteLoginSuccessful = (TrackInviteLoginSuccessful) other;
        return Intrinsics3.areEqual(this.inviteCode, trackInviteLoginSuccessful.inviteCode) && Intrinsics3.areEqual(this.guildId, trackInviteLoginSuccessful.guildId) && Intrinsics3.areEqual(this.channelId, trackInviteLoginSuccessful.channelId) && Intrinsics3.areEqual(this.inviterId, trackInviteLoginSuccessful.inviterId) && Intrinsics3.areEqual(this.prevUserId, trackInviteLoginSuccessful.prevUserId);
    }

    public int hashCode() {
        CharSequence charSequence = this.inviteCode;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.guildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.inviterId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.prevUserId;
        return iHashCode4 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackInviteLoginSuccessful(inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", inviterId=");
        sbU.append(this.inviterId);
        sbU.append(", prevUserId=");
        return outline.G(sbU, this.prevUserId, ")");
    }
}
