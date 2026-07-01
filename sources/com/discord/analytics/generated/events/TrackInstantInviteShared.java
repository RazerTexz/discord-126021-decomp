package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackInstantInviteShared.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackInstantInviteShared implements AnalyticsSchema, TrackBase2 {
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
        return Intrinsics3.areEqual(this.guildId, trackInstantInviteShared.guildId) && Intrinsics3.areEqual(this.channelId, trackInstantInviteShared.channelId) && Intrinsics3.areEqual(this.inviteCode, trackInstantInviteShared.inviteCode) && Intrinsics3.areEqual(this.inviteChannelType, trackInstantInviteShared.inviteChannelType) && Intrinsics3.areEqual(this.inviteInviterId, trackInstantInviteShared.inviteInviterId) && Intrinsics3.areEqual(this.inviteGuildScheduledEventId, trackInstantInviteShared.inviteGuildScheduledEventId);
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
        StringBuilder sbU = outline.U("TrackInstantInviteShared(guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", inviteChannelType=");
        sbU.append(this.inviteChannelType);
        sbU.append(", inviteInviterId=");
        sbU.append(this.inviteInviterId);
        sbU.append(", inviteGuildScheduledEventId=");
        return outline.G(sbU, this.inviteGuildScheduledEventId, ")");
    }
}
