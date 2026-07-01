package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Payment;
import com.discord.utilities.analytics.Traits$StoreSku;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGooglePlayPurchases$AnalyticsTrait {
    private final Traits$Location locationTrait;
    private final Traits$Payment paymentTrait;
    private final long skuId;
    private final Traits$StoreSku storeSkuTrait;
    private final long timestamp;

    public StoreGooglePlayPurchases$AnalyticsTrait(long j, long j2, Traits$Location traits$Location, Traits$StoreSku traits$StoreSku, Traits$Payment traits$Payment) {
        m.checkNotNullParameter(traits$Location, "locationTrait");
        m.checkNotNullParameter(traits$StoreSku, "storeSkuTrait");
        m.checkNotNullParameter(traits$Payment, "paymentTrait");
        this.skuId = j;
        this.timestamp = j2;
        this.locationTrait = traits$Location;
        this.storeSkuTrait = traits$StoreSku;
        this.paymentTrait = traits$Payment;
    }

    public static /* synthetic */ StoreGooglePlayPurchases$AnalyticsTrait copy$default(StoreGooglePlayPurchases$AnalyticsTrait storeGooglePlayPurchases$AnalyticsTrait, long j, long j2, Traits$Location traits$Location, Traits$StoreSku traits$StoreSku, Traits$Payment traits$Payment, int i, Object obj) {
        return storeGooglePlayPurchases$AnalyticsTrait.copy((i & 1) != 0 ? storeGooglePlayPurchases$AnalyticsTrait.skuId : j, (i & 2) != 0 ? storeGooglePlayPurchases$AnalyticsTrait.timestamp : j2, (i & 4) != 0 ? storeGooglePlayPurchases$AnalyticsTrait.locationTrait : traits$Location, (i & 8) != 0 ? storeGooglePlayPurchases$AnalyticsTrait.storeSkuTrait : traits$StoreSku, (i & 16) != 0 ? storeGooglePlayPurchases$AnalyticsTrait.paymentTrait : traits$Payment);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getSkuId() {
        return this.skuId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Traits$Location getLocationTrait() {
        return this.locationTrait;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Traits$StoreSku getStoreSkuTrait() {
        return this.storeSkuTrait;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Traits$Payment getPaymentTrait() {
        return this.paymentTrait;
    }

    public final StoreGooglePlayPurchases$AnalyticsTrait copy(long skuId, long timestamp, Traits$Location locationTrait, Traits$StoreSku storeSkuTrait, Traits$Payment paymentTrait) {
        m.checkNotNullParameter(locationTrait, "locationTrait");
        m.checkNotNullParameter(storeSkuTrait, "storeSkuTrait");
        m.checkNotNullParameter(paymentTrait, "paymentTrait");
        return new StoreGooglePlayPurchases$AnalyticsTrait(skuId, timestamp, locationTrait, storeSkuTrait, paymentTrait);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreGooglePlayPurchases$AnalyticsTrait)) {
            return false;
        }
        StoreGooglePlayPurchases$AnalyticsTrait storeGooglePlayPurchases$AnalyticsTrait = (StoreGooglePlayPurchases$AnalyticsTrait) other;
        return this.skuId == storeGooglePlayPurchases$AnalyticsTrait.skuId && this.timestamp == storeGooglePlayPurchases$AnalyticsTrait.timestamp && m.areEqual(this.locationTrait, storeGooglePlayPurchases$AnalyticsTrait.locationTrait) && m.areEqual(this.storeSkuTrait, storeGooglePlayPurchases$AnalyticsTrait.storeSkuTrait) && m.areEqual(this.paymentTrait, storeGooglePlayPurchases$AnalyticsTrait.paymentTrait);
    }

    public final Traits$Location getLocationTrait() {
        return this.locationTrait;
    }

    public final Traits$Payment getPaymentTrait() {
        return this.paymentTrait;
    }

    public final long getSkuId() {
        return this.skuId;
    }

    public final Traits$StoreSku getStoreSkuTrait() {
        return this.storeSkuTrait;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int iA = (b.a(this.timestamp) + (b.a(this.skuId) * 31)) * 31;
        Traits$Location traits$Location = this.locationTrait;
        int iHashCode = (iA + (traits$Location != null ? traits$Location.hashCode() : 0)) * 31;
        Traits$StoreSku traits$StoreSku = this.storeSkuTrait;
        int iHashCode2 = (iHashCode + (traits$StoreSku != null ? traits$StoreSku.hashCode() : 0)) * 31;
        Traits$Payment traits$Payment = this.paymentTrait;
        return iHashCode2 + (traits$Payment != null ? traits$Payment.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("AnalyticsTrait(skuId=");
        sbU.append(this.skuId);
        sbU.append(", timestamp=");
        sbU.append(this.timestamp);
        sbU.append(", locationTrait=");
        sbU.append(this.locationTrait);
        sbU.append(", storeSkuTrait=");
        sbU.append(this.storeSkuTrait);
        sbU.append(", paymentTrait=");
        sbU.append(this.paymentTrait);
        sbU.append(")");
        return sbU.toString();
    }
}
