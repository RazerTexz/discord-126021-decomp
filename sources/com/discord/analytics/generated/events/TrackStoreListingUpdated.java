package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackStoreListingUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStoreListingUpdated implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.storeListingId, trackStoreListingUpdated.storeListingId) && C12238m.areEqual(this.skuId, trackStoreListingUpdated.skuId) && C12238m.areEqual(this.updateFrom, trackStoreListingUpdated.updateFrom) && C12238m.areEqual(this.updateType, trackStoreListingUpdated.updateType) && C12238m.areEqual(this.guildId, trackStoreListingUpdated.guildId) && C12238m.areEqual(this.childSkuIds, trackStoreListingUpdated.childSkuIds) && C12238m.areEqual(this.isPublished, trackStoreListingUpdated.isPublished) && C12238m.areEqual(this.tagline, trackStoreListingUpdated.tagline) && C12238m.areEqual(this.flavorText, trackStoreListingUpdated.flavorText) && C12238m.areEqual(this.thumbnailAssetId, trackStoreListingUpdated.thumbnailAssetId) && C12238m.areEqual(this.previewVideoAssetId, trackStoreListingUpdated.previewVideoAssetId) && C12238m.areEqual(this.carouselItems, trackStoreListingUpdated.carouselItems);
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
        StringBuilder sbM833U = C1643a.m833U("TrackStoreListingUpdated(storeListingId=");
        sbM833U.append(this.storeListingId);
        sbM833U.append(", skuId=");
        sbM833U.append(this.skuId);
        sbM833U.append(", updateFrom=");
        sbM833U.append(this.updateFrom);
        sbM833U.append(", updateType=");
        sbM833U.append(this.updateType);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", childSkuIds=");
        sbM833U.append(this.childSkuIds);
        sbM833U.append(", isPublished=");
        sbM833U.append(this.isPublished);
        sbM833U.append(", tagline=");
        sbM833U.append(this.tagline);
        sbM833U.append(", flavorText=");
        sbM833U.append(this.flavorText);
        sbM833U.append(", thumbnailAssetId=");
        sbM833U.append(this.thumbnailAssetId);
        sbM833U.append(", previewVideoAssetId=");
        sbM833U.append(this.previewVideoAssetId);
        sbM833U.append(", carouselItems=");
        return C1643a.m824L(sbM833U, this.carouselItems, ")");
    }
}
