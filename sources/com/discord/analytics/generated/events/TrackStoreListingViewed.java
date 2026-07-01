package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackPaymentMetadata;
import com.discord.analytics.generated.traits.TrackPaymentMetadata2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackStoreListingViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStoreListingViewed implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackSourceMetadata2, TrackStoreSkuMetadata2, TrackPaymentMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackPaymentMetadata trackPaymentMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final CharSequence loadId = null;
    private final Boolean hasDescription = null;
    private final Boolean hasStaffReview = null;
    private final Long carouselImageCount = null;
    private final Long carouselVideoCount = null;
    private final Boolean hasNews = null;
    private final Boolean hasSinglePlayer = null;
    private final Boolean hasOnlineMultiplayer = null;
    private final Boolean hasLocalMultiplayer = null;
    private final Boolean hasPvpFeatures = null;
    private final Boolean hasCoop = null;
    private final Boolean hasLocalCoop = null;
    private final Boolean hasOnlineCoop = null;
    private final Boolean hasCrossPlatform = null;
    private final Boolean hasRichPresence = null;
    private final Boolean hasGameInvites = null;
    private final Boolean hasSpectatorMode = null;
    private final Boolean hasControllerSupport = null;
    private final Boolean hasCloudSaves = null;
    private final Boolean hasSecureNetworking = null;
    private final Long promotionId = null;
    private final Long listIndex = null;
    private final Boolean listSearched = null;
    private final CharSequence listSort = null;
    private final CharSequence listFilterDistributionType = null;
    private final CharSequence source = null;
    private final transient String analyticsSchemaTypeName = "store_listing_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStoreListingViewed)) {
            return false;
        }
        TrackStoreListingViewed trackStoreListingViewed = (TrackStoreListingViewed) other;
        return Intrinsics3.areEqual(this.loadId, trackStoreListingViewed.loadId) && Intrinsics3.areEqual(this.hasDescription, trackStoreListingViewed.hasDescription) && Intrinsics3.areEqual(this.hasStaffReview, trackStoreListingViewed.hasStaffReview) && Intrinsics3.areEqual(this.carouselImageCount, trackStoreListingViewed.carouselImageCount) && Intrinsics3.areEqual(this.carouselVideoCount, trackStoreListingViewed.carouselVideoCount) && Intrinsics3.areEqual(this.hasNews, trackStoreListingViewed.hasNews) && Intrinsics3.areEqual(this.hasSinglePlayer, trackStoreListingViewed.hasSinglePlayer) && Intrinsics3.areEqual(this.hasOnlineMultiplayer, trackStoreListingViewed.hasOnlineMultiplayer) && Intrinsics3.areEqual(this.hasLocalMultiplayer, trackStoreListingViewed.hasLocalMultiplayer) && Intrinsics3.areEqual(this.hasPvpFeatures, trackStoreListingViewed.hasPvpFeatures) && Intrinsics3.areEqual(this.hasCoop, trackStoreListingViewed.hasCoop) && Intrinsics3.areEqual(this.hasLocalCoop, trackStoreListingViewed.hasLocalCoop) && Intrinsics3.areEqual(this.hasOnlineCoop, trackStoreListingViewed.hasOnlineCoop) && Intrinsics3.areEqual(this.hasCrossPlatform, trackStoreListingViewed.hasCrossPlatform) && Intrinsics3.areEqual(this.hasRichPresence, trackStoreListingViewed.hasRichPresence) && Intrinsics3.areEqual(this.hasGameInvites, trackStoreListingViewed.hasGameInvites) && Intrinsics3.areEqual(this.hasSpectatorMode, trackStoreListingViewed.hasSpectatorMode) && Intrinsics3.areEqual(this.hasControllerSupport, trackStoreListingViewed.hasControllerSupport) && Intrinsics3.areEqual(this.hasCloudSaves, trackStoreListingViewed.hasCloudSaves) && Intrinsics3.areEqual(this.hasSecureNetworking, trackStoreListingViewed.hasSecureNetworking) && Intrinsics3.areEqual(this.promotionId, trackStoreListingViewed.promotionId) && Intrinsics3.areEqual(this.listIndex, trackStoreListingViewed.listIndex) && Intrinsics3.areEqual(this.listSearched, trackStoreListingViewed.listSearched) && Intrinsics3.areEqual(this.listSort, trackStoreListingViewed.listSort) && Intrinsics3.areEqual(this.listFilterDistributionType, trackStoreListingViewed.listFilterDistributionType) && Intrinsics3.areEqual(this.source, trackStoreListingViewed.source);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.hasDescription;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasStaffReview;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.carouselImageCount;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.carouselVideoCount;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool3 = this.hasNews;
        int iHashCode6 = (iHashCode5 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.hasSinglePlayer;
        int iHashCode7 = (iHashCode6 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.hasOnlineMultiplayer;
        int iHashCode8 = (iHashCode7 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.hasLocalMultiplayer;
        int iHashCode9 = (iHashCode8 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Boolean bool7 = this.hasPvpFeatures;
        int iHashCode10 = (iHashCode9 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        Boolean bool8 = this.hasCoop;
        int iHashCode11 = (iHashCode10 + (bool8 != null ? bool8.hashCode() : 0)) * 31;
        Boolean bool9 = this.hasLocalCoop;
        int iHashCode12 = (iHashCode11 + (bool9 != null ? bool9.hashCode() : 0)) * 31;
        Boolean bool10 = this.hasOnlineCoop;
        int iHashCode13 = (iHashCode12 + (bool10 != null ? bool10.hashCode() : 0)) * 31;
        Boolean bool11 = this.hasCrossPlatform;
        int iHashCode14 = (iHashCode13 + (bool11 != null ? bool11.hashCode() : 0)) * 31;
        Boolean bool12 = this.hasRichPresence;
        int iHashCode15 = (iHashCode14 + (bool12 != null ? bool12.hashCode() : 0)) * 31;
        Boolean bool13 = this.hasGameInvites;
        int iHashCode16 = (iHashCode15 + (bool13 != null ? bool13.hashCode() : 0)) * 31;
        Boolean bool14 = this.hasSpectatorMode;
        int iHashCode17 = (iHashCode16 + (bool14 != null ? bool14.hashCode() : 0)) * 31;
        Boolean bool15 = this.hasControllerSupport;
        int iHashCode18 = (iHashCode17 + (bool15 != null ? bool15.hashCode() : 0)) * 31;
        Boolean bool16 = this.hasCloudSaves;
        int iHashCode19 = (iHashCode18 + (bool16 != null ? bool16.hashCode() : 0)) * 31;
        Boolean bool17 = this.hasSecureNetworking;
        int iHashCode20 = (iHashCode19 + (bool17 != null ? bool17.hashCode() : 0)) * 31;
        Long l3 = this.promotionId;
        int iHashCode21 = (iHashCode20 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.listIndex;
        int iHashCode22 = (iHashCode21 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool18 = this.listSearched;
        int iHashCode23 = (iHashCode22 + (bool18 != null ? bool18.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.listSort;
        int iHashCode24 = (iHashCode23 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.listFilterDistributionType;
        int iHashCode25 = (iHashCode24 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.source;
        return iHashCode25 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStoreListingViewed(loadId=");
        sbU.append(this.loadId);
        sbU.append(", hasDescription=");
        sbU.append(this.hasDescription);
        sbU.append(", hasStaffReview=");
        sbU.append(this.hasStaffReview);
        sbU.append(", carouselImageCount=");
        sbU.append(this.carouselImageCount);
        sbU.append(", carouselVideoCount=");
        sbU.append(this.carouselVideoCount);
        sbU.append(", hasNews=");
        sbU.append(this.hasNews);
        sbU.append(", hasSinglePlayer=");
        sbU.append(this.hasSinglePlayer);
        sbU.append(", hasOnlineMultiplayer=");
        sbU.append(this.hasOnlineMultiplayer);
        sbU.append(", hasLocalMultiplayer=");
        sbU.append(this.hasLocalMultiplayer);
        sbU.append(", hasPvpFeatures=");
        sbU.append(this.hasPvpFeatures);
        sbU.append(", hasCoop=");
        sbU.append(this.hasCoop);
        sbU.append(", hasLocalCoop=");
        sbU.append(this.hasLocalCoop);
        sbU.append(", hasOnlineCoop=");
        sbU.append(this.hasOnlineCoop);
        sbU.append(", hasCrossPlatform=");
        sbU.append(this.hasCrossPlatform);
        sbU.append(", hasRichPresence=");
        sbU.append(this.hasRichPresence);
        sbU.append(", hasGameInvites=");
        sbU.append(this.hasGameInvites);
        sbU.append(", hasSpectatorMode=");
        sbU.append(this.hasSpectatorMode);
        sbU.append(", hasControllerSupport=");
        sbU.append(this.hasControllerSupport);
        sbU.append(", hasCloudSaves=");
        sbU.append(this.hasCloudSaves);
        sbU.append(", hasSecureNetworking=");
        sbU.append(this.hasSecureNetworking);
        sbU.append(", promotionId=");
        sbU.append(this.promotionId);
        sbU.append(", listIndex=");
        sbU.append(this.listIndex);
        sbU.append(", listSearched=");
        sbU.append(this.listSearched);
        sbU.append(", listSort=");
        sbU.append(this.listSort);
        sbU.append(", listFilterDistributionType=");
        sbU.append(this.listFilterDistributionType);
        sbU.append(", source=");
        return outline.E(sbU, this.source, ")");
    }
}
