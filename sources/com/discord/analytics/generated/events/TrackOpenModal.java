package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackOpenModal.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOpenModal implements AnalyticsSchema, TrackBase2, TrackChannel2, TrackGuild2, TrackLocationMetadata2, TrackSourceMetadata2 {
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
        if (!(other instanceof TrackOpenModal)) {
            return false;
        }
        TrackOpenModal trackOpenModal = (TrackOpenModal) other;
        return Intrinsics3.areEqual(this.source, trackOpenModal.source) && Intrinsics3.areEqual(this.type, trackOpenModal.type) && Intrinsics3.areEqual(this.otherUserId, trackOpenModal.otherUserId) && Intrinsics3.areEqual(this.applicationId, trackOpenModal.applicationId) && Intrinsics3.areEqual(this.applicationName, trackOpenModal.applicationName) && Intrinsics3.areEqual(this.isFriend, trackOpenModal.isFriend) && Intrinsics3.areEqual(this.hasImages, trackOpenModal.hasImages) && Intrinsics3.areEqual(this.partyMax, trackOpenModal.partyMax) && Intrinsics3.areEqual(this.partyId, trackOpenModal.partyId) && Intrinsics3.areEqual(this.partyPlatform, trackOpenModal.partyPlatform) && Intrinsics3.areEqual(this.gameId, trackOpenModal.gameId) && Intrinsics3.areEqual(this.gameName, trackOpenModal.gameName) && Intrinsics3.areEqual(this.gamePlatform, trackOpenModal.gamePlatform) && Intrinsics3.areEqual(this.skuId, trackOpenModal.skuId) && Intrinsics3.areEqual(this.deviceName, trackOpenModal.deviceName) && Intrinsics3.areEqual(this.profileUserStatus, trackOpenModal.profileUserStatus) && Intrinsics3.areEqual(this.loadId, trackOpenModal.loadId) && Intrinsics3.areEqual(this.numGuildPermissions, trackOpenModal.numGuildPermissions) && Intrinsics3.areEqual(this.messageContentLength, trackOpenModal.messageContentLength) && Intrinsics3.areEqual(this.promotionId, trackOpenModal.promotionId) && Intrinsics3.areEqual(this.profileHasNitroCustomization, trackOpenModal.profileHasNitroCustomization) && Intrinsics3.areEqual(this.guildEventsCount, trackOpenModal.guildEventsCount) && Intrinsics3.areEqual(this.isAdminUser, trackOpenModal.isAdminUser);
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
        StringBuilder sbU = outline.U("TrackOpenModal(source=");
        sbU.append(this.source);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", otherUserId=");
        sbU.append(this.otherUserId);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", applicationName=");
        sbU.append(this.applicationName);
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
        sbU.append(", gameId=");
        sbU.append(this.gameId);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", gamePlatform=");
        sbU.append(this.gamePlatform);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", deviceName=");
        sbU.append(this.deviceName);
        sbU.append(", profileUserStatus=");
        sbU.append(this.profileUserStatus);
        sbU.append(", loadId=");
        sbU.append(this.loadId);
        sbU.append(", numGuildPermissions=");
        sbU.append(this.numGuildPermissions);
        sbU.append(", messageContentLength=");
        sbU.append(this.messageContentLength);
        sbU.append(", promotionId=");
        sbU.append(this.promotionId);
        sbU.append(", profileHasNitroCustomization=");
        sbU.append(this.profileHasNitroCustomization);
        sbU.append(", guildEventsCount=");
        sbU.append(this.guildEventsCount);
        sbU.append(", isAdminUser=");
        return outline.D(sbU, this.isAdminUser, ")");
    }
}
