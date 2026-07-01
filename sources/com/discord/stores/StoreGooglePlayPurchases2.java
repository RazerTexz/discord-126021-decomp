package com.discord.stores;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.stores.PendingDowngrade, reason: use source file name */
/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGooglePlayPurchases2 {
    private final String newSkuName;
    private final String purchaseToken;
    private final String subscriptionId;

    public StoreGooglePlayPurchases2(String str, String str2, String str3) {
        outline.q0(str, "purchaseToken", str2, "subscriptionId", str3, "newSkuName");
        this.purchaseToken = str;
        this.subscriptionId = str2;
        this.newSkuName = str3;
    }

    public static /* synthetic */ StoreGooglePlayPurchases2 copy$default(StoreGooglePlayPurchases2 storeGooglePlayPurchases2, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = storeGooglePlayPurchases2.purchaseToken;
        }
        if ((i & 2) != 0) {
            str2 = storeGooglePlayPurchases2.subscriptionId;
        }
        if ((i & 4) != 0) {
            str3 = storeGooglePlayPurchases2.newSkuName;
        }
        return storeGooglePlayPurchases2.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNewSkuName() {
        return this.newSkuName;
    }

    public final StoreGooglePlayPurchases2 copy(String purchaseToken, String subscriptionId, String newSkuName) {
        Intrinsics3.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics3.checkNotNullParameter(subscriptionId, "subscriptionId");
        Intrinsics3.checkNotNullParameter(newSkuName, "newSkuName");
        return new StoreGooglePlayPurchases2(purchaseToken, subscriptionId, newSkuName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreGooglePlayPurchases2)) {
            return false;
        }
        StoreGooglePlayPurchases2 storeGooglePlayPurchases2 = (StoreGooglePlayPurchases2) other;
        return Intrinsics3.areEqual(this.purchaseToken, storeGooglePlayPurchases2.purchaseToken) && Intrinsics3.areEqual(this.subscriptionId, storeGooglePlayPurchases2.subscriptionId) && Intrinsics3.areEqual(this.newSkuName, storeGooglePlayPurchases2.newSkuName);
    }

    public final String getNewSkuName() {
        return this.newSkuName;
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public int hashCode() {
        String str = this.purchaseToken;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subscriptionId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.newSkuName;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("PendingDowngrade(purchaseToken=");
        sbU.append(this.purchaseToken);
        sbU.append(", subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", newSkuName=");
        return outline.J(sbU, this.newSkuName, ")");
    }
}
