package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackVoiceChannelInviteSent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVoiceChannelInviteSent implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long recipientId = null;
    private final Long inviteGuildId = null;
    private final Long inviteChannelId = null;
    private final CharSequence entryPoint = null;
    private final transient String analyticsSchemaTypeName = "voice_channel_invite_sent";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVoiceChannelInviteSent)) {
            return false;
        }
        TrackVoiceChannelInviteSent trackVoiceChannelInviteSent = (TrackVoiceChannelInviteSent) other;
        return Intrinsics3.areEqual(this.recipientId, trackVoiceChannelInviteSent.recipientId) && Intrinsics3.areEqual(this.inviteGuildId, trackVoiceChannelInviteSent.inviteGuildId) && Intrinsics3.areEqual(this.inviteChannelId, trackVoiceChannelInviteSent.inviteChannelId) && Intrinsics3.areEqual(this.entryPoint, trackVoiceChannelInviteSent.entryPoint);
    }

    public int hashCode() {
        Long l = this.recipientId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.inviteGuildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.inviteChannelId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.entryPoint;
        return iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVoiceChannelInviteSent(recipientId=");
        sbU.append(this.recipientId);
        sbU.append(", inviteGuildId=");
        sbU.append(this.inviteGuildId);
        sbU.append(", inviteChannelId=");
        sbU.append(this.inviteChannelId);
        sbU.append(", entryPoint=");
        return outline.E(sbU, this.entryPoint, ")");
    }
}
