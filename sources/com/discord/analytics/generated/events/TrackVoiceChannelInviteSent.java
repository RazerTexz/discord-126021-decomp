package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackVoiceChannelInviteSent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVoiceChannelInviteSent implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long recipientId = null;
    private final Long inviteGuildId = null;
    private final Long inviteChannelId = null;
    private final CharSequence entryPoint = null;
    private final transient String analyticsSchemaTypeName = "voice_channel_invite_sent";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
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
        return C12238m.areEqual(this.recipientId, trackVoiceChannelInviteSent.recipientId) && C12238m.areEqual(this.inviteGuildId, trackVoiceChannelInviteSent.inviteGuildId) && C12238m.areEqual(this.inviteChannelId, trackVoiceChannelInviteSent.inviteChannelId) && C12238m.areEqual(this.entryPoint, trackVoiceChannelInviteSent.entryPoint);
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
        StringBuilder sbM833U = C1643a.m833U("TrackVoiceChannelInviteSent(recipientId=");
        sbM833U.append(this.recipientId);
        sbM833U.append(", inviteGuildId=");
        sbM833U.append(this.inviteGuildId);
        sbM833U.append(", inviteChannelId=");
        sbM833U.append(this.inviteChannelId);
        sbM833U.append(", entryPoint=");
        return C1643a.m817E(sbM833U, this.entryPoint, ")");
    }
}
