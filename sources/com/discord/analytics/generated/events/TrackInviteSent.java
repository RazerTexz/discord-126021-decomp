package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        if (!(other instanceof TrackInviteSent)) {
            return false;
        }
        TrackInviteSent trackInviteSent = (TrackInviteSent) other;
        return C12238m.areEqual(this.inviteType, trackInviteSent.inviteType) && C12238m.areEqual(this.inviteCode, trackInviteSent.inviteCode) && C12238m.areEqual(this.messageId, trackInviteSent.messageId) && C12238m.areEqual(this.inviteGuildId, trackInviteSent.inviteGuildId) && C12238m.areEqual(this.inviteChannelId, trackInviteSent.inviteChannelId) && C12238m.areEqual(this.inviteChannelType, trackInviteSent.inviteChannelType) && C12238m.areEqual(this.inviteInviterId, trackInviteSent.inviteInviterId) && C12238m.areEqual(this.applicationId, trackInviteSent.applicationId) && C12238m.areEqual(this.destinationUserId, trackInviteSent.destinationUserId) && C12238m.areEqual(this.isSuggested, trackInviteSent.isSuggested) && C12238m.areEqual(this.rowNum, trackInviteSent.rowNum) && C12238m.areEqual(this.numTotal, trackInviteSent.numTotal) && C12238m.areEqual(this.numAffinityConnections, trackInviteSent.numAffinityConnections) && C12238m.areEqual(this.isFiltered, trackInviteSent.isFiltered) && C12238m.areEqual(this.numSelected, trackInviteSent.numSelected) && C12238m.areEqual(this.sendType, trackInviteSent.sendType) && C12238m.areEqual(this.inviteGuildScheduledEventId, trackInviteSent.inviteGuildScheduledEventId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackInviteSent(inviteType=");
        sbM833U.append(this.inviteType);
        sbM833U.append(", inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", inviteGuildId=");
        sbM833U.append(this.inviteGuildId);
        sbM833U.append(", inviteChannelId=");
        sbM833U.append(this.inviteChannelId);
        sbM833U.append(", inviteChannelType=");
        sbM833U.append(this.inviteChannelType);
        sbM833U.append(", inviteInviterId=");
        sbM833U.append(this.inviteInviterId);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", destinationUserId=");
        sbM833U.append(this.destinationUserId);
        sbM833U.append(", isSuggested=");
        sbM833U.append(this.isSuggested);
        sbM833U.append(", rowNum=");
        sbM833U.append(this.rowNum);
        sbM833U.append(", numTotal=");
        sbM833U.append(this.numTotal);
        sbM833U.append(", numAffinityConnections=");
        sbM833U.append(this.numAffinityConnections);
        sbM833U.append(", isFiltered=");
        sbM833U.append(this.isFiltered);
        sbM833U.append(", numSelected=");
        sbM833U.append(this.numSelected);
        sbM833U.append(", sendType=");
        sbM833U.append(this.sendType);
        sbM833U.append(", inviteGuildScheduledEventId=");
        return C1643a.m819G(sbM833U, this.inviteGuildScheduledEventId, ")");
    }
}
