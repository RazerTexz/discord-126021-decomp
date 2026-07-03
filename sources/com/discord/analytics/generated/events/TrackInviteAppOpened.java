package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackInviteAppOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackInviteAppOpened implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence inviteCode = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long inviterId = null;
    private final Boolean hasUsername = null;
    private final transient String analyticsSchemaTypeName = "invite_app_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackInviteAppOpened)) {
            return false;
        }
        TrackInviteAppOpened trackInviteAppOpened = (TrackInviteAppOpened) other;
        return C12238m.areEqual(this.inviteCode, trackInviteAppOpened.inviteCode) && C12238m.areEqual(this.guildId, trackInviteAppOpened.guildId) && C12238m.areEqual(this.channelId, trackInviteAppOpened.channelId) && C12238m.areEqual(this.inviterId, trackInviteAppOpened.inviterId) && C12238m.areEqual(this.hasUsername, trackInviteAppOpened.hasUsername);
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
        Boolean bool = this.hasUsername;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackInviteAppOpened(inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", inviterId=");
        sbM833U.append(this.inviterId);
        sbM833U.append(", hasUsername=");
        return C1643a.m816D(sbM833U, this.hasUsername, ")");
    }
}
