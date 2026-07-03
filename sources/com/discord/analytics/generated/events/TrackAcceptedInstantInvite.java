package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackAcceptedInstantInvite.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAcceptedInstantInvite implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long channel = null;
    private final Long channelType = null;
    private final Boolean custom = null;
    private final Long guild = null;
    private final Long guildOwner = null;
    private final Long ownerId = null;
    private final CharSequence invite = null;
    private final Long inviter = null;
    private final Long userDay = null;
    private final Long userGuilds = null;
    private final Long locationGuildId = null;
    private final Long locationChannelId = null;
    private final Long locationChannelType = null;
    private final Long locationMessageId = null;
    private final Long guildSizeTotal = null;
    private final Long guildSizeOnline = null;
    private final Long sizeTotal = null;
    private final Long sizeOnline = null;
    private final CharSequence inviteType = null;
    private final Long destinationUserId = null;
    private final Long guildVerificationLevel = null;
    private final Boolean hasMutualGuild = null;
    private final Long inviteGuildScheduledEventId = null;
    private final transient String analyticsSchemaTypeName = "accepted_instant_invite";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAcceptedInstantInvite)) {
            return false;
        }
        TrackAcceptedInstantInvite trackAcceptedInstantInvite = (TrackAcceptedInstantInvite) other;
        return C12238m.areEqual(this.channel, trackAcceptedInstantInvite.channel) && C12238m.areEqual(this.channelType, trackAcceptedInstantInvite.channelType) && C12238m.areEqual(this.custom, trackAcceptedInstantInvite.custom) && C12238m.areEqual(this.guild, trackAcceptedInstantInvite.guild) && C12238m.areEqual(this.guildOwner, trackAcceptedInstantInvite.guildOwner) && C12238m.areEqual(this.ownerId, trackAcceptedInstantInvite.ownerId) && C12238m.areEqual(this.invite, trackAcceptedInstantInvite.invite) && C12238m.areEqual(this.inviter, trackAcceptedInstantInvite.inviter) && C12238m.areEqual(this.userDay, trackAcceptedInstantInvite.userDay) && C12238m.areEqual(this.userGuilds, trackAcceptedInstantInvite.userGuilds) && C12238m.areEqual(this.locationGuildId, trackAcceptedInstantInvite.locationGuildId) && C12238m.areEqual(this.locationChannelId, trackAcceptedInstantInvite.locationChannelId) && C12238m.areEqual(this.locationChannelType, trackAcceptedInstantInvite.locationChannelType) && C12238m.areEqual(this.locationMessageId, trackAcceptedInstantInvite.locationMessageId) && C12238m.areEqual(this.guildSizeTotal, trackAcceptedInstantInvite.guildSizeTotal) && C12238m.areEqual(this.guildSizeOnline, trackAcceptedInstantInvite.guildSizeOnline) && C12238m.areEqual(this.sizeTotal, trackAcceptedInstantInvite.sizeTotal) && C12238m.areEqual(this.sizeOnline, trackAcceptedInstantInvite.sizeOnline) && C12238m.areEqual(this.inviteType, trackAcceptedInstantInvite.inviteType) && C12238m.areEqual(this.destinationUserId, trackAcceptedInstantInvite.destinationUserId) && C12238m.areEqual(this.guildVerificationLevel, trackAcceptedInstantInvite.guildVerificationLevel) && C12238m.areEqual(this.hasMutualGuild, trackAcceptedInstantInvite.hasMutualGuild) && C12238m.areEqual(this.inviteGuildScheduledEventId, trackAcceptedInstantInvite.inviteGuildScheduledEventId);
    }

    public int hashCode() {
        Long l = this.channel;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.custom;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l3 = this.guild;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildOwner;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.ownerId;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        CharSequence charSequence = this.invite;
        int iHashCode7 = (iHashCode6 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l6 = this.inviter;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.userDay;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.userGuilds;
        int iHashCode10 = (iHashCode9 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.locationGuildId;
        int iHashCode11 = (iHashCode10 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.locationChannelId;
        int iHashCode12 = (iHashCode11 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.locationChannelType;
        int iHashCode13 = (iHashCode12 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.locationMessageId;
        int iHashCode14 = (iHashCode13 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.guildSizeTotal;
        int iHashCode15 = (iHashCode14 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.guildSizeOnline;
        int iHashCode16 = (iHashCode15 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.sizeTotal;
        int iHashCode17 = (iHashCode16 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.sizeOnline;
        int iHashCode18 = (iHashCode17 + (l16 != null ? l16.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.inviteType;
        int iHashCode19 = (iHashCode18 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l17 = this.destinationUserId;
        int iHashCode20 = (iHashCode19 + (l17 != null ? l17.hashCode() : 0)) * 31;
        Long l18 = this.guildVerificationLevel;
        int iHashCode21 = (iHashCode20 + (l18 != null ? l18.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasMutualGuild;
        int iHashCode22 = (iHashCode21 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l19 = this.inviteGuildScheduledEventId;
        return iHashCode22 + (l19 != null ? l19.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackAcceptedInstantInvite(channel=");
        sbM833U.append(this.channel);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", custom=");
        sbM833U.append(this.custom);
        sbM833U.append(", guild=");
        sbM833U.append(this.guild);
        sbM833U.append(", guildOwner=");
        sbM833U.append(this.guildOwner);
        sbM833U.append(", ownerId=");
        sbM833U.append(this.ownerId);
        sbM833U.append(", invite=");
        sbM833U.append(this.invite);
        sbM833U.append(", inviter=");
        sbM833U.append(this.inviter);
        sbM833U.append(", userDay=");
        sbM833U.append(this.userDay);
        sbM833U.append(", userGuilds=");
        sbM833U.append(this.userGuilds);
        sbM833U.append(", locationGuildId=");
        sbM833U.append(this.locationGuildId);
        sbM833U.append(", locationChannelId=");
        sbM833U.append(this.locationChannelId);
        sbM833U.append(", locationChannelType=");
        sbM833U.append(this.locationChannelType);
        sbM833U.append(", locationMessageId=");
        sbM833U.append(this.locationMessageId);
        sbM833U.append(", guildSizeTotal=");
        sbM833U.append(this.guildSizeTotal);
        sbM833U.append(", guildSizeOnline=");
        sbM833U.append(this.guildSizeOnline);
        sbM833U.append(", sizeTotal=");
        sbM833U.append(this.sizeTotal);
        sbM833U.append(", sizeOnline=");
        sbM833U.append(this.sizeOnline);
        sbM833U.append(", inviteType=");
        sbM833U.append(this.inviteType);
        sbM833U.append(", destinationUserId=");
        sbM833U.append(this.destinationUserId);
        sbM833U.append(", guildVerificationLevel=");
        sbM833U.append(this.guildVerificationLevel);
        sbM833U.append(", hasMutualGuild=");
        sbM833U.append(this.hasMutualGuild);
        sbM833U.append(", inviteGuildScheduledEventId=");
        return C1643a.m819G(sbM833U, this.inviteGuildScheduledEventId, ")");
    }
}
