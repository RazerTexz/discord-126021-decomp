package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackInviteLoginSuccessful.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackInviteLoginSuccessful implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.inviteCode, trackInviteLoginSuccessful.inviteCode) && C12238m.areEqual(this.guildId, trackInviteLoginSuccessful.guildId) && C12238m.areEqual(this.channelId, trackInviteLoginSuccessful.channelId) && C12238m.areEqual(this.inviterId, trackInviteLoginSuccessful.inviterId) && C12238m.areEqual(this.prevUserId, trackInviteLoginSuccessful.prevUserId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackInviteLoginSuccessful(inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", inviterId=");
        sbM833U.append(this.inviterId);
        sbM833U.append(", prevUserId=");
        return C1643a.m819G(sbM833U, this.prevUserId, ")");
    }
}
