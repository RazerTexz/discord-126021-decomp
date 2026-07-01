package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackInviteSent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackInviteSent implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver, TrackLocationMetadataReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence inviteType = null;
    private final CharSequence inviteCode = null;
    private final Long messageId = null;
    private final Long inviteGuildId = null;
    private final Long inviteChannelId = null;
    private final Long inviteChannelType = null;
    private final Long inviteInviterId = null;
    private final Long applicationId = null;
    private final Long destinationUserId = null;
    private final Boolean isSuggested = null;
    private final Long rowNum = null;
    private final Long numTotal = null;
    private final Long numAffinityConnections = null;
    private final Boolean isFiltered = null;
    private final Long numSelected = null;
    private final CharSequence sendType = null;
    private final Long inviteGuildScheduledEventId = null;
    private final transient String analyticsSchemaTypeName = "invite_sent";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
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
        if (!(other instanceof TrackInviteSent)) {
            return false;
        }
        TrackInviteSent trackInviteSent = (TrackInviteSent) other;
        return m.areEqual(this.inviteType, trackInviteSent.inviteType) && m.areEqual(this.inviteCode, trackInviteSent.inviteCode) && m.areEqual(this.messageId, trackInviteSent.messageId) && m.areEqual(this.inviteGuildId, trackInviteSent.inviteGuildId) && m.areEqual(this.inviteChannelId, trackInviteSent.inviteChannelId) && m.areEqual(this.inviteChannelType, trackInviteSent.inviteChannelType) && m.areEqual(this.inviteInviterId, trackInviteSent.inviteInviterId) && m.areEqual(this.applicationId, trackInviteSent.applicationId) && m.areEqual(this.destinationUserId, trackInviteSent.destinationUserId) && m.areEqual(this.isSuggested, trackInviteSent.isSuggested) && m.areEqual(this.rowNum, trackInviteSent.rowNum) && m.areEqual(this.numTotal, trackInviteSent.numTotal) && m.areEqual(this.numAffinityConnections, trackInviteSent.numAffinityConnections) && m.areEqual(this.isFiltered, trackInviteSent.isFiltered) && m.areEqual(this.numSelected, trackInviteSent.numSelected) && m.areEqual(this.sendType, trackInviteSent.sendType) && m.areEqual(this.inviteGuildScheduledEventId, trackInviteSent.inviteGuildScheduledEventId);
    }

    public int hashCode() {
        CharSequence charSequence = this.inviteType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.inviteCode;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.messageId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.inviteGuildId;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.inviteChannelId;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.inviteChannelType;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.inviteInviterId;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.applicationId;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.destinationUserId;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Boolean bool = this.isSuggested;
        int iHashCode10 = (iHashCode9 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l8 = this.rowNum;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.numTotal;
        int iHashCode12 = (iHashCode11 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.numAffinityConnections;
        int iHashCode13 = (iHashCode12 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Boolean bool2 = this.isFiltered;
        int iHashCode14 = (iHashCode13 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l11 = this.numSelected;
        int iHashCode15 = (iHashCode14 + (l11 != null ? l11.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.sendType;
        int iHashCode16 = (iHashCode15 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l12 = this.inviteGuildScheduledEventId;
        return iHashCode16 + (l12 != null ? l12.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackInviteSent(inviteType=");
        sbU.append(this.inviteType);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", inviteGuildId=");
        sbU.append(this.inviteGuildId);
        sbU.append(", inviteChannelId=");
        sbU.append(this.inviteChannelId);
        sbU.append(", inviteChannelType=");
        sbU.append(this.inviteChannelType);
        sbU.append(", inviteInviterId=");
        sbU.append(this.inviteInviterId);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", destinationUserId=");
        sbU.append(this.destinationUserId);
        sbU.append(", isSuggested=");
        sbU.append(this.isSuggested);
        sbU.append(", rowNum=");
        sbU.append(this.rowNum);
        sbU.append(", numTotal=");
        sbU.append(this.numTotal);
        sbU.append(", numAffinityConnections=");
        sbU.append(this.numAffinityConnections);
        sbU.append(", isFiltered=");
        sbU.append(this.isFiltered);
        sbU.append(", numSelected=");
        sbU.append(this.numSelected);
        sbU.append(", sendType=");
        sbU.append(this.sendType);
        sbU.append(", inviteGuildScheduledEventId=");
        return a.G(sbU, this.inviteGuildScheduledEventId, ")");
    }
}
