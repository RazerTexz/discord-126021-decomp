package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.source, trackOpenPopout.source) && C12238m.areEqual(this.type, trackOpenPopout.type) && C12238m.areEqual(this.otherUserId, trackOpenPopout.otherUserId) && C12238m.areEqual(this.applicationId, trackOpenPopout.applicationId) && C12238m.areEqual(this.applicationName, trackOpenPopout.applicationName) && C12238m.areEqual(this.gameId, trackOpenPopout.gameId) && C12238m.areEqual(this.isFriend, trackOpenPopout.isFriend) && C12238m.areEqual(this.hasImages, trackOpenPopout.hasImages) && C12238m.areEqual(this.partyMax, trackOpenPopout.partyMax) && C12238m.areEqual(this.partyId, trackOpenPopout.partyId) && C12238m.areEqual(this.partyPlatform, trackOpenPopout.partyPlatform) && C12238m.areEqual(this.gameName, trackOpenPopout.gameName) && C12238m.areEqual(this.gamePlatform, trackOpenPopout.gamePlatform) && C12238m.areEqual(this.skuId, trackOpenPopout.skuId) && C12238m.areEqual(this.profileUserStatus, trackOpenPopout.profileUserStatus) && C12238m.areEqual(this.isStreaming, trackOpenPopout.isStreaming) && C12238m.areEqual(this.hasCustomStatus, trackOpenPopout.hasCustomStatus) && C12238m.areEqual(this.guildId, trackOpenPopout.guildId) && C12238m.areEqual(this.emojiId, trackOpenPopout.emojiId) && C12238m.areEqual(this.stickerId, trackOpenPopout.stickerId) && C12238m.areEqual(this.stickerPackId, trackOpenPopout.stickerPackId) && C12238m.areEqual(this.profileHasNitroCustomization, trackOpenPopout.profileHasNitroCustomization) && C12238m.areEqual(this.hasNickname, trackOpenPopout.hasNickname) && C12238m.areEqual(this.hasGuildMemberAvatar, trackOpenPopout.hasGuildMemberAvatar) && C12238m.areEqual(this.hasGuildMemberBanner, trackOpenPopout.hasGuildMemberBanner) && C12238m.areEqual(this.hasGuildMemberBio, trackOpenPopout.hasGuildMemberBio);
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
        StringBuilder sbM833U = C1643a.m833U("TrackOpenPopout(source=");
        sbM833U.append(this.source);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(", otherUserId=");
        sbM833U.append(this.otherUserId);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", applicationName=");
        sbM833U.append(this.applicationName);
        sbM833U.append(", gameId=");
        sbM833U.append(this.gameId);
        sbM833U.append(", isFriend=");
        sbM833U.append(this.isFriend);
        sbM833U.append(", hasImages=");
        sbM833U.append(this.hasImages);
        sbM833U.append(", partyMax=");
        sbM833U.append(this.partyMax);
        sbM833U.append(", partyId=");
        sbM833U.append(this.partyId);
        sbM833U.append(", partyPlatform=");
        sbM833U.append(this.partyPlatform);
        sbM833U.append(", gameName=");
        sbM833U.append(this.gameName);
        sbM833U.append(", gamePlatform=");
        sbM833U.append(this.gamePlatform);
        sbM833U.append(", skuId=");
        sbM833U.append(this.skuId);
        sbM833U.append(", profileUserStatus=");
        sbM833U.append(this.profileUserStatus);
        sbM833U.append(", isStreaming=");
        sbM833U.append(this.isStreaming);
        sbM833U.append(", hasCustomStatus=");
        sbM833U.append(this.hasCustomStatus);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", emojiId=");
        sbM833U.append(this.emojiId);
        sbM833U.append(", stickerId=");
        sbM833U.append(this.stickerId);
        sbM833U.append(", stickerPackId=");
        sbM833U.append(this.stickerPackId);
        sbM833U.append(", profileHasNitroCustomization=");
        sbM833U.append(this.profileHasNitroCustomization);
        sbM833U.append(", hasNickname=");
        sbM833U.append(this.hasNickname);
        sbM833U.append(", hasGuildMemberAvatar=");
        sbM833U.append(this.hasGuildMemberAvatar);
        sbM833U.append(", hasGuildMemberBanner=");
        sbM833U.append(this.hasGuildMemberBanner);
        sbM833U.append(", hasGuildMemberBio=");
        return C1643a.m816D(sbM833U, this.hasGuildMemberBio, ")");
    }
}
