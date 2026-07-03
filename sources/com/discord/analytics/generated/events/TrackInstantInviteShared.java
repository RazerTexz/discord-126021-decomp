package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackInstantInviteShared.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackInstantInviteShared implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Long channelId = null;
    private final CharSequence inviteCode = null;
    private final Long inviteChannelType = null;
    private final Long inviteInviterId = null;
    private final Long inviteGuildScheduledEventId = null;
    private final transient String analyticsSchemaTypeName = "instant_invite_shared";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackInstantInviteShared)) {
            return false;
        }
        TrackInstantInviteShared trackInstantInviteShared = (TrackInstantInviteShared) other;
        return C12238m.areEqual(this.guildId, trackInstantInviteShared.guildId) && C12238m.areEqual(this.channelId, trackInstantInviteShared.channelId) && C12238m.areEqual(this.inviteCode, trackInstantInviteShared.inviteCode) && C12238m.areEqual(this.inviteChannelType, trackInstantInviteShared.inviteChannelType) && C12238m.areEqual(this.inviteInviterId, trackInstantInviteShared.inviteInviterId) && C12238m.areEqual(this.inviteGuildScheduledEventId, trackInstantInviteShared.inviteGuildScheduledEventId);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.inviteCode;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l3 = this.inviteChannelType;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.inviteInviterId;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.inviteGuildScheduledEventId;
        return iHashCode5 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackInstantInviteShared(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", inviteChannelType=");
        sbM833U.append(this.inviteChannelType);
        sbM833U.append(", inviteInviterId=");
        sbM833U.append(this.inviteInviterId);
        sbM833U.append(", inviteGuildScheduledEventId=");
        return C1643a.m819G(sbM833U, this.inviteGuildScheduledEventId, ")");
    }
}
