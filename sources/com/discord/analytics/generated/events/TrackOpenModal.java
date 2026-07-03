package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackOpenModal.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOpenModal implements AnalyticsSchema, TrackBaseReceiver, TrackChannelReceiver, TrackGuildReceiver, TrackLocationMetadataReceiver, TrackSourceMetadataReceiver {
    private final transient String analyticsSchemaTypeName;
    private final Long applicationId;
    private final CharSequence applicationName;
    private final CharSequence deviceName;
    private final Long gameId;
    private final CharSequence gameName;
    private final CharSequence gamePlatform;
    private final Long guildEventsCount;
    private final Boolean hasImages;
    private final Boolean isAdminUser;
    private final Boolean isFriend;
    private final CharSequence loadId;
    private final Long messageContentLength;
    private final Long numGuildPermissions;
    private final Long otherUserId;
    private final CharSequence partyId;
    private final Long partyMax;
    private final CharSequence partyPlatform;
    private final Boolean profileHasNitroCustomization;
    private final CharSequence profileUserStatus;
    private final CharSequence promotionId;
    private final Long skuId;
    private final CharSequence source;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private final CharSequence type;

    public TrackOpenModal() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607);
    }

    public TrackOpenModal(CharSequence charSequence, CharSequence charSequence2, Long l, Long l2, CharSequence charSequence3, Boolean bool, Boolean bool2, Long l3, CharSequence charSequence4, CharSequence charSequence5, Long l4, CharSequence charSequence6, CharSequence charSequence7, Long l5, CharSequence charSequence8, CharSequence charSequence9, CharSequence charSequence10, Long l6, Long l7, CharSequence charSequence11, Boolean bool3, Long l8, Boolean bool4, int i) {
        int i2 = i & 1;
        CharSequence charSequence12 = (i & 2) != 0 ? null : charSequence2;
        int i3 = i & 4;
        int i4 = i & 8;
        int i5 = i & 16;
        int i6 = i & 32;
        int i7 = i & 64;
        int i8 = i & 128;
        int i9 = i & 256;
        int i10 = i & 512;
        int i11 = i & 1024;
        int i12 = i & 2048;
        int i13 = i & 4096;
        int i14 = i & 8192;
        int i15 = i & 16384;
        int i16 = 32768 & i;
        int i17 = 65536 & i;
        int i18 = 131072 & i;
        int i19 = 262144 & i;
        int i20 = 524288 & i;
        int i21 = 1048576 & i;
        Long l9 = (2097152 & i) != 0 ? null : l8;
        int i22 = i & 4194304;
        this.source = null;
        this.type = charSequence12;
        this.otherUserId = null;
        this.applicationId = null;
        this.applicationName = null;
        this.isFriend = null;
        this.hasImages = null;
        this.partyMax = null;
        this.partyId = null;
        this.partyPlatform = null;
        this.gameId = null;
        this.gameName = null;
        this.gamePlatform = null;
        this.skuId = null;
        this.deviceName = null;
        this.profileUserStatus = null;
        this.loadId = null;
        this.numGuildPermissions = null;
        this.messageContentLength = null;
        this.promotionId = null;
        this.profileHasNitroCustomization = null;
        this.guildEventsCount = l9;
        this.isAdminUser = null;
        this.analyticsSchemaTypeName = "open_modal";
    }

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
        if (!(other instanceof TrackOpenModal)) {
            return false;
        }
        TrackOpenModal trackOpenModal = (TrackOpenModal) other;
        return C12238m.areEqual(this.source, trackOpenModal.source) && C12238m.areEqual(this.type, trackOpenModal.type) && C12238m.areEqual(this.otherUserId, trackOpenModal.otherUserId) && C12238m.areEqual(this.applicationId, trackOpenModal.applicationId) && C12238m.areEqual(this.applicationName, trackOpenModal.applicationName) && C12238m.areEqual(this.isFriend, trackOpenModal.isFriend) && C12238m.areEqual(this.hasImages, trackOpenModal.hasImages) && C12238m.areEqual(this.partyMax, trackOpenModal.partyMax) && C12238m.areEqual(this.partyId, trackOpenModal.partyId) && C12238m.areEqual(this.partyPlatform, trackOpenModal.partyPlatform) && C12238m.areEqual(this.gameId, trackOpenModal.gameId) && C12238m.areEqual(this.gameName, trackOpenModal.gameName) && C12238m.areEqual(this.gamePlatform, trackOpenModal.gamePlatform) && C12238m.areEqual(this.skuId, trackOpenModal.skuId) && C12238m.areEqual(this.deviceName, trackOpenModal.deviceName) && C12238m.areEqual(this.profileUserStatus, trackOpenModal.profileUserStatus) && C12238m.areEqual(this.loadId, trackOpenModal.loadId) && C12238m.areEqual(this.numGuildPermissions, trackOpenModal.numGuildPermissions) && C12238m.areEqual(this.messageContentLength, trackOpenModal.messageContentLength) && C12238m.areEqual(this.promotionId, trackOpenModal.promotionId) && C12238m.areEqual(this.profileHasNitroCustomization, trackOpenModal.profileHasNitroCustomization) && C12238m.areEqual(this.guildEventsCount, trackOpenModal.guildEventsCount) && C12238m.areEqual(this.isAdminUser, trackOpenModal.isAdminUser);
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
        Boolean bool = this.isFriend;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasImages;
        int iHashCode7 = (iHashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l3 = this.partyMax;
        int iHashCode8 = (iHashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.partyId;
        int iHashCode9 = (iHashCode8 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.partyPlatform;
        int iHashCode10 = (iHashCode9 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l4 = this.gameId;
        int iHashCode11 = (iHashCode10 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.gameName;
        int iHashCode12 = (iHashCode11 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.gamePlatform;
        int iHashCode13 = (iHashCode12 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        Long l5 = this.skuId;
        int iHashCode14 = (iHashCode13 + (l5 != null ? l5.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.deviceName;
        int iHashCode15 = (iHashCode14 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.profileUserStatus;
        int iHashCode16 = (iHashCode15 + (charSequence9 != null ? charSequence9.hashCode() : 0)) * 31;
        CharSequence charSequence10 = this.loadId;
        int iHashCode17 = (iHashCode16 + (charSequence10 != null ? charSequence10.hashCode() : 0)) * 31;
        Long l6 = this.numGuildPermissions;
        int iHashCode18 = (iHashCode17 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.messageContentLength;
        int iHashCode19 = (iHashCode18 + (l7 != null ? l7.hashCode() : 0)) * 31;
        CharSequence charSequence11 = this.promotionId;
        int iHashCode20 = (iHashCode19 + (charSequence11 != null ? charSequence11.hashCode() : 0)) * 31;
        Boolean bool3 = this.profileHasNitroCustomization;
        int iHashCode21 = (iHashCode20 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l8 = this.guildEventsCount;
        int iHashCode22 = (iHashCode21 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Boolean bool4 = this.isAdminUser;
        return iHashCode22 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackOpenModal(source=");
        sbM833U.append(this.source);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(", otherUserId=");
        sbM833U.append(this.otherUserId);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", applicationName=");
        sbM833U.append(this.applicationName);
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
        sbM833U.append(", gameId=");
        sbM833U.append(this.gameId);
        sbM833U.append(", gameName=");
        sbM833U.append(this.gameName);
        sbM833U.append(", gamePlatform=");
        sbM833U.append(this.gamePlatform);
        sbM833U.append(", skuId=");
        sbM833U.append(this.skuId);
        sbM833U.append(", deviceName=");
        sbM833U.append(this.deviceName);
        sbM833U.append(", profileUserStatus=");
        sbM833U.append(this.profileUserStatus);
        sbM833U.append(", loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", numGuildPermissions=");
        sbM833U.append(this.numGuildPermissions);
        sbM833U.append(", messageContentLength=");
        sbM833U.append(this.messageContentLength);
        sbM833U.append(", promotionId=");
        sbM833U.append(this.promotionId);
        sbM833U.append(", profileHasNitroCustomization=");
        sbM833U.append(this.profileHasNitroCustomization);
        sbM833U.append(", guildEventsCount=");
        sbM833U.append(this.guildEventsCount);
        sbM833U.append(", isAdminUser=");
        return C1643a.m816D(sbM833U, this.isAdminUser, ")");
    }
}
