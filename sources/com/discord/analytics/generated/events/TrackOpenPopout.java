package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackOpenPopout.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOpenPopout implements AnalyticsSchema, TrackBaseReceiver, TrackChannelReceiver, TrackLocationMetadataReceiver, TrackOverlayClientMetadataReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final CharSequence source = null;
    private final CharSequence type = null;
    private final Long otherUserId = null;
    private final Long applicationId = null;
    private final CharSequence applicationName = null;
    private final Long gameId = null;
    private final Boolean isFriend = null;
    private final Boolean hasImages = null;
    private final Long partyMax = null;
    private final CharSequence partyId = null;
    private final CharSequence partyPlatform = null;
    private final CharSequence gameName = null;
    private final CharSequence gamePlatform = null;
    private final Long skuId = null;
    private final CharSequence profileUserStatus = null;
    private final Boolean isStreaming = null;
    private final Boolean hasCustomStatus = null;
    private final Long guildId = null;
    private final Long emojiId = null;
    private final Long stickerId = null;
    private final Long stickerPackId = null;
    private final Boolean profileHasNitroCustomization = null;
    private final Boolean hasNickname = null;
    private final Boolean hasGuildMemberAvatar = null;
    private final Boolean hasGuildMemberBanner = null;
    private final Boolean hasGuildMemberBio = null;
    private final transient String analyticsSchemaTypeName = "open_popout";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOpenPopout)) {
            return false;
        }
        TrackOpenPopout trackOpenPopout = (TrackOpenPopout) other;
        return m.areEqual(this.source, trackOpenPopout.source) && m.areEqual(this.type, trackOpenPopout.type) && m.areEqual(this.otherUserId, trackOpenPopout.otherUserId) && m.areEqual(this.applicationId, trackOpenPopout.applicationId) && m.areEqual(this.applicationName, trackOpenPopout.applicationName) && m.areEqual(this.gameId, trackOpenPopout.gameId) && m.areEqual(this.isFriend, trackOpenPopout.isFriend) && m.areEqual(this.hasImages, trackOpenPopout.hasImages) && m.areEqual(this.partyMax, trackOpenPopout.partyMax) && m.areEqual(this.partyId, trackOpenPopout.partyId) && m.areEqual(this.partyPlatform, trackOpenPopout.partyPlatform) && m.areEqual(this.gameName, trackOpenPopout.gameName) && m.areEqual(this.gamePlatform, trackOpenPopout.gamePlatform) && m.areEqual(this.skuId, trackOpenPopout.skuId) && m.areEqual(this.profileUserStatus, trackOpenPopout.profileUserStatus) && m.areEqual(this.isStreaming, trackOpenPopout.isStreaming) && m.areEqual(this.hasCustomStatus, trackOpenPopout.hasCustomStatus) && m.areEqual(this.guildId, trackOpenPopout.guildId) && m.areEqual(this.emojiId, trackOpenPopout.emojiId) && m.areEqual(this.stickerId, trackOpenPopout.stickerId) && m.areEqual(this.stickerPackId, trackOpenPopout.stickerPackId) && m.areEqual(this.profileHasNitroCustomization, trackOpenPopout.profileHasNitroCustomization) && m.areEqual(this.hasNickname, trackOpenPopout.hasNickname) && m.areEqual(this.hasGuildMemberAvatar, trackOpenPopout.hasGuildMemberAvatar) && m.areEqual(this.hasGuildMemberBanner, trackOpenPopout.hasGuildMemberBanner) && m.areEqual(this.hasGuildMemberBio, trackOpenPopout.hasGuildMemberBio);
    }

    public int hashCode() {
        CharSequence charSequence = this.source;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.type;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.otherUserId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.applicationId;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.applicationName;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l3 = this.gameId;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.isFriend;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasImages;
        int iHashCode8 = (iHashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l4 = this.partyMax;
        int iHashCode9 = (iHashCode8 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.partyId;
        int iHashCode10 = (iHashCode9 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.partyPlatform;
        int iHashCode11 = (iHashCode10 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.gameName;
        int iHashCode12 = (iHashCode11 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.gamePlatform;
        int iHashCode13 = (iHashCode12 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        Long l5 = this.skuId;
        int iHashCode14 = (iHashCode13 + (l5 != null ? l5.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.profileUserStatus;
        int iHashCode15 = (iHashCode14 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        Boolean bool3 = this.isStreaming;
        int iHashCode16 = (iHashCode15 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.hasCustomStatus;
        int iHashCode17 = (iHashCode16 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Long l6 = this.guildId;
        int iHashCode18 = (iHashCode17 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.emojiId;
        int iHashCode19 = (iHashCode18 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.stickerId;
        int iHashCode20 = (iHashCode19 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.stickerPackId;
        int iHashCode21 = (iHashCode20 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Boolean bool5 = this.profileHasNitroCustomization;
        int iHashCode22 = (iHashCode21 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.hasNickname;
        int iHashCode23 = (iHashCode22 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Boolean bool7 = this.hasGuildMemberAvatar;
        int iHashCode24 = (iHashCode23 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        Boolean bool8 = this.hasGuildMemberBanner;
        int iHashCode25 = (iHashCode24 + (bool8 != null ? bool8.hashCode() : 0)) * 31;
        Boolean bool9 = this.hasGuildMemberBio;
        return iHashCode25 + (bool9 != null ? bool9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackOpenPopout(source=");
        sbU.append(this.source);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", otherUserId=");
        sbU.append(this.otherUserId);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", applicationName=");
        sbU.append(this.applicationName);
        sbU.append(", gameId=");
        sbU.append(this.gameId);
        sbU.append(", isFriend=");
        sbU.append(this.isFriend);
        sbU.append(", hasImages=");
        sbU.append(this.hasImages);
        sbU.append(", partyMax=");
        sbU.append(this.partyMax);
        sbU.append(", partyId=");
        sbU.append(this.partyId);
        sbU.append(", partyPlatform=");
        sbU.append(this.partyPlatform);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", gamePlatform=");
        sbU.append(this.gamePlatform);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", profileUserStatus=");
        sbU.append(this.profileUserStatus);
        sbU.append(", isStreaming=");
        sbU.append(this.isStreaming);
        sbU.append(", hasCustomStatus=");
        sbU.append(this.hasCustomStatus);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", emojiId=");
        sbU.append(this.emojiId);
        sbU.append(", stickerId=");
        sbU.append(this.stickerId);
        sbU.append(", stickerPackId=");
        sbU.append(this.stickerPackId);
        sbU.append(", profileHasNitroCustomization=");
        sbU.append(this.profileHasNitroCustomization);
        sbU.append(", hasNickname=");
        sbU.append(this.hasNickname);
        sbU.append(", hasGuildMemberAvatar=");
        sbU.append(this.hasGuildMemberAvatar);
        sbU.append(", hasGuildMemberBanner=");
        sbU.append(this.hasGuildMemberBanner);
        sbU.append(", hasGuildMemberBio=");
        return a.D(sbU, this.hasGuildMemberBio, ")");
    }
}
