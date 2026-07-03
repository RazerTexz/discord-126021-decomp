package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackPriceMetadata;
import com.discord.analytics.generated.traits.TrackPriceMetadataReceiver;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackPromotionViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPromotionViewed implements AnalyticsSchema, TrackBaseReceiver, TrackStoreSkuMetadataReceiver, TrackLocationMetadataReceiver, TrackPriceMetadataReceiver {
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
        return C12238m.areEqual(this.loadId, trackPromotionViewed.loadId) && C12238m.areEqual(this.promotionId, trackPromotionViewed.promotionId) && C12238m.areEqual(this.promotionType, trackPromotionViewed.promotionType) && C12238m.areEqual(this.promotionUrl, trackPromotionViewed.promotionUrl) && C12238m.areEqual(this.listIndex, trackPromotionViewed.listIndex);
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
        StringBuilder sbM833U = C1643a.m833U("TrackPromotionViewed(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", promotionId=");
        sbM833U.append(this.promotionId);
        sbM833U.append(", promotionType=");
        sbM833U.append(this.promotionType);
        sbM833U.append(", promotionUrl=");
        sbM833U.append(this.promotionUrl);
        sbM833U.append(", listIndex=");
        return C1643a.m819G(sbM833U, this.listIndex, ")");
    }
}
