package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackStoreListingUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStoreListingUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long storeListingId = null;
    private final Long skuId = null;
    private final CharSequence updateFrom = null;
    private final CharSequence updateType = null;
    private final Long guildId = null;
    private final List<Long> childSkuIds = null;
    private final Boolean isPublished = null;
    private final CharSequence tagline = null;
    private final CharSequence flavorText = null;
    private final Long thumbnailAssetId = null;
    private final Long previewVideoAssetId = null;
    private final List<CharSequence> carouselItems = null;
    private final transient String analyticsSchemaTypeName = "store_listing_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStoreListingUpdated)) {
            return false;
        }
        TrackStoreListingUpdated trackStoreListingUpdated = (TrackStoreListingUpdated) other;
        return Intrinsics3.areEqual(this.storeListingId, trackStoreListingUpdated.storeListingId) && Intrinsics3.areEqual(this.skuId, trackStoreListingUpdated.skuId) && Intrinsics3.areEqual(this.updateFrom, trackStoreListingUpdated.updateFrom) && Intrinsics3.areEqual(this.updateType, trackStoreListingUpdated.updateType) && Intrinsics3.areEqual(this.guildId, trackStoreListingUpdated.guildId) && Intrinsics3.areEqual(this.childSkuIds, trackStoreListingUpdated.childSkuIds) && Intrinsics3.areEqual(this.isPublished, trackStoreListingUpdated.isPublished) && Intrinsics3.areEqual(this.tagline, trackStoreListingUpdated.tagline) && Intrinsics3.areEqual(this.flavorText, trackStoreListingUpdated.flavorText) && Intrinsics3.areEqual(this.thumbnailAssetId, trackStoreListingUpdated.thumbnailAssetId) && Intrinsics3.areEqual(this.previewVideoAssetId, trackStoreListingUpdated.previewVideoAssetId) && Intrinsics3.areEqual(this.carouselItems, trackStoreListingUpdated.carouselItems);
    }

    public int hashCode() {
        Long l = this.storeListingId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.skuId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.updateFrom;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.updateType;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Long> list = this.childSkuIds;
        int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool = this.isPublished;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.tagline;
        int iHashCode8 = (iHashCode7 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.flavorText;
        int iHashCode9 = (iHashCode8 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l4 = this.thumbnailAssetId;
        int iHashCode10 = (iHashCode9 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.previewVideoAssetId;
        int iHashCode11 = (iHashCode10 + (l5 != null ? l5.hashCode() : 0)) * 31;
        List<CharSequence> list2 = this.carouselItems;
        return iHashCode11 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStoreListingUpdated(storeListingId=");
        sbU.append(this.storeListingId);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", updateFrom=");
        sbU.append(this.updateFrom);
        sbU.append(", updateType=");
        sbU.append(this.updateType);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", childSkuIds=");
        sbU.append(this.childSkuIds);
        sbU.append(", isPublished=");
        sbU.append(this.isPublished);
        sbU.append(", tagline=");
        sbU.append(this.tagline);
        sbU.append(", flavorText=");
        sbU.append(this.flavorText);
        sbU.append(", thumbnailAssetId=");
        sbU.append(this.thumbnailAssetId);
        sbU.append(", previewVideoAssetId=");
        sbU.append(this.previewVideoAssetId);
        sbU.append(", carouselItems=");
        return outline.L(sbU, this.carouselItems, ")");
    }
}
