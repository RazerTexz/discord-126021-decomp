package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackStoreSkuMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStoreSkuMetadata {
    private final Long skuId = null;
    private final Long skuType = null;
    private final Long applicationId = null;
    private final CharSequence applicationName = null;
    private final CharSequence storeTitle = null;
    private final CharSequence distributionType = null;
    private final Long quantity = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStoreSkuMetadata)) {
            return false;
        }
        TrackStoreSkuMetadata trackStoreSkuMetadata = (TrackStoreSkuMetadata) other;
        return C12238m.areEqual(this.skuId, trackStoreSkuMetadata.skuId) && C12238m.areEqual(this.skuType, trackStoreSkuMetadata.skuType) && C12238m.areEqual(this.applicationId, trackStoreSkuMetadata.applicationId) && C12238m.areEqual(this.applicationName, trackStoreSkuMetadata.applicationName) && C12238m.areEqual(this.storeTitle, trackStoreSkuMetadata.storeTitle) && C12238m.areEqual(this.distributionType, trackStoreSkuMetadata.distributionType) && C12238m.areEqual(this.quantity, trackStoreSkuMetadata.quantity);
    }

    public int hashCode() {
        Long l = this.skuId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.skuType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.applicationId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.applicationName;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.storeTitle;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.distributionType;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l4 = this.quantity;
        return iHashCode6 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackStoreSkuMetadata(skuId=");
        sbM833U.append(this.skuId);
        sbM833U.append(", skuType=");
        sbM833U.append(this.skuType);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", applicationName=");
        sbM833U.append(this.applicationName);
        sbM833U.append(", storeTitle=");
        sbM833U.append(this.storeTitle);
        sbM833U.append(", distributionType=");
        sbM833U.append(this.distributionType);
        sbM833U.append(", quantity=");
        return C1643a.m819G(sbM833U, this.quantity, ")");
    }
}
