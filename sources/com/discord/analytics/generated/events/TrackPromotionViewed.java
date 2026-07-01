package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackPriceMetadata;
import com.discord.analytics.generated.traits.TrackPriceMetadata2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackPromotionViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPromotionViewed implements AnalyticsSchema, TrackBase2, TrackStoreSkuMetadata2, TrackLocationMetadata2, TrackPriceMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackPriceMetadata trackPriceMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final CharSequence loadId = null;
    private final CharSequence promotionId = null;
    private final CharSequence promotionType = null;
    private final CharSequence promotionUrl = null;
    private final Long listIndex = null;
    private final transient String analyticsSchemaTypeName = "promotion_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPromotionViewed)) {
            return false;
        }
        TrackPromotionViewed trackPromotionViewed = (TrackPromotionViewed) other;
        return Intrinsics3.areEqual(this.loadId, trackPromotionViewed.loadId) && Intrinsics3.areEqual(this.promotionId, trackPromotionViewed.promotionId) && Intrinsics3.areEqual(this.promotionType, trackPromotionViewed.promotionType) && Intrinsics3.areEqual(this.promotionUrl, trackPromotionViewed.promotionUrl) && Intrinsics3.areEqual(this.listIndex, trackPromotionViewed.listIndex);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.promotionId;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.promotionType;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.promotionUrl;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l = this.listIndex;
        return iHashCode4 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPromotionViewed(loadId=");
        sbU.append(this.loadId);
        sbU.append(", promotionId=");
        sbU.append(this.promotionId);
        sbU.append(", promotionType=");
        sbU.append(this.promotionType);
        sbU.append(", promotionUrl=");
        sbU.append(this.promotionUrl);
        sbU.append(", listIndex=");
        return outline.G(sbU, this.listIndex, ")");
    }
}
